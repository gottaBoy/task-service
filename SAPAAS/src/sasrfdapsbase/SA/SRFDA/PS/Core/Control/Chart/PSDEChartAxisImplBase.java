/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEChartAxisImplBase
extends PSDEChartObjectImplBase
implements IPSChartAxis,
IPSPFCtrlPartCodeObject {
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSDEChartAxes iPSDEChartAxes = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                HashMap<String, Object> params = new HashMap<String, Object>();
                params.put("app", this.getPSApplication());
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDEChart().getPSAppView(), (Object)this.getPSDEChart(), (Object)this, params);
            }
        }
        super.onInit();
    }

    @Override
    public IPSDEChartAxes getPSDEChartAxes() {
        return this.iPSDEChartAxes;
    }

    protected void setPSDEChartAxes(IPSDEChartAxes iPSDEChartAxes) {
        this.iPSDEChartAxes = iPSDEChartAxes;
        if (this.getPSDEChartAxes() != null) {
            this.setPSDEChart(this.getPSDEChartAxes().getPSDEChart());
        } else {
            this.setPSDEChart(null);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (this.getPSDEChartAxes() != null) {
            return this.getPSDEChartAxes().getCaption();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.getPSDEChartAxes() != null) {
            return this.getPSDEChartAxes().getCapPSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="ECharts\u7c7b\u578b")
    public String getEChartsType() {
        if (StringHelper.compare((String)this.getType(), (String)"category", (boolean)false) == 0) {
            return "category";
        }
        if (StringHelper.compare((String)this.getType(), (String)"numeric", (boolean)false) == 0) {
            return "value";
        }
        if (StringHelper.compare((String)this.getType(), (String)"time", (boolean)false) == 0) {
            return "time";
        }
        return "log";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return StringHelper.format((String)"AXIS_%1$s", (Object)this.getEChartsPos().toUpperCase());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        if (this.getPSDEChartAxes() != null) {
            return this.getPSDEChartAxes().getPSSysPFPlugin();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDEChartAxes();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c")
    public Double getMaxValue() {
        return this.getPSDEChartAxes().getMaxValue();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c")
    public Double getMinValue() {
        return this.getPSDEChartAxes().getMinValue();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="ChartAxesType")
    public String getType() {
        return this.getPSDEChartAxes().getAxesType();
    }

    @Override
    @PSModelRTMeta(description="\u4f4d\u7f6e", codelist="ChartAxesPos")
    public String getPosition() {
        return this.getPSDEChartAxes().getAxesPos();
    }

    @Override
    @PSModelRTMeta(description="ECharts\u4f4d\u7f6e")
    public String getEChartsPos() {
        return this.onGetEChartsPos();
    }

    protected String onGetEChartsPos() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u663e\u793a\u6a21\u5f0f", codelist="ChartAxesDataShowMode", ignoredumpvalues="0")
    public int getDataShowMode() {
        return this.getPSDEChartAxes().getDataShowMode();
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7840\u914d\u7f6eJson\u5185\u5bb9")
    public String getBaseOptionJOString() {
        if (this.getPSDEChartAxes().getPSDynaModel() != null) {
            return ((IPSSysDynaModel)this.getPSDEChartAxes().getPSDynaModel()).getJOString();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }
}

