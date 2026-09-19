package util;
import java.io.*;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    //1.String input
    public static String readLine(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        return input;
    }

    //2. Integer input
    public static int readInt(String prompt) {
        System.out.print(prompt);
        int value = sc.nextInt();
        sc.nextLine();      //newline consume
        return value;
    }

    //3. Fast String input
    public static String readFast(String prompt) throws IOException {
        System.out.print(prompt);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }

    //4. Single char input
    public static char readChar(String prompt) throws IOException{
        System.out.print(prompt);
        int ch = System.in.read();
        return (char) ch;
    }


}
