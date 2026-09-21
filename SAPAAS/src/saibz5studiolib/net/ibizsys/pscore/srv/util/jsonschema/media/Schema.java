/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.ExternalDocumentation;
import net.ibizsys.pscore.srv.util.jsonschema.media.Discriminator;
import net.ibizsys.pscore.srv.util.jsonschema.media.XML;

public class Schema<T> {
    public static final String TYPE_NULL = "null";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_OBJECT = "object";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_INTEGER = "integer";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_UNKNOWN = "unknown";
    protected T _default;
    private String name;
    private String title = null;
    private BigDecimal multipleOf = null;
    private BigDecimal maximum = null;
    private Boolean exclusiveMaximum = null;
    private BigDecimal minimum = null;
    private Boolean exclusiveMinimum = null;
    private Integer maxLength = null;
    private Integer minLength = null;
    private String pattern = null;
    private Integer maxItems = null;
    private Integer minItems = null;
    private Boolean uniqueItems = null;
    private Integer maxProperties = null;
    private Integer minProperties = null;
    private List<String> required = null;
    private String type = null;
    private Schema not = null;
    private Map<String, Schema> properties = null;
    private Object additionalProperties = null;
    private String description = null;
    private String format = null;
    private String $ref = null;
    private Boolean nullable = null;
    private Boolean readOnly = null;
    private Boolean writeOnly = null;
    protected T example = null;
    private ExternalDocumentation externalDocs = null;
    private Boolean deprecated = null;
    private XML xml = null;
    private Map<String, Object> extensions = null;
    protected List<T> _enum = null;
    private Discriminator discriminator = null;

    public Schema() {
    }

    protected Schema(String string, String string2) {
        this.type = string;
        this.format = string2;
    }

    @JsonIgnore
    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Schema name(String string) {
        this.setName(string);
        return this;
    }

    public Discriminator getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(Discriminator discriminator) {
        this.discriminator = discriminator;
    }

