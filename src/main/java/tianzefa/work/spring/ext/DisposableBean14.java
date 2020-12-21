package tianzefa.work.spring.ext;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;
/**
 * 这个扩展点也只有一个方法：destroy()，其触发时机为当此对象销毁时，会自动执行这个方法。
 * 比如说运行applicationContext.registerShutdownHook时，就会触发这个方法。
 */
@Component
public class DisposableBean14 implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 扩展接口第十四");
    }
}
