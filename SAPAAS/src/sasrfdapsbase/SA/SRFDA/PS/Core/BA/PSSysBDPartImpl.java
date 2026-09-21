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

import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDPartImpl
extends PSSysBDSchemeObjectImpl
implements IPSSysBDPart {
    private static final Log log = LogFactory.getLog(PSSysBDPartImpl.class);
    protected PSSysBDPart psSysBDPart = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDScheme iPSSysBDScheme, PSSysBDPart psSysBDPart) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDScheme(iPSSysBDScheme);
            this.psSysBDPart = psSysBDPart;
            this.setId(this.psSysBDPart.getPSSYSBDPARTID());
            this.setName(this.psSysBDPart.getPSSYSBDPARTNAME());
            this.setPSObjectData(this.psSysBDPart);
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBDPart.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDPART";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBDScheme().getModelId(), (Object)super.getModelId());
    }
}

