/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class DateTimeSchema
extends Schema<OffsetDateTime> {
    public DateTimeSchema() {
        super("string", "date-time");
    }

    @Override
    public DateTimeSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public DateTimeSchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public DateTimeSchema _default(Date date) {
        super.setDefault(date);
        return this;
    }

    @Override
    protected OffsetDateTime cast(Object object) {
        if (object != null) {
            try {
                if (object instanceof Date) {
                    return ((Date)object).toInstant().atOffset(ZoneOffset.UTC);
                }
                if (object instanceof String) {
                    return OffsetDateTime.parse((String)object);
                }
                if (object instanceof OffsetDateTime) {
                    return (OffsetDateTime)object;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public DateTimeSchema _enum(List<OffsetDateTime> list) {
        super.setEnum(list);
        return this;
    }

    public DateTimeSchema addEnumItem(OffsetDateTime offsetDateTime) {
        super.addEnumItemObject(offsetDateTime);
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
        stringBuilder.append("class DateTimeSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

