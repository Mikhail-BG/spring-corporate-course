package corporate.course.spring.module.annotation.model.inventory;

public class Sword
{
    private static int counter = 0;
    private int damageLevel;
    private String id;

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
