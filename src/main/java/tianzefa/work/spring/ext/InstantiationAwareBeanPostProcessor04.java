package tianzefa.work.spring.ext;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import tianzefa.work.spring.JavaBean;
import tianzefa.work.spring.JavaRestController;

import java.beans.PropertyDescriptor;

/**
 * 该接口继承了BeanPostProcess接口，区别如下：
 * BeanPostProcess接口只在bean的初始化阶段进行扩展（注入spring上下文前后），
 * 而InstantiationAwareBeanPostProcessor接口在此基础上增加了4个方法，把可扩展的范围增加了实例化阶段和属性注入阶段。
 *
 * 该类主要的扩展点有以下5个方法，主要在bean生命周期的两大阶段：实例化阶段和初始化阶段，下面一起进行说明，按调用顺序为：

 * 使用场景：这个扩展点非常有用 ，无论是写中间件和业务中，都能利用这个特性。比如对实现了某一类接口的bean在各个生命期间进行收集，或者对某个类型的bean进行统一的设值等等。
 */
@Component
public class InstantiationAwareBeanPostProcessor04 implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        //  postProcessBeforeInstantiation：实例化bean之前，相当于new这个bean之前
        if (JavaRestController.class == beanClass){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessBeforeInstantiation 扩展接口第四-01");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // postProcessAfterInstantiation：实例化bean之后，相当于new这个bean之后
        if (bean instanceof JavaRestController){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessAfterInstantiation 扩展接口第四-02 "+((JavaRestController)bean).getJavaBean());
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // postProcessProperties：bean已经实例化完成，在属性注入时阶段触发
        if (bean instanceof JavaRestController){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessProperties 扩展接口第四-03");
        }
        return pvs;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // postProcessBeforeInitialization：初始化bean之前，相当于把bean注入spring上下文之前
        if (bean instanceof JavaRestController){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessProperties 扩展接口第四-04 "+((JavaRestController)bean).getJavaBean());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // postProcessAfterInitialization：初始化bean之后，相当于把bean注入spring上下文之后
        if (bean instanceof JavaRestController){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessProperties 扩展接口第四-05 "+((JavaRestController)bean).getJavaBean());
        }
        return bean;
    }


    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        // postProcessPropertyValues：bean已经实例化完成，在属性注入时阶段触发，@Autowired,@Resource等注解原理基于此方法实现
        if (bean instanceof JavaRestController){
            System.out.println("InstantiationAwareBeanPostProcessor postProcessProperties 扩展接口第四-06");
        }
        return pvs;
    }


}
