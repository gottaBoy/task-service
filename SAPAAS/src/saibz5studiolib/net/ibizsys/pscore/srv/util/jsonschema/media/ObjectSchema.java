/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class ObjectSchema
extends Schema<Object> {
    public ObjectSchema() {
        super("object", null);
    }

    @Override
    public ObjectSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public ObjectSchema example(Object object) {
        if (object != null) {
            super.setExample(object.toString());
        }
        return this;
    }

    @Override
    protected Object cast(Object object) {
        return object;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ObjectSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

