import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Person eva = new Person("Ева", 52, Sex.Male);
        Person mahim = new Person("Максим", 34, Sex.Female);
        Person masha = new Person("Маша", 29, Sex.Male);
        Person mihail = new Person("Михаил", 27, Sex.Female);
        Person jane = new Person("Женя", 2, Sex.Female);
        Person ivan = new Person("Ваня", 5, Sex.Female);
        
        
        FamilyTree tree = new FamilyTree();
        tree.addParent(eva, jane);
        tree.addParent(mahim, jane);
        tree.addParent(mahim, mihail);
        tree.addParent(masha, ivan);
        tree.addParent(mihail, ivan);

        System.out.println(mahim);
        printer(tree.searchParentByName("Максим")); // Женя Михаил
        printer(tree.searchParentByName("Маша")); // Ваня
        printer(tree.searchChildrenByName("Ваня")); // Маша Михаил



        // tree.console();
        // System.out.println(tree.viewAll());
    }
    public static void printer(ArrayList<String> arr){
        for (String ele : arr) {
            System.out.print(ele);
            System.out.print(" ");
        }
        System.out.println();
    }
}