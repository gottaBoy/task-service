/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.PSDELogicImpl;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDELogic, IPSDELogic> {
    private static final Log log = LogFactory.getLog(PSDELogicGlobalModel.class);

    @Override
    protected PSDELogic getObject(String strPSDELogicId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDELogic onCreateModelHelper(PSDELogic vt, String objObjectId) throws Exception {
        PSDELogicImpl iPSDELogic = new PSDELogicImpl();
        this.setModel(objObjectId, vt, iPSDELogic);
        iPSDELogic.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDELogic;
    }

    @Override
    protected IPSDELogic onCreateModelHelper(PSDELogic vt) throws Exception {
        PSDELogicImpl iPSDELogic = new PSDELogicImpl();
        iPSDELogic.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDELogic;
    }

    @Override
    protected Boolean testObjectRenew(PSDELogic obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSDELogic> getAllModels() throws Exception {
        Vector<PSDELogic> psDELogicList2 = new Vector<PSDELogic>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDELogics(this.getPSDataEntity().getId(), psDELogicList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDELogic> psDELogicList = new Vector<PSDELogic>();
        for (PSDELogic psDELogic : psDELogicList2) {
            if (!StringHelper.isNullOrEmpty((String)psDELogic.getLOGICTYPE()) && StringHelper.compare((String)psDELogic.getLOGICTYPE(), (String)"DELOGIC", (boolean)true) != 0) continue;
            psDELogicList.add(psDELogic);
        }
        for (PSDELogic psDELogic : psDELogicList) {
            this.setModel(psDELogic.getPSDELOGICID(), psDELogic, null);
        }
        return psDELogicList;
    }

    @Override
    protected IPSDELogic registerModel(PSDELogic vt) throws Exception {
        IPSDELogic iPSDELogic = (IPSDELogic)this.internalGetModelHelper(vt.getPSDELOGICID());
        if (iPSDELogic != null) {
            return iPSDELogic;
        }
        this.setModel(vt.getPSDELOGICID(), vt, null);
        return (IPSDELogic)this.findModelHelper(vt.getPSDELOGICID());
    }

    @Override
    protected String getObjectId(PSDELogic vt) {
        return vt.getPSDELOGICID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20020, objObjectId);
    }
}

