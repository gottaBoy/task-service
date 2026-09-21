/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Security.PrivilegesHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ListColumnConfig;

public class ListLinkConfig
extends ListColumnConfig {
    protected static String PRIVRESID = "PRIVRESID";
    protected static String PRIVACTION = "PRIVACTION";
    protected String strPrivResId = "";
    protected int privilege = 0;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, PRIVRESID, true) == 0) {
            this.strPrivResId = strValue;
            return;
        }
        if (StringHelper.Compare(strName, PRIVACTION, true) == 0) {
            this.privilege = PrivilegesHelper.FromString(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getReqPrivilege() {
        return this.privilege;
    }

    public String getPrivResId() {
        return this.strPrivResId;
    }
}

