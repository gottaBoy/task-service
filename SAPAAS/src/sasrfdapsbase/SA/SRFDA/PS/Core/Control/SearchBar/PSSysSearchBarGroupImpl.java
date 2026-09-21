/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarGroup;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarItemImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSSysSearchBarGroupImpl
extends PSSysSearchBarItemImplBase
implements IPSSearchBarGroup {
    private boolean bAddSeparator = false;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private double fWidth = 0.0;
    private IPSDEDataSet filterPSDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psSysSearchBarItem.isADDSEPARATORNull()) {
            this.bAddSeparator = this.psSysSearchBarItem.getADDSEPARATOR();
        }
        if (!this.psSysSearchBarItem.isWIDTHNull()) {
            this.fWidth = this.psSysSearchBarItem.GetParamDoubleValue("WIDTH", this.fWidth);
            if (this.fWidth < 0.0) {
                this.fWidth = 0.0;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getTIPPSLANRESID())) {
            this.tooltipPSLanguageRes = this.getPSSearchBar().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysSearchBarItem.getTIPPSLANRESID());
        }
        if (this.getPSSysSearchBar().getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getFILTERPSDEDSID())) {
            this.filterPSDEDataSet = this.getPSSysSearchBar().getPSDataEntity().getPSDEDataSet(this.psSysSearchBarItem.getFILTERPSDEDSID());
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHBARGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f", fields={"ADDSEPARATOR"})
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u63d0\u793a\u4fe1\u606f", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        return this.psSysSearchBarItem.getTOOLTIPINFO();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u63d0\u793a\u4fe1\u606f\u591a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", fields={"WIDTH"})
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5206\u7ec4", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefaultGroup() {
        return this.psSysSearchBarItem.getDEFAULTFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6761\u4ef6", child=true)
    public Iterator<IPSDEDQCondition> getFilterPSDEDQConditions() {
        if (this.getFilterPSDEDataSet() != null) {
            return this.getFilterPSDEDataSet().getADPSDEDQConditions();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6570\u636e\u96c6")
    public IPSDEDataSet getFilterPSDEDataSet() {
        return this.filterPSDEDataSet;
    }
}

