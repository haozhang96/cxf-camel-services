package org.haozhang.services.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.activation.MimeType;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.annotation.XmlTransient;
import org.apache.cxf.phase.Phase;
import org.haozhang.services.models.support.ModelDataSource;

import javax.print.attribute.standard.Media;
import java.awt.datatransfer.DataFlavor;
import java.io.Serializable;
import java.time.Instant;
import java.util.Properties;
import java.util.function.Predicate;

@XmlTransient
public interface Model extends Serializable, Cloneable {
    @Nonnull
    default Context getContext() {
        return AbstractModel.DummyContext.INSTANCE;
    }

    @Nonnull
    default <M extends Model> M copy() {
        return (M) this;
    }

    default ModelDataSource asDataSource() {

    }

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

            }

            @Nonnull
            public static Type infer(@Nonnull String content) {

            }

            @Override
            public boolean test(@Nonnull String content) {
                return false;
            }
        }
    }
}
