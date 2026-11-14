package school.decorator;

public abstract class AccessDecorator implements UserAccess {

    protected final UserAccess access;

    public AccessDecorator(UserAccess access) {
        this.access = access;
    }

    @Override
    public boolean canEditGrades() {
        return access.canEditGrades();
    }

    @Override
    public boolean canViewReports() {
        return access.canViewReports();
    }

    @Override
    public String getDescription() {
        return access.getDescription();
    }
}