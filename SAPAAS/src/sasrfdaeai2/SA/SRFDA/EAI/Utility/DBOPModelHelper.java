/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Utility;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBOPModelHelper {
    private static final Log log = LogFactory.getLog(DBOPModelHelper.class);

    public static Hashtable<String, IDEDataCtrl> GetRIndexDataCtrls(IDEDataCtrl dataCtrl, ISRFDAGlobalHelper globalHelper) {
        Vector list = dataCtrl.GetDEHelper().GetDERINDEXs(true);
        Hashtable<String, IDEDataCtrl> derIndexTable = new Hashtable<String, IDEDataCtrl>();
        for (DERINDEX dERINDEX : list) {
            IDEDataCtrl ctrl = globalHelper.getDAModelStorage().FindDEDataCtrlEx(dERINDEX.getDEID(), dataCtrl);
            if (ctrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                continue;
            }
            derIndexTable.put(dERINDEX.getTYPEVALUE(), ctrl);
        }
        return derIndexTable;
    }
}

