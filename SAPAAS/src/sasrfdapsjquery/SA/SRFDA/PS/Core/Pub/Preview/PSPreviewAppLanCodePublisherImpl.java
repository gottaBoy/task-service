/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSAppLan
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewAppCodePublisherImpl;
import java.util.Iterator;

public class PSPreviewAppLanCodePublisherImpl
extends PSPreviewAppCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psAppLans = this.iPSApplication.getAllPSAppLans();
        while (psAppLans.hasNext()) {
            IPSAppLan iPSAppLan = (IPSAppLan)psAppLans.next();
            this.onGenerateCode(iPSAppLan, iPSAppLan.getLanguage().toLowerCase());
        }
    }
}

