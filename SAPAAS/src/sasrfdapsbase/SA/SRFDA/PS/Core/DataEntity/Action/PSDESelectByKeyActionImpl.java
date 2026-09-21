/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDESelectByKeyAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESelectByKeyActionImpl
extends PSDEActionImplBase
implements IPSDESelectByKeyAction {
    protected IPSDEDataQuery iPSDEDataQuery = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.psDEAction.getPSDEDATAQUERYID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u67e5\u8be2");
        }
        this.iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(this.psDEAction.getPSDEDATAQUERYID());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", dumpref=true, from="IPSDataEntity")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        return "READ";
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getActionHolder() {
        try {
            if (!this.isCustomActionHolder()) {
                return 1;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.getActionHolder();
    }
}

