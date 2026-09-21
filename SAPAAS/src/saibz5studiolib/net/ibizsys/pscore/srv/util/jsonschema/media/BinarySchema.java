/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class BinarySchema
extends Schema<byte[]> {
    public BinarySchema() {
        super("string", "binary");
    }

    @Override
    public BinarySchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public BinarySchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public BinarySchema _default(byte[] byArray) {
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

    public BinarySchema _enum(List<byte[]> list) {
        super.setEnum(list);
        return this;
    }

    public BinarySchema addEnumItem(byte[] byArray) {
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
        return Objects.hash(this._default, this._enum, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class BinarySchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

