package school.factory;

import school.model.User;

public abstract class ProfileFactory {

    public abstract User createProfile(
            String id,
            String name,
            String details
    );
}