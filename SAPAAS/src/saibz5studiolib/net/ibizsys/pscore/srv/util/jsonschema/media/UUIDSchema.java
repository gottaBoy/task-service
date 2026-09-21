/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class UUIDSchema
extends Schema<UUID> {
    public UUIDSchema() {
        super("string", "uuid");
    }

    @Override
    public UUIDSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public UUIDSchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public UUIDSchema _default(UUID uUID) {
        super.setDefault(uUID);
        return this;
    }

    public UUIDSchema _default(String string) {
        if (string != null) {
            super.setDefault(UUID.fromString(string));
        }
        return this;
    }

    public UUIDSchema _enum(List<UUID> list) {
        super.setEnum(list);
        return this;
    }

    public UUIDSchema addEnumItem(UUID uUID) {
        super.addEnumItemObject(uUID);
        return this;
    }

    @Override
    protected UUID cast(Object object) {
        if (object != null) {
            try {
                return UUID.fromString(object.toString());
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
        stringBuilder.append("class UUIDSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

