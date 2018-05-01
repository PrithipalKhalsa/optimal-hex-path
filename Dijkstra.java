package Algorithm;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Dijkstra{
    private String inFile = "INPUT.txt";
    private String outFile = "output.txt";
    //private Hex[] honeycomb =  new Hex[234];


    public Dijkstra(){
        makehoneycomb();
    }

    // this will take the txt files and turn it into the link list from hell
    public void makehoneycomb(){
      try  (BufferedReader br = new BufferedReader(new FileReader(inFile))){
        for (String line = br.readLine(); line != null; line = br.readLine()) {
          System.out.println(line);
          //int pos= //parse int
          //int value; //parse int
          //honeycomb[i]=
          }
        }
       catch (IOException e) {
          e.printStackTrace();
      }
      }
      //take 234 inputs and make them hex objects


   //public void findbestpath(){
      // this is where the real math happens

  //}\

    public static void main(String[] args) {
      new Dijkstra();
    }
}
