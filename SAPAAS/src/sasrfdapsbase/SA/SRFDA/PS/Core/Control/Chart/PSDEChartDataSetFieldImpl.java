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

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEChartDataSetField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartDataSetFieldImpl
extends PSDEChartObjectImplBase
implements IPSDEChartDataSetField {
    private static final Log log = LogFactory.getLog(PSDEChartDataSetFieldImpl.class);
    private PSDEChartDataSetField psDEChartDataSetField = null;
    private IPSDEChartDataSet iPSDEChartDataSet = null;
    private IPSCodeList iPSCodeList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChartDataSet iPSDEChartDataSet, PSDEChartDataSetField psDEChartDataSetField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChartDataSet.getPSDEChart());
            this.iPSDEChartDataSet = iPSDEChartDataSet;
            this.psDEChartDataSetField = psDEChartDataSetField;
            this.setId(psDEChartDataSetField.getPSDECHARTDATASETFIELDID());
            this.setName(psDEChartDataSetField.getPSDECHARTDATASETFIELDNAME());
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartDataSetField.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSDEChart().getPSAppView().getPSApplication().getPSAppCodeList(this.psDEChartDataSetField.getPSCODELISTID(), true);
                if (this.iPSCodeList == null) {
                    this.iPSCodeList = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSCodeList(this.psDEChartDataSetField.getPSCODELISTID());
                }
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
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSChartDataSet getPSChartDataSet() {
        return this.getPSDEChartDataSet();
    }

    public IPSDEChartDataSet getPSDEChartDataSet() {
        return this.iPSDEChartDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTDATASETFIELD";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEChartDataSet().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5c5e\u6027")
    public boolean isGroupField() {
        return this.psDEChartDataSetField.getGROUPFIELD();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f")
    public String getGroupMode() {
        return this.psDEChartDataSetField.getGROUPMODE();
    }
}

