package genClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

import genClassUtils.annotation.Annotation;

public abstract class ReflectClazz<T extends Annotation> implements AutoGen{

	protected Set<T> annotation = new LinkedHashSet<>();

	public Set<T> getAnnotation() {
		return annotation;
	}
	public void setAnnotation(Set<T> annotation) {
		this.annotation = annotation;
	}

}
