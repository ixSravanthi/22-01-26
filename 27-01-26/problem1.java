import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class problem1 {
    public static void main(String[] args) {
        File file= new File("data2.txt");
        int total_words=0, total_sentence=0, total_char=0;
        HashMap<String,Integer> map= new HashMap<>();
        String sentence="";
        ArrayList<String> list=new ArrayList<>();

        try(Scanner sc= new Scanner(file)){
            while(sc.hasNextLine()){
                String data=sc.next();
                data=data.trim();
                sentence+=data+" ";
                System.out.print(data+" ");
                data=data.toLowerCase();

                //counting words
                total_words+=1;

                //counting sentences
                if(data.contains(".")){
                    total_sentence+=1;
                    list.add(sentence);
                    sentence="";
                }

                //counting characters
                total_char+=data.length();
                data=data.replace(",","");
                data=data.replace(".","");

                //counting occurance
                if(map.containsKey(data)){
                    map.put(data,map.get(data)+1);
                }
                else{
                    map.put(data, 1);
                }
            }
            //printing total number of words, sentences and characters
            System.out.println("\nTotal number of words: "+total_words);
            System.out.println("Total number of sentences: "+total_sentence);
            System.out.println("Total number of characters: "+total_char);

            //printing frequently occured first five words
            System.out.println("Frequently occured first five words: ");
            map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5).forEach(System.out::println);

            //printing reversed sentences
            Collections.reverse(list);
            for(String value: list){
                System.out.print(value+" ");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }

        //comparing strings
        
    }
}
