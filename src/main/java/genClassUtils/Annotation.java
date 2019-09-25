package genClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Annotation implements AutoGen {

	public Annotation(String annotationName) {
		this.annotationName = annotationName;
	}

	protected String annotationName = "";

	protected Set<Method> methods = new LinkedHashSet<>();

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
		return annoBuilder.toString();
	}

}
