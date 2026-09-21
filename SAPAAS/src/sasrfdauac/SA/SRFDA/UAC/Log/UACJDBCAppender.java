/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Log.DAJDBCAppender
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.UAC.Log;

import SA.SRFDA.Log.DAJDBCAppender;
import SA.SRFramework.Utility.StringHelper;

public class UACJDBCAppender
extends DAJDBCAppender {
    protected String OnDealInfo(String strInfo) {
        if (StringHelper.IsNullOrEmpty((String)strInfo)) {
            return strInfo;
        }
        strInfo = strInfo.replaceAll("org.jasig.cas", "sa.uac");
        strInfo = strInfo.replaceAll("cas", "UAC");
        return strInfo;
    }
}

