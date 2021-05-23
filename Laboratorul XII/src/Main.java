import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


    public static void main(String[] args) {
        System.out.println("all good!");
        MyClassloader classloader = new MyClassloader();
        Class reflection = null;

        try {
            File path = new File("E:\\FII\\Semestrul IV\\Programare avansata\\Laboratorul XII\\out\\production\\Compulsory");
            URL url = path.toURI().toURL();
            classloader.addURL(url);
            reflection = classloader.loadClass("example.MyProgram");
            /// name + package + modifier
            int classModifier = reflection.getModifiers();
            String classPackage = reflection.getPackageName();
            String className = reflection.getName();
            System.out.println("Public ->" + Modifier.isPublic(classModifier));
            System.out.println("Private ->" + Modifier.isPrivate(classModifier));
            System.out.println("Protected ->" + Modifier.isProtected(classModifier));
            System.out.println("package ->" + classPackage);
            System.out.println("name ->" + className);

            /// methods of the class
            Method[] classMethod = reflection.getMethods();
            System.out.println("display methods");
            for (Method method : classMethod) {

                System.out.println("name of the method: " + method.getName());
                System.out.println("return type of the method: " + method.getReturnType());
            }

            // call static method
            int passed = 0;
            int failed = 0;
            for (Method method : classMethod) {
                if (method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers())) {
                    try {
                        method.invoke(null);
                        passed++;

                    } catch (Throwable ex) {
                        failed++;
                        System.out.println("Test failed..");
                    }

                }
            }
            System.out.println("Passed: " + passed + ", Failed : " + failed);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }


    }

}
