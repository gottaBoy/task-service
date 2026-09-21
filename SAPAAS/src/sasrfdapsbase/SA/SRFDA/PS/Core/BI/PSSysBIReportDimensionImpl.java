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

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.PSSysBIReportItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;

public class PSSysBIReportDimensionImpl
extends PSSysBIReportItemImpl
implements IPSSysBIReportDimension {
    private IPSSysBICubeDimension iPSSysBICubeDimension = null;

    @Override
    protected void onInit() throws Exception {
        if ("DIMENSION".equals(this.getItemType())) {
            if (this.getPSSysBICubeDimension() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIReportItem.getPSSYSBICUBEDIMENSIONID())) {
                this.iPSSysBICubeDimension = (IPSSysBICubeDimension)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysBICubeDimension>(){

                    public IPSSysBICubeDimension execute(Object obj) throws Exception {
                        return PSSysBIReportDimensionImpl.this.getPSSysBIReport().getPSSysBICube().getPSSysBICubeDimension((String)obj);
                    }
                }, (IPSModelObject)this.getPSSysBIReport(), (Object)this.psSysBIReportItem.getPSSYSBICUBEDIMENSIONID());
            }
            if (this.getPSSysBICubeDimension() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u7acb\u65b9\u4f53\u7ef4\u5ea6", new Object[0]));
            }
        } else {
            throw new Exception(String.format("\u62a5\u8868\u9879\u7c7b\u578b\u4e0d\u6b63\u786e", new Object[0]));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u7ef4\u5ea6", dumpref=true, from="IPSSysBIReport", from_method="getPSSysBICubeMust().getPSSysBICubeDimension", hideempty=true, fields={"PSSYSBICUBEDIMENSIONID"})
    public IPSSysBICubeDimension getPSSysBICubeDimension() {
        return this.iPSSysBICubeDimension;
    }

    @Override
    public IPSBICubeDimension getPSBICubeDimension() {
        return this.getPSSysBICubeDimension();
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u7c7b\u578b", codelist="BIReportItemPlaceType", fields={"PLACETYPE"})
    public String getPlaceType() {
        return this.psSysBIReportItem.getPLACETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u653e\u7f6e\u4f4d\u7f6e", codelist="BIReportItemPlacement", fields={"PLACEMENT"})
    public String getPlacement() {
        return this.psSysBIReportItem.getPLACEMENT();
    }

    @Override
    public String getModelType() {
        return "PSSYSBIREPORTITEM_DIMENSION";
    }
}

