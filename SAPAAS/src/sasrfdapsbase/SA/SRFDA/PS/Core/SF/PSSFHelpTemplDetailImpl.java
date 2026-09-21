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
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFHelpPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFHelpTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFHelpTemplDetailImpl
extends PSSFObjectImpl
implements IPSSFHelpTemplDetail {
    protected PSSFHelpTemplDetail psSFHelpTemplDetail = null;
    protected IPSSFHelpTempl2 iPSSFHelpTempl = null;
    private static final Log log = LogFactory.getLog(PSSFHelpTemplDetailImpl.class);
    protected ArrayList<IPSSFHelpPartCodePublisher> psSFHelpPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFHelpTempl2 iPSSFHelpTempl, PSSFHelpTemplDetail psSFHelpTemplDetail) throws Exception {
        this.psSFHelpTemplDetail = psSFHelpTemplDetail;
        this.iPSSFHelpTempl = iPSSFHelpTempl;
        this.setPSSF(this.iPSSFHelpTempl.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFHelpTemplDetail.getPSSFHELPDETAILID());
        this.setName(this.psSFHelpTemplDetail.getPSSFHELPDETAILNAME());
        this.setPSObjectData(this.psSFHelpTemplDetail);
        this.onInit();
    }

    @Override
    public IPSSFPubCode getPSSFPubCode() throws Exception {
        return this.iPSSFHelpTempl.getPSSFPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFHelpPartCodePublisher getPSSFHelpPartCodePublisher() throws Exception {
        ArrayList<IPSSFHelpPartCodePublisher> arrayList = this.psSFHelpPartCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psSFHelpPartCodePublisher.clear();
            } else if (this.psSFHelpPartCodePublisher.size() > 0) {
                return this.psSFHelpPartCodePublisher.remove(0);
            }
        }
        IPSSFHelpPartCodePublisher iPSSFHelpPartCodePublisher = this.createPSSFHelpPartCodePublisher();
        iPSSFHelpPartCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFHelpPartCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFHelpPartCodePublisher(IPSSFHelpPartCodePublisher iPSSFHelpPartCodePublisher) {
        ArrayList<IPSSFHelpPartCodePublisher> arrayList = this.psSFHelpPartCodePublisher;
        synchronized (arrayList) {
            this.psSFHelpPartCodePublisher.add(iPSSFHelpPartCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFHelpPartCodePublishers() {
        ArrayList<IPSSFHelpPartCodePublisher> arrayList = this.psSFHelpPartCodePublisher;
        synchronized (arrayList) {
            this.psSFHelpPartCodePublisher.clear();
        }
    }

    @Override
    public PSSFHelpTemplDetail getPSSFHelpTemplDetailData() {
        return this.psSFHelpTemplDetail;
    }

    @Override
    public IPSSFHelpTempl2 getPSSFHelpTempl() {
        return this.iPSSFHelpTempl;
    }

    @Override
    public IPSSFHelpPartCodePublisher createPSSFHelpPartCodePublisher() throws Exception {
        IPSSFHelpPartCodePublisher iPSSFHelpPartCodePublisher = null;
        if (!StringHelper.IsNullOrEmpty((String)this.psSFHelpTemplDetail.getPUBOBJ())) {
            iPSSFHelpPartCodePublisher = (IPSSFHelpPartCodePublisher)ObjectHelper.Create((String)this.psSFHelpTemplDetail.getPUBOBJ());
        }
        return iPSSFHelpPartCodePublisher;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return this.psSFHelpTemplDetail.getTEMPLDESC();
    }

    @Override
    public String getTypeName() {
        return this.psSFHelpTemplDetail.getTYPENAME();
    }
}

