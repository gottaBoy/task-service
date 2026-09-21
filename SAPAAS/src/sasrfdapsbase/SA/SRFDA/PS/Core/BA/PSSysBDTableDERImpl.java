/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBATable
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDER;
import SA.SRFDA.PS.Core.BA.PSSysBDTableObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDTableDER;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBATable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableDERImpl
extends PSSysBDTableObjectImpl
implements IPSSysBDTableDER {
    private static final Log log = LogFactory.getLog(PSSysBDTableDERImpl.class);
    protected PSSysBDTableDER psSysBDTableDER = null;
    private IPSDER1N iPSDER1N = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDTable iPSSysBDTable, PSSysBDTableDER psSysBDTableDER) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDTable(iPSSysBDTable);
            this.psSysBDTableDER = psSysBDTableDER;
            this.setId(this.psSysBDTableDER.getPSSYSBDTABLEDERID());
            this.setName(this.psSysBDTableDER.getPSSYSBDTABLEDERNAME());
            this.setPSObjectData(this.psSysBDTableDER);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSDER1N = (IPSDER1N)this.getPSSysBDScheme().getPSSystem().getPSDER(this.psSysBDTableDER.getPSDERID());
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDTABLEDER";
    }

    @Override
    public IBATable getBATable() {
        return this.getPSSysBDTable();
    }

    @Override
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    public String getMajorDEName() {
        return this.getPSDER1N().getMajorDEName();
    }

    public String getMinorDEName() {
        return this.getPSDER1N().getMinorDEName();
    }

    public String getDERFieldName() {
        return this.getPSDER1N().getPickupDEFName();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBDTable().getModelId(), (Object)super.getModelId());
    }
}

