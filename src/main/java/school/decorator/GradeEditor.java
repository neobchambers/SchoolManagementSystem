package school.decorator;

public class GradeEditor extends AccessDecorator {

    public GradeEditor(UserAccess access) {
        super(access);
    }

    @Override
    public boolean canEditGrades() {
        return true;
    }

    @Override
    public String getDescription() {
        return access.getDescription() + " + Grade Editor";
    }
}