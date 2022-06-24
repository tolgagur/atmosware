package atmosware.questions.q1;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static final List<List<Integer>> usedCoordinates = new LinkedList<>();
    private static final LinkedHashMap<List<Integer>, Integer> failGames = new LinkedHashMap<>();
    private static final List<List<Integer>> coordinates = new LinkedList<>();
    private static final List<List<Integer>> illegalPosition = List.of(
            List.of(1, 3), List.of(3, 4), List.of(3, 9), List.of(4, 9), List.of(6, 5),
            List.of(5, 8), List.of(6, 1), List.of(7, 8), List.of(9, 4), List.of(9, 7));
    private static int startX;
    private static int startY;
    private static int count = 0;
    private static int gameCount = 0;

    public static void main(String[] args) {
        doCoordinates();
        startGame();
    }

    public static void doCoordinates() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                coordinates.add(List.of(i, j));
            }
        }
    }

    public static void startGame() {

        startX = coordinates.get(count).get(0);
        startY = coordinates.get(count).get(1);

        usedCoordinates.add(List.of(startX, startY));
        count++;
        while (!positions(startX, startY).isEmpty()) {

            findPosition(positions(startX, startY));
        }
        validGame();
    }


    public static void validGame() {

        if (count != 100) {
            print();

            if (usedCoordinates.size() < 100)
                failGames.put(usedCoordinates.get(0), usedCoordinates.size());

            usedCoordinates.clear();
            startGame();
        } else {
            print();
            System.out.println("Count Game " + gameCount);
            System.out.println("Fail Games : " + failGames);
            System.err.println("GAME OVER");
        }
    }

    public static void findPosition(List<List<Integer>> getPositions) {

        LinkedList<List<Integer>> list = new LinkedList<>();

        int minValue = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < getPositions.size(); i++) {
            if (!(positions(getPositions.get(i).get(0), getPositions.get(i).get(1)).isEmpty()) &&
                    minValue > positions(getPositions.get(i).get(0), getPositions.get(i).get(1)).size()) {

                minValue = positions(getPositions.get(i).get(0), getPositions.get(i).get(1)).size();
                index = i;

            }
        }
        for (List<Integer> getPosition : getPositions) {
            if (minValue == positions(getPosition.get(0), getPosition.get(1)).size()) {
                list.add(getPosition);
            }
        }

        int listMin = Integer.MAX_VALUE;
        int listIndex = 0;

        if (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                if (listMin > positions(list.get(i).get(0), list.get(i).get(1)).size()) {
                    listMin = positions(list.get(i).get(0), list.get(i).get(1)).size();
                    listIndex = i;
                }
            }
        }

        LinkedList<List<Integer>> newPosition = new LinkedList<>();

        newPosition.add(list.isEmpty() ? getPositions.get(index) : list.get(listIndex));

        usedCoordinates.add(newPosition.get(0));
        startX = newPosition.get(0).get(0);
        startY = newPosition.get(0).get(1);

    }

    public static List<List<Integer>> positions(int x, int y) {

        List<List<Integer>> possiblePositions = new LinkedList<>();

        if (illegalPosition.contains(usedCoordinates.get(0))) {
            possiblePositions.add(validPosition(x, y - 3));
            possiblePositions.add(validPosition(x - 2, y - 2));
            possiblePositions.add(validPosition(x - 3, y));
            possiblePositions.add(validPosition(x - 2, y + 2));
            possiblePositions.add(validPosition(x, y + 3));
            possiblePositions.add(validPosition(x + 2, y + 2));
            possiblePositions.add(validPosition(x + 3, y));
            possiblePositions.add(validPosition(x + 2, y - 2));

        } else {
            possiblePositions.add(validPosition(x, y - 3));
            possiblePositions.add(validPosition(x + 2, y - 2));
            possiblePositions.add(validPosition(x + 3, y));
            possiblePositions.add(validPosition(x + 2, y + 2));
            possiblePositions.add(validPosition(x, y + 3));
            possiblePositions.add(validPosition(x - 2, y + 2));
            possiblePositions.add(validPosition(x - 3, y));
            possiblePositions.add(validPosition(x - 2, y - 2));
        }


        return possiblePositions.stream()
                .filter(e -> !e.equals(List.of(-1, -1)))
                .toList();

    }

    public static List<Integer> validPosition(int x, int y) {

        if (usedCoordinates.contains(List.of(x, y)))
            return List.of(-1, -1);
        else if (x > 10 || y > 10 || x < 1 || y < 1)
            return List.of(-1, -1);
        else
            return List.of(x, y);
    }

    public static void print() {
        System.out.println("\n" + usedCoordinates);
        if (usedCoordinates.size() == 100)
            gameCount++;
        for (int i = 0; i < 11; i++) {
            System.out.print(String.format("%02d", i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("%02d", i + 1) + "|");
            for (int j = 0; j < 10; j++) {
                if (usedCoordinates.contains(List.of(i + 1, j + 1))) {
                    String s = String.format("%02d", usedCoordinates.indexOf(List.of(i + 1, j + 1)) + 1);
                    System.out.print(s + " ");
                } else {
                    System.out.print("** ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("Total number of steps :  " + usedCoordinates.size() + "\n");
    }
}