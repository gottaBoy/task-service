/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.SRFWFProcess
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFProcess;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFSimpleProcess
extends SRFWFProcess {
    private static final Log log = LogFactory.getLog(WFSimpleProcess.class);
    protected GlobalHelperEx globalHelperEx = null;

    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        context.AppendReturnInfo("\u8fd0\u884c\u6210\u529f\uff0c\u8bf7\u6ce8\u610f");
        return super.Execute(context);
    }
}

