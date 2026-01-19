package tonpere.tamerecestjava;

import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class UI
{
    public static void setScreenResolution(int width, int height)
    {
        UI.Screen = new UI(width, height);
    }
    private static UI Screen;

    protected boolean visible;

    public void setVisible(boolean value)
    {
        visible = value;
    }

    public void hide(boolean value)
    {
        visible = !value;
    }

    protected UI parent;
    protected List<UI> childs;

    protected Rectangle rect, margin, padding;
    protected float layer;
    protected Bounds position;

    protected UI()
    {
        rect = new Rectangle(0, 0, 32, 32);
        parent = Screen;
    }

    protected UI(float width, float height)
    {
        margin = new Rectangle(0, 0, 0, 0);
        padding = new Rectangle(0, 0, 0, 0);
        rect = new Rectangle(0, 0, width, height);
        parent = Screen;
    }

    protected UI(int width, int height, Bounds position)
    {
        this(width, height);
        this.setPosition(position);
    }

    public void setSize(int width, int height)
    {
        rect.width = width;
        rect.height = height;
    }

    public void setSize(Extend extend)
    {
        if (extend.x)
        {
            rect.width = parent.rect.width - parent.padding.x - parent.padding.width;
        }
        if (extend.y)
        {
            rect.height = parent.rect.height - parent.padding.y - parent.padding.height;
        }
    }

    public void setSize(int width, int height, Extend extend)
    {
        setSize(extend);
        setSize(width, height);
    }

    public void setSize(Extend extend, int addWidth, int addHeight)
    {
        setSize(extend);
        rect.width += addWidth;
        rect.height += addHeight;
    }


    public void setPosition(Bounds position)
    {
        this.position = position;
        if (position.x == 0) // gauche
        {
            rect.x = parent.rect.x + parent.padding.x + margin.x;
        }
        else if (position.x == 1) // centre
        {
            rect.x = (parent.rect.width - this.rect.width) / 2;
        }
        else // droite
        {
            rect.x = parent.rect.x + parent.rect.width - this.rect.width - margin.width - parent.margin.width;
        }

        if (position.y == 0) // bas
        {
            rect.y = parent.rect.y + parent.padding.y + margin.y;
        }
        else if (position.y == 1) // centre
        {
            rect.y = (parent.rect.height - this.rect.height) / 2;
        }
        else // haut
        {
            rect.y = parent.rect.y + parent.rect.height - this.rect.height - margin.height - parent.margin.height;
        }
    }

    public void updatePosition()  // à faire quand la taille de l'écran change
    {
        this.setPosition(this.position);
        for (UI c : childs)
        {
            c.updatePosition();
        }
    }
}
