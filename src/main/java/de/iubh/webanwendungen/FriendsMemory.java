package de.iubh.webanwendungen;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class FriendsMemory implements Serializable
{
    private Set<String> namesMet = new HashSet<>();

    public Set<String> getNamesMet()
    {
        return namesMet;
    }
}
