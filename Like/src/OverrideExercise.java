public class OverrideExercise {
    public static void main(String[] args){
    Person jack = new Person(10,"JACK");
    System.out.println(jack.say());
    Student peter = new Student(22,"韦",2455,3455);
        System.out.println(peter.say());
    }
}

class Person{
    private String name;
    private int age;

    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }
    public String say(){
        return "name="+name+"age="+age;
    }
}

class Student extends Person{
    private int id;
    private double score;

    public Student(int age, String name, int id,double score) {
        super(age, name);
        this.id = id;
        this.score = score;
    }



    public String say(){
        return super.say()+"id="+id+"score"+score;
    }
}