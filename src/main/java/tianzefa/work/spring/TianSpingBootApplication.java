package tianzefa.work.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tianzefa.work.spring.ext.ApplicationContextInitializer01;

@SpringBootApplication
public class TianSpingBootApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TianSpingBootApplication.class);

        // ApplicationContextInitializer01 生效方式之一
        // context.initializer.classes = tianzefa.work.spring.ext.ApplicationContextInitializer01 方式二
        // spring.factories  org.springframework.context.ApplicationContextInitializer=tianzefa.work.spring.ext.ApplicationContextInitializer01 方式三
        application.addInitializers(new ApplicationContextInitializer01());

        ConfigurableApplicationContext context = application.run(args);
        context.registerShutdownHook();

    }

    @Bean
    public JavaBean javaBean(){
        JavaBean bean = new JavaBean();
        bean.setName("this is test,zhangsan");
        return bean;
    }

}
