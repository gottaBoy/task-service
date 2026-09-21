/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.PSDEGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEGroup, IPSDEGroup> {
    private static final Log log = LogFactory.getLog(PSDEGroupGlobalModel.class);

    @Override
    protected PSDEGroup GetObject(String strPSDEGroupId) {
        return null;
    }

    @Override
    protected IPSDEGroup OnCreateModelHelper(PSDEGroup vt) throws Exception {
        PSDEGroupImpl iPSDEGroup = new PSDEGroupImpl();
        iPSDEGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEGroup obj) {
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
    protected Vector<PSDEGroup> getAllModels() throws Exception {
        Vector<PSDEGroup> psDEGroupList = new Vector<PSDEGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEGroups(this.getPSDataEntity().getId(), psDEGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEGroupList;
    }

    @Override
    protected IPSDEGroup registerModel(PSDEGroup vt) throws Exception {
        IPSDEGroup iPSDEGroup = (IPSDEGroup)this.InternalGetModelHelper(vt.getPSDEGROUPID());
        if (iPSDEGroup != null) {
            return iPSDEGroup;
        }
        this.setModel(vt.getPSDEGROUPID(), vt, null);
        return (IPSDEGroup)this.FindModelHelper(vt.getPSDEGROUPID());
    }

    @Override
    protected String getObjectId(PSDEGroup vt) {
        return vt.getPSDEGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20025, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

