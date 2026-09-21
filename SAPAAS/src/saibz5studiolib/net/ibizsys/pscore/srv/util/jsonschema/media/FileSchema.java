/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class FileSchema
extends Schema<String> {
    public FileSchema() {
        super("string", "binary");
    }

    @Override
    public FileSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public FileSchema format(String string) {
        super.setFormat(string);
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
        stringBuilder.append("class FileSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

