/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.text.NumberFormat;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class IntegerSchema
extends Schema<Number> {
    public IntegerSchema() {
        super("integer", "int32");
    }

    @Override
    public IntegerSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public IntegerSchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public IntegerSchema _default(Number number) {
        super.setDefault(number);
        return this;
    }

    @Override
    protected Number cast(Object object) {
        if (object != null) {
            try {
                Number number = NumberFormat.getInstance().parse(object.toString());
                if (number.longValue() <= Integer.MAX_VALUE) {
                    return Integer.parseInt(object.toString());
                }
                return Long.parseLong(object.toString());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public IntegerSchema addEnumItem(Number number) {
        super.addEnumItemObject(number);
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
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class IntegerSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

