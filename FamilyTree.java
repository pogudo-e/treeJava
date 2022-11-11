import java.util.ArrayList;

public class FamilyTree {
    ArrayList<String> res = new ArrayList<String>();
    ArrayList<Node> tree;
    ArrayList<Person> person;

    public FamilyTree() {
        ArrayList<Node> tree = new ArrayList<Node>();
        this.tree = tree;
    }


    public void addNode(Person parent, Person child) {
        this.tree.add(new Node(parent, child, Relations.Parent));
        this.tree.add(new Node(child, parent, Relations.Child));
    }

    /**
     * Поиск по Возрасту
     * @param age - 
     * @return ArrayList
     */
    public ArrayList<String> searchByAge(int age){
        
        for (Node node: this.tree) {
            if (node.getPerson().getAge() < age){
                res.add(node.getPerson().getName());
            }
        }
        return res;
    }
    /**
     * Поиск по имени
     * @param name - 
     * @return ArrayList
     */
    public ArrayList<String> searchByName(String name){
        for (Node node: this.tree) {
            if (node.getPerson().getName() == name){
                if(node.getRelation() == Relations.Parent){
                    res.add(node.getParent().getName());
                }
                if(node.getRelation() == Relations.Child){
                    res.add(node.getParent().getName());
                }
            }
        }
        return res;
    }

    public void console(){
        for (Node node: this.tree) {
            if (node.getRelation() == Relations.Parent){
            System.out.println( getRelatedPersons(node.getPerson(), Relations.Parent));
            }
        }
    }

    public ArrayList<String> getRelatedPersons(Person person, Relations relation){
        ArrayList<String> ress = new ArrayList<String>();

        for (Node node: this.tree) {
            if ( node.getPerson().getName() == person.getName()
                 && node.getRelation() == relation){
                ress.add(node.getParent().getName());
            }
        }
        return ress;
    }

}