package genClassUtils.enums;

public enum ClazzAccessLevel {

	PUBLIC("public"), DEFAULT("");

	private String accessLevelText;

	public String getAccLevelText() {
		return accessLevelText;
	}

	public void setAccLevelText(String accessLevelText) {
		this.accessLevelText = accessLevelText;
	}

	private ClazzAccessLevel(String accessLevelText) {
		this.accessLevelText = accessLevelText;
	}

	public ClazzAccessLevel getEnumByText(String text) {
		String compareText = text.toLowerCase();
		if (PUBLIC.getAccLevelText().equals(compareText)) {
			return PUBLIC;
		} else if (DEFAULT.getAccLevelText().equals(compareText)) {
			return DEFAULT;
		}
		return PUBLIC;
	}

	public String getTextByEnum(ClazzAccessLevel clazzModifier) {
		switch (clazzModifier) {
		case PUBLIC:
			return PUBLIC.getAccLevelText();
		case DEFAULT:
			return DEFAULT.getAccLevelText();
		default:
			throw new IllegalArgumentException();
		}
	}

}
