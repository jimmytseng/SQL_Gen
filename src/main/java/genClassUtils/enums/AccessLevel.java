package genClassUtils.enums;

public enum AccessLevel {

	PUBLIC("public"), DEFAULT(""), PROTECTED("protected"), PRIVATE("private");

	private String accessLevelText;

	public String getAccLevelText() {
		return accessLevelText;
	}

	public void setAccLevelText(String accessLevelText) {
		this.accessLevelText = accessLevelText;
	}

	private AccessLevel(String accessLevelText) {
		this.accessLevelText = accessLevelText;
	}

	public AccessLevel getEnumByText(String text) {
		String compareText = text.toLowerCase();
		switch (compareText) {
		case "public":
			return PUBLIC;
		case "":
			return DEFAULT;
		case "protected":
			return PROTECTED;
		case "private":
			return PRIVATE;
		default:
			throw new IllegalArgumentException();
		}
	}

	public String getTextByEnum(AccessLevel accessEnum) {
		switch (accessEnum) {
		case PUBLIC:
			return PUBLIC.getAccLevelText();
		case DEFAULT:
			return DEFAULT.getAccLevelText();
		case PROTECTED:
			return PROTECTED.getAccLevelText();
		case PRIVATE:
			return PRIVATE.getAccLevelText();
		default:
			throw new IllegalArgumentException();
		}
	}
}
