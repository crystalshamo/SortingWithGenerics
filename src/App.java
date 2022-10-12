import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.Student;
import sorting.Sort;

public class App {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "Integer":
                    System.out.println("Integer processing......"); 
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
                case "Float":
                System.out.println("Float processing......");
                    arrayList.add((Student<T>) new Student<Float>(id, random.nextFloat(100)));
                    break;
                case "Double":
                System.out.println("Double processing......");
                    arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble(100)));
                    break;
                default:
                    System.out.println("Input invaild Interget will be used.");
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
            }

        }
        return arrayList;
    }

    public static <T extends Comparable<T>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input the array size: ");
            int arrayLength = scanner.nextInt();
            System.out.println("Please input the grade data type (choose Integer, Float, or Double): ");
            String typeName = scanner.next();
            ArrayList<Student<T>> arrayList = createRandomArray(arrayLength, typeName);
            System.out.println(arrayList.toString());
            System.out.println(Sort.isSorted(arrayList));
            Sort.mergeSort(arrayList);
            System.out.println(arrayList.toString());
            System.out.println(Sort.isSorted(arrayList));

            System.out.println("If you would like to continue enter yes if not enter no"); 
            String yesNo = scanner.next();
            if (yesNo.equals("no")){
                System.out.println("Thank you! Have a nice day!");
                break; 
            }
                if (yesNo.equals("yes")){
                    continue; 
                }else{
                    System.out.println("Your input is invaild please try again!");
                continue; 
            }
               
                 
            
             
            


        }
        scanner.close();
    }
}
