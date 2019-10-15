package genClassUtils;

public class Interface extends CommonClazz implements AutoGen {

	private String interfaceName = "";

	private final AccessLevel accessLevel = AccessLevel.PUBLIC;

	public Interface(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	@Override
	public String genCode() {
		StringBuilder interfaceBuilder = new StringBuilder();
		interfaceBuilder.append(changeLine);
		interfaceBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);
		interfaceBuilder.append("interface " + this.interfaceName);
		interfaceBuilder.append("");
		interfaceBuilder.append("");
		interfaceBuilder.append("");
		interfaceBuilder.append("");
		interfaceBuilder.append("");
		interfaceBuilder.append("");
		return interfaceBuilder.toString();
	}

}
