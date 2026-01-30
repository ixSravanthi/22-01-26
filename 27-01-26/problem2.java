import java.security.KeyStore.Entry;
import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        String[] employees= {"Ram","Shyam","Radha","Akhil","Anand","Shyam","Akhil"};

        //converting to arraylist
        ArrayList<String> list= new ArrayList<>(Arrays.asList(employees));

        //frequency counting
        HashMap<String,Integer> map= new HashMap<>();
        for(String value: employees){
            if(map.containsKey(value)){
                map.put(value,map.get(value)+1);
            }
            else{
                map.put(value,1);
            }
        }

        for(String value: list){
            System.out.print(value+" ");
        }

        //removing duplicates
        HashSet<String> set= new HashSet<>(Arrays.asList(employees));
        System.out.print("\n");
        Iterator<String> it= set.iterator();
        while(it.hasNext()){
            System.out.println(it.next()+" ");
        }
        
        for(Map.Entry<String, Integer> iter: map.entrySet()){
            System.out.println(iter.getKey()+" "+iter.getValue());
        }
    }
}
