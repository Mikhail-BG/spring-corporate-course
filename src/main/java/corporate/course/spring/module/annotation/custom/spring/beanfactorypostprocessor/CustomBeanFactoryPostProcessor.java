package corporate.course.spring.module.annotation.custom.spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import corporate.course.spring.module.annotation.configuration.ConfiguredSword;
import corporate.course.spring.module.annotation.custom.spring.scope.TimeLimitedStuffScope;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException
    {
        configurableListableBeanFactory
                .registerScope(TimeLimitedStuffScope.TIME_LIMITED_STUFF_SCOPE, new TimeLimitedStuffScope());
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name : beanNames)
        {
            if (name.equals(ConfiguredSword.RANDOM_SWORD_BEAN_NAME))
            {
                BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
                beanDefinition.setScope(TimeLimitedStuffScope.TIME_LIMITED_STUFF_SCOPE);
            }
        }
    }
}
