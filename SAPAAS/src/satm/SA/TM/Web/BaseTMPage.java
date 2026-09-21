/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Web;

import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMUserSessionStorage;
import SA.TM.Ctrl.TMModelStorageFactory;
import SA.TM.Ctrl.TMUSSFactory;

public abstract class BaseTMPage
extends BaseMainPage {
    public ITMModelStorage getTMModelStorage() throws Exception {
        return TMModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    public ITMUserSessionStorage getTMUserSessionStorage() throws Exception {
        return TMUSSFactory.GetCurrentUSS((ISRFDAWebContext)this.getWebContext());
    }
}

