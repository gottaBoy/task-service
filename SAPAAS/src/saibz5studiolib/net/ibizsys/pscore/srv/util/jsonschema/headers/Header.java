/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.headers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.examples.Example;
import net.ibizsys.pscore.srv.util.jsonschema.media.Content;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class Header {
    private String description = null;
    private String $ref = null;
    private Boolean required = null;
    private Boolean deprecated = null;
    private StyleEnum style = null;
    private Boolean explode = null;
    private Schema schema = null;
    private Map<String, Example> examples = null;
    private Object example = null;
    private Content content = null;
    private Map<String, Object> extensions = null;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Header description(String string) {
        this.description = string;
        return this;
    }

    public Boolean getRequired() {
        return this.required;
    }

    public void setRequired(Boolean bl) {
        this.required = bl;
    }

    public Header required(Boolean bl) {
        this.required = bl;
        return this;
    }

    public Boolean getDeprecated() {
        return this.deprecated;
    }

    public void setDeprecated(Boolean bl) {
        this.deprecated = bl;
    }

    public Header deprecated(Boolean bl) {
        this.deprecated = bl;
        return this;
    }

    public StyleEnum getStyle() {
        return this.style;
    }

    public void setStyle(StyleEnum styleEnum) {
        this.style = styleEnum;
    }

    public Header style(StyleEnum styleEnum) {
        this.style = styleEnum;
        return this;
    }

    public Boolean getExplode() {
        return this.explode;
    }

    public void setExplode(Boolean bl) {
        this.explode = bl;
    }

    public Header explode(Boolean bl) {
        this.explode = bl;
        return this;
    }

    public Schema getSchema() {
        return this.schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Header schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Map<String, Example> getExamples() {
        return this.examples;
    }

    public void setExamples(Map<String, Example> map) {
        this.examples = map;
    }

    public Header examples(Map<String, Example> map) {
        this.examples = map;
        return this;
    }

    public Header addExample(String string, Example example) {
        if (this.examples == null) {
            this.examples = new LinkedHashMap<String, Example>();
        }
        this.examples.put(string, example);
        return this;
    }

    public Object getExample() {
        return this.example;
    }

    public void setExample(Object object) {
        this.example = object;
    }

    public Header example(Object object) {
        this.example = object;
        return this;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Header content(Content content) {
        this.content = content;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Header header = (Header)object;
        return Objects.equals(this.description, header.description) && Objects.equals(this.required, header.required) && Objects.equals(this.deprecated, header.deprecated) && Objects.equals((Object)this.style, (Object)header.style) && Objects.equals(this.explode, header.explode) && Objects.equals(this.schema, header.schema) && Objects.equals(this.examples, header.examples) && Objects.equals(this.example, header.example) && Objects.equals(this.content, header.content) && Objects.equals(this.extensions, header.extensions) && Objects.equals(this.$ref, header.$ref);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.description, this.required, this.deprecated, this.style, this.explode, this.schema, this.examples, this.example, this.content, this.extensions, this.$ref});
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

    public Header extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String get$ref() {
        return this.$ref;
    }

    public void set$ref(String string) {
        if (string != null && string.indexOf(".") == -1 && string.indexOf("/") == -1) {
            string = "#/components/headers/" + string;
        }
        this.$ref = string;
    }

    public Header $ref(String string) {
        this.set$ref(string);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class Header {\n");
        stringBuilder.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        stringBuilder.append("    required: ").append(this.toIndentedString(this.required)).append("\n");
        stringBuilder.append("    deprecated: ").append(this.toIndentedString(this.deprecated)).append("\n");
        stringBuilder.append("    style: ").append(this.toIndentedString((Object)this.style)).append("\n");
        stringBuilder.append("    explode: ").append(this.toIndentedString(this.explode)).append("\n");
        stringBuilder.append("    schema: ").append(this.toIndentedString(this.schema)).append("\n");
        stringBuilder.append("    examples: ").append(this.toIndentedString(this.examples)).append("\n");
        stringBuilder.append("    example: ").append(this.toIndentedString(this.example)).append("\n");
        stringBuilder.append("    content: ").append(this.toIndentedString(this.content)).append("\n");
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

    public static enum StyleEnum {
        SIMPLE("simple");

        private String value;

        private StyleEnum(String string2) {
            this.value = string2;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }
}

