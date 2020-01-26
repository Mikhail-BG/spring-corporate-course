package corporate.course.spring.module.ioc.model.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import corporate.course.spring.module.ioc.model.inventory.Inventory;
import corporate.course.spring.module.ioc.model.inventory.Spell;

public class Magician extends Hero
{
    private Map<String, Inventory> spellMap = new HashMap<>();

    public Magician()
    {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void addSpell(Inventory spell)
    {
        spellMap.put(spell.getId(), spell);
    }

    public void hit()
    {
        spellMap.keySet().forEach(key ->
        {
            Spell currentSpell = (Spell) spellMap.get(key);
            if (Objects.nonNull(currentSpell))
            System.out.println("Magician hit with damage: " + currentSpell.doDamage()
                    + " by inventory: " + key);
        });
    }
}
