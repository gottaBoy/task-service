/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtilType;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUtil, IPSAppUtil> {
    private static final Log log = LogFactory.getLog(PSAppUtilGlobalModel.class);

    @Override
    protected PSAppUtil GetObject(String strPSAppUtilId) {
        return null;
    }

    @Override
    protected IPSAppUtil OnCreateModelHelper(PSAppUtil vt) throws Exception {
        IPSAppUtilType iPSAppUtilType = this.getPSModelStorage().getPSAppUtilType(vt.getUTILTYPE());
        IPSAppUtil iPSAppUtil = iPSAppUtilType.createPSAppUtil(vt);
        iPSAppUtil.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppUtil;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUtil obj) {
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
    protected Vector<PSAppUtil> getAllModels() throws Exception {
        Vector<PSAppUtil> psAppUtil = new Vector<PSAppUtil>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppUtils(this.getPSApplication().getId(), psAppUtil);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5e94\u7528\u7ec4\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psAppUtil;
    }

    @Override
    protected IPSAppUtil registerModel(PSAppUtil vt) throws Exception {
        IPSAppUtil iPSAppUtil = (IPSAppUtil)this.InternalGetModelHelper(vt.getPSAPPUTILID());
        if (iPSAppUtil != null) {
            return iPSAppUtil;
        }
        this.setModel(vt.getPSAPPUTILID(), vt, null);
        return (IPSAppUtil)this.FindModelHelper(vt.getPSAPPUTILID());
    }

    @Override
    protected String getObjectId(PSAppUtil vt) {
        return vt.getPSAPPUTILID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40020, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppUtil vt) {
        if (StringHelper.Compare((String)vt.getUTILTYPE(), (String)"USER", (boolean)true) != 0) {
            return new String[]{vt.getUTILTYPE().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

