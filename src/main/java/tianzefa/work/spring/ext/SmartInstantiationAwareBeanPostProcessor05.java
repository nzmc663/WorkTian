package tianzefa.work.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import tianzefa.work.spring.JavaRestController;

import java.lang.reflect.Constructor;

@Component
public class SmartInstantiationAwareBeanPostProcessor05 implements SmartInstantiationAwareBeanPostProcessor {

    private static boolean printfed;

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        // predictBeanType：该触发点发生在postProcessBeforeInstantiation之前(因为一般不太需要扩展这个点)
        // 这个方法用于预测Bean的类型，返回第一个预测成功的Class类型，如果不能预测返回null；
        // 当你调用BeanFactory.getType(name)时当通过bean的名字无法得到bean类型信息时就调用该回调方法来决定类型信息。
        if (JavaRestController.class == beanClass){
            if (!printfed){
                System.out.println("SmartInstantiationAwareBeanPostProcessor predictBeanType 扩展接口第五-01");
                printfed = true;
            }
            return beanClass;
        }
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        // determineCandidateConstructors：该触发点发生在postProcessBeforeInstantiation之后，
        // 用于确定该bean的构造函数之用，返回的是该bean的所有构造函数列表。
        // 用户可以扩展这个点，来自定义选择相应的构造器来实例化这个bean。
        if (JavaRestController.class == beanClass){
            System.out.println("SmartInstantiationAwareBeanPostProcessor determineCandidateConstructors 扩展接口第五-02");
            return beanClass.getConstructors();
        }
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        // getEarlyBeanReference：该触发点发生在postProcessAfterInstantiation之后，
        // 当有循环依赖的场景，当bean实例化好之后，为了防止有循环依赖，会提前暴露回调方法，用于bean实例化的后置处理。
        // 这个方法就是在提前暴露的回调方法中触发。
        if (bean instanceof JavaRestController){
            System.out.println("SmartInstantiationAwareBeanPostProcessor getEarlyBeanReference 扩展接口第五-03");
            return bean;
        }
        return bean;
    }
}
