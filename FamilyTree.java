import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FamilyTree {
    ArrayList<Node> tree;
    ArrayList<Person> person;
    private Map<Integer, String> command;
    private boolean work;
    Scanner scanner;

    public FamilyTree() {
        ArrayList<Node> tree = new ArrayList<Node>();
        this.tree = tree;


        command = new TreeMap<>();
        command.put(1, "stop");
        command.put(2, "searchByName");
    }

    /**
     * 
     * @param parent
     * @param child
     */
    public void addParent(Person parent, Person child) {
        this.tree.add(new Node(parent, child, Relations.Parent));
        this.tree.add(new Node(child, parent, Relations.Child));
    }

    public ArrayList<String> viewAll(){
        ArrayList<String> res = new ArrayList<String>();
        for (Node node: this.tree){
            res.add(node.getPerson().getName());  
        }
        return res;
    }

        /**
     * Поиск по имени
     * @param name - 
     * @return ArrayList
     */
    public ArrayList<String> searchParentByName(String name){
        ArrayList<String> res = new ArrayList<String>();
        for (Node node: this.tree) {
            if (node.getPerson().getName() == name){
                if(node.getRelation() == Relations.Parent){
                    
                    res.add(node.getParent().getName());
                    
                }
            }
        }
        return res;
    }

    public ArrayList<String> searchChildrenByName(String name){
        ArrayList<String> res = new ArrayList<String>();
        for (Node node: this.tree) {
            if (node.getPerson().getName() == name){
                if(node.getRelation() == Relations.Child){
                    res.add(node.getParent().getName());
                }
            }
        }
        return res;
    }
    
    // TODO: Не работает. Как будто из за того что персон создаем в майне а запускаем тут, но это не точно
    public void execute(int command){
        if (!this.command.containsKey(command)){
            return;
        }
        switch (this.command.get(command)){
            case "stop":
                work = false;
                break;
            case "searchByName":
                System.out.println("Введите имя которое хотите найти: ");
                if (scanner.hasNext()){
                    String name = scanner.next();
                    System.out.println(searchParentByName(name));
                    System.out.println(name);
                }
                break;
        }
    }

    public void console(){
        work = true;
        scanner = new Scanner(System.in);
        while (work){
            System.out.println(this.command);
            if (scanner.hasNextInt()){
                execute(scanner.nextInt());
            }
        }
        System.out.println("До свидания!");
    }

}