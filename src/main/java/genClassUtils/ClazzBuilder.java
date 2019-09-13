package genClassUtils;

public class ClazzBuilder {

	private Clazz clazz = new Clazz();

	public ClazzBuilder(String clazzName) {
		this.clazz.setClassName(clazzName);
	}

	public ClazzBuilder addField(Field field) {
		this.clazz.getFieldSet().add(field);
		return this;
	}

	public ClazzBuilder addMethod(Method method) {
		this.clazz.getMethodSet().add(method);
		return this;
	}

	public ClazzBuilder addImplementInterfaces(Interface interfaceImpl) {
		this.clazz.getImplementInterfaces().add(interfaceImpl);
		return this;
	}

	public static void main(String[] args) {

	}

	public Clazz buildClazz() {

		return this.clazz;
	}

}
