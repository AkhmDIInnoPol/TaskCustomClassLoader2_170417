package stc5.libr;

import classloader.JarClassLoader;

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
            Object ticketInstance = book2Class.newInstance();
            Field f = book2Class.getDeclaredField("title");
            f.setAccessible(true);
            f.set(ticketInstance, "John");
            String name = (String) f.get(ticketInstance);

             System.out.println(name);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
//        catch (NoSuchMethodException ex)
//        {
//            ex.printStackTrace();
//        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        catch (InstantiationException ex)
        {
            ex.printStackTrace();
        }
        catch (NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
//        catch (InvocationTargetException ex)
//        {
//            ex.printStackTrace();
//        }













    }
}
