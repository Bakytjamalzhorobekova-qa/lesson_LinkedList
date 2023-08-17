import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Animals> animals = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            animals.add(new Dog(i + 1, random.nextInt(20))); // 50'дон Cat и Dog туздук
            animals.add(new Cat(i + 1, random.nextInt(10)));

        }
        int count = 0;

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Cat) {          // ар 5 чи cat очурдук
                count++;
                if (count == 5) {
                    animals.remove(animals.get(i));
                    count = 0;
                }

            }

        }

        count = 0;
        int mouseId = 1;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Dog) {   //ар 3 чу dog' тон кийин 1 ден mouse коштук
                count++;
                if (count == 3) {
                    animals.add(i + 1, new Mouse(mouseId, random.nextInt(5)));
                    mouseId++;
                    count = 0;
                }
            }
        }
        LinkedList<Cat> cats = new LinkedList<>();  // mouse' тун жанында турган cats башка List'ге салып сразу
        // remove( удаление) кылдык
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Cat) {
                if (animals.get(i + 1) instanceof Mouse || animals.get(i - 1) instanceof Mouse) {
                    cats.add((Cat) animals.get(i));
                    animals.remove(animals.get(i));

                }
            }
        }


        LinkedList<Animals> sortAnimal = new LinkedList<>();
        for (Animals animal : animals) {
            if (animal instanceof Cat) {      // Жаны sortList туздук Cat' терди 1 чи чыгардык
                sortAnimal.addFirst(animal);
            } else if (animal instanceof Dog) {  // Dog'торду ортого чыгардык
                sortAnimal.add(animal);
            }

        }

        for (Animals animal : animals) {
            if (animal instanceof Mouse) {
                sortAnimal.addLast(animal);    // Mouse'тарды акыркы чыгардык
            }
        }

        for (Animals animals1 : sortAnimal) {
            System.out.println(animals1);

        }

        ArrayList<Animals> arrayList = new ArrayList<>(animals);// 3 чу жолу - эн кыска жолу ArrayList конст беребиз

        System.out.println(arrayList);
//        for (Animals animal : animals) {
//            arrayList.add(animal);          // LinkedList' тен жаны ArrayList' ге кочуруп алдык - булчи 1 жолу
//

//        arrayList.addAll(animals);         //LinkedList'тен жаны ArrayList'ге кочургондун -2 чи жолу
        int catSumma = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Cat) {
                catSumma += animals.get(i).getAge();
                catSumma++;
            }
        }
        int dogSumma = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Dog) {
                dogSumma += animals.get(i).getAge();
                dogSumma++;
            }
        }
        int mouseSumma = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Mouse) {
                mouseSumma += animals.get(i).getAge();
                mouseSumma++;
            }

        }


        System.out.println("The sum of the Age Cats : " + catSumma);
        System.out.println("The sum of the Age Dogs : " + dogSumma);
        System.out.println("The sum of the Age Mice : " + mouseSumma);


    }
}
