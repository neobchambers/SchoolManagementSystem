package school.factory;

import school.model.Staff;
import school.model.User;

public class StaffFactory extends ProfileFactory {

    @Override
    public User createProfile(
            String id,
            String name,
            String details
    ) {
        return new Staff(id, name, details);
    }
}