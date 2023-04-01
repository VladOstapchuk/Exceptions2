public class Main {
    public static void main(String[] args) {


        Student student1 = new Student("Alex", "One", Gender.MALE);
        Student student2 = new Student("Kat", "Two", Gender.FEMALE);

        Group VI42 = new Group("VI42");
        try {
            VI42.addStudent(student1);
            VI42.addStudent(student2);

        } catch (GroupOverflowException e){
            System.out.println("This group is full");
        }

        System.out.println(VI42.toString());


 //       try {
 //           System.out.println(VI42.searchStudentByLastname("Two").toString());
 //       } catch (StudentNotFoundException e) {
 //                   }


    }
}