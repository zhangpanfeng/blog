package com.darren.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileFilterTest {

    public static void main(String[] args) {
        File srcDir = new File("D:/java");
        if (!srcDir.exists() || !srcDir.isDirectory()) {
            srcDir.mkdir();
        }

        /**
         * 长见识了，之前不知道还有FIleFilter和FileNameFilter来过滤文件，一般遇到这种问题都是自己在读文件时去判断文件的后缀
         */

        /**
         * 这也就是Java的策略模式，只要实现不同的filter接口的不同逻辑，就可以得到不同的结果，只不过， 我这里是匿名实现的FileFilter和FileNameFilter接口
         */

        // FileFilter fileFilter = new FileFilter() {
        //
        // @Override
        // /**
        // *
        // * @param pathname 当前读到的文件
        // * @return
        // */
        // public boolean accept(File pathname) {
        // return pathname.getName().endsWith(".java");
        // }
        // };
        //
        // File[] files = srcDir.listFiles(fileFilter);

        FilenameFilter fileNameFilter = new FilenameFilter() {

            @Override
            /**
             * @param dir - 被找到的文件所在的目录
             * @param name - 文件的名称
             * @return 
             */
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        };

        File[] files = srcDir.listFiles(fileNameFilter);

        File targetDir = new File("D:/jad");
        if (!targetDir.exists() || !targetDir.isDirectory()) {
            targetDir.mkdir();
        }

        for (File file : files) {
            try {
                FileInputStream fin = new FileInputStream(file);
                String targetFileName = file.getName().replaceAll("\\.java$", ".jad");
                File targetFile = new File(targetDir, targetFileName);
                FileOutputStream fout = new FileOutputStream(targetFile);

                copy(fin, fout);
                try {
                    fin.close();
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private static void copy(FileInputStream fin, FileOutputStream fout) {
        int length = 0;
        byte[] buff = new byte[1024];
        try {
            while ((length = fin.read(buff)) != -1) {
                fout.write(buff, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
