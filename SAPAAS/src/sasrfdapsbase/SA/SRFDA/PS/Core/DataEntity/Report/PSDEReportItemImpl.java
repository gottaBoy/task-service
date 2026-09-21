/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Report;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReportItem;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReportItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEReportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEReportItemImpl
extends PSObjectImpl
implements IPSDEReportItem,
IPSAppDEReportItem {
    private static final Log log = LogFactory.getLog(PSDEReportItemImpl.class);
    private IPSDEReport iPSDEReport = null;
    private PSDEReportItem psDEReportItem = null;
    private String strMinorPSDEReportId = null;
    private IPSDEReport minorPSDEReport = null;
    private int nOrderValue = 100;
    private IPSAppDEReport iPSAppDEReport = null;
    private IPSAppDEReport minorPSAppDEReport = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEReport iPSDEReport, PSDEReportItem psDEReportItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEReport(iPSDEReport);
            this.setPSDEReportItemData(psDEReportItem);
            if (iPSDEReport instanceof IPSAppDEReport) {
                this.iPSAppDEReport = (IPSAppDEReport)iPSDEReport;
                if (this.iPSAppDEReport.getPSAppDataEntity() == null) {
                    this.iPSAppDEReport = null;
                }
            }
            this.setId(this.psDEReportItem.getPSDEREPITEMID());
            this.setName(this.psDEReportItem.getPSDEREPITEMNAME());
            this.setPSObjectData(this.psDEReportItem);
            if (!this.psDEReportItem.isORDERVALUENull()) {
                this.nOrderValue = this.psDEReportItem.getORDERVALUE();
            }
            this.strMinorPSDEReportId = this.psDEReportItem.getMINORPSDEREPORTID();
            if (StringHelper.isNullOrEmpty((String)this.strMinorPSDEReportId)) {
                throw new Exception("\u672a\u6307\u5b9a\u5173\u7cfb\u62a5\u8868\u5bf9\u8c61");
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
    protected int onCheck() throws Exception {
        this.getMinorPSDEReport();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u62a5\u8868\u5bf9\u8c61")
    public IPSDEReport getPSDEReport() {
        return this.iPSDEReport;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5e94\u7528\u5b9e\u4f53\u62a5\u8868\u5bf9\u8c61")
    public IPSAppDEReport getPSAppDEReport() {
        return this.iPSAppDEReport;
    }

    protected void setPSDEReport(IPSDEReport iPSDEReport) {
        this.iPSDEReport = iPSDEReport;
    }

    public PSDEReportItem getPSDEReportItemData() {
        return this.psDEReportItem;
    }

    protected void setPSDEReportItemData(PSDEReportItem psDEReportItem) {
        this.psDEReportItem = psDEReportItem;
    }

    @Override
    public String getMinorPSDEReportId() {
        return this.strMinorPSDEReportId;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u62a5\u8868\u5bf9\u8c61")
    public IPSDEReport getMinorPSDEReport() throws Exception {
        if (this.minorPSDEReport == null && !StringHelper.isNullOrEmpty((String)this.getMinorPSDEReportId())) {
            this.minorPSDEReport = this.getPSDEReport().getPSDataEntity().getPSDEReport(this.getMinorPSDEReportId());
        }
        return this.minorPSDEReport;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u62a5\u8868\u5bf9\u8c61", child=true)
    public IPSAppDEReport getMinorPSAppDEReport() throws Exception {
        if (this.minorPSAppDEReport == null && this.getPSAppDEReport() != null && !StringHelper.isNullOrEmpty((String)this.getMinorPSDEReportId())) {
            this.minorPSAppDEReport = this.getPSAppDEReport().getPSAppDataEntity().getPSAppDEReport(this.getMinorPSDEReportId());
        }
        return this.minorPSAppDEReport;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEReport.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEReport() != null) {
            return "PSAPPDEREPITEM";
        }
        return "PSDEREPITEM";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEReport() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEReport().getModelId(), (Object)super.getModelId());
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEReport().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEReport().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEReport().getPSDataEntity().getPSSystem());
    }
}

