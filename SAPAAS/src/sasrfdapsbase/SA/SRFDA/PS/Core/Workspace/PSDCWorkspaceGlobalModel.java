/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.PSDCWorkspaceImpl;
import SA.SRFDA.PS.Data.PSDCWorkspace;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCWorkspaceGlobalModel
extends PSGlobalModelBase<String, PSDCWorkspace, IPSDCWorkspace> {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceGlobalModel.class);

    @Override
    protected PSDCWorkspace GetObject(String strPSDCWorkspaceId) {
        PSDCWorkspace PSDCWorkspace2 = new PSDCWorkspace();
        CallResult callResult = this.iPSModelHelper.getPSDCWorkspace(strPSDCWorkspaceId, PSDCWorkspace2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCWorkspaceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDCWorkspace2;
    }

    @Override
    protected IPSDCWorkspace OnCreateModelHelper(PSDCWorkspace psDCWorkspace) throws Exception {
        try {
            return this.internalCreateModelHelper(psDCWorkspace);
        }
        catch (Exception ex) {
            this.ResetModel(psDCWorkspace.getPSDCWORKSPACEID());
            throw ex;
        }
    }

    protected IPSDCWorkspace internalCreateModelHelper(PSDCWorkspace psDCWorkspace) throws Exception {
        ICodeList iCodeList = DevCenterResStateCodeListModel.getInstance();
        int nResState = psDCWorkspace.getRESSTATE();
        if (nResState != 20) {
            String strInfo = StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5f53\u524d\u72b6\u6001[%1$s]\uff0c\u65e0\u6cd5\u4f7f\u7528", (Object)iCodeList.getCodeListText(Integer.toString(nResState), true));
            throw new Exception(strInfo);
        }
        if (psDCWorkspace.getEXPIREDTIME() != null) {
            Timestamp expiredTime = new Timestamp(psDCWorkspace.getEXPIREDTIME().getTime());
            long nCurTime = System.currentTimeMillis();
            if (expiredTime.getTime() < nCurTime) {
                String strInfo = StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5df2\u8fc7\u671f");
                throw new Exception(strInfo);
            }
        }
        try {
            PSDCWorkspaceImpl psDCWorkspaceImpl = new PSDCWorkspaceImpl();
            psDCWorkspaceImpl.init(this.getDAGlobalHelper(), psDCWorkspace);
            return psDCWorkspaceImpl;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            String strInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            throw new Exception(strInfo, ex);
        }
    }

    @Override
    protected Boolean TestObjectRenew(PSDCWorkspace obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDCWorkspace vt) {
        return vt.getPSDCWORKSPACEID();
    }
}

