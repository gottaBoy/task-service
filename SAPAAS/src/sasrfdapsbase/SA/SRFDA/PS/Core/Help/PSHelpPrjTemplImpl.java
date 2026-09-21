/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.PSHelpPrjPublisherImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSHelpPrjTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjTemplImpl
extends PSObjectImpl
implements IPSHelpPrjTempl {
    protected PSHelpPrjTempl psHelpPrjTempl = null;
    private static final Log log = LogFactory.getLog(PSHelpPrjTemplImpl.class);
    protected ArrayList<IPSHelpPrjPublisher> psHelpPrjPublisher = new ArrayList();
    private String strPubObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpPrjTempl psHelpPrjTempl) throws Exception {
        this.psHelpPrjTempl = psHelpPrjTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psHelpPrjTempl.getPSHELPPRJTEMPLID());
        this.setName(this.psHelpPrjTempl.getPSHELPPRJTEMPLNAME());
        this.setPSObjectData(this.psHelpPrjTempl);
        this.strPubObj = this.psHelpPrjTempl.getPUBOBJ();
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSHelpPrjPublisher getPSHelpPrjPublisher() throws Exception {
        ArrayList<IPSHelpPrjPublisher> arrayList = this.psHelpPrjPublisher;
        synchronized (arrayList) {
            if (this.psHelpPrjPublisher.size() > 0) {
                return this.psHelpPrjPublisher.remove(0);
            }
        }
        IPSHelpPrjPublisher iPSHelpPrjPublisher = this.createPSHelpPrjPublisher();
        iPSHelpPrjPublisher.init(this.getDAGlobalHelper(), this);
        return iPSHelpPrjPublisher;
    }

    protected IPSHelpPrjPublisher createPSHelpPrjPublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strPubObj)) {
            return (IPSHelpPrjPublisher)ObjectHelper.Create((String)this.strPubObj);
        }
        return new PSHelpPrjPublisherImpl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSHelpPrjPublisher(IPSHelpPrjPublisher iPSHelpPrjPublisher) {
        ArrayList<IPSHelpPrjPublisher> arrayList = this.psHelpPrjPublisher;
        synchronized (arrayList) {
            this.psHelpPrjPublisher.add(iPSHelpPrjPublisher);
        }
    }

    @Override
    public PSHelpPrjTempl getPSHelpPrjTemplData() {
        return this.psHelpPrjTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

