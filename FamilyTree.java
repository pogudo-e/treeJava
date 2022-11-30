import java.util.ArrayList;

public class FamilyTree<T extends Person> {

    ArrayList<String> res = new ArrayList<String>();
    ArrayList<Node> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void addNode(T parent, T child, Relations relation) {
        if (relation == Relations.Parent) {
            this.tree.add(new Node<Person>(parent, child, Relations.Parent));
            this.tree.add(new Node<Person>(child, parent, Relations.Child));
        } else if (relation == Relations.Sibling) {
            this.tree.add(new Node<Person>(parent, child, Relations.Sibling));
            this.tree.add(new Node<Person>(child, parent, Relations.Sibling));
        } else if (relation == Relations.GrandParent) {
            this.tree.add(new Node<Person>(child, parent, Relations.GrandParent));
            if (child.getSex() == 0) {
                this.tree.add(new Node<Person>(parent, child, Relations.GrandDaughter));
            } else {
                this.tree.add(new Node<Person>(parent, child, Relations.GrandSon));
            }
        }

    }

    /**
     * Поиск по Возрасту
     * 
     * @param age -
     * @return ArrayList
     */
    @SuppressWarnings("unchecked")
    public ArrayList<String> searchByAge(int age) {

        for (Node<Person> node : this.tree) {
            if (node.getPerson().getAge() < age) {
                res.add(node.getPerson().getName());
            }
        }
        return res;
    }

    /**
     * Поиск по имени
     * 
     * @param name -
     * @return ArrayList
     */

    @SuppressWarnings("unchecked")
    public ArrayList<String> searchByName(String name) {
        for (Node<Person> node : this.tree) {
            if (node.getPerson().getName() == name) {
                if (node.getRelation() == Relations.Parent) {
                    res.add(node.getParent().getName());
                }
                if (node.getRelation() == Relations.Child) {
                    res.add(node.getParent().getName());
                }
            }
        }
        return res;

    }

    @SuppressWarnings("unchecked")
    public void console() {
        for (Node<Person> node : this.tree) {
            if (node.getRelation() == Relations.Parent) {
                System.out.println(getRelatedPersons(node.getPerson(), Relations.Parent));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> getRelatedPersons(Person person, Relations relation) {
        ArrayList<String> ress = new ArrayList<String>();

        for (Node<Person> node : this.tree) {
            if (node.getPerson().getName() == person.getName()
                    && node.getRelation() == relation) {
                ress.add(node.getParent().getName());
            }
        }
        return ress;
    }

    public ArrayList<String> getChild(T person) {
        return getRelatedPersons(person, Relations.Parent);
    }

    public ArrayList<String> getParent(T person) {
        return getRelatedPersons(person, Relations.Child);
    }

    public ArrayList<String> getGrandParent(T person) {
        return getRelatedPersons(person, Relations.GrandParent);
    }

    public ArrayList<String> getSibling(T person) {
        return getRelatedPersons(person, Relations.Sibling);
    }
}