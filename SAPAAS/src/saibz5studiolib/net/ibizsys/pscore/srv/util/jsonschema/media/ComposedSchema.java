/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class ComposedSchema
extends Schema<Object> {
    private List<Schema> allOf = null;
    private List<Schema> anyOf = null;
    private List<Schema> oneOf = null;

    public List<Schema> getAllOf() {
        return this.allOf;
    }

    public void setAllOf(List<Schema> list) {
        this.allOf = list;
    }

    public ComposedSchema allOf(List<Schema> list) {
        this.allOf = list;
        return this;
    }

    public ComposedSchema addAllOfItem(Schema schema) {
        if (this.allOf == null) {
            this.allOf = new ArrayList<Schema>();
        }
        this.allOf.add(schema);
        return this;
    }

    public List<Schema> getAnyOf() {
        return this.anyOf;
    }

    public void setAnyOf(List<Schema> list) {
        this.anyOf = list;
    }

    public ComposedSchema anyOf(List<Schema> list) {
        this.anyOf = list;
        return this;
    }

    public ComposedSchema addAnyOfItem(Schema schema) {
        if (this.anyOf == null) {
            this.anyOf = new ArrayList<Schema>();
        }
        this.anyOf.add(schema);
        return this;
    }

    public List<Schema> getOneOf() {
        return this.oneOf;
    }

    public void setOneOf(List<Schema> list) {
        this.oneOf = list;
    }

    public ComposedSchema oneOf(List<Schema> list) {
        this.oneOf = list;
        return this;
    }

    public ComposedSchema addOneOfItem(Schema schema) {
        if (this.oneOf == null) {
            this.oneOf = new ArrayList<Schema>();
        }
        this.oneOf.add(schema);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ComposedSchema composedSchema = (ComposedSchema)object;
        return Objects.equals(this.allOf, composedSchema.allOf) && Objects.equals(this.anyOf, composedSchema.anyOf) && Objects.equals(this.oneOf, composedSchema.oneOf) && super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.allOf, this.anyOf, this.oneOf, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ComposedSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("    allOf: ").append(this.toIndentedString(this.allOf)).append("\n");
        stringBuilder.append("    anyOf: ").append(this.toIndentedString(this.anyOf)).append("\n");
        stringBuilder.append("    oneOf: ").append(this.toIndentedString(this.oneOf)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

