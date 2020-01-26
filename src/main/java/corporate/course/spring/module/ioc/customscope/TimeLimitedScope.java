package corporate.course.spring.module.ioc.customscope;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

public class TimeLimitedScope implements Scope
{
    private final ThreadLocal<Map<String, Object>> threadScope =
            new NamedThreadLocal<>("Time Limited Scope")
            {
                @Override
                protected Map<String, Object> initialValue()
                {
                    return new HashMap<>();
                }
            };

    private long timeLimit;
    private LocalDateTime creationTime;
    private LocalDateTime destroyingTime;

    public void setTimeLimit(long timeLimit)
    {
        this.timeLimit = timeLimit;
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory)
    {
        Object scopedObject;
        Map<String, Object> scope = this.threadScope.get();

        if (isTimeOff())
        {
            scope.remove(name);
            System.out.println("Instance id: " + name + " was out of time.");
            scopedObject = null;
        }
        else
        {
            scopedObject = objectFactory.getObject();
            scope.put(name, scopedObject);
        }

        if (creationTime == null)
        {
            initTimer();
        }

        return scopedObject;
    }

    @Override
    public Object remove(String name)
    {
        Map<String, Object> scope = this.threadScope.get();
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

    private void initTimer()
    {
        creationTime = LocalDateTime.now();
        destroyingTime = creationTime.plusSeconds(timeLimit);
    }

    private boolean isTimeOff()
    {
        if (destroyingTime == null)
        {
            return false;
        }

        return LocalDateTime.now().isAfter(destroyingTime);
    }
}
