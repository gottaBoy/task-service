/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSWFDEImpl;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFDEGlobalModel
extends PSGlobalModelBase<String, PSWFDE, IPSWFDE> {
    private static final Log log = LogFactory.getLog(PSWFDEGlobalModel.class);
    protected IPSWorkflow iPSWorkflow = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSWFDE GetObject(String strPSWFDEId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u6d41\u7a0b\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFDE OnCreateModelHelper(PSWFDE vt) throws Exception {
        PSWFDEImpl iPSWFDE = new PSWFDEImpl();
        IPSDataEntity iPSDataEntity = this.getPSWorkflow().getPSSystem().getPSDataEntity2(vt.getPSDEID());
        iPSWFDE.init(this.iDAGlobalHelper, this.getPSWorkflow(), iPSDataEntity, vt);
        return iPSWFDE;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFDE obj) {
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
    protected Vector<PSWFDE> getAllModels() throws Exception {
        Vector<PSWFDE> psDEDataSetList = new Vector<PSWFDE>();
        CallResult callResult = this.iPSModelHelper.getPSWFDEsByWF(this.getPSWorkflow().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSWFDE registerModel(PSWFDE vt) throws Exception {
        IPSWFDE iPSDEWF = (IPSWFDE)this.InternalGetModelHelper(vt.getPSWFDEID());
        if (iPSDEWF != null) {
            return iPSDEWF;
        }
        this.setModel(vt.getPSWFDEID(), vt, null);
        return (IPSWFDE)this.FindModelHelper(vt.getPSWFDEID());
    }

    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWorkflow().getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSWFDE vt) {
        return vt.getPSWFDEID();
    }
}

