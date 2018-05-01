package Algorithm;

public class Hex implements Comparable<Hex> {
    int current;
    int position;


    public Hex(int position, int current) {
         this.position = position;
         this.current = current;

     }
     @Override
         public int compareTo(Hex o) {
             return 0;
         }
}
