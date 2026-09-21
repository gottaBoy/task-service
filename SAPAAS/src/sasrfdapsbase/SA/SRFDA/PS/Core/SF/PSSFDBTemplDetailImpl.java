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

import SA.SRFDA.PS.Core.Pub.IPSSFDBPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFDBTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFDBTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFDBTemplDetailImpl
extends PSSFObjectImpl
implements IPSSFDBTemplDetail {
    protected PSSFDBTemplDetail psSFDBTemplDetail = null;
    protected IPSSFDBTempl2 iPSSFDBTempl = null;
    private static final Log log = LogFactory.getLog(PSSFDBTemplDetailImpl.class);
    protected ArrayList<IPSSFDBPartCodePublisher> psSFDBPartCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFDBTempl2 iPSSFDBTempl, PSSFDBTemplDetail psSFDBTemplDetail) throws Exception {
        this.psSFDBTemplDetail = psSFDBTemplDetail;
        this.iPSSFDBTempl = iPSSFDBTempl;
        this.setPSSF(this.iPSSFDBTempl.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFDBTemplDetail.getPSSFDBDETAILID());
        this.setName(this.psSFDBTemplDetail.getPSSFDBDETAILNAME());
        this.setPSObjectData(this.psSFDBTemplDetail);
        this.onInit();
    }

    @Override
    public IPSSFPubCode getPSSFPubCode() throws Exception {
        return this.iPSSFDBTempl.getPSSFPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFDBPartCodePublisher getPSSFDBPartCodePublisher() throws Exception {
        ArrayList<IPSSFDBPartCodePublisher> arrayList = this.psSFDBPartCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psSFDBPartCodePublisher.clear();
            } else if (this.psSFDBPartCodePublisher.size() > 0) {
                return this.psSFDBPartCodePublisher.remove(0);
            }
        }
        IPSSFDBPartCodePublisher iPSSFDBPartCodePublisher = this.createPSSFDBPartCodePublisher();
        iPSSFDBPartCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFDBPartCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFDBPartCodePublisher(IPSSFDBPartCodePublisher iPSSFDBPartCodePublisher) {
        ArrayList<IPSSFDBPartCodePublisher> arrayList = this.psSFDBPartCodePublisher;
        synchronized (arrayList) {
            this.psSFDBPartCodePublisher.add(iPSSFDBPartCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFDBPartCodePublishers() {
        ArrayList<IPSSFDBPartCodePublisher> arrayList = this.psSFDBPartCodePublisher;
        synchronized (arrayList) {
            this.psSFDBPartCodePublisher.clear();
        }
    }

    @Override
    public PSSFDBTemplDetail getPSSFDBTemplDetailData() {
        return this.psSFDBTemplDetail;
    }

    @Override
    public IPSSFDBTempl2 getPSSFDBTempl() {
        return this.iPSSFDBTempl;
    }

    @Override
    public IPSSFDBPartCodePublisher createPSSFDBPartCodePublisher() throws Exception {
        IPSSFDBPartCodePublisher iPSSFDBPartCodePublisher = null;
        if (!StringHelper.IsNullOrEmpty((String)this.psSFDBTemplDetail.getPUBOBJ())) {
            iPSSFDBPartCodePublisher = (IPSSFDBPartCodePublisher)ObjectHelper.Create((String)this.psSFDBTemplDetail.getPUBOBJ());
        }
        return iPSSFDBPartCodePublisher;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return this.psSFDBTemplDetail.getTEMPLDESC();
    }

    @Override
    public String getDBName() {
        return this.psSFDBTemplDetail.getDBNAME();
    }
}

