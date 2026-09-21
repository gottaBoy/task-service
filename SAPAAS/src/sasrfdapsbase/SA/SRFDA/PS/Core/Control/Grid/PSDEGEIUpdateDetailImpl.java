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
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGEIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGEIUpdateDetailImpl
extends PSObjectImpl
implements IPSDEGEIUpdateDetail {
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateDetailImpl.class);
    protected IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate;
    protected PSDEGEIUDetail psDEGEIUDetail;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate, PSDEGEIUDetail psDEGEIUDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEGridEditItemUpdate = iPSDEGridEditItemUpdate;
            this.psDEGEIUDetail = psDEGEIUDetail;
            this.setId(psDEGEIUDetail.getPSDEGEIUDETAILID());
            this.setName(psDEGEIUDetail.getPSDEGEIUDETAILNAME());
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    @PSModelRTMeta(description="\u66f4\u65b0\u8868\u683c\u5217", fields={"PSDEGRIDCOLNAME"})
    public String getName() {
        return this.getPSDEGridColumnName();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEGridEditItemUpdate.getPSSysModelInstId();
    }

    @Override
    public String getPSDEGridColumnName() {
        return this.psDEGEIUDetail.getPSDEGRIDCOLNAME();
    }

    @Override
    public String getPSDEGridColumnId() {
        return this.psDEGEIUDetail.getPSDEGRIDCOLID();
    }

    @Override
    public String getModelType() {
        return "PSDEGEIUDETAIL";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEGridEditItemUpdate() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEGridEditItemUpdate().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() {
        return this.iPSDEGridEditItemUpdate;
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEGridEditItemUpdate().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEGridEditItemUpdate().getPSDEGrid().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

