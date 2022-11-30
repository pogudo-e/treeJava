public class Node<T extends Person> {
    private T person;
    private T parent;
    private Relations relation;

    public Node(T person, T parent, Relations relation) {
        this.person = person;
        this.parent = parent;
        this.relation = relation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(T person) {
        this.person = person;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public Relations getRelation() {
        return relation;
    }

    public void setRelation(Relations relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Node{" +
                "person=" + person +
                ", parent=" + parent +
                ", relation=" + relation +
                '}';
    }
}
