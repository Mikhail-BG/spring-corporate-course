package corporate.course.spring.module.annotation.model.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //6 annotation Configuration allows to configure bean as in XML
public class ConfiguredSword
{
    @Bean(name = "bigSword") //7 set name for configured bean
    public Sword bigSword()
    {
        return new Sword(400);
    }
}
