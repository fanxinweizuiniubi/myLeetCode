package interview;

public class Father {

    protected String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Son extends Father {

    private String sonName;

    public Son() {
    }

    public Son(String sonName) {
        this.sonName = sonName;
    }

    public void setName(String name) {
        this.name = name + this.sonName;
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.setAge(5);
        son.name = "baby";
        System.out.println(son);
        Father father = new Father();
        father.name = "daddy";
        System.out.println(father.toString());
        Son sonName = new Son("fox");
        sonName.setName("fa");
        System.out.println(sonName);
    }

}
