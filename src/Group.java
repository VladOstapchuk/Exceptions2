import java.util.Arrays;
import java.util.Comparator;

public class Group{
    private String groupName;
    Student[] students = new Student[10];


    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    //метод добавления студента в группу
    public void addStudent (Student student) throws GroupOverflowException  {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                students[i].setId(i+1);
                break;
            } else if (students[students.length-1] != null) {
               throw new GroupOverflowException();
              }
        }
    }

    //метод поиска студента по фамилии
    public Student searchStudentByLastname (String lastName) throws StudentNotFoundException {
        Student student = null;

        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null && students[i].getLastName() == lastName) {
                student = students[i];
            } else {
                throw new StudentNotFoundException();
            }

        }
        return student;
    }

    public boolean removeStudentById (int id){
        boolean result = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null && students[i].getId() == id){
                students[i] = null;
                result = true;
            }
        }

        return result;
    }



    public void sortStudentsByLastName(){
        Arrays.sort(students, new SortByLastName());

    }




}

