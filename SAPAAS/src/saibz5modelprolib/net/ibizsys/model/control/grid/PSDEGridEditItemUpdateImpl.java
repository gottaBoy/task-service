/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdateRuntime;
import net.ibizsys.model.control.grid.PSDEGEIUpdateDetailImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.model.entity.PSDEGEIUpdate;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridEditItemUpdateImpl
extends PSObjectImpl
implements IPSDEGridEditItemUpdate,
IPSDEGridEditItemUpdateRuntime {
    private static final Log log = LogFactory.getLog(PSDEGridEditItemUpdateImpl.class);
    protected IPSDEGrid iPSDEGrid;
    protected PSDEGEIUpdate psDEGEIUpdate;
    protected IPSDEAction iPSDEAction = null;
    protected ArrayList<IPSDEGEIUpdateDetail> psDEGEIUpdateDetailList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEGrid iPSDEGrid, PSDEGEIUpdate psDEGEIUpdate) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEGrid = iPSDEGrid;
            this.psDEGEIUpdate = psDEGEIUpdate;
            this.setId(psDEGEIUpdate.getPSDEGEIUPDATEID());
            this.setName(psDEGEIUpdate.getPSDEGEIUPDATENAME());
            this.iPSDEAction = iPSDEGrid.getPSDataEntity().getPSDEAction(psDEGEIUpdate.getPSDEACTIONID());
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
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEGEIUpdateDetails();
    }

    protected void onPreparePSDEGEIUpdateDetails() throws Exception {
        this.psDEGEIUpdateDetailList.clear();
        ArrayList<PSDEGEIUDetail> psDEGEIUDetailList = this.psDEGEIUpdate.getPSDEGEIUDetails(false);
        if (psDEGEIUDetailList == null) {
            return;
        }
        for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            PSDEGEIUpdateDetailImpl psDEGEIUpdateDetailImpl = new PSDEGEIUpdateDetailImpl();
            psDEGEIUpdateDetailImpl.init(this.getPSModelStorageContext(), this, psDEGEIUDetail);
            this.psDEGEIUpdateDetailList.add(psDEGEIUpdateDetailImpl);
        }
    }

    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408")
    public Iterator<IPSDEGEIUpdateDetail> getPSDEGEIUpdateDetails() {
        return this.psDEGEIUpdateDetailList.iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psDEGEIUpdate.getCODENAME();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u683c\u5bf9\u8c61")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() throws Exception {
        return this.iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEGrid).getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEGEIUPDATE";
    }
}

