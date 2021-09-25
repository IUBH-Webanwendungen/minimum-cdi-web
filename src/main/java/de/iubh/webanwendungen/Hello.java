package de.iubh.webanwendungen;

import java.util.Iterator;
import java.util.Set;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Hello
{
    private String name;

    @Inject
    private FriendsMemory memory;

    /**
     * @return the stored name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name stores the given name
     */
    public void setName(String name)
    {
        this.name = name;
        if (name != null && name.length() > 0) {
            memory.getNamesMet().add(name);
        }
    }

    /**
     * @return the greeting to the named.
     */
    public String getGreeting()
    {
        if (name == null || name.trim().length() == 0) {
            return "";
        }
        return "Hello " + name + "!";
    }

    /**
     * @return Gets a bit from the memory
     */
    public String getFriendsMemoryBit()
    {
        String ranF = randomFriend();
        if (ranF == null) {
            return "";
        } else {
            return "Did you know I met " + ranF + "?";
        }
    }

    /**
     * @return Returns the name of a previously met friend from the memory.
     */
    private String randomFriend()
    {
        Set<String> l = memory.getNamesMet();
        String r = null;
        if (l.size() <= 1) {
            return null;
        }
        boolean found = false;
        while (!found) {
            int p = (int) Math.round(Math.random() * l.size());
            Iterator<String> it = l.iterator();
            for (int i = 0; i < p; i++) {
                r = it.next();
            }
            if( r!=null && ! r.equals(name)) {
                found = true;
            }
        }
        return r;
    }
}

