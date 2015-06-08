package arcanemaster.map;

public interface MapPattern {
	
	public AmTile[] build(AmTile[] map, int width, int height, boolean wrapWidth, boolean wrapHeight);

}
