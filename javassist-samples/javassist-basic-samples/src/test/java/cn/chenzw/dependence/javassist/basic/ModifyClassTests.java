package cn.chenzw.dependence.javassist.basic;

import javassist.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * 类动态修改
 */
@RunWith(JUnit4.class)
public class ModifyClassTests {

    /**
     * 动态添加方法
     */
    @Test
    public void testAddMethod() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();

        // 添加类搜索路径
        // pool.insertClassPath(new ClassClassPath(this.getClass()));

        // 获取类
        CtClass ctClass = pool.get("cn.chenzw.dependence.javassist.basic.domain.entity.User");

        // 动态添加方法
        /**
         * <code>
         *      public int add(int var1, int var2) {
         *         int var4 = var1 + var2;
         *
         *         for(int var5 = 0; var5 < (new Object[]{new Integer(var1), new Integer(var2)}).length; ++var5) {
         *             System.out.println("args[" + var5 + "]=" + (new Object[]{new Integer(var1), new Integer(var2)})[var5]);
         *         }
         *
         *         return var4;
         *     }
         * </code>
         */
        CtMethod ctMethod = new CtMethod(CtClass.intType, "add", new CtClass[]{
                CtClass.intType, CtClass.intType}, ctClass);
        ctMethod.setBody("return $1 + $2;");
        ctMethod.insertAfter("for(int i=0;i<$args.length;i++)"
                + "{System.out.println(\"args[\"+i+\"]=\"+$args[i]);}");
        ctClass.addMethod(ctMethod);

        // 生成Class对象(必须)
        ctClass.toClass();

        // 写入到目录中
        ctClass.writeFile("test");


    }
}
