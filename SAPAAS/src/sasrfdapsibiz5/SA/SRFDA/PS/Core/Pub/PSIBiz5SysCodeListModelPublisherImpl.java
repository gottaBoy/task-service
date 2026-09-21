/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.CodeList.IPSCodeItem
 *  SA.SRFDA.PS.Core.CodeList.IPSCodeList
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodeListCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysCodeListModelPublisherImpl
extends PSIBiz5SysCodeListCodePublisherImpl {
    public static final String CODETEMPL_CODEITEM = "CODEITEM";

    @Override
    protected void onGenerateCode(IPSCodeList iPSCodeList, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> codeitems = new ArrayList<IPSGenerateCodeResult>();
        Iterator psCodeItems = iPSCodeList.getPSCodeItems();
        if (psCodeItems != null) {
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_CODEITEM, iPSCodeItem, null);
                codeitems.add(iPSGenerateCodeResult);
            }
        }
        params.put("codeitems", codeitems);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSCodeList, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_CODEITEM, (boolean)true) == 0) {
            IPSCodeItem parentPSCodeItem = (IPSCodeItem)obj;
            ArrayList<IPSGenerateCodeResult> codeitems = new ArrayList<IPSGenerateCodeResult>();
            Iterator psCodeItems = parentPSCodeItem.getPSCodeItems();
            if (psCodeItems != null) {
                while (psCodeItems.hasNext()) {
                    IPSCodeItem iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                    IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_CODEITEM, iPSCodeItem, null);
                    codeitems.add(iPSGenerateCodeResult);
                }
            }
            params.put("codeitems", codeitems);
        }
    }
}

