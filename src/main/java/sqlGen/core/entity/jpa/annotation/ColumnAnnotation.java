package sqlGen.core.entity.jpa.annotation;

import genClassUtils.annotation.FieldAnnotation;
import genClassUtils.method.Method;

public class ColumnAnnotation extends FieldAnnotation {

	public ColumnAnnotation(String name) {
		super("Column");
		Method anntationMethod = new Method("name");
		anntationMethod.setReturnValue(name);
		this.getMethods().add(anntationMethod);
	}

}
