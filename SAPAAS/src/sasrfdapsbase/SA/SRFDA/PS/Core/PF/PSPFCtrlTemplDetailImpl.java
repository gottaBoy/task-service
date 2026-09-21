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

import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailImpl
extends PSPFObjectImpl
implements IPSPFCtrlTemplDetail {
    protected PSPFCtrlTemplDetail psPFCtrlTemplDetail = null;
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailImpl.class);
    protected ArrayList<IPSPFCtrlPartCodePublisher> psPFCtrlPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTempl iPSPFCtrlTempl, PSPFCtrlTemplDetail psPFCtrlTemplDetail) throws Exception {
        this.psPFCtrlTemplDetail = psPFCtrlTemplDetail;
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPF(this.iPSPFCtrlTempl.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFCtrlTemplDetail.getPSPFCTDETAILID());
        this.setName(this.psPFCtrlTemplDetail.getPSPFCTDETAILNAME());
        this.setPSObjectData(this.psPFCtrlTemplDetail);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFCtrlTempl.getPSPFPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFCtrlPartCodePublisher getPSPFCtrlPartCodePublisher() throws Exception {
        ArrayList<IPSPFCtrlPartCodePublisher> arrayList = this.psPFCtrlPartCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFCtrlPartCodePublisher.clear();
            } else if (this.psPFCtrlPartCodePublisher.size() > 0) {
                return this.psPFCtrlPartCodePublisher.remove(0);
            }
        }
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.createPSPFCtrlPartCodePublisher();
        iPSPFCtrlPartCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFCtrlPartCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFCtrlPartCodePublisher(IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher) {
        ArrayList<IPSPFCtrlPartCodePublisher> arrayList = this.psPFCtrlPartCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlPartCodePublisher.add(iPSPFCtrlPartCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFCtrlPartCodePublishers() {
        ArrayList<IPSPFCtrlPartCodePublisher> arrayList = this.psPFCtrlPartCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlPartCodePublisher.clear();
        }
    }

    @Override
    public PSPFCtrlTemplDetail getPSPFCtrlTemplDetailData() {
        return this.psPFCtrlTemplDetail;
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = null;
        if (!StringHelper.IsNullOrEmpty((String)this.psPFCtrlTemplDetail.getPUBOBJ())) {
            iPSPFCtrlPartCodePublisher = (IPSPFCtrlPartCodePublisher)ObjectHelper.Create((String)this.psPFCtrlTemplDetail.getPUBOBJ());
        } else {
            IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail;
            if (this.getPSPFCtrlTempl().getPSPFStyle() != null && this.getPSPFCtrlTempl().getPSPFStyle().getTemplPSPFStyle() != null && (iPSPFCtrlTemplDetail = this.getPSPFCtrlTempl().getPSPFStyle().getTemplPSPFStyle().getPSPFCtrlTemplDetail(this.getPSPFCtrlTempl().getPSControlType(), this.getPSPFCtrlTempl().getPSPFPubCode(), this.getName(), true)) != null) {
                iPSPFCtrlPartCodePublisher = iPSPFCtrlTemplDetail.createPSPFCtrlPartCodePublisher();
            }
            if (iPSPFCtrlPartCodePublisher == null) {
                iPSPFCtrlPartCodePublisher = this.getPSPF().createPSPFCtrlPartCodePublisher();
            }
        }
        return iPSPFCtrlPartCodePublisher;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return this.psPFCtrlTemplDetail.getTEMPLDESC();
    }

    @Override
    public String getLogicName() {
        return this.psPFCtrlTemplDetail.getLOGICNAME();
    }
}

