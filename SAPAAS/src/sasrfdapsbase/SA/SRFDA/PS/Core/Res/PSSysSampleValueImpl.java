/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSampleValue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Random;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSampleValueImpl
extends PSSystemObjectImpl
implements IPSSysSampleValue {
    private static final Log log = LogFactory.getLog(PSSysSampleValueImpl.class);
    protected PSSysSampleValue psSysSampleValue = null;
    private String strSampleValue = "";
    private boolean bNullValue = false;
    private IPSSystemModule iPSSystemModule = null;
    private String[] randomValues = null;
    private static Random random = new Random();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSampleValue psSysSampleValue) throws Exception {
        try {
            String strValueList;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysSampleValue = psSysSampleValue;
            this.setId(this.psSysSampleValue.getPSSYSSAMPLEVALUEID());
            this.setName(this.psSysSampleValue.getPSSYSSAMPLEVALUENAME());
            this.setPSObjectData(this.psSysSampleValue);
            if (!this.psSysSampleValue.isNULLVALUENull()) {
                this.bNullValue = this.psSysSampleValue.getNULLVALUE();
            }
            this.strSampleValue = this.psSysSampleValue.getVALUE();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSampleValue.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysSampleValue.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)(strValueList = psSysSampleValue.getVALUELIST()))) {
                this.randomValues = strValueList.split("[;]");
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
    @PSModelRTMeta(description="\u7a7a\u503c", fields={"NULLVALUE"})
    public boolean isNullValue() {
        return this.bNullValue;
    }

    @Override
    public String getSampleValue(boolean bRandom) {
        if (bRandom) {
            return this.getRandomValue();
        }
        return this.getValue();
    }

    @Override
    public String getModelType() {
        return "PSSYSSAMPLEVALUE";
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u503c", fields={"VALUE"})
    public String getValue() {
        return this.strSampleValue;
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u793a\u4f8b\u503c")
    public String getRandomValue() {
        int nIndex;
        if (this.randomValues != null && this.randomValues.length > 0 && (nIndex = random.nextInt(2000) % this.randomValues.length) < this.randomValues.length) {
            return this.randomValues[nIndex];
        }
        return this.getValue();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psSysSampleValue.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u503c\u96c6\u5408")
    public String[] getValues() {
        return this.randomValues;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }
}

