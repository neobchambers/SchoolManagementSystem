package school.model;

public class Staff extends User {

    private final String position;

    public Staff(String id, String name, String position) {
        super(id, name);

        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException(
                    "Position cannot be empty."
            );
        }

        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Position: " + position);
    }
}
