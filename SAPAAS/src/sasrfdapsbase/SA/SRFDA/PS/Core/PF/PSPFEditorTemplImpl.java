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

import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFEditorTempl {
    protected PSPFEditorTempl psPFEditorTempl = null;
    private static final Log log = LogFactory.getLog(PSPFEditorTemplImpl.class);
    protected ArrayList<IPSPFEditorCodePublisher> psPFEditorCodePublisher = new ArrayList();
    private IPSEditorType iPSEditorType = null;
    private String strContainerType = null;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFEditorTempl psPFEditorTempl) throws Exception {
        this.psPFEditorTempl = psPFEditorTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFEditorTempl.getPSPFEDITORTEMPLID());
        this.setName(this.psPFEditorTempl.getPSPFEDITORTEMPLNAME());
        this.setPSObjectData(this.psPFEditorTempl);
        this.iPSEditorType = this.getPSModelStorage().getPSEditorType(psPFEditorTempl.getPSEDITORTYPEID());
        this.strContainerType = psPFEditorTempl.getCONTAINERTYPE();
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFEditorTempl.getPSPFPUBCODEID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFEditorCodePublisher getPSPFEditorCodePublisher() throws Exception {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFEditorCodePublisher.clear();
            } else if (this.psPFEditorCodePublisher.size() > 0) {
                return this.psPFEditorCodePublisher.remove(0);
            }
        }
        IPSPFEditorCodePublisher iPSPFEditorCodePublisher = this.createPSPFEditorCodePublisher();
        iPSPFEditorCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFEditorCodePublisher;
    }

    protected IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFEditorTempl.getPUBOBJ())) {
            return (IPSPFEditorCodePublisher)ObjectHelper.Create((String)this.psPFEditorTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFEditorTempl iPSPFEditorTempl = templPSPFStyle.getPSPFEditorTempl(this.getPSEditorType(), this.getContainerType(), this.getPSPFPubCode());
                if (iPSPFEditorTempl == null) break;
                if (StringHelper.IsNullOrEmpty((String)iPSPFEditorTempl.getPSPFEditorTemplData().getPUBOBJ())) {
                    if (iPSPFEditorTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFEditorTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFEditorCodePublisher)ObjectHelper.Create((String)iPSPFEditorTempl.getPSPFEditorTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFEditorCodePublisher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFEditorCodePublisher(IPSPFEditorCodePublisher iPSPFEditorCodePublisher) {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            this.psPFEditorCodePublisher.add(iPSPFEditorCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFEditorCodePublishers() {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            this.psPFEditorCodePublisher.clear();
        }
    }

    @Override
    public PSPFEditorTempl getPSPFEditorTemplData() {
        return this.psPFEditorTempl;
    }

    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public String getContainerType() {
        return this.strContainerType;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }
}

