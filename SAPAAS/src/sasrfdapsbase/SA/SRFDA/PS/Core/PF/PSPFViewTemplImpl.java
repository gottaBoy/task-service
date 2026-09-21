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
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFViewTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFViewTempl {
    protected PSPFViewTempl psPFViewTempl = null;
    private static final Log log = LogFactory.getLog(PSPFViewTemplImpl.class);
    protected ArrayList<IPSPFViewCodePublisher> psPFViewCodePublisher = new ArrayList();
    private IPSViewType iPSViewType = null;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iSPFStyle, PSPFViewTempl psPFViewTempl) throws Exception {
        this.psPFViewTempl = psPFViewTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFViewTempl.getPSPFVIEWTEMPLID());
        this.setName(this.psPFViewTempl.getPSPFVIEWTEMPLNAME());
        this.setPSObjectData(this.psPFViewTempl);
        this.iPSViewType = this.getPSModelStorage().getPSViewType(this.psPFViewTempl.getPSVIEWTYPEID());
        String strNewCode = StringHelper.Format((String)"<#if (view.getPSSysPFPlugin()??)&&(view.getPSSysPFPlugin().hasCode('%1$s','%3$s'))>${view.getPSSysPFPlugin().getCode('%1$s','%3$s')}<#else>%2$s</#if>", (Object)psPFViewTempl.getPITEMPLCODE(), (Object)this.psPFViewTempl.getTEMPLCODE(), (Object)this.psPFViewTempl.getPSPFPUBCODEID());
        this.psPFViewTempl.set("TEMPLCODE", strNewCode);
        this.onInit();
    }

    @Override
    public PSPFViewTempl getPSPFViewTemplData() {
        return this.psPFViewTempl;
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFViewTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFViewCodePublisher getPSPFViewCodePublisher() throws Exception {
        ArrayList<IPSPFViewCodePublisher> arrayList = this.psPFViewCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFViewCodePublisher.clear();
            } else if (this.psPFViewCodePublisher.size() > 0) {
                return this.psPFViewCodePublisher.remove(0);
            }
        }
        IPSPFViewCodePublisher iPSPFViewCodePublisher = this.createPSPFViewCodePublisher();
        iPSPFViewCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFViewCodePublisher;
    }

    protected IPSPFViewCodePublisher createPSPFViewCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFViewTempl.getPUBOBJ())) {
            return (IPSPFViewCodePublisher)ObjectHelper.Create((String)this.psPFViewTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFViewTempl iPSPFViewTempl = templPSPFStyle.getPSPFViewTempl(this.getPSViewType(), this.getPSPFPubCode());
                if (iPSPFViewTempl == null) break;
                if (StringHelper.IsNullOrEmpty((String)iPSPFViewTempl.getPSPFViewTemplData().getPUBOBJ())) {
                    if (iPSPFViewTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFViewTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFViewCodePublisher)ObjectHelper.Create((String)iPSPFViewTempl.getPSPFViewTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFViewCodePublisher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFViewCodePublisher(IPSPFViewCodePublisher iPSPFViewCodePublisher) {
        ArrayList<IPSPFViewCodePublisher> arrayList = this.psPFViewCodePublisher;
        synchronized (arrayList) {
            this.psPFViewCodePublisher.add(iPSPFViewCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFViewCodePublishers() {
        ArrayList<IPSPFViewCodePublisher> arrayList = this.psPFViewCodePublisher;
        synchronized (arrayList) {
            this.psPFViewCodePublisher.clear();
        }
    }

    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @Override
    public String getTemplDocUrl() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSPFStyle().getTemplDocRootUrl())) {
            return "http://www.ibizsys.net";
        }
        try {
            String strPSPFViewTemplFolder = StringHelper.Format((String)"%1$s%2$sview", (Object)this.getPSPFStyle().getTemplDocRootUrl(), (Object)"/");
            String strViewFolder = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strPSPFViewTemplFolder, (Object)"/", (Object)this.getPSViewType().getId());
            String strFileName = StringHelper.Format((String)"%1$s%2$s", (Object)this.getPSPFPubCode().getName(), (Object)this.getPSPFPubCode().getFileNameExt());
            return StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strViewFolder, (Object)"/", (Object)strFileName);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return this.getTemplDocUrl();
        }
    }
}

