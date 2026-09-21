/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportMeasure;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBIReportMeasureImpl
extends PSObjectImpl
implements IPSAppBIReportMeasure {
    private static final Log log = LogFactory.getLog(PSAppBIReportMeasureImpl.class);
    private IPSAppBIReport iPSAppBIReport = null;
    private IPSSysBIReportMeasure iPSSysBIReportMeasure = null;
    private IPSAppBICubeMeasure iPSAppBICubeMeasure = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBIReport iPSAppBIReport, IPSSysBIReportMeasure iPSSysBIReportMeasure) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBIReport = iPSAppBIReport;
            this.iPSSysBIReportMeasure = iPSSysBIReportMeasure;
            this.setId(this.iPSSysBIReportMeasure.getId());
            this.setName(this.iPSSysBIReportMeasure.getName());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysBIReportMeasure();
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSAppBICubeMeasure = this.getPSAppBIReport().getPSAppBICube().getPSAppBICubeMeasure(this.getPSSysBIReportMeasure().getPSSysBICubeMeasure());
        super.onInit();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBIReport().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBIREPORTMEASURE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBIReport().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppBIReport.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868")
    public IPSAppBIReport getPSAppBIReport() {
        return this.iPSAppBIReport;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807", ignorert=2, dumpref=true, from="IPSAppBIReport", from_method="getPSAppBICubeMust().getPSAppBICubeMeasure", fields={"PSSYSBICUBEMEASUREID"})
    public IPSAppBICubeMeasure getPSAppBICubeMeasure() {
        return this.iPSAppBICubeMeasure;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u6307\u6807")
    public IPSSysBIReportMeasure getPSSysBIReportMeasure() {
        return this.iPSSysBIReportMeasure;
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u7c7b\u578b", codelist="BIReportItemPlaceType", fields={"PLACETYPE"})
    public String getPlaceType() {
        return this.getPSSysBIReportMeasure().getPlaceType();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="AggMode", fields={"AGGTYPE"})
    public String getAggMode() {
        return this.getPSSysBIReportMeasure().getAggMode();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBIReport().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u6807\u8bb0")
    public String getMeasureTag() {
        return this.getPSAppBICubeMeasure().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u540d\u79f0")
    public String getMeasureName() {
        return this.getPSAppBICubeMeasure().getName();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBIReport", from_method="getPSAppBICubeMust().getPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getPSAppDEField() {
        return this.getPSAppBICubeMeasure().getPSAppDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true)
    public IPSAppCodeList getPSAppCodeList() {
        return this.getPSAppBICubeMeasure().getPSAppCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7c7b\u578b", codelist="BIMeasureType")
    public String getMeasureType() {
        return this.getPSAppBICubeMeasure().getMeasureType();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u516c\u5f0f")
    public String getMeasureFormula() {
        return this.getPSAppBICubeMeasure().getMeasureFormula();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7ec4")
    public String getMeasureGroup() {
        return this.getPSAppBICubeMeasure().getMeasureGroup();
    }

    @Override
    @PSModelRTMeta(description="Json\u503c\u683c\u5f0f\u5316")
    public String getJsonFormat() {
        return this.getPSAppBICubeMeasure().getJsonFormat();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u9879\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getMeasureParams() {
        return this.getPSSysBIReportMeasure().getItemParams();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb0", hideempty2=true, fields={"BIREPITEMTAG"})
    public String getItemTag() {
        return this.getPSSysBIReportMeasure().getItemTag();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb02", hideempty2=true, fields={"BIREPITEMTAG2"})
    public String getItemTag2() {
        return this.getPSSysBIReportMeasure().getItemTag2();
    }

    @Override
    @PSModelRTMeta(description="\u94bb\u53d6\u6570\u636e\u5c55\u793a\u89c6\u56fe", dumpref=true)
    public IPSAppView getDrillDownPSAppView() {
        return this.getPSAppBICubeMeasure().getDrillDownPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u53cd\u67e5\u6570\u636e\u5c55\u793a\u89c6\u56fe", dumpref=true)
    public IPSAppView getDrillDetailPSAppView() {
        return this.getPSAppBICubeMeasure().getDrillDetailPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f")
    public String getTextTemplate() {
        return this.getPSAppBICubeMeasure().getTextTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f")
    public String getTipTemplate() {
        return this.getPSAppBICubeMeasure().getTipTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.getPSAppBICubeMeasure().getStdDataType();
    }
}

