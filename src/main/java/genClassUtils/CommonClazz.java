package genClassUtils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommonClazz {

	protected Set<String> generics = new LinkedHashSet<>();

	protected Boolean isSupportGeneric = false;

	public Set<String> getGenerics() {
		return generics;
	}
	
	public void setGenerics(Set<String> generics) {
		this.generics = generics;
	}
	public Boolean getIsSupportGeneric() {
		return isSupportGeneric;
	}

	public void setIsSupportGeneric(Boolean isSupportGeneric) {
		this.isSupportGeneric = isSupportGeneric;
	}

	protected String genGenerics() {
		StringBuilder genericsBuilder = new StringBuilder();
		genericsBuilder.append("<");
		Iterator<String> it = this.generics.iterator();
		Boolean commaFlag = false;
		while (it.hasNext()) {
			if (commaFlag) {
				genericsBuilder.append(",");
			}
			commaFlag = true;
			genericsBuilder.append(it.next());
		}
		genericsBuilder.append(">");
		return genericsBuilder.toString();
	}

}
