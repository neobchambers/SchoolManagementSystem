package school.strategy;

import school.model.Grade;

import java.util.List;

public interface GradeStrategy {

    double calculate(List<Grade> grades);

    String getName();
}