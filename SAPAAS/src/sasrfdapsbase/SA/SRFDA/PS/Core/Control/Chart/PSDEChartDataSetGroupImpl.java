/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetGroupRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartDataSetGroupImpl
extends PSDEChartObjectImplBase
implements IPSDEChartDataSetGroup,
IPSDEChartDataSetGroupRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartDataSetGroupImpl.class);
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private ArrayList<IPSDEChartDataSet> psDEChartDataSetList = new ArrayList();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, IPSDEDataSet iPSDEDataSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChart);
            this.iPSDEDataSet = iPSDEDataSet;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEChart.getId(), (String)this.iPSDEDataSet.getId()));
            this.setName(iPSDEDataSet.getName());
            this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDEDataSet().getPSDataEntity(), true);
            if (this.getPSAppDataEntity() != null) {
                this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.getPSDEDataSet(), true);
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u96c6\u96c6\u5408")
    public Iterator<? extends IPSChartDataSet> getPSChartDataSets() {
        if (this.psDEChartDataSetList == null || this.psDEChartDataSetList.size() == 0) {
            return null;
        }
        return this.psDEChartDataSetList.iterator();
    }

    @Override
    public void registerPSDEChartDataSet(IPSDEChartDataSet iPSDEChartDataSet) {
        this.psDEChartDataSetList.add(iPSDEChartDataSet);
    }

    @Override
    public String getModelType() {
        return "PSDECHARTDATASETGROUP";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEChart().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s", (Object)this.getPSDEChart().getFullModelName());
    }
}

