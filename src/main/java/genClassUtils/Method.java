package genClassUtils;

import java.util.HashSet;
import java.util.Set;

public class Method implements AutoGen, IsFinalCheck, IsStaticCheck, IsAbstractCheck {

	private final static String startParentheses = "(";
	private final static String endParentheses = ")";

	private AccessLevel accessLevel = AccessLevel.PUBLIC;

	private String methodName = "";

	private DataType returnDataType

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
		methodBuilder.append(GenStringUtil.firstToLower(this.methodName) + emptySpace);
		methodBuilder.append(startParentheses);

		methodBuilder.append(endParentheses);
		methodBuilder.append(changeLine);
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

}
