package genClassUtils.annotation;

public class MethodAnnotation extends Annotation {
	
	public static final MethodAnnotation overrideAnnotation = new MethodAnnotation("override");

	public MethodAnnotation(String annotationName) {
		super(annotationName);
	}

}
