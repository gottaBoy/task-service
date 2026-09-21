/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class BooleanSchema
extends Schema<Boolean> {
    public BooleanSchema() {
        super("boolean", null);
    }

    @Override
    public BooleanSchema type(String string) {
        super.setType(string);
        return this;
    }

    public BooleanSchema _default(Boolean bl) {
        super.setDefault(bl);
        return this;
    }

    @Override
    protected Boolean cast(Object object) {
        if (object != null) {
            try {
                return Boolean.parseBoolean(object.toString());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public BooleanSchema _enum(List<Boolean> list) {
        this._enum = list;
        return this;
    }

    public BooleanSchema addEnumItem(Boolean bl) {
        if (this._enum == null) {
            this._enum = new ArrayList();
        }
        this._enum.add(bl);
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
        stringBuilder.append("class BooleanSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

