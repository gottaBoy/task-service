/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.MediaType;

public class Content
extends LinkedHashMap<String, MediaType> {
    public Content addMediaType(String string, MediaType mediaType) {
        this.put(string, mediaType);
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
        stringBuilder.append("class Content {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private String toIndentedString(Object object) {
        if (object == null) {
            return "null";
        }
        return object.toString().replace("\n", "\n    ");
    }
}

