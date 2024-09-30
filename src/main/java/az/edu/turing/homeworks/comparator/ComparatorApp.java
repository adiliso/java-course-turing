package az.edu.turing.homeworks.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorApp {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player(1, "Bob", 19, false, 80.8),
                new Player(2, "John", 19, false, 80.8),
                new Player(3, "Sophia", 24, true, 90.5)
        );
        players.sort(Comparator.comparing(Player::getScore, Comparator.reverseOrder())
                .thenComparing(Player::isFemale, Comparator.reverseOrder())
                .thenComparing(Player::getAge)
                .thenComparing(Player::getName, Comparator.reverseOrder())
                .thenComparing(Player::compareTo));
        players.forEach(System.out::println);
    }
}
