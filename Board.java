public class Board {
    private static int pieces;
    
    public static void populate(){
        //put a random number between 10 and 50 into pieces
        pieces = (int)(Math.random() * 40) + 10;
    }
    
    public static int getNumPieces(){
        return pieces; 
    }
    public static void removePieces(int remove){
        pieces = pieces - remove;
    }
}
