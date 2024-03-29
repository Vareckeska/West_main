package union;

import haven.*;

import java.util.ArrayList;

import static haven.MCache.tileSize;


public class KerriUtils {
	
	public static ArrayList<Integer> iObj = new ArrayList<Integer>(); //ignored objects list
	
	//clears object ignoring lis
	public static void clearOL() {
		iObj.clear();
	}
	
	//adds new object for ignoring
	public static void addOL(Gob obj) {
		if(obj != null) { 
			Integer newId = Integer.valueOf(obj.id);
			if(!iObj.contains(newId))
				iObj.add(newId);
			}
	}

    public void addOL2(Gob obj) {
        if(obj != null) {
            Integer newId = Integer.valueOf(obj.id);
            if(!iObj.contains(newId))
                iObj.add(newId);
        }
        return;
    }
	
	//minimap panel button curio
	public static void makeButtonSC() {
		new IButton(new Coord(140, 8), UI.instance.minimappanel,
				Resource.loadimg("gfx/hud/buttons/curiosityu"), Resource.loadimg("gfx/hud/buttons/curiosityd")) {
			//Kerrigan
			//я в душе не ибу правильно ли это, я в яву не могу
			//оверрайд так через жопу подстанавливается автоматически, не ругайте меня, это хотябы вроде работает
			@Override
			public void setPushed(boolean pushed) {
				super.setPushed(Config.show_minimap_profits);
			}
			public void click() {
				Config.show_minimap_profits = !Config.show_minimap_profits;
				setPushed(Config.show_minimap_profits);
				UI.instance.slenhud.error("Show objects on minimap: "+Boolean.toString(Config.show_minimap_profits));
				Config.saveOptions();
			}
		}.tooltip = "Show different shit on minimap";
	}

	//minimap panel button other players
	public static void makeButtonOP() {
		new IButton(new Coord(160, 8), UI.instance.minimappanel, Resource.loadimg("gfx/hud/buttons/humanu"),
				Resource.loadimg("gfx/hud/buttons/humand")) {
			@Override
			public void setPushed(boolean pushed) {
				super.setPushed(Config.show_minimap_players);
			}
			public void click() {
				Config.show_minimap_players = !Config.show_minimap_players;
				setPushed(Config.show_minimap_players);
				UI.instance.slenhud.error("Show hearthlings on minimap: "+Boolean.toString(Config.show_minimap_players));
				Config.saveOptions();
			}
		}.tooltip = "Show other players on minimap";
	}
	
	//minimap panel button vision radius
	public static void makeButtonVR() {
		new IButton(new Coord(180, 8), UI.instance.minimappanel, Resource.loadimg("gfx/hud/buttons/radiusu"),
				Resource.loadimg("gfx/hud/buttons/radiusd")) {
			@Override
			public void setPushed(boolean pushed) {
				super.setPushed(Config.show_minimap_radius);
			}
			public void click() {

				Config.show_minimap_radius = !Config.show_minimap_radius;
				setPushed(Config.show_minimap_radius);
				UI.instance.slenhud.error("Show vision rect: "+Boolean.toString(Config.show_minimap_radius));
				Config.saveOptions();
			}
		}.tooltip = "Show vision radius on minimap";
	}
	
	//minimap panel buton object health
	public static void makeButtonOH() {
		new IButton(new Coord(200, 8), UI.instance.minimappanel, Resource.loadimg("gfx/hud/buttons/healthu"),
				Resource.loadimg("gfx/hud/buttons/healthd")) {
			@Override
			public void setPushed(boolean pushed) {
				super.setPushed(Config.show_gob_health);
			}
			public void click() {
				Config.show_gob_health = !Config.show_gob_health;
				setPushed(Config.show_gob_health);
				UI.instance.slenhud.error("Show objects health: "+Boolean.toString(Config.show_gob_health));
				Config.saveOptions();
			}
		}.tooltip = "Show objects health";
	}
	
	//draws players at minimap

	
	//draw vision square
	public static void drawVisSquare(GOut g, Coord tc, Coord hsz) {
		if(JSBotUtils.playerID == -1)
			return;
		if(UI.instance.minimap == null) return;
		Coord current; 
		if(JSBotUtils.getPlayerSelf() == null)
			current = new Coord(0, 0);
		else {
			if(JSBotUtils.getPlayerSelf() == null)
				current = new Coord(0, 0);
			else
				current = JSBotUtils.getPlayerSelf().position();
		}
		Coord ptc = current.div(tileSize).add(tc.inv()).add(hsz.div(2));
		g.chcolor(255, 255, 255, 64);
		g.frect(ptc.sub(42, 42), new Coord(85, 85));
		g.chcolor();
	}
	
	//
	public static boolean isTresspass(int s) {
		if(s==52465)
			return true;
		return false;
	}
	//
	public static boolean isTheft(int s) {
		if(s==53185)
			return true;
		return false;
	}
	//
	public static boolean isVandalism(int s) {
		if(s==62977)
			return true;
		return false;
	}
	//
	public static boolean isAssault(int s) {
		if(s==53057)
			return true;
		return false;
	}
	//
	public static boolean isBattery(int s) {
		if(s==62529)
			return true;
		return false;
	}
	//
	public static boolean isMurder(int s) {
		if(s==32961)
			return true;
		return false;
	}

}
