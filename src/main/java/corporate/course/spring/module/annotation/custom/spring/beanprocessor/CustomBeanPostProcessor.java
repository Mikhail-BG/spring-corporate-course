package corporate.course.spring.module.annotation.custom.spring.beanprocessor;

import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import corporate.course.spring.module.annotation.configuration.ConfiguredSword;
import corporate.course.spring.module.annotation.model.inventory.Sword;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor
{
    private Random random = new Random();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Called postProcessBeforeInitialization() for : " + beanName);

        if (beanName.equals(ConfiguredSword.RANDOM_SWORD_BEAN_NAME))
        {
            boolean trigger = random.nextBoolean();
            System.out.println("Sword power will be increased : " + trigger);
            if (trigger)
            {
                ((Sword) bean).setDamageLevel(100 + random.nextInt(1000));
                ((Sword) bean).setTimeToLiveMsec(1000 + random.nextInt(1000));
                System.out.println("Sword power increased for :" + beanName);
            }
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("Called postProcessAfterInitialization() for : " + beanName);
        return bean;
    }
}
