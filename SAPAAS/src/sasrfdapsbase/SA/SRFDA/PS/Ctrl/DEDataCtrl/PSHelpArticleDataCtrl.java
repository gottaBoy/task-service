/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticleDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSHelpArticleDataCtrl.class);
    public static final String CUSTOMCALL_INITMODEL = "INITMODEL";
    public static final String CUSTOMCALL_INITMODELALL = "INITMODELALL";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITMODEL, (boolean)true) == 0) {
            return this.initModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITMODELALL, (boolean)true) == 0) {
            return this.initModelAll(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSHelpArticle psHelpArticle = new PSHelpArticle();
            psHelpArticle.proxy(dataEntity);
            this.onInitModel(psHelpArticle);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5e2e\u52a9\u6587\u6863\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitModel(PSHelpArticle psHelpArticle) throws Exception {
        String strPSSystemId = psHelpArticle.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSSystem(null, strPSSystemId, IPSSystem.LOADLEVEL_CODE);
        IPSHelpArticleType iPSHelpArticleType = this.getPSModelStorage().getPSHelpArticleType(psHelpArticle.getARTICLETYPE());
        iPSHelpArticleType.initModel(iPSSystem, psHelpArticle);
    }

    public CallResult initModelAll(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSHelpArticle psHelpArticle = new PSHelpArticle();
            psHelpArticle.proxy(dataEntity);
            this.onInitModelAll(psHelpArticle);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5e2e\u52a9\u6587\u6863\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitModelAll(PSHelpArticle psHelpArticle) throws Exception {
        String strPSSystemId = psHelpArticle.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSSystem(null, strPSSystemId, IPSSystem.LOADLEVEL_CODE);
        PSHelpArticle psHelpArticleCond = new PSHelpArticle();
        psHelpArticleCond.setPSSYSTEMID(strPSSystemId);
        Vector psHelpArticleList = new Vector();
        CallResult callResult = this.Select(psHelpArticleCond, psHelpArticleList, PSHelpArticle.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u6587\u6863\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSHelpArticle psHelpArticle3 : psHelpArticleList) {
            try {
                IPSHelpArticleType iPSHelpArticleType = this.getPSModelStorage().getPSHelpArticleType(psHelpArticle3.getARTICLETYPE());
                iPSHelpArticleType.initModel(iPSSystem, psHelpArticle3);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
    }
}

