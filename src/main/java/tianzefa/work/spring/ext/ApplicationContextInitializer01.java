package tianzefa.work.spring.ext;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
/**
 这是整个spring容器在刷新之前初始化ConfigurableApplicationContext的回调接口，
 简单来说，就是在容器刷新之前调用此类的initialize方法。
 这个点允许被用户自己扩展。用户可以在整个spring容器还没被初始化之前做一些事情。
 可以想到的场景可能为，在最开始激活一些配置，或者利用这时候class还没被类加载器加载的时机，进行动态字节码注入等操作。
 */
public class ApplicationContextInitializer01 implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // 容器初始化事件，在refresh之前调用，可以通过此时通过字节码技术进行扩展
        System.out.println("ApplicationContextInitializer扩展接口第一");
    }

}
