package ReflectionAndAnnotation_07.Lab.p03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getModifiers))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] methods = Reflection.class.getDeclaredMethods();
        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0 && !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s have to be public!%n",
                        m.getName()));

        Method[] setters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") &&
                        m.getParameterCount() == 1 && !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(setters).forEach(m ->
                System.out.printf("%s have to be private!%n",
                        m.getName()));

    }
}
