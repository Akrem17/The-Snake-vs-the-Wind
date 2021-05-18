package snake;

import java.util.ArrayList;
import java.util.Scanner;

public class Work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int n;
char wind;
int x;
int y;
do {
System.out.println("write the length of the squared area");
 n = in.nextInt();// length and width of the square area 
}while(n<2 || n>60);

do {
System.out.println("write the direction of the wind (e/n/w/s)");
wind=in.next().charAt(0); // direction of wind }while( || n>60);
}while(wind!='e' && wind!='n' && wind!='w' && wind !='s');

do {
System.out.println("write the starting position(x) of the snake (one of the corners) ");
x=in.nextInt(); //initial x position of the snake (one of the 4 corners)
}while(x!=0 && x!=n-1);

do {
System.out.println("write the starting position(y) of the snake (one of the corners) ");
 y=in.nextInt(); //initial y position of the snake (one of the 4 corners)
}while(y!=0 && y!=n-1);




ArrayList<String> coord = new ArrayList<String>(); //an array to save positions 
//a,b used to loop the square area incrementally  and decrementally 
int a=0;
int b=n;

//permut used as intermedial as a storage variable when switching a and b together to pass from incremntal to decremntal
int permut=0;

//index is  an index
int index=0;

//e is used to altern from ++ to -- in looping,it takes 1 or -1
int e=1;

//index for loop
int j=a;


//the path of the snake starting from the corner (x,y)=(0,0)
if(x==0 && y==0) { 
	
	
for(int i=0;i<n;i++) {
	//System.out.println();
		//this loop is dynamic, it goes from 0 to a(which represent the length of the area) and it can altern from a to 0 dynmacily using the same loop
		for (j=init(a,e);sup(j,b,e);j=j+e) {
			
			if(wind=='n' || wind=='s' ) {
				//System.out.println (i+" "+j);
				//in this condition the snake will takes the position (x,y)=(i,j)
				//we storage here the index of position of the snake everytime in the coord arrayList
				coord.add(String.valueOf(i) +String.valueOf(j));

			}else if(wind=='e' ||wind=='w' ) {
				//System.out.println (j+" "+index);
				//in this condition the snake will takes the position (x,y)=(j,index)
				//index represents an index
				coord.add(String.valueOf(j) +String.valueOf(index));

			}
		}
		
		//here we switch a and be to pass from increment to decrement depends on the move of the snake
		
	    permut=a;
	    a=b;
	    b=permut;
	    
	   //here will switch from j++(incrementing ) to j--(decrementing ) using e value    
	    e=e*-1;
	  
	    
	    index++;
	    
	    //the j loop will start from a value (a will be 0 or n )
	    j=a;
}
  
}
//the path of the snake starting from the corner (x,y)=(n-1,0)
else if (x==n-1 && y==0) {

	if(wind=='e' ||wind=='w') {
		//changing variables to start from decrementing (from n to 0 )
		 a=n;
		 b=0;
		 index=0;
		 e=-1;	
	}
	for(int i=n-1;i>=0;i--) {
		//System.out.println();
		//this loop is dynamic, it goes from 0 to a(which represent the length of the area) and it can altern from a to 0 dynmacily using the same loop
			for (j=init(a,e);sup(j,b,e);j=j+e) {
				if(wind=='n' || wind=='s' ) {
					//System.out.println (i+" "+j);
					
					//in this condition the snake will takes the position (x,y)=(i,j)
					//we storage here the index of position of the snake everytime in the coord arrayList
					coord.add(String.valueOf(i) +String.valueOf(j));
				}else if(wind=='e' ||wind=='w' ) {
					//System.out.println (j+" "+index);
					//in this condition the snake will takes the position (x,y)=(j,index)
					//index represents an index
					coord.add(String.valueOf(j) +String.valueOf(index));

				}
			}
			
			//here we switch a and be to pass from increment to decrement depends on the move of the snake

		    permut=a;
		    a=b;
		    b=permut;
			
		    //here will switch from j++(incrementing ) to j--(decrementing ) using e value    
		    e=e*-1;
		    index++;
		    
		    //the j loop will start from a value (a will be 0 or n )
		    j=a;
	}
}
//the path of the snake starting from the corner (x,y)=(0,n-1)
else if (x==0 && y==n-1) {	
	
	 if(wind=='n' || wind=='s' ) {
		 //changing variables to start from decrementing (from n to 0 )
		 a=n;
		 b=0;
		 index=0;
		 e=-1; 
	 }else { 
		 
		 //in this condition the index will decrement from n-1 to 0 
		 index=n-1;
	 }
	 
	 
	for(int i=0;i<n;i++) {	
		//System.out.println();
		
		//this loop is dynamic, it goes from 0 to a(which represent the length of the area) and it can altern from a to 0 dynmacily using the same loop
			for (j=init(a,e);sup(j,b,e);j=j+e) {
				if(wind=='n' || wind=='s' ) {
					//System.out.println (i+" "+j);
					//in this condition the snake will takes the position (x,y)=(i,j)
					//we storage here the index of position of the snake everytime in the coord arrayList
					coord.add(String.valueOf(i) +String.valueOf(j));

				}else if(wind=='e' ||wind=='w' ) {
					//System.out.println (j+" "+index);
					//in this condition the snake will takes the position (x,y)=(j,index)
					//index represents an index
					coord.add(String.valueOf(j) +String.valueOf(index));

				}
			}
			
			//here we switch a and be to pass from increment to decrement depends on the move of the snake
		    permut=a;
		    a=b;
		    b=permut;
		    
		    //here will switch from j++(incrementing ) to j--(decrementing ) using e value    
		    e=e*-1;    
		    
			 if(wind=='n' || wind=='s' ) {
				 index++;
			 }else {
				 
				 index--;
			 }
			 
			//the j loop will start from a value (a will be 0 or n )			 
		    j=a;

		
	}
}

