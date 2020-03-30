package cn.chenzw.dependence.javassist.basic;

import javassist.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * 创建类
 */
@RunWith(JUnit4.class)
public class MakeClassTests {


    /**
     * <code>
     *  public class TestApp {
     *     public String userName;
     *
     *     public void setUserName(String var1) {
     *         this.userName = var1;
     *     }
     *
     *     public String getUserName() {
     *         return this.userName;
     *     }
     *
     *     public TestApp() {
     *     }
     *
     *     public TestApp(String var1) {
     *         this.userName = var1;
     *     }
     *
     *     public void run() {
     *         System.out.println("hello world.....");
     *     }
     *  }
     * </code>
     */
    @Test
    public void testMakeClass() throws CannotCompileException, IOException, NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        // 创建类
        CtClass ctClass = classPool.makeClass("cn.chenzw.test.TestApp");

        // 创建字段
        /**
         * <code>
         *     public String userName;
         *     public String getUserName(){
         *         return userName;
         *     }
         *     public void setUserName(String userName) {
         *         this.userName = userName;
         *     }
         * </code>
         */
        CtField ctField = new CtField(classPool.get(String.class.getName()), "userName", ctClass);
        ctField.setModifiers(Modifier.PUBLIC);
        ctClass.addMethod(CtNewMethod.setter("setUserName", ctField));
        ctClass.addMethod(CtNewMethod.getter("getUserName", ctField));
        ctClass.addField(ctField);

        // 无参构造器
        /**
         * <code>
         *     public TestApp() {}
         * </code>
         */
        CtConstructor constructor = new CtConstructor(null, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{}");
        ctClass.addConstructor(constructor);


        // 参数构造器
        /**
         * <code>
         *     public TestApp(String xx) { this.value = xx;}
         * </code>
         */
        constructor = new CtConstructor(new CtClass[]{classPool.get(String.class.getName())}, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{this.userName=$1;}");
        ctClass.addConstructor(constructor);

        // 创建方法
        /**
         * <code>
         *     public void run (){ System.out.println("hello world..."); }
         * </code>
         */
        CtMethod ctMethod = CtNewMethod.make("public void run(){}", ctClass);
        ctMethod.insertBefore("System.out.println(\"hello world.....\");");
        ctClass.addMethod(ctMethod);

        // 生成Class对象(必须)
        Class<?> aClass = ctClass.toClass();

        // 写入到目录中
        ctClass.writeFile("test");
    }
}
