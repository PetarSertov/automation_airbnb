package utils;

public enum OrdinalNumbers {

    FIRST( 0 ),
    SECOND( 1 ),
    THIRD( 2 );

    private int value;

    OrdinalNumbers( int value )
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

}
