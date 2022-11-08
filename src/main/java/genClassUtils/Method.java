package genClassUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import genClassUtils.enums.AccessLevel;
import genClassUtils.enums.DataType;
import genClassUtils.enums.NonAccessModifier;

public class Method extends ReflectClazz implements IsFinalCheck, IsStaticCheck, IsAbstractCheck {

	public Method(String methodName) {
		this.methodName = methodName;
	}

	public Method(String methodName, String content) {
		this.methodName = methodName;
		this.content = content;
	}

	public Method(String methodName, DataType returnType) {
		this.methodName = methodName;
		this.returnType = returnType;
	}

	public Method(String methodName, DataType returnType, String content) {
		this.methodName = methodName;
		this.content = content;
		this.returnType = returnType;
	}

	protected final static String startParentheses = "(";
	protected final static String endParentheses = ")";

	protected AccessLevel accessLevel = AccessLevel.PUBLIC;

	protected String methodName = "";

	protected DataType returnType = DataType.STRING;

	protected String content;

	protected String returnValue;

	protected Boolean isFinal = false;

	protected Boolean isStatic = false;

	protected Boolean isAbstract = false;

	protected Set<Parameter> parameters = new HashSet<>();

	@Override
	public String genCode() {
		StringBuilder methodBuilder = new StringBuilder();
		methodBuilder.append(changeLineAndSpace);
		if (this.annotation.size() > 0) {
			Iterator<Annotation> it = this.annotation.iterator();
			while (it.hasNext()) {
				methodBuilder.append(changeLineAndSpace);
				methodBuilder.append(it.next().genCode());
			}
			methodBuilder.append(changeLineAndSpace);
		}
		if (isAbstract)
			methodBuilder.append(NonAccessModifier.ABSTRACT.getModifer() + emptySpace);
		else
			methodBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);

		if (this.isStatic)
			methodBuilder.append(NonAccessModifier.STATIC.getModifer() + emptySpace);
		if (this.isFinal)
			methodBuilder.append(NonAccessModifier.FINAL.getModifer() + emptySpace);
		if (this.returnType == null) {
			methodBuilder.append("void ");
		} else {
			methodBuilder.append(this.returnType.getDataType() + emptySpace);
		}
		methodBuilder.append(GenStringUtil.firstToLower(this.methodName));
		methodBuilder.append(startParentheses);
		if (parameters.size() > 0) {
			Iterator<Parameter> it = parameters.iterator();
			Boolean commaFlag = false;
			while (it.hasNext()) {
				if (commaFlag) {
					methodBuilder.append(", ");
				}
				commaFlag = true;
				methodBuilder.append(it.next().genCode());
			}
		}
		methodBuilder.append(endParentheses);
		if (isAbstract)
			methodBuilder.append(";");
		else {
			methodBuilder.append(startCurl);
			methodBuilder.append(changeLineAndSpace);
			if (this.content != null) {
				methodBuilder.append("\t" + content);
				methodBuilder.append(";");
				methodBuilder.append(changeLineAndSpace);
			}
			methodBuilder.append(endCurl);
		}
		return methodBuilder.toString();
	}

	@Override
	public Boolean getIsFinal() {
		return isFinal;
	}

	@Override
	public void setIsFinal(Boolean isFianl) {
		this.isFinal = isFianl;
	}

	@Override
	public Boolean getIsStatic() {
		return isStatic;
	}

	@Override
	public void setIsStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Boolean getIsAbstract() {
		return isAbstract;
	}

	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Set<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(Set<Parameter> parameters) {
		this.parameters = parameters;
	}

	public DataType getReturnType() {
		return returnType;
	}

	public void setReturnType(DataType returnType) {
		this.returnType = returnType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
}
