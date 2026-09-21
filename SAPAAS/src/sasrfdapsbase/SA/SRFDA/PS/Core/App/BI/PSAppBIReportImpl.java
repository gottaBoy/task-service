/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.BI.PSAppBIReportDimensionImpl;
import SA.SRFDA.PS.Core.App.BI.PSAppBIReportMeasureImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.PSAppSysPanelPreviewViewImpl;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBIReportImpl
extends PSObjectImpl3
implements IPSAppBIReport {
    private static final Log log = LogFactory.getLog(PSAppBIReportImpl.class);
    private IPSSysBIReport iPSSysBIReport = null;
    private IPSAppBIScheme iPSAppBIScheme = null;
    private Map<String, IPSAppBIReportMeasure> psAppBIReportMeasureMap = new LinkedHashMap<String, IPSAppBIReportMeasure>();
    private Map<String, IPSAppBIReportDimension> psAppBIReportDimensionMap = new LinkedHashMap<String, IPSAppBIReportDimension>();
    private IPSAppBICube iPSAppBICube = null;
    private IPSLayoutPanel iPSLayoutPanel = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBIScheme iPSAppBIScheme, IPSSysBIReport iPSSysBIReport) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBIScheme = iPSAppBIScheme;
            this.iPSSysBIReport = iPSSysBIReport;
            this.setId(iPSSysBIReport.getId());
            this.setName(iPSSysBIReport.getName());
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
        Iterator<? extends IPSSysBIReportDimension> psSysBIReportDimensions;
        this.iPSAppBICube = this.getPSAppBIScheme().getPSAppBICube(this.getPSSysBIReport().getPSSysBICube(), false);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysBIReport().getPSLayoutPanelId())) {
            try {
                PSAppView psAppView = new PSAppView();
                psAppView.setPSAPPVIEWID("PSAppBIReportPanelView");
                psAppView.setPSAPPVIEWNAME("PSAppBIReportPanelView");
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
                psDEViewCtrl.setPSSYSVIEWPANELID(this.getPSSysBIReport().getPSLayoutPanelId());
                PSAppSysPanelPreviewViewImpl psAppSysPanelPreviewViewImpl = new PSAppSysPanelPreviewViewImpl();
                psAppSysPanelPreviewViewImpl.init(this.getDAGlobalHelper(), this.getPSAppDataEntity().getPSApplication(), psAppView, this.getPSSysBIReport().getPSSysBICube().getPSDataEntity(), psDEViewCtrl);
                this.iPSLayoutPanel = (IPSLayoutPanel)psAppSysPanelPreviewViewImpl.getPSControl("panel");
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        super.onInit();
        Iterator<? extends IPSSysBIReportMeasure> psSysBIReportMeasures = this.getPSSysBIReport().getAllPSSysBIReportMeasures();
        if (psSysBIReportMeasures != null) {
            while (psSysBIReportMeasures.hasNext()) {
                IPSSysBIReportMeasure iPSSysBIReportMeasure = psSysBIReportMeasures.next();
                PSAppBIReportMeasureImpl psAppBIReportMeasureImpl = new PSAppBIReportMeasureImpl();
                psAppBIReportMeasureImpl.init(this.getDAGlobalHelper(), this, iPSSysBIReportMeasure);
                this.psAppBIReportMeasureMap.put(iPSSysBIReportMeasure.getId(), psAppBIReportMeasureImpl);
            }
        }
        if ((psSysBIReportDimensions = this.getPSSysBIReport().getAllPSSysBIReportDimensions()) != null) {
            while (psSysBIReportDimensions.hasNext()) {
                IPSSysBIReportDimension iPSSysBIReportDimension = psSysBIReportDimensions.next();
                PSAppBIReportDimensionImpl psAppBIReportDimensionImpl = new PSAppBIReportDimensionImpl();
                psAppBIReportDimensionImpl.init(this.getDAGlobalHelper(), this, iPSSysBIReportDimension);
                this.psAppBIReportDimensionMap.put(iPSSysBIReportDimension.getId(), psAppBIReportDimensionImpl);
            }
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSLayoutPanel() != null) {
            this.getPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysBIReport();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u4f53\u7cfb")
    public IPSAppBIScheme getPSAppBIScheme() {
        return this.iPSAppBIScheme;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53")
    public IPSSysBIReport getPSSysBIReport() {
        return this.iPSSysBIReport;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53", dumpref=true, from="IPSAppBIScheme")
    public IPSAppBICube getPSAppBICube() {
        return this.iPSAppBICube;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5b9e\u4f53", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.getPSAppBICube().getPSAppDataEntity();
    }

    @Override
    public String getModelType() {
        return "PSAPPBIREPORT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBIReport().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u96c6\u5408", child=true)
    public Iterator<IPSAppBIReportDimension> getPSAppBIReportDimensions() {
        if (this.psAppBIReportDimensionMap == null || this.psAppBIReportDimensionMap.size() == 0) {
            return null;
        }
        return this.psAppBIReportDimensionMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807\u96c6\u5408", child=true)
    public Iterator<IPSAppBIReportMeasure> getPSAppBIReportMeasures() {
        if (this.psAppBIReportMeasureMap == null || this.psAppBIReportMeasureMap.size() == 0) {
            return null;
        }
        return this.psAppBIReportMeasureMap.values().iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBIScheme().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppBIScheme().getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppBIScheme();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSAppBIScheme() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSAppBIScheme().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    public IPSAppBIReportDimension getPSAppBIReportDimension(IPSSysBIReportDimension iPSSysBIReportDimension) throws Exception {
        IPSAppBIReportDimension iPSAppBIReportDimension = this.psAppBIReportDimensionMap.get(iPSSysBIReportDimension.getId());
        if (iPSAppBIReportDimension != null) {
            return iPSAppBIReportDimension;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u4f20\u5165\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6[%1$s]\u7684\u5e94\u7528\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6", iPSSysBIReportDimension.getName()));
    }

    @Override
    public IPSAppBIReportMeasure getPSAppBIReportMeasure(IPSSysBIReportMeasure iPSSysBIReportMeasure) throws Exception {
        IPSAppBIReportMeasure iPSAppBIReportMeasure = this.psAppBIReportMeasureMap.get(iPSSysBIReportMeasure.getId());
        if (iPSAppBIReportMeasure != null) {
            return iPSAppBIReportMeasure;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u4f20\u5165\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u6307\u6807[%1$s]\u7684\u5e94\u7528\u667a\u80fd\u62a5\u8868\u6307\u6807", iPSSysBIReportMeasure.getName()));
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBIScheme().getPSSysModelInstId();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return this.getPSAppBIScheme().getPSApplication().isEnableDynaSys();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u524d\u7aef\u6a21\u578b", fields={"BIREPORTUIMODEL"})
    public String getReportUIModel() {
        return this.getPSSysBIReport().getReportUIModel();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb0", fields={"BIREPORTTAG"})
    public String getReportTag() {
        return this.getPSSysBIReport().getReportTag();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb02", fields={"BIREPORTTAG2"})
    public String getReportTag2() {
        return this.getPSSysBIReport().getReportTag2();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.iPSLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        if (this.getPSSysBIReport().getPSSysUniRes() != null) {
            return this.getPSSysBIReport().getPSSysUniRes().getResCode();
        }
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

