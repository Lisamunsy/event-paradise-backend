package co.simplon.eventparadise.errors;

public class CustomError {
    private String code;
    private String fieldName;
    private String message;

    public CustomError(String code, String name,
	    String message) {
	this.code = code;
	this.fieldName = name;
	this.message = message;
    }

    public String getCode() {
	return code;
    }

    public String getFieldName() {
	return fieldName;
    }

    public Object getMessage() {
	return message;
    }

    @Override
    public String toString() {
	return "{code=" + code + ", fieldName=" + fieldName
		+ ", message=" + message + "}";
    }

}