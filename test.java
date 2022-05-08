public class test
{
   public static void main(String args [ ])
   {
      try
      {
         System.out.println("JJ");
         int result=15/0;
         System.out.println("JJ");
      }
      catch (ArithmeticException ex)
      {
         for(int i = 0; i <= 0; i++)
                  {
                  System.out.println("JJ");
                  }
      }
      finally
      {
         System.out.println("EB");
      }
   }
}