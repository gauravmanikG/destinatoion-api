package com.destination.api.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String method;

    @Column(columnDefinition = "TEXT")
    private String headers;

    @Column(nullable = false)
    private Integer retryCount;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Destination() {}

    public Destination(Long id, String name, String type, String url, String method,
                       String headers, Integer retryCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.retryCount = retryCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public String getHeaders() { return headers; }
    public void setHeaders(String headers) { this.headers = headers; }

    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static DestinationBuilder builder() { return new DestinationBuilder(); }

    public static class DestinationBuilder {
        private Long id;
        private String name;
        private String type;
        private String url;
        private String method;
        private String headers;
        private Integer retryCount;

        public DestinationBuilder id(Long id) { this.id = id; return this; }
        public DestinationBuilder name(String name) { this.name = name; return this; }
        public DestinationBuilder type(String type) { this.type = type; return this; }
        public DestinationBuilder url(String url) { this.url = url; return this; }
        public DestinationBuilder method(String method) { this.method = method; return this; }
        public DestinationBuilder headers(String headers) { this.headers = headers; return this; }
        public DestinationBuilder retryCount(Integer retryCount) { this.retryCount = retryCount; return this; }

        public Destination build() {
            Destination d = new Destination();
            d.id = this.id;
            d.name = this.name;
            d.type = this.type;
            d.url = this.url;
            d.method = this.method;
            d.headers = this.headers;
            d.retryCount = this.retryCount;
            return d;
        }
    }
}
