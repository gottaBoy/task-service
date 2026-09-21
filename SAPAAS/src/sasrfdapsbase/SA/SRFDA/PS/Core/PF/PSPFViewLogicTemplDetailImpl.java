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

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTemplDetail;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicPartCodePublisher;
import SA.SRFDA.PS.Data.PSPFViewLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewLogicTemplDetailImpl
extends PSPFObjectImpl
implements IPSPFViewLogicTemplDetail {
    protected PSPFViewLogicTemplDetail psPFViewLogicTemplDetail = null;
    protected IPSPFViewLogicTempl2 iPSPFViewLogicTempl = null;
    private static final Log log = LogFactory.getLog(PSPFViewLogicTemplDetailImpl.class);
    protected ArrayList<IPSPFViewLogicPartCodePublisher> psPFViewLogicPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFViewLogicTempl2 iPSPFViewLogicTempl, PSPFViewLogicTemplDetail psPFViewLogicTemplDetail) throws Exception {
        this.psPFViewLogicTemplDetail = psPFViewLogicTemplDetail;
        this.iPSPFViewLogicTempl = iPSPFViewLogicTempl;
        this.setPSPF(this.iPSPFViewLogicTempl.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFViewLogicTemplDetail.getPSPFVLDETAILID());
        this.setName(this.psPFViewLogicTemplDetail.getPSPFVLDETAILNAME());
        this.setPSObjectData(this.psPFViewLogicTemplDetail);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFViewLogicTempl.getPSPFPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFViewLogicPartCodePublisher getPSPFViewLogicPartCodePublisher() throws Exception {
        ArrayList<IPSPFViewLogicPartCodePublisher> arrayList = this.psPFViewLogicPartCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFViewLogicPartCodePublisher.clear();
            } else if (this.psPFViewLogicPartCodePublisher.size() > 0) {
                return this.psPFViewLogicPartCodePublisher.remove(0);
            }
        }
        IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher = this.createPSPFViewLogicPartCodePublisher();
        iPSPFViewLogicPartCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFViewLogicPartCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFViewLogicPartCodePublisher(IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher) {
        ArrayList<IPSPFViewLogicPartCodePublisher> arrayList = this.psPFViewLogicPartCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicPartCodePublisher.add(iPSPFViewLogicPartCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFViewLogicPartCodePublishers() {
        ArrayList<IPSPFViewLogicPartCodePublisher> arrayList = this.psPFViewLogicPartCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicPartCodePublisher.clear();
        }
    }

    @Override
    public PSPFViewLogicTemplDetail getPSPFViewLogicTemplDetailData() {
        return this.psPFViewLogicTemplDetail;
    }

    @Override
    public IPSPFViewLogicTempl2 getPSPFViewLogicTempl() {
        return this.iPSPFViewLogicTempl;
    }

    @Override
    public IPSPFViewLogicPartCodePublisher createPSPFViewLogicPartCodePublisher() throws Exception {
        IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher = null;
        if (!StringHelper.IsNullOrEmpty((String)this.psPFViewLogicTemplDetail.getPUBOBJ())) {
            iPSPFViewLogicPartCodePublisher = (IPSPFViewLogicPartCodePublisher)ObjectHelper.Create((String)this.psPFViewLogicTemplDetail.getPUBOBJ());
        }
        return iPSPFViewLogicPartCodePublisher;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return this.psPFViewLogicTemplDetail.getTEMPLDESC();
    }

    @Override
    public String getLogicName() {
        return this.psPFViewLogicTemplDetail.getLOGICNAME();
    }
}

