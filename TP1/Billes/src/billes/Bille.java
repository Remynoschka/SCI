package billes;



import java.util.Random;

public class Bille extends Agent {
	private int x, y;
	private Direction direction;

	/**
	 * Cree une bille
	 */
	public Bille() {
		super();
		setRandomDirection();
	}

	/**
	 * Affecte une direction aleatoire a la bille
	 */
	public void setRandomDirection() {
		switch (new Random().nextInt(8)) {
		case 0:
			setDirection(Direction.NORD);
			break;
		case 1:
			setDirection(Direction.SUD_EST);
			break;
		case 2:
			setDirection(Direction.NORD_EST);
			break;
		case 3:
			setDirection(Direction.NORD_OUEST);
			break;
		case 4:
			setDirection(Direction.EST);
			break;
		case 5:
			setDirection(Direction.OUEST);
			break;
		case 6:
			setDirection(Direction.SUD);
			break;
		case 7:
			setDirection(Direction.SUD_OUEST);
			break;
		default:
			setDirection(Direction.NORD);
			break;
		}
	}

	@Override
	public void action() {

		if (nextCaseIsReachable()) {
			// System.out.println("move");
			move();
		} else {
			// MUR
			if (x == 0 || y == 0
					|| x == ((Grille) this.getEnvironnement()).getW() - 1
					|| y == ((Grille) this.getEnvironnement()).getH() - 1) {
				this.direction = Direction.getOppositeAngle(direction, this);
				if (nextCaseIsReachable()) {
					// System.out.println("move");
					move();
				}
			}
			// BILLE
			else {
				this.direction = Direction.getOpposite(direction);
				if (nextCaseIsReachable()) {
					// System.out.println("move");
					move();
				}
			}
			// System.out.println(x+"/"+y+" "+direction);
		}
	}

	/**
	 * Deplace la bille en fonction de la direction
	 */
	private void move() {
		switch (direction) {
		case NORD:
			((Grille) this.getEnvironnement()).moveBille(this, x, y - 1);
			break;
		case NORD_OUEST:
			((Grille) this.getEnvironnement()).moveBille(this, x - 1, y - 1);
			break;
		case NORD_EST:
			((Grille) this.getEnvironnement()).moveBille(this, x + 1, y - 1);
			break;
		case SUD:
			((Grille) this.getEnvironnement()).moveBille(this, x, y + 1);
			break;
		case SUD_EST:
			((Grille) this.getEnvironnement()).moveBille(this, x + 1, y + 1);
			break;
		case SUD_OUEST:
			((Grille) this.getEnvironnement()).moveBille(this, x - 1, y + 1);
			break;
		case EST:
			((Grille) this.getEnvironnement()).moveBille(this, x + 1, y);
			break;
		case OUEST:
			((Grille) this.getEnvironnement()).moveBille(this, x - 1, y);
			break;
		}
	}

	/**
	 * 
	 * @return true si la bille peut se rendre sur la prochaine case
	 */
	public boolean nextCaseIsReachable() {
		switch (direction) {
		case NORD:
			if (this.y != 0)
				return ((Grille) this.getEnvironnement()).isFree(x, y - 1);
			else {
				return (this.y > 0);
			}
		case NORD_OUEST:
			if (this.y != 0 && this.x != 0)
				return ((Grille) this.getEnvironnement()).isFree(x - 1, y - 1);
			else
				return this.y > 0 && this.x > 0;
		case OUEST:
			if (this.x != 0)
				return ((Grille) this.getEnvironnement()).isFree(x - 1, y);
			else
				return this.x > 0;
		case SUD_OUEST:
			if (this.y != ((Grille) this.getEnvironnement()).getH() - 1
					&& this.x != 0)
				return ((Grille) this.getEnvironnement()).isFree(x - 1, y + 1);
			else
				return this.x > 0
						&& this.y < ((Grille) this.getEnvironnement()).getH() - 1;
		case SUD:
			if (this.y != ((Grille) this.getEnvironnement()).getH() - 1)
				return ((Grille) this.getEnvironnement()).isFree(x, y + 1);
			else
				return this.y < ((Grille) this.getEnvironnement()).getH() - 1;
		case SUD_EST:
			if (this.y != ((Grille) this.getEnvironnement()).getH() - 1
					&& this.x != ((Grille) this.getEnvironnement()).getW() - 1)
				return ((Grille) this.getEnvironnement()).isFree(x + 1, y + 1);
			else
				return this.x < ((Grille) this.getEnvironnement()).getW() - 1
						&& this.y < ((Grille) this.getEnvironnement()).getH() - 1;
		case EST:
			if (this.x != ((Grille) this.getEnvironnement()).getW() - 1)
				return ((Grille) this.getEnvironnement()).isFree(x + 1, y);
			else
				return this.x < ((Grille) this.getEnvironnement()).getW() - 1;
		case NORD_EST:
			if (this.y != 0
					&& this.x != ((Grille) this.getEnvironnement()).getW() - 1)
				return ((Grille) this.getEnvironnement()).isFree(x + 1, y - 1);
			else
				return this.y > 0
						&& this.x < ((Grille) this.getEnvironnement()).getW() - 1;
		default:
			return ((Grille) this.getEnvironnement()).isFree(x, y);
		}
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

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
