/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardGroupImpl;
import SA.SRFDA.PS.Data.PSDEAWGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionWizardGroupGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEAWGroup, IPSDEActionWizardGroup> {
    private static final Log log = LogFactory.getLog(PSDEActionWizardGroupGlobalModel.class);

    @Override
    protected PSDEAWGroup GetObject(String strPSDEAWGroupId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEAWGroupId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEActionWizardGroup OnCreateModelHelper(PSDEAWGroup vt) throws Exception {
        PSDEActionWizardGroupImpl iPSDEAWGroup = new PSDEActionWizardGroupImpl();
        iPSDEAWGroup.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEAWGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEAWGroup obj) {
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
    protected Vector<PSDEAWGroup> getAllModels() throws Exception {
        Vector<PSDEAWGroup> psDEActionWizardGroup = new Vector<PSDEAWGroup>();
        CallResult callResult = this.iPSModelHelper.getPSDEActionWizardGroups(this.getPSDataEntity().getId(), psDEActionWizardGroup);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEActionWizardGroup;
    }

    @Override
    protected IPSDEActionWizardGroup registerModel(PSDEAWGroup vt) throws Exception {
        IPSDEActionWizardGroup iPSDEActionWizardGroup = (IPSDEActionWizardGroup)this.InternalGetModelHelper(vt.getPSDEAWGROUPID());
        if (iPSDEActionWizardGroup != null) {
            return iPSDEActionWizardGroup;
        }
        this.setModel(vt.getPSDEAWGROUPID(), vt, null);
        return (IPSDEActionWizardGroup)this.FindModelHelper(vt.getPSDEAWGROUPID());
    }

    @Override
    protected String getObjectId(PSDEAWGroup vt) {
        return vt.getPSDEAWGROUPID();
    }
}

