package billes;

public class Bille extends Agent {
	private int x, y;

	public Bille() {
		super();
	}

	public Bille(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "X : " + x + " / Y : " + y;
	}
}
