package az.edu.turing.homeworks.comparator;

public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private int age;
    private boolean isFemale;
    private double score;

    public Player() {
    }

    public Player(int id, String name, int age, boolean isFemale, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return this.id - o.id   ;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isFemale=" + isFemale +
                ", score=" + score +
                '}';
    }
}
