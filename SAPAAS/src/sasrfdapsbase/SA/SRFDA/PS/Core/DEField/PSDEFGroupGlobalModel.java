/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.PSDEFGroupImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEFGroup, IPSDEFGroup> {
    private static final Log log = LogFactory.getLog(PSDEFGroupGlobalModel.class);

    @Override
    protected PSDEFGroup GetObject(String strPSDEFGroupId) {
        return null;
    }

    @Override
    protected IPSDEFGroup OnCreateModelHelper(PSDEFGroup vt) throws Exception {
        PSDEFGroupImpl iPSDEFGroup = new PSDEFGroupImpl();
        iPSDEFGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEFGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFGroup obj) {
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
    protected Vector<PSDEFGroup> getAllModels() throws Exception {
        Vector<PSDEFGroup> psDEFGroupList2 = new Vector<PSDEFGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEFGroups(this.getPSDataEntity().getId(), psDEFGroupList2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEFGroup> psDEFGroupList = new Vector<PSDEFGroup>();
        for (PSDEFGroup psDEFGroup : psDEFGroupList2) {
            if (psDEFGroup.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
            psDEFGroupList.add(psDEFGroup);
        }
        return psDEFGroupList;
    }

    @Override
    protected IPSDEFGroup registerModel(PSDEFGroup vt) throws Exception {
        IPSDEFGroup iPSDEFGroup = (IPSDEFGroup)this.InternalGetModelHelper(vt.getPSDEFGROUPID());
        if (iPSDEFGroup != null) {
            return iPSDEFGroup;
        }
        this.setModel(vt.getPSDEFGROUPID(), vt, null);
        return (IPSDEFGroup)this.FindModelHelper(vt.getPSDEFGROUPID());
    }

    @Override
    protected String getObjectId(PSDEFGroup vt) {
        return vt.getPSDEFGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20024, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEFGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

