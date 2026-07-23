package com.cognizant.javadfse.week1.designpatterns.factory;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Document Management System ---");

        // 1. Client wants a Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("\nExecuting Word Factory:");
        wordFactory.processDocument();

        // 2. Client wants a PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("\nExecuting PDF Factory:");
        pdfFactory.processDocument();

        // 3. Client wants an Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("\nExecuting Excel Factory:");
        excelFactory.processDocument();
    }
}