package org.gaborbalazs.kipchakifyapp.web.exception;

import java.time.ZonedDateTime;

public final class ExceptionResponse {

    private final ZonedDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    private ExceptionResponse(Builder builder) {
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.error = builder.error;
        this.message = builder.message;
        this.path = builder.path;
    }

    static Builder newBuilder() {
        return new Builder();
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public static final class Builder {
        private ZonedDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

        private Builder() {
        }

        Builder withTimestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        Builder withError(String error) {
            this.error = error;
            return this;
        }

        Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        Builder withPath(String path) {
            this.path = path;
            return this;
        }

        ExceptionResponse build() {
            return new ExceptionResponse(this);
        }
    }
}
