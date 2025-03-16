package org.haozhang.services.support.diagnostics;

/**
 * This interface contains a list of valid directives for use with {@link SuppressWarnings @SuppressWarnings}.
 *
 * @see SuppressWarnings @SuppressWarnings
 */
public interface CodeWarnings {
    String ALL = "all";

    interface Compiler {
        String UNCHECKED_TYPE_USAGE = "unchecked";
        String RAW_TYPE_USAGE = "rawtypes";
        String UNUSED_ELEMENTS = "unused";
        String DEPRECATED_ELEMENT_USAGE = "deprecation";
        String DEPRECATED_FOR_REMOVAL_ELEMENT_USAGE = "removal";
        String UNREIFIABLE_VARARGS = "varargs";
        String IMPROPER_RESOURCE_HANDLING = "resource";
        String INVALID_JAVADOC = "javadoc";
    }

    interface IDE {
        interface IDEA {

        }

        interface Eclipse {

        }
    }

    interface Analyzer {
        interface Sonar {

        }

        interface Nexus {

        }
    }
}
