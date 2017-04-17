package stc5.libr;

import classloader.JarClassLoader;
import library.models.Book;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
	// write your code here


        String className = "library.models.Book2";

        JarClassLoader jarClassLoader = new JarClassLoader();
        Class book2Class = null;
        Object object = null;
        try {
             book2Class = jarClassLoader.loadClass(className);
            Object book2Obj = book2Class.newInstance();

            Book book = new Book();
            Class bookClass = book.getClass();
            Method m = bookClass.getDeclaredMethod("setTitle", String.class);
            m.invoke(book, "ReadBook");
            Method m2 = bookClass.getDeclaredMethod("getTitle");
            String title = (String) m2.invoke(book);
            System.out.println("Book class message: " + title);


            Method m3 = book2Class.getDeclaredMethod("setPagesNum", Integer.class);
            m3.invoke(book2Obj,1990);
            Method m4 = book2Class.getDeclaredMethod("getPagesNum");
            Integer value = (Integer) m4.invoke(book2Obj);
            System.out.println("Book2 class mean: " + value);


        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (NoSuchMethodException ex)
        {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        catch (InstantiationException ex)
        {
            ex.printStackTrace();
        }
//        catch (NoSuchFieldException ex)
//        {
//            ex.printStackTrace();
//        }
        catch (InvocationTargetException ex)
        {
            ex.printStackTrace();
        }













    }
}
