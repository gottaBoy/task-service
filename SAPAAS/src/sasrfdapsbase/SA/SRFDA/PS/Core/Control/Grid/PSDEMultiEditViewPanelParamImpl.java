/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEMultiEditViewPanelParam;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEMultiEditViewPanelParamImpl
extends PSDEGridParamImpl
implements IPSDEMultiEditViewPanelParam {
    private String strPSDEViewId = "";
    private String strPanelStyle = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEViewId(this.psDEViewCtrl.getPSDEVIEWID());
        this.setPanelStyle(this.psDEViewCtrl.getCTRLPARAM());
    }

    @Override
    public String getPSDEViewId() {
        return this.strPSDEViewId;
    }

    public void setPSDEViewId(String strPSDEViewId) {
        this.strPSDEViewId = strPSDEViewId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEMultiEditViewPanelParam) {
            IPSDEMultiEditViewPanelParam iPSDEViewBarParam = (IPSDEMultiEditViewPanelParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEViewId())) {
                this.setPSDEViewId(iPSDEViewBarParam.getPSDEViewId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPanelStyle())) {
                this.setPanelStyle(iPSDEViewBarParam.getPanelStyle());
            }
        }
    }

    @Override
    public String getPanelStyle() {
        return this.strPanelStyle;
    }

    public void setPanelStyle(String strPanelStyle) {
        this.strPanelStyle = strPanelStyle;
    }
}

