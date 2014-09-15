package billes;



public enum Direction {
	NORD, NORD_OUEST, OUEST, SUD_OUEST, SUD, SUD_EST, EST, NORD_EST;

	/**
	 * Indique quelle est la direction opposee a celle passee en parametre
	 * 
	 * @param dir
	 *            : le direction dont on veut connaitre l'opposee
	 * @return la direction opposee
	 */
	public static Direction getOpposite(Direction dir) {
		switch (dir) {
		case NORD:
			return SUD;
		case NORD_OUEST:
			return SUD_EST;
		case OUEST:
			return EST;
		case SUD_OUEST:
			return NORD_EST;
		case SUD:
			return NORD;
		case SUD_EST:
			return NORD_OUEST;
		case EST:
			return OUEST;
		case NORD_EST:
			return SUD_OUEST;
		default:
			return NORD;
		}

	}

	/**
	 * Indique l'angle oppose en prenant en compte l'angle d'arrive de la bille
	 * 
	 * @param dir
	 *            : la direction d'arrive
	 * @param bille
	 *            : la bille en question
	 * @return la direction dans laquelle la bille repartira
	 */
	public static Direction getOppositeAngle(Direction dir, Bille bille) {
		switch (dir) {
		case NORD:
			return SUD;
		case NORD_OUEST:
			if (bille.getX() == 0) {
				if (bille.getY() == 0)
					return getOpposite(dir);
				return NORD_EST;
			} else
				return SUD_OUEST;
		case OUEST:
			return EST;
		case SUD_OUEST:
			if (bille.getX() == 0) {
				if (bille.getY() == ((Grille) bille.getEnvironnement()).getH() - 1)
					return getOpposite(dir);
				return SUD_EST;
			} else
				return NORD_OUEST;
		case SUD:
			return NORD;
		case SUD_EST:
			if (bille.getX() == ((Grille) bille.getEnvironnement()).getW() - 1) {
				if (bille.getY() == ((Grille) bille.getEnvironnement()).getH() - 1)
					return getOpposite(dir);
				return SUD_OUEST;
			} else {
				return NORD_EST;
			}
		case EST:
			return OUEST;
		case NORD_EST:
			if (bille.getX() == ((Grille) bille.getEnvironnement()).getW() - 1) {
				if (bille.getY() == 0)
					return getOpposite(dir);
				return NORD_OUEST;
			} else
				return SUD_EST;
		default:
			return SUD;
		}

	}
}
