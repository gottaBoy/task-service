/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.PSPFObjectImpl;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailProxy
extends PSPFObjectImpl
implements IPSPFCtrlTemplDetailRuntime {
    protected IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailProxy.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFCtrlTempl iPSPFCtrlTempl, PSPFCtrlTemplDetail psPFCtrlTemplDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public void proxy(IPSPFCtrlTempl iPSPFCtrlTempl, IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail) throws Exception {
        this.iPSPFCtrlTemplDetail = iPSPFCtrlTemplDetail;
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        this.setPSPF(this.iPSPFCtrlTempl.getPSPF());
        this.setPSModelStorageContext(((IPSModelObjectRuntime)((Object)iPSPFCtrlTempl)).getPSModelStorageContext());
        this.setId(this.iPSPFCtrlTemplDetail.getId());
        this.setName(this.iPSPFCtrlTemplDetail.getName());
        this.setPSObjectData(((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTemplDetail).getPSPFCtrlTemplDetailData());
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFCtrlTempl.getPSPFPubCode();
    }

    @Override
    public PSPFCtrlTemplDetail getPSPFCtrlTemplDetailData() {
        return ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTemplDetail).getPSPFCtrlTemplDetailData();
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlPartCodePublisher getPSPFCtrlPartCodePublisher() throws Exception {
        return ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTemplDetail).getPSPFCtrlPartCodePublisher();
    }

    @Override
    public String getLogicName() {
        return this.iPSPFCtrlTemplDetail.getLogicName();
    }
}

