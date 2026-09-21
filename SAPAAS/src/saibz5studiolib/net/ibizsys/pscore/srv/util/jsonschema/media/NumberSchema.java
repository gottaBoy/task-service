/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class NumberSchema
extends Schema<BigDecimal> {
    public NumberSchema() {
        super("number", null);
    }

    @Override
    public NumberSchema type(String string) {
        super.setType(string);
        return this;
    }

    public NumberSchema _default(BigDecimal bigDecimal) {
        super.setDefault(bigDecimal);
        return this;
    }

    public NumberSchema _enum(List<BigDecimal> list) {
        super.setEnum(list);
        return this;
    }

    public NumberSchema addEnumItem(BigDecimal bigDecimal) {
        super.addEnumItemObject(bigDecimal);
        return this;
    }

    @Override
    protected BigDecimal cast(Object object) {
        if (object != null) {
            try {
                return new BigDecimal(object.toString());
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
        stringBuilder.append("class NumberSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

