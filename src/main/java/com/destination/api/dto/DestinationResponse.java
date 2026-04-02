package com.destination.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "Response payload representing a destination")
public class DestinationResponse {

    @Schema(description = "Destination ID", example = "1")
    private Long id;

    @Schema(description = "Destination name", example = "Slack Webhook")
    private String name;

    @Schema(description = "Destination type", example = "webhook")
    private String type;

    @Schema(description = "Destination URL", example = "https://hooks.slack.com/services/xxx")
    private String url;

    @Schema(description = "HTTP method", example = "POST")
    private String method;

    @Schema(description = "Request headers")
    private Map<String, String> headers;

    @Schema(description = "Number of retry attempts", example = "3")
    private Integer retryCount;

    @Schema(description = "Record creation timestamp")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update timestamp")
    private LocalDateTime updatedAt;

    public DestinationResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static DestinationResponseBuilder builder() { return new DestinationResponseBuilder(); }

    public static class DestinationResponseBuilder {
        private Long id;
        private String name;
        private String type;
        private String url;
        private String method;
        private Map<String, String> headers;
        private Integer retryCount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public DestinationResponseBuilder id(Long id) { this.id = id; return this; }
        public DestinationResponseBuilder name(String name) { this.name = name; return this; }
        public DestinationResponseBuilder type(String type) { this.type = type; return this; }
        public DestinationResponseBuilder url(String url) { this.url = url; return this; }
        public DestinationResponseBuilder method(String method) { this.method = method; return this; }
        public DestinationResponseBuilder headers(Map<String, String> headers) { this.headers = headers; return this; }
        public DestinationResponseBuilder retryCount(Integer retryCount) { this.retryCount = retryCount; return this; }
        public DestinationResponseBuilder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public DestinationResponseBuilder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }

        public DestinationResponse build() {
            DestinationResponse r = new DestinationResponse();
            r.id = this.id; r.name = this.name; r.type = this.type;
            r.url = this.url; r.method = this.method; r.headers = this.headers;
            r.retryCount = this.retryCount; r.createdAt = this.createdAt; r.updatedAt = this.updatedAt;
            return r;
        }
    }
}
