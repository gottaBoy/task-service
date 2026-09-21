/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSObjectRuntime;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailProxy
extends PSPFObjectImpl
implements IPSPFCtrlTemplDetail {
    protected IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailProxy.class);
    protected ArrayList<IPSPFCtrlPartCodePublisher> psPFCtrlPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTempl iPSPFCtrlTempl, PSPFCtrlTemplDetail psPFCtrlTemplDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public void proxy(IPSPFCtrlTempl iPSPFCtrlTempl, IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail) throws Exception {
        this.iPSPFCtrlTemplDetail = iPSPFCtrlTemplDetail;
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPF(this.iPSPFCtrlTempl.getPSPF());
        this.setDAGlobalHelper(((IPSObjectRuntime)((Object)iPSPFCtrlTempl)).getDAGlobalHelper());
        this.setId(this.iPSPFCtrlTemplDetail.getId());
        this.setName(this.iPSPFCtrlTemplDetail.getName());
        this.setPSObjectData(this.iPSPFCtrlTemplDetail.getPSPFCtrlTemplDetailData());
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
        return this.iPSPFCtrlTemplDetail.getPSPFCtrlTemplDetailData();
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        return this.iPSPFCtrlTemplDetail.createPSPFCtrlPartCodePublisher();
    }

    @Override
    public String getTemplDocUrl() {
        return this.iPSPFCtrlTemplDetail.getTemplDocUrl();
    }

    @Override
    public String getTemplDesc() {
        return this.iPSPFCtrlTemplDetail.getTemplDesc();
    }

    @Override
    public String getLogicName() {
        return this.iPSPFCtrlTemplDetail.getLogicName();
    }
}

