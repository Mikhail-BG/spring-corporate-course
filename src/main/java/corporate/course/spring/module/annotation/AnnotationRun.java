package corporate.course.spring.module.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import corporate.course.spring.module.annotation.model.inventory.Sword;
import corporate.course.spring.module.annotation.model.person.Paladin;

public class AnnotationRun
{
    public static void main(String[] args)
    {
        //2 set annotation ApplicationContext
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("corporate.course.spring.module.annotation");

        Paladin paladin = applicationContext.getBean(Paladin.class);

        Sword sword = applicationContext.getBean(Sword.class); //5 create default bean by class
        paladin.addSword(sword);
        paladin.hit();
        System.out.println();

        Sword bigSword = applicationContext.getBean("bigSword", Sword.class); //8 create configured bean by name
        paladin.addSword(bigSword);
        paladin.hit();
        System.out.println();
    }
}
