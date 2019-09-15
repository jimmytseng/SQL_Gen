package genClassUtils;

import java.util.HashSet;
import java.util.Set;

public class Clazz implements AutoGen, IsFinalCheck {

	private String className = "";

	private Boolean isFinal = false;

	private AccessLevel accessLevel = AccessLevel.PUBLIC;

	private Set<Field> fieldSet = new HashSet<>();

	private Set<Method> methodSet = new HashSet<>();

	private Set<Interface> implementInterfaces = new HashSet<>();

	private Clazz extendsClazz = null;

	@Override
	public String genCode() {

		StringBuilder clzzString = new StringBuilder(this.accessLevel.getAccLevelText() + emptySpace);
		clzzString.append("class " + this.className + emptySpace);
		if (extendsClazz != null) {
			clzzString.append("extends " + extendsClazz.getClassName() + emptySpace);
		}
		if (implementInterfaces.size() > 0) {
			clzzString.append("implements ");
			for (Interface interfaceImpl : this.implementInterfaces) {
				clzzString.append(interfaceImpl.getInterfaceName());
			}
		}

		clzzString.append(startCurl);
		clzzString.append(changeLineAndSpace);

		if (this.fieldSet.size() > 0) {
			fieldSet.forEach(field -> {
				clzzString.append(field.genCode());
			});
		}

		if (this.methodSet.size() > 0) {
			methodSet.forEach(method -> {
				clzzString.append(method.genCode());
			});
		}

		clzzString.append(changeLine);
		clzzString.append(endCurl);
		return clzzString.toString();
	}

	public static void main(String[] args) {

		Method method = new Method("MyTestMethod", "MyContent");
		method.setReturnType(null);
		Parameter param = new Parameter("MyParam");
		Parameter param2 = new Parameter("MyParam2");
		method.getParameters().add(param);
		method.getParameters().add(param2);
		String clazz = new ClazzBuilder("MyClass").addField(new Field("MyTestFiled")).addMethod(method).buildClazz()
				.genCode();
		System.out.print(clazz);
	}

	@Override
	public Boolean getIsFinal() {
		return isFinal;
	}

	@Override
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Field> getFieldSet() {
		return fieldSet;
	}

	public void setFieldSet(Set<Field> fieldSet) {
		this.fieldSet = fieldSet;
	}

	public Set<Method> getMethodSet() {
		return methodSet;
	}

	public void setMethodSet(Set<Method> methodSet) {
		this.methodSet = methodSet;
	}

	public Set<Interface> getImplementInterfaces() {
		return implementInterfaces;
	}

	public void setImplementInterfaces(Set<Interface> implementInterfaces) {
		this.implementInterfaces = implementInterfaces;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

}
