/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemRV;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCalendarItemRVImpl
extends PSObjectImpl
implements IPSSysCalendarItemRV {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemRVImpl.class);
    private IPSSysCalendarItem iPSSysCalendarItem = null;
    protected PSSysCalendarItemRV psSysCalendarItemRV = null;
    private String strPSDEViewBaseId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysCalendarItem iPSSysCalendarItem, PSSysCalendarItemRV psSysCalendarItemRV) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysCalendarItem(iPSSysCalendarItem);
            this.psSysCalendarItemRV = psSysCalendarItemRV;
            this.setId(this.psSysCalendarItemRV.getPSSYSCALENDARITEMRVID());
            this.setName(this.psSysCalendarItemRV.getPSSYSCALENDARITEMRVNAME());
            this.strPSDEViewBaseId = this.psSysCalendarItemRV.getPSDEVIEWBASEID();
            this.setPSObjectData(this.psSysCalendarItemRV);
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
    @PSModelRTMeta(description="\u65e5\u5386\u90e8\u4ef6\u9879\u5bf9\u8c61")
    public IPSSysCalendarItem getPSSysCalendarItem() {
        return this.iPSSysCalendarItem;
    }

    protected void setPSSysCalendarItem(IPSSysCalendarItem iPSSysCalendarItem) {
        this.iPSSysCalendarItem = iPSSysCalendarItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysCalendarItem().getPSSysModelInstId();
    }

    @Override
    public String getPSDEViewBaseId() {
        return this.strPSDEViewBaseId;
    }

    @Override
    public String getViewParam() {
        return this.psSysCalendarItemRV.getVIEWPARAMS();
    }

    @Override
    public String getModelType() {
        return "PSSYSCALENDARITEMRV";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysCalendarItem().getPSSysCalendar().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysCalendarItem().getPSSysCalendar().getModelId(), (Object)super.getModelId());
    }
}

