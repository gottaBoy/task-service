/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEWF
 */
package net.ibizsys.model.dataentity.wf;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.IDEWF;

public interface IPSDEWF
extends IPSDataEntityObject,
IDEWF {
    public boolean isValid();

    public IPSWorkflow getPSWorkflow();

    public String getCodeName();

    public IPSDEField getWFStepPSDEField();

    public IPSDEField getWFStatePSDEField();

    public IPSDEField getUDStatePSDEField();

    public IPSDEField getWFInstPSDEField();

    public IPSDEField getWFActorsPSDEField();

    public IPSDEField getWFRetPSDEField();

    public IPSCodeList getWFStepPSCodeList() throws Exception;

    public IPSCodeList getEntityStatePSCodeList() throws Exception;

    public boolean isDefaultMode();

    public boolean isEnableUserStart();

    public IPSDEAction getInitPSDEAction();

    public IPSDEAction getFinishPSDEAction();

    public IPSDEField getWFVerPSDEField();

    public IPSDEField getWorkflowPSDEField();

    public String getMyWFWorkCaption();

    public IPSLanguageRes getMyWFWorkCapPSLanguageRes();

    public String getMyWFDataCaption();

    public IPSLanguageRes getMyWFDataCapPSLanguageRes();

    public int getWFProxyMode();

    public IPSDEField getProxyModulePSDEField();

    public IPSDEField getProxyDataPSDEField();
}

