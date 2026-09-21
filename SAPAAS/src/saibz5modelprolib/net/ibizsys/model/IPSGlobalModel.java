/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model;

public interface IPSGlobalModel<KT, VT, HT> {
    public VT findModel(KT var1);

    public HT findModelHelper(KT var1) throws Exception;

    public void resetModel(KT var1);

    public void resetAll();
}

