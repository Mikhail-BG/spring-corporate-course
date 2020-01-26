package corporate.course.spring.module.ioc.model.inventory;

public class Spell
{
    private int damageLevel;

    public Spell(int damageLevel)
    {
        this.damageLevel = damageLevel;
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public int doDamage()
    {
        return damageLevel;
    }
}
