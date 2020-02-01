package corporate.course.spring.module.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corporate.course.spring.module.annotation.model.inventory.Sword;
import corporate.course.spring.module.annotation.model.person.Paladin;

public class AnnotationRun
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "springctx/annotation/annotation.xml");

        Paladin paladin = applicationContext.getBean(Paladin.class);

        Sword sword = applicationContext.getBean(Sword.class);
        paladin.addSword(sword);
        paladin.hit();
        System.out.println();

        Sword bigSword = (Sword) applicationContext.getBean("bigSword");
        paladin.addSword(bigSword);
        paladin.hit();
        System.out.println();
    }
}
