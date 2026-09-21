/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDTableRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableRSImpl
extends PSSysBDSchemeObjectImpl
implements IPSSysBDTableRS {
    private static final Log log = LogFactory.getLog(PSSysBDTableRSImpl.class);
    protected PSSysBDTableRS psSysBDTableRS = null;
    private IPSSysBDTable majorPSSysBDTable = null;
    private IPSSysBDTable minorPSSysBDTable = null;
    private IPSDER1N iPSDER1N = null;
    private String strCodeName = null;
    private String strMinorCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDScheme iPSSysBDScheme, PSSysBDTableRS psSysBDTableRS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDScheme(iPSSysBDScheme);
            this.psSysBDTableRS = psSysBDTableRS;
            this.setId(this.psSysBDTableRS.getPSSYSBDTABLERSID());
            this.setName(this.psSysBDTableRS.getPSSYSBDTABLERSNAME());
            this.setPSObjectData(this.psSysBDTableRS);
            this.strCodeName = this.psSysBDTableRS.getCODENAME();
            this.strMinorCodeName = this.psSysBDTableRS.getMINORCODENAME();
            this.majorPSSysBDTable = this.getPSSysBDScheme().getPSSysBDTable(psSysBDTableRS.getMAJORPSSYSBDTABLEID());
            this.minorPSSysBDTable = this.getPSSysBDScheme().getPSSysBDTable(psSysBDTableRS.getMINORPSSYSBDTABLEID());
            if (!StringHelper.isNullOrEmpty((String)this.psSysBDTableRS.getPSDERID())) {
                this.iPSDER1N = this.getPSSysBDScheme().getPSSystem().getPSDER1N(this.psSysBDTableRS.getPSDERID());
                if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.iPSDER1N.getCodeName();
                }
                if (StringHelper.isNullOrEmpty((String)this.strMinorCodeName)) {
                    this.strMinorCodeName = this.iPSDER1N.getMinorCodeName();
                }
            }
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
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u6570\u636e\u8868\u5bf9\u8c61")
    public IPSSysBDTable getMajorPSSysBDTable() {
        return this.majorPSSysBDTable;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u6570\u636e\u8868\u5bf9\u8c61")
    public IPSSysBDTable getMinorPSSysBDTable() {
        return this.minorPSSysBDTable;
    }

    @Override
    public String getModelType() {
        return "PSSYSBDTABLERS";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBDScheme().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5173\u7cfb\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5173\u7cfb\u4ee3\u7801\u540d\u79f0")
    public String getMinorCodeName() {
        return this.strMinorCodeName;
    }
}

