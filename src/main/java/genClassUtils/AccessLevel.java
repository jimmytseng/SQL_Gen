package genClassUtils;

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
		if (PUBLIC.getAccLevelText().equals(compareText)) {
			return PUBLIC;
		} else if (DEFAULT.getAccLevelText().equals(compareText)) {
			return DEFAULT;
		} else if (PROTECTED.getAccLevelText().equals(compareText)) {
			return PROTECTED;
		} else if (PRIVATE.getAccLevelText().equals(compareText)) {
			return PRIVATE;
		}
		return PUBLIC;
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
		}
		return "public";
	}
}
