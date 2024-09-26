package az.edu.turing.homeworks.comparator;

import java.util.Comparator;

public class CustomComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int score = p2.getScore() - p1.getScore();
        if (score != 0) {
            return score;
        }
        int gender = (p1.isFemale() == p2.isFemale()) ? 0 : (p1.isFemale() ? -1 : 1);
        if (gender != 0) {
            return gender;
        }
        int age = p1.getAge() - p2.getAge();
        if (age != 0) {
            return age;
        }
        int name = p2.getName().compareToIgnoreCase(p1.getName());
        if (name != 0) {
            return name;
        }
        return p1.compareTo(p2);
    }
}
