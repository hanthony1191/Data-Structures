import java.util.Scanner;

public class Sequence<E>{
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException();}
        this.data=new Object[n];
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public void append(E element){            
        if(this.size<this.data.length){
            this.data[this.size]=element;
        }
        else{
            Object[] temp=new Object[this.size+1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data=temp;
            this.data[this.size]=element;
        }
        this.size++;    
    }

    public Object get(int k) throws IndexOutOfBoundsException{
            if(k<0 || k>=this.size){
                throw new IndexOutOfBoundsException();}
            return this.data[k];
    }

	public void print(){
		System.out.print("\nCurrent Sequence: ");
		for(int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
        }
		System.out.println();
	}
	
    public void insert(int index, E newElement){
        //IMPLEMENT ME
        //Resourced from course document Arrays.java
        boolean insertMade = false;
        Object[] temp = new Object[this.size+1];

		for(int i=0;i<this.size;i++){
			if(i==index && !insertMade){
				temp[i]=newElement; 
				insertMade = true; 
				i--;
			}   
			else if(i>=index && insertMade){
				temp[i+1] = this.data[i];
            } 
			else{
				temp[i] = this.data[i];
			} 
		}
		
        this.data = temp;
        this.size++;
        this.print();
		System.out.println();
    }

	public void delete(int index){
        //IMPLEMENT ME
        //Resourced from course document Arrays.java
        Object[] temp = new Object[this.size()-1];
		for(int i=0;i<=temp.length;i++){
			if(i==index){continue;}
			else if(i>=index){
				temp[i-1] = this.data[i];
			}
			else{
				temp[i] = this.data[i];
			}
		}
        this.data = temp;
        this.size--;
        this.print();
		System.out.println();
	}
	
    public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		Sequence<Integer> s = new Sequence<Integer>(5);
		s.append(1);
		s.append(2);
		s.append(3);
		s.append(4);
		s.append(5);
		s.print();
		
        //INSERT CONTROL LOOP HERE
        boolean quit = false;
        while(quit == false){
            System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit.");
            int option = in.nextInt();

            if(option == 1){
                System.out.println("Please enter the value to insert.");
                Integer newElement = in.nextInt();

                System.out.println("Please enter the index to insert.");
                int index = in.nextInt();

                s.insert(index, newElement);
            }

            else if(option == 2){
                System.out.println("Please enter the index to delete.");
                int index = in.nextInt();

                s.delete(index);
            }

            else if(option == 3){
                quit = true;
                in.close();
                System.out.println("Goodbye");
            }

            else {
                System.out.println("Invalid choice");
            }
        }
        
    }   //End main
}   //End class