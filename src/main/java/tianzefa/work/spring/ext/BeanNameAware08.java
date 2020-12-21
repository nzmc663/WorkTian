package tianzefa.work.spring.ext;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import tianzefa.work.spring.JavaRestController;

/**
 * 可以看到，这个类也是Aware扩展的一种，触发点在bean的初始化之前，
 * 也就是postProcessBeforeInitialization之前，这个类的触发点方法只有一个：setBeanName
 *
 * 使用场景为：用户可以扩展这个点，在初始化bean之前拿到spring容器中注册的的beanName，来自行修改这个beanName的值。
 */
@Component
public class BeanNameAware08 implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware 扩展接口第八");
    }

}
