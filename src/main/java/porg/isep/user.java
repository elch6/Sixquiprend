package porg.isep;

public class user {
    public class User {
        private String name;
        private int score;

        public User(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void addScore(int score) {
            this.score += score;
        }
    }

}
