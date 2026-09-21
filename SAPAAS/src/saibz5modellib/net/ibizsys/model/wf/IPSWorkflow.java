/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFModel
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.pswf.core.IWFModel;

public interface IPSWorkflow
extends IPSSystemObject,
IWFModel {
    public static final String WFENGINETYPE_EMBEDDED = "EMBEDDED";
    public static final String WFENGINETYPE_ACTIVITI = "ACTIVITI";
    public static final int WFPROXYMODE_NONE = 0;
    public static final int WFPROXYMODE_CLIENT = 1;
    public static final int WFPROXYMODE_SERVER = 2;

    public String getCodeName();

    public String getLogicName();

    public Iterator<IPSWFVersion> getPSWFVersions() throws Exception;

    public IPSWFVersion getPSWFVersion(String var1) throws Exception;

    public Iterator<IPSDEWF> getPSWFDEs() throws Exception;

    public IPSDEWF getPSDEWF(String var1) throws Exception;

    public IPSCodeList getWFStepPSCodeList();

    public IPSCodeList getEntityStatePSCodeList();

    public Iterator<String> getEntityWFStates();

    public IPSWFVersion getLastPSWFVersion() throws Exception;

    public boolean isValid();

    public String getWFSN();

    public String getWFEngineType();

    public boolean isDynamicWorkflow();

    public IPSLanguageRes getNamePSLanguageRes();

    public boolean isUseRemoteEngine();

    public int getWFProxyMode();
}

