/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Print;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEPrintImpl
extends PSDataEntityObjectImpl
implements IPSDEPrint,
IPSAppDEPrint,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEPrintImpl.class);
    protected PSDEPrint psDEPrint;
    protected String strCodeName = "";
    private String strPSDEDataSetId = "";
    private IPSDEDataSet iPSDEDataSet = null;
    private boolean bEnableColPriv = false;
    private boolean bEnablePrintLog = false;
    private boolean bEnableMultiPrint = false;
    private String strGetDataPSDEActionId = null;
    private IPSDEAction getDataPSDEAction = null;
    private String strReportType = null;
    private String strReportFile = null;
    private IPSDEOPPriv getDataPSDEOPPriv = null;
    private String strDetailPSDEId = null;
    private IPSDataEntity refPSDataEntity = null;
    private String strActiveDataPSDELogicId = "";
    private IPSDELogic activeDataPSDELogic = null;
    private int nExtendMode = 0;
    protected boolean bDefaultMode = false;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private int nPOTime = -1;
    private Properties printParams = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEPrint psDEPrint) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEPrint);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEPrint psDEPrint) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEPrint = psDEPrint;
            this.setId(psDEPrint.getPSDEPRINTID());
            this.setName(psDEPrint.getPSDEPRINTNAME());
            this.setPSObjectData(this.psDEPrint);
            this.strCodeName = this.psDEPrint.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEPrint.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEPrint.getEXTENDMODE();
            }
            if (!this.psDEPrint.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEPrint.getDEFAULTMODE();
            }
            this.strDetailPSDEId = this.psDEPrint.getREFPSDEID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDetailPSDEId)) {
                this.refPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.strDetailPSDEId);
                this.strPSDEDataSetId = this.psDEPrint.getPSDEDATASETID();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
                    this.iPSDEDataSet = this.getDetailPSDE().getPSDEDataSet(this.strPSDEDataSetId);
                }
                this.strActiveDataPSDELogicId = this.psDEPrint.getADPSDELOGICID();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getDetailActiveDataPSDELogicId())) {
                    this.activeDataPSDELogic = this.getDetailPSDE().getPSDELogic(this.getDetailActiveDataPSDELogicId());
                }
            } else {
                this.strPSDEDataSetId = this.psDEPrint.getPSDEDATASETID();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
                    this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getGETDATAPSDEACTIONID())) {
                this.strGetDataPSDEActionId = this.psDEPrint.getGETDATAPSDEACTIONID();
                this.getDataPSDEAction = this.getPSDataEntity().getPSDEAction(this.strGetDataPSDEActionId);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getREADPSDEOPPRIVID())) {
                this.getDataPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDEPrint.getREADPSDEOPPRIVID());
            }
            if (this.psDEPrint.getENABLECOLPRIV()) {
                this.bEnableColPriv = this.psDEPrint.getENABLECOLPRIV();
            }
            if (this.psDEPrint.getENABLELOG()) {
                this.bEnablePrintLog = this.psDEPrint.getENABLELOG();
            }
            if (this.psDEPrint.getENABLEMP()) {
                this.bEnableMultiPrint = this.psDEPrint.getENABLEMP();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getREPORTTYPE())) {
                this.strReportType = this.psDEPrint.getREPORTTYPE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getREPORTFILE())) {
                this.strReportFile = this.psDEPrint.getREPORTFILE();
            }
            if (!this.psDEPrint.isPOTIMENull() && this.psDEPrint.getPOTIME() > 0) {
                this.nPOTime = this.psDEPrint.getPOTIME();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getPRINTPARAMS())) {
                this.printParams = PropertiesHelper.Load((String)this.psDEPrint.getPRINTPARAMS());
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
        String strPSSysSFPluginId = this.psDEPrint.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEPrint.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSAppDataEntity() != null ? this.getPSAppDataEntity().getPSApplication().getPSSysPFPlugin(this.psDEPrint.getPSSYSPFPLUGINID(), "DEPRINT", null, null) : this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEPrint.getPSSYSPFPLUGINID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5217\u6743\u9650", ignoredumpvalues="false", ignorepf=true, fields={"ENABLECOLPRIV"})
    public boolean isEnableColPriv() {
        return this.bEnableColPriv;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6253\u5370\u65e5\u5fd7", ignoredumpvalues="false", ignorepf=true, fields={"ENABLELOG"})
    public boolean isEnableLog() {
        return this.bEnablePrintLog;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u591a\u9875\u6253\u5370", ignoredumpvalues="false", fields={"ENABLEMP"})
    public boolean isEnableMulitPrint() {
        return this.bEnableMultiPrint;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"GETDATAPSDEACTIONID"})
    public IPSDEAction getGetDataPSDEAction() {
        return this.getDataPSDEAction;
    }

    @Override
    public String getGetDataPSDEActionId() {
        return this.strGetDataPSDEActionId;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u7c7b\u578b", fields={"REPORTTYPE"})
    public String getReportType() {
        return this.strReportType;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u8def\u5f84", ignorepf=true, fields={"REPORTFILE"})
    public String getReportFile() {
        return this.strReportFile;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, fields={"READPSDEOPPRIVID"})
    public IPSDEOPPriv getGetDataPSDEOPPriv() {
        return this.getDataPSDEOPPriv;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEPRINT";
        }
        return "PSDEPRINT";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getDetailPSDEId() {
        return this.strDetailPSDEId;
    }

    @Override
    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, fields={"REFPSDEID"})
    public IPSDataEntity getDetailPSDE() {
        return this.refPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDetailPSDEMust().getPSDEDataSet", fields={"PSDEDATASETID"})
    public IPSDEDataSet getDetailPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getDetailActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    @Override
    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91", hideempty2=true, ignorepf=true, fields={"ADPSDELOGICID"})
    public IPSDELogic getDetailActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public String getDynaModelFilePath() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return super.getDynaModelFilePath();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u6253\u5370", ignoredumpvalues="false", fields={"DEFAULTMODE"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6a21\u578b", ignorepf=true, fields={"PRINTMODEL"})
    public String getReportModel() {
        return this.psDEPrint.getPRINTMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true, fields={"READPSDEOPPRIVID"})
    public String getDataAccessAction() {
        if (this.getGetDataPSDEOPPriv() == null) {
            return null;
        }
        return this.getGetDataPSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="ReportContentType", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.psDEPrint.getCONTENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5370\u6807\u8bb0", fields={"PRINTTAG"})
    public String getPrintTag() {
        return this.psDEPrint.getPRINTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5370\u6807\u8bb02", fields={"PRINTTAG2"})
    public String getPrintTag2() {
        return this.psDEPrint.getPRINTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"PRINTPARAMS"})
    public Properties getPrintParams() {
        return this.printParams;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u754c\u9762\u6a21\u578b", ignorepf=true, fields={"PRINTUIMODEL"})
    public String getReportUIModel() {
        return this.psDEPrint.getPRINTUIMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSPFPLUGINID"})
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }
}

