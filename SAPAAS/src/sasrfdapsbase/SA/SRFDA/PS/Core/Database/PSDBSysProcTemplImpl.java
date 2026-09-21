/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBSPPartTempl;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.PSDBSPPartTemplGlobalModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSDBSysProcCodePublisher;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBSysProcTemplImpl
extends PSObjectImpl
implements IPSDBSysProcTempl {
    protected PSDBSysProcTempl psDBSysProcTempl = null;
    protected IPSDBType iPSDBType = null;
    private static final Log log = LogFactory.getLog(PSDBSysProcTemplImpl.class);
    protected PSDBSPPartTemplGlobalModel psDBSPPartTemplGlobalModel = new PSDBSPPartTemplGlobalModel();
    protected ArrayList<IPSDBSysProcCodePublisher> psDBSysProcCodePublisher = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType, PSDBSysProcTempl psDBSysProcTempl) throws Exception {
        this.iPSDBType = iPSDBType;
        this.psDBSysProcTempl = psDBSysProcTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDBSysProcTempl.getPSDBSYSPROCTEMPLID());
        this.setName(psDBSysProcTempl.getPSDBSYSPROCTEMPLNAME());
        this.setPSObjectData(this.psDBSysProcTempl);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.psDBSPPartTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
    }

    @Override
    public IPSDBSPPartTempl getPSDBSPPartTempl(String strDBSPPartTemplId) throws Exception {
        return (IPSDBSPPartTempl)this.psDBSPPartTemplGlobalModel.FindModelHelper(strDBSPPartTemplId);
    }

    @Override
    public void resetPSDBSPPartTempl(String strDBSPPartTemplId) throws Exception {
        this.psDBSPPartTemplGlobalModel.ResetModel(strDBSPPartTemplId);
    }

    @Override
    public IPSDBType getPSDBType() {
        return this.iPSDBType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDBSysProcCodePublisher getPSDBSysProcCodePublisher() throws Exception {
        ArrayList<IPSDBSysProcCodePublisher> arrayList = this.psDBSysProcCodePublisher;
        synchronized (arrayList) {
            if (this.psDBSysProcCodePublisher.size() > 0) {
                return this.psDBSysProcCodePublisher.remove(0);
            }
        }
        IPSDBSysProcCodePublisher iPSDBSysProcCodePublisher = (IPSDBSysProcCodePublisher)ObjectHelper.Create((String)this.psDBSysProcTempl.getPUBOBJ());
        iPSDBSysProcCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSDBSysProcCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSDBSysProcCodePublisher(IPSDBSysProcCodePublisher iPSDBSysProcCodePublisher) {
        ArrayList<IPSDBSysProcCodePublisher> arrayList = this.psDBSysProcCodePublisher;
        synchronized (arrayList) {
            this.psDBSysProcCodePublisher.add(iPSDBSysProcCodePublisher);
        }
    }

    @Override
    public PSDBSysProcTempl getPSDBSysProcTemplData() {
        return this.psDBSysProcTempl;
    }

    @Override
    public String getPSDBSysProcTypeId() {
        return this.psDBSysProcTempl.getPSDBSYSPROCTYPEID();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDBType.getPSSysModelInstId();
    }
}

