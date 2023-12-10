public class InvalidSpaceException extends Exception {

    private char spaceIdentifier = '?';

    public InvalidSpaceException(char invalidSpace) {

        spaceIdentifier = invalidSpace;

        System.out.println("Invalid space: " + invalidSpace);
    }

    private InvalidSpaceException() {
        System.out.println("Invalid space");
    }

    public String toString() {
        return ("Attempted to create space with invalid space argument" + "" + this.spaceIdentifier);
    }

    public char getSpaceIdentifier() {
        return spaceIdentifier;
    }

} // End class
