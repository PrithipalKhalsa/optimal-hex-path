package hexpaths;
import java.io.*;
import java.nio.file.*;
import java.util.*;


public class Dijkstra {
    private String inFile = "INPUT.txt";
    private String outFile = "output.txt";
    private Hex[] honeycomb =  new Hex[234];


    public Dijkstra(){
        makehoneycomb();
    }



    //this finds the neighbors
    public Hex[] getEdges(Hex tile){
      int i=0;
      Hex[] edges= new Hex[6];
      if (tile.canNW()){
        edges[i]=honeycomb[tile.position-8];
        i++;
      }
      if (tile.canN()){
        edges[i]=honeycomb[tile.position-15];
        i++;
      }
      if (tile.canNE()){
        edges[i]=honeycomb[tile.position-7];
        i++;
      }
      if (tile.canSE()){
        edges[i]=honeycomb[tile.position+8];
        i++;
      }
      if (tile.canS()){
        edges[i]=honeycomb[tile.position+15];
        i++;
      }
      if (tile.canSW()){
        edges[i]=honeycomb[tile.position+7];
        i++;
      }

      return edges;
    }


    // this will take the txt files and turn it into an arrra
    public void makehoneycomb(){
      int row=0;
      //int j=1;
      try  (BufferedReader br = new BufferedReader(new FileReader(inFile))){
          int i=1;
          for (String line = br.readLine(); line != null; line = br.readLine()) {
              String[] temp = line.split(" ");
              honeycomb[i]= new Hex(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));

                if (honeycomb[i].position==1){
                  honeycomb[i].leftedge=true;
                  honeycomb[i].topedge=true;
                }
                if ((honeycomb[i].position<=8)&&(honeycomb[i].position !=1)){
                  honeycomb[i].topedge=true;

                  if (honeycomb[i].position==8)
                    honeycomb[i].rightedge=true;
                }
                if (honeycomb[i].position<=15 &&(honeycomb[i].position>8)){
                  honeycomb[i].nexttopedge=true;

                }
                if(((honeycomb[i].position-1)/8==row)&&(honeycomb[i].position>8)){
                  honeycomb[i].leftedge=true;

                }
                if(row>14){
                  honeycomb[i].nextbottomedge=true;
                  if(honeycomb[i].position>225){
                    if(honeycomb[i].position==226)
                        honeycomb[i].leftedge=true;
                    honeycomb[i].bottomedge=true;
                  }
                }
                if(((honeycomb[i].position-8)/15==row)&&(honeycomb[i].position>8)){
                  honeycomb[i].rightedge=true;
                  row++;
                }


            //  honeycomb[i].printvalues();

              i++;

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
