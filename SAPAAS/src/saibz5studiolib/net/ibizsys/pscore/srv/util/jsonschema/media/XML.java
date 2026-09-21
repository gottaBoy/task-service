/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class XML {
    private String name = null;
    private String namespace = null;
    private String prefix = null;
    private Boolean attribute = null;
    private Boolean wrapped = null;
    private Map<String, Object> extensions = null;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public XML name(String string) {
        this.name = string;
        return this;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setNamespace(String string) {
        this.namespace = string;
    }

    public XML namespace(String string) {
        this.namespace = string;
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String string) {
        this.prefix = string;
    }

    public XML prefix(String string) {
        this.prefix = string;
        return this;
    }

    public Boolean getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Boolean bl) {
        this.attribute = bl;
    }

    public XML attribute(Boolean bl) {
        this.attribute = bl;
        return this;
    }

    public Boolean getWrapped() {
        return this.wrapped;
    }

    public void setWrapped(Boolean bl) {
        this.wrapped = bl;
    }

    public XML wrapped(Boolean bl) {
        this.wrapped = bl;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        XML xML = (XML)object;
        return Objects.equals(this.name, xML.name) && Objects.equals(this.namespace, xML.namespace) && Objects.equals(this.prefix, xML.prefix) && Objects.equals(this.attribute, xML.attribute) && Objects.equals(this.wrapped, xML.wrapped) && Objects.equals(this.extensions, xML.extensions);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.namespace, this.prefix, this.attribute, this.wrapped, this.extensions);
    }

    public Map<String, Object> getExtensions() {
        return this.extensions;
    }

    public void addExtension(String string, Object object) {
        if (string == null || string.isEmpty() || !string.startsWith("x-")) {
            return;
        }
        if (this.extensions == null) {
            this.extensions = new LinkedHashMap<String, Object>();
        }
        this.extensions.put(string, object);
    }

    public void setExtensions(Map<String, Object> map) {
        this.extensions = map;
    }

    public XML extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class XML {\n");
        stringBuilder.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
        stringBuilder.append("    namespace: ").append(this.toIndentedString(this.namespace)).append("\n");
        stringBuilder.append("    prefix: ").append(this.toIndentedString(this.prefix)).append("\n");
        stringBuilder.append("    attribute: ").append(this.toIndentedString(this.attribute)).append("\n");
        stringBuilder.append("    wrapped: ").append(this.toIndentedString(this.wrapped)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private String toIndentedString(Object object) {
        if (object == null) {
            return "null";
        }
        return object.toString().replace("\n", "\n    ");
    }
}

