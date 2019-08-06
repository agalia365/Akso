import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list7 = new ArrayList<>();
        list7.add(new String("test"));
        list7.add(new String("new String"));

        for(String s : list7) {
            s = s + "list7";
        }
        list7.forEach(System.out::println);

    }
}
