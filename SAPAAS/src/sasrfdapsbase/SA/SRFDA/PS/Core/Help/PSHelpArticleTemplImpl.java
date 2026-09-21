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

import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.PSHelpArticlePublisherImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSHelpArticleTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticleTemplImpl
extends PSObjectImpl
implements IPSHelpArticleTempl {
    protected PSHelpArticleTempl psHelpArticleTempl = null;
    private static final Log log = LogFactory.getLog(PSHelpArticleTemplImpl.class);
    protected ArrayList<IPSHelpArticlePublisher> psHelpArticlePublisher = new ArrayList();
    private String strPubObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpArticleTempl psHelpArticleTempl) throws Exception {
        this.psHelpArticleTempl = psHelpArticleTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psHelpArticleTempl.getPSHELPARTICLETEMPLID());
        this.setName(this.psHelpArticleTempl.getPSHELPARTICLETEMPLNAME());
        this.setPSObjectData(this.psHelpArticleTempl);
        this.strPubObj = this.psHelpArticleTempl.getPUBOBJ();
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSHelpArticlePublisher getPSHelpArticlePublisher() throws Exception {
        ArrayList<IPSHelpArticlePublisher> arrayList = this.psHelpArticlePublisher;
        synchronized (arrayList) {
            if (this.psHelpArticlePublisher.size() > 0) {
                return this.psHelpArticlePublisher.remove(0);
            }
        }
        IPSHelpArticlePublisher iPSHelpArticlePublisher = this.createPSHelpArticlePublisher();
        iPSHelpArticlePublisher.init(this.getDAGlobalHelper(), this);
        return iPSHelpArticlePublisher;
    }

    protected IPSHelpArticlePublisher createPSHelpArticlePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strPubObj)) {
            return (IPSHelpArticlePublisher)ObjectHelper.Create((String)this.strPubObj);
        }
        return new PSHelpArticlePublisherImpl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSHelpArticlePublisher(IPSHelpArticlePublisher iPSHelpArticlePublisher) {
        ArrayList<IPSHelpArticlePublisher> arrayList = this.psHelpArticlePublisher;
        synchronized (arrayList) {
            this.psHelpArticlePublisher.add(iPSHelpArticlePublisher);
        }
    }

    @Override
    public PSHelpArticleTempl getPSHelpArticleTemplData() {
        return this.psHelpArticleTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

