package school.model;

public abstract class User {

    private final String id;
    private final String name;

    public User(String id, String name) {
        if (id == null || id.isBlank() ||
                name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "ID and name cannot be empty."
            );
        }

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + getRole());
    }
}