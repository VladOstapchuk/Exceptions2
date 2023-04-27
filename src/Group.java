import java.io.*;
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
        return  "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    //метод добавления студента в группу
    public void addStudent (Student student, String groupName) throws GroupOverflowException  {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                students[i].setId(i+1);
                break;
            } else if (students[students.length-1] != null) {
               throw new GroupOverflowException();
              }
        }
        student.setGroupName(groupName);
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

    //Write Group into File
    public void saveGroupToFile (Group group, String filename){

        File file = new File(filename);

        try(PrintWriter f=new PrintWriter(file)){
            f.println("Group NAME: " + group.getGroupName());
            f.println();

            for (Student st: group.getStudents()
            ) {
                if (st != null) {
                    f.println(st.getId() + " " + st.getName() + " " + st.getLastName() + " " + st.getGender() + " " + st.getGroupName());
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }


    }

    //Read group from file

    public void ReadGroupFromFile (Group group, String filename){
        String[] studentdata = new String[5];
        String str= "";

        try(BufferedReader f =new BufferedReader(new
                FileReader(filename))){

                for(;(str=f.readLine())!=null;) {
                    studentdata = str.split(" ");
                    Student student = new Student(studentdata[0], studentdata[1], Gender.getGenderbyString(studentdata[2]));
                    try {
                        group.addStudent(student, group.getGroupName());
                    } catch (GroupOverflowException e){
                        System.out.println("This group is full");
                    }
                }


//                //for (int i = 0; i < 5; i++) {
//                //    Student student = new Student(studentdata[1], studentdata[2], Gender.getGenderbyString(studentdata[3]), Integer.parseInt(studentdata[4]), studentdata[1]);
//
//                    try {
//                        group.addStudent(student, group.getGroupName());
//                    } catch (GroupOverflowException e){
//                        System.out.println("This group is full");
//                    }
//
//                //}
        }
        catch(IOException e){
            System.out.println("ERROR from ReadFromFile method");
        }


    }




}

