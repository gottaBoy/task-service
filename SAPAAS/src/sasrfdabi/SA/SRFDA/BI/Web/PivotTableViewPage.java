/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.Web.Default.BaseMainPage;

public class PivotTableViewPage
extends BaseMainPage {
    public String GetConfigPath() {
        return this.getPageParam("PAGE.CONFIGPATH", "mondrian.xml");
    }
}

