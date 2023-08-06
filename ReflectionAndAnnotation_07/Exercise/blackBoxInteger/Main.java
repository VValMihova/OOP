package ReflectionAndAnnotation_07.Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());


        String command = scan.nextLine();
        while (!command.equals("END")) {

            String commandName = command.split("_")[0];
            int number = Integer.parseInt(command.split("_")[1]);

            switch (commandName) {
                case "add":
                    executeCommand("add", blackBoxInt, number, innerValue, methods);
                    break;

                case "subtract":
                    executeCommand("subtract", blackBoxInt, number, innerValue, methods);
                    break;

                case "divide":
                    executeCommand("divide", blackBoxInt, number, innerValue, methods);
                    break;

                case "multiply":
                    executeCommand("multiply", blackBoxInt, number, innerValue, methods);
                    break;

                case "rightShift":
                    executeCommand("rightShift", blackBoxInt, number, innerValue, methods);
                    break;
                case "leftShift":
                    executeCommand("leftShift", blackBoxInt, number, innerValue, methods);
                    break;
            }
            command = scan.nextLine();
        }

    }

    private static void executeCommand(String command, BlackBoxInt blackBoxInt, int number, Field innerValue, List<Method> methods) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt, number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
