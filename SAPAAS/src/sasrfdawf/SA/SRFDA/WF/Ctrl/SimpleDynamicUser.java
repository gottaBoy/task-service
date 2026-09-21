/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SRFWF.Ctrl.Data.WFActor
 *  SRFWF.Ctrl.Data.WFUser
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.ISRFWFDynamicUser
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.Data.WFActor;
import SRFWF.Ctrl.Data.WFUser;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFDynamicUser;
import java.util.Vector;

public class SimpleDynamicUser
implements ISRFWFDynamicUser {
    protected GlobalHelperEx globalHelperEx = null;

    public CallResult GetUsers(ISRFWFContext context, WFActor wfActor, Vector<WFUser> wfUsers) {
        this.globalHelperEx = (GlobalHelperEx)context.getContextHelper().getServletContext().getAttribute("SRFDACONTEXTHELPER");
        return new CallResult();
    }
}

