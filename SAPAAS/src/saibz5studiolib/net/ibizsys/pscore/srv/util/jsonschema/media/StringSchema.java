/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class StringSchema
extends Schema<String> {
    public StringSchema() {
        super("string", null);
    }

    @Override
    public StringSchema type(String string) {
        super.setType(string);
        return this;
    }

    public StringSchema _default(String string) {
        super.setDefault(string);
        return this;
    }

    public StringSchema _enum(List<String> list) {
        super.setEnum(list);
        return this;
    }

    public StringSchema addEnumItem(String string) {
        super.addEnumItemObject(string);
        return this;
    }

    @Override
    protected String cast(Object object) {
        if (object != null) {
            try {
                return object.toString();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
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
        stringBuilder.append("class StringSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

