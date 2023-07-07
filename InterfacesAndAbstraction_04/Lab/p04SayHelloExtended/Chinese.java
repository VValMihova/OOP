package InterfacesAndAbstraction_04.Lab.p04SayHelloExtended;

public class Chinese extends BasePerson {
    private String name;

    protected Chinese(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
