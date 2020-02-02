package corporate.course.spring.module.annotation.model.inventory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import corporate.course.spring.module.annotation.model.TimeLimitedStuff;

@Component //3 set annotation Component to identify bean
@Primary //4 set annotation Primary to identify default bean
public class Sword extends TimeLimitedStuff
{
    private int damageLevel;

    public Sword()
    {
        this(99);
    }

    public Sword(int damageLevel)
    {
        this.damageLevel = damageLevel;
        counter++;
        generateId();
        System.out.println(this.getClass().getSimpleName() + " with id = " + this.getId() + " created");
    }

    public void setDamageLevel(int damageLevel)
    {
        this.damageLevel = damageLevel;
    }

    public int doDamage()
    {
        return damageLevel;
    }

    @Override
    public String toString()
    {
        return "Sword{" +
                "id=" + getId() +
                '}';
    }
}
