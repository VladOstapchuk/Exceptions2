import java.io.*;

public class SaveLoadGroupDAO implements GroupDAO {

    // method for saving Student Group in file
    //output filename = Predicate "SaveGroup" + Group name in txt format
    @Override
    public void saveGroup(Group group) {
        File file = new File("SaveGroup" + group.getGroupName() + ".txt");

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


//method for loading group from file.
//file name must have name like: "LoadGroupVI100.txt" or "LoadGroupKK200.txt"
// were KK200 or VI100 - groupID (group name)
    @Override
    public Group loadGroup(String groupID) {

        String[] studentdata = new String[5];
        String str= "";
        File filename = new File("LoadGroup" + groupID + ".txt");
        Group group = new Group(groupID);

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
        }catch(IOException e){
            System.out.println("ERROR from ReadFromFile method");
        }

        return group;
    }
}
