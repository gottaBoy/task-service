/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.security.UserPrivilegeMgr
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pscore.srv.web;

import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.ibizsys.pscore.srv.web.WebContext;
import net.sf.json.JSONObject;

public class UserPrivilegeMgr
extends net.ibizsys.paas.security.UserPrivilegeMgr {
    public static final String RESKEY_DCADMIN = "DCADMIN";
    public static final String RESKEY_SYSADMIN = "SYSADMIN";

    protected synchronized boolean internalTest(IWebContext iWebContext, String string) throws Exception {
        if (string.indexOf(RESKEY_DCADMIN) == 0) {
            String[] stringArray = string.split("[_]");
            String string2 = "";
            int n = DCLevelCodeListModel.PROFESSIONAL;
            if (stringArray.length >= 3) {
                string2 = stringArray[1];
                n = Integer.parseInt(stringArray[2]);
            }
            if (WebContext.isDCAdmin(iWebContext)) {
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    return true;
                }
                return DataTypeHelper.testCond((Object)WebContext.getDCLevel(iWebContext), (String)string2, (Object)n);
            }
            return false;
        }
        if (string.indexOf(RESKEY_SYSADMIN) == 0) {
            JSONObject jSONObject;
            String[] stringArray = string.split("[_]");
            String string3 = "";
            int n = DCLevelCodeListModel.PROFESSIONAL;
            if (stringArray.length >= 3) {
                string3 = stringArray[1];
                n = Integer.parseInt(stringArray[2]);
            }
            if ((jSONObject = WebContext.getAppData((IWebContext)iWebContext)) != null) {
                String string4 = null;
                String string5 = jSONObject.optString("psdevslnsysid");
                if (StringHelper.isNullOrEmpty((String)string5)) {
                    string4 = jSONObject.optString("pssystemid");
                }
                if (!StringHelper.isNullOrEmpty((String)string5) || !StringHelper.isNullOrEmpty((String)string4)) {
                    try {
                        IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUser(iWebContext, string5, string4);
                        if (iPSSysDevUser == null || iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                            return false;
                        }
                        if (iPSSysDevUser.isShareAccMode()) {
                            return false;
                        }
                        if ((iPSSysDevUser.getAccMode() & 2) > 0) {
                            if (StringHelper.isNullOrEmpty((String)string3)) {
                                return true;
                            }
                            return DataTypeHelper.testCond((Object)WebContext.getDCLevel(iWebContext), (String)string3, (Object)n);
                        }
                        if (WebContext.isDCAdmin(iWebContext)) {
                            if (StringHelper.isNullOrEmpty((String)string3)) {
                                return true;
                            }
                            return DataTypeHelper.testCond((Object)WebContext.getDCLevel(iWebContext), (String)string3, (Object)n);
                        }
                        return false;
                    }
                    catch (Exception exception) {
                        return false;
                    }
                }
            }
            return false;
        }
        return super.internalTest(iWebContext, string);
    }
}

