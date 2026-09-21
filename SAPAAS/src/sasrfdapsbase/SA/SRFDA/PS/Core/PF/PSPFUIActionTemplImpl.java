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
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFUIActionTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFUIActionCodePublisher;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFUIActionTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFUIActionTempl {
    protected PSPFUIActionTempl psPFUIActionTempl = null;
    private static final Log log = LogFactory.getLog(PSPFUIActionTemplImpl.class);
    protected ArrayList<IPSPFUIActionCodePublisher> psPFUIActionCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFUIActionTempl psPFUIActionTempl) throws Exception {
        this.psPFUIActionTempl = psPFUIActionTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFUIActionTempl.getPSPFUATEMPLID());
        this.setName(this.psPFUIActionTempl.getPSPFUATEMPLNAME());
        this.setPSObjectData(this.psPFUIActionTempl);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFUIActionTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFUIActionCodePublisher getPSPFUIActionCodePublisher() throws Exception {
        ArrayList<IPSPFUIActionCodePublisher> arrayList = this.psPFUIActionCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFUIActionCodePublisher.clear();
            } else if (this.psPFUIActionCodePublisher.size() > 0) {
                return this.psPFUIActionCodePublisher.remove(0);
            }
        }
        IPSPFUIActionCodePublisher iPSPFUIActionCodePublisher = null;
        iPSPFUIActionCodePublisher = !StringHelper.IsNullOrEmpty((String)this.psPFUIActionTempl.getPUBOBJ()) ? (IPSPFUIActionCodePublisher)ObjectHelper.Create((String)this.psPFUIActionTempl.getPUBOBJ()) : this.getPSPF().createPSPFUIActionCodePublisher();
        iPSPFUIActionCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFUIActionCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFUIActionCodePublisher(IPSPFUIActionCodePublisher iPSPFUIActionCodePublisher) {
        ArrayList<IPSPFUIActionCodePublisher> arrayList = this.psPFUIActionCodePublisher;
        synchronized (arrayList) {
            this.psPFUIActionCodePublisher.add(iPSPFUIActionCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFUIActionCodePublishers() {
        ArrayList<IPSPFUIActionCodePublisher> arrayList = this.psPFUIActionCodePublisher;
        synchronized (arrayList) {
            this.psPFUIActionCodePublisher.clear();
        }
    }

    @Override
    public PSPFUIActionTempl getPSPFUIActionTemplData() {
        return this.psPFUIActionTempl;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }
}

