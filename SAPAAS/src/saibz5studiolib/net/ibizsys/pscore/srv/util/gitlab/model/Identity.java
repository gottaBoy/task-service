/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Identity {
    private String provider;
    private String externUid;

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String string) {
        this.provider = string;
    }

    public String getExternUid() {
        return this.externUid;
    }

    public void setExternUid(String string) {
        this.externUid = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

