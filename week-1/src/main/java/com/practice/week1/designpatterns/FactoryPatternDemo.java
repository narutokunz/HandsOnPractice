package com.practice.week1.designpatterns;

/**
 * FACTORY PATTERN
 * Delegates object creation to a factory method instead of calling "new" directly,
 * so client code depends only on an interface.
 */
public class FactoryPatternDemo {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() { System.out.println("Drawing a Circle"); }
    }

    static class Rectangle implements Shape {
        public void draw() { System.out.println("Drawing a Rectangle"); }
    }

    static class ShapeFactory {
        static Shape create(String type) {
            return switch (type.toLowerCase()) {
                case "circle" -> new Circle();
                case "rectangle" -> new Rectangle();
                default -> throw new IllegalArgumentException("Unknown shape: " + type);
            };
        }
    }

    public static void main(String[] args) {
        Shape s1 = ShapeFactory.create("circle");
        Shape s2 = ShapeFactory.create("rectangle");
        s1.draw();
        s2.draw();
    }
}
