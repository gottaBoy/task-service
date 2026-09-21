/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.examples;

import java.util.LinkedHashMap;
import java.util.Map;

public class Example {
    private String summary = null;
    private String description = null;
    private Object value = null;
    private String externalValue = null;
    private String $ref = null;
    private Map<String, Object> extensions = null;

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String string) {
        this.summary = string;
    }

    public Example summary(String string) {
        this.summary = string;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Example description(String string) {
        this.description = string;
        return this;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object object) {
        this.value = object;
    }

    public Example value(Object object) {
        this.value = object;
        return this;
    }

    public String getExternalValue() {
        return this.externalValue;
    }

    public void setExternalValue(String string) {
        this.externalValue = string;
    }

    public Example externalValue(String string) {
        this.externalValue = string;
        return this;
    }

    public String get$ref() {
        return this.$ref;
    }

    public void set$ref(String string) {
        if (string != null && string.indexOf(".") == -1 && string.indexOf("/") == -1) {
            string = "#/components/examples/" + string;
        }
        this.$ref = string;
    }

    public Example $ref(String string) {
        this.set$ref(string);
        return this;
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

    public Example extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Example)) {
            return false;
        }
        Example example = (Example)object;
        if (this.summary != null ? !this.summary.equals(example.summary) : example.summary != null) {
            return false;
        }
        if (this.description != null ? !this.description.equals(example.description) : example.description != null) {
            return false;
        }
        if (this.value != null ? !this.value.equals(example.value) : example.value != null) {
            return false;
        }
        if (this.externalValue != null ? !this.externalValue.equals(example.externalValue) : example.externalValue != null) {
            return false;
        }
        if (this.$ref != null ? !this.$ref.equals(example.$ref) : example.$ref != null) {
            return false;
        }
        return this.extensions != null ? this.extensions.equals(example.extensions) : example.extensions == null;
    }

    public int hashCode() {
        int n = this.summary != null ? this.summary.hashCode() : 0;
        n = 31 * n + (this.description != null ? this.description.hashCode() : 0);
        n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
        n = 31 * n + (this.externalValue != null ? this.externalValue.hashCode() : 0);
        n = 31 * n + (this.$ref != null ? this.$ref.hashCode() : 0);
        n = 31 * n + (this.extensions != null ? this.extensions.hashCode() : 0);
        return n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class Example {\n");
        stringBuilder.append("    summary: ").append(this.toIndentedString(this.summary)).append("\n");
        stringBuilder.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        stringBuilder.append("    value: ").append(this.toIndentedString(this.value)).append("\n");
        stringBuilder.append("    externalValue: ").append(this.toIndentedString(this.externalValue)).append("\n");
        stringBuilder.append("    $ref: ").append(this.toIndentedString(this.$ref)).append("\n");
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

