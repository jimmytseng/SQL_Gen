package genClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class ReflectClazz {

	protected Set<Annotation> annotation = new LinkedHashSet<>();

	public Set<Annotation> getAnnotation() {
		return annotation;
	}
	public void setAnnotation(Set<Annotation> annotation) {
		this.annotation = annotation;
	}

}
