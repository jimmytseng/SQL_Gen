package sqlGen.core.entity.jpa.annotation;

import genClassUtils.Annotation;
import genClassUtils.Method;

public class ColumnAnnotation extends Annotation {

	public ColumnAnnotation(String name) {
		super("Column");
		Method anntationMethod = new Method("name");
		anntationMethod.setReturnValue(name);
		this.getMethods().add(anntationMethod);
	}

}
