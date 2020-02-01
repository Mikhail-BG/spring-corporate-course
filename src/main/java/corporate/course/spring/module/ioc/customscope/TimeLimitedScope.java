package corporate.course.spring.module.ioc.customscope;

import java.util.*;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TimeLimitedScope implements Scope
{
    private Map<String, Object> scope = new HashMap<>();
    private long timeLimitMsec;
    private Timer timer;

    public void setTimeLimit(long timeLimit)
    {
        this.timeLimitMsec = timeLimit * 1000;
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory)
    {
        if (Objects.isNull(scope))
        {
            System.out.println("Scope was destroyed");
            return null;
        }

        Object scopedObject;

        if (Objects.isNull(scope.get(name)))
        {
            scopedObject = objectFactory.getObject();
            scope.put(name, scopedObject);
        }
        else
        {
            scopedObject = scope.get(name);
        }

        runTimerAndDestroyScope();

        return scopedObject;
    }

    @Override
    public Object remove(String name)
    {
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable)
    {

    }

    @Override
    public Object resolveContextualObject(String s)
    {
        return null;
    }

    @Override
    public String getConversationId()
    {
        return null;
    }

    private void runTimerAndDestroyScope()
    {
        timer = new Timer();
        timer.schedule(new DestroyTask(), timeLimitMsec);
        System.out.println("Time for scope " + this.getClass().getSimpleName() + " is off!");
    }

    private class DestroyTask extends TimerTask
    {
        @Override
        public void run()
        {
            for (String name : scope.keySet())
            {
                scope.remove(name);
            }
            timer.cancel();
            scope = null;
        }
    }
}
