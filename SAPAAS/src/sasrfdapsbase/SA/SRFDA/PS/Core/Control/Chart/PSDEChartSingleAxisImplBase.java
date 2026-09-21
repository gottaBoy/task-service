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

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartAxisImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartSingleAxisImplBase
extends PSDEChartAxisImplBase
implements IPSChartSingleAxis {
    private static final Log log = LogFactory.getLog(PSDEChartSingleAxisImplBase.class);
    private IPSDEChartSingle iPSDEChartSingle = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChartSingle iPSDEChartSingle, IPSDEChartAxes iPSDEChartAxes) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChartAxes(iPSDEChartAxes);
            this.iPSDEChartSingle = iPSDEChartSingle;
            this.setId(this.getPSDEChartAxes().getId());
            this.setName(this.getPSDEChartAxes().getName());
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
    @PSModelRTMeta(description="\u5355\u4e00\u5750\u6807\u7cfb\u90e8\u4ef6")
    public IPSChartSingle getPSChartSingle() {
        return this.iPSDEChartSingle;
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSChartSingle().getModelId(), (Object)super.getModelId());
    }
}

