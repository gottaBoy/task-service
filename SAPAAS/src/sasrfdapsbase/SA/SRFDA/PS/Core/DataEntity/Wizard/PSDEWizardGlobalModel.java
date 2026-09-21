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

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEWizardImpl;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWizardGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEWizard, IPSDEWizard> {
    private static final Log log = LogFactory.getLog(PSDEWizardGlobalModel.class);

    @Override
    protected PSDEWizard GetObject(String strPSDEWizardId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5411\u5bfc[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEWizardId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEWizard OnCreateModelHelper(PSDEWizard vt) throws Exception {
        PSDEWizardImpl iPSDEWizard = new PSDEWizardImpl();
        iPSDEWizard.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEWizard;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEWizard obj) {
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
    protected Vector<PSDEWizard> getAllModels() throws Exception {
        Vector<PSDEWizard> psDEWizard = new Vector<PSDEWizard>();
        CallResult callResult = this.iPSModelHelper.getPSDEWizards(this.getPSDataEntity().getId(), psDEWizard);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEWizard;
    }

    @Override
    protected IPSDEWizard registerModel(PSDEWizard vt) throws Exception {
        IPSDEWizard iPSDEWizard = (IPSDEWizard)this.InternalGetModelHelper(vt.getPSDEWIZARDID());
        if (iPSDEWizard != null) {
            return iPSDEWizard;
        }
        this.setModel(vt.getPSDEWIZARDID(), vt, null);
        return (IPSDEWizard)this.FindModelHelper(vt.getPSDEWIZARDID());
    }

    @Override
    protected String getObjectId(PSDEWizard vt) {
        return vt.getPSDEWIZARDID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20009, objObjectId);
    }
}

