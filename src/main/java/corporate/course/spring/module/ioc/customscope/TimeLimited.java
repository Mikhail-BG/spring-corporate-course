package corporate.course.spring.module.ioc.customscope;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import corporate.course.spring.module.ioc.model.inventory.Inventory;

public class TimeLimited implements Scope
{
    private final ThreadLocal<Map<String, Inventory>> threadScope =
            new NamedThreadLocal<>("Time Limited Scope")
            {
                @Override
                protected Map<String, Inventory> initialValue()
                {
                    return new HashMap<>();
                }
            };

    private long timeLimit;

    public void setTimeLimit(long timeLimit)
    {
        this.timeLimit = timeLimit;
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory)
    {
        Map<String, Inventory> scope = this.threadScope.get();
        Object scopedObject = scope.get(name);
        if (scopedObject == null)
        {
            scopedObject = objectFactory.getObject();
            scope.put(name, (Inventory) scopedObject);
        }

        runTimer(scope);

        return scopedObject;
    }

    @Override
    public Object remove(String name)
    {
        Map<String, Inventory> scope = this.threadScope.get();
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

    private void runTimer(Map<String, Inventory> scope)
    {
        System.out.println("Current thread: " + Thread.currentThread());
        Thread thread = new Thread(new TimerTask()
        {
            @Override
            public void run()
            {
                Timer timer = new Timer();
                try
                {
                    timer.wait(timeLimit);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        try
        {
            thread.start();
            System.out.println("Current thread: " + Thread.currentThread());
            thread.join();
            System.out.println("Current thread: " + Thread.currentThread());
            System.out.println("Timer is up!");
            scope.keySet().forEach(name ->
            {
                System.out.println("Instance : " + scope.get(name).toString() + " destroyed");
                scope.put(name, null);
            });
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
