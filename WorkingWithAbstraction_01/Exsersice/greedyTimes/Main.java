
package WorkingWithAbstraction_01.Exsersice.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityOfBag = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantity = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < itemsAndQuantity.length; i += 2) {
            String item = itemsAndQuantity[i];
            long count = Long.parseLong(itemsAndQuantity[i + 1]);

            String currentItem = "";

            currentItem = getCurrentItem(item, currentItem);

            if (currentItem.equals("")) {
                continue;
            } else if (capacityValidator(capacityOfBag, bag, count)) {
                continue;
            }

            switch (currentItem) {
                case "Gem":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gold")) {
                            if (goldCountValidator(bag, count)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gem")) {
                            if (goldCountValidator(bag, count)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(currentItem)) {
                bag.put((currentItem), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(currentItem).containsKey(item)) {
                bag.get(currentItem).put(item, 0L);
            }


            bag.get(currentItem).put(item, bag.get(currentItem).get(item) + count);
            if (currentItem.equals("Gold")) {
                gold += count;
            } else if (currentItem.equals("Gem")) {
                gem += count;
            } else if (currentItem.equals("Cash")) {
                cash += count;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean goldCountValidator(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count) {
        return count > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
    }

    private static boolean capacityValidator(long capacityOfBag, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count) {
        return capacityOfBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count;
    }

    private static String getCurrentItem(String item, String currentItem) {
        if (item.length() == 3) {
            currentItem = "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            currentItem = "Gem";
        } else if (item.toLowerCase().equals("gold")) {
            currentItem = "Gold";
        }
        return currentItem;
    }
}