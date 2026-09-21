/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemError;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.util.Vector;

public class SRFExFormItemErrors {
    protected Vector formItemErrors = null;
    protected int nRetCode = 0;
    protected String strErrorInfo = "";

    public void Register(String strFormItemId, String strFormErrorId, int nErrorType, String strErrorInfo) {
        if (this.formItemErrors == null) {
            this.formItemErrors = new Vector();
        }
        SRFExFormItemError formItemError = this.FindFormItemError(strFormItemId, true);
        formItemError.setFormErrorId(strFormErrorId);
        formItemError.setErrorType(nErrorType);
        formItemError.setErrorInfo(strErrorInfo);
        this.formItemErrors.add(formItemError);
    }

    public void Register(SRFExControl childControl, int nErrorType, String strErrorInfo) {
        if (childControl == null) {
            return;
        }
        if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)((Object)childControl);
            if (formItem.getFormItemConfig() == null) {
                return;
            }
            FormItemConfig formItemConfig = formItem.getFormItemConfig();
            String strError = StringHelper.Format((String)childControl.getPage().GetLocalization("ERROR.STD.FORM.INVALIDVALUE2", "\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u539f\u56e0\u4e3a:%2$s"), (Object)formItemConfig.getName(), (Object)strErrorInfo);
            this.Register(childControl.getUniqueID(), formItemConfig.getErrorRegionId(), nErrorType, strError);
        }
    }

    public SRFExFormItemError FindFormItemError(String strFormItemId) {
        return this.FindFormItemError(strFormItemId, false);
    }

    protected SRFExFormItemError FindFormItemError(String strFormItemId, boolean bNew) {
        if (this.formItemErrors != null) {
            int nCount = this.formItemErrors.size();
            int i = 0;
            while (i < nCount) {
                SRFExFormItemError formItemError = (SRFExFormItemError)this.formItemErrors.get(i);
                if (StringHelper.Compare((String)strFormItemId, (String)formItemError.getFormItemId(), (boolean)true) == 0) {
                    return formItemError;
                }
                ++i;
            }
        }
        if (!bNew) {
            return null;
        }
        SRFExFormItemError formItemError = new SRFExFormItemError();
        formItemError.setFormItemId(strFormItemId);
        return formItemError;
    }

    public void Unregister(String strFormItemId) {
        if (this.formItemErrors == null) {
            return;
        }
        int nCount = this.formItemErrors.size();
        int i = 0;
        while (i < nCount) {
            SRFExFormItemError formItemError = (SRFExFormItemError)this.formItemErrors.get(i);
            if (StringHelper.Compare((String)strFormItemId, (String)formItemError.getFormItemId(), (boolean)true) == 0) {
                this.formItemErrors.remove(i);
                return;
            }
            ++i;
        }
    }

    public void Reset() {
        if (this.formItemErrors == null) {
            return;
        }
        this.formItemErrors.clear();
    }

    public void FillJSONs(Vector items) {
        if (this.formItemErrors == null) {
            return;
        }
        int nCount = this.formItemErrors.size();
        int i = 0;
        while (i < nCount) {
            SRFExFormItemError formItemError = (SRFExFormItemError)this.formItemErrors.get(i);
            formItemError.FillJSONs(items);
            ++i;
        }
    }

    public int getRetCode() {
        return this.nRetCode;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setRetCode(int nRetCode) {
        this.nRetCode = nRetCode;
    }

    public void setErrorInfo(String strErrorInfo) {
        this.strErrorInfo = strErrorInfo;
    }

    public String GetTotalError() {
        if (this.formItemErrors == null) {
            return "";
        }
        String strMessage = "";
        int nCount = this.formItemErrors.size();
        int i = 0;
        while (i < nCount) {
            SRFExFormItemError formItemError = (SRFExFormItemError)this.formItemErrors.get(i);
            if (!StringHelper.IsNullOrEmpty((String)strMessage)) {
                strMessage = String.valueOf(strMessage) + "\r\n";
            }
            strMessage = String.valueOf(strMessage) + formItemError.getErrorInfo();
            ++i;
        }
        return strMessage;
    }
}

