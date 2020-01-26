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

        System.out.println("Registered scopes are: " +
                Arrays.toString(configurableBeanFactory.getRegisteredScopeNames()));

        Magician magician = (Magician) applicationContext.getBean("magician");

        Spell spell = (Spell) applicationContext.getBean("magicianSpell");
        magician.addSpell(spell);
        magician.hit();

        Spell temporarySpell = (Spell) applicationContext.getBean("magicianSpellTemporary");
        magician.addSpell(temporarySpell);
        magician.hit();

        Thread.sleep(2000);

        magician.hit();
    }
}
