/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ExternalDocumentation {
    private String description = null;
    private String url = null;
    private Map<String, Object> extensions = null;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public ExternalDocumentation description(String string) {
        this.description = string;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public ExternalDocumentation url(String string) {
        this.url = string;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ExternalDocumentation externalDocumentation = (ExternalDocumentation)object;
        return Objects.equals(this.description, externalDocumentation.description) && Objects.equals(this.url, externalDocumentation.url) && Objects.equals(this.extensions, externalDocumentation.extensions);
    }

    public int hashCode() {
        return Objects.hash(this.description, this.url, this.extensions);
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

    public ExternalDocumentation extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ExternalDocumentation {\n");
        stringBuilder.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        stringBuilder.append("    url: ").append(this.toIndentedString(this.url)).append("\n");
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

