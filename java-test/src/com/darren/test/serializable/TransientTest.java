package com.darren.test.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {

    public static void main(String[] args) {
        // 现在我们创建一个这个类的实例，并且串行化(serialize)它 ,然后将这个串行化对象写如磁盘。
        Transient t = new Transient("Darren", "123456");
        String path = "transient.txt";
        System.out.println("写之前：");
        System.out.println(t.toString());
        write(t, path);

        Transient rt = read(path);
        System.out.println("写之后：");
        System.out.println(rt.toString());
        // 运行结果：

        // 写之前：
        // User:[userName = Darren, password = 123456, description = I'm Darren!]
        // 写之后：
        // User:[userName = Darren, password = NOT SET PASSWORD!, description = NOT SET DESCRIPTION!]

        // 如果我们运行这段代码，我们会注意到从磁盘中读回(read——back)的对象打印password为"NOT SET PASSWORD!"。
        // 这是当我们定义password域为transient时，所期望的正确结果。

        // 问题：为什么description的值有默认这也不行呢？

        // 我们仍然看到读回的对象打印description 为"NOT SET DESCRIPTION！"。
        // 当从磁盘中读出某个类的实例时，实际上并不会执行这个类的构造函数，而是载入了一个该类对象的持久化状态，并将这个状态赋值给该类的另一个对象。
    }

    private static Transient read(String path) {
        Transient t = null;
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream(path);
            in = new ObjectInputStream(fileIn);

            Object object = in.readObject();
            t = (Transient) object;
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    private static void write(Transient t, String path) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(path);
            out = new ObjectOutputStream(fileOut);

            out.writeObject(t);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
