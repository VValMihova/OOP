package InterfacesAndAbstraction_04.Lab.p03SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }


}

