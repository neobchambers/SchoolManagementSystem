package school.factory;

import school.model.Student;
import school.model.User;

public class StudentFactory extends ProfileFactory {

    @Override
    public User createProfile(
            String id,
            String name,
            String details
    ) {
        return new Student(id, name, details);
    }
}
