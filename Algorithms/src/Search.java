
public class Search
{
  public static void main( String[] args )
  {
    int[] arr  = {5, 4, 7, 2, 9, 3, 1};
    int[] arr2 = {4, 9, 12, 2, 6, 8, 18, 11, 22, 39, 0, 7, 13, 26, 32};
    Sort.insertionSort( arr2 );
    
    System.out.println( "Testing linear search on unsorted list... " );
    System.out.println( linear( 9, arr ) );
    System.out.println( linear( 99, arr ) );

    System.out.println( "Testing linear search on sorted list... " );
    System.out.println( linear( 8, arr2 ) );
    System.out.print( "Arr2: " );
    for( int i=0; i<arr2.length; i++ )
      System.out.print( arr2[i] + ", " );
    System.out.println();

    System.out.println( "Testing binary search on sorted list... " );
    System.out.println( binary( 18, arr2 ) );
    System.out.println( binary( 19, arr2 ) );
  }

  public static int linear( int target, int[] nums )
  {
    int found = -1;
    for( int i=0; i<nums.length; i++ )
    {
      if( nums[i] == target )
      {
        found = i;
        break;
      }
    }
    if( found > 0)
      return nums[found];
    else 
      return -1;
  }
  
  public static int binary( int target, int[] list )
  {
    boolean found = false;
    int min, mid, max;
    min = 0;
    max = list.length;
    mid = 0; // reset later
    
    // keep searching
    while( !found && min <= max )
    {
      // check middle element
      mid = ( min+max )/2;
      if( list[mid] == target )
        found = true;
      else
        if( list[mid] > target )
          max = mid-1;      // repeat on smaller half
        else
          min = mid+1;      // repeat on larger half
    }
    
    // return result
    if( found )
      return list[mid];
    else
      return -1;
  }
}
