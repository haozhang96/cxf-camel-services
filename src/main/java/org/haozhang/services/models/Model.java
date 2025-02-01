package org.haozhang.services.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.SerializationUtils;
import org.haozhang.services.constants.SharedObjects;
import org.haozhang.services.models.request.Request;
import org.haozhang.services.models.support.ModelDataSource;
import org.haozhang.services.support.esoteric.Unchecked;

import java.awt.datatransfer.DataFlavor;
import java.io.Serializable;
import java.time.Instant;
import java.util.function.Predicate;

@XmlTransient
public interface Model extends Serializable, Cloneable {
    @Nonnull
    default Context getContext() {
        return AbstractModel.DummyContext.INSTANCE;
    }

    @Nonnull
    default <M extends Model> M copy() {
        try {
            return Unchecked.cast(SerializationUtils.clone(this));
        } catch (Exception exception) {

        }

        try (var tokenBuffer = new TokenBuffer(SharedObjects.OBJECT_MAPPER, false)) {
            return Unchecked.cast(SharedObjects.OBJECT_MAPPER.readValue(tokenBuffer.asParser(), getClass()));
//            return Unchecked.cast(SharedObjects.OBJECT_MAPPER.convertValue(this, getClass()));
        } catch (Exception exception) {

        }

        throw new UnsupportedOperationException("");
    }

    @Nonnull
    default ModelDataSource asDataSource() {
        return null;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Context.class)
    @JsonSubTypes(@JsonSubTypes.Type(Request.Context.class))
    class Context extends AbstractModel {
        @Nonnull
        private Instant timestamp = Instant.now();

        @Nonnull
        private Type type = Type.UNKNOWN;

        @Nonnull
        public Instant getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(@Nonnull Instant timestamp) {
            this.timestamp = timestamp;
        }

        @Nonnull
        public Type getType() {
            return type;
        }

        public void setType(@Nonnull Type type) {
            this.type = type;
        }

        public enum Type implements Predicate<String> {
            XML(MediaType.APPLICATION_XML_TYPE),
            JSON(MediaType.APPLICATION_JSON_TYPE),
            YAML("application/yaml"),
            PROTOCOL_BUFFER("application/protobuf"),
            JAVA_PROPERTIES("text/x-java-properties"),
            JAVA_SERIALIZED(DataFlavor.javaSerializedObjectMimeType),
            TEXT(MediaType.TEXT_PLAIN_TYPE),
            BINARY(MediaType.APPLICATION_OCTET_STREAM_TYPE),
            UNKNOWN(MediaType.WILDCARD_TYPE);

            @Nonnull
            private final MediaType mediaType;

            Type(@Nonnull String mimeType) {
                this(MediaType.valueOf(mimeType));
            }

            Type(@Nonnull MediaType mediaType) {
                this.mediaType = mediaType;
            }

            @Nonnull
            public <M extends ObjectMapper> M getObjectMapper() {
                return null;
            }

            public boolean isKnown() {
                return this != UNKNOWN;
            }

            @Nonnull
            public MediaType toMediaType() {
                return mediaType;
            }

            @Nonnull
            public static Type infer(@Nonnull String content) {
                return UNKNOWN;
            }

            @Override
            public boolean test(@Nonnull String content) {
                return infer(content) == this;
            }
        }
    }
}
