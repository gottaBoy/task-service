/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.BI.PSSysBIReportItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;

public class PSSysBIReportMeasureImpl
extends PSSysBIReportItemImpl
implements IPSSysBIReportMeasure {
    private IPSSysBICubeMeasure iPSSysBICubeMeasure = null;

    @Override
    protected void onInit() throws Exception {
        if ("MEASURE".equals(this.getItemType())) {
            if (this.getPSSysBICubeMeasure() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIReportItem.getPSSYSBICUBEMEASUREID())) {
                this.iPSSysBICubeMeasure = (IPSSysBICubeMeasure)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysBICubeMeasure>(){

                    public IPSSysBICubeMeasure execute(Object obj) throws Exception {
                        return PSSysBIReportMeasureImpl.this.getPSSysBIReport().getPSSysBICube().getPSSysBICubeMeasure((String)obj);
                    }
                }, (IPSModelObject)this.getPSSysBIReport(), (Object)this.psSysBIReportItem.getPSSYSBICUBEMEASUREID());
            }
            if (this.getPSSysBICubeMeasure() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u7acb\u65b9\u4f53\u6307\u6807", new Object[0]));
            }
        } else {
            throw new Exception(String.format("\u62a5\u8868\u9879\u7c7b\u578b\u4e0d\u6b63\u786e", new Object[0]));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6307\u6807", dumpref=true, from="IPSSysBIReport", from_method="getPSSysBICubeMust().getPSSysBICubeMeasure", hideempty=true, fields={"PSSYSBICUBEMEASUREID"})
    public IPSSysBICubeMeasure getPSSysBICubeMeasure() {
        return this.iPSSysBICubeMeasure;
    }

    @Override
    public IPSBICubeMeasure getPSBICubeMeasure() {
        return this.getPSSysBICubeMeasure();
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u7c7b\u578b", codelist="BIReportItemPlaceType", fields={"PLACETYPE"})
    public String getPlaceType() {
        return this.psSysBIReportItem.getPLACETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="AggMode", fields={"AGGTYPE"})
    public String getAggMode() {
        if (!StringHelper.isNullOrEmpty((String)this.psSysBIReportItem.getAGGTYPE())) {
            return this.psSysBIReportItem.getAGGTYPE();
        }
        return this.getPSBICubeMeasure().getAggMode();
    }

    @Override
    public String getModelType() {
        return "PSSYSBIREPORTITEM_MEASURE";
    }
}

