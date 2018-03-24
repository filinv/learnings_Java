public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student=null;
        for(Student s: students){
            if(s.getAverageGrade()==averageGrade){
                student=s;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student=null;
        double maxGrade=Double.MIN_VALUE;
        for(Student s: students){
            if(s.getAverageGrade()>maxGrade){
                maxGrade=s.getAverageGrade();
                student=s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade(){
        Student student=null;
        double minGrade=Double.MAX_VALUE;
        for(Student s: students){
            if(s.getAverageGrade()<minGrade){
                minGrade=s.getAverageGrade();
                student=s;
            }
        }
        return student;
    }

    public void expel(Student student){
        if(students!=null&&students.contains(student)){
            students.remove(student);
        }
    }
}
