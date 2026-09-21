/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartTitle;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartTitleImpl
extends PSDEChartObjectImplBase
implements IPSDEChartTitle {
    private static final Log log = LogFactory.getLog(PSDEChartTitleImpl.class);
    private PSDEChart psDEChart = null;
    private boolean bShowTitle = true;
    private String strTitle = null;
    private String strSubTitle = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLanguageRes subTitlePSLanguageRes = null;
    private String strTitlePos = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, PSDEChart psDEChart) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChart);
            this.psDEChart = psDEChart;
            if (!this.psDEChart.isSHOWTITLENull()) {
                this.bShowTitle = this.psDEChart.getSHOWTITLE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getLOGICNAME())) {
                this.strTitle = this.psDEChart.getLOGICNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getSUBTITLE())) {
                this.strSubTitle = this.psDEChart.getSUBTITLE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getTITLEPOS())) {
                this.strTitlePos = this.psDEChart.getTITLEPOS();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getLNPSLANRESID())) {
                this.titlePSLanguageRes = iPSDEChart.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEChart.getLNPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getSUBTITLEPSLANRESID())) {
                this.subTitlePSLanguageRes = iPSDEChart.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEChart.getSUBTITLEPSLANRESID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    @PSModelRTMeta(description="\u6807\u9898", fields={"LOGICNAME"})
    public String getTitle() {
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6807\u9898", fields={"SUBTITLE"})
    public String getSubTitle() {
        return this.strSubTitle;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", fields={"SHOWTITLE"})
    public boolean isShowTitle() {
        return this.bShowTitle;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"LNPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"SUBTITLEPSLANRESID"})
    public IPSLanguageRes getSubTitlePSLanguageRes() {
        return this.subTitlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u4f4d\u7f6e", codelist="ChartTitlePos", fields={"TITLEPOS"})
    public String getTitlePos() {
        return this.strTitlePos;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTTITLE";
    }

    @Override
    public String getModelId() {
        return this.getPSDEChart().getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s", (Object)this.getPSDEChart().getFullModelName());
    }
}

