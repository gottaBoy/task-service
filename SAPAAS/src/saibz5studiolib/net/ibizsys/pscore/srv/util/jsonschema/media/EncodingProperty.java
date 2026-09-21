/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.headers.Header;

public class EncodingProperty {
    private String contentType = null;
    private Map<String, Header> headers = null;
    private StyleEnum style = null;
    private Boolean explode = null;
    private Boolean allowReserved = null;
    private Map<String, Object> extensions = null;

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String string) {
        this.contentType = string;
    }

    public EncodingProperty contentType(String string) {
        this.contentType = string;
        return this;
    }

    public Map<String, Header> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, Header> map) {
        this.headers = map;
    }

    public EncodingProperty headers(Map<String, Header> map) {
        this.headers = map;
        return this;
    }

    public EncodingProperty addHeaderObject(String string, Header header) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap<String, Header>();
        }
        this.headers.put(string, header);
        return this;
    }

    public StyleEnum getStyle() {
        return this.style;
    }

    public void setStyle(StyleEnum styleEnum) {
        this.style = styleEnum;
    }

    public EncodingProperty style(StyleEnum styleEnum) {
        this.style = styleEnum;
        return this;
    }

    public Boolean getExplode() {
        return this.explode;
    }

    public void setExplode(Boolean bl) {
        this.explode = bl;
    }

    public EncodingProperty explode(Boolean bl) {
        this.explode = bl;
        return this;
    }

    public Boolean getAllowReserved() {
        return this.allowReserved;
    }

    public void setAllowReserved(Boolean bl) {
        this.allowReserved = bl;
    }

    public EncodingProperty allowReserved(Boolean bl) {
        this.allowReserved = bl;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        EncodingProperty encodingProperty = (EncodingProperty)object;
        return Objects.equals(this.contentType, encodingProperty.contentType) && Objects.equals(this.headers, encodingProperty.headers) && Objects.equals((Object)this.style, (Object)encodingProperty.style) && Objects.equals(this.explode, encodingProperty.explode) && Objects.equals(this.allowReserved, encodingProperty.allowReserved) && Objects.equals(this.extensions, encodingProperty.extensions);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.contentType, this.headers, this.style, this.explode, this.allowReserved, this.extensions});
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

    public EncodingProperty extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class EncodingProperty {\n");
        stringBuilder.append("    contentType: ").append(this.toIndentedString(this.contentType)).append("\n");
        stringBuilder.append("    headers: ").append(this.toIndentedString(this.headers)).append("\n");
        stringBuilder.append("    style: ").append(this.toIndentedString((Object)this.style)).append("\n");
        stringBuilder.append("    explode: ").append(this.toIndentedString(this.explode)).append("\n");
        stringBuilder.append("    allowReserved: ").append(this.toIndentedString(this.allowReserved)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private String toIndentedString(Object object) {
        if (object == null) {
            return "null";
        }
        return object.toString().replace("\n", "\n    ");
    }

    public static enum StyleEnum {
        FORM("form"),
        SPACEDELIMITED("spaceDelimited"),
        PIPEDELIMITED("pipeDelimited"),
        DEEPOBJECT("deepObject");

        private String value;

        private StyleEnum(String string2) {
            this.value = string2;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }
}

