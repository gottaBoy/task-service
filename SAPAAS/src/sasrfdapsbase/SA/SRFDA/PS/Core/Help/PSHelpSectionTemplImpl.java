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

import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.PSHelpSectionPublisherImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSHelpSectionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionTemplImpl
extends PSObjectImpl
implements IPSHelpSectionTempl {
    protected PSHelpSectionTempl psHelpSectionTempl = null;
    private static final Log log = LogFactory.getLog(PSHelpSectionTemplImpl.class);
    protected ArrayList<IPSHelpSectionPublisher> psHelpSectionPublisher = new ArrayList();
    private String strPubObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpSectionTempl psHelpSectionTempl) throws Exception {
        this.psHelpSectionTempl = psHelpSectionTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psHelpSectionTempl.getPSHELPSECTIONTEMPLID());
        this.setName(this.psHelpSectionTempl.getPSHELPSECTIONTEMPLNAME());
        this.setPSObjectData(this.psHelpSectionTempl);
        this.strPubObj = this.psHelpSectionTempl.getPUBOBJ();
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSHelpSectionPublisher getPSHelpSectionPublisher() throws Exception {
        ArrayList<IPSHelpSectionPublisher> arrayList = this.psHelpSectionPublisher;
        synchronized (arrayList) {
            if (this.psHelpSectionPublisher.size() > 0) {
                return this.psHelpSectionPublisher.remove(0);
            }
        }
        IPSHelpSectionPublisher iPSHelpSectionPublisher = this.createPSHelpSectionPublisher();
        iPSHelpSectionPublisher.init(this.getDAGlobalHelper(), this);
        return iPSHelpSectionPublisher;
    }

    protected IPSHelpSectionPublisher createPSHelpSectionPublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strPubObj)) {
            return (IPSHelpSectionPublisher)ObjectHelper.Create((String)this.strPubObj);
        }
        return new PSHelpSectionPublisherImpl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSHelpSectionPublisher(IPSHelpSectionPublisher iPSHelpSectionPublisher) {
        ArrayList<IPSHelpSectionPublisher> arrayList = this.psHelpSectionPublisher;
        synchronized (arrayList) {
            this.psHelpSectionPublisher.add(iPSHelpSectionPublisher);
        }
    }

    @Override
    public PSHelpSectionTempl getPSHelpSectionTemplData() {
        return this.psHelpSectionTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

