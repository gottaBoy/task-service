/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class Variable {
    private String key;
    private String value;
    private Type variableType;
    @JsonProperty(value="protected")
    private Boolean isProtected;
    @JsonProperty(value="masked")
    private Boolean isMasked;
    private String environmentScope;

    public Variable() {
    }

    public Variable(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public Type getVariableType() {
        return this.variableType;
    }

    public void setVariableType(Type type) {
        this.variableType = type;
    }

    public Boolean getProtected() {
        return this.isProtected;
    }

    public void setProtected(Boolean bl) {
        this.isProtected = bl;
    }

    public Boolean getMasked() {
        return this.isMasked;
    }

    public void setMasked(Boolean bl) {
        this.isMasked = bl;
    }

    public String getEnvironmentScope() {
        return this.environmentScope;
    }

    public void setEnvironmentScope(String string) {
        this.environmentScope = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static final List<Variable> convertMapToList(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        ArrayList<Variable> arrayList = new ArrayList<Variable>(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Variable(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static enum Type {
        ENV_VAR,
        FILE;

        private static JacksonJsonEnumHelper<Type> enumHelper;

        @JsonCreator
        public static Type forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Type>(Type.class);
        }
    }
}

