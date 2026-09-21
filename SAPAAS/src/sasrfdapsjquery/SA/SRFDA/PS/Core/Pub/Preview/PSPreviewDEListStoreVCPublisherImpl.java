/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.List.IPSDEList
 *  SA.SRFDA.PS.Core.Control.List.IPSListDataItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewCtrlPartCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSPreviewDEListStoreVCPublisherImpl
extends PSPreviewCtrlPartCodePublisherImpl {
    public static final String CTRLPART_RECORD = "RECORD";
    protected IPSDEList iPSDEList = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEList = (IPSDEList)iPSControl;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psListDataItems = this.iPSDEList.getPSListDataItems();
        while (psListDataItems.hasNext()) {
            IPSListDataItem iPSListDataItem = (IPSListDataItem)psListDataItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEList, (Object)iPSListDataItem);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("records", gridRecordList);
    }

    protected void onClose() {
        this.iPSDEList = null;
        super.onClose();
    }
}

