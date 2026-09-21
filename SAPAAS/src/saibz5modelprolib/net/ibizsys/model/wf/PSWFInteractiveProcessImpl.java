/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFProcessRole
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFInteractiveLinkModel
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcessRole;
import net.ibizsys.model.wf.PSWFProcessImpl;
import net.ibizsys.model.wf.PSWFProcessRoleImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;

public class PSWFInteractiveProcessImpl
extends PSWFProcessImpl
implements IPSWFInteractiveProcess {
    protected ArrayList<IPSWFProcessRole> psWFProcessRoleList = new ArrayList();
    protected ArrayList<IWFProcRoleModel> wfProcRoleModelList = new ArrayList();
    private boolean bEditable = false;
    private String strMultiInstMode = "NONE";
    private HashMap<String, String> predefinedActionMap = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psWFProcess.isEDITFLAGNull()) {
            this.bEditable = this.psWFProcess.getEDITFLAG();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getMULTIINSTMODE())) {
            this.strMultiInstMode = this.psWFProcess.getMULTIINSTMODE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getPREDEFINEDACTIONS())) {
            String[] actions;
            this.predefinedActionMap = new HashMap();
            String[] stringArray = actions = this.psWFProcess.getPREDEFINEDACTIONS().split("[;]");
            int n = actions.length;
            int n2 = 0;
            while (n2 < n) {
                String strAction = stringArray[n2];
                if (!StringHelper.isNullOrEmpty((String)strAction)) {
                    this.predefinedActionMap.put(strAction, "");
                }
                ++n2;
            }
        }
        this.preparePSWFProcessRoles();
    }

    protected void preparePSWFProcessRoles() throws Exception {
        this.psWFProcessRoleList.clear();
        this.wfProcRoleModelList.clear();
        ArrayList<PSWFProcRole> psWFProcessRoleList = this.psWFProcess.getPSWFProcRoles(false);
        if (psWFProcessRoleList == null) {
            return;
        }
        for (PSWFProcRole psWFProcRole : psWFProcessRoleList) {
            PSWFProcessRoleImpl iPSWFVersionProcessRole = new PSWFProcessRoleImpl();
            iPSWFVersionProcessRole.init(this.getPSModelStorageContext(), this, psWFProcRole);
            this.psWFProcessRoleList.add(iPSWFVersionProcessRole);
        }
        this.wfProcRoleModelList.addAll(this.psWFProcessRoleList);
    }

    public Iterator<IWFInteractiveLinkModel> getWFInteractiveLinkModels() {
        return null;
    }

    public IWFInteractiveLinkModel getWFInteractiveLinkModel(String strName, boolean bTryMode) throws Exception {
        return null;
    }

    public Iterator<IWFProcRoleModel> getWFProcRoleModels() {
        return this.wfProcRoleModelList.iterator();
    }

    @PSModelRTMeta(description="\u53d1\u9001\u901a\u77e5")
    public boolean isSendInform() {
        return this.psWFProcess.getSENDINFORM();
    }

    public String getMsgTemplateId() {
        return this.psWFProcess.getPSSYSMSGTEMPLID();
    }

    public int getMsgType() {
        return this.psWFProcess.getMSGTYPE();
    }

    public boolean isActorIAActionControl() {
        return false;
    }

    public Iterator<String> getUDActors() {
        return null;
    }

    @PSModelRTMeta(description="\u4ea4\u4e92\u5904\u7406\u89d2\u8272\u96c6\u5408")
    public Iterator<IPSWFProcessRole> getPSWFProcessRoles() {
        return this.psWFProcessRoleList.iterator();
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u7f16\u8f91")
    public boolean isEditable() {
        return this.bEditable;
    }

    @PSModelRTMeta(description="\u5904\u7406\u610f\u89c1\u5b57\u6bb5")
    public String getMemoField() {
        return this.psWFProcess.getMEMOFIELD();
    }

    @PSModelRTMeta(description="\u591a\u5b9e\u4f8b\u6a21\u5f0f", codelist="WFProcMultiInstMode", hideempty2=true)
    public String getMultiInstMode() {
        return this.strMultiInstMode;
    }

    public boolean isEnablePredefinedAction(String strAction) {
        if (this.predefinedActionMap == null) {
            return false;
        }
        return this.predefinedActionMap.containsKey(strAction);
    }

    public Iterator<String> getPredefinedActions() {
        if (this.predefinedActionMap == null || this.predefinedActionMap.size() == 0) {
            return null;
        }
        return this.predefinedActionMap.values().iterator();
    }
}

