import java.util.*;
public class BankersAlgo{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Number of processes");
    int p=sc.nextInt();
    System.out.println("Number of resources");
    int r=sc.nextInt();
    int[][] max=new int[p][r];
    int[][] allo=new int[p][r];
    int[][] need=new int[p][r];
    int[] available=new int[r];
    int pr[]=new int[p];
    for(int i=0; i<p; i++){
      System.out.println("Max of P"+i);
      for(int j=0; j<r; j++){
        max[i][j]=sc.nextInt();
      }
    }
    for(int i=0; i<p; i++){
      System.out.println("Allocation of P"+i);
      for(int j=0; j<r; j++){
        allo[i][j]=sc.nextInt();
      }
    }
    System.out.println("Need Matrix");
    for(int i=0; i<p; i++){
      for(int j=0; j<r; j++){
        need[i][j]=(max[i][j]-allo[i][j]);
        System.out.print(need[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("Available resource");
    for(int i=0; i<r; i++){
      available[i]=sc.nextInt();
    }
    for(int i=0; i<p; i++){
      pr[i]=1;
    }
    int total=0;
    boolean b=false;
    while(b!=true){
      for(int k=0; k<p; k++){
        total=total+pr[k];
      }
      for(int i=0; i<p; i++){
        
        if(pr[i]==1){
          int t=0;
          for(int j=0; j<r; j++){
            if(available[j]-need[i][j]>=0){
              t++;
            }
          }
          if(t==r){
            System.out.println("P"+i+" completed");
            for(int j=0; j<r; j++){
              available[j]=available[j]+allo[i][j];
              System.out.print(available[j]+" ");
            }
            System.out.println();
            pr[i]=0;
          }
        }
      }
      int to=0;
      for(int j=0; j<p; j++){
        to=to+pr[j];
      }
      if(to==total){
        System.out.println("Deadlock");
        b=true;
      }
      if(to==0){
        b=true;
      }
    }
  }
}