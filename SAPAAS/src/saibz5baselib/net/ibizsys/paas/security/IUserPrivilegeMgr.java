/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import java.io.Serializable;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

public interface IUserPrivilegeMgr
extends Serializable {
    public static final String TESTRESULT_CACHE = "CACHE";

    public void reset(IWebContext var1);

    public void reset();

    public boolean test(IWebContext var1, String var2) throws Exception;

    public int testDEField(IWebContext var1, String var2) throws Exception;

    public CallResult testDataAccessAction(IWebContext var1, IDataEntityModel var2, IEntity var3, String var4) throws Exception;

    public CallResult testDataAccessAction(IWebContext var1, IDataEntityModel var2, Object var3, String var4) throws Exception;
}

