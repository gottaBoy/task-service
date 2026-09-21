/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.PSSysBICubeObjectImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBICubeMeasure;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBICubeMeasureImpl
extends PSSysBICubeObjectImpl
implements IPSSysBICubeMeasure {
    private static final Log log = LogFactory.getLog(PSSysBICubeMeasureImpl.class);
    protected PSSysBICubeMeasure psSysBICubeMeasure = null;
    private String strCubeMeasureType = "COMMON";
    private IPSDEField iPSDEField = null;
    private boolean bHiddenItem = false;
    private String strMeasureFormula = null;
    private String strValueFormat = null;
    private String strAggMode = null;
    private IPSCodeList iPSCodeList = null;
    private int nStdDataType = 0;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBICube iPSSysBICube, PSSysBICubeMeasure psSysBICubeMeasure) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBICube(iPSSysBICube);
            this.psSysBICubeMeasure = psSysBICubeMeasure;
            this.setId(this.psSysBICubeMeasure.getPSSYSBICUBEMEASUREID());
            this.setName(this.psSysBICubeMeasure.getPSSYSBICUBEMEASURENAME());
            this.setPSObjectData(this.psSysBICubeMeasure);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeMeasure.getBIMEASURETYPE())) {
                this.strCubeMeasureType = this.psSysBICubeMeasure.getBIMEASURETYPE();
            }
            if (!this.psSysBICubeMeasure.isHIDDENDATAITEMNull()) {
                this.bHiddenItem = this.psSysBICubeMeasure.getHIDDENDATAITEM();
            }
            if ("COMMON".equals(this.getMeasureType())) {
                if (this.getPSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICubeMeasure.getPSDEFID())) {
                    this.iPSDEField = this.getPSSysBICube().getPSDataEntity().getPSDEField(this.psSysBICubeMeasure.getPSDEFID());
                }
                if (this.getPSDEField() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", new Object[0]));
                }
            } else if ("CALCULATED".equals(this.getMeasureType())) {
                if (StringHelper.isNullOrEmpty((String)this.getMeasureFormula()) && !StringHelper.isNullOrEmpty((String)this.psSysBICubeMeasure.getMEASUREFORMULA())) {
                    this.strMeasureFormula = this.psSysBICubeMeasure.getMEASUREFORMULA();
                }
                if (StringHelper.isNullOrEmpty((String)this.getMeasureFormula())) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6307\u6807\u516c\u5f0f", new Object[0]));
                }
            }
            this.strAggMode = this.psSysBICubeMeasure.getAGGTYPE();
            if (StringHelper.isNullOrEmpty((String)this.getAggMode()) && !this.isDataItem() && !"CALCULATED".equals(this.getMeasureType()) && StringHelper.isNullOrEmpty((String)this.getAggMode())) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u6807\u805a\u5408\u6a21\u5f0f", new Object[0]));
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeMeasure.getVALUEFORMAT())) {
                this.strValueFormat = this.psSysBICubeMeasure.getVALUEFORMAT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeMeasure.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSSysBICube().getPSSysBIScheme().getPSSystem().getPSCodeList(this.psSysBICubeMeasure.getPSCODELISTID());
            }
            if (!this.psSysBICubeMeasure.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysBICubeMeasure.getSTDDATATYPE();
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
    public String getModelType() {
        return "PSSYSBICUBEMEASURE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysBICubeMeasure.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u6807\u8bb0", hideempty2=true, fields={"BICUBEMEASURETAG"})
    public String getMeasureTag() {
        return this.psSysBICubeMeasure.getBICUBEMEASURETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u6807\u8bb02", hideempty2=true, fields={"BICUBEMEASURETAG2"})
    public String getMeasureTag2() {
        return this.psSysBICubeMeasure.getBICUBEMEASURETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7c7b\u578b", codelist="BIMeasureType", fields={"BIMEASURETYPE"})
    public String getMeasureType() {
        return this.strCubeMeasureType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSSysBICube", from_method="getPSDataEntityMust().getPSDEField", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879", ignoredumpvalues="false", fields={"HIDDENDATAITEM"})
    public boolean isDataItem() {
        return this.bHiddenItem;
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u516c\u5f0f", fields={"MEASUREFORMULA"})
    public String getMeasureFormula() {
        return this.strMeasureFormula;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7ec4", fields={"BIMEASUREGROUP"})
    public String getMeasureGroup() {
        return this.psSysBICubeMeasure.getBIMEASUREGROUP();
    }

    @Override
    @PSModelRTMeta(description="Json\u503c\u683c\u5f0f\u5316", fields={"JSONFORMAT"})
    public String getJsonFormat() {
        return this.psSysBICubeMeasure.getJSONFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="AggMode", fields={"AGGTYPE"})
    public String getAggMode() {
        return this.strAggMode;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public String getDrillDownPSDEViewId() {
        return this.psSysBICubeMeasure.getDRILLDOWNPSDEVIEWID();
    }

    @Override
    public String getParamPSDEUIActionId() {
        return this.psSysBICubeMeasure.getPARAMPSDEUIACTIONID();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u914d\u7f6e\u754c\u9762\u884c\u4e3a\u6807\u8bb0", hideempty=true)
    public String getParamPSDEUIActionTag() throws Exception {
        IPSDEUIAction iPSDEUIAction;
        if (!StringHelper.isNullOrEmpty((String)this.getParamPSDEUIActionId()) && (iPSDEUIAction = this.getPSSysBICube().getPSDataEntity().getPSDEUIAction(this.getParamPSDEUIActionId(), true)) != null) {
            return iPSDEUIAction.getUIActionFullTag();
        }
        return null;
    }

    @Override
    public String getDrillDetailPSDEViewId() {
        return this.psSysBICubeMeasure.getDRILLDETAILPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u53cd\u67e5\u6269\u5c55\u6761\u4ef6", fields={"DRILLDETAILCUSTOMCOND"})
    public String getDrillDetailCustomCond() {
        return this.psSysBICubeMeasure.getDRILLDETAILCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        if (this.nStdDataType == 0 && this.getPSDEField() != null) {
            return this.getPSDEField().getStdDataType();
        }
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f", fields={"TEXTTEMPLATE"})
    public String getTextTemplate() {
        return this.psSysBICubeMeasure.getTEXTTEMPLATE();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f", fields={"TIPTEMPLATE"})
    public String getTipTemplate() {
        return this.psSysBICubeMeasure.getTIPTEMPLATE();
    }
}

