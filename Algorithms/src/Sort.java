public class Sort
{
  public static void main( String[] args )
  {
    int[] arr  = {5, 4, 7, 2, 9, 3, 1};
    int[] arr2 = {4, 9, 12, 2, 6, 8, 18};
    int i;

    System.out.println( "Original set of numbers ... " );
    for(i=0; i<arr.length; i++ )
      System.out.println( arr[i] );

    int[] rez = selectionSort( arr );
    System.out.println( "Sorted set of numbers ... " );
    for( i=0; i<rez.length; i++ )
      System.out.println( rez[i] );
    
    System.out.println( "Testing insertion sort... " );
    insertionSort( arr2 );
    System.out.println( "Sorted set of numbers ... " );
    for( i=0; i<arr2.length; i++ )
      System.out.println( arr2[i] );
  }

  public static int[] selectionSort( int[] numbers )
  {
    int i, j, min, temp;
    // 1. take each number (from left to right)
    for( i = 0; i < (numbers.length); i++ )
    {
      // 2. switch it with the smallest value in the remaining numbers
      // take the index of the i'th item
      min = i;

      // a. find the smallest value in the remaining numbers
      // find smallest value in remaining list
      for( j = (i + 1); j < numbers.length; j++ )
      {
        if( numbers[j] < numbers[min] )
          min = j;
      }
      System.out.println( "SS: " + numbers[i] + ", " + numbers[min] );

      // b. swap two values
      // swap the values
      temp = numbers[min];
      numbers[min] = numbers[i];
      numbers[i] = temp;
    }

    // 3. return the sorted array
    return numbers;
  }

  public static void insertionSort( int[] nums )
  {
    // 1. keep track of sorted sublist
    int sorted = 0;
    // 2. for each unsorted element
    for( int i=(sorted+1); i<nums.length; i++ )
    {
      // a. compare key with those in sorted sublist
      int key = nums[i];
      
      // b. keep shifting larger values unless we reach the top
      int position = i;
      while( position > 0 && nums[position-1] > key )
      {
        nums[position] = nums[position-1];
        position--;
      }

      // c. insert key when correct spot is found
      nums[position] = key;
    }
  }
}
