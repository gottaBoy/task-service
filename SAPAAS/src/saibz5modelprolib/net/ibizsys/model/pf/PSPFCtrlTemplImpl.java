/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTemplRuntime;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.PSPFCtrlTemplDetailGlobalModel;
import net.ibizsys.model.pf.PSPFCtrlTemplDetailProxy;
import net.ibizsys.model.pf.PSPFStyleObjectImpl;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFCtrlTemplRuntime {
    protected PSPFCtrlTempl psPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplImpl.class);
    private IPSControlType iPSControlType = null;
    protected PSPFCtrlTemplDetailGlobalModel psPFCtrlTemplDetailGlobalModel = new PSPFCtrlTemplDetailGlobalModel();
    protected HashMap<String, PSPFCtrlTemplDetailProxy> psPFCtrlTemplDetailProxyMap = new HashMap();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFCtrlTempl psPFCtrlTempl) throws Exception {
        this.psPFCtrlTempl = psPFCtrlTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFCtrlTempl.getPSPFCTRLTEMPLID());
        this.setName(this.psPFCtrlTempl.getPSPFCTRLTEMPLNAME());
        this.setPSObjectData(this.psPFCtrlTempl);
        this.iPSControlType = this.getPSModelStorageContext().getPSControlType(this.psPFCtrlTempl.getPSCTRLTYPEID());
        this.psPFCtrlTemplDetailGlobalModel.init(iPSModelStorageContext, this);
        String strNewCode = StringHelper.format((String)"<#if (ctrl.getPSSysPFPlugin()??)&&(ctrl.getPSSysPFPlugin().hasCode('%1$s','%3$s'))>${ctrl.getPSSysPFPlugin().getCode('%1$s','%3$s')}<#else>%2$s</#if>", (Object)psPFCtrlTempl.getPITEMPLCODE(), (Object)this.psPFCtrlTempl.getTEMPLCODE(), (Object)this.psPFCtrlTempl.getPSPFPUBCODEID());
        this.psPFCtrlTempl.set("TEMPLCODE", strNewCode);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFCtrlTempl.getPSPFPUBCODEID());
    }

    @Override
    public IPSPFCtrlCodePublisher getPSPFCtrlCodePublisher() throws Exception {
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = this.createPSPFCtrlCodePublisher();
        iPSPFCtrlCodePublisher.init(this.getPSModelStorageContext(), this);
        return iPSPFCtrlCodePublisher;
    }

    protected IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psPFCtrlTempl.getPUBOBJ())) {
            return (IPSPFCtrlCodePublisher)this.getPSModelStorageContext().createObject(this.psPFCtrlTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFCtrlTempl iPSPFCtrlTempl = templPSPFStyle.getPSPFCtrlTempl(this.getPSControlType(), this.getPSPFPubCode());
                if (iPSPFCtrlTempl == null) break;
                if (StringHelper.isNullOrEmpty((String)((IPSPFCtrlTemplRuntime)iPSPFCtrlTempl).getPSPFCtrlTemplData().getPUBOBJ())) {
                    if (iPSPFCtrlTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFCtrlTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFCtrlCodePublisher)this.getPSModelStorageContext().createObject(((IPSPFCtrlTemplRuntime)iPSPFCtrlTempl).getPSPFCtrlTemplData().getPUBOBJ());
            }
        }
        return this.getPSPFRuntime().createPSPFCtrlCodePublisher();
    }

    @Override
    public PSPFCtrlTempl getPSPFCtrlTemplData() {
        return this.psPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String strName) throws Exception {
        return this.getPSPFStyle().getPSPFCtrlTemplDetail(this.iPSControlType, this.getPSPFPubCode(), strName);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String strName, boolean bTryMode) throws Exception {
        return this.getPSPFStyle().getPSPFCtrlTemplDetail(this.iPSControlType, this.getPSPFPubCode(), strName, bTryMode);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return (IPSPFCtrlTemplDetail)this.psPFCtrlTemplDetailGlobalModel.findModelHelper(strName, bTryMode);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String strName) throws Exception {
        return (IPSPFCtrlTemplDetail)this.psPFCtrlTemplDetailGlobalModel.findModelHelper(strName);
    }

    @Override
    public IPSControlType getPSControlType() {
        return this.iPSControlType;
    }
}

