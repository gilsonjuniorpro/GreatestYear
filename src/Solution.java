
import java.util.*;

public class Solution {

    public static void main(String args[]) {
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int birthYear = in.nextInt();
            int deathYear = in.nextInt();
            people.add(new Person(birthYear, deathYear));
        }

        System.out.println(findYears(people));
    }
    
    
    private static class Person{
        public Person(int birthYear, int deathYear){
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }
        int birthYear;
        int deathYear;
    }
    
    
    public static int findYears(List<Person> people){
        Map<Integer, Integer> years = new TreeMap<>();

        for (Person person : people){
            if (!years.containsKey(person.birthYear)){
                years.put(person.birthYear, 0);
            }
            years.put(person.birthYear, years.get(person.birthYear) + 1);

            if (!years.containsKey(person.deathYear + 1)){
                years.put(person.deathYear + 1, 0);
            }
            years.put(person.deathYear + 1, years.get(person.deathYear + 1) - 1);
        }
        //maximum sub array
        int maxYear = 0, max = Integer.MIN_VALUE, current = 0;

        for (Map.Entry<Integer, Integer> entry : years.entrySet()){
            int year = entry.getKey();
            int delta = entry.getValue();
            current += delta;
            if (current > max){
                maxYear = year;
                max = current;
            }
        }

        return maxYear;
    }
    
}
