package projectd;

import java.awt.Insets;

public class Muur extends Item {
	private boolean _isInvicible;

    public Muur(Insets insets) {
        super(insets);
        width = 54;
        height = 38;
    }

	public void destroy() {
		throw new UnsupportedOperationException();
	}
}