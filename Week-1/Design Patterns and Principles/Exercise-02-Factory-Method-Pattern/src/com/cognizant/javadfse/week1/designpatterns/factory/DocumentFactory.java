package com.cognizant.javadfse.week1.designpatterns.factory;

/**
 * Abstract Creator class that declares the factory method.
 */
public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();
    
    // A common operation that uses the factory method
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}