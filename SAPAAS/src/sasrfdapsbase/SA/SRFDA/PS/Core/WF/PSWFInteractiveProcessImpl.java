/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pswf.core.IWFInteractiveLinkModel
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;
import SA.SRFDA.PS.Core.WF.PSWFProcessRoleImpl;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"INTERACTIVE"})
public class PSWFInteractiveProcessImpl
extends PSWFProcessImpl
implements IPSWFInteractiveProcess {
    protected ArrayList<IPSWFProcessRole> psWFProcessRoleList = new ArrayList();
    protected ArrayList<IWFProcRoleModel> wfProcRoleModelList = new ArrayList();
    private int nEditMode = 0;
    private String strMultiInstMode = "NONE";
    private Map<String, String> predefinedActionMap = null;
    private List<String> editFieldList = null;
    private String strPSDEFormId = "";
    private String strMobPSDEFormId = "";
    private String strFormCodeName = "";
    private String strMobFormCodeName = "";
    private String strPSDEFormName = "";
    private String strMobPSDEFormName = "";
    private String strPSDEUAGroupId = "";
    private String strMobPSDEUAGroupId = "";
    private String strUAGroupCodeName = "";
    private String strMobUAGroupCodeName = "";
    private String strUtilPSDEFormId = "";
    private String strMobUtilPSDEFormId = "";
    private String strUtilFormCodeName = "";
    private String strMobUtilFormCodeName = "";
    private String strUtil2PSDEFormId = "";
    private String strMobUtil2PSDEFormId = "";
    private String strUtil2FormCodeName = "";
    private String strMobUtil2FormCodeName = "";
    private String strUtil3PSDEFormId = "";
    private String strMobUtil3PSDEFormId = "";
    private String strUtil3FormCodeName = "";
    private String strMobUtil3FormCodeName = "";
    private String strUtil4PSDEFormId = "";
    private String strMobUtil4PSDEFormId = "";
    private String strUtil4FormCodeName = "";
    private String strMobUtil4FormCodeName = "";
    private String strUtil5PSDEFormId = "";
    private String strMobUtil5PSDEFormId = "";
    private String strUtil5FormCodeName = "";
    private String strMobUtil5FormCodeName = "";
    private String strUtilFormName = "";
    private String strMobUtilFormName = "";
    private String strUtil2FormName = "";
    private String strMobUtil2FormName = "";
    private String strUtil3FormName = "";
    private String strMobUtil3FormName = "";
    private String strUtil4FormName = "";
    private String strMobUtil4FormName = "";
    private String strUtil5FormName = "";
    private String strMobUtil5FormName = "";

    @Override
    protected void onInit() throws Exception {
        int n;
        int n2;
        String[] stringArray;
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getPSDEFORMID())) {
            this.strPSDEFormId = this.psWFProcess.getPSDEFORMID();
            this.strFormCodeName = this.psWFProcess.getFORMCODENAME();
            this.strPSDEFormName = this.psWFProcess.getPSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBPSDEFORMID())) {
            this.strMobPSDEFormId = this.psWFProcess.getMOBPSDEFORMID();
            this.strMobFormCodeName = this.psWFProcess.getMOBFORMCODENAME();
            this.strMobPSDEFormName = this.psWFProcess.getMOBPSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getUTILPSDEFORMID())) {
            this.strUtilPSDEFormId = this.psWFProcess.getUTILPSDEFORMID();
            this.strUtilFormCodeName = this.psWFProcess.getUTILFORMCODENAME();
            this.strUtilFormName = this.psWFProcess.getUTILPSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBUTILPSDEFORMID())) {
            this.strMobUtilPSDEFormId = this.psWFProcess.getMOBUTILPSDEFORMID();
            this.strMobUtilFormCodeName = this.psWFProcess.getMOBUTILFORMCODENAME();
            this.strMobUtilFormName = this.psWFProcess.getMOBUTILPSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getUTIL2PSDEFORMID())) {
            this.strUtil2PSDEFormId = this.psWFProcess.getUTIL2PSDEFORMID();
            this.strUtil2FormCodeName = this.psWFProcess.getUTIL2FORMCODENAME();
            this.strUtil2FormName = this.psWFProcess.getUTIL2PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBUTIL2PSDEFORMID())) {
            this.strMobUtil2PSDEFormId = this.psWFProcess.getMOBUTIL2PSDEFORMID();
            this.strMobUtil2FormCodeName = this.psWFProcess.getMOBUTIL2FORMCODENAME();
            this.strMobUtil2FormName = this.psWFProcess.getMOBUTIL2PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getUTIL3PSDEFORMID())) {
            this.strUtil3PSDEFormId = this.psWFProcess.getUTIL3PSDEFORMID();
            this.strUtil3FormCodeName = this.psWFProcess.getUTIL3FORMCODENAME();
            this.strUtil3FormName = this.psWFProcess.getUTIL3PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBUTIL3PSDEFORMID())) {
            this.strMobUtil3PSDEFormId = this.psWFProcess.getMOBUTIL3PSDEFORMID();
            this.strMobUtil3FormCodeName = this.psWFProcess.getMOBUTIL3FORMCODENAME();
            this.strMobUtil3FormName = this.psWFProcess.getMOBUTIL3PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getUTIL4PSDEFORMID())) {
            this.strUtil4PSDEFormId = this.psWFProcess.getUTIL4PSDEFORMID();
            this.strUtil4FormCodeName = this.psWFProcess.getUTIL4FORMCODENAME();
            this.strUtil4FormName = this.psWFProcess.getUTIL4PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBUTIL4PSDEFORMID())) {
            this.strMobUtil4PSDEFormId = this.psWFProcess.getMOBUTIL4PSDEFORMID();
            this.strMobUtil4FormCodeName = this.psWFProcess.getMOBUTIL4FORMCODENAME();
            this.strMobUtil4FormName = this.psWFProcess.getMOBUTIL4PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getUTIL5PSDEFORMID())) {
            this.strUtil5PSDEFormId = this.psWFProcess.getUTIL5PSDEFORMID();
            this.strUtil5FormCodeName = this.psWFProcess.getUTIL5FORMCODENAME();
            this.strUtil5FormName = this.psWFProcess.getUTIL5PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBUTIL5PSDEFORMID())) {
            this.strMobUtil5PSDEFormId = this.psWFProcess.getMOBUTIL5PSDEFORMID();
            this.strMobUtil5FormCodeName = this.psWFProcess.getMOBUTIL5FORMCODENAME();
            this.strMobUtil5FormName = this.psWFProcess.getMOBUTIL5PSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getPSDEUAGROUPID())) {
            this.strPSDEUAGroupId = this.psWFProcess.getPSDEUAGROUPID();
            this.strUAGroupCodeName = this.psWFProcess.getUAGROUPCODENAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBPSDEUAGROUPID())) {
            this.strMobPSDEUAGroupId = this.psWFProcess.getMOBPSDEUAGROUPID();
            this.strMobUAGroupCodeName = this.psWFProcess.getMOBUAGROUPCODENAME();
        }
        super.onInit();
        if (!this.psWFProcess.isEDITFLAGNull()) {
            this.nEditMode = this.psWFProcess.GetParamIntValue("EDITFLAG", 0);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMULTIINSTMODE())) {
            this.strMultiInstMode = this.psWFProcess.getMULTIINSTMODE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getPREDEFINEDACTIONS())) {
            String[] actions;
            this.predefinedActionMap = new LinkedHashMap<String, String>();
            stringArray = actions = this.psWFProcess.getPREDEFINEDACTIONS().split("[;]");
            n2 = actions.length;
            n = 0;
            while (n < n2) {
                String strAction = stringArray[n];
                if (!StringHelper.IsNullOrEmpty((String)strAction)) {
                    this.predefinedActionMap.put(strAction, "");
                }
                ++n;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getEDITFIELDS())) {
            String[] fields = this.psWFProcess.getEDITFIELDS().toUpperCase().split("[;]");
            this.editFieldList = new ArrayList<String>();
            stringArray = fields;
            n2 = fields.length;
            n = 0;
            while (n < n2) {
                String strField = stringArray[n];
                if (!StringHelper.IsNullOrEmpty((String)(strField = strField.trim())) && !this.editFieldList.contains(strField)) {
                    this.editFieldList.add(strField);
                }
                ++n;
            }
        }
    }

    @Override
    protected void preparePSWFLinks() throws Exception {
        this.preparePSWFProcessRoles();
        super.preparePSWFLinks();
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
            iPSWFVersionProcessRole.init(this.getDAGlobalHelper(), this, psWFProcRole);
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

    @Override
    @PSModelRTMeta(description="\u53d1\u9001\u901a\u77e5", fields={"SENDINFORM"})
    public boolean isSendInform() {
        return this.psWFProcess.getSENDINFORM();
    }

    @Override
    public String getMsgTemplateId() {
        return this.psWFProcess.getPSSYSMSGTEMPLID();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u9001\u901a\u77e5\u7c7b\u578b", codelist="WFInfomMsgType", fields={"MSGTYPE"})
    public int getMsgType() {
        return this.psWFProcess.getMSGTYPE();
    }

    @Override
    public boolean isActorIAActionControl() {
        return false;
    }

    @Override
    public Iterator<String> getUDActors() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ea4\u4e92\u5904\u7406\u89d2\u8272\u96c6\u5408", child=true, ignorepf=true)
    public Iterator<IPSWFProcessRole> getPSWFProcessRoles() {
        return this.psWFProcessRoleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false")
    public boolean isEditable() {
        return this.getEditMode() != 0;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u610f\u89c1\u5b57\u6bb5", fields={"MEMOFIELD"})
    public String getMemoField() {
        return this.psWFProcess.getMEMOFIELD();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u5b9e\u4f8b\u6a21\u5f0f", codelist="WFProcMultiInstMode", hideempty2=true, fields={"MULTIINSTMODE"})
    public String getMultiInstMode() {
        return this.strMultiInstMode;
    }

    @Override
    public boolean isEnablePredefinedAction(String strAction) {
        if (this.predefinedActionMap == null) {
            return false;
        }
        return this.predefinedActionMap.containsKey(strAction);
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u884c\u4e3a", hideempty=true, child=true)
    public Iterator<String> getPredefinedActions() {
        if (this.predefinedActionMap == null || this.predefinedActionMap.size() == 0) {
            return null;
        }
        return this.predefinedActionMap.keySet().iterator();
    }

    @Override
    public String getPSDEFormId() {
        return this.strPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"FORMCODENAME"})
    public String getFormCodeName() {
        return this.strFormCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"PSDEFORMNAME"})
    public String getFormName() {
        return this.strPSDEFormName;
    }

    @Override
    public String getMobPSDEFormId() {
        return this.strMobPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBFORMCODENAME"})
    public String getMobFormCodeName() {
        return this.strMobFormCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBPSDEFORMNAME"})
    public String getMobFormName() {
        return this.strMobPSDEFormName;
    }

    @Override
    public String getUtilPSDEFormId() {
        return this.strUtilPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"UTILFORMCODENAME"})
    public String getUtilFormCodeName() {
        return this.strUtilFormCodeName;
    }

    @Override
    public String getMobUtilPSDEFormId() {
        return this.strMobUtilPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBUTILFORMCODENAME"})
    public String getMobUtilFormCodeName() {
        return this.strMobUtilFormCodeName;
    }

    @Override
    public String getUtil2PSDEFormId() {
        return this.strUtil2PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd2\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"UTIL2FORMCODENAME"})
    public String getUtil2FormCodeName() {
        return this.strUtil2FormCodeName;
    }

    @Override
    public String getMobUtil2PSDEFormId() {
        return this.strMobUtil2PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd2\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBUTIL2FORMCODENAME"})
    public String getMobUtil2FormCodeName() {
        return this.strMobUtil2FormCodeName;
    }

    @Override
    public String getUtil3PSDEFormId() {
        return this.strUtil3PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd3\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"UTIL3FORMCODENAME"})
    public String getUtil3FormCodeName() {
        return this.strUtil3FormCodeName;
    }

    @Override
    public String getMobUtil3PSDEFormId() {
        return this.strMobUtil3PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd3\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBUTIL3FORMCODENAME"})
    public String getMobUtil3FormCodeName() {
        return this.strMobUtil3FormCodeName;
    }

    @Override
    public String getUtil4PSDEFormId() {
        return this.strUtil4PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd4\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"UTIL4FORMCODENAME"})
    public String getUtil4FormCodeName() {
        return this.strUtil4FormCodeName;
    }

    @Override
    public String getMobUtil4PSDEFormId() {
        return this.strMobUtil4PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd4\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBUTIL4FORMCODENAME"})
    public String getMobUtil4FormCodeName() {
        return this.strMobUtil4FormCodeName;
    }

    @Override
    public String getUtil5PSDEFormId() {
        return this.strUtil5PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd5\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"UTIL5FORMCODENAME"})
    public String getUtil5FormCodeName() {
        return this.strUtil5FormCodeName;
    }

    @Override
    public String getMobUtil5PSDEFormId() {
        return this.strMobUtil5PSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd5\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBUTIL5FORMCODENAME"})
    public String getMobUtil5FormCodeName() {
        return this.strMobUtil5FormCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"UTILPSDEFORMNAME"})
    public String getUtilFormName() {
        return this.strUtilFormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBUTILPSDEFORMNAME"})
    public String getMobUtilFormName() {
        return this.strMobUtilFormName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd2\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"UTIL2PSDEFORMNAME"})
    public String getUtil2FormName() {
        return this.strUtil2FormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd2\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBUTIL2PSDEFORMNAME"})
    public String getMobUtil2FormName() {
        return this.strMobUtil2FormName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd3\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"UTIL3PSDEFORMNAME"})
    public String getUtil3FormName() {
        return this.strUtil3FormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd3\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBUTIL3PSDEFORMNAME"})
    public String getMobUtil3FormName() {
        return this.strMobUtil3FormName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd4\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"UTIL4PSDEFORMNAME"})
    public String getUtil4FormName() {
        return this.strUtil4FormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd4\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBUTIL4PSDEFORMNAME"})
    public String getMobUtil4FormName() {
        return this.strMobUtil4FormName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd5\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"UTIL5PSDEFORMNAME"})
    public String getUtil5FormName() {
        return this.strUtil5FormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u529f\u80fd5\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBUTIL5PSDEFORMNAME"})
    public String getMobUtil5FormName() {
        return this.strMobUtil5FormName;
    }

    @Override
    protected String onGetWFStepValue() {
        String strWFStepValue = super.onGetWFStepValue();
        if (!StringHelper.IsNullOrEmpty((String)strWFStepValue)) {
            return strWFStepValue;
        }
        return this.getName();
    }

    @Override
    public IPSWFProcessRole getPSWFProcessRole(String strPSWFProcessRoleId) throws Exception {
        if (this.psWFProcessRoleList != null) {
            for (IPSWFProcessRole iPSWFProcessRole : this.psWFProcessRoleList) {
                if (StringHelper.Compare((String)iPSWFProcessRole.getId(), (String)strPSWFProcessRoleId, (boolean)false) != 0) continue;
                return iPSWFProcessRole;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5de5\u4f5c\u6d41\u5904\u7406\u89d2\u8272[%1$s]", (Object)strPSWFProcessRoleId));
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u6a21\u5f0f", codelist="WFProcessEditMode", ignoredumpvalues="0", fields={"EDITFLAG"})
    public int getEditMode() {
        return this.nEditMode;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u76f8\u5173\u5c5e\u6027", hideempty=true, child=true, fields={"EDITFIELDS"})
    public Iterator<String> getEditFields() {
        if (this.editFieldList == null || this.editFieldList.size() == 0) {
            return null;
        }
        return this.editFieldList.iterator();
    }

    @Override
    public String getPSDEUAGroupId() {
        return this.strPSDEUAGroupId;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u754c\u9762\u884c\u4e3a\u7ec4\u6807\u8bb0", fields={"UAGROUPCODENAME"})
    public String getUAGroupCodeName() {
        return this.strUAGroupCodeName;
    }

    @Override
    public String getMobPSDEUAGroupId() {
        return this.strMobPSDEUAGroupId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u9644\u52a0\u754c\u9762\u884c\u4e3a\u7ec4\u6807\u8bb0", fields={"MOBUAGROUPCODENAME"})
    public String getMobUAGroupCodeName() {
        return this.strMobUAGroupCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSDEWF() != null) {
            return this.getPSDEWF().getPSDataEntity();
        }
        return null;
    }
}

