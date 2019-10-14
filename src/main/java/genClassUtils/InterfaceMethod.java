package genClassUtils;

import java.util.Iterator;

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

//	@Override
//	public String genCode() {
//		StringBuilder methodBuilder = new StringBuilder();
//		methodBuilder.append(changeLineAndSpace);
//		if (this.annotation.size() > 0) {
//			Iterator<Annotation> it = this.annotation.iterator();
//			while (it.hasNext()) {
//				methodBuilder.append(changeLineAndSpace);
//				methodBuilder.append(it.next().genCode());
//			}
//			methodBuilder.append(changeLineAndSpace);
//		}
//		if (isAbstract)
//			methodBuilder.append("abstract ");
//		else
//			methodBuilder.append(this.accessLevel.getAccLevelText() + emptySpace);
//
//		if (this.isStatic)
//			methodBuilder.append("static ");
//		if (this.isFinal)
//			methodBuilder.append("fianl ");
//		if (this.returnType == null) {
//			methodBuilder.append("void ");
//		} else {
//			methodBuilder.append(this.returnType.getDataType() + emptySpace);
//		}
//		methodBuilder.append(GenStringUtil.firstToLower(this.methodName));
//		methodBuilder.append(startParentheses);
//		if (parameters.size() > 0) {
//			Iterator<Parameter> it = parameters.iterator();
//			Boolean commaFlag = false;
//			while (it.hasNext()) {
//				if (commaFlag) {
//					methodBuilder.append(", ");
//				}
//				commaFlag = true;
//				methodBuilder.append(it.next().genCode());
//			}
//		}
//		methodBuilder.append(endParentheses);
//		if (isAbstract)
//			methodBuilder.append(";");
//		else {
//			methodBuilder.append(startCurl);
//			methodBuilder.append(changeLineAndSpace);
//			if (this.content != null) {
//				methodBuilder.append("\t" + content);
//				methodBuilder.append(";");
//				methodBuilder.append(changeLineAndSpace);
//			}
//			methodBuilder.append(endCurl);
//		}
//		return methodBuilder.toString();
//
//	}

}
