/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonAnyGetter
 *  com.fasterxml.jackson.annotation.JsonAnySetter
 *  com.fasterxml.jackson.annotation.JsonIgnore
 */
package net.ibizsys.modelapi.util;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.modelapi.util.IPSModelDTO;

public abstract class PSModelDTOBase
implements IPSModelDTO {
    @JsonIgnore
    private Map<String, Object> otherProperties = null;

    @Override
    public Object get(String name) {
        if (this.otherProperties == null) {
            return null;
        }
        return this.otherProperties.get(name);
    }

    @Override
    @JsonAnyGetter
    public Map<String, Object> any() {
        return this.otherProperties;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        if (this.otherProperties == null) {
            this.otherProperties = new HashMap<String, Object>();
        }
        this.otherProperties.put(name, value);
    }

    public boolean contains(String name) {
        if (this.otherProperties == null) {
            return false;
        }
        return this.otherProperties.containsKey(name);
    }

    public void reset() {
        this.otherProperties = null;
    }
}

