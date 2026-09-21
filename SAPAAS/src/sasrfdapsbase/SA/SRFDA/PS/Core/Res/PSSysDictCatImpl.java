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
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDictCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDictCatImpl
extends PSSystemObjectImpl
implements IPSSysDictCat {
    private static final Log log = LogFactory.getLog(PSSysDictCatImpl.class);
    protected PSSysDictCat psSysDictCat = null;
    private boolean bUserCat = true;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDictCat psSysDictCat) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDictCat = psSysDictCat;
            this.setId(this.psSysDictCat.getPSSYSDICTCATID());
            this.setName(this.psSysDictCat.getPSSYSDICTCATNAME());
            this.setPSObjectData(this.psSysDictCat);
            if (!this.psSysDictCat.isUSERCATNull()) {
                this.bUserCat = this.psSysDictCat.getUSERCAT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDictCat.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysDictCat.getPSMODULEID());
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
    public boolean isUserCat() {
        return this.bUserCat;
    }

    @Override
    public String getModelType() {
        return "PSSYSDICTCAT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDictCat.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u8bcd\u6761\u5206\u7c7b\u6807\u8bb0")
    public String getDictCatTag() {
        return this.psSysDictCat.getDICTCATTAG();
    }

    @Override
    @PSModelRTMeta(description="\u8bcd\u6761\u5206\u7c7b\u6807\u8bb02")
    public String getDictCatTag2() {
        return this.psSysDictCat.getDICTCATTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u8bcd\u5178")
    public boolean isUserDictCat() {
        return this.isUserCat();
    }
}

