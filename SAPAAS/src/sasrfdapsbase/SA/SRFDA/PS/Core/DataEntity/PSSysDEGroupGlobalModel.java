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

import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.DataEntity.PSSysDEGroupImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEGroupGlobalModel
extends PSSystemGlobalModelBase<String, PSDEGroup, IPSSysDEGroup> {
    private static final Log log = LogFactory.getLog(PSSysDEGroupGlobalModel.class);

    @Override
    protected PSDEGroup GetObject(String strPSDEGroupId) {
        return null;
    }

    @Override
    protected IPSSysDEGroup OnCreateModelHelper(PSDEGroup vt) throws Exception {
        PSSysDEGroupImpl iPSDEGroup = new PSSysDEGroupImpl();
        iPSDEGroup.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
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
        CallResult callResult = this.iPSModelHelper.getPSSysDEGroups(this.getPSSystem().getId(), psDEGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEGroupList;
    }

    @Override
    protected IPSSysDEGroup registerModel(PSDEGroup vt) throws Exception {
        IPSSysDEGroup iPSSysDEGroup = (IPSSysDEGroup)this.InternalGetModelHelper(vt.getPSDEGROUPID());
        if (iPSSysDEGroup != null) {
            return iPSSysDEGroup;
        }
        this.setModel(vt.getPSDEGROUPID(), vt, null);
        return (IPSSysDEGroup)this.FindModelHelper(vt.getPSDEGROUPID());
    }

    @Override
    protected String getObjectId(PSDEGroup vt) {
        return vt.getPSDEGROUPID();
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

