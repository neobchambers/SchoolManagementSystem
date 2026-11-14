package school.decorator;

public class BasicAccess implements UserAccess {

    @Override
    public boolean canEditGrades() {
        return false;
    }

    @Override
    public boolean canViewReports() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Basic access";
    }
}