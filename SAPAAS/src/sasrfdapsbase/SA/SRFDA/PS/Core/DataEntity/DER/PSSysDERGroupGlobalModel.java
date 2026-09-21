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

import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.PSSysDERGroupImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDERGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDERGroupGlobalModel
extends PSSystemGlobalModelBase<String, PSDERGroup, IPSSysDERGroup> {
    private static final Log log = LogFactory.getLog(PSSysDERGroupGlobalModel.class);

    @Override
    protected PSDERGroup GetObject(String strPSDERGroupId) {
        return null;
    }

    @Override
    protected IPSSysDERGroup OnCreateModelHelper(PSDERGroup vt) throws Exception {
        PSSysDERGroupImpl iPSDERGroup = new PSSysDERGroupImpl();
        iPSDERGroup.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSDERGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDERGroup obj) {
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
    protected Vector<PSDERGroup> getAllModels() throws Exception {
        Vector<PSDERGroup> psDERGroupList = new Vector<PSDERGroup>();
        CallResult callResult = this.iPSModelHelper.getPSSysDERGroups(this.getPSSystem().getId(), psDERGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDERGroupList;
    }

    @Override
    protected IPSSysDERGroup registerModel(PSDERGroup vt) throws Exception {
        IPSSysDERGroup iPSDERGroup = (IPSSysDERGroup)this.InternalGetModelHelper(vt.getPSDERGROUPID());
        if (iPSDERGroup != null) {
            return iPSDERGroup;
        }
        this.setModel(vt.getPSDERGROUPID(), vt, null);
        return (IPSSysDERGroup)this.FindModelHelper(vt.getPSDERGROUPID());
    }

    @Override
    protected String getObjectId(PSDERGroup vt) {
        return vt.getPSDERGROUPID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDERGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

