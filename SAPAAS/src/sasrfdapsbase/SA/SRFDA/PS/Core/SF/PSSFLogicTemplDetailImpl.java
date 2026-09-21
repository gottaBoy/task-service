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

import SA.SRFDA.PS.Core.Pub.IPSSFLogicPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFLogicTemplDetailImpl
extends PSSFObjectImpl
implements IPSSFLogicTemplDetail {
    protected PSSFLogicTemplDetail psSFLogicTemplDetail = null;
    protected IPSSFLogicTempl2 iPSSFLogicTempl = null;
    private static final Log log = LogFactory.getLog(PSSFLogicTemplDetailImpl.class);
    protected ArrayList<IPSSFLogicPartCodePublisher> psSFLogicPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFLogicTempl2 iPSSFLogicTempl, PSSFLogicTemplDetail psSFLogicTemplDetail) throws Exception {
        this.psSFLogicTemplDetail = psSFLogicTemplDetail;
        this.iPSSFLogicTempl = iPSSFLogicTempl;
        this.setPSSF(this.iPSSFLogicTempl.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFLogicTemplDetail.getPSSFLOGICDETAILID());
        this.setName(this.psSFLogicTemplDetail.getPSSFLOGICDETAILNAME());
        this.setPSObjectData(this.psSFLogicTemplDetail);
        this.onInit();
    }

    @Override
    public IPSSFPubCode getPSSFPubCode() throws Exception {
        return this.iPSSFLogicTempl.getPSSFPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFLogicPartCodePublisher getPSSFLogicPartCodePublisher() throws Exception {
        ArrayList<IPSSFLogicPartCodePublisher> arrayList = this.psSFLogicPartCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psSFLogicPartCodePublisher.clear();
            } else if (this.psSFLogicPartCodePublisher.size() > 0) {
                return this.psSFLogicPartCodePublisher.remove(0);
            }
        }
        IPSSFLogicPartCodePublisher iPSSFLogicPartCodePublisher = this.createPSSFLogicPartCodePublisher();
        iPSSFLogicPartCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFLogicPartCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFLogicPartCodePublisher(IPSSFLogicPartCodePublisher iPSSFLogicPartCodePublisher) {
        ArrayList<IPSSFLogicPartCodePublisher> arrayList = this.psSFLogicPartCodePublisher;
        synchronized (arrayList) {
            this.psSFLogicPartCodePublisher.add(iPSSFLogicPartCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFLogicPartCodePublishers() {
        ArrayList<IPSSFLogicPartCodePublisher> arrayList = this.psSFLogicPartCodePublisher;
        synchronized (arrayList) {
            this.psSFLogicPartCodePublisher.clear();
        }
    }

    @Override
    public PSSFLogicTemplDetail getPSSFLogicTemplDetailData() {
        return this.psSFLogicTemplDetail;
    }

    @Override
    public IPSSFLogicTempl2 getPSSFLogicTempl() {
        return this.iPSSFLogicTempl;
    }

    @Override
    public IPSSFLogicPartCodePublisher createPSSFLogicPartCodePublisher() throws Exception {
        IPSSFLogicPartCodePublisher iPSSFLogicPartCodePublisher = null;
        if (!StringHelper.IsNullOrEmpty((String)this.psSFLogicTemplDetail.getPUBOBJ())) {
            iPSSFLogicPartCodePublisher = (IPSSFLogicPartCodePublisher)ObjectHelper.Create((String)this.psSFLogicTemplDetail.getPUBOBJ());
        }
        return iPSSFLogicPartCodePublisher;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return this.psSFLogicTemplDetail.getTEMPLDESC();
    }

    @Override
    public String getLogicName() {
        return this.psSFLogicTemplDetail.getLOGICNAME();
    }
}

