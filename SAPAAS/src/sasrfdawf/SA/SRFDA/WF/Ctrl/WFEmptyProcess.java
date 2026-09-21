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

public class WFEmptyProcess
extends SRFWFProcess {
    private static final Log log = LogFactory.getLog(WFEmptyProcess.class);
    protected GlobalHelperEx globalHelperEx = null;

    public CallResult Execute(ISRFWFContext context) {
        return super.Execute(context);
    }
}

