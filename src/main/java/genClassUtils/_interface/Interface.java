package genClassUtils._interface;

import org.apache.commons.lang3.StringUtils;

import genClassUtils.AutoGen;
import genClassUtils.CommonClazz;
import genClassUtils.enums.AccessLevel;
import genClassUtils.method.InterfaceMethod;

public class Interface extends CommonClazz<InterfaceMethod> implements AutoGen {

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
		interfaceBuilder.append("package ");
		if (StringUtils.isNotBlank(packageName)) {
			interfaceBuilder.append(packageName);
		}
		interfaceBuilder.append(";");
		interfaceBuilder.append(changeLine);
		interfaceBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);
		interfaceBuilder.append("interface " + this.interfaceName);
		if (this.isSupportGeneric) {
			interfaceBuilder.append(this.genGenerics());
		}
		if (implementInterfaces.size() > 0) {
			interfaceBuilder.append("extends ");
			for (Interface interfaceImpl : this.implementInterfaces) {
				interfaceBuilder.append(interfaceImpl.getInterfaceName() + interfaceImpl.genGenerics());
			}
		}
		interfaceBuilder.append(startCurl);

		if (this.fieldSet.size() > 0) {
			fieldSet.forEach(field -> {
				interfaceBuilder.append(field.genCode());
			});
		}

		if (this.methodSet.size() > 0) {
			methodSet.forEach(method -> {
				interfaceBuilder.append(method.genCode());
			});
		}

		interfaceBuilder.append(changeLine);
		interfaceBuilder.append(endCurl);
		return interfaceBuilder.toString();
	}

}
