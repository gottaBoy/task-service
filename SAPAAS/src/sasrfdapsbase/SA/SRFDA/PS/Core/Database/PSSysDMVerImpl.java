/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDMVer;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSSysDMVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDMVerImpl
extends PSSystemObjectImpl
implements IPSSysDMVer {
    private static final Log log = LogFactory.getLog(PSSysDMVerImpl.class);
    protected PSSysDMVer psSysDMVer = null;
    private boolean bActiveFlag = false;
    private int nDMVer = 1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDMVer psSysDMVer) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDMVer = psSysDMVer;
            this.setId(this.psSysDMVer.getPSSYSDMVERID());
            this.setName(this.psSysDMVer.getPSSYSDMVERNAME());
            this.setPSObjectData(this.psSysDMVer);
            if (!this.psSysDMVer.isACTIVEFLAGNull()) {
                this.bActiveFlag = this.psSysDMVer.getACTIVEFLAG();
            }
            if (!this.psSysDMVer.isDMVERNull()) {
                this.nDMVer = this.psSysDMVer.getDMVER();
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
    public String getModelType() {
        return "PSSYSDMVER";
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u6a21\u578b\u7248\u672c")
    public boolean isActive() {
        return this.bActiveFlag;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u7248\u672c")
    public int getDMVer() {
        return this.nDMVer;
    }
}

