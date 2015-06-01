package projectd;

import java.awt.Insets;
import java.io.IOException;

public class Muur extends Item {
	private boolean _isInvicible;

    public Muur(String spritePath) throws IOException {
        setSprite(spritePath);
        width = 32;
        height = 24;
    }

	public void destroy() {
		throw new UnsupportedOperationException();
	}
}