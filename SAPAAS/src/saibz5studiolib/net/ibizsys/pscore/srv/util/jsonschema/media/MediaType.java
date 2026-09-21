/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.examples.Example;
import net.ibizsys.pscore.srv.util.jsonschema.media.Encoding;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class MediaType {
    private Schema schema = null;
    private Map<String, Example> examples = null;
    private Object example = null;
    private Map<String, Encoding> encoding = null;
    private Map<String, Object> extensions = null;

    public Schema getSchema() {
        return this.schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public MediaType schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Map<String, Example> getExamples() {
        return this.examples;
    }

    public void setExamples(Map<String, Example> map) {
        this.examples = map;
    }

    public MediaType examples(Map<String, Example> map) {
        this.examples = map;
        return this;
    }

    public MediaType addExamples(String string, Example example) {
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

    public MediaType example(Object object) {
        this.example = object;
        return this;
    }

    public Map<String, Encoding> getEncoding() {
        return this.encoding;
    }

    public void setEncoding(Map<String, Encoding> map) {
        this.encoding = map;
    }

    public MediaType encoding(Map<String, Encoding> map) {
        this.encoding = map;
        return this;
    }

    public MediaType addEncoding(String string, Encoding encoding) {
        if (this.encoding == null) {
            this.encoding = new LinkedHashMap<String, Encoding>();
        }
        this.encoding.put(string, encoding);
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        MediaType mediaType = (MediaType)object;
        return Objects.equals(this.schema, mediaType.schema) && Objects.equals(this.examples, mediaType.examples) && Objects.equals(this.example, mediaType.example) && Objects.equals(this.encoding, mediaType.encoding) && Objects.equals(this.extensions, mediaType.extensions);
    }

    public int hashCode() {
        return Objects.hash(this.schema, this.examples, this.example, this.encoding, this.extensions);
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

    public MediaType extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class MediaType {\n");
        stringBuilder.append("    schema: ").append(this.toIndentedString(this.schema)).append("\n");
        stringBuilder.append("    examples: ").append(this.toIndentedString(this.examples)).append("\n");
        stringBuilder.append("    example: ").append(this.toIndentedString(this.example)).append("\n");
        stringBuilder.append("    encoding: ").append(this.toIndentedString(this.encoding)).append("\n");
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

