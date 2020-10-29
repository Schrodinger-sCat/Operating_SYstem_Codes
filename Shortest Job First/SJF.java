import java.util.Scanner;
public class SJF{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    process[] p=new process[5];
    process p0=new process("P0", 7, 12, false, 0, 0);
    process p1=new process("P1", 3, 10, false, 0, 0);
    process p2=new process("P2", 0, 20, false, 0, 0);
    process p3=new process("P3", 5, 13, false, 0, 0);
    process p4=new process("P4", 12, 6, false, 0, 0);
    p[0]=p0;
    p[1]=p1;
    p[2]=p2;
    p[3]=p3;
    p[4]=p4;
    for(int i=0; i<4; i++){
      for(int j=i+1; j<5; j++){
        if(p[j].bt<p[i].bt){
          process temp=p[i];
          p[i]=p[j];
          p[j]=temp;
        }
      }
    }
//    for(int i=0; i<5; i++){
//      System.out.println(p[i].name+" "+ p[i].at+" "+p[i].bt);
//    }
    int tt=0;
    boolean b=false;
    while(b!=true){
      int totaltime=tt;
      int flag=0;
      boolean f= true;
      for(int i=0; i<5; i++){
        if(p[i].at<=tt && p[i].state==false){
          System.out.println(p[i].name+" is served at "+tt);
          tt=tt+p[i].bt;
          p[i].tat=tt-p[i].at;
          p[i].wt=p[i].tat-p[i].bt;
          p[i].state=true;
        }
      }
      if(totaltime==tt){
        tt++;
      }
      for(int i=0; i<5; i++){
        f=f&p[i].state;
      }
      b=f;
    }
    System.out.println("average TAT: "+(p[0].tat+p[1].tat+p[2].tat+p[3].tat+p[4].tat)/5);
    System.out.println("average WT: "+(p[0].wt+p[1].wt+p[2].wt+p[3].wt+p[4].wt)/5);
    sc.close();
  }
}