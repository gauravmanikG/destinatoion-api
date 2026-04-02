package com.destination.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.Map;

@Schema(description = "Request payload for creating or updating a destination")
public class DestinationRequest {

    @NotBlank(message = "Name is required")
    @Schema(description = "Destination name", example = "Slack Webhook")
    private String name;

    @NotBlank(message = "Type is required")
    @Schema(description = "Destination type", example = "webhook", allowableValues = {"webhook", "API"})
    private String type;

    @NotBlank(message = "URL is required")
    @Schema(description = "Destination URL", example = "https://hooks.slack.com/services/xxx")
    private String url;

    @NotBlank(message = "HTTP method is required")
    @Schema(description = "HTTP method", example = "POST", allowableValues = {"GET", "POST", "PUT", "PATCH", "DELETE"})
    private String method;

    @Schema(description = "Request headers", example = "{\"Authorization\":\"Bearer token\"}")
    private Map<String, String> headers;

    @NotNull(message = "Retry count is required")
    @Min(value = 0, message = "Retry count must be at least 0")
    @Max(value = 10, message = "Retry count must not exceed 10")
    @Schema(description = "Number of retry attempts", example = "3")
    private Integer retryCount;

    public DestinationRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }

    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }
}
