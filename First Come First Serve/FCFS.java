import java.util.Scanner;
public class FCFS{
  public static void main(String[]args){
    System.out.println("How many processes?");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] at=new int[n];
    int[] bt=new int[n];
    int[] cat=new int[n];
    for(int i=0; i<n; i++){
      System.out.println("Arrival time for P"+i+" ?");
      at[i]=sc.nextInt();
      cat[i]=at[i];
      System.out.println("Burst time for P"+i+" ?");
      bt[i]=sc.nextInt();
    }
    for(int i=0; i<n-1; i++){
      for(int j=i+1; j<n; j++){
        if(at[j]<at[i]){
          int temp1=at[i];
          int temp2=bt[i];
          at[i]=at[j];
          bt[i]=bt[j];
          at[j]=temp1;
          bt[j]=temp2;
        }
      }
    }
//    for(int i=0; i<n; i++){
//      System.out.println(at[i]+" "+bt[i]);
//    }
    int[] tat=new int[n];
    tat[0]=at[0];
    int ot=0;
    for(int i=1; i<n; i++){
      ot= ot+bt[i-1];
      if(ot>=at[i]){
        tat[i]=ot;
      }
      else{
        tat[i]=at[i];
      }
    }
    for(int i=0; i<n; i++){
      int wt=tat[i]-at[i];
      System.out.println("response time="+tat[i]+" waiting time="+wt);
    }
    sc.close();
  }
}