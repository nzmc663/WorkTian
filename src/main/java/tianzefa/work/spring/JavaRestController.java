package tianzefa.work.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class JavaRestController {

    @Autowired
    private JavaBean javaBean;

    @Autowired
    private JavaInterface javaInterface;

    @GetMapping("/echo")
    public String echo(String name){

        try {
            return "echo is " + name + ",javabean name is " + javaBean.getName() + ", javainterface is " + javaInterface.getObject().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public JavaBean getJavaBean(){
        return javaBean;
    }
}
