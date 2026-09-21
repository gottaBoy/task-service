/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.util.IGlobalContext;

public interface IGlobalModel<KT, VT, HT> {
    public void init(IGlobalContext var1) throws Exception;

    public VT getObjectData(KT var1) throws Exception;

    public HT getObject(KT var1) throws Exception;

    public void resetObject(KT var1);

    public void resetAll();
}

