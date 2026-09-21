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

import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailProxy;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFCtrlTempl {
    protected PSPFCtrlTempl psPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplImpl.class);
    protected ArrayList<IPSPFCtrlCodePublisher> psPFCtrlCodePublisher = new ArrayList();
    private IPSControlType iPSControlType = null;
    protected PSPFCtrlTemplDetailGlobalModel psPFCtrlTemplDetailGlobalModel = new PSPFCtrlTemplDetailGlobalModel();
    protected HashMap<String, PSPFCtrlTemplDetailProxy> psPFCtrlTemplDetailProxyMap = new HashMap();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFCtrlTempl psPFCtrlTempl) throws Exception {
        this.psPFCtrlTempl = psPFCtrlTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFCtrlTempl.getPSPFCTRLTEMPLID());
        this.setName(this.psPFCtrlTempl.getPSPFCTRLTEMPLNAME());
        this.setPSObjectData(this.psPFCtrlTempl);
        this.iPSControlType = this.getPSModelStorage().getPSControlType(this.psPFCtrlTempl.getPSCTRLTYPEID());
        this.psPFCtrlTemplDetailGlobalModel.Init(iDAGlobalHelper, this);
        String strNewCode = StringHelper.Format((String)"<#if (ctrl.getPSSysPFPlugin()??)&&(ctrl.getPSSysPFPlugin().hasCode('%1$s','%3$s'))>${ctrl.getPSSysPFPlugin().getCode('%1$s','%3$s')}<#else>%2$s</#if>", (Object)psPFCtrlTempl.getPITEMPLCODE(), (Object)this.psPFCtrlTempl.getTEMPLCODE(), (Object)this.psPFCtrlTempl.getPSPFPUBCODEID());
        this.psPFCtrlTempl.set("TEMPLCODE", strNewCode);
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFCtrlTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFCtrlCodePublisher getPSPFCtrlCodePublisher() throws Exception {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFCtrlCodePublisher.clear();
            } else if (this.psPFCtrlCodePublisher.size() > 0) {
                return this.psPFCtrlCodePublisher.remove(0);
            }
        }
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = this.createPSPFCtrlCodePublisher();
        iPSPFCtrlCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFCtrlCodePublisher;
    }

    protected IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFCtrlTempl.getPUBOBJ())) {
            return (IPSPFCtrlCodePublisher)ObjectHelper.Create((String)this.psPFCtrlTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFCtrlTempl iPSPFCtrlTempl = templPSPFStyle.getPSPFCtrlTempl(this.getPSControlType(), this.getPSPFPubCode());
                if (iPSPFCtrlTempl == null) break;
                if (StringHelper.IsNullOrEmpty((String)iPSPFCtrlTempl.getPSPFCtrlTemplData().getPUBOBJ())) {
                    if (iPSPFCtrlTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFCtrlTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFCtrlCodePublisher)ObjectHelper.Create((String)iPSPFCtrlTempl.getPSPFCtrlTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFCtrlCodePublisher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFCtrlCodePublisher(IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher) {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlCodePublisher.add(iPSPFCtrlCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFCtrlCodePublishers() {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlCodePublisher.clear();
        }
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
        return (IPSPFCtrlTemplDetail)this.psPFCtrlTemplDetailGlobalModel.FindModelHelper(strName, bTryMode);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String strName) throws Exception {
        return (IPSPFCtrlTemplDetail)this.psPFCtrlTemplDetailGlobalModel.FindModelHelper(strName);
    }

    @Override
    public IPSControlType getPSControlType() {
        return this.iPSControlType;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }
}

