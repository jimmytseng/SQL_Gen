package genClassUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import genClassUtils._interface.Interface;
import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.field.Field;
import genClassUtils.method.Method;

public abstract class CommonClazz<T extends Method> extends ReflectClazz<ClazzAnnotation> {

	protected String packageName = "";
	
	protected Set<String> imports = new HashSet<>();

	protected Set<String> generics = new LinkedHashSet<>();

	protected Set<Interface> implementInterfaces = new HashSet<>();

	protected Set<Field> fieldSet = new LinkedHashSet<>();

	protected Set<T> methodSet = new LinkedHashSet<>();

	protected Boolean isSupportGeneric = false;
	

	public Set<String> getImports() {
		return imports;
	}

	public void setImports(Set<String> imports) {
		this.imports = imports;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Set<String> getGenerics() {
		return generics;
	}

	public void setGenerics(Set<String> generics) {
		this.generics = generics;
	}

	public Set<Interface> getImplementInterfaces() {
		return implementInterfaces;
	}

	public void setImplementInterfaces(Set<Interface> implementInterfaces) {
		this.implementInterfaces = implementInterfaces;
	}

	public void addImplementInterfaces(Set<Interface> implementInterfaces) {
		this.implementInterfaces.addAll(implementInterfaces);
	}

	public Set<Field> getFieldSet() {
		return fieldSet;
	}

	public void setFieldSet(Set<Field> fieldSet) {
		this.fieldSet = fieldSet;
	}

	public void addFields(Set<Field> fieldSet) {
		this.fieldSet.addAll(fieldSet);
	}

	public Set<T> getMethodSet() {
		return methodSet;
	}

	public void setMethodSet(Set<T> methodSet) {
		this.methodSet = methodSet;
	}

	public void addMethods(Set<T> methodSet) {
		this.methodSet.addAll(methodSet);
	}

	public Boolean getIsSupportGeneric() {
		return isSupportGeneric;
	}

	public void setIsSupportGeneric(Boolean isSupportGeneric) {
		this.isSupportGeneric = isSupportGeneric;
	}

	protected String genGenerics() {
		StringBuilder genericsBuilder = new StringBuilder();
		genericsBuilder.append("<");
		Iterator<String> it = this.generics.iterator();
		Boolean commaFlag = false;
		while (it.hasNext()) {
			if (commaFlag) {
				genericsBuilder.append(",");
			}
			commaFlag = true;
			genericsBuilder.append(it.next());
		}
		genericsBuilder.append(">");
		return genericsBuilder.toString();
	}

}
