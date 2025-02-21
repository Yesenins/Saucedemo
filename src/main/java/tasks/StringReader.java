package tasks;

import java.io.*;

public class StringReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\homework\\QA\\Saucedemo\\README.md")));
        String readString;
        while((readString = reader.readLine()) != null){
            System.out.println(readString);
        }
    }
}
