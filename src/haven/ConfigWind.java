package haven;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ConfigWind extends Window {
    Label text;
    boolean dm = false;
    Coord sc;
    Coord c1;
    Coord c2;
    private Button btnbot;
    public boolean recthit = false;
    public Color color;
    BufferedImage up, down, hover;
    public static Label AA, GC, DB;


    MapView mv;


    public  ConfigWind(Coord c, Widget parent) {
        super(c, new Coord(100, 50), parent, "Configs");
        cbtn.c.x = -9000;
        cbtn.c.y = -9000;
        int k;
        k = 10;



        //boolean Aggro = Config.autoaggro;

        GC = new Label(new Coord(10, 5), this, "GobColor:" + Config.GobColor);
        //Label LO = new Label(new Coord(10, 20), this, "GobColor:" + Config.GobColor);
        AA = new Label(new Coord(10, 20), this, "0");// "AutoAggro: " + Config.autoaggro);
        System.out.println(AA);
        //AA.settext("GobColor: " + Config.GobColor);
        //AA.
        DB = new Label(new Coord(10, 20+15), this, "0");





    }

    public void show() {
        super.show();

    }





    public void destroy() {
        super.destroy();
    }

    public static class Maker implements WidgetFactory {
        public Widget create(Coord c, Widget parent, Object[] args) {
            return new ConfigWind(c, parent);
        }
    }







}
