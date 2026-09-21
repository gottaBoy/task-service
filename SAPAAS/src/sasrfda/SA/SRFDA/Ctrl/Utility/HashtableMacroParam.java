/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class HashtableMacroParam
implements TemplateMethodModel {
    protected BaseDataEntity dataEntity = null;
    protected IDEHelper iDEHelper = null;
    protected String strLanguage = "";

    public void setDataEntity(BaseDataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public String getLanguage() {
        return this.strLanguage;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    public void setLanguage(String strLanguage) {
        this.strLanguage = strLanguage;
    }

    public Object exec(List arg0) throws TemplateModelException {
        Object objValue;
        IDEFHelper iDEFHelper;
        if (this.dataEntity == null) {
            throw new TemplateModelException("\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
        }
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
        }
        String strParam = arg0.get(0).toString();
        String strFormat = "";
        CodeListConfig codeListConfig = null;
        if (this.iDEHelper != null && (iDEFHelper = this.iDEHelper.GetDEFHelper(strParam)) != null) {
            strFormat = iDEFHelper.GetFormCtrl().GetItemFormat();
            String strCodeListId = iDEFHelper.GetCodeList();
            if (!StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                codeListConfig = this.iDEHelper.getGlobalHelper().getCodeListMgr().GetCodeListConfig(strCodeListId, this.strLanguage);
            }
        }
        if (arg0.size() >= 2) {
            strFormat = arg0.get(1).toString();
        }
        if ((objValue = this.dataEntity.GetParamValue(strParam)) == null) {
            if (arg0.size() >= 3) {
                return arg0.get(2);
            }
            if (codeListConfig != null) {
                return codeListConfig.GetCodeListValue("", true);
            }
            return "";
        }
        if (codeListConfig != null) {
            objValue = codeListConfig.GetCodeListValue(objValue.toString(), true);
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormat)) {
            return StringHelper.Format((String)strFormat, (Object)objValue);
        }
        return objValue;
    }
}

