
public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", 56, 0);
        Person vasya = new Person("Вася", 30, 1);
        Person masha = new Person("Маша", 25, 0);
        Person mihail = new Person("Михаил", 27, 1);
        Person jane = new Person("Женя", 2, 1);
        Person ivan = new Person("Ваня", 5, 1);
        FamilyTree<Person> tree = new FamilyTree<>();
        tree.addNode(irina, masha, Relations.Parent);
        tree.addNode(irina, vasya, Relations.Parent);
        tree.addNode(irina, mihail, Relations.Parent);

        tree.addNode(vasya, jane, Relations.Parent);
        tree.addNode(vasya, ivan, Relations.Parent);

        tree.addNode(jane, ivan, Relations.Sibling);

        tree.addNode(irina, jane, Relations.GrandParent);

        System.out.println("Поиск по имени - " + masha.getName() + " : " + tree.searchByName("Маша"));
        System.out.println(tree.getGrandParent(jane)); // Бабушка Жени
        // System.out.println(tree.getGrandParent(irina));
        System.out.println(tree.getSibling(jane)); // Брат Жени
        System.out.println(tree.getChild(vasya)); // Дети Васи
        System.out.println(tree.getParent(ivan)); // Родитель Вани
    }

}