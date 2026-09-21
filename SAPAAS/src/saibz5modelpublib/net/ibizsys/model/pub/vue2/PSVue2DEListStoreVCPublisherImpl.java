/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSListDataItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSListDataItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.vue2.PSVue2CtrlPartCodePublisherImpl;

public class PSVue2DEListStoreVCPublisherImpl
extends PSVue2CtrlPartCodePublisherImpl {
    public static final String CTRLPART_RECORD = "RECORD";
    protected IPSDEList iPSDEList = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEList = (IPSDEList)iPSControl;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psListDataItems = this.iPSDEList.getPSListDataItems();
        while (psListDataItems.hasNext()) {
            IPSListDataItem iPSListDataItem = (IPSListDataItem)psListDataItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEList, (Object)iPSListDataItem);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        params.put("records", gridRecordList);
    }
}

