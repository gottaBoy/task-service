/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.Deploy.PSDepSysAppImplBase;
import SA.SRFDA.PS.Data.PSDepSaaSSysApp;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSaaSSysAppImpl
extends PSDepSysAppImplBase {
    private static final Log log = LogFactory.getLog(PSDepSaaSSysAppImpl.class);
    private PSDepSaaSSysApp psDepSaaSSysApp = new PSDepSaaSSysApp();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSysVer iPSDepSysVer, PSDepSysApp psDepSysApp) throws Exception {
        super.init(iDAGlobalHelper, iPSDepSysVer, psDepSysApp);
    }
}

