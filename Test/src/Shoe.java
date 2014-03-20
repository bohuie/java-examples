public class Shoe implements Comparable
{
  private int size;
  private int gender;
  private static final int MALE = 0;
  
  public Shoe( int myGender, int mySize )
  {
    gender = myGender;
    size   = mySize;
  }

  public int getSize()   { return size; }
  public int getGender() { return gender; }

  public int compareTo( Object otherShoe )
  {
    Shoe other = ( Shoe )otherShoe;
    int rez = -1;
    if( gender == other.getGender() )
    {
      // within gender, just compare size
      if( size < other.getSize() )
        rez = -1;
      else if( size > other.getSize() )
        rez = 1;
      else
        rez = 0;
    }
    else
    {
      // compare across genders
      // male size always 2 sizes less
      if( gender == MALE )
        if( (size+2) == other.getSize() )
          rez = 0;
        else if( (size+2) > other.getSize() )
          rez = 1;
        else
          rez = -1;
      else
        if( size == ( other.getSize()+2 ))
          rez = 0;
        else if( size > ( other.getSize()+2 ))
          rez = 1;
        else
          rez = -1;
    }
    return rez;
  }
}
