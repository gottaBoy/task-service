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
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEDataSetDEAWImpl;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionWizardGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEActionWizard, IPSDEActionWizard> {
    private static final Log log = LogFactory.getLog(PSDEActionWizardGlobalModel.class);

    @Override
    protected PSDEActionWizard GetObject(String strPSDEActionWizardId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEActionWizardId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEActionWizard OnCreateModelHelper(PSDEActionWizard vt) throws Exception {
        PSDEActionWizardImpl iPSDEActionWizard = null;
        int nDynamicMode = vt.GetParamIntValue("DYNAMICMODE", 0);
        switch (nDynamicMode) {
            case 0: {
                iPSDEActionWizard = new PSDEActionWizardImpl();
                break;
            }
            case 1: {
                iPSDEActionWizard = new PSDEDataSetDEAWImpl();
                break;
            }
            default: {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7c7b\u578b[%1$s]", (Object)nDynamicMode));
            }
        }
        iPSDEActionWizard.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEActionWizard;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEActionWizard obj) {
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
    protected Vector<PSDEActionWizard> getAllModels() throws Exception {
        Vector<PSDEActionWizard> psDEActionWizard = new Vector<PSDEActionWizard>();
        CallResult callResult = this.iPSModelHelper.getPSDEActionWizards(this.getPSDataEntity().getId(), psDEActionWizard);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEActionWizard;
    }

    @Override
    protected IPSDEActionWizard registerModel(PSDEActionWizard vt) throws Exception {
        IPSDEActionWizard iPSDEActionWizard = (IPSDEActionWizard)this.InternalGetModelHelper(vt.getPSDEACTIONWIZARDID());
        if (iPSDEActionWizard != null) {
            return iPSDEActionWizard;
        }
        this.setModel(vt.getPSDEACTIONWIZARDID(), vt, null);
        return (IPSDEActionWizard)this.FindModelHelper(vt.getPSDEACTIONWIZARDID());
    }

    @Override
    protected String getObjectId(PSDEActionWizard vt) {
        return vt.getPSDEACTIONWIZARDID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20018, objObjectId);
    }
}

