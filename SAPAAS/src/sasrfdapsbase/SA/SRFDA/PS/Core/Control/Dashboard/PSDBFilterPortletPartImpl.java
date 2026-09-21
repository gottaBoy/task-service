/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBFilterPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEFilterPortlet;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"FILTER"})
public class PSDBFilterPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBFilterPortletPart {
    private IPSSysDEFilterPortlet iPSSysDEFilterPortlet = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSSysDEFilterPortlet = (IPSSysDEFilterPortlet)this.iPSSysPortlet;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6761\u4ef6", child=true)
    public Iterator<IPSDEDQCondition> getFilterPSDEDQConditions() {
        return this.iPSSysDEFilterPortlet.getFilterPSDEDQConditions();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6570\u636e\u96c6")
    public IPSDEDataSet getFilterPSDEDataSet() {
        return this.iPSSysDEFilterPortlet.getFilterPSDEDataSet();
    }
}

