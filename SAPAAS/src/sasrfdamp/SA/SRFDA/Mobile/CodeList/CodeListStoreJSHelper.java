/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.CodeList;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class CodeListStoreJSHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    public String GetJSPath(ISRFDAWebContext webContext, String strCodeListId, String strLanguage, boolean bMin) throws Exception {
        return "";
    }
}

