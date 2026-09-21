/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.jsonschema.media;

import java.util.LinkedHashMap;
import java.util.Map;

public class Discriminator {
    private String propertyName;
    private Map<String, String> mapping;

    public Discriminator propertyName(String string) {
        this.propertyName = string;
        return this;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String string) {
        this.propertyName = string;
    }

    public Discriminator mapping(String string, String string2) {
        if (this.mapping == null) {
            this.mapping = new LinkedHashMap<String, String>();
        }
        this.mapping.put(string, string2);
        return this;
    }

    public Discriminator mapping(Map<String, String> map) {
        this.mapping = map;
        return this;
    }

    public Map<String, String> getMapping() {
        return this.mapping;
    }

    public void setMapping(Map<String, String> map) {
        this.mapping = map;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Discriminator)) {
            return false;
        }
        Discriminator discriminator = (Discriminator)object;
        if (this.propertyName != null ? !this.propertyName.equals(discriminator.propertyName) : discriminator.propertyName != null) {
            return false;
        }
        return this.mapping != null ? this.mapping.equals(discriminator.mapping) : discriminator.mapping == null;
    }

    public int hashCode() {
        int n = this.propertyName != null ? this.propertyName.hashCode() : 0;
        n = 31 * n + (this.mapping != null ? this.mapping.hashCode() : 0);
        return n;
    }

    public String toString() {
        return "Discriminator{propertyName='" + this.propertyName + '\'' + ", mapping=" + this.mapping + '}';
    }
}

