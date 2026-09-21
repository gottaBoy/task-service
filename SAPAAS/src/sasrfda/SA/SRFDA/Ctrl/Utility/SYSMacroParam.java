/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class SYSMacroParam
implements TemplateMethodModel {
    protected BaseDataEntity dataEntity = null;
    protected ISRFDAWebContext webContext;
    protected ISRFDAGlobalHelper globalHelperEx;
    protected String strCurPersonId;

    public SYSMacroParam(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity dataEntity) {
        this.webContext = webContext;
        this.globalHelperEx = globalHelperEx;
        this.strCurPersonId = strCurPersonId;
        this.dataEntity = dataEntity;
    }

    public void setDataEntity(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (this.dataEntity == null) {
            throw new TemplateModelException("\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
        }
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
        }
        String strParam = arg0.get(0).toString();
        CallResult callResult = MacroHelper.GetValue(strParam, this.webContext, this.globalHelperEx, strParam, this.dataEntity);
        if (callResult.IsOk()) {
            return callResult.getUserObject();
        }
        throw new TemplateModelException(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]", (Object)strParam));
    }
}

