/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;

public class DateSchema
extends Schema<Date> {
    public DateSchema() {
        super("string", "date");
    }

    @Override
    public DateSchema type(String string) {
        super.setType(string);
        return this;
    }

    @Override
    public DateSchema format(String string) {
        super.setFormat(string);
        return this;
    }

    public DateSchema _default(Date date) {
        super.setDefault(date);
        return this;
    }

    @Override
    protected Date cast(Object object) {
        if (object != null) {
            try {
                if (object instanceof Date) {
                    return (Date)object;
                }
                if (object instanceof String) {
                    return new SimpleDateFormat("yyyy-MM-dd Z").parse((String)object + " UTC");
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public DateSchema addEnumItem(Date date) {
        super.addEnumItemObject(date);
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
        stringBuilder.append("class DateSchema {\n");
        stringBuilder.append("    ").append(this.toIndentedString(super.toString())).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

