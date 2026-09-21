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

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartRadarImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartCS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartCoordinateSystemControlImplBase
extends PSDEChartObjectImplBase
implements IPSChartCoordinateSystemControl,
IPSPFCtrlPartCodeObject {
    private static final Log log = LogFactory.getLog(PSDEChartRadarImpl.class);
    private PSDEChart psDEChart = null;
    private IPSDEChartCoordinateSystem iPSDEChartCoordinateSystem = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private PSDEChartCS psDEChartCS = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChartCoordinateSystem iPSDEChartCoordinateSystem, PSDEChart psDEChart, PSDEChartCS psDEChartCS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChartCoordinateSystem.getPSDEChart());
            this.iPSDEChartCoordinateSystem = iPSDEChartCoordinateSystem;
            this.psDEChart = psDEChart;
            this.psDEChartCS = psDEChartCS;
            this.setId(this.iPSDEChartCoordinateSystem.getId());
            this.setName(this.iPSDEChartCoordinateSystem.getName());
            this.setPSObjectData(psDEChartCS);
            if (this.getPSChartCoordinateSystem().getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSChartCoordinateSystem().getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDEChart().getPSAppView(), (Object)this.getPSDEChart(), (Object)this, params);
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

    protected PSDEChart getPSDEChartData() {
        return this.psDEChart;
    }

    protected PSDEChartCS getPSDEChartCSData() {
        return this.psDEChartCS;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5750\u6807\u7cfb\u7edf", dumpref=true, from="IPSDEChart")
    public IPSChartCoordinateSystem getPSChartCoordinateSystem() {
        return this.iPSDEChartCoordinateSystem;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s", (Object)this.getPSChartCoordinateSystem().getFullModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSChartCoordinateSystem().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return StringHelper.format((String)"CS_%1$s", (Object)this.getType().toUpperCase());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b")
    public String getType() {
        return this.onGetType();
    }

    protected String onGetType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7840\u914d\u7f6eJson\u5185\u5bb9")
    public String getBaseOptionJOString() {
        if (this.getPSDynaModel() != null) {
            return ((IPSSysDynaModel)this.getPSDynaModel()).getJOString();
        }
        return null;
    }
}

