package com.company;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the class path");
        filePath = sc.nextLine();
        try{
            File f = new File(filePath);
            //File f = new File("D:\\Proiecte_java\\java\\lab5\\out\\production\\lab5");
            URL[] cp = {f.toURI().toURL()};
            URLClassLoader urlcl = new URLClassLoader(cp);
            Class cls = urlcl.loadClass("com.company.Catalog");


            ClassLoader cLoader = cls.getClassLoader();

            System.out.println(cls.getName());
            System.out.println("Metodele din clasa catalog");
            for (Method m: cls.getMethods()
                 ) {
                System.out.println(m.getName());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
