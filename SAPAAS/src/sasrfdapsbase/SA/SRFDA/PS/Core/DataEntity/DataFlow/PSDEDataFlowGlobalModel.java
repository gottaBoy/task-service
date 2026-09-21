/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataFlowGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDELogic, IPSDEDataFlow> {
    private static final Log log = LogFactory.getLog(PSDEDataFlowGlobalModel.class);

    @Override
    protected PSDELogic GetObject(String strPSDELogicId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDELogicId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataFlow OnCreateModelHelper(PSDELogic vt, String objObjectId) throws Exception {
        PSDEDataFlowImpl iPSDEDataFlow = new PSDEDataFlowImpl();
        this.setModel(objObjectId, vt, iPSDEDataFlow);
        iPSDEDataFlow.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataFlow;
    }

    @Override
    protected IPSDEDataFlow OnCreateModelHelper(PSDELogic vt) throws Exception {
        PSDEDataFlowImpl iPSDEDataFlow = new PSDEDataFlowImpl();
        iPSDEDataFlow.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataFlow;
    }

    @Override
    protected Boolean TestObjectRenew(PSDELogic obj) {
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
        CallResult callResult = this.iPSModelHelper.getPSDELogics(this.getPSDataEntity().getId(), psDELogicList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDELogic> psDELogicList = new Vector<PSDELogic>();
        for (PSDELogic psDELogic : psDELogicList2) {
            if (StringHelper.Compare((String)psDELogic.getLOGICTYPE(), (String)"DATAFLOWLOGIC", (boolean)true) != 0) continue;
            psDELogicList.add(psDELogic);
        }
        for (PSDELogic psDELogic : psDELogicList) {
            this.setModel(psDELogic.getPSDELOGICID(), psDELogic, null);
        }
        return psDELogicList;
    }

    @Override
    protected IPSDEDataFlow registerModel(PSDELogic vt) throws Exception {
        IPSDEDataFlow iPSDEDataFlow = (IPSDEDataFlow)this.InternalGetModelHelper(vt.getPSDELOGICID());
        if (iPSDEDataFlow != null) {
            return iPSDEDataFlow;
        }
        this.setModel(vt.getPSDELOGICID(), vt, null);
        return (IPSDEDataFlow)this.FindModelHelper(vt.getPSDELOGICID());
    }

    @Override
    protected String getObjectId(PSDELogic vt) {
        return vt.getPSDELOGICID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20021, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDELogic vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

