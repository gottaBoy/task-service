/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFAppObjectTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFAppObjectCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFAppObjectCodePublisherImpl;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPFAppObjectTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFAppObjectTempl {
    private static final Log log = LogFactory.getLog(PSPFAppObjectTemplImpl.class);
    protected PSPFAppTempl psPFAppTempl = null;
    protected long nLastResetTime = System.currentTimeMillis();
    protected final long RESETTIMER = 600000L;
    private IPSPFPubCode2 iPSPFPubCode2 = null;
    private String strTemplFilePath = null;
    protected ArrayList<IPSPFAppObjectCodePublisher> psPFCodePublisherList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle2 iPSPFStyle, IPSPFPubCode2 iPSPFPubCode2, PSPFAppTempl psPFAppTempl) throws Exception {
        this.psPFAppTempl = psPFAppTempl;
        this.setPSPF(iPSPFStyle.getPSPF());
        this.setPSPFStyle(iPSPFStyle);
        this.iPSPFPubCode2 = iPSPFPubCode2;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFAppTempl.getPSPFAPPTEMPLID());
        this.setName(this.psPFAppTempl.getPSPFAPPTEMPLNAME());
        this.setPSObjectData(this.psPFAppTempl);
        this.strTemplFilePath = this.psPFAppTempl.getTEMPLFILEPATH();
        this.onInit();
    }

    @Override
    public PSPFAppTempl getPSPFAppTemplData() {
        return this.psPFAppTempl;
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFPubCode2;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getFileName() {
        return this.psPFAppTempl.getFILENAME();
    }

    @Override
    public String getFilePath() {
        return this.psPFAppTempl.getCODEPATH();
    }

    @Override
    public String getTemplFilePath() {
        return this.strTemplFilePath;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFAppObjectCodePublisher getPSPFCodePublisher() throws Exception {
        ArrayList<IPSPFAppObjectCodePublisher> arrayList = this.psPFCodePublisherList;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFCodePublisherList.clear();
            } else if (this.psPFCodePublisherList.size() > 0) {
                return this.psPFCodePublisherList.remove(0);
            }
        }
        IPSPFAppObjectCodePublisher iPSPFCodePublisher = this.createPSPFCodePublisher();
        iPSPFCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFCodePublisher;
    }

    protected IPSPFAppObjectCodePublisher createPSPFCodePublisher() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psPFAppTempl.getPUBOBJ())) {
            return (IPSPFAppObjectCodePublisher)ObjectHelper.create((String)this.psPFAppTempl.getPUBOBJ());
        }
        return this.createDefaultCodePublisher();
    }

    protected IPSPFAppObjectCodePublisher createDefaultCodePublisher() throws Exception {
        return new PSPFAppObjectCodePublisherImpl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFCodePublisher(IPSPFAppObjectCodePublisher iPSPFCodePublisher) {
        ArrayList<IPSPFAppObjectCodePublisher> arrayList = this.psPFCodePublisherList;
        synchronized (arrayList) {
            this.psPFCodePublisherList.add(iPSPFCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFCodePublishers() {
        ArrayList<IPSPFAppObjectCodePublisher> arrayList = this.psPFCodePublisherList;
        synchronized (arrayList) {
            this.psPFCodePublisherList.clear();
        }
    }
}

