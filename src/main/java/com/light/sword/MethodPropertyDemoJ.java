package com.light.sword;

public class MethodPropertyDemoJ {
    public static void main(String[] args) {
        Book1 b1 = new Book1();
        b1.name = "B1";
        b1.author = "b1";
        Book2 b2 = new Book2();
        b2.setName("B2");
        b2.setAuthor("b2");
    }
}

class Book1 {
    public String name;
    public String author;
}

class Book2 {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


