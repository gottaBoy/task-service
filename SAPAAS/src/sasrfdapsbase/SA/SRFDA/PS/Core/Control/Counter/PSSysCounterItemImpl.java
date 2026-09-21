/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysCounterItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCounterItemImpl
extends PSObjectImpl
implements IPSSysCounterItem {
    private static final Log log = LogFactory.getLog(PSSysCounterItemImpl.class);
    private IPSSysCounter iPSSysCounter = null;
    private PSSysCounterItem psSysCounterItem = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysCounter iPSSysCounter, PSSysCounterItem psSysCounterItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysCounter = iPSSysCounter;
            this.psSysCounterItem = psSysCounterItem;
            this.setPSObjectData(psSysCounterItem);
            this.setId(psSysCounterItem.getPSSYSCOUNTERITEMID());
            this.setName(psSysCounterItem.getPSSYSCOUNTERITEMNAME());
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psSysCounterItem.getLOGICNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysCounter().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysCounter().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysCounter().getFullModelName(), (Object)this.getModelName());
    }
}

