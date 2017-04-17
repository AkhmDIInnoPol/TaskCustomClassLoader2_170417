package classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Di on 17.04.2017.
 */
public class JarClassLoader extends ClassLoader
{



    private String jarFile = "D:/Innopolis/work/Lesson_170417/tmp2/book2.jar"; //Path to the jar file
    private Hashtable classes = new Hashtable(); //used to cache already defined classes

    public JarClassLoader() {
        super(JarClassLoader.class.getClassLoader()); //calls the parent class loader's constructor
    }

    public Class loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    public Class findClass(String className) {
        byte classByte[];
        Class result = null;

        result = (Class) classes.get(className); //checks in cached classes
        if (result != null) {
            return result;
        }

        try {
            return findSystemClass(className);
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            JarFile jar = new JarFile(jarFile);

            JarEntry entry = jar.getJarEntry("library/models/Book2.class");

//            JarEntry entry = jar.getJarEntry(className + ".class");
            InputStream is = jar.getInputStream(entry);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = is.read();
            while (-1 != nextValue) {
                byteStream.write(nextValue);
                nextValue = is.read();
            }

            classByte = byteStream.toByteArray();
            result = defineClass(className, classByte, 0, classByte.length, null);
            classes.put(className, result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }


}
