package genClassUtils;

import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Field extends ReflectClazz implements IsFinalCheck, IsStaticCheck {

	private DataType dataType = DataType.STRING;

	private AccessLevel accessLevel = AccessLevel.PRIVATE;

	private String fieldName;

	private Boolean isFinal = false;

	private Boolean isStatic = false;

	public Field(String fieldName) {
		this.fieldName = GenStringUtil.firstToLower(fieldName);
	}

	public Field(String fieldName, DataType dataType) {
		this.fieldName = GenStringUtil.firstToLower(fieldName);
		this.dataType = dataType;
	}

	public Field(String fieldName, DataType dataType, AccessLevel accessLevel) {
		this.fieldName = GenStringUtil.firstToLower(fieldName);
		this.dataType = dataType;
		this.accessLevel = accessLevel;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public Boolean getIsStatic() {
		return isStatic;
	}

	@Override
	public void setIsStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}

	@Override
	public String genCode() {
		StringBuilder fieldBuilder = new StringBuilder();
		if (this.annotation.size() > 0) {
			Iterator<Annotation> it = this.annotation.iterator();
			while (it.hasNext()) {
				fieldBuilder.append(changeLineAndSpace);
				fieldBuilder.append(it.next().genCode());
			}
		}
		fieldBuilder.append(changeLineAndSpace + this.accessLevel.getAccLevelText() + emptySpace);
		if (this.isStatic)
			fieldBuilder.append("static ");
		if (this.isFinal)
			fieldBuilder.append("fianl ");
		fieldBuilder.append(GenStringUtil.firstToUpper(this.dataType.getDataType()) + emptySpace
				+ GenStringUtil.firstToLower(fieldName));
		fieldBuilder.append(";");
		fieldBuilder.append(changeLine);
		return fieldBuilder.toString();
	}

	@Override
	public Boolean getIsFinal() {
		return isFinal;
	}

	@Override
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public String toString() {
		return fieldName;

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(fieldName).append(dataType.getDataType()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Field other = (Field) obj;
		if (!Objects.equals(this.fieldName, other.fieldName)) {
			return false;
		}
		if (!Objects.equals(this.dataType.getDataType(), other.dataType.getDataType())) {
			return false;
		}
		return true;
	}

}
