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
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodeListModelCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysCodeItemModelCodePublisherImpl
extends PSIBiz5SysCodeListModelCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSCodeList iPSCodeList, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psCodeItems = iPSCodeList.getAllPSCodeItems();
        if (psCodeItems != null) {
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                this.onGenerateCode(iPSCodeItem, list);
            }
        }
    }

    protected void onGenerateCode(IPSCodeItem iPSCodeItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSCodeItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

