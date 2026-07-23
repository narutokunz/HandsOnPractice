package com.cognizant.javadfse.week1.designpatterns.factory;

/**
 * Common interface for all document types.
 */
public interface Document {
    void open();
    void save();
    void close();
}