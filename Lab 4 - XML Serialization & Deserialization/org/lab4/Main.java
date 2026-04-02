package org.lab4;

public class Main {
    public static void main(String[] args) throws Exception {

    Course c1 = new Course("math","CSE4141",4);
    Course c2 = new Course("math2","CSE4241",3);
    Person p = new Person("ami");
    p.addCourse(c1);p.addCourse(c2);

    String parsed = XMLSerializer.parse(p,0);
    System.out.println(parsed);

    XMLDeserializer.deserializeAndPrint(parsed,p.getClass());
}
}