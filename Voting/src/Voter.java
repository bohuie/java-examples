
public class Voter
{
   private String person;
   
   /**
    * constructor
    * @param name
    */
   public Voter( String name )
   {
     person = name;
   }
   
   /**
    * makes a vote on specific board
    * 
    * @param forum
    * @param num
    */
   public void castVote( Board forum, int num )
   {
     forum.vote( num );
     System.out.println( person + ", your vote has been casted in the ballot." );
   }
}
