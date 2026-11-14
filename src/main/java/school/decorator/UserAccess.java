package school.decorator;

public interface UserAccess {

    boolean canEditGrades();

    boolean canViewReports();

    String getDescription();
}
