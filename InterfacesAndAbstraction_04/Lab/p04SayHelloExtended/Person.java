package InterfacesAndAbstraction_04.Lab.p04SayHelloExtended;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }


}