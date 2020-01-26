package corporate.course.spring.module.ioc;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corporate.course.spring.module.ioc.model.inventory.Spell;
import corporate.course.spring.module.ioc.model.person.Magician;

public class IocRun
{
    public static void main(String[] args) throws InterruptedException
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springctx/ioc/ioc.xml");
        ConfigurableBeanFactory configurableBeanFactory =
                (ConfigurableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        System.out.println("\nRegistered scopes are: " +
                Arrays.toString(configurableBeanFactory.getRegisteredScopeNames()));
        System.out.println();

        Magician magician = (Magician) applicationContext.getBean("magician");

        Spell spell = (Spell) applicationContext.getBean("magicianSpell");
        magician.addSpell(spell);
        magician.hit();
        System.out.println();

        Spell temporarySpell1 = (Spell) applicationContext.getBean("magicianSpellTemporary1");
        magician.addSpell(temporarySpell1);
        magician.hit();
        System.out.println();

        Thread.sleep(5000);

        Spell temporarySpell2 = (Spell) applicationContext.getBean("magicianSpellTemporary2");
        magician.addSpell(temporarySpell2);
        magician.hit();
    }
}
