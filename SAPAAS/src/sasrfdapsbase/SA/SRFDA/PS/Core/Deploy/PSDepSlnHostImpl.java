/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnHost;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnHostImpl
extends PSDepSlnObjectImpl
implements IPSDepSlnHost {
    private static final Log log = LogFactory.getLog(PSDepSlnHostImpl.class);
    protected PSDepSlnHost psDepSlnHost = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnHost psDepSlnHost) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnHost = psDepSlnHost;
        this.setId(this.psDepSlnHost.getPSDEPSLNHOSTID());
        this.setName(this.psDepSlnHost.getPSDEPSLNHOSTNAME());
        this.setPSObjectData(this.psDepSlnHost);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNHOST";
    }

    @Override
    public String getUserName() {
        return this.psDepSlnHost.getUSERNAME();
    }

    @Override
    public String getPassword() {
        return this.psDepSlnHost.getPWD();
    }

    @Override
    public String getRemoteAddr() {
        return this.psDepSlnHost.getIPADDR();
    }
}

