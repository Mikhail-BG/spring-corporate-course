package corporate.course.spring.module.ioc.model.inventory;

public class Spell implements Inventory
{
    private static int counter = 0;
    private int damageLevel;

    public Spell(int damageLevel)
    {
        this.damageLevel = damageLevel;
        counter++;
        System.out.println(this.getClass().getSimpleName() + " with id = " + this.getId() + " created");
    }

    @Override
    public String getId()
    {
        return this.getClass().getSimpleName() + " " + counter;
    }

    @Override
    public int doDamage()
    {
        return damageLevel;
    }

    @Override
    public String toString()
    {
        return "Spell{" +
                "id=" + getId() +
                '}';
    }
}
