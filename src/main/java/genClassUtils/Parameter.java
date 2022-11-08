package genClassUtils;

import java.util.Iterator;

import genClassUtils.enums.DataType;

public class Parameter extends ReflectClazz implements IsFinalCheck {

	public Parameter(String paraName) {
		this.paraName = paraName;
	}

	public Parameter(DataType dataType) {
		this.dataType = dataType;
	}

	public Parameter(DataType dataType, String paraName) {
		this.dataType = dataType;
		this.paraName = paraName;
	}

	private DataType dataType = DataType.STRING;

	private String paraName = "";

	private Boolean isFinal = false;

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public String genCode() {
		StringBuilder paraBuilder = new StringBuilder();
		if (this.annotation.size() > 0) {
			Iterator<Annotation> it = this.annotation.iterator();
			while (it.hasNext()) {
				paraBuilder.append(it.next().genCode());
				paraBuilder.append(emptySpace);
			}
		}
		if (this.getIsFinal())
			paraBuilder.append("final ");
		paraBuilder.append(this.dataType.getDataType() + emptySpace);
		paraBuilder.append(this.paraName);
		return paraBuilder.toString();
	}

}
