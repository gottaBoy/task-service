/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFIUpdateDetail
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFIUpdateDetail;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.IPSDEFormItemUpdateRuntime;
import net.ibizsys.model.control.form.PSDEFIUpdateDetailImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.entity.PSDEFIUDetail;
import net.ibizsys.model.entity.PSDEFIUpdate;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormItemUpdateImpl
extends PSObjectImpl
implements IPSDEFormItemUpdate,
IPSDEFormItemUpdateRuntime {
    private static final Log log = LogFactory.getLog(PSDEFormItemUpdateImpl.class);
    protected IPSDEForm iPSDEForm;
    protected PSDEFIUpdate psDEFIUpdate;
    protected IPSDEAction iPSDEAction = null;
    protected ArrayList<IPSDEFIUpdateDetail> psDEFIUpdateDetailList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEForm iPSDEForm, PSDEFIUpdate psDEFIUpdate) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEForm = iPSDEForm;
            this.psDEFIUpdate = psDEFIUpdate;
            this.setId(psDEFIUpdate.getPSDEFIUPDATEID());
            this.setName(psDEFIUpdate.getPSDEFIUPDATENAME());
            this.iPSDEAction = iPSDEForm.getPSDataEntity().getPSDEAction(psDEFIUpdate.getPSDEACTIONID());
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
        this.onPreparePSDEFIUpdateDetails();
    }

    protected void onPreparePSDEFIUpdateDetails() throws Exception {
        this.psDEFIUpdateDetailList.clear();
        ArrayList<PSDEFIUDetail> psDEFIUDetailList = this.psDEFIUpdate.getPSDEFIUDetails(false);
        if (psDEFIUDetailList == null) {
            return;
        }
        for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
            PSDEFIUpdateDetailImpl psDEFIUpdateDetailImpl = new PSDEFIUpdateDetailImpl();
            psDEFIUpdateDetailImpl.init(this.getPSModelStorageContext(), this, psDEFIUDetail);
            this.psDEFIUpdateDetailList.add(psDEFIUpdateDetailImpl);
        }
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408")
    public Iterator<IPSDEFIUpdateDetail> getPSDEFIUpdateDetails() {
        return this.psDEFIUpdateDetailList.iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psDEFIUpdate.getCODENAME();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u5355\u5bf9\u8c61")
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() throws Exception {
        return this.iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEForm).getPSSysModelInstId();
    }
}

