/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEFilterPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@PSModelPFIgnoreMeta
public class PSSysDEFilterPortletImpl
extends PSSysPortletImpl
implements IPSSysDEFilterPortlet {
    private IPSDEDataSet filterPSDEDataSet = null;
    private List<IPSDEDQCondition> psDEDQConditionList = new ArrayList<IPSDEDQCondition>();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSDataEntity() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u8fc7\u6ee4\u5668\u5bf9\u5e94\u7684\u5b9e\u4f53");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFilterPSDEDataSetId())) {
            this.filterPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.getFilterPSDEDataSetId());
            Iterator<IPSDEDataQuery> psDEDataQueries = this.filterPSDEDataSet.getPSDEDataQueries();
            if (psDEDataQueries != null) {
                while (psDEDataQueries.hasNext()) {
                    IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                    if (iPSDEDataQuery.getPSDEDQMain() == null || iPSDEDataQuery.getPSDEDQMain().getPSDEDQGroupCondition() == null) continue;
                    this.psDEDQConditionList.add(iPSDEDataQuery.getPSDEDQMain().getPSDEDQGroupCondition());
                }
            }
        }
    }

    @Override
    public String getFilterPSDEDataSetId() {
        return this.psSysPortlet.getFILTERPSDEDSID();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6570\u636e\u96c6")
    public IPSDEDataSet getFilterPSDEDataSet() {
        return this.filterPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6761\u4ef6\u96c6\u5408")
    public Iterator<IPSDEDQCondition> getFilterPSDEDQConditions() {
        if (this.psDEDQConditionList == null || this.psDEDQConditionList.size() == 0) {
            return null;
        }
        return this.psDEDQConditionList.iterator();
    }
}

