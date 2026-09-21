/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERType;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSSystemException;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERGlobalModel
extends PSSystemGlobalModelBase<String, PSDER, IPSDERBase> {
    private static final Log log = LogFactory.getLog(PSDERGlobalModel.class);

    @Override
    protected PSDER GetObject(String strPSDERId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSDER psDER = new PSDER();
        CallResult callResult = this.iPSModelHelper.getPSDER(strPSDERId, psDER);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDERId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSSystem().getId(), (String)psDER.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        if (psDER.GetParamIntValue("VALIDFLAG", 1) == 0) {
            return null;
        }
        return psDER;
    }

    @Override
    protected IPSDERBase OnCreateModelHelper(PSDER vt) throws Exception {
        IPSDERType iPSDERType = this.iPSModelStorage.getPSDERType(vt.getDERTYPE());
        IPSDERBase iPSDER = iPSDERType.createPSDER(vt);
        IPSDataEntity majorPSDataEntity = this.getPSSystem().getPSDataEntity2(vt.getMAJORPSDEID());
        IPSDataEntity minorPSDataEntity = this.getPSSystem().getPSDataEntity2(vt.getMINORPSDEID());
        iPSDER.init(this.iDAGlobalHelper, majorPSDataEntity, minorPSDataEntity, vt);
        return iPSDER;
    }

    @Override
    protected Boolean TestObjectRenew(PSDER obj) {
        return false;
    }

    @Override
    protected IPSDERBase registerModel(PSDER vt) throws Exception {
        IPSDERBase iPSDERBase = (IPSDERBase)this.InternalGetModelHelper(vt.getPSDERID());
        if (iPSDERBase != null) {
            return iPSDERBase;
        }
        this.setModel(vt.getPSDERID(), vt, null);
        return (IPSDERBase)this.FindModelHelper(vt.getPSDERID());
    }

    @Override
    protected Vector<PSDER> getAllModels() throws Exception {
        Vector<PSDER> list2 = new Vector<PSDER>();
        CallResult callResult = this.iPSModelHelper.getAllPSDERs(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDER> psDERList = new Vector<PSDER>();
        for (PSDER psDER : list2) {
            if (psDER.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
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
}

