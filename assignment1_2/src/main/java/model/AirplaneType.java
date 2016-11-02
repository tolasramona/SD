package model;

public enum AirplaneType {
	JA045, SKR878, SKR854, IF7420616P, CG39006;

	@Override
	public String toString() {
		switch (this) {
		case JA045:
			return "JA045";
		case SKR878:
			return "SKR878";
		case SKR854:
			return "SKR854";
		case IF7420616P:
			return "IF7420616P";
		case CG39006:
			return "CG39006";

		default:
			throw new IllegalArgumentException();
		}
	}

}
