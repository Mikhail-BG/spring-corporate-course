package corporate.course.spring.module.annotation.model;

import java.util.Timer;
import java.util.TimerTask;

import corporate.course.spring.module.annotation.model.inventory.Sword;

public abstract class TimeLimitedStuff
{
    protected static int counter = 0;
    private String id;
    private long timeToLiveMsec;
    private Timer timer;

    public long getTimeToLiveMsec()
    {
        return timeToLiveMsec;
    }

    public void setTimeToLiveMsec(long timeToLiveMsec)
    {
        this.timeToLiveMsec = timeToLiveMsec;
    }

    public void generateId()
    {
        this.id = this.getClass().getSimpleName() + " " + counter;
    }

    public String getId()
    {
        return id;
    }

    public void destroyByTimer(TimeLimitedStuff stuff)
    {
        if (timeToLiveMsec != 0)
        {
            timer = new Timer();
            timer.schedule(new DestroyTask(stuff), stuff.getTimeToLiveMsec());
        }
    }

    private class DestroyTask extends TimerTask
    {
        private TimeLimitedStuff stuff;

        public DestroyTask(TimeLimitedStuff stuff)
        {
            this.stuff = stuff;
        }

        @Override
        public void run()
        {
            System.out.println("Time for stuff '" + stuff.getId() + "' is off!");
            //Possible to change fields but not to destroy
            ((Sword) stuff).setDamageLevel(0);
            stuff = null;
            timer.cancel();
        }
    }
}
