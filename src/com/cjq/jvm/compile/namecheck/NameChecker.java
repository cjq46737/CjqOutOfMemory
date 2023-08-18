/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.namecheck
 * @className com.cjq.jvm.compile.namecheck.NameChecker
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.namecheck;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * NameChecker
 * @description 命名规范注解插件
 * @author chenjunqi
 * @date 2023年08月18日 上午8:49
 * @version 3.0.0
 */
public class NameChecker {

    private final Messager messager;

    private NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        // 检查类命名
        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }

        // 检查方法命名
        @Override
        public Void visitExecutable(ExecutableElement e, Void p) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName()))
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法 “" + name + "”不应当与类名重复，避免与构造函数产生混淆", e);
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, p);
            return null;
        }

        // 检查变量命名
        @Override
        public Void visitVariable(VariableElement e, Void p) {
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || isConstants(e)) {
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }
            return null;
        }

        // 判断是否是常量
        private boolean isConstants(VariableElement variableElement) {
            if (variableElement.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            } else if (variableElement.getKind() == ElementKind.FIELD && variableElement.getModifiers()
                    .containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL))) {
                return true;
            } else {
                return false;
            }
        }

        // 判断是否符合驼峰命名
        private void checkCamelCase(Element e, boolean flag) {
            String name = e.getSimpleName().toString();
            char firstChar = name.charAt(0);
            if (flag) {
                // 类 element，第一个字母必须大写
                if (!Character.isUpperCase(firstChar)) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "类：" + name + "应该以大写字母开头");
                    return;
                }
            } else {
                // 方法、属性 element，第一个字母必须小写
                if (!Character.isLowerCase(firstChar)) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "属性、方法：" + name + "应该以小些字母开头");
                    return;
                }
            }
            boolean preCharUpper = false;
            for (int i = 1; i < name.length(); i++) {
                if (Character.isUpperCase(name.charAt(i))) {
                    if (preCharUpper) {
                        messager.printMessage(Diagnostic.Kind.WARNING, "名称：" + name + "应该符合驼峰命名规范");
                        return;
                    }
                    preCharUpper = true;
                }
            }
        }

        // 检查是否所有都是大写
        private void checkAllCaps(Element e) {
            String name = e.getSimpleName().toString();
            boolean pass = true;
            if (!Character.isUpperCase(name.charAt(0))) {
                pass = false;
            } else {
                for (int i = 1; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (Character.isUpperCase(c) || Character.isDigit(c) || c == '_') {
                        continue;
                    }
                    pass = false;
                }
            }

            if (!pass) {
                messager.printMessage(Diagnostic.Kind.WARNING, "常量：" + name + "应该以大写字母和下划线命名，并以字母开头");
            }

        }
    }
}
