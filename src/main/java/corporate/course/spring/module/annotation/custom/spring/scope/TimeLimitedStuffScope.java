package corporate.course.spring.module.annotation.custom.spring.scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import corporate.course.spring.module.annotation.model.TimeLimitedStuff;

public class TimeLimitedStuffScope implements Scope
{
    public static final String TIME_LIMITED_STUFF_SCOPE = "TimeLimitedStuffScope";

    private Map<String, TimeLimitedStuff> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory)
    {
        Object scopedObject = objectFactory.getObject();
        TimeLimitedStuff stuff = (TimeLimitedStuff) scopedObject;
        scopedObjects.put(name, stuff);
        stuff.destroyByTimer(stuff);

        return scopedObject;
    }

    @Override
    public Object remove(String name)
    {
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable runnable)
    {

    }

    @Override
    public Object resolveContextualObject(String name)
    {
        return null;
    }

    @Override
    public String getConversationId()
    {
        return null;
    }
}
