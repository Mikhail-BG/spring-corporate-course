package corporate.course.spring.module.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corporate.course.spring.module.ioc.model.person.Magician;

public class IocRun
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springctx/ioc/ioc.xml");

        Magician magician = (Magician) applicationContext.getBean("magician");
        magician.hit();
    }
}
