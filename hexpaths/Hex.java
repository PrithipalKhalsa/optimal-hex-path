package hexpaths;
public class Hex implements Comparable<Hex> {
    int current;
    int position;


    public Hex(int position, int current) {
         this.position = position;
         this.current = current;

     }
     public int printvalues(){
       System.out.print(this.position+" ");
       System.out.println(this.current);
       return 0;
     }
     @Override
         public int compareTo(Hex o) {
             return 0;
         }
}
