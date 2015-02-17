package com.fmi.oopjava.interfaces;

/**
 * We are using this interface, because we want to have abstraction when coming to
 * writing or reading Clients of BankCards to XML files.
 * 
 * Because I don't want to have different methods for i/o for the two classes,
 * I am using this interface.
 * 
 * Each class that want to be serialized using my xmlSerializer should implement it!
 * 
 * @author Dimitar
 */
public interface Storable {
    
    public String getFileName();
    
}
