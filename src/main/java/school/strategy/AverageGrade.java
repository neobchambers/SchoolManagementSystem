package school.strategy;

import school.model.Grade;

import java.util.List;

public class AverageGrade implements GradeStrategy {

    @Override
    public double calculate(List<Grade> grades) {

        if (grades.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Grade grade : grades) {
            total += grade.getScore();
        }

        return total / grades.size();
    }

    @Override
    public String getName() {
        return "Average";
    }
}