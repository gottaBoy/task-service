/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEActionGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEActionGroup, IPSDEActionGroup> {
    private static final Log log = LogFactory.getLog(PSDEActionGroupGlobalModel.class);

    @Override
    protected PSDEActionGroup GetObject(String strPSDEActionGroupId) {
        return null;
    }

    @Override
    protected IPSDEActionGroup OnCreateModelHelper(PSDEActionGroup vt) throws Exception {
        PSDEActionGroupImpl iPSDEActionGroup = new PSDEActionGroupImpl();
        iPSDEActionGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEActionGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEActionGroup obj) {
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
    protected Vector<PSDEActionGroup> getAllModels() throws Exception {
        Vector<PSDEActionGroup> psDEActionGroupList2 = new Vector<PSDEActionGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEActionGroups(this.getPSDataEntity().getId(), psDEActionGroupList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEActionGroup> psDEActionGroupList = new Vector<PSDEActionGroup>();
        for (PSDEActionGroup psDEActionGroup : psDEActionGroupList2) {
            if (psDEActionGroup.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
            psDEActionGroupList.add(psDEActionGroup);
        }
        return psDEActionGroupList;
    }

    @Override
    protected IPSDEActionGroup registerModel(PSDEActionGroup vt) throws Exception {
        IPSDEActionGroup iPSDEActionGroup = (IPSDEActionGroup)this.InternalGetModelHelper(vt.getPSDEACTIONGROUPID());
        if (iPSDEActionGroup != null) {
            return iPSDEActionGroup;
        }
        this.setModel(vt.getPSDEACTIONGROUPID(), vt, null);
        return (IPSDEActionGroup)this.FindModelHelper(vt.getPSDEACTIONGROUPID());
    }

    @Override
    protected String getObjectId(PSDEActionGroup vt) {
        return vt.getPSDEACTIONGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20027, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEActionGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

