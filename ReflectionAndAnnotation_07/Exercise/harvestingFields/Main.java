package ReflectionAndAnnotation_07.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Field>> fieldsMap = getFieldsMap();
        Consumer<Field> printerField = field -> System.out.println(String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(), field.getName()));

        String command = scan.nextLine();
        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    fieldsMap.get("private").forEach(printerField);
                    break;
                case "public":
                    fieldsMap.get("public").forEach(printerField);
                    break;
                case "protected":
                    fieldsMap.get("protected").forEach(printerField);
                    break;
                case "all":
                    fieldsMap.get("all").forEach(printerField);

                    break;
            }
            command = scan.nextLine();
        }
    }

    private static Map<String, List<Field>> getFieldsMap() {
        Map<String, List<Field>> map = new HashMap<>();
        map.put("private", new ArrayList<>());
        map.put("public", new ArrayList<>());
        map.put("protected", new ArrayList<>());

        List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
        map.put("all", allFields);

        allFields.forEach(field -> {
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "private":
                    map.get("private").add(field);
                    break;
                case "public":
                    map.get("public").add(field);
                    break;
                case "protected":
                    map.get("protected").add(field);
                    break;
            }
        });
        return map;
    }
}
