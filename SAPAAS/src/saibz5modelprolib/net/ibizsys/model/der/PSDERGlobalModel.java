/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import java.util.Vector;
import net.ibizsys.model.PSSystemException;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERRuntime;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.der.IPSDERTypeRuntime;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERGlobalModel
extends PSSystemGlobalModelBase<String, PSDER, IPSDERBase> {
    private static final Log log = LogFactory.getLog(PSDERGlobalModel.class);

    @Override
    protected PSDER getObject(String strPSDERId) {
        PSDER psDER = new PSDER();
        CallResult callResult = this.getPSModelQueryHelper().getPSDER(strPSDERId, psDER);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDERId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.compare((String)this.getPSSystem().getId(), (String)psDER.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        if (psDER.getParamIntValue("VALIDFLAG", 1) == 0) {
            return null;
        }
        return psDER;
    }

    @Override
    protected IPSDERBase onCreateModelHelper(PSDER vt) throws Exception {
        IPSDERType iPSDERType = this.getPSModelStorageContext().getPSDERType(vt.getDERTYPE());
        IPSDERBase iPSDER = ((IPSDERTypeRuntime)iPSDERType).createPSDER(vt);
        IPSDataEntity majorPSDataEntity = this.getPSSystem().getPSDataEntity(vt.getMAJORPSDEID(), true);
        IPSDataEntity minorPSDataEntity = this.getPSSystem().getPSDataEntity(vt.getMINORPSDEID(), true);
        ((IPSDERRuntime)iPSDER).init(this.getPSModelStorageContext(), majorPSDataEntity, minorPSDataEntity, vt);
        return iPSDER;
    }

    @Override
    protected Boolean testObjectRenew(PSDER obj) {
        return false;
    }

    @Override
    protected IPSDERBase registerModel(PSDER vt) throws Exception {
        IPSDERBase iPSDERBase = (IPSDERBase)this.internalGetModelHelper(vt.getPSDERID());
        if (iPSDERBase != null) {
            return iPSDERBase;
        }
        this.setModel(vt.getPSDERID(), vt, null);
        return (IPSDERBase)this.findModelHelper(vt.getPSDERID());
    }

    @Override
    protected Vector<PSDER> getAllModels() throws Exception {
        Vector<PSDER> list2 = new Vector<PSDER>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSDERs(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDER> psDERList = new Vector<PSDER>();
        for (PSDER psDER : list2) {
            if (psDER.getParamIntValue("VALIDFLAG", 1) != 1) continue;
            psDERList.add(psDER);
        }
        return psDERList;
    }

    @Override
    protected String getObjectId(PSDER vt) {
        return vt.getPSDERID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSSystemException.create(this.getPSSystem(), 10004, objObjectId);
    }
}

