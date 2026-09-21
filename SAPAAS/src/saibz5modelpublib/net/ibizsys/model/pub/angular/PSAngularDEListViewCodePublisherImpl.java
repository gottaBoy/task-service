/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSDEListItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.angular.PSAngularCtrlCodePublisherImpl;

public class PSAngularDEListViewCodePublisherImpl
extends PSAngularCtrlCodePublisherImpl {
    protected IPSDEList iPSDEList = null;
    public static final String CTRLPART_RECORD = "RECORD";
    public static final String CTRLPART_COLUMN = "COLUMN";
    public static final String CTRLPART_STORE = "STORE";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEList = (IPSDEList)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSDEList = (IPSDEList)this.iPSControl;
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEList, null);
        params.put("store", iPSGenerateCodeResult);
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_COLUMN).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEListItems = this.iPSDEList.getPSDEListItems();
        while (psDEListItems.hasNext()) {
            IPSDEListItem iPSDEListItem = (IPSDEListItem)psDEListItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult2 = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEList, (Object)iPSDEListItem);
            gridColumnList.add(iPSGenerateCodeResult2);
        }
        params.put("columns", gridColumnList);
    }
}

