/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class EmailSchema
extends Schema<String> {
    public EmailSchema() {
        super("string", "email");
    }

    @Override
    public EmailSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public EmailSchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public EmailSchema _default(String string) {
        super.setDefault(string);
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

    public EmailSchema addEnumItem(String string) {
        super.addEnumItemObject(string);
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
        stringBuilder.append("class EmailSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

