public class Novel extends Reading
{
  private String mainCharacter;
  private String author;
  private String setting;

  public Novel( String title, int year, int numPages,  
      String auth, String set, String main )
  {
    super( title, year, numPages );
    mainCharacter = main;
    author = auth;
    setting = set;
  }

  public String getMainCharacter() { return mainCharacter; }
  public String getAuthor()        { return author; }
  public String getSetting()       { return setting; }
  public void setMainCharacter( String newMain ) { mainCharacter = newMain; }
  public void setAuthor( String newAuthor )      { author = newAuthor; }
  public void setSetting( String newSetting )    { setting = newSetting; }

  public String toString()
  {
    return super.toString() 
         + "Author: "         + author + "\n" 
         + "Setting: "        + setting + "\n"
         + "Main Character: " + mainCharacter + "\n";
  }
}