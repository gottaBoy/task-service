/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSSysDashboardLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDashboardLogicImpl
extends PSObjectImpl
implements IPSSysDashboardLogic,
IPSAppDEUILogicGroupDetail {
    private static final Log log = LogFactory.getLog(PSSysDashboardLogicImpl.class);
    private IPSSysDashboard iPSSysDashboard = null;
    private PSSysDashboardLogic psSysDashboardLogic = null;
    private int nOrderValue = 99999;
    private IPSDataEntity iPSDataEntity = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSAppUILogic iPSAppUILogic = null;
    private String strPSSysPFPluginId = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDashboard iPSSysDashboard, PSSysDashboardLogic psSysDashboardLogic) throws Exception {
        try {
            PSDELogic psDELogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysDashboard = iPSSysDashboard;
            this.psSysDashboardLogic = psSysDashboardLogic;
            this.setId(this.psSysDashboardLogic.getPSSYSDASHBOARDLOGICID());
            this.setName(this.psSysDashboardLogic.getPSSYSDASHBOARDLOGICNAME());
            this.setPSObjectData(psSysDashboardLogic);
            if (!this.psSysDashboardLogic.isORDERVALUENull()) {
                this.nOrderValue = this.psSysDashboardLogic.getORDERVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEUILogicId()) && (psDELogic = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDELogicData(this.getPSDEUILogicId(), true)) != null) {
                psSysDashboardLogic.setPSDEID(psDELogic.getPSDEID());
            }
            if (StringHelper.isNullOrEmpty((String)psSysDashboardLogic.getPSDEID())) {
                this.iPSDataEntity = iPSSysDashboard.getPSDataEntity();
            } else {
                if (this.getPSDataEntity() == null && iPSSysDashboard.getPSDataEntity() != null && StringHelper.compare((String)psSysDashboardLogic.getPSDEID(), (String)iPSSysDashboard.getPSDataEntity().getId(), (boolean)false) == 0) {
                    this.iPSDataEntity = iPSSysDashboard.getPSDataEntity();
                }
                if (this.getPSDataEntity() == null) {
                    this.iPSDataEntity = iPSSysDashboard.getPSAppView().getPSSystem().getPSDataEntity2(psSysDashboardLogic.getPSDEID());
                }
            }
            if (this.getPSDataEntity() != null) {
                this.iPSAppDataEntity = this.getPSSysDashboard().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
            }
            if (StringHelper.compare((String)this.getLogicType(), (String)"PFPLUGIN", (boolean)false) == 0) {
                this.strPSSysPFPluginId = this.psSysDashboardLogic.getPSSYSPFPLUGINID();
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
    public IPSSysDashboard getPSSysDashboard() {
        return this.iPSSysDashboard;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysDashboard().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSDASHBOARDLOGIC";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysDashboard().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysDashboard().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysDashboard().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false, group="\u57fa\u672c", order=130)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="UILogicTrigger", group="\u57fa\u672c", order=110, fields={"TRIGGERTYPE"})
    public String getTriggerType() {
        return this.psSysDashboardLogic.getTRIGGERTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=112)
    public String getCtrlName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=113)
    public String getItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.getPSSysDashboardPartName())) {
            return this.getPSSysDashboardPartName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=114, fields={"EVENTNAMES"})
    public String getEventNames() {
        return this.psSysDashboardLogic.getEVENTNAMES();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570", hideempty2=true, group="\u57fa\u672c", order=116, fields={"EVENTARG"})
    public String getEventArg() {
        return this.psSysDashboardLogic.getEVENTARG();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702", hideempty2=true, group="\u57fa\u672c", order=118, fields={"EVENTARG2"})
    public String getEventArg2() {
        return this.psSysDashboardLogic.getEVENTARG2();
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=119, fields={"ATTRNAME"})
    public String getAttrName() {
        return this.psSysDashboardLogic.getATTRNAME();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", hideempty2=true, codelist="ViewLogicType2", group="\u57fa\u672c", order=120, fields={"DSTLOGICTYPE"})
    public String getLogicType() {
        return this.psSysDashboardLogic.getDSTLOGICTYPE();
    }

    @Override
    public String getPSSysViewLogicId() {
        return this.psSysDashboardLogic.getPSSYSVIEWLOGICID();
    }

    @Override
    public String getPSDEUILogicId() {
        return this.psSysDashboardLogic.getPSDELOGICID();
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
        return this.psSysDashboardLogic.getLOGICPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb02", hideempty2=true, fields={"LOGICPARAM2"})
    public String getLogicTag2() {
        return this.psSysDashboardLogic.getLOGICPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (StringHelper.compare((String)this.getLogicType(), (String)"SCRIPT", (boolean)true) == 0) {
            return this.psSysDashboardLogic.getCUSTOMCODE();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u770b\u677f\u90e8\u4ef6\u540d\u79f0", hideempty2=true, fields={"PSSYSDBPARTNAME"})
    public String getPSSysDashboardPartName() {
        return this.psSysDashboardLogic.getPSSYSDBPARTNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        if (StringHelper.compare((String)this.getTriggerType(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.psSysDashboardLogic.getTIMER();
    }

    @Override
    public String getPSDEUIActionId() {
        return this.psSysDashboardLogic.getPSDEUIACTIONID();
    }

    @Override
    public String getPSSysViewPanelId() {
        return this.psSysDashboardLogic.getPSSYSVIEWPANELID();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSSysDashboard();
    }
}

