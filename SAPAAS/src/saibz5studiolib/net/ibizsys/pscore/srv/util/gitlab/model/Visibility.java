/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL;

    private static JacksonJsonEnumHelper<Visibility> enumHelper;

    @JsonCreator
    public static Visibility forValue(String string) {
        return enumHelper.forValue(string);
    }

    @JsonValue
    public String toValue() {
        return enumHelper.toString(this);
    }

    public String toString() {
        return enumHelper.toString(this);
    }

    static {
        enumHelper = new JacksonJsonEnumHelper<Visibility>(Visibility.class);
    }
}

