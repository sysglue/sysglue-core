package sysglue.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {


    @JsonProperty(required=true)
    @JsonPropertyDescription("Error message")
    public String message;

    @JsonProperty(required=true)
    @JsonPropertyDescription("Error code")
    public String code;

    @JsonPropertyDescription("Error detail")
    public String detail;

    public ApiError(String message, String code, String detail) {
        this.message = message;
        this.code = code;
        this.detail = detail;
    }
    
    public ApiError(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ApiError(String message, Integer code, String detail) {
        this.message = message;
        this.code = code.toString();
        this.detail = detail;
    }

    public ApiError(String message, Integer code) {
        this.message = message;
        this.code = code.toString();
    }

    public ApiError(){

    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", detail=" + detail + ", message=" + message + "]";
    }
    
}