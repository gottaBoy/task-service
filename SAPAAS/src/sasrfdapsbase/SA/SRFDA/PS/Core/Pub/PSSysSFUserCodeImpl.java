/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFUserCode;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSSysSFUserCodeImpl
extends PSObjectImpl
implements IPSSysSFUserCode {
    private IPSSysSFPub iPSSysSFPub = null;
    private PSSysSFCode psSysSFCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSFPub iPSSysSFPub, PSSysSFCode psSysSFCode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysSFPub = iPSSysSFPub;
        this.psSysSFCode = psSysSFCode;
        this.setId(this.psSysSFCode.getPSSYSSFCODEID());
        this.setName(this.psSysSFCode.getPSSYSSFCODENAME());
        this.setPSObjectData(this.psSysSFCode);
        this.onInit();
    }

    @Override
    public String getProjectType() {
        return this.psSysSFCode.getCODEPATH();
    }

    @Override
    public String getUserCode() {
        return this.psSysSFCode.getUSERCODE();
    }

    @Override
    public String getFilePath() {
        return this.psSysSFCode.getFULLCODENAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysSFPub().getPSSysModelInstId();
    }

    @Override
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }
}

