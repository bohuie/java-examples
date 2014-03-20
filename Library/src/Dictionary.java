public class Dictionary extends SimpleBook
{
  private int    numDefs;
  private Word[] entries;
  private int    currWord;

  public Dictionary( int maxPages, int maxEntries )
  {
    super( maxPages );
    numDefs = maxEntries;
    entries = new Word[numDefs];
    currWord = 0;
  }

  public void addEntry( String entry, String pron, String defn )
  {
    Word vocab = new Word( entry, pron, defn );
    if( currWord < numDefs )
    {
      entries[ currWord ] = vocab;
      currWord++;
    }
  }
  
  public void addEntry( Word vocab )
  {
    if( currWord < numDefs )
    {
      entries[ currWord ] = vocab;
      currWord++;
    }
  }
  
  public int  getNumEntries()              { return currWord; }
  public void setNumDefs( int newNumDefs ) { numDefs = newNumDefs; }
  public int  getNumDefs()                 { return numDefs; }
}
