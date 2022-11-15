package genClassUtils;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

import genClassUtils._interface.Interface;
import genClassUtils._interface.InterfaceBuilder;
import genClassUtils.annotation.Annotation;
import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.annotation.MethodAnnotation;
import genClassUtils.enums.ClazzAccessLevel;
import genClassUtils.enums.DataType;
import genClassUtils.field.Field;
import genClassUtils.method.ClazzMethod;
import genClassUtils.method.InterfaceMethod;
import genClassUtils.method.Method;
import genClassUtils.param.Parameter;
import genClassUtils.utility.GenStringUtil;

public class Clazz extends CommonClazz<ClazzMethod> implements IsFinalCheck, IsAbstractCheck {

	private String className = "";

	private Boolean isAbstract = false;

	private Boolean isFinal = false;

	private ClazzAccessLevel clazzAccessLevel = ClazzAccessLevel.PUBLIC;

	private Clazz extendsClazz = null;

	@Override
	public String genCode() {
		StringBuilder clzzString = new StringBuilder();
		clzzString.append("package ");
		if (StringUtils.isNotBlank(packageName)) {
			clzzString.append(packageName);
		}
		clzzString.append(";"+changeLine);
		for (String clazzImport : imports) {
			clzzString.append("import "+clazzImport+";"+changeLine);
		}
		clzzString.append(changeLine);
		if (this.annotation.size() > 0) {
			Iterator<ClazzAnnotation> it = this.annotation.iterator();
			while (it.hasNext()) {
				clzzString.append(changeLine);
				clzzString.append(it.next().genCode());
			}
			clzzString.append(changeLine);
		}
		if (this.isAbstract)
			clzzString.append("abstract ");
		clzzString.append(this.clazzAccessLevel.getAccLevelText() + emptySpace);
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
//		Field myfield = new Field("account");
//		myfield.setDataType(DataType.BOOLEAN);
//		Field myfield1 = new Field("address");
//		Field myfield2 = new Field("name");
//		ClazzMethod method = new ClazzMethod("MyTestMethod");
//		method.getAnnotation().add(new MethodAnnotation("Overrid"));
//		method.setReturnType(null);
//		Parameter param = new Parameter("MyParam");
//		Parameter param2 = new Parameter("MyParam2");
//		method.getParameters().add(param);
//		method.getParameters().add(param2);
//		String clazz = new ClazzBuilder("MyClass").setPackageName("genClassUtils").addAnnotation(new ClazzAnnotation("Entity")).buildGetterSetter(myfield)
//				.buildGetterSetter(myfield1).buildGetterSetter(myfield2).addMethod(method).addGeneric("Long")
//				.buildClazz().genCode();
//
//		System.out.print(clazz);

		// Interface
//		Interface interClazz = new Interface("MyInterface");
		Interface extendsInterface = new Interface("JpaRepository");
		extendsInterface.getGenerics().add("CPCDeviceInfoEntity");
		extendsInterface.getGenerics().add("Integer");
//		interClazz.getImplementInterfaces().add(extendsInterface);
		InterfaceMethod method1 = new InterfaceMethod("MyTestMethod");
//		interClazz.getMethodSet().add(method1);
//		System.out.println(interClazz.genCode());

		InterfaceBuilder builder = new InterfaceBuilder("MyInterface");
		Interface myInterface = builder.addImplementInterfaces(extendsInterface).setPackageName("genClassUtils")
				.addMethod(method1).buildInterface();
		System.out.println(myInterface.genCode());
	}

	@Override
	public Boolean getIsFinal() {
		return isFinal;
	}

	@Override
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public Boolean getIsAbstract() {
		return isAbstract;
	}

	@Override
	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ClazzAccessLevel getClazzAccessLevel() {
		return clazzAccessLevel;
	}

	public void setClazzAccessLevel(ClazzAccessLevel accessLevel) {
		this.clazzAccessLevel = accessLevel;
	}

	public void addGetter(Field field) {
		ClazzMethod getter = new ClazzMethod("get" + GenStringUtil.firstToUpper(field.getFieldName()));
		getter.setReturnType(field.getDataType());
		getter.setContent("return " + field.getFieldName());
		this.methodSet.add(getter);
	}

	public void addSetter(Field field) {
		ClazzMethod setter = new ClazzMethod("set" + GenStringUtil.firstToUpper(field.getFieldName()));
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
