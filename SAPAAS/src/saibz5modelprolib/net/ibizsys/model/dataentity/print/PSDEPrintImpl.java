/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.print;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.print.IPSDEPrintRuntime;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEPrintImpl
extends PSDataEntityObjectImpl
implements IPSDEPrintRuntime {
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEPrint psDEPrint) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psDEPrint = psDEPrint;
            this.setId(psDEPrint.getPSDEPRINTID());
            this.setName(psDEPrint.getPSDEPRINTNAME());
            this.setPSObjectData(this.psDEPrint);
            this.strCodeName = this.psDEPrint.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEPrint.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEPrint.getEXTENDMODE();
            }
            this.strDetailPSDEId = this.psDEPrint.getREFPSDEID();
            if (!StringHelper.isNullOrEmpty((String)this.strDetailPSDEId)) {
                this.refPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity(this.strDetailPSDEId);
                this.strPSDEDataSetId = this.psDEPrint.getPSDEDATASETID();
                if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
                    this.iPSDEDataSet = this.getDetailPSDE().getPSDEDataSet(this.strPSDEDataSetId);
                }
                this.strActiveDataPSDELogicId = this.psDEPrint.getADPSDELOGICID();
                if (!StringHelper.isNullOrEmpty((String)this.getDetailActiveDataPSDELogicId())) {
                    this.activeDataPSDELogic = this.getDetailPSDE().getPSDELogic(this.getDetailActiveDataPSDELogicId());
                }
            } else {
                this.strPSDEDataSetId = this.psDEPrint.getPSDEDATASETID();
                if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
                    this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEPrint.getGETDATAPSDEACTIONID())) {
                this.strGetDataPSDEActionId = this.psDEPrint.getGETDATAPSDEACTIONID();
                this.getDataPSDEAction = this.getPSDataEntity().getPSDEAction(this.strGetDataPSDEActionId);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEPrint.getREADPSDEOPPRIVID())) {
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
            if (!StringHelper.isNullOrEmpty((String)this.psDEPrint.getREPORTTYPE())) {
                this.strReportType = this.psDEPrint.getREPORTTYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEPrint.getREPORTFILE())) {
                this.strReportFile = this.psDEPrint.getREPORTFILE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    @PSModelRTMeta(description="\u542f\u7528\u5217\u6743\u9650")
    public boolean isEnableColPriv() {
        return this.bEnableColPriv;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6253\u5370\u65e5\u5fd7")
    public boolean isEnableLog() {
        return this.bEnablePrintLog;
    }

    @PSModelRTMeta(description="\u542f\u7528\u591a\u9875\u6253\u5370")
    public boolean isEnableMulitPrint() {
        return this.bEnableMultiPrint;
    }

    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getGetDataPSDEAction() {
        return this.getDataPSDEAction;
    }

    public String getGetDataPSDEActionId() {
        return this.strGetDataPSDEActionId;
    }

    @PSModelRTMeta(description="\u62a5\u8868\u7c7b\u578b")
    public String getReportType() {
        return this.strReportType;
    }

    public String getReportFile() {
        return this.strReportFile;
    }

    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getGetDataPSDEOPPriv() {
        return this.getDataPSDEOPPriv;
    }

    public String getDetailPSDEId() {
        return this.strDetailPSDEId;
    }

    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getDetailPSDE() {
        return this.refPSDataEntity;
    }

    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true)
    public IPSDEDataSet getDetailPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public String getDetailActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    @PSModelRTMeta(description="\u660e\u7ec6\u6570\u636e\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91", hideempty2=true)
    public IPSDELogic getDetailActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }
}

