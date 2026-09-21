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

import SA.SRFDA.PS.Core.PF.IPSPFAppWFVerTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFAppWFVerCodePublisher;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPFAppWFVerTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFAppWFVerTempl {
    protected PSPFAppTempl psPFAppTempl = null;
    private static final Log log = LogFactory.getLog(PSPFAppWFVerTemplImpl.class);
    protected ArrayList<IPSPFAppWFVerCodePublisher> psPFAppWFVerCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSPFPubCode2 iPSPFPubCode2 = null;
    private String strTemplFilePath = null;

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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFAppWFVerCodePublisher getPSPFAppWFVerCodePublisher() throws Exception {
        ArrayList<IPSPFAppWFVerCodePublisher> arrayList = this.psPFAppWFVerCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFAppWFVerCodePublisher.clear();
            } else if (this.psPFAppWFVerCodePublisher.size() > 0) {
                return this.psPFAppWFVerCodePublisher.remove(0);
            }
        }
        IPSPFAppWFVerCodePublisher iPSPFAppWFVerCodePublisher = this.createPSPFAppWFVerCodePublisher();
        iPSPFAppWFVerCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFAppWFVerCodePublisher;
    }

    protected IPSPFAppWFVerCodePublisher createPSPFAppWFVerCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFAppTempl.getPUBOBJ())) {
            return (IPSPFAppWFVerCodePublisher)ObjectHelper.Create((String)this.psPFAppTempl.getPUBOBJ());
        }
        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u53d1\u5e03\u5668\u5bf9\u8c61");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFAppWFVerCodePublisher(IPSPFAppWFVerCodePublisher IPSPFAppWFVerCodePublisher2) {
        ArrayList<IPSPFAppWFVerCodePublisher> arrayList = this.psPFAppWFVerCodePublisher;
        synchronized (arrayList) {
            this.psPFAppWFVerCodePublisher.add(IPSPFAppWFVerCodePublisher2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFAppWFVerCodePublishers() {
        ArrayList<IPSPFAppWFVerCodePublisher> arrayList = this.psPFAppWFVerCodePublisher;
        synchronized (arrayList) {
            this.psPFAppWFVerCodePublisher.clear();
        }
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
}

