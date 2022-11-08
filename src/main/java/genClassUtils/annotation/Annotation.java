package genClassUtils.annotation;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import genClassUtils.AutoGen;
import genClassUtils.method.Method;

public class Annotation implements AutoGen {

	public Annotation(String annotationName) {
		this.annotationName = annotationName;
	}

	protected String annotationName = "";

	protected Set<Method> methods = new LinkedHashSet<>();

	public Set<Method> getMethods() {
		return methods;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
	}

	public String getAnnotationName() {
		return annotationName;
	}

	public void setAnnotationName(String annotationName) {
		this.annotationName = annotationName;
	}

	public String genCode() {
		StringBuilder annoBuilder = new StringBuilder();
		annoBuilder.append("@");
		annoBuilder.append(this.annotationName);
		if (this.methods.size() > 0) {
			annoBuilder.append("(");
			Iterator<Method> it = this.methods.iterator();
			while (it.hasNext()) {
				Method method = it.next();
				Boolean commaFlag = false;
				if (commaFlag) {
					annoBuilder.append(", ");
				}
				commaFlag = true;
				annoBuilder.append(method.getMethodName());
				annoBuilder.append("=");
				annoBuilder.append(method.getReturnValue());
			}
			annoBuilder.append(")");
		}
		return annoBuilder.toString();
	}

}
