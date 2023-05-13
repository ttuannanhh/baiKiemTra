package advancec.dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {
    private static final String FILEJob = "input.txt";
    
    public static void main(String[] args) {
        List<Person> Persons = readPersonsFromFile("input.txt");

        System.out.println("Danh sách các nhân vien:");
        for (Person Person : Persons) {
            System.out.println(Person.getJob() + ": " + Person.getAge() + ": " + Person.getCity() + ": " + Person.getIncome());
        }

        Collections.sort(Persons);

        System.out.println("\nDanh sách sau khi sắp xếp theo lương tăng dần:");
        for (Person Person : Persons) {
            System.out.println(Person.getJob() + ": " + Person.getAge() + ": " + Person.getCity() + ": " + Person.getIncome());
        }

        Person highestPaid = getHighestPaidPerson(Persons);
        System.out.println("\nNhân viên có lương cao nhất:");
        System.out.println(highestPaid.getJob() + ": " + highestPaid.getAge() + ": " + highestPaid.getCity() + ": " + highestPaid.getIncome());
    }

    private static List<Person> readPersonsFromFile(String fileJob) {
        List<Person> Persons = new ArrayList<>();

        try {
            File file = new File(fileJob);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 4) {
                    String job = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    String city = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());

                    Person Person = new Person(job, age, city, salary);
                    Persons.add(Person);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin.");
            e.printStackTrace();
        }

        return Persons;
    }


    private static Person getHighestPaidPerson(List<Person> Persons) {
        if (Persons.isEmpty()) {
            return null;
        }

        Person highestPaid = Persons.get(0);
        for (int i = 1; i < Persons.size(); i++) {
        	 if (Persons.get(i).getIncome() > highestPaid.getIncome()) {
        		 highestPaid = Persons.get(i);
             }
         }

         return highestPaid;
     }
 }
        	 
	

