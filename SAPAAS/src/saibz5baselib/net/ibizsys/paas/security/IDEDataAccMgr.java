/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataAccMgr {
    public void init(IDataEntityModel var1) throws Exception;

    public CallResult test(IWebContext var1, Object var2, String var3) throws Exception;

    public CallResult test(IWebContext var1, IEntity var2, String var3) throws Exception;

    public CallResult test(IWebContext var1, Object var2, String var3, boolean var4) throws Exception;

    public CallResult test(IWebContext var1, IEntity var2, String var3, boolean var4) throws Exception;

    public void audit(String var1, IWebContext var2, IEntity var3, IEntity var4, String var5) throws Exception;

    public void audit(String var1, String var2, String var3, String var4, IEntity var5, IEntity var6, String var7) throws Exception;
}

