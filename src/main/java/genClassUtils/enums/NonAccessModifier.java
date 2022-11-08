package genClassUtils.enums;

public enum NonAccessModifier {

	FINAL("final"), STATIC("static"), ABSTRACT("abstract"), TRANSIENT("transient"), SYNCHRONIZED("synchronized"),
	VOLATILE("volatile");

	private String modifer;

	public String getModifer() {
		return modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer;
	}

	private NonAccessModifier(String modifer) {
		this.modifer = modifer;
	}

	public NonAccessModifier getEnumByText(String modifer) {
		String compareText = modifer.toLowerCase();
		switch (compareText) {
		case "final":
			return NonAccessModifier.FINAL;
		case "static":
			return NonAccessModifier.STATIC;
		case "abstract":
			return NonAccessModifier.ABSTRACT;
		case "transient":
			return NonAccessModifier.TRANSIENT;
		case "synchronized":
			return NonAccessModifier.SYNCHRONIZED;
		case "volatile":
			return NonAccessModifier.VOLATILE;
		default:
			throw new IllegalArgumentException();
		}
	}

	public String getTextByEnum(NonAccessModifier nonAccessModifier) {
		switch (nonAccessModifier) {
		case FINAL:
			return NonAccessModifier.FINAL.getModifer();
		case STATIC:
			return NonAccessModifier.STATIC.getModifer();
		case ABSTRACT:
			return NonAccessModifier.ABSTRACT.getModifer();
		case TRANSIENT:
			return NonAccessModifier.TRANSIENT.getModifer();
		case SYNCHRONIZED:
			return NonAccessModifier.SYNCHRONIZED.getModifer();
		case VOLATILE:
			return NonAccessModifier.VOLATILE.getModifer();
		default:
			throw new IllegalArgumentException();
		}
	}
}
