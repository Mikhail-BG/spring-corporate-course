package corporate.course.spring.module.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import corporate.course.spring.module.annotation.configuration.ConfiguredSword;
import corporate.course.spring.module.annotation.model.inventory.Sword;
import corporate.course.spring.module.annotation.model.person.Paladin;

public class AnnotationRun
{
    public static void main(String[] args) throws InterruptedException
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

        Sword randomSword1 = applicationContext.getBean(ConfiguredSword.RANDOM_SWORD_BEAN_NAME, Sword.class);
        paladin.addSword(randomSword1);
        Sword randomSword2 = applicationContext.getBean(ConfiguredSword.RANDOM_SWORD_BEAN_NAME, Sword.class);
        paladin.addSword(randomSword2);
        Sword randomSword3 = applicationContext.getBean(ConfiguredSword.RANDOM_SWORD_BEAN_NAME, Sword.class);
        paladin.addSword(randomSword3);
        paladin.hit();
        System.out.println();

        //Wait till beans are dead
        Thread.sleep(3000);

        paladin.hit();
        System.out.println();
    }
}
