/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dataview.IPSDEDataView
 *  net.ibizsys.model.control.dataview.IPSDEDataViewDataItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.control.dataview.IPSDEDataViewDataItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSJQCtrlPartCodePublisherImpl;

public class PSJQDEDataViewStoreVCPublisherImpl
extends PSJQCtrlPartCodePublisherImpl {
    public static final String CTRLPART_RECORD = "RECORD";
    protected IPSDEDataView iPSDEDataView = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEDataView = (IPSDEDataView)iPSControl;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEDataViewDataItems = this.iPSDEDataView.getPSDEDataViewDataItems();
        while (psDEDataViewDataItems.hasNext()) {
            IPSDEDataViewDataItem iPSDEDataViewDataItem = (IPSDEDataViewDataItem)psDEDataViewDataItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEDataView, (Object)iPSDEDataViewDataItem);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        params.put("records", gridRecordList);
    }
}

