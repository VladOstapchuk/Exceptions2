import java.util.Comparator;

public class SortByLastName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        int result =0;

        if (student1 == null || student2 == null)
            result = 0;
        else if (student1.getLastName().compareTo(student2.getLastName()) > 0)
            result = 1;
        else if (student1.getLastName().compareTo(student2.getLastName()) < 0)
            result = -1;

        return result;
    }
}



