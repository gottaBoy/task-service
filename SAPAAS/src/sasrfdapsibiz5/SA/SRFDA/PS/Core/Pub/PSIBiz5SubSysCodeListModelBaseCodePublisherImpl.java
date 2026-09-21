/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.CodeList.IPSCodeItem
 *  SA.SRFDA.PS.Core.CodeList.IPSCodeList
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SubSysCodeListCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SubSysCodeListModelBaseCodePublisherImpl
extends PSIBiz5SubSysCodeListCodePublisherImpl {
    public static final String CODETEMPL_CODEITEM = "CODEITEM";

    @Override
    protected void onGenerateCode(IPSCodeList iPSCodeList, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, ArrayList<IPSCodeItem>> params = new HashMap<String, ArrayList<IPSCodeItem>>();
        ArrayList<IPSCodeItem> codeitems = new ArrayList<IPSCodeItem>();
        Iterator psCodeItems = iPSCodeList.getPSCodeItems();
        if (psCodeItems != null) {
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                codeitems.add(iPSCodeItem);
                this.onFillChildCodeItems(iPSCodeItem, codeitems);
            }
        }
        params.put("codeitems", codeitems);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSCodeList, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected void onFillChildCodeItems(IPSCodeItem iPSCodeItem, ArrayList<IPSCodeItem> codeitems) throws Exception {
        Iterator psCodeItems = iPSCodeItem.getPSCodeItems();
        if (psCodeItems != null) {
            while (psCodeItems.hasNext()) {
                IPSCodeItem childPSCodeItem = (IPSCodeItem)psCodeItems.next();
                codeitems.add(childPSCodeItem);
                this.onFillChildCodeItems(childPSCodeItem, codeitems);
            }
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }
}

