package hexpaths;
public class Hex implements Comparable<Hex> {
    int current;
    int position;
    int row;
    int col;
    boolean n=true;
    boolean ne=true;
    boolean se=true;
    boolean s=true;
    boolean sw=true;
    boolean nw=true;

    public Hex(int pos, int cost) {
  		this.position = pos;
  		this.current = cost;
  	}


  public Hex(int position, int current, int row, int col){
        super();
         this.position = position;
         this.current = current;
         this.row = row;
         this.col = col;
         if (col==1){
           this.sw=this.nw=false;
         }
         if (col==8){
           this.se=this.ne=false;
         }
         if (row==1){
           this.n=false;
           if(col<=8){
             this.nw= this.ne=false;
           }
         }
        if (row==15 && col>8){
          this.s=false;
        }
        if(row==16){
          this.s=this.se=this.sw=false;
        }

     }


        @Override
         public int compareTo(Hex obj) {
         return this.current - obj.current;

         }
}
