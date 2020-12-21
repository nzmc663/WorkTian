package tianzefa.work.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * org.springframework.context.support.ApplicationContextAwareProcessor
 * 该类本身并没有扩展点，但是该类内部却有6个扩展点可供实现 ，这些类触发的时机在bean实例化之后，初始化之前。
 *
 *  可以看到，该类用于执行各种驱动接口，在bean实例化之后，属性填充之后，通过扩展接口，来获取对应容器的变量。所以这里应该来说是有6个扩展点，这里就放一起来说了
 */

@Configuration
public class ApplicationContextAwareProcessor07   {

    @Component
    class ApplicationContextAware07 implements ApplicationContextAware{
        // ApplicationContextAware：用来获取ApplicationContext的一个扩展类，
        // ApplicationContext应该是很多人非常熟悉的一个类了，就是spring上下文管理器，
        // 可以手动的获取任何在spring上下文注册的bean，我们经常扩展这个接口来缓存spring上下文，
        // 包装成静态方法。同时ApplicationContext也实现了BeanFactory，MessageSource，
        // ApplicationEventPublisher等接口，也可以用来做相关接口的事情。
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println("ApplicationContextAware setApplicationContext 扩展接口第七-06");
        }
    }

    @Component
    class MessageSourceAware07 implements MessageSourceAware{
        // MessageSourceAware：用于获取MessageSource的一个扩展类，MessageSource主要用来做国际化。
        @Override
        public void setMessageSource(MessageSource messageSource) {
            System.out.println("MessageSourceAware setMessageSource 扩展接口第七-05");
        }
    }

    @Component
    class ApplicationEventPublisherAware07 implements ApplicationEventPublisherAware {
        //  ApplicationEventPublisherAware：用于获取ApplicationEventPublisher的一个扩展类，ApplicationEventPublisher可以用来发布事件，
        //  结合ApplicationListener来共同使用，下文在介绍ApplicationListener时会详细提到。
        //  这个对象也可以通过spring注入的方式来获得。
        @Override
        public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            System.out.println("ApplicationEventPublisherAware setApplicationEventPublisher 扩展接口第七-04");
        }
    }

    @Component
    class ResourceLoaderAware07 implements ResourceLoaderAware {
        //  ResourceLoaderAware：用于获取ResourceLoader的一个扩展类，
        //  ResourceLoader可以用于获取classpath内所有的资源对象，可以扩展此类来拿到ResourceLoader对象。
        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            System.out.println("ResourceLoaderAware setResourceLoader 扩展接口第七-03");
        }
    }

    @Component
    class EmbeddedValueResolverAware07 implements EmbeddedValueResolverAware {
        //  EmbeddedValueResolverAware：用于获取StringValueResolver的一个扩展类，
        //  StringValueResolver用于获取基于String类型的properties的变量，一般我们都用@Value的方式去获取，
        //  如果实现了这个Aware接口，把StringValueResolver缓存起来，通过这个类去获取String类型的变量，效果是一样的。
        @Override
        public void setEmbeddedValueResolver(StringValueResolver resolver) {
            System.out.println("EmbeddedValueResolverAware setEmbeddedValueResolver 扩展接口第七-02");
        }
    }

    @Component
    class EnvironmentAware07 implements EnvironmentAware {
        //  EnvironmentAware：用于获取EnviromentAware的一个扩展类，这个变量非常有用， 可以获得系统内的所有参数。
        //  当然个人认为这个Aware没必要去扩展，因为spring内部都可以通过注入的方式来直接获得。
        @Override
        public void setEnvironment(Environment environment) {
            System.out.println("EnvironmentAware setEnvironment 扩展接口第七-01");
        }
    }

}
