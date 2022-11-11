public class Person {
    private String name;
    private Sex sex;
    private int age;
    // private String parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public String getParent() {
    //     return parent;
    // }

    // public void setParent(String parent) {
    //     this.parent = parent;
    // }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Sex getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Name: " + name +
                ", Age: " + age +
                ", Sex: " + sex;
    }
}