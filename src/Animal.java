public class Animal {
    public static void main(String[] args) {
        Animal animal=new Animal();
        Dog dog=new Dog();
        if(animal instanceof Dog){
            System.out.println("狗是他的子类");
        }else {
            System.out.println("狗不是他的子类");
        }
    }
}
class Dog extends Animal{

}
