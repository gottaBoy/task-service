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

import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartDataSetFieldImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEChartDataSetField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartDataSetImpl
extends PSDEChartObjectImplBase
implements IPSDEChartDataSet,
IPSDEChartDataSetRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartDataSetImpl.class);
    private IPSDEChartSeries iPSDEChartSeries = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEChartDataSetGroup iPSDEChartDataSetGroup = null;
    private ArrayList<IPSDEChartDataSetField> psDEChartDataSetFieldList = new ArrayList();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChartSeries iPSDEChartSeries, IPSDEDataSet iPSDEDataSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChartSeries.getPSDEChart());
            this.iPSDEChartSeries = iPSDEChartSeries;
            this.iPSDEDataSet = iPSDEDataSet;
            this.setId(iPSDEChartSeries.getId());
            this.setName(StringHelper.format((String)"%1$s-%2$s", (Object)this.getPSChartSeries().getName(), (Object)this.getPSDEDataSet().getName()));
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTDATASET";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEChart().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s", (Object)this.getPSDEChart().getFullModelName());
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u96c6\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartDataSetField> getPSChartDataSetFields() {
        if (this.psDEChartDataSetFieldList == null || this.psDEChartDataSetFieldList.size() == 0) {
            return null;
        }
        return this.psDEChartDataSetFieldList.iterator();
    }

    @Override
    public IPSDEChartDataSetField registerPSDEChartDataSetField(PSDEChartDataSetField psDEChartDataSetField) throws Exception {
        for (IPSDEChartDataSetField iPSDEChartDataSetField : this.psDEChartDataSetFieldList) {
            if (StringHelper.compare((String)iPSDEChartDataSetField.getName(), (String)psDEChartDataSetField.getPSDECHARTDATASETFIELDNAME(), (boolean)true) != 0) continue;
            return iPSDEChartDataSetField;
        }
        int nIndex = this.psDEChartDataSetFieldList.size();
        PSDEChartDataSetFieldImpl psDEChartDataSetFieldImpl = new PSDEChartDataSetFieldImpl();
        psDEChartDataSetFieldImpl.init(this.getDAGlobalHelper(), this, psDEChartDataSetField);
        this.psDEChartDataSetFieldList.add(psDEChartDataSetFieldImpl);
        psDEChartDataSetFieldImpl.setIndex(nIndex);
        return psDEChartDataSetFieldImpl;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u96c6\u5206\u7ec4")
    public IPSChartDataSetGroup getPSChartDataSetGroup() {
        return this.iPSDEChartDataSetGroup;
    }

    @Override
    public void setPSDEChartDataSetGroup(IPSDEChartDataSetGroup iPSDEChartDataSetGroup) {
        this.iPSDEChartDataSetGroup = iPSDEChartDataSetGroup;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5e8f\u5217")
    public IPSChartSeries getPSChartSeries() {
        return this.iPSDEChartSeries;
    }
}

