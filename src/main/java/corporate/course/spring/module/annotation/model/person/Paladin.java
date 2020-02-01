package corporate.course.spring.module.annotation.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import corporate.course.spring.module.annotation.model.inventory.Sword;

public class Paladin
{
    private List<Sword> swords = new ArrayList<>();

    public Paladin()
    {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void addSword(Sword spell)
    {
        swords.add(spell);
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
