package question_1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Character, Integer> map= new HashMap<>();
    private static int lines_count, word_count, vowel_count;

    public static void main(String[] args) {
        try (
                Scanner line_sc= new Scanner(new File("input.txt"));
                Scanner word_sc= new Scanner(new File("input.txt"))
        ){
            while (line_sc.hasNextLine()) {
                lines_count++;
                line_sc.nextLine();
            }

            while (word_sc.hasNext()) {
                word_count++;
                word_sc.next();
            }

            StringBuilder builder=
                    new StringBuilder(new String(Files.readAllBytes(Paths.get("input.txt"))));

            for (int i= 0; i<builder.length(); i++) {
                char c= builder.charAt(i);

                if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                    vowel_count++;
                } else if (map.containsKey(c)) {
                    int value= map.get(c)+1;
                    map.put(c, value);
                } else if (c!='\n') {
                    map.put(c, 1);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        } finally {
            System.out.println("Lines count -> " +lines_count);
            System.out.println("Words count -> " +word_count);
            System.out.println("Vowel count -> " +vowel_count);
            System.out.println();
            System.out.println(map);
        }
    }
}
