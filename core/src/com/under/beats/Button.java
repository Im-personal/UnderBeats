package com.under.beats;

public class Button {

    private float pointX, pointY, Width, Height;

    public Button()
    {

    }

    public Button(float x, float y,float w, float h)
    {
        pointX = x;
        pointY = y;
        Width = w;
        Height = h;
    }

    public boolean isPressed()
    {
        float x = Mistener.ux;
        float y  = Mistener.uy;
        float mnX = Graph.mnX;
        float mnY = Graph.mnY;

        return (x>=pointX*mnX&&x<=(pointX+Width)*mnX&&y>=pointY*mnY&&y<=(pointY+Height)*mnY);
    }

    public boolean isPressed(float x, float y)
    {

        float mnX = Graph.mnX;
        float mnY = Graph.mnY;

        return (x>=(pointX*mnX)&&x<=((pointX+Width)*mnX) && y>=(pointY*mnY)&&y<=((pointY+Height)*mnY));
    }

    public  void printData()
    {
        System.out.println("X: "+pointX+" Y: "+pointY+" W: "+Width+"H: "+Height);
    }

}
