/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;

public interface IWFActionContext {
    public WFActionParam getWFActionParam();

    public String getOpPersonId();

    public IEntity getActiveEntity();

    public IWFModel getWFModel();

    public IWFVersionModel getWFVersionModel();

    public boolean isThreadMode();

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);

    public String getActiveWFInstanceId();

    public void setCurNext(String var1);
}

