/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBValueOP;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueOP;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSDBValueOP;
import SA.SRFDA.PS.Data.PSSysDBValueOP;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBValueOPImpl
extends PSSystemObjectImpl
implements IPSSysDBValueOP {
    private static final Log log = LogFactory.getLog(PSSysDBValueOPImpl.class);
    protected PSSysDBValueOP psSysDBValueOP = null;
    protected IPSDBValueOP iPSDBValueOP = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDBValueOP psSysDBValueOP) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDBValueOP = psSysDBValueOP;
            this.setId(this.psSysDBValueOP.getPSSYSDBVALUEOPID());
            this.setName(this.psSysDBValueOP.getPSSYSDBVALUEOPNAME());
            this.setPSObjectData(this.psSysDBValueOP);
            if (!StringHelper.IsNullOrEmpty((String)psSysDBValueOP.getPSDBVALUEOPID())) {
                this.iPSDBValueOP = this.getPSModelStorage().getPSDBValueOP(psSysDBValueOP.getPSDBVALUEOPID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBValueOP psDBValueOP) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getCaption(boolean bSimpleMode, String strLanguage) {
        return this.getSimpleName();
    }

    @Override
    public String getSimpleName() {
        return this.psSysDBValueOP.getSIMPLENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSDBVALUEOP";
    }
}

