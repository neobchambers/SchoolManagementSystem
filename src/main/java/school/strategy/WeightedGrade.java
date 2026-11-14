package school.strategy;

import school.model.Grade;

import java.util.List;

public class WeightedGrade implements GradeStrategy {

    @Override
    public double calculate(List<Grade> grades) {

        if (grades.isEmpty()) {
            return 0;
        }

        double weightedTotal = 0;
        double totalWeight = 0;

        for (Grade grade : grades) {
            weightedTotal += grade.getScore() * grade.getWeight();
            totalWeight += grade.getWeight();
        }

        return weightedTotal / totalWeight;
    }

    @Override
    public String getName() {
        return "Weighted average";
    }
}