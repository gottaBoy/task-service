/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.CaretTemplate;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class CaretTemplHelper {
    private static CaretTemplHelper caretTemplHelper = null;
    private ISRFDAGlobalHelper iSRFDAGlobalHelper = null;
    private IDEDataCtrl caretTemplDataCtrl = null;

    public static CaretTemplHelper GetCurrent(ISRFDAGlobalHelper iSRFDAGlobalHelper) throws Exception {
        if (caretTemplHelper != null) {
            return caretTemplHelper;
        }
        CaretTemplHelper caretTemplHelper2 = new CaretTemplHelper();
        caretTemplHelper2.Init(iSRFDAGlobalHelper);
        caretTemplHelper = caretTemplHelper2;
        return caretTemplHelper;
    }

    public void Init(ISRFDAGlobalHelper iSRFDAGlobalHelper) throws Exception {
        this.iSRFDAGlobalHelper = iSRFDAGlobalHelper;
        this.caretTemplDataCtrl = this.iSRFDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0110", "SYSTEM", null);
        if (this.caretTemplDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0110"));
        }
    }

    public void Log(String strCaretTemplGroupId, String strOwnerId, String strText) {
        String strKey = "";
        if (!StringHelper.IsNullOrEmpty((String)strOwnerId)) {
            strKey = String.valueOf(strKey) + "|";
            strKey = String.valueOf(strKey) + strOwnerId;
        }
        strKey = String.valueOf(strKey) + "|";
        strKey = String.valueOf(strKey) + strText;
        Date beginDate = new Date();
        strKey = String.valueOf(strCaretTemplGroupId) + Helper.GenMD5((String)strKey);
        Date endDate = new Date();
        long nTime = endDate.getTime() - beginDate.getTime();
        CaretTemplate caretTemplate = new CaretTemplate();
        caretTemplate.setCARETTEMPLATEID(strKey);
        caretTemplate.setCARETTEMPLATENAME(strText);
        caretTemplate.setCARETTEMPLGROUPID(strCaretTemplGroupId);
        caretTemplate.setCARETWORD(strText);
        this.caretTemplDataCtrl.Save(true, caretTemplate);
    }
}

