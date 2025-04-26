import java.util.ArrayList;
import java.util.List;

// Abstract Course Type
abstract class CourseType {
    private String courseName;
    private int courseCode;

    public CourseType(String courseName, int courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public abstract void showEvaluationMethod();
}

// Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getCourseName() + " (Exam-Based Evaluation)");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getCourseName() + " (Assignment-Based Evaluation)");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getCourseName() + " (Research-Based Evaluation)");
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private T courseDetails;

    public Course(T courseDetails) {
        this.courseDetails = courseDetails;
    }

    public T getCourseDetails() {
        return courseDetails;
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseDetails.getCourseCode());
        courseDetails.showEvaluationMethod();
    }
}

// Catalog Class
class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void showAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            course.displayCourseInfo();
            System.out.println("---");
        }
    }
}

// Main Class
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Mathematics 101", 1001));
        Course<AssignmentCourse> artCourse = new Course<>(new AssignmentCourse("Modern Art", 2002));
        Course<ResearchCourse> aiCourse = new Course<>(new ResearchCourse("AI Research", 3003));

        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(mathCourse);
        catalog.addCourse(artCourse);
        catalog.addCourse(aiCourse);

        System.out.println("=== University Course Catalog ===");
        catalog.showAllCourses();
    }
}
