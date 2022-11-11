public class Node {
    private Person person;
    private Person parent;
    private Relations relation;

    public Node(Person person, Person parent, Relations relation){
        this.person = person;
        this.parent = parent;
        this.relation = relation;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getParent() {
        return parent;
    }
    public void setParent(Person parent) {
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
        return super.toString();
    }
}

