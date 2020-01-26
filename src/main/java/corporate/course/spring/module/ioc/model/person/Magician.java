package corporate.course.spring.module.ioc.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import corporate.course.spring.module.ioc.model.inventory.Inventory;

public class Magician extends Hero
{
    private List<Inventory> spells = new ArrayList<>();

    public Magician()
    {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void addSpell(Inventory spell)
    {
        spells.add(spell);
    }

    public void hit()
    {
        for (Inventory spell : spells)
            if (Objects.nonNull(spell))
            {
                System.out.println("Magician hit with damage: " + spell.doDamage() + " by inventory: "
                        + spell.getId());
            }
            else
            {
                System.out.println("Empty spell");
            }
    }
}
