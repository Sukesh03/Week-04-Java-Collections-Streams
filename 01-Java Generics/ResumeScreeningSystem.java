import java.util.ArrayList;
import java.util.List;

// Abstract Job Role
abstract class JobRole {
    private String candidateName;
    private int yearsOfExperience;

    public JobRole(String candidateName, int yearsOfExperience) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public abstract void displayRoleDetails();
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Software Engineer: " + getCandidateName() + " (" + getYearsOfExperience() + " years experience)");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Data Scientist: " + getCandidateName() + " (" + getYearsOfExperience() + " years experience)");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Product Manager: " + getCandidateName() + " (" + getYearsOfExperience() + " years experience)");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T jobApplication;

    public Resume(T jobApplication) {
        this.jobApplication = jobApplication;
    }

    public T getJobApplication() {
        return jobApplication;
    }

    public void processResume() {
        System.out.println("Processing resume for:");
        jobApplication.displayRoleDetails();
    }
}

// Screening Utility
class ResumeScreening {
    public static <T extends JobRole> Resume<T> createResume(T jobRole) {
        System.out.println("Creating resume for " + jobRole.getCandidateName());
        return new Resume<>(jobRole);
    }

    public static void screenAllResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.processResume();
            System.out.println("---");
        }
    }
}

// Main Class
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

        // Candidates
        SoftwareEngineer seCandidate = new SoftwareEngineer("Alice", 5);
        DataScientist dsCandidate = new DataScientist("Bob", 3);
        ProductManager pmCandidate = new ProductManager("Charlie", 7);

        // Create resumes
        Resume<SoftwareEngineer> seResume = ResumeScreening.createResume(seCandidate);
        Resume<DataScientist> dsResume = ResumeScreening.createResume(dsCandidate);
        Resume<ProductManager> pmResume = ResumeScreening.createResume(pmCandidate);

        // Add to list
        resumeList.add(seResume);
        resumeList.add(dsResume);
        resumeList.add(pmResume);

        System.out.println("\n=== Screening Resumes ===");
        ResumeScreening.screenAllResumes(resumeList);
    }
}
