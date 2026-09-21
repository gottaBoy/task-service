/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionGroupImpl;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEUIActionGroup, IPSDEUIActionGroup> {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupGlobalModel.class);

    @Override
    protected PSDEUIActionGroup GetObject(String strPSDEUIActionGroupId) {
        return null;
    }

    @Override
    protected IPSDEUIActionGroup OnCreateModelHelper(PSDEUIActionGroup vt) throws Exception {
        PSDEUIActionGroupImpl iPSDEUIActionGroup = new PSDEUIActionGroupImpl();
        iPSDEUIActionGroup.init(this.iDAGlobalHelper, this.getPSDataEntity().getPSSystem(), this.getPSDataEntity(), vt);
        return iPSDEUIActionGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIActionGroup obj) {
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
    protected Vector<PSDEUIActionGroup> getAllModels() throws Exception {
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEUIActionGroups(this.getPSDataEntity().getId(), psDEUIActionGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUIActionGroupList;
    }

    @Override
    protected IPSDEUIActionGroup registerModel(PSDEUIActionGroup vt) throws Exception {
        IPSDEUIActionGroup iPSDEUIActionGroup = (IPSDEUIActionGroup)this.InternalGetModelHelper(vt.getPSDEUAGROUPID());
        if (iPSDEUIActionGroup != null) {
            return iPSDEUIActionGroup;
        }
        this.setModel(vt.getPSDEUAGROUPID(), vt, null);
        return (IPSDEUIActionGroup)this.FindModelHelper(vt.getPSDEUAGROUPID());
    }

    @Override
    protected String getObjectId(PSDEUIActionGroup vt) {
        return vt.getPSDEUAGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20002, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEUIActionGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

