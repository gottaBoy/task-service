/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDynaModel
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFLinkModel;

public interface IDynaWFLinkModel
extends IWFLinkModel,
IDynaModel,
IDynaModelJsonLoader {
    public static final String ATTR_WFLINKCONDS = "wflinkconds";
    public static final String ATTR_WFLINKROLES = "wflinkroles";
    public static final String ATTR_FROMWFPROCID = "fromwfprocid";
    public static final String ATTR_TOWFPROCID = "towfprocid";
    public static final String ATTR_LOGICNAME = "logicname";
    public static final String ATTR_NEXTCOND = "nextcond";
    public static final String ATTR_MODELID = "modelid";

    public void init(IDynaWFVersionModel var1, Object var2) throws Exception;
}

