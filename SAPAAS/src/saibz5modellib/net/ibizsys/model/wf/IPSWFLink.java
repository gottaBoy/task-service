/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWFLinkGroupCond;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.pswf.core.IWFLinkModel;

public interface IPSWFLink
extends IPSModelObject,
IWFLinkModel {
    public static final String WFLINKTYPE_TIMEOUT = "TIMEOUT";
    public static final String WFLINKTYPE_IAACTION = "IAACTION";
    public static final String WFLINKTYPE_ROUTE = "ROUTE";

    public IPSWFLinkGroupCond getPSWFLinkGroupCond();

    public IPSWFProcess getToPSWFProcess() throws Exception;

    public IPSWFProcess getFromPSWFProcess() throws Exception;

    public IPSWFVersion getPSWFVersion();

    public String getWFLinkType();

    public String getLogicName();

    public String getMemoField();

    public IPSLanguageRes getLNPSLanguageRes();

    public boolean isEnableCustomCond();

    public String getCustomCond();
}

