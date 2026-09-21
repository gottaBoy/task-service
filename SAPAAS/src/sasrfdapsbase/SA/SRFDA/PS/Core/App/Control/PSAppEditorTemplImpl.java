/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppEditorTempl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;

public class PSAppEditorTemplImpl
extends PSApplicationObjectImpl
implements IPSAppEditorTempl {
    protected PSAppEditorTempl psAppEditorTempl = null;
    protected IPSPFEditorTempl iPSPFEditorTempl = null;
    protected PSPFEditorTempl psPFEditorTempl = new PSPFEditorTempl();
    protected IPSPF iPSPF = null;
    protected ArrayList<IPSPFEditorCodePublisher> psPFEditorCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppEditorTempl psAppEditorTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSApplication(iPSApplication);
        this.psAppEditorTempl = psAppEditorTempl;
        this.setId(this.psAppEditorTempl.getPSAPPEDITORTEMPLID());
        this.setName(this.psAppEditorTempl.getPSAPPEDITORTEMPLNAME());
        this.setPSObjectData(psAppEditorTempl);
        this.psAppEditorTempl.CopyTo(this.psPFEditorTempl, true);
        String strPSPFEditorTemplId = Helper.GenUniqueId((String)iPSApplication.getPFType(), (String)psAppEditorTempl.getPSEDITORTYPEID(), (String)psAppEditorTempl.getCONTAINERTYPE(), (String)psAppEditorTempl.getPSPFPUBCODEID());
        this.iPSPFEditorTempl = this.getPSModelStorage().getPSPF(iPSApplication.getPFType()).getPSPFEditorTempl(strPSPFEditorTemplId, true);
        this.iPSPF = this.getPSModelStorage().getPSPF(iPSApplication.getPFType());
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psAppEditorTempl.getPSPFPUBCODEID());
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
        IPSPFEditorCodePublisher iPSPFEditorCodePublisher = null;
        iPSPFEditorCodePublisher = !StringHelper.IsNullOrEmpty((String)this.psAppEditorTempl.getPUBOBJ()) ? (IPSPFEditorCodePublisher)ObjectHelper.Create((String)this.psAppEditorTempl.getPUBOBJ()) : (this.iPSPFEditorTempl != null && !StringHelper.IsNullOrEmpty((String)this.iPSPFEditorTempl.getPSPFEditorTemplData().getPUBOBJ()) ? (IPSPFEditorCodePublisher)ObjectHelper.Create((String)this.iPSPFEditorTempl.getPSPFEditorTemplData().getPUBOBJ()) : this.getPSPF().createPSPFEditorCodePublisher());
        iPSPFEditorCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFEditorCodePublisher;
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

    @Override
    public PSPFEditorTempl getPSPFEditorTemplData() {
        return this.psPFEditorTempl;
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFEditorTempl psPFEditorTempl) throws Exception {
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSAPPEDITORTEMPL";
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
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
}

