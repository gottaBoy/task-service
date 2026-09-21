/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.CodeListMgr
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Report.Web.IReportContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.DataEx.BaseDataEntity;

public class DefaultReportContext
implements IReportContext {
    protected ISRFDAGlobalHelper globalHelper = null;
    protected ISRFDAWebContext webContext = null;
    protected BaseDataEntity dataEntity = null;

    public void setGlobalHelper(ISRFDAGlobalHelper globalHelper) {
        this.globalHelper = globalHelper;
    }

    public void setWebContext(ISRFDAWebContext webContext) {
        this.webContext = webContext;
    }

    public void setDataEntity(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    @Override
    public Object GV(String strParamName) {
        if (this.webContext != null) {
            return this.webContext.GetGlobalValue(strParamName);
        }
        return null;
    }

    @Override
    public Object SV(String strParamName) {
        if (this.webContext != null) {
            return this.webContext.GetSessionValue(strParamName);
        }
        return null;
    }

    @Override
    public Object UV(String strParamName) {
        if (this.webContext != null) {
            return this.webContext.GetParamValue(strParamName);
        }
        return null;
    }

    @Override
    public Object V(String strParamName) {
        if (this.dataEntity != null) {
            return this.dataEntity.GetParamValue(strParamName);
        }
        return null;
    }

    @Override
    public String getCurUserId() {
        if (this.webContext != null) {
            return this.webContext.getCurUserId();
        }
        return null;
    }

    @Override
    public String getCurUserName() {
        if (this.webContext != null) {
            return this.webContext.getCurUserName();
        }
        return null;
    }

    @Override
    public String CLText(String strCodeListId, String strValue) {
        CodeListMgr codeListMgr = this.getCodeListMgr();
        CodeListConfig codeListConfig = null;
        codeListConfig = this.webContext != null ? codeListMgr.GetCodeListConfig(strCodeListId, this.webContext.getLocalization()) : codeListMgr.GetCodeListConfig(strCodeListId);
        if (codeListConfig == null) {
            return "\u65e0\u6548\u4ee3\u7801\u8868";
        }
        return codeListConfig.GetCodeListValue(strValue, true);
    }

    protected CodeListMgr getCodeListMgr() {
        if (this.webContext != null) {
            return this.webContext.getCodeListMgr();
        }
        return null;
    }

    @Override
    public String getCodeListText(String strCodeListId, String strValue) {
        CodeListMgr codeListMgr = this.getCodeListMgr();
        CodeListConfig codeListConfig = null;
        codeListConfig = this.webContext != null ? codeListMgr.GetCodeListConfig(strCodeListId, this.webContext.getLocalization()) : codeListMgr.GetCodeListConfig(strCodeListId);
        if (codeListConfig == null) {
            return "\u65e0\u6548\u4ee3\u7801\u8868";
        }
        return codeListConfig.GetCodeListValue(strValue, true);
    }
}

