/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEFormTempl;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDynaDEFormTemplImpl
extends PSObjectImpl
implements IPSDynaDEFormTempl {
    private static final Log log = LogFactory.getLog(PSDynaDEFormTemplImpl.class);
    protected PSDynaDEFormTempl psDynaDEFormTempl = null;
    private IPSDynaDETempl iPSDynaDETempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDynaDETempl iPSDynaDETempl, PSDynaDEFormTempl psDynaDEFormTempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDynaDETempl = iPSDynaDETempl;
            this.psDynaDEFormTempl = psDynaDEFormTempl;
            this.setId(this.psDynaDEFormTempl.getPSDYNADEFORMTEMPLID());
            this.setName(this.psDynaDEFormTempl.getPSDYNADEFORMTEMPLNAME());
            this.setPSObjectData(this.psDynaDEFormTempl);
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
    public IPSDynaDETempl getPSDynaDETempl() {
        return this.iPSDynaDETempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDynaDETempl().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u5355\u6807\u8bc6")
    public String getPSDEFormId() {
        return this.psDynaDEFormTempl.getPSDEFORMID();
    }

    @Override
    public String getModelType() {
        return "PSDYNADEFORMTEMPL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDynaDETempl().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDynaDETempl().getPSSystem());
    }
}

