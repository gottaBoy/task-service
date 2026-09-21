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

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportDimension;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
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

public class PSAppBIReportDimensionImpl
extends PSObjectImpl
implements IPSAppBIReportDimension {
    private static final Log log = LogFactory.getLog(PSAppBIReportDimensionImpl.class);
    private IPSAppBIReport iPSAppBIReport = null;
    private IPSSysBIReportDimension iPSSysBIReportDimension = null;
    private IPSAppBICubeDimension iPSAppBICubeDimension = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBIReport iPSAppBIReport, IPSSysBIReportDimension iPSSysBIReportDimension) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBIReport = iPSAppBIReport;
            this.iPSSysBIReportDimension = iPSSysBIReportDimension;
            this.setId(this.iPSSysBIReportDimension.getId());
            this.setName(this.iPSSysBIReportDimension.getName());
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
        return this.getPSSysBIReportDimension();
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSAppBICubeDimension = this.getPSAppBIReport().getPSAppBICube().getPSAppBICubeDimension(this.getPSSysBIReportDimension().getPSSysBICubeDimension());
        super.onInit();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBIReport().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBIREPORTDIMENSION";
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
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6", ignorert=2, dumpref=true, from="IPSAppBIReport", from_method="getPSAppBICubeMust().getPSAppBICubeDimension", fields={"PSSYSBICUBEDIMENSIONID"})
    public IPSAppBICubeDimension getPSAppBICubeDimension() {
        return this.iPSAppBICubeDimension;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6")
    public IPSSysBIReportDimension getPSSysBIReportDimension() {
        return this.iPSSysBIReportDimension;
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u7c7b\u578b", codelist="BIReportItemPlaceType", fields={"PLACETYPE"})
    public String getPlaceType() {
        return this.getPSSysBIReportDimension().getPlaceType();
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u4f4d\u7f6e", codelist="BIReportItemPlacement", fields={"PLACEMENT"})
    public String getPlacement() {
        return this.getPSSysBIReportDimension().getPlacement();
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
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb0")
    public String getDimensionTag() {
        return this.getPSAppBICubeDimension().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u540d\u79f0")
    public String getDimensionName() {
        return this.getPSAppBICubeDimension().getName();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBIReport", from_method="getPSAppBICubeMust().getPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getPSAppDEField() {
        return this.getPSAppBICubeDimension().getPSAppDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBIReport", from_method="getPSAppBICubeMust().getPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getTextPSAppDEField() {
        return this.getPSAppBICubeDimension().getTextPSAppDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true)
    public IPSAppCodeList getPSAppCodeList() {
        return this.getPSAppBICubeDimension().getPSAppCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u7c7b\u578b", codelist="BIDimensionType")
    public String getDimensionType() {
        return this.getPSAppBICubeDimension().getDimensionType();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u516c\u5f0f")
    public String getDimensionFormula() {
        return this.getPSAppBICubeDimension().getDimensionFormula();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u9879\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getDimensionParams() {
        return this.getPSSysBIReportDimension().getItemParams();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb0", hideempty2=true, fields={"BIREPITEMTAG"})
    public String getItemTag() {
        return this.getPSSysBIReportDimension().getItemTag();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb02", hideempty2=true, fields={"BIREPITEMTAG2"})
    public String getItemTag2() {
        return this.getPSSysBIReportDimension().getItemTag2();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f")
    public String getTextTemplate() {
        return this.getPSAppBICubeDimension().getTextTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f")
    public String getTipTemplate() {
        return this.getPSAppBICubeDimension().getTipTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.getPSAppBICubeDimension().getStdDataType();
    }
}

