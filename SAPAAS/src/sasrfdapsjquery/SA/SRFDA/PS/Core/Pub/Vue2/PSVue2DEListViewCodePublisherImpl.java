/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.List.IPSDEList
 *  SA.SRFDA.PS.Core.Control.List.IPSDEListItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2CtrlCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSVue2DEListViewCodePublisherImpl
extends PSVue2CtrlCodePublisherImpl {
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
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEList, null);
        iPSPFCtrlPartCodePublisher.close();
        params.put("store", iPSGenerateCodeResult);
        iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_COLUMN).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEListItems = this.iPSDEList.getPSDEListItems();
        while (psDEListItems.hasNext()) {
            IPSDEListItem iPSDEListItem = (IPSDEListItem)psDEListItems.next();
            IPSGenerateCodeResult iPSGenerateCodeResult2 = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEList, (Object)iPSDEListItem);
            gridColumnList.add(iPSGenerateCodeResult2);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("columns", gridColumnList);
    }

    protected void onClose() {
        this.iPSDEList = null;
        super.onClose();
    }
}

