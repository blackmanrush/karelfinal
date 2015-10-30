import kareltherobot.*;
public class TreasureBot extends Robot implements Directions
{
    int beep;
  public TreasureBot(int st, int ave, Direction dir, int beeps)
    {
        super(st, ave, dir, beeps);
    }
    public static void main(String[] args)
    {
        World.reset();
        World.setDelay(1);
         World.setTrace(true);
        World.setVisible(true);
        TreasureBot tb= new TreasureBot(4,3,North,0);
    }
  
 public void turnRight(){
   turnLeft(); turnLeft(); turnLeft();
}
 private void faceNorth(){
     if(facingSouth()){
         turnLeft();
         turnLeft();
        }
     if(facingEast()){
         turnLeft();
        
        }
     if(facingWest()){
         turnRight();
        }
    } 
 private void faceSouth(){
     if(facingNorth()){
         turnLeft();
         turnLeft();
        }
     if(facingWest()){
         turnLeft();
        
        }
     if(facingEast()){
         turnRight();
        }
    } 
 private void faceWest(){
     if(facingEast()){
         turnLeft();
         turnLeft();
        }
     if(facingNorth()){
         turnLeft();
        
        }
     if(facingSouth()){
         turnRight();
        }
    } 
 private void faceEast(){
     if(facingWest()){
         turnLeft();
         turnLeft();
        }
     if(facingSouth()){
         turnLeft();
        
        }
     if(facingNorth()){
         turnRight();
        }
    }    
    public int countBeepers(){
    int beep=0;
    
      while(nextToABeeper()){
      pickBeeper();
      beep++;
    }
      
        return beep;
    }
    
    public void moveToNextClue(){
      int beep= countBeepers();
     
       if(beep==1){
         faceNorth();
         
        }
        
      if(beep==2){
          faceWest();
          
        }
        
      if(beep==3){
          faceSouth();
          
        }
        
      if(beep==4){
          faceEast();
          
        }
        
      if(beep==5){
          turnOff();
         
        }
    }
    public void work(){
       
         while(!nextToABeeper())
        {
            move();
         while(nextToABeeper()){
             moveToNextClue();
            }
        }
       
    
    }
}
        
              