/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2CtrlPartCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSVue2DEGridStoreVCPublisherImpl
extends PSVue2CtrlPartCodePublisherImpl {
    public static final String CTRLPART_RECORD = "RECORD";
    protected IPSDEGrid iPSDEGrid = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEGrid = (IPSDEGrid)iPSControl;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEGridDataItems = this.iPSDEGrid.getPSDEGridDataItems();
        while (psDEGridDataItems.hasNext()) {
            IPSDEGridDataItem iPSDEGridDataItem = (IPSDEGridDataItem)psDEGridDataItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEGrid, (Object)iPSDEGridDataItem);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("records", gridRecordList);
    }

    protected void onClose() {
        this.iPSDEGrid = null;
        super.onClose();
    }
}

