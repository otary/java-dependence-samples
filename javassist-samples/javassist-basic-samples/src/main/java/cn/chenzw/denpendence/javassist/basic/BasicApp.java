package cn.chenzw.denpendence.javassist.basic;

import javassist.*;

import java.io.IOException;

public class BasicApp {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        // 创建类
        CtClass ctClass = classPool.makeClass("cn.chenzw.test.TestApp");


        // 无参构造器
        CtConstructor constructor = new CtConstructor(null, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{}");
        ctClass.addConstructor(constructor);
        // 参数构造器
        constructor = new CtConstructor(new CtClass[]{classPool.get(String.class.getName())}, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{this.value=$1;}");
        ctClass.addConstructor(constructor);

        // 创建方法
        CtMethod ctMethod = CtNewMethod.make("public void run(){}", ctClass);
        ctMethod.insertBefore("System.out.println(\"hello world.....\");");
        ctClass.addMethod(ctMethod);

        // 创建字段
        CtField ctField = new CtField(classPool.get(String.class.getName()), "userName", ctClass);
        ctField.setModifiers(Modifier.PUBLIC);
        ctClass.addMethod(CtNewMethod.setter("setUserName", ctField));
        ctClass.addMethod(CtNewMethod.getter("getUserName", ctField));
        ctClass.addField(ctField);

        // 生成Class对象
        Class<?> aClass = ctClass.toClass();

        // 写入文件
        ctClass.writeFile("test");
    }
}
