package genClassUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Method implements AutoGen, IsFinalCheck, IsStaticCheck, IsAbstractCheck {

	public Method() {

	}

	public Method(String methodName) {
		this.methodName = methodName;
	}

	public Method(String methodName, String content) {
		this.methodName = methodName;
		this.content = content;
	}

	public Method(String methodName, DataType returnType, String content) {
		this.methodName = methodName;
		this.content = content;
		this.returnType = returnType;
	}

	private final static String startParentheses = "(";
	private final static String endParentheses = ")";

	private AccessLevel accessLevel = AccessLevel.PUBLIC;

	private String methodName = "";

	private DataType returnType = DataType.STRING;

	private String content;

	private Boolean isFinal = false;

	private Boolean isStatic = false;

	private Boolean isAbstract = false;

	private Set<Parameter> parameters = new HashSet<>();

	@Override
	public String genCode() {
		StringBuilder methodBuilder = new StringBuilder();
		methodBuilder.append(changeLineAndSpace);
		if (isAbstract)
			methodBuilder.append("abstract ");
		else
			methodBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);

		if (this.isStatic)
			methodBuilder.append("static ");
		if (this.isFinal)
			methodBuilder.append("fianl ");
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
				methodBuilder.append(content);
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

}
