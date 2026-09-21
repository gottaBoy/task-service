/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Util;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.DataEntity.Util.PSDEUtilImpl;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUtilGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEUtil, IPSDEUtil> {
    private static final Log log = LogFactory.getLog(PSDEUtilGlobalModel.class);

    @Override
    protected PSDEUtil GetObject(String strPSDEUtilId) {
        return null;
    }

    @Override
    protected IPSDEUtil OnCreateModelHelper(PSDEUtil vt) throws Exception {
        PSDEUtilImpl iPSDEUtil = new PSDEUtilImpl();
        iPSDEUtil.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEUtil;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUtil obj) {
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
    protected Vector<PSDEUtil> getAllModels() throws Exception {
        Vector<PSDEUtil> psDEUtil = new Vector<PSDEUtil>();
        CallResult callResult = this.iPSModelHelper.getPSDEUtils(this.getPSDataEntity().getId(), psDEUtil);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u8f85\u52a9\u529f\u80fd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUtil;
    }

    @Override
    protected IPSDEUtil registerModel(PSDEUtil vt) throws Exception {
        IPSDEUtil iPSDEUtil = (IPSDEUtil)this.InternalGetModelHelper(vt.getPSDEUTILDEID());
        if (iPSDEUtil != null) {
            return iPSDEUtil;
        }
        this.setModel(vt.getPSDEUTILDEID(), vt, null);
        if (StringHelper.Compare((String)vt.getUTILTYPE(), (String)"USER", (boolean)true) != 0) {
            this.setModel(vt.getUTILTYPE(), vt, null);
        }
        return (IPSDEUtil)this.FindModelHelper(vt.getPSDEUTILDEID());
    }

    @Override
    protected String getObjectId(PSDEUtil vt) {
        return vt.getPSDEUTILDEID();
    }
}