//the path of the snake starting from the corner (x,y)=(n-1,n-1)
else if (x==n-1 && y==n-1) {	
	 //changing variables to start from decrementing (from n to 0 )
		 a=n;
		 b=0;
		 index=0;
		 e=-1; 	 
	for(int i=n-1;i>=0;i--) {
		//System.out.println();
		
		//this loop is dynamic, it goes from 0 to a(which represent the length of the area) and it can altern from a to 0 dynmacily using the same loop
			for (j=init(a,e);sup(j,b,e);j=j+e) {
				if(wind=='n' || wind=='s' ) {
					//System.out.println (i+" "+j);
					
					//in this condition the snake will takes the position (x,y)=(i,j)
					//we storage here the index of position of the snake everytime in the coord arrayList
					coord.add(String.valueOf(i) +String.valueOf(j));
				}else if(wind=='e' ||wind=='w' ) {
					//System.out.println (j+" "+i);
					
					//in this condition the snake will takes the position (x,y)=(j,i)
					coord.add(String.valueOf(j) +String.valueOf(i));
				}
			}	
			
			
			//here we switch a and be to pass from increment to decrement depends on the move of the snake
		    permut=a;
		    a=b;
		    b=permut;
		    
		    //here will switch from j++(incrementing ) to j--(decrementing ) using e value    
		    e=e*-1;	
		    
			index	++;
			
			//the j loop will start from a value (a will be 0 or n )			 	
		    j=a;
}
	}

//in this 2 loops we will convert the coord arraylist from positions(x,y) to paths 1,2,3 ... like the output asked for, then we print the output
	        for(int i=0; i< n; i++) {
	            for(int j1=0; j1< n; j1++) {
	            	
	                System.out.print(recherhe(i,j1,coord)+" " );	               
	            }
	            System.out.println("");
	        }

	}

	public static int recherhe(int x,int y,ArrayList coord) {
		//this function will  loop the coord arraylist that contains the path positions(x,y) of the snake and return the index of this position in a matrix
		
		for(int i=0;i<coord.size();i++) {
	        String cord=(String) coord.get(i);
			  int x1=Character.getNumericValue(cord.charAt(0));
		        int y1=Character.getNumericValue(cord.charAt(1));
			if(x1==x && y1==y) {
				
				return i+1;
			}
		}		
		return 0;
		
	}
	

	public static boolean sup(int j, int b,int e) {
		
		if(e>0) {
			return j<b;
		}else {
			return j>=b;
		}
		
	}

public int inc(int j, int e) {
			if(e>0) {
				return j++;
				
			}else {
				return j--;
			}
	
	}

public static int init(int a, int e) {
		if( e>0){
			return a ;
		}else {
			return a-1;
		}
	
}
	
}
