/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail;
import net.ibizsys.model.control.grid.IPSDEGEIUpdateDetailRuntime;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGEIUpdateDetailImpl
extends PSObjectImpl
implements IPSDEGEIUpdateDetail,
IPSDEGEIUpdateDetailRuntime {
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateDetailImpl.class);
    protected IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate;
    protected PSDEGEIUDetail psDEGEIUDetail;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate, PSDEGEIUDetail psDEGEIUDetail) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEGridEditItemUpdate = iPSDEGridEditItemUpdate;
            this.psDEGEIUDetail = psDEGEIUDetail;
            this.setId(psDEGEIUDetail.getPSDEGEIUDETAILID());
            this.setName(psDEGEIUDetail.getPSDEGEIUDETAILNAME());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEGridEditItemUpdate).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u66f4\u65b0\u8868\u683c\u5217\u540d\u79f0")
    public String getPSDEGridColumnName() {
        return this.psDEGEIUDetail.getPSDEGRIDCOLNAME();
    }

    public String getPSDEGridColumnId() {
        return this.psDEGEIUDetail.getPSDEGRIDCOLID();
    }

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() {
        return this.iPSDEGridEditItemUpdate;
    }
}