    public Schema discriminator(Discriminator discriminator) {
        this.discriminator = discriminator;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Schema title(String string) {
        this.title = string;
        return this;
    }

    public T getDefault() {
        return this._default;
    }

    public void setDefault(Object object) {
        this._default = this.cast(object);
    }

    protected T cast(Object object) {
        return (T)object;
    }

    public List<T> getEnum() {
        return this._enum;
    }

    public void setEnum(List<T> list) {
        this._enum = list;
    }

    public void addEnumItemObject(T t) {
        if (this._enum == null) {
            this._enum = new ArrayList<T>();
        }
        this._enum.add(this.cast(t));
    }

    public BigDecimal getMultipleOf() {
        return this.multipleOf;
    }

    public void setMultipleOf(BigDecimal bigDecimal) {
        this.multipleOf = bigDecimal;
    }

    public Schema multipleOf(BigDecimal bigDecimal) {
        this.multipleOf = bigDecimal;
        return this;
    }

    public BigDecimal getMaximum() {
        return this.maximum;
    }

    public void setMaximum(BigDecimal bigDecimal) {
        this.maximum = bigDecimal;
    }

    public Schema maximum(BigDecimal bigDecimal) {
        this.maximum = bigDecimal;
        return this;
    }

    public Boolean getExclusiveMaximum() {
        return this.exclusiveMaximum;
    }

    public void setExclusiveMaximum(Boolean bl) {
        this.exclusiveMaximum = bl;
    }

    public Schema exclusiveMaximum(Boolean bl) {
        this.exclusiveMaximum = bl;
        return this;
    }

    public BigDecimal getMinimum() {
        return this.minimum;
    }

    public void setMinimum(BigDecimal bigDecimal) {
        this.minimum = bigDecimal;
    }

    public Schema minimum(BigDecimal bigDecimal) {
        this.minimum = bigDecimal;
        return this;
    }

    public Boolean getExclusiveMinimum() {
        return this.exclusiveMinimum;
    }

    public void setExclusiveMinimum(Boolean bl) {
        this.exclusiveMinimum = bl;
    }

    public Schema exclusiveMinimum(Boolean bl) {
        this.exclusiveMinimum = bl;
        return this;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(Integer n) {
        this.maxLength = n;
    }

    public Schema maxLength(Integer n) {
        this.maxLength = n;
        return this;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public void setMinLength(Integer n) {
        this.minLength = n;
    }

    public Schema minLength(Integer n) {
        this.minLength = n;
        return this;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String string) {
        this.pattern = string;
    }

    public Schema pattern(String string) {
        this.pattern = string;
        return this;
    }

    public Integer getMaxItems() {
        return this.maxItems;
    }

    public void setMaxItems(Integer n) {
        this.maxItems = n;
    }

    public Schema maxItems(Integer n) {
        this.maxItems = n;
        return this;
    }

    public Integer getMinItems() {
        return this.minItems;
    }

    public void setMinItems(Integer n) {
        this.minItems = n;
    }

    public Schema minItems(Integer n) {
        this.minItems = n;
        return this;
    }

    public Boolean getUniqueItems() {
        return this.uniqueItems;
    }

    public void setUniqueItems(Boolean bl) {
        this.uniqueItems = bl;
    }

    public Schema uniqueItems(Boolean bl) {
        this.uniqueItems = bl;
        return this;
    }

    public Integer getMaxProperties() {
        return this.maxProperties;
    }

    public void setMaxProperties(Integer n) {
        this.maxProperties = n;
    }

    public Schema maxProperties(Integer n) {
        this.maxProperties = n;
        return this;
    }

    public Integer getMinProperties() {
        return this.minProperties;
    }

    public void setMinProperties(Integer n) {
        this.minProperties = n;
    }

    public Schema minProperties(Integer n) {
        this.minProperties = n;
        return this;
    }

    public List<String> getRequired() {
        return this.required;
    }

    public void setRequired(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (list != null) {
            for (String string : list) {
                if (this.properties == null) {
                    arrayList.add(string);
                    continue;
                }
                if (!this.properties.containsKey(string)) continue;
                arrayList.add(string);
            }
        }
        Collections.sort(arrayList);
        if (arrayList.size() == 0) {
            arrayList = null;
        }
        this.required = arrayList;
    }

    public Schema required(List<String> list) {
        this.required = list;
        return this;
    }

    public Schema addRequiredItem(String string) {
        if (this.required == null) {
            this.required = new ArrayList<String>();
        }
        this.required.add(string);
        Collections.sort(this.required);
        return this;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String string) {
        this.type = string;
    }

    public Schema type(String string) {
        this.type = string;
        return this;
    }

    public Schema getNot() {
        return this.not;
    }

    public void setNot(Schema schema) {
        this.not = schema;
    }

    public Schema not(Schema schema) {
        this.not = schema;
        return this;
    }

    public Map<String, Schema> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, Schema> map) {
        this.properties = map;
    }

    public Schema properties(Map<String, Schema> map) {
        this.properties = map;
        return this;
    }

    public Schema addProperties(String string, Schema schema) {
        if (this.properties == null) {
            this.properties = new LinkedHashMap<String, Schema>();
        }
        this.properties.put(string, schema);
        return this;
    }

    public Object getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(Object object) {
        if (object != null && !(object instanceof Boolean) && !(object instanceof Schema)) {
            throw new IllegalArgumentException("additionalProperties must be either a Boolean or a Schema instance");
        }
        this.additionalProperties = object;
    }

    public Schema additionalProperties(Object object) {
        this.setAdditionalProperties(object);
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Schema description(String string) {
        this.description = string;
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String string) {
        this.format = string;
    }

    public Schema format(String string) {
        this.format = string;
        return this;
    }

    public String get$ref() {
        return this.$ref;
    }

    public void set$ref(String string) {
        if (string != null && string.indexOf(".") == -1 && string.indexOf("/") == -1) {
            string = "#/components/schemas/" + string;
        }
        this.$ref = string;
    }

    public Schema $ref(String string) {
        this.set$ref(string);
        return this;
    }

    public Boolean getNullable() {
        return this.nullable;
    }

    public void setNullable(Boolean bl) {
        this.nullable = bl;
    }

    public Schema nullable(Boolean bl) {
        this.nullable = bl;
        return this;
    }

    public Boolean getReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(Boolean bl) {
        this.readOnly = bl;
    }

    public Schema readOnly(Boolean bl) {
        this.readOnly = bl;
        return this;
    }

    public Boolean getWriteOnly() {
        return this.writeOnly;
    }

    public void setWriteOnly(Boolean bl) {
        this.writeOnly = bl;
    }

    public Schema writeOnly(Boolean bl) {
        this.writeOnly = bl;
        return this;
    }

    public Object getExample() {
        return this.example;
    }

    public void setExample(Object object) {
        this.example = this.cast(object);
    }

    public Schema example(Object object) {
        this.setExample(object);
        return this;
    }

    public ExternalDocumentation getExternalDocs() {
        return this.externalDocs;
    }

    public void setExternalDocs(ExternalDocumentation externalDocumentation) {
        this.externalDocs = externalDocumentation;
    }

    public Schema externalDocs(ExternalDocumentation externalDocumentation) {
        this.externalDocs = externalDocumentation;
        return this;
    }

    public Boolean getDeprecated() {
        return this.deprecated;
    }

    public void setDeprecated(Boolean bl) {
        this.deprecated = bl;
    }

    public Schema deprecated(Boolean bl) {
        this.deprecated = bl;
        return this;
    }

    public XML getXml() {
        return this.xml;
    }

    public void setXml(XML xML) {
        this.xml = xML;
    }

    public Schema xml(XML xML) {
        this.xml = xML;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Schema schema = (Schema)object;
        return Objects.equals(this.title, schema.title) && Objects.equals(this.multipleOf, schema.multipleOf) && Objects.equals(this.maximum, schema.maximum) && Objects.equals(this.exclusiveMaximum, schema.exclusiveMaximum) && Objects.equals(this.minimum, schema.minimum) && Objects.equals(this.exclusiveMinimum, schema.exclusiveMinimum) && Objects.equals(this.maxLength, schema.maxLength) && Objects.equals(this.minLength, schema.minLength) && Objects.equals(this.pattern, schema.pattern) && Objects.equals(this.maxItems, schema.maxItems) && Objects.equals(this.minItems, schema.minItems) && Objects.equals(this.uniqueItems, schema.uniqueItems) && Objects.equals(this.maxProperties, schema.maxProperties) && Objects.equals(this.minProperties, schema.minProperties) && Objects.equals(this.required, schema.required) && Objects.equals(this.type, schema.type) && Objects.equals(this.not, schema.not) && Objects.equals(this.properties, schema.properties) && Objects.equals(this.additionalProperties, schema.additionalProperties) && Objects.equals(this.description, schema.description) && Objects.equals(this.format, schema.format) && Objects.equals(this.$ref, schema.$ref) && Objects.equals(this.nullable, schema.nullable) && Objects.equals(this.readOnly, schema.readOnly) && Objects.equals(this.writeOnly, schema.writeOnly) && Objects.equals(this.example, schema.example) && Objects.equals(this.externalDocs, schema.externalDocs) && Objects.equals(this.deprecated, schema.deprecated) && Objects.equals(this.xml, schema.xml) && Objects.equals(this.extensions, schema.extensions) && Objects.equals(this.discriminator, schema.discriminator) && Objects.equals(this._enum, schema._enum) && Objects.equals(this._default, schema._default);
    }

    public int hashCode() {
        return Objects.hash(this.title, this.multipleOf, this.maximum, this.exclusiveMaximum, this.minimum, this.exclusiveMinimum, this.maxLength, this.minLength, this.pattern, this.maxItems, this.minItems, this.uniqueItems, this.maxProperties, this.minProperties, this.required, this.type, this.not, this.properties, this.additionalProperties, this.description, this.format, this.$ref, this.nullable, this.readOnly, this.writeOnly, this.example, this.externalDocs, this.deprecated, this.xml, this.extensions, this.discriminator, this._enum, this._default);
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

    public Schema extensions(Map<String, Object> map) {
        this.extensions = map;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class Schema {\n");
        stringBuilder.append("    type: ").append(this.toIndentedString(this.type)).append("\n");
        stringBuilder.append("    format: ").append(this.toIndentedString(this.format)).append("\n");
        stringBuilder.append("    $ref: ").append(this.toIndentedString(this.$ref)).append("\n");
        stringBuilder.append("    description: ").append(this.toIndentedString(this.description)).append("\n");
        stringBuilder.append("    title: ").append(this.toIndentedString(this.title)).append("\n");
        stringBuilder.append("    multipleOf: ").append(this.toIndentedString(this.multipleOf)).append("\n");
        stringBuilder.append("    maximum: ").append(this.toIndentedString(this.maximum)).append("\n");
        stringBuilder.append("    exclusiveMaximum: ").append(this.toIndentedString(this.exclusiveMaximum)).append("\n");
        stringBuilder.append("    minimum: ").append(this.toIndentedString(this.minimum)).append("\n");
        stringBuilder.append("    exclusiveMinimum: ").append(this.toIndentedString(this.exclusiveMinimum)).append("\n");
        stringBuilder.append("    maxLength: ").append(this.toIndentedString(this.maxLength)).append("\n");
        stringBuilder.append("    minLength: ").append(this.toIndentedString(this.minLength)).append("\n");
        stringBuilder.append("    pattern: ").append(this.toIndentedString(this.pattern)).append("\n");
        stringBuilder.append("    maxItems: ").append(this.toIndentedString(this.maxItems)).append("\n");
        stringBuilder.append("    minItems: ").append(this.toIndentedString(this.minItems)).append("\n");
        stringBuilder.append("    uniqueItems: ").append(this.toIndentedString(this.uniqueItems)).append("\n");
        stringBuilder.append("    maxProperties: ").append(this.toIndentedString(this.maxProperties)).append("\n");
        stringBuilder.append("    minProperties: ").append(this.toIndentedString(this.minProperties)).append("\n");
        stringBuilder.append("    required: ").append(this.toIndentedString(this.required)).append("\n");
        stringBuilder.append("    not: ").append(this.toIndentedString(this.not)).append("\n");
        stringBuilder.append("    properties: ").append(this.toIndentedString(this.properties)).append("\n");
        stringBuilder.append("    additionalProperties: ").append(this.toIndentedString(this.additionalProperties)).append("\n");
        stringBuilder.append("    nullable: ").append(this.toIndentedString(this.nullable)).append("\n");
        stringBuilder.append("    readOnly: ").append(this.toIndentedString(this.readOnly)).append("\n");
        stringBuilder.append("    writeOnly: ").append(this.toIndentedString(this.writeOnly)).append("\n");
        stringBuilder.append("    example: ").append(this.toIndentedString(this.example)).append("\n");
        stringBuilder.append("    externalDocs: ").append(this.toIndentedString(this.externalDocs)).append("\n");
        stringBuilder.append("    deprecated: ").append(this.toIndentedString(this.deprecated)).append("\n");
        stringBuilder.append("    discriminator: ").append(this.toIndentedString(this.discriminator)).append("\n");
        stringBuilder.append("    xml: ").append(this.toIndentedString(this.xml)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected String toIndentedString(Object object) {
        if (object == null) {
            return TYPE_NULL;
        }
        return object.toString().replace("\n", "\n    ");
    }
}

