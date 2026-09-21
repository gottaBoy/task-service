/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.headers.Header;

public class Encoding {
    private String contentType;
    private Map<String, Header> headers;
    private StyleEnum style;
    private Boolean explode;
    private Boolean allowReserved;
    private Map<String, Object> extensions = null;

    public Encoding contentType(String string) {
        this.contentType = string;
        return this;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String string) {
        this.contentType = string;
    }

    public Encoding headers(Map<String, Header> map) {
        this.headers = map;
        return this;
    }

    public Map<String, Header> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, Header> map) {
        this.headers = map;
    }

    public Encoding style(StyleEnum styleEnum) {
        this.style = styleEnum;
        return this;
    }

    public StyleEnum getStyle() {
        return this.style;
    }

    public void setStyle(StyleEnum styleEnum) {
        this.style = styleEnum;
    }

    public Encoding explode(Boolean bl) {
        this.explode = bl;
        return this;
    }

    public Boolean getExplode() {
        return this.explode;
    }

    public void setExplode(Boolean bl) {
        this.explode = bl;
    }

    public Encoding allowReserved(Boolean bl) {
        this.allowReserved = bl;
        return this;
    }

    public Boolean getAllowReserved() {
        return this.allowReserved;
    }

    public void setAllowReserved(Boolean bl) {
        this.allowReserved = bl;
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

    public Encoding extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Encoding encoding = (Encoding)object;
        return Objects.equals(this.contentType, encoding.contentType) && Objects.equals(this.headers, encoding.headers) && Objects.equals((Object)this.style, (Object)encoding.style) && Objects.equals(this.explode, encoding.explode) && Objects.equals(this.extensions, encoding.extensions) && Objects.equals(this.allowReserved, encoding.allowReserved);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.contentType, this.headers, this.style, this.explode, this.allowReserved, this.extensions});
    }

    public String toString() {
        return "Encoding{contentType='" + this.contentType + '\'' + ", headers=" + this.headers + ", style='" + (Object)((Object)this.style) + '\'' + ", explode=" + this.explode + ", allowReserved=" + this.allowReserved + ", extensions=" + this.extensions + '}';
    }

    public static enum StyleEnum {
        FORM("form"),
        SPACE_DELIMITED("spaceDelimited"),
        PIPE_DELIMITED("pipeDelimited"),
        DEEP_OBJECT("deepObject");

        private String value;

        private StyleEnum(String string2) {
            this.value = string2;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }
}

