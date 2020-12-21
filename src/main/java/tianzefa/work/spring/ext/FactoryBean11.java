package tianzefa.work.spring.ext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import tianzefa.work.spring.JavaBean;
import tianzefa.work.spring.JavaInterface;

import java.lang.reflect.Proxy;

/**
 * 一般情况下，Spring通过反射机制利用bean的class属性指定支线类去实例化bean，
 * 在某些情况下，实例化Bean过程比较复杂，如果按照传统的方式，则需要在bean中提供大量的配置信息。
 * 配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。
 * Spring为此提供了一个org.springframework.bean.factory.FactoryBean的工厂类接口，
 * 用户可以通过实现该接口定制实例化Bean的逻辑。
 * FactoryBean接口对于Spring框架来说占用重要的地位，Spring自身就提供了70多个FactoryBean的实现。
 * 它们隐藏了实例化一些复杂bean的细节，给上层应用带来了便利。
 * 从Spring3.0开始，FactoryBean开始支持泛型，即接口声明改为FactoryBean<T>的形式
 *
 * 使用场景：用户可以扩展这个类，来为要实例化的bean作一个代理，比如为该对象的所有的方法作一个拦截，
 * 在调用前后输出一行log，模仿ProxyFactoryBean的功能。扩展：SpringBoot内容聚合
 */
@Component
public class FactoryBean11 implements FactoryBean<JavaInterface> {

    private static boolean printfed;

    @Override
    public Class<?> getObjectType() {
        if (!printfed){
            System.out.println("FactoryBean getObjectType 扩展接口第十一-01");
            printfed = true;
        }
        return JavaInterface.class;
    }

    @Override
    public boolean isSingleton() {
        System.out.println("FactoryBean isSingleton 扩展接口第十一-02");
        return true;
    }

    @Override
    public JavaInterface getObject() throws Exception {
        System.out.println("FactoryBean getObject 扩展接口第十一-03");
//        return (JavaInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(),JavaInterface.class.getInterfaces(),(object,method,params)->{
//            System.out.println("动态代理被调用执行，object is " + object + ",method is " + method + ",params is " + params);
//            if (method.getName().equals("getObject")){
//                JavaBean bean = new JavaBean();
//                bean.setName("this is dynamic class");
//                return bean;
//            }
//            return method.invoke(object,params);
//        });


        return () -> {
                JavaBean bean = new JavaBean();
                bean.setName("this is dynamic class");
                return bean;
            };
    }




}
