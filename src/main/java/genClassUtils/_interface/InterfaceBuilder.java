package genClassUtils._interface;

import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.field.Field;
import genClassUtils.method.InterfaceMethod;

public class InterfaceBuilder {
	
	private Interface $interface = null;;
	
	public InterfaceBuilder(String interfaceName) {
		this.$interface = new Interface(interfaceName);
	}
	
	public InterfaceBuilder setPackageName(String packageName) {
		this.$interface.setPackageName(packageName);
		return this;
	}
	
	public InterfaceBuilder addField(Field field) {
		this.$interface.getFieldSet().add(field);
		return this;
	}
	
	public InterfaceBuilder addMethod(InterfaceMethod method) {
		this.$interface.getMethodSet().add(method);
		return this;
	}

	public InterfaceBuilder addAnnotation(ClazzAnnotation annotation) {
		this.$interface.getAnnotation().add(annotation);
		return this;
	}

	public InterfaceBuilder addGeneric(String genericType) {
		this.$interface.setIsSupportGeneric(true);
		this.$interface.getGenerics().add(genericType);
		return this;
	}
	
	public InterfaceBuilder addImplementInterfaces(Interface interfaceImpl) {
		this.$interface.getImplementInterfaces().add(interfaceImpl);
		return this;
	}


	public Interface buildInterface() {
		return this.$interface;
	}


}
