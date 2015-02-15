Hanoi Solution algorithm written in Java.
Can be integrated into a game to solve a game.
2011. Author: Achilleas Tzimis. London, UK.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

import java.util.*;

public class HanoiSolution{

public void shiftPegs(int[]initial,int[]finalOut,int pegCount){
    int pegCounter = 0;
    boolean match = false;
    List <Integer>spareBucket = new ArrayList<Integer>();
    LinkedList aa = new LinkedList();
     for(int h=initial.length-1;h>=0;h--){
       if(initial[h]==finalOut[h]){
       }else{
         match = false;
         for(int k=h;k>0;k--){
            if(initial[h] == initial[k-1]){
                match=true;
                pegCounter++;
                //put disc on spare peg
                if(usePeg(initial, pegCount)){       
                  spareBucket.add(initial[k-1]); // start location
                  spareBucket.add(pegCount);  // end location 
                }else{
                 //if there are more than 2 pegs then 
                 //move the one with less radius first.
                  spareBucket.add(initial[k-1]); //start location
                  spareBucket.add(initial[h+1]); //end location
                }  
            }else{
                 match=false; 
            }   
          }
          //no previuos same peg then just move it.
          if(!match){    
              aa.add(initial[h]+" "+finalOut[h]);
              pegCounter++;  
          }
        }
         //this block of code has to run before the  
         if((h==0) && (spareBucket.size()>0)){
             pegCounter++;
             aa.add(0,(spareBucket.get(0)+" "+spareBucket.get(1)));
             aa.add(spareBucket.get(1)+" "+finalOut[0]);
         }     
       }
       System.out.println(pegCounter);
       for(int s =0;s<aa.size();s++){
       System.out.println(aa.get(s));
   }
}

public boolean usePeg(int initial[], int count){
      boolean use = false;
      int max = initial[0];
      for (int ktr = 0; ktr < initial.length; ktr++) {
        if (initial[ktr] > max){
          max = initial[ktr];
        }
      }
      if(count>max)
      use = true;
      return use;
    }     
}       



 


