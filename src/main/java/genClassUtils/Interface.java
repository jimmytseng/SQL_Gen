package genClassUtils;

public class Interface extends CommonClazz implements AutoGen {

	private String interfaceName = "";

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
		interfaceBuilder.append("");
		return null;
	}

}
