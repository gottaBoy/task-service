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
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysI18N;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysI18NImpl
extends PSSystemObjectImpl
implements IPSSysI18N {
    protected PSAppLan psAppLan = null;
    private static final Log log = LogFactory.getLog(PSSysI18NImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.setId(this.iPSSystem.getId());
            this.setName(this.iPSSystem.getName());
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
    public String getModelType() {
        return "PSSYSI18N";
    }

    @Override
    protected String onGetDynaModelTag() {
        return "DEFAULT";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8bed\u8a00\u96c6\u5408", child=true, dumpref=true, rtdump=2, dynamodelmode=4)
    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception {
        return this.getPSSystem().getAllPSSysLans();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8bed\u8a00\u8d44\u6e90\u96c6\u5408", child=true, dynamodelmode=4)
    public Iterator<IPSLanguageRes> getAllPSLanguageReses() throws Exception {
        return this.getPSSystem().getAllPSLanguageReses();
    }
}

