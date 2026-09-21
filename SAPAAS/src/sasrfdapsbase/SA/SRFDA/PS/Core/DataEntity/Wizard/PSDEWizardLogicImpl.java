/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardLogic;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEWizardLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEWizardLogicImpl
extends PSObjectImpl
implements IPSDEWizardLogic,
IPSAppDEUILogicGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEWizardLogicImpl.class);
    private IPSDEWizard iPSDEWizard = null;
    private PSDEWizardLogic psDEWizardLogic = null;
    private int nOrderValue = 99999;
    private IPSDataEntity iPSDataEntity = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSAppUILogic iPSAppUILogic = null;
    private String strPSSysPFPluginId = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEWizard iPSDEWizard, PSDEWizardLogic psDEWizardLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEWizard = iPSDEWizard;
            this.psDEWizardLogic = psDEWizardLogic;
            this.setId(this.psDEWizardLogic.getPSDEWIZARDLOGICID());
            this.setName(this.psDEWizardLogic.getPSDEWIZARDLOGICNAME());
            this.setPSObjectData(psDEWizardLogic);
            if (!this.psDEWizardLogic.isORDERVALUENull()) {
                this.nOrderValue = this.psDEWizardLogic.getORDERVALUE();
            }
            if (StringHelper.isNullOrEmpty((String)psDEWizardLogic.getPSDEID())) {
                this.iPSDataEntity = iPSDEWizard.getPSDataEntity();
            } else {
                if (this.getPSDataEntity() == null && iPSDEWizard.getPSDataEntity() != null && StringHelper.compare((String)psDEWizardLogic.getPSDEID(), (String)iPSDEWizard.getPSDataEntity().getId(), (boolean)false) == 0) {
                    this.iPSDataEntity = iPSDEWizard.getPSDataEntity();
                }
                if (this.getPSDataEntity() == null) {
                    this.iPSDataEntity = iPSDEWizard.getPSDataEntity().getPSSystem().getPSDataEntity2(psDEWizardLogic.getPSDEID());
                }
            }
            this.getPSDataEntity();
            if (StringHelper.compare((String)this.getLogicType(), (String)"PFPLUGIN", (boolean)false) == 0) {
                this.strPSSysPFPluginId = this.psDEWizardLogic.getPSSYSPFPLUGINID();
                if (StringHelper.isNullOrEmpty((String)this.getPSSysPFPluginId())) {
                    throw new Exception("\u672a\u6307\u5b9a\u524d\u7aef\u63d2\u4ef6");
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSAppDEUILogic() != null) {
            this.getPSAppUILogic().check();
        }
        return super.onCheck();
    }

    @Override
    public IPSDEWizard getPSDEWizard() {
        return this.iPSDEWizard;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEWizard().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEWIZARDLOGIC";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEWizard().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEWizard().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEWizard().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false, group="\u57fa\u672c", order=130)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="UILogicTrigger", group="\u57fa\u672c", order=110, fields={"TRIGGERTYPE"})
    public String getTriggerType() {
        return this.psDEWizardLogic.getTRIGGERTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=112)
    public String getCtrlName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=113)
    public String getItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEWizardFormName())) {
            return this.getPSDEWizardFormName();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEWizardStepName())) {
            return this.getPSDEWizardStepName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=114, fields={"EVENTNAMES"})
    public String getEventNames() {
        return this.psDEWizardLogic.getEVENTNAMES();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570", hideempty2=true, group="\u57fa\u672c", order=116, fields={"EVENTARG"})
    public String getEventArg() {
        return this.psDEWizardLogic.getEVENTARG();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702", hideempty2=true, group="\u57fa\u672c", order=118, fields={"EVENTARG2"})
    public String getEventArg2() {
        return this.psDEWizardLogic.getEVENTARG2();
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=119, fields={"ATTRNAME"})
    public String getAttrName() {
        return this.psDEWizardLogic.getATTRNAME();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", hideempty2=true, codelist="ViewLogicType2", group="\u57fa\u672c", order=120, fields={"DSTLOGICTYPE"})
    public String getLogicType() {
        return this.psDEWizardLogic.getDSTLOGICTYPE();
    }

    @Override
    public String getPSSysViewLogicId() {
        return this.psDEWizardLogic.getPSSYSVIEWLOGICID();
    }

    @Override
    public String getPSDEUILogicId() {
        return this.psDEWizardLogic.getPSDELOGICID();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup() {
        return null;
    }

    @Override
    public IPSDEUILogicGroup getPSDEUILogicGroup() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u5bf9\u8c61", hideempty2=true, dumpref=true, from="IPSAppDataEntity", group="\u57fa\u672c", order=122, fields={"PSDELOGICID"})
    public IPSAppDEUILogic getPSAppDEUILogic() throws Exception {
        if (this.iPSAppDEUILogic == null && !StringHelper.isNullOrEmpty((String)this.getPSDEUILogicId()) && this.getPSAppDataEntity() != null) {
            this.iPSAppDEUILogic = this.getPSAppDataEntity().getPSAppDEUILogic(this.getPSDEUILogicId());
        }
        return this.iPSAppDEUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91\u5bf9\u8c61", hideempty2=true, dumpref=true, from="IPSApplication", group="\u57fa\u672c", order=124, fields={"PSSYSVIEWLOGICID"})
    public IPSAppUILogic getPSAppUILogic() throws Exception {
        if (this.iPSAppUILogic == null && !StringHelper.isNullOrEmpty((String)this.getPSSysViewLogicId()) && this.getPSAppDEUILogicGroup() != null && this.getPSAppDEUILogicGroup().getPSApplication() != null) {
            this.iPSAppUILogic = this.getPSAppDEUILogicGroup().getPSApplication().getPSAppUILogic(this.getPSSysViewLogicId());
        }
        return this.iPSAppUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0", hideempty2=true, fields={"LOGICPARAM"})
    public String getLogicTag() {
        return this.psDEWizardLogic.getLOGICPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb02", hideempty2=true, fields={"LOGICPARAM2"})
    public String getLogicTag2() {
        return this.psDEWizardLogic.getLOGICPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (StringHelper.compare((String)this.getLogicType(), (String)"SCRIPT", (boolean)true) == 0) {
            return this.psDEWizardLogic.getCUSTOMCODE();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u540d\u79f0", hideempty2=true, fields={"PSDEWIZARDSTEPNAME"})
    public String getPSDEWizardStepName() {
        return this.psDEWizardLogic.getPSDEWIZARDSTEPNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u8868\u5355\u540d\u79f0", hideempty2=true, fields={"PSDEWIZARDFORMNAME"})
    public String getPSDEWizardFormName() {
        return this.psDEWizardLogic.getPSDEWIZARDFORMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u6807\u8bc6", hideempty2=true, fields={"PSDEWIZARDSTEPID"})
    public String getPSDEWizardStepId() {
        return this.psDEWizardLogic.getPSDEWIZARDSTEPID();
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u8868\u5355\u6807\u8bc6", hideempty2=true, fields={"PSDEWIZARDFORMID"})
    public String getPSDEWizardFormId() {
        return this.psDEWizardLogic.getPSDEWIZARDFORMID();
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6b65\u9aa4\u6807\u8bb0", hideempty2=true, fields={"STEPTAG"})
    public String getPSDEWizardStepTag() {
        return this.psDEWizardLogic.getSTEPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u8868\u5355\u6807\u8bb0", hideempty2=true, fields={"FORMTAG"})
    public String getPSDEWizardFormTag() {
        return this.psDEWizardLogic.getFORMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        if (StringHelper.compare((String)this.getTriggerType(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.psDEWizardLogic.getTIMER();
    }

    @Override
    public String getPSDEUIActionId() {
        return this.psDEWizardLogic.getPSDEUIACTIONID();
    }

    @Override
    public String getPSSysViewPanelId() {
        return this.psDEWizardLogic.getPSSYSVIEWPANELID();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }
}

