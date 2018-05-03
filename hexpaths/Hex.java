package hexpaths;
public class Hex implements Comparable<Hex> {
    int current;
    int position;
    boolean topedge=false;
    boolean nexttopedge=false;
    boolean rightedge=false;
    boolean leftedge=false;
    boolean nextbottomedge=false;
    boolean bottomedge=false;

    public Hex(int position, int current) {
         this.position = position;
         this.current = current;

     }

     public int printvalues(){
       System.out.print(this.position+" ");
       System.out.print(this.current);
       System.out.println(this.bottomedge);
       return 0;
     }
     public int printgrid(){
       if (this.rightedge==true)
          System.out.println(this.position+" ");
       if (this.leftedge==true)
          System.out.print("   "+this.position);
      if ((this.leftedge==false)&&(this.rightedge==false))
          System.out.print("  "+this.position+"   ");

      return 0;
     }
     @Override
         public int compareTo(Hex o) {
             return 0;
         }
}
