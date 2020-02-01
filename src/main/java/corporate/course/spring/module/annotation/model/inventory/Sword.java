package corporate.course.spring.module.annotation.model.inventory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //3 set annotation Component to identify bean
@Primary //4 set annotation Primary to identify default bean
public class Sword
{
    private static int counter = 0;
    private int damageLevel;
    private String id;

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

    public void generateId()
    {
        this.id = this.getClass().getSimpleName() + " " + counter;
    }

    public String getId()
    {
        return id;
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
