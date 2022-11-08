package genClassUtils.method;

import java.util.Iterator;

import genClassUtils.annotation.Annotation;
import genClassUtils.annotation.MethodAnnotation;
import genClassUtils.enums.AccessLevel;
import genClassUtils.enums.DataType;
import genClassUtils.param.Parameter;
import genClassUtils.utility.GenStringUtil;

public class InterfaceMethod extends Method {

	public InterfaceMethod(String methodName) {
		super(methodName);
	}

	public InterfaceMethod(String methodName, DataType returnType) {
		super(methodName, returnType);
	}

	private boolean isDefaultMethod;

	public boolean isDefaultMethod() {
		return isDefaultMethod;
	}

	public void setDefaultMethod(boolean isDefaultMethod) {
		this.isDefaultMethod = isDefaultMethod;
	}

	private final AccessLevel accessLevel = AccessLevel.PUBLIC;

	@Override
	public String genCode() {
		StringBuilder methodBuilder = new StringBuilder();
		methodBuilder.append(changeLineAndSpace);
		if (this.annotation.size() > 0) {
			Iterator<MethodAnnotation> it = this.annotation.iterator();
			while (it.hasNext()) {
				methodBuilder.append(changeLineAndSpace);
				methodBuilder.append(it.next().genCode());
			}
			methodBuilder.append(changeLineAndSpace);
		}
		methodBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);
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
		methodBuilder.append(";");
		return methodBuilder.toString();
	}
}
