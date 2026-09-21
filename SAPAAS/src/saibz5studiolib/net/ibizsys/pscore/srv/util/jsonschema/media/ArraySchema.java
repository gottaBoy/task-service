/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class ArraySchema
extends Schema<Object> {
    private Schema<?> items = null;

    public ArraySchema() {
        super("array", null);
    }

    @Override
    public ArraySchema type(String string) {
        super.setType(string);
        return this;
    }

    public Schema<?> getItems() {
        return this.items;
    }

    public void setItems(Schema<?> schema) {
        this.items = schema;
    }

    public ArraySchema items(Schema<?> schema) {
        this.items = schema;
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
        ArraySchema arraySchema = (ArraySchema)object;
        return Objects.equals(this.items, arraySchema.items) && super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.items, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ArraySchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("    items: ").append(this.toIndentedString(this.items)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

