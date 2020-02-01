package corporate.course.spring.module.annotation.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import corporate.course.spring.module.annotation.model.inventory.Sword;

@Component //3 set annotation Component to identify bean
@Primary //4 set annotation Primary to identify default bean
public class Paladin
{
    private List<Sword> swords = new ArrayList<>();

    public Paladin()
    {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void addSword(Sword sword)
    {
        swords.add(sword);
    }

    public void hit()
    {
        for (Sword sword : swords)
            if (Objects.nonNull(sword))
            {
                System.out.println("Paladin hit with damage: " + sword.doDamage() + " by sword: "
                        + sword.getId());
            }
            else
            {
                System.out.println("Empty sword");
            }
    }
}
