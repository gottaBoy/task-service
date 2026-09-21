/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

public class DiffRef {
    private String baseSha;
    private String headSha;
    private String startSha;

    public String getBaseSha() {
        return this.baseSha;
    }

    public void setBaseSha(String string) {
        this.baseSha = string;
    }

    public String getHeadSha() {
        return this.headSha;
    }

    public void setHeadSha(String string) {
        this.headSha = string;
    }

    public String getStartSha() {
        return this.startSha;
    }

    public void setStartSha(String string) {
        this.startSha = string;
    }
}

