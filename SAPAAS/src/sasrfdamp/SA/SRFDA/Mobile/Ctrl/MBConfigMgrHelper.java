/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Mobile.UIPart.Model.MBListMgr
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Mobile.UIPart.Model.MBListMgr;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class MBConfigMgrHelper {
    public static MBListMgr GetMBListMgr(ISRFDAGlobalHelper iDAGlobalHelper) {
        return (MBListMgr)iDAGlobalHelper.GetGlobalValue("SRFDAMBLISTMGR");
    }
}

