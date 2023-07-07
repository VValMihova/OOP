package InterfacesAndAbstraction_04.Lab.p04SayHelloExtended;

public class European extends BasePerson {
    private String name;

    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
