package it.mulders.spark;

public class Greeting
{
    public final String text;
    public final long generated;

    public Greeting( final String text, final long generated )
    {
        this.text = text;
        this.generated = generated;
    }
}
