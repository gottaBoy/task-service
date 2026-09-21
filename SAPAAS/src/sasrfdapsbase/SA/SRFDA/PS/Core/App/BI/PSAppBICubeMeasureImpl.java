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

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBICubeMeasureImpl
extends PSObjectImpl
implements IPSAppBICubeMeasure {
    private static final Log log = LogFactory.getLog(PSAppBICubeMeasureImpl.class);
    private IPSAppBICube iPSAppBICube = null;
    private IPSSysBICubeMeasure iPSSysBICubeMeasure = null;
    private IPSAppDEField iPSAppDEField = null;
    private IPSAppCodeList iPSAppCodeList = null;
    private IPSAppDEUIAction paramPSAppDEUIAction = null;
    private IPSAppView drillDownPSAppView = null;
    private IPSAppView drillDetailPSAppView = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBICube iPSAppBICube, IPSSysBICubeMeasure iPSSysBICubeMeasure) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBICube = iPSAppBICube;
            this.iPSSysBICubeMeasure = iPSSysBICubeMeasure;
            this.setId(this.iPSSysBICubeMeasure.getId());
            this.setName(this.iPSSysBICubeMeasure.getName());
            if (!StringHelper.IsNullOrEmpty((String)iPSSysBICubeMeasure.getParamPSDEUIActionId())) {
                this.paramPSAppDEUIAction = this.getPSAppBICube().getPSAppDataEntity().getPSAppDEUIAction(iPSSysBICubeMeasure.getParamPSDEUIActionId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSSysBICubeMeasure.getDrillDownPSDEViewId())) {
                this.drillDownPSAppView = this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSAppViewByDEViewId(iPSSysBICubeMeasure.getDrillDownPSDEViewId(), false);
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSSysBICubeMeasure.getDrillDetailPSDEViewId())) {
                this.drillDetailPSAppView = this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSAppViewByDEViewId(iPSSysBICubeMeasure.getDrillDetailPSDEViewId(), false);
            }
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
        return this.getPSSysBICubeMeasure();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSysBICubeMeasure().getPSDEField() != null && this.getPSAppBICube().getPSAppDataEntity() != null) {
            this.iPSAppDEField = this.getPSAppBICube().getPSAppDataEntity().getPSAppDEField(this.getPSSysBICubeMeasure().getPSDEField(), false);
        }
        if (this.getPSSysBICubeMeasure().getPSCodeList() != null) {
            this.iPSAppCodeList = this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSAppCodeList(this.getPSSysBICubeMeasure().getPSCodeList(), false);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBICubeMeasure().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u6807\u8bb0", hideempty2=true)
    public String getMeasureTag() {
        return this.getPSSysBICubeMeasure().getMeasureTag();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u6807\u8bb02", hideempty2=true)
    public String getMeasureTag2() {
        return this.getPSSysBICubeMeasure().getMeasureTag2();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7c7b\u578b", codelist="BIMeasureType")
    public String getMeasureType() {
        return this.getPSSysBICubeMeasure().getMeasureType();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879", ignoredumpvalues="false")
    public boolean isDataItem() {
        return this.getPSSysBICubeMeasure().isDataItem();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u516c\u5f0f")
    public String getMeasureFormula() {
        return this.getPSSysBICubeMeasure().getMeasureFormula();
    }

    @Override
    @PSModelRTMeta(description="\u6307\u6807\u7ec4")
    public String getMeasureGroup() {
        return this.getPSSysBICubeMeasure().getMeasureGroup();
    }

    @Override
    @PSModelRTMeta(description="Json\u503c\u683c\u5f0f\u5316")
    public String getJsonFormat() {
        return this.getPSSysBICubeMeasure().getJsonFormat();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBICube", from_method="getPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBICUBEMEASURE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBICube().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppBICube.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53")
    public IPSAppBICube getPSAppBICube() {
        return this.iPSAppBICube;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807")
    public IPSSysBICubeMeasure getPSSysBICubeMeasure() {
        return this.iPSSysBICubeMeasure;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="AggMode")
    public String getAggMode() {
        return this.getPSSysBICubeMeasure().getAggMode();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBICube().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, fields={"PSCODELISTID"})
    public IPSAppCodeList getPSAppCodeList() {
        return this.iPSAppCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u914d\u7f6e\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", dumpref=true, from="IPSAppBICube", from_method="getPSAppDataEntityMust().getPSAppDEUIAction", fields={"PARAMPSDEUIACTIONID"})
    public IPSAppDEUIAction getParamPSAppDEUIAction() {
        return this.paramPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u94bb\u53d6\u6570\u636e\u5c55\u793a\u89c6\u56fe", dumpref=true, fields={"DRILLDOWNPSDEVIEWID"})
    public IPSAppView getDrillDownPSAppView() {
        return this.drillDownPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u53cd\u67e5\u6570\u636e\u5c55\u793a\u89c6\u56fe", dumpref=true, fields={"DRILLDETAILPSDEVIEWID"})
    public IPSAppView getDrillDetailPSAppView() {
        return this.drillDetailPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f", fields={"TEXTTEMPLATE"})
    public String getTextTemplate() {
        return this.getPSSysBICubeMeasure().getTextTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f", fields={"TIPTEMPLATE"})
    public String getTipTemplate() {
        return this.getPSSysBICubeMeasure().getTipTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.getPSSysBICubeMeasure().getStdDataType();
    }
}

