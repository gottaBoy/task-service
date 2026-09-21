/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.PSSysUserRoleImpl;
import SA.SRFDA.PS.Data.PSSysUserRole;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserRoleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUserRole, IPSSysUserRole> {
    private static final Log log = LogFactory.getLog(PSSysUserRoleGlobalModel.class);

    @Override
    protected PSSysUserRole GetObject(String strPSSysUserRoleId) {
        PSSysUserRole psSysUserRole = new PSSysUserRole();
        CallResult callResult = this.iPSModelHelper.getPSSysUserRole(strPSSysUserRoleId, psSysUserRole);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u6237\u89d2\u8272[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUserRoleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUserRole;
    }

    @Override
    protected IPSSysUserRole OnCreateModelHelper(PSSysUserRole vt) throws Exception {
        PSSysUserRoleImpl iPSSysUserRole = null;
        iPSSysUserRole = new PSSysUserRoleImpl();
        iPSSysUserRole.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUserRole;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUserRole obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUserRole registerModel(PSSysUserRole vt) throws Exception {
        IPSSysUserRole iIPSSysUserRole = (IPSSysUserRole)this.InternalGetModelHelper(vt.getPSSYSOPPRIVID());
        if (iIPSSysUserRole != null) {
            return iIPSSysUserRole;
        }
        this.setModel(vt.getPSSYSOPPRIVID(), vt, null);
        return (IPSSysUserRole)this.FindModelHelper(vt.getPSSYSOPPRIVID());
    }

    @Override
    protected Vector<PSSysUserRole> getAllModels() throws Exception {
        Vector<PSSysUserRole> list = new Vector<PSSysUserRole>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUserRoles(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u7528\u6237\u89d2\u8272\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUserRole vt) {
        return vt.getPSSYSOPPRIVID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysUserRole vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

