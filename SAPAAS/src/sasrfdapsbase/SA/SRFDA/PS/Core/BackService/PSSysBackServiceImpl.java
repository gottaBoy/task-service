/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BackService;

import SA.SRFDA.PS.Core.BackService.IPSBackService;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysBackService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBackServiceImpl
extends PSSystemObjectImpl
implements IPSSysBackService {
    private static final Log log = LogFactory.getLog(PSSysBackServiceImpl.class);
    protected PSSysBackService psSysBackService = null;
    private IPSBackService iPSBackService = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEAction iPSDEAction = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private boolean bTimerMode = false;
    private boolean bLocalMode = false;
    private boolean bStandalone = false;
    private String strTimerPolicy = "";
    private String strTaskType = "";
    private String strPredefinedType = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysBackService psSysBackService) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysBackService = psSysBackService;
            this.setId(this.psSysBackService.getPSSYSBACKSERVICEID());
            this.setName(this.psSysBackService.getPSSYSBACKSERVICENAME());
            this.setPSObjectData(this.psSysBackService);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSBACKSERVICEID())) {
                this.iPSBackService = this.getPSModelStorage().getPSBackService(this.psSysBackService.getPSBACKSERVICEID());
            }
            this.strTaskType = psSysBackService.getTASKTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strTaskType) || StringHelper.compare((String)this.strTaskType, (String)"DEACTION", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysBackService.getPSDEID());
                    if (this.getPSDataEntity() != null) {
                        if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSDEACTIONID())) {
                            this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysBackService.getPSDEACTIONID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSDEDSID())) {
                            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysBackService.getPSDEDSID());
                        }
                    }
                    this.strTaskType = "DEACTION";
                }
                if (StringHelper.compare((String)this.strTaskType, (String)"DEACTION", (boolean)false) == 0 && this.getPSDEAction() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8c03\u7528\u7684\u5b9e\u4f53\u884c\u4e3a");
                }
            }
            if (StringHelper.compare((String)this.strTaskType, (String)"PREDEFINED", (boolean)false) == 0) {
                this.strPredefinedType = this.psSysBackService.getPREDEFINEDTYPE();
                if (StringHelper.isNullOrEmpty((String)this.strPredefinedType)) {
                    this.strPredefinedType = "USER";
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strTaskType)) {
                this.strTaskType = "USER";
            }
            if (!this.psSysBackService.isTIMERMODENull()) {
                this.bTimerMode = this.psSysBackService.getTIMERMODE() > 0;
                this.bLocalMode = this.psSysBackService.getTIMERMODE() == 2 || this.psSysBackService.getTIMERMODE() == 3;
                boolean bl = this.bStandalone = this.psSysBackService.getTIMERMODE() == 3;
            }
            if (this.isTimerMode()) {
                this.strTimerPolicy = this.psSysBackService.getTIMERPOLICY();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysBackService.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysBackService.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getServiceObject(IPSSysSFPub iPSSysSFPub) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psSysBackService.getSERVICEOBJ())) {
            return this.psSysBackService.getSERVICEOBJ();
        }
        if (this.iPSBackService != null) {
            return this.iPSBackService.getServiceObject(iPSSysSFPub);
        }
        return "#";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u52a8\u6a21\u5f0f", codelist="SysBackServiceStartMode", fields={"STARTMODE"})
    public String getStartMode() {
        return this.psSysBackService.getSTARTMODE();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u5bb9\u5668", codelist="SysBackServiceContainer", fields={"SERVICECONTAINER"})
    public String getServiceContainer() {
        return this.psSysBackService.getSERVICECONTAINER();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u6b21\u5e8f", fields={"RUNORDER"})
    public int getServiceOrder() {
        return this.psSysBackService.getRUNORDER();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAMS"})
    public String getServiceParams() {
        return this.psSysBackService.getSERVICEPARAMS();
    }

    @Override
    public String getModelType() {
        return "PSSYSBACKSERVICE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBackService.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u5904\u7406\u5bf9\u8c61", fields={"SERVICEOBJ"})
    public String getServiceHandler() {
        return this.psSysBackService.getSERVICEOBJ();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u6807\u8bb0", fields={"SERVICETAG"})
    public String getServiceTag() {
        return this.psSysBackService.getSERVICETAG();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u6807\u8bb02", fields={"SERVICETAG2"})
    public String getServiceTag2() {
        return this.psSysBackService.getSERVICETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5bb9\u5668\u6807\u8bb0", fields={"CONTAINERTAG"})
    public String getContainerTag() {
        return this.psSysBackService.getCONTAINERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6570\u636e\u96c6", dumpref=true, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u7b56\u7565", fields={"SERVICEPOLICY"})
    public String getServicePolicy() {
        return this.psSysBackService.getSERVICEPOLICY();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u7b56\u75652", fields={"SERVICEPOLICY2"})
    public String getServicePolicy2() {
        return this.psSysBackService.getSERVICEPOLICY2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u89e6\u53d1\u6a21\u5f0f", ignoredumpvalues="false", fields={"TIMERMODE"})
    public boolean isTimerMode() {
        return this.bTimerMode;
    }

    @Override
    @PSModelRTMeta(description="\u672c\u5730\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isLocalMode() {
        return this.bLocalMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e0d\u542f\u7528\u5206\u5e03\u5f0f", ignoredumpvalues="false")
    public boolean isStandalone() {
        return this.bStandalone;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u89e6\u53d1\u7b56\u7565", fields={"TIMERPOLICY"})
    public String getTimerPolicy() {
        return this.strTimerPolicy;
    }

    @Override
    @PSModelRTMeta(description="\u4efb\u52a1\u7c7b\u578b", codelist="SysBackendTaskType", group="\u57fa\u672c", order=125, fields={"TASKTYPE"})
    public String getTaskType() {
        return this.strTaskType;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", codelist="SysBackendTaskPredefinedType", hideempty2=true, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.strPredefinedType;
    }
}

