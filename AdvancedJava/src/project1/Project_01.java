package advJava;

/*--------------------------------------------------------------------------------------------------------------------------------------
CLASS: Main (Main.java)

Descrpition:
This file comtains the class and related methods used to properly count and give the number of runs of 
motonocially increasing/decreasing integers within a given source file. 

Course and Project Info:
CSE-205 Object Oriented Programming and Data Structures, Summer 2017
Project Number: 1

Author:
John Z. Orr (john.z.orr@asu.edu or zac.orr@gmail.com)
--------------------------------------------------------------------------------------------------------------------------------------*/

package project1;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 *
 * @author zac
 */
/*
----------------------------The main method where all code is called-----------------------------------------------
*/
public class Project_01{
    
    public static void main(String[] args) throws FileNotFoundException {   
        Project_01 mainObject = new Project_01();
        mainObject.run();        
    } // end main 
    
/*
-------------------This is the run() method with the meat and potatoes of the project.---------------------------------   
*/
    private void run() throws FileNotFoundException{      
       ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scan = new Scanner(new File("p01-in.txt"))) {           
            while(scan.hasNext()){
                list.add(scan.nextInt());                      
            }
        }  

        ArrayList<Integer> listRunsUpCount = new ArrayList<>();
        listRunsUpCount = FindRunsUp(list);
        
        ArrayList<Integer> listRunsDnCount = new ArrayList<>();
        listRunsDnCount = FindRunsDn(list);
        
        ArrayList<Integer> listRunsCount = new ArrayList<>();
        listRunsCount = Merge(FindRunsUp(list), FindRunsDn(list));
        
        File file = new File("p01-runs.txt");
        Output(file, listRunsCount);     
    }// end run
    
/*
------------------FindsRuns() will be used to find the number of k at each element in a monotonically increasing order---------------------
*/   
   private static ArrayList<Integer> FindRunsUp(ArrayList<Integer> pList){
        ArrayList<Integer> listRunsUpCount = arrayListCreate(pList.size(), 0);
        int i = 0, k = 0; 
        while (i < pList.size()-1){
            if (pList.get(i) <= pList.get(i+1)){
                k++;
            }  else if (k != 0){ 
                int oldValue = listRunsUpCount.get(k);
                oldValue++;              
                listRunsUpCount.set(k,oldValue);              
                k = 0;
                }
            i++;        
        }
        if (k!= 0){
            int oldValue = listRunsUpCount.get(k);
            oldValue++;
            listRunsUpCount.set(k,oldValue);
        }                  
      return listRunsUpCount;
    }// end FindRunsUp
   
/*
   --------------FindRunsDn is used to find the number of k at each element in a monotonically decreasing order--------   
*/
        private static ArrayList<Integer> FindRunsDn(ArrayList<Integer> pList){
            ArrayList<Integer> listRunsDnCount = arrayListCreate(pList.size(), 0);       
             int i = 0, k = 0;      
             while (i < pList.size()-1){
                 if (pList.get(i) >= pList.get(i+1)){
                     k++;
                 }  else if (k != 0){ 
                     int oldValue = listRunsDnCount.get(k);
                     oldValue++;              
                     listRunsDnCount.set(k,oldValue);             
                     k = 0;
                     }
                 i++;        
             }
             if (k!= 0){
                 int oldValue = listRunsDnCount.get(k);
                 oldValue++;
                 listRunsDnCount.set(k,oldValue);
             }                  
           return listRunsDnCount;
         }// end FindRunsDn

     /*
     ------------------Merge() will be used to find the total number of runs for each k value-------------------------------
     */ 
       private static ArrayList<Integer> Merge(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount) {
           ArrayList<Integer> listRunsCount = arrayListCreate(pListRunsUpCount.size(), 0);
             for (int i = 0; i < pListRunsUpCount.size()-1; i++) {
               int x = pListRunsUpCount.get(i);
               int y = pListRunsDnCount.get(i);
               listRunsCount.set(i, x+y);         
           }
         return listRunsCount;   
       }//end Merge

     /*
     ------------------arrayListCreate() will be used to create the number of lements and set initial values-------------------------------
     */ 
      private static ArrayList<Integer> arrayListCreate(int pSize, int pInitValue){
          ArrayList<Integer> list = new ArrayList<>();     // this initiates the ArrayList with a 0 at each element with he size of the pList entered   
             for (int i = 0; i < pSize; i++) {
                 list.add(pInitValue);          
             } 
             return list;
      }//end arrayListCreate

     /*
     ------------------Output() will be used to find the number of runs for each k value-------------------------------
     */ 
     private void Output(File pFileName, ArrayList<Integer> pListRuns) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(pFileName);
        out.print("runs_total: " + sumOfRuns(pListRuns) + "\n");
        for (int k = 1; k < pListRuns.size()-1; k++){
            out.print("runs_" + k + ": " + pListRuns.get(k) + "\n");
        }
        out.close();         
     }//end Output

     /*
     ----------------------This is an extra method used to sum the elements of the given ArrayList------------------ 
     */

     private static int sumOfRuns(ArrayList<Integer> pList){
         int s = 0;
         for (int i : pList){
           s += i;        
         }
       return s;
     }//end sumOfRuns
}  //end Main class