package useinterface;



public class Process {
   Stone [] stone = new Stone[70];
   Box [] box = new Box[12];
   Interface gi;

   public Process(Interface g){
		gi = g;
   }
   public void start(){
       for(int i=0;i<12;i++)   box[i] = new Box(gi,this,i);
       int count=0;
		for(int i=0;i<12;i++) {
			if(i!=5&&i!=11)
				for(int j=0;j<5;j++) {
					stone[count]=new Stone(gi,i);
					count++;
				}
			else 
				for(int j=0;j<10;j++) {
					stone[count]=new Stone(gi,i);
					count++;
				}
		}
   }
   public void resize() {
	// for(int i=0;i<12;i++) box[i].resize();
	// scBox[0].resize();
	// scBox[1].resize();
	for(int i=0;i<70;i++) stone[i].resize();
}
}
