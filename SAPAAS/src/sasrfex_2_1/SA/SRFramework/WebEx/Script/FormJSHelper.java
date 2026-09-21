/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;

public class FormJSHelper {
    public static String getLoadDefaultScript(SRFExForm form) {
        String strOutput = "";
        if (form.getLoadAction() != null && form.getLoadAction().getLoadDefault()) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s();", (Object)form.getFormId(), (Object)form.getLoadAction().getLoadDefaultActionName());
        }
        return strOutput;
    }

    public static String getLoadScript(SRFExForm form) {
        String strOutput = "";
        if (form.getLoadAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s();", (Object)form.getFormId(), (Object)form.getLoadAction().getActionName());
        }
        return strOutput;
    }

    public static String getLoadCopyModeScript(SRFExForm form) {
        String strOutput = "";
        if (form.getLoadAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$scm();", (Object)form.getFormId(), (Object)form.getLoadAction().getActionName());
        }
        return strOutput;
    }

    public static String getLoad2Script(SRFExForm form, String strParams) {
        String strOutput = "";
        if (form.getLoadAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.load2(%2$s);", (Object)form.getFormId(), (Object)strParams);
        }
        return strOutput;
    }

    public static String getSaveScript(SRFExForm form) {
        return FormJSHelper.getSaveScript(form, false);
    }

    public static String getSaveScript(SRFExForm form, boolean bSaveAndNew) {
        String strOutput = "";
        if (form.getSaveAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s('%3$s');", (Object)form.getFormId(), (Object)form.getSaveAction().getActionName(), (Object)bSaveAndNew);
        }
        return strOutput;
    }

    public static String getRemoveScript(SRFExForm form) {
        String strOutput = "";
        if (form.getRemoveAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s();", (Object)form.getFormId(), (Object)form.getRemoveAction().getActionName());
        }
        return strOutput;
    }

    public static String getResetScript(SRFExForm form) {
        String strOutput = "";
        if (form.getResetAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s();", (Object)form.getFormId(), (Object)form.getResetAction().getActionName());
        }
        return strOutput;
    }

    public static String getCustomActionScript(SRFExForm form, String strAction, String strActionParam) {
        String strOutput = "";
        if (form.getRemoveAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s(%3$s);", (Object)form.getFormId(), (Object)strAction, (Object)strActionParam);
        }
        return strOutput;
    }

    public static String getGetFormItemValueScript(SRFExForm form, String strFormItemId) {
        String strOutput = "";
        SRFExControl control = form.FindControl(strFormItemId);
        if (control != null && control instanceof ISRFExFormItem) {
            strOutput = StringHelper.Format((String)"%1$s.G('%2$s')", (Object)form.getFormId(), (Object)control.getUniqueID());
        }
        return strOutput;
    }

    public static String getSetFormItemValueScript(SRFExForm form, String strFormItemId, String strValue) {
        String strOutput = "";
        SRFExControl control = form.FindControl(strFormItemId);
        if (control != null && control instanceof ISRFExFormItem) {
            strOutput = StringHelper.Format((String)"%1$s.S('%2$s',%3$s)", (Object)form.getFormId(), (Object)control.getUniqueID(), (Object)strValue);
        }
        return strOutput;
    }

    public static String getFormGetKeysScript(SRFExForm form) {
        String strOutput = "";
        if (form.getGetKeysAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s()", (Object)form.getFormId(), (Object)form.getGetKeysAction().getActionName());
        }
        return strOutput;
    }

    public static String getFormGetMainDataScript(SRFExForm form) {
        String strOutput = "";
        if (form.getGetKeysAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s()", (Object)form.getFormId(), (Object)form.getGetMainDataAction().getActionName());
        }
        return strOutput;
    }

    public static String getFormHasKeysScript(SRFExForm form) {
        String strOutput = "";
        if (form.getHasKeysAction() != null) {
            strOutput = StringHelper.Format((String)"%1$s.%2$s()", (Object)form.getFormId(), (Object)form.getHasKeysAction().getActionName());
        }
        return strOutput;
    }

    public static String getOnFormFillEventScript(SRFExForm form, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.form['%1$s'].on('filled',function(_T){%2$s});", (Object)form.getFormId(), (Object)strEventCode);
        return strOutput;
    }

    public static String getOnFormResetEventScript(SRFExForm form, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.form['%1$s'].on('reseted',function(_T){%2$s});", (Object)form.getFormId(), (Object)strEventCode);
        return strOutput;
    }
}

