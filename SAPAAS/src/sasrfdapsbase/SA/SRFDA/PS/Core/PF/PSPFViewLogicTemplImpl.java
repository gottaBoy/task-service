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
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFViewLogicTempl {
    protected PSPFViewLogicTempl psPFViewLogicTempl = null;
    private static final Log log = LogFactory.getLog(PSPFViewLogicTemplImpl.class);
    protected ArrayList<IPSPFViewLogicCodePublisher> psPFViewLogicCodePublisher = new ArrayList();
    private IPSViewLogicType iPSViewLogicType = null;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFViewLogicTempl psPFViewLogicTempl) throws Exception {
        this.psPFViewLogicTempl = psPFViewLogicTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFViewLogicTempl.getPSPFVLTEMPLID());
        this.setName(this.psPFViewLogicTempl.getPSPFVLTEMPLNAME());
        this.setPSObjectData(this.psPFViewLogicTempl);
        this.iPSViewLogicType = this.getPSModelStorage().getPSViewLogicType(psPFViewLogicTempl.getPSVIEWLOGICTYPEID());
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFViewLogicTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFViewLogicCodePublisher getPSPFViewLogicCodePublisher() throws Exception {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFViewLogicCodePublisher.clear();
            } else if (this.psPFViewLogicCodePublisher.size() > 0) {
                return this.psPFViewLogicCodePublisher.remove(0);
            }
        }
        IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher = this.createPSPFViewLogicCodePublisher();
        iPSPFViewLogicCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFViewLogicCodePublisher;
    }

    protected IPSPFViewLogicCodePublisher createPSPFViewLogicCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFViewLogicTempl.getPUBOBJ())) {
            return (IPSPFViewLogicCodePublisher)ObjectHelper.Create((String)this.psPFViewLogicTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFViewLogicTempl iPSPFViewLogicTempl = templPSPFStyle.getPSPFViewLogicTempl(this.getPSViewLogicType(), this.getPSPFPubCode());
                if (iPSPFViewLogicTempl == null) break;
                if (StringHelper.IsNullOrEmpty((String)iPSPFViewLogicTempl.getPSPFViewLogicTemplData().getPUBOBJ())) {
                    if (iPSPFViewLogicTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFViewLogicTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFViewLogicCodePublisher)ObjectHelper.Create((String)iPSPFViewLogicTempl.getPSPFViewLogicTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFViewLogicCodePublisher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFViewLogicCodePublisher(IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher) {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicCodePublisher.add(iPSPFViewLogicCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFViewLogicCodePublishers() {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicCodePublisher.clear();
        }
    }

    @Override
    public PSPFViewLogicTempl getPSPFViewLogicTemplData() {
        return this.psPFViewLogicTempl;
    }

    @Override
    public IPSViewLogicType getPSViewLogicType() {
        return this.iPSViewLogicType;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }
}

