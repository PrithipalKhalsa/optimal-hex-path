package hexpaths;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;


public class Dijkstra {
    private String inFile = "INPUT.txt";
    private String outFile = "output.txt";
    private Hex[] chart;


    public Dijkstra(){
      Hex[] bigchart=makechart();
      int[] path =calculatePath();
      outputFile(path);

    }
    private void outputFile(int[] minPath) {
      Path path = Paths.get(outFile);
      try(BufferedWriter writer = Files.newBufferedWriter(path)){
        int i = minPath[0];
        int distance = minPath[i++];
        while(i < minPath.length) {
          writer.write(minPath[i++] + "\n");
        }
        writer.write("Mimimal Path Cost = " + distance + "\n");

      }
      catch(IOException e) {
        e.printStackTrace();
      }

    }
    private int[] calculatePath() {
    			int [] path = new int[233];
    			int current = 0; //pointer to current hex
    			int [] parent = findMinPath(226,8);
    			int i = path.length - 1;
    			path[i--] = 8;
    			current = parent[8];
    			while(current != 226) {
    				path[i--] = current;
    				current = parent[current];
    			}

    			path[i--] = 266;
    			path[i] = parent[0];
    			path[0] = i;
    			return path;
    		}

    private int[] findMinPath(int start, int end) {
    			int i, v, w, weight;
    			PriorityQueue<Hex> tree = new PriorityQueue<>(233);
    			Deque<Hex> neighbors;
    			Hex currTile= new Hex(0,0,0,0);
    			boolean[] intree = new boolean[234];
    			int[] distance = new int[234];
    			int[] parent = new int[234];
    			for (i = 1; i <= 233; i++) {
    				distance[i] = Integer.MAX_VALUE;
    			}
    			currTile = chart[start];

    			distance[start] = currTile.current;

    			v = start;
    			while (!intree[v]) {
    				intree[v] = true;
    				currTile = chart[v];
    				neighbors = getNeighbors(currTile);
    				while (!neighbors.isEmpty()) {
    					currTile = neighbors.pop();
    					w = currTile.position;
    					weight = currTile.current;
    					if (distance[w] > (distance[v] + weight)) {
    						distance[w] = distance[v] + weight;
    						parent[w] = v;
    						tree.add(new Hex(w, distance[w],currTile.row,currTile.col));
    					}
    				}
    				if (tree.isEmpty() || v == end) {
    					parent[0] = distance[end];
    					return parent;
    				}
    				v = tree.poll().position;
    			}
    			return parent;

    		}
    //this finds the neighbors
    private Deque<Hex> getNeighbors(Hex tile){
      Deque<Hex> neighbors = new ArrayDeque<>(6);
      if (tile.nw){
        neighbors.push(chart[tile.position-8]);
      }
      if (tile.n){
        neighbors.push(chart[tile.position-15]);
      }
      if (tile.ne){
        neighbors.push(chart[tile.position-7]);
      }
      if (tile.se){
        neighbors.push(chart[tile.position+8]);
      }
      if (tile.s){
        neighbors.push(chart[tile.position+15]);
      }
      if (tile.sw){
        neighbors.push(chart[tile.position+7]);
      }

      return neighbors;
    }


    // this will take the txt files and turn it into an arrra
    public Hex[] makechart(){
      int row=1;
      int col=1;
      int pos;
      String[] temp;
      String line;
      chart = new Hex[234];
      try  (BufferedReader br = new BufferedReader(new FileReader(inFile))){
          int i=1;
          while(br.ready()) {
  					if(i > 233){
  						break;
  					}
              line = br.readLine();
              temp = line.split(" ");
              pos=Integer.parseInt(temp[0]);
              chart[pos]= new Hex(pos,Integer.parseInt(temp[1]), row, col);
              if (chart[i].col==15){
                row++;
                col=1;
              }
              else{
                col++;
              }
        
            i++;
          }

        }
       catch (IOException e) {
          e.printStackTrace();
      }
      return chart;
  }


      //take 234 inputs and make them hex objects


   //public void findbestpath(){
      // this is where the real math happens

  //}\

  public static void main(String[] args) {
     new Dijkstra();
  }
}
