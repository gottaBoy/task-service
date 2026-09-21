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
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFAppTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFAppTempl {
    protected PSPFAppTempl psPFAppTempl = null;
    private static final Log log = LogFactory.getLog(PSPFAppTemplImpl.class);
    protected ArrayList<IPSPFAppCodePublisher> psPFAppCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFAppTempl psPFAppTempl) throws Exception {
        this.psPFAppTempl = psPFAppTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFAppTempl.getPSPFAPPTEMPLID());
        this.setName(this.psPFAppTempl.getPSPFAPPTEMPLNAME());
        this.setPSObjectData(this.psPFAppTempl);
        this.onInit();
    }

    @Override
    public PSPFAppTempl getPSPFAppTemplData() {
        return this.psPFAppTempl;
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFAppTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFAppCodePublisher getPSPFAppCodePublisher() throws Exception {
        ArrayList<IPSPFAppCodePublisher> arrayList = this.psPFAppCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFAppCodePublisher.clear();
            } else if (this.psPFAppCodePublisher.size() > 0) {
                return this.psPFAppCodePublisher.remove(0);
            }
        }
        IPSPFAppCodePublisher iPSPFAppCodePublisher = this.createPSPFAppCodePublisher();
        iPSPFAppCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFAppCodePublisher;
    }

    protected IPSPFAppCodePublisher createPSPFAppCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFAppTempl.getPUBOBJ())) {
            return (IPSPFAppCodePublisher)ObjectHelper.Create((String)this.psPFAppTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFAppTempl iPSPFAppTempl = templPSPFStyle.getPSPFAppTempl(this.getPSPFPubCode());
                if (iPSPFAppTempl == null) break;
                if (StringHelper.IsNullOrEmpty((String)iPSPFAppTempl.getPSPFAppTemplData().getPUBOBJ())) {
                    if (iPSPFAppTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFAppTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFAppCodePublisher)ObjectHelper.Create((String)iPSPFAppTempl.getPSPFAppTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFAppCodePublisher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFAppCodePublisher(IPSPFAppCodePublisher iPSPFAppCodePublisher) {
        ArrayList<IPSPFAppCodePublisher> arrayList = this.psPFAppCodePublisher;
        synchronized (arrayList) {
            this.psPFAppCodePublisher.add(iPSPFAppCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFAppCodePublishers() {
        ArrayList<IPSPFAppCodePublisher> arrayList = this.psPFAppCodePublisher;
        synchronized (arrayList) {
            this.psPFAppCodePublisher.clear();
        }
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }
}

