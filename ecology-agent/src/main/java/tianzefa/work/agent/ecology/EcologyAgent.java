package tianzefa.work.agent.ecology;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @author tzf 2020/11/12
 */
public class EcologyAgent {

    public static void agentmain(String agentArgs, Instrumentation instrumentation) throws Exception  {

        final String lnClassName = "ln.LN";
        final String  lCLClssName = "weaver.login.LicenseCheckLogin";
        Class<?>[] classes = instrumentation.getAllLoadedClasses();
        for (Class<?> cls : classes){
//            if (cls.getName().equals(lnClassName)){
//                byte[] bytes = lnClasses(lnClassName);
//                if (bytes!=null){
//                    instrumentation.redefineClasses(new ClassDefinition(cls,bytes));
//                    System.out.println("------->"+cls.getName());
//                }
//            }else if (cls.getName().equals(lCLClssName)){
//                byte[] bytes = lclClass(lCLClssName);
//                if (bytes!=null){
//                    instrumentation.redefineClasses(new ClassDefinition(cls,bytes));
//                    System.out.println("------->"+cls.getName());
//                }
//            } else
                if (cls.getName().equals(testClassName)){
                byte[] bytes = testClass(testClassName);
                if (bytes!=null){
                    instrumentation.redefineClasses(new ClassDefinition(cls,bytes));
                    System.out.println("------->"+cls.getName());
                }
            }
        }

        System.out.println("----------------------------"+Thread.currentThread().getName()+"-时间戳"+System.currentTimeMillis()+"------------------------------");
    }

    private static byte[] lnClasses(final String lnClassName){
        ClassPool cp = ClassPool.getDefault();
        try {
            CtClass ctClass = cp.getCtClass(lnClassName);
            CtMethod checkLicense = ctClass.getDeclaredMethod("checkLicense");
            checkLicense.setBody("return true;");
            CtMethod CkLicense = ctClass.getDeclaredMethod("CkLicense");
            CkLicense.setBody("System.out.println(11111111); return String.valueOf(1);");

            CtMethod getScCount = ctClass.getDeclaredMethod("getScCount");
            getScCount.setBody("return String.valueOf(999999);");
            //CkUsedHrmnum
            CtMethod CkUsedHrmnum = ctClass.getDeclaredMethod("CkUsedHrmnum");
            CkUsedHrmnum.setBody("return 1;");
            //CkUnusedHrmnum
            CtMethod CkUnusedHrmnum = ctClass.getDeclaredMethod("CkUnusedHrmnum");
            CkUnusedHrmnum.setBody("return 999998;");
            //CkHrmnum
            CtMethod CkHrmnum = ctClass.getDeclaredMethod("CkHrmnum");
            CkHrmnum.setBody("return 999999;");
            System.out.println("-------------------------------------------------------->>>>\n");
            return ctClass.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] lclClass(final String lCLClssName){
        ClassPool cp = ClassPool.getDefault();
        try {
            CtClass ctClass = cp.getCtClass(lCLClssName);
            CtMethod checkLicense = ctClass.getDeclaredMethod("getLicUserCheck");
            checkLicense.setBody("return false;");
            System.out.println("-------------------------------------------------------->>>>\n");
            return ctClass.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] testClass(final String testClssName){
        ClassPool cp = ClassPool.getDefault();
        try {
            CtClass ctClass = cp.getCtClass(testClssName);
            CtMethod checkLicense = ctClass.getDeclaredMethod("getTestNumber");
            checkLicense.setBody("return 3;");
            System.out.println("-------------------------------------------------------->>>>\n");
            return ctClass.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
