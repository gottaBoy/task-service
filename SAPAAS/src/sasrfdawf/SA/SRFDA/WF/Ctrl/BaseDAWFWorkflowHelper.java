/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.SRFWFWorkflowHelperBase
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFWorkflowHelperBase;
import java.util.Properties;

public abstract class BaseDAWFWorkflowHelper
extends SRFWFWorkflowHelperBase {
    protected Properties properties = null;

    public void Init(Properties properties) {
        this.properties = properties;
        this.OnInit();
    }

    protected void OnInit() {
    }

    public final ISRFDAGlobalHelper getDAGlobalHelper(ISRFWFContext iWFContext) throws Exception {
        return (ISRFDAGlobalHelper)iWFContext.getContextHelper().GetGlobalValue("SRFDACONTEXTHELPER");
    }
}

