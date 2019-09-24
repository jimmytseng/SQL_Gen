package genClassUtils;

public class Clazz extends CommonClazz implements AutoGen, IsFinalCheck {

	private String className = "";

	private Boolean isFinal = false;

	private AccessLevel accessLevel = AccessLevel.PUBLIC;

	private Clazz extendsClazz = null;

	@Override
	public String genCode() {
		StringBuilder clzzString = new StringBuilder();
		clzzString.append(changeLine);
		clzzString.append(this.accessLevel.getAccLevelText() + emptySpace);
		clzzString.append("class " + this.className);
		if (this.isSupportGeneric) {
			clzzString.append(this.genGenerics());
		}
		clzzString.append(emptySpace);
		if (extendsClazz != null) {
			clzzString.append("extends " + extendsClazz.getClassName());
			if (this.extendsClazz.isSupportGeneric) {
				clzzString.append(this.extendsClazz.genGenerics());
			}
			clzzString.append(emptySpace);
		}
		if (implementInterfaces.size() > 0) {
			clzzString.append("implements ");
			for (Interface interfaceImpl : this.implementInterfaces) {
				clzzString.append(interfaceImpl.getInterfaceName() + interfaceImpl.genGenerics());
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
		Field myfield = new Field("account");
		myfield.setDataType(DataType.BOOLEAN);
		Field myfield1 = new Field("address");
		Field myfield2 = new Field("name");
//		Method method = new Method("MyTestMethod", "MyContent");
//		method.setReturnType(null);
//		Parameter param = new Parameter("MyParam");
//		Parameter param2 = new Parameter("MyParam2");
//		method.getParameters().add(param);
		String clazz = new ClazzBuilder("MyClass").buildGetterSetter(myfield).buildGetterSetter(myfield1)
				.buildGetterSetter(myfield2).addGeneric("Long").buildClazz().genCode();

		System.out.print(clazz);
//		System.out.println(Clazz.class.getProtectionDomain());
//		System.out.println(Clazz.class.getProtectionDomain().getCodeSource());
//		System.out.println(Clazz.class.getProtectionDomain().getCodeSource().getLocation());
//		System.out.println(Clazz.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//		System.out.println(Clazz.class.getSimpleName());
//		File file = new File("");
//		System.out.println(file.getAbsolutePath() + "\\src\\main\\java\\entity");
//		File destFile = new File(file.getAbsolutePath() + "\\src\\main\\java\\entity");
//		if (!destFile.exists()) {
//			destFile.mkdirs();
//		}
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
	
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void addGetter(Field field) {
		Method getter = new Method("get" + GenStringUtil.firstToUpper(field.getFieldName()));
		getter.setReturnType(field.getDataType());
		getter.setContent("return " + field.getFieldName());
		this.methodSet.add(getter);
	}

	public void addSetter(Field field) {
		Method setter = new Method("set" + GenStringUtil.firstToUpper(field.getFieldName()));
		setter.setReturnType(null);
		Parameter setterParam = new Parameter(field.getDataType(), field.getFieldName());
		setter.getParameters().add(setterParam);
		setter.setContent("this." + field.getFieldName() + "=" + field.getFieldName());
		this.methodSet.add(setter);
	}

	public void addGetterSetter(Field field) {
		addGetter(field);
		addSetter(field);
	}
}
