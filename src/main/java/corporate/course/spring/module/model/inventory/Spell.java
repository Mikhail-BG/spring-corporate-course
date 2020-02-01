package corporate.course.spring.module.model.inventory;

public class Spell implements Inventory
{
    private static int counter = 0;
    private int damageLevel;
    private String id;

    public Spell(int damageLevel)
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

    @Override
    public String getId()
    {
        return id;
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
