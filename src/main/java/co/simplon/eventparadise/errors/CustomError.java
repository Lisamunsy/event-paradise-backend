package co.simplon.eventparadise.errors;

public class CustomError {
    private String code;
    private String fieldName;

    public CustomError(String code, String message) {
	this.code = code;
	this.fieldName = message;
    }

    public String getCode() {
	return code;
    }

    public String getFieldName() {
	return fieldName;
    }

    @Override
    public String toString() {
	return "{code=" + code + ", message=" + fieldName
		+ "}";
    }

}