/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.RemoteDEDataCtrl
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.RemoteDEDataCtrl;
import SA.SRFramework.Utility.StringHelper;

public class IMRemoteDEDataCtrl
extends RemoteDEDataCtrl {
    private static String strUrl = "";

    public static void InitUrl(String strUrl) {
        IMRemoteDEDataCtrl.strUrl = strUrl;
    }

    public void Init(String strRemoteCallUrl, String strDEId, String strCurPersonId) {
        if (StringHelper.IsNullOrEmpty((String)strRemoteCallUrl)) {
            strRemoteCallUrl = strUrl;
        }
        if (StringHelper.IsNullOrEmpty((String)strCurPersonId)) {
            strCurPersonId = "SYSTEM";
        }
        super.Init(strRemoteCallUrl, strDEId, strCurPersonId);
    }
}

