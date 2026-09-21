/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSAppLan
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2AppCodePublisherImpl;
import java.util.Iterator;

public class PSVue2AppLanCodePublisherImpl
extends PSVue2AppCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psAppLans = this.iPSApplication.getAllPSAppLans();
        while (psAppLans.hasNext()) {
            IPSAppLan iPSAppLan = (IPSAppLan)psAppLans.next();
            this.onGenerateCode(iPSAppLan, iPSAppLan.getLanguage().toLowerCase());
        }
    }
}

