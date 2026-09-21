/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.PSPFObjectImpl;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailImpl
extends PSPFObjectImpl
implements IPSPFCtrlTemplDetailRuntime {
    protected PSPFCtrlTemplDetail psPFCtrlTemplDetail = null;
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFCtrlTempl iPSPFCtrlTempl, PSPFCtrlTemplDetail psPFCtrlTemplDetail) throws Exception {
        this.psPFCtrlTemplDetail = psPFCtrlTemplDetail;
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPF(this.iPSPFCtrlTempl.getPSPF());
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFCtrlTemplDetail.getPSPFCTDETAILID());
        this.setName(this.psPFCtrlTemplDetail.getPSPFCTDETAILNAME());
        this.setPSObjectData(this.psPFCtrlTemplDetail);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFCtrlTempl.getPSPFPubCode();
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
    public IPSPFCtrlPartCodePublisher getPSPFCtrlPartCodePublisher() throws Exception {
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.createPSPFCtrlPartCodePublisher();
        iPSPFCtrlPartCodePublisher.init(this.getPSModelStorageContext(), this);
        return iPSPFCtrlPartCodePublisher;
    }

    protected IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = null;
        if (!StringHelper.isNullOrEmpty((String)this.psPFCtrlTemplDetail.getPUBOBJ())) {
            iPSPFCtrlPartCodePublisher = (IPSPFCtrlPartCodePublisher)this.getPSModelStorageContext().createObject(this.psPFCtrlTemplDetail.getPUBOBJ());
        } else {
            IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail;
            if (this.getPSPFCtrlTempl().getPSPFStyle() != null && this.getPSPFCtrlTempl().getPSPFStyle().getTemplPSPFStyle() != null && (iPSPFCtrlTemplDetail = this.getPSPFCtrlTempl().getPSPFStyle().getTemplPSPFStyle().getPSPFCtrlTemplDetail(this.getPSPFCtrlTempl().getPSControlType(), this.getPSPFCtrlTempl().getPSPFPubCode(), this.getName(), true)) != null) {
                iPSPFCtrlPartCodePublisher = ((IPSPFCtrlTemplDetailRuntime)iPSPFCtrlTemplDetail).getPSPFCtrlPartCodePublisher();
            }
            if (iPSPFCtrlPartCodePublisher == null) {
                iPSPFCtrlPartCodePublisher = this.getPSPFRuntime().createPSPFCtrlPartCodePublisher();
            }
        }
        return iPSPFCtrlPartCodePublisher;
    }

    @Override
    public String getLogicName() {
        return this.psPFCtrlTemplDetail.getLOGICNAME();
    }
}

