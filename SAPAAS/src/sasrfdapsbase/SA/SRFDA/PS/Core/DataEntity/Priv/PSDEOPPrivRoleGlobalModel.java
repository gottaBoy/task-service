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

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEOPPrivRoleImpl;
import SA.SRFDA.PS.Data.PSDEOPPrivRole;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivRoleGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEOPPrivRole, IPSDEOPPrivRole> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleGlobalModel.class);

    @Override
    protected PSDEOPPrivRole GetObject(String strPSDEOPPrivRoleId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u89d2\u8272[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEOPPrivRoleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEOPPrivRole OnCreateModelHelper(PSDEOPPrivRole vt) throws Exception {
        PSDEOPPrivRoleImpl iPSDEOPPrivRole = new PSDEOPPrivRoleImpl();
        iPSDEOPPrivRole.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEOPPrivRole;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEOPPrivRole obj) {
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
    protected Vector<PSDEOPPrivRole> getAllModels() throws Exception {
        Vector<PSDEOPPrivRole> psDEOPPrivRole = new Vector<PSDEOPPrivRole>();
        CallResult callResult = this.iPSModelHelper.getPSDEOPPrivRoles(this.getPSDataEntity().getId(), psDEOPPrivRole);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEOPPrivRole;
    }

    @Override
    protected IPSDEOPPrivRole registerModel(PSDEOPPrivRole vt) throws Exception {
        IPSDEOPPrivRole iPSDEOPPrivRole = (IPSDEOPPrivRole)this.InternalGetModelHelper(vt.getPSDEOPPRIVROLEID());
        if (iPSDEOPPrivRole != null) {
            return iPSDEOPPrivRole;
        }
        this.setModel(vt.getPSDEOPPRIVROLEID(), vt, null);
        return (IPSDEOPPrivRole)this.FindModelHelper(vt.getPSDEOPPRIVROLEID());
    }

    @Override
    protected String getObjectId(PSDEOPPrivRole vt) {
        return vt.getPSDEOPPRIVROLEID();
    }
}

