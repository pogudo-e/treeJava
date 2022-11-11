
public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", 56);
        Person vasya = new Person("Вася", 30);
        Person masha = new Person("Маша", 25);
        Person mihail = new Person("Михаил", 27);
        Person jane = new Person("Женя", 2);
        Person ivan = new Person("Ваня", 5);
        FamilyTree tree = new FamilyTree();
        tree.addNode(irina, masha);
        tree.addNode(irina, vasya);
        tree.addNode(irina, mihail);

        tree.addNode(vasya, jane);
        tree.addNode(vasya, ivan);
        // view(tree);

        System.out.println(irina.getName() + ": " + Relations.Parent +" " + tree.getRelatedPersons(irina, Relations.Parent));
        // System.out.println(vasya.getName() + ": " + tree.getRelatedPersons(vasya, Relations.Parent));
        // System.out.println(masha.getName() + ": " + tree.getRelatedPersons(masha, Relations.Parent));
        System.out.println(tree.searchByName("Маша"));


        // System.out.println("Поиск людей по возрасту: " + tree.searchByAge(30));
        // tree.console();
    }
    // public void view(Person tree){
    //     for (Node node: tree) {
    //         if (node.getRelation() == Relations.Parent){
    //         System.out.println(getRelatedPersons(node.getPerson(), Relations.Parent));
    //         }
    //     }
    // }
}