package org.haozhang.services.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.annotation.Nonnull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import org.apache.cxf.service.model.ServiceModelUtil;

import java.io.Serial;

@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class AbstractModel implements Model {
    private static final @Serial long serialVersionUID = 1L;

    private final transient Context context = createContext();

    protected AbstractModel() {

    }

    protected AbstractModel(@Nonnull Context.Type type) {
        context
    }

    @Nonnull
    @Override
    public Context getContext() {
        return context;
    }

    @Nonnull
    protected Context createContext() {
        return DummyContext.INSTANCE;
    }

    static final class DummyContext extends Context {
        private static final @Serial long serialVersionUID = 1L;


        static final Context INSTANCE = new DummyContext();

        private DummyContext() {
            // This is a singleton class.
        }

        @Serial
        private static Object readResolve() {
            return INSTANCE;
        }
    }
}
