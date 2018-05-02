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

    dijktrasAlgorithm(Hex[] graph, int start, int end){
      int i;
      int v;
      int w;
      int weight;
      int distance;
      boolean[] intree = new boolean[234];
      int[] distance = new int[234];
      int[] parent = new int[234];
      for (int i = 1 ; i <= 233 ; i++){
       intree[i] = FALSE ;
       distance[i]=Integer.MAX_VALUE; //global const MAXINT=max integer
      parent[i] = -1 ;
      }
      distance[start] = 0 ;
      v = start ;
      while ( !intree[v] ){
        intree[v] = TRUE ;
        //maybe call get edges here
        // p = g-> edges[v] ;//these edges are the neighbors of the selected tile v
        while ( p != NULL ){
            w = p->y ;
            weight = p->weight ;
            if ( distance[w] > (distance[v] + weight) ) {
                distance[w] = distance[v] + weight ;
                parent[w] = v ;
            }
            p = p->next ;
          }
          v = 1 ;
          dist = MAXINT ;
          for ( i = 1 ; i <= g->nvertices ; i++ )
            if ( !intree[i] && (dist > distance[i]) ){
              dist = distance[i] ;
              v = i ;
            }
    }



    public Hex[] getEdges(Hex tile){
      int i=0;
      Hex[] edges= new Hex[6];
      if (honeycomb[tile.position+15] != null){
        edges[i]=honeycomb[tile.position+15];
        i++;
      }
    }

    // this will take the txt files and turn it into an arrra
    public void makehoneycomb(){

      try  (BufferedReader br = new BufferedReader(new FileReader(inFile))){
          int i=1;
          for (String line = br.readLine(); line != null; line = br.readLine()) {
              String[] temp = line.split(" ");
              honeycomb[i]= new Hex(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
              honeycomb[i].printvalues();
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
