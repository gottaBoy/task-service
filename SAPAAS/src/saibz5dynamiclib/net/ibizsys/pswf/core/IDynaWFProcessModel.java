/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDynaModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IDynaWFProcessModel
extends IWFProcessModel,
IDynaModel,
IDynaModelJsonLoader {
    public static final String ATTR_WFPROCSUBWFS = "wfprocsubwfs";
    public static final String ATTR_WFPROCROLES = "wfprocroles";
    public static final String ATTR_WFPROCPARAMS = "wfprocparams";
    public static final String ATTR_LEFTPOS = "leftpos";
    public static final String ATTR_TOPPOS = "toppos";
    public static final String ATTR_WFSTEPVALUE = "wfstepvalue";
    public static final String ATTR_ASYNCMODE = "asyncmode";
    public static final String ATTR_EDITABLE = "editable";
    public static final String ATTR_MEMOFIELD = "memofield";
    public static final String ATTR_USERDATA = "userdata";
    public static final String ATTR_USERDATA2 = "userdata2";
    public static final String ATTR_SENDINFORM = "sendinform";
    public static final String ATTR_MSGTYPE = "msgtype";
    public static final String ATTR_SYSMSGTEMPLID = "sysmsgtemplid";
    public static final String ATTR_MODELID = "modelid";
    public static final String ATTR_DEACTIONNAME = "deactionname";

    public void init(IDynaWFVersionModel var1, Object var2) throws Exception;
}

