package school.decorator;

public class ReportViewer extends AccessDecorator {

    public ReportViewer(UserAccess access) {
        super(access);
    }

    @Override
    public boolean canViewReports() {
        return true;
    }

    @Override
    public String getDescription() {
        return access.getDescription() + " + Report Viewer";
    }
}