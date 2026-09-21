/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class ByteArraySchema
extends Schema<byte[]> {
    public ByteArraySchema() {
        super("string", "byte");
    }

    @Override
    public ByteArraySchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public ByteArraySchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public ByteArraySchema _default(byte[] byArray) {
        super.setDefault(byArray);
        return this;
    }

    @Override
    protected byte[] cast(Object object) {
        if (object != null) {
            try {
                if (object instanceof byte[]) {
                    return (byte[])object;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public ByteArraySchema _enum(List<byte[]> list) {
        super.setEnum(list);
        return this;
    }

    public ByteArraySchema addEnumItem(byte[] byArray) {
        super.addEnumItemObject(byArray);
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
        stringBuilder.append("class ByteArraySchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

