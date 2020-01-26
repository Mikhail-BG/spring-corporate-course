package corporate.course.spring.module.ioc.model.person;

import corporate.course.spring.module.ioc.model.inventory.Spell;

public class Magician extends Hero
{
    private Spell spell;

    public Magician(Spell spell)
    {
        this.spell = spell;
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    @Override
    public boolean isAlive()
    {
        return true;
    }

    public void hit()
    {
        System.out.println("Magician hit with damage: " + spell.doDamage());
    }
}
