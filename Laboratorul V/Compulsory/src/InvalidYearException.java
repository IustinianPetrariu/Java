public class InvalidYearException extends RuntimeException{
     public InvalidYearException(String message)
     {
         super(message);
     }

     public InvalidYearException(int year)
     {
         super("Invalid year: " + year);
     }
}
