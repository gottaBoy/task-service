/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 */
package net.ibizsys.pscore.srv.util.gitlab.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;

public class JacksonJsonEnumHelper<E extends Enum<E>> {
    private Map<String, E> valuesMap = new HashMap<String, E>();
    private Map<E, String> namesMap = new HashMap<E, String>();

    public JacksonJsonEnumHelper(Class<E> clazz) {
        this(clazz, false);
    }

    public JacksonJsonEnumHelper(Class<E> clazz, boolean bl) {
        for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
            String string = enum_.name().toLowerCase();
            if (bl) {
                string = string.substring(0, 1).toUpperCase() + string.substring(1);
            }
            this.valuesMap.put(string, enum_);
            this.namesMap.put(enum_, string);
        }
    }

    public JacksonJsonEnumHelper(Class<E> clazz, boolean bl, boolean bl2) {
        for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
            char[] cArray = enum_.name().toLowerCase().toCharArray();
            StringBuilder stringBuilder = new StringBuilder(cArray.length);
            boolean bl3 = bl;
            for (char c : cArray) {
                if (c == '_') {
                    if (bl2) {
                        bl3 = true;
                        continue;
                    }
                    stringBuilder.append(' ');
                    continue;
                }
                if (bl3) {
                    bl3 = false;
                    stringBuilder.append(Character.toUpperCase(c));
                    continue;
                }
                stringBuilder.append(c);
            }
            String object = stringBuilder.toString();
            this.valuesMap.put(object, enum_);
            this.namesMap.put(enum_, object);
        }
    }

    public void addEnum(E e, String string) {
        this.valuesMap.put(string, e);
        this.namesMap.put(e, string);
    }

    @JsonCreator
    public E forValue(String string) {
        return (E)((Enum)this.valuesMap.get(string));
    }

    public String toString(E e) {
        return this.namesMap.get(e);
    }
}

