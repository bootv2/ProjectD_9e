import java.util.Vector;

public class Speler extends BeweegbaarElement {
	private int _xCoordinate;
	private int _yCoordinate;
	private boolean _hasBazooka;
	private int _bazookaAmmo;
	private Sprite _sprite;
	public Rocket _unnamed_Rocket_;
	public Veld _unnamed_Veld_;
	public Vriend _unnamed_Vriend_;
	public Vector<Item> _picks_up = new Vector<Item>();

	public void schietBazooka() {
		throw new UnsupportedOperationException();
	}

	public void update() {
		throw new UnsupportedOperationException();
	}
}