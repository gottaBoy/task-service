/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.PSSubViewTypeImpl;
import SA.SRFDA.PS.Data.PSSubViewType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubViewTypeGlobalModel
extends PSSystemGlobalModelBase<String, PSSubViewType, IPSSubViewType> {
    private static final Log log = LogFactory.getLog(PSSubViewTypeGlobalModel.class);
    public static final String DEFAULTVIEWTYPE_PREFIX = "VIEWTYPE:";

    @Override
    protected PSSubViewType GetObject(String strPSSubViewTypeId) {
        PSSubViewType psSubViewType = new PSSubViewType();
        CallResult callResult = this.iPSModelHelper.getPSSubViewType(strPSSubViewTypeId, psSubViewType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u89c6\u56fe\u5b50\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubViewTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubViewType;
    }

    @Override
    protected IPSSubViewType OnCreateModelHelper(PSSubViewType vt) throws Exception {
        PSSubViewTypeImpl iPSSubViewType = null;
        iPSSubViewType = new PSSubViewTypeImpl();
        iPSSubViewType.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSubViewType;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubViewType obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSubViewType registerModel(PSSubViewType vt) throws Exception {
        IPSSubViewType iIPSSubViewType = (IPSSubViewType)this.InternalGetModelHelper(vt.getPSSUBVIEWTYPEID());
        if (iIPSSubViewType != null) {
            return iIPSSubViewType;
        }
        this.setModel(vt.getPSSUBVIEWTYPEID(), vt, null);
        return (IPSSubViewType)this.FindModelHelper(vt.getPSSUBVIEWTYPEID());
    }

    @Override
    protected Vector<PSSubViewType> getAllModels() throws Exception {
        Vector<PSSubViewType> list = new Vector<PSSubViewType>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubViewTypes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u89c6\u56fe\u5b50\u7c7b\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSubViewType vt) {
        return vt.getPSSUBVIEWTYPEID();
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

    protected String[] getObjectAliases(PSSubViewType vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

