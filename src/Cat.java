public class Cat extends Animals{
    public Cat(int id, int age) {
        super(id, age);
    }

    @Override
    public String toString() {
        return "Cat : "+getId() + " age : "+getAge();
    }
}
