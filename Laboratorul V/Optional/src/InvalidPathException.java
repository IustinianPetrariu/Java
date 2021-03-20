public class InvalidPathException extends RuntimeException {

    public InvalidPathException(String path)
    {
        super("your path is invalid: " + path);
    }

}
