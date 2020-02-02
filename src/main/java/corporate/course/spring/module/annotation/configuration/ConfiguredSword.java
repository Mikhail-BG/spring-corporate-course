package corporate.course.spring.module.annotation.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import corporate.course.spring.module.annotation.model.inventory.Sword;

@Configuration //6 annotation Configuration allows to configure bean as in XML
public class ConfiguredSword
{
    public static final String RANDOM_SWORD_BEAN_NAME = "randomSword";

    @Bean(name = "bigSword") //7 set name for configured bean
    public Sword bigSword()
    {
        return new Sword(400);
    }

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(name = RANDOM_SWORD_BEAN_NAME)
    public Sword randomSword()
    {
        return new Sword(1);
    }
}
