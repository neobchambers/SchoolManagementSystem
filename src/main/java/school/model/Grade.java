package school.model;

public class Grade {

    private final String studentId;
    private final double score;
    private final double weight;

    public Grade(String studentId, double score, double weight) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100."
            );
        }

        if (weight <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be greater than zero."
            );
        }

        this.studentId = studentId;
        this.score = score;
        this.weight = weight;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getScore() {
        return score;
    }

    public double getWeight() {
        return weight;
    }
}