/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEUserRoleImpl;
import SA.SRFDA.PS.Data.PSDEUserRole;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUserRoleGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEUserRole, IPSDEUserRole> {
    private static final Log log = LogFactory.getLog(PSDEUserRoleGlobalModel.class);

    @Override
    protected PSDEUserRole GetObject(String strPSDEUserRoleId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u7528\u6237\u89d2\u8272[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUserRoleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEUserRole OnCreateModelHelper(PSDEUserRole vt) throws Exception {
        PSDEUserRoleImpl iPSDEUserRole = new PSDEUserRoleImpl();
        iPSDEUserRole.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEUserRole;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUserRole obj) {
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
    protected Vector<PSDEUserRole> getAllModels() throws Exception {
        Vector<PSDEUserRole> psDEUserRole = new Vector<PSDEUserRole>();
        CallResult callResult = this.iPSModelHelper.getPSDEUserRoles(this.getPSDataEntity().getId(), psDEUserRole);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u7528\u6237\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEUserRole;
    }

    @Override
    protected IPSDEUserRole registerModel(PSDEUserRole vt) throws Exception {
        IPSDEUserRole iPSDEUserRole = (IPSDEUserRole)this.InternalGetModelHelper(vt.getPSDEUSERROLEID());
        if (iPSDEUserRole != null) {
            return iPSDEUserRole;
        }
        this.setModel(vt.getPSDEUSERROLEID(), vt, null);
        return (IPSDEUserRole)this.FindModelHelper(vt.getPSDEUSERROLEID());
    }

    @Override
    protected String getObjectId(PSDEUserRole vt) {
        return vt.getPSDEUSERROLEID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20028, objObjectId);
    }
}

