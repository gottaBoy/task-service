/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExForms {
    protected SRFExPage page = null;
    protected Vector formList = null;
    private static final Log log = LogFactory.getLog(SRFExForms.class);

    public SRFExForms(SRFExPage page) {
        this.page = page;
    }

    public SRFExPage getPage() {
        return this.page;
    }

    public synchronized void AddForm(SRFExBaseForm form) {
        String strTempId = form.getFormId();
        if (StringHelper.StringLength((String)strTempId) == 0) {
            form.setFormId(this.GetUnusedFormId());
        }
        if (this.InternalFindForm(form.getFormId()) != null) {
            return;
        }
        if (this.formList == null) {
            this.formList = new Vector();
        }
        form.setPage(this.page);
        this.formList.addElement(form);
    }

    public synchronized SRFExBaseForm FindForm(String strFormId) {
        return this.InternalFindForm(strFormId);
    }

    public synchronized void RemoveForm(String strFormId) {
        SRFExBaseForm form = this.InternalFindForm(strFormId);
        if (form != null) {
            this.formList.remove(form);
        }
    }

    private SRFExBaseForm InternalFindForm(String strFormId) {
        if (this.formList == null) {
            return null;
        }
        int nFormCount = this.formList.size();
        int i = 0;
        while (i < nFormCount) {
            SRFExBaseForm form = (SRFExBaseForm)this.formList.get(i);
            if (StringHelper.Compare((String)strFormId, (String)form.getFormId(), (boolean)true) == 0) {
                return form;
            }
            ++i;
        }
        return null;
    }

    public void Render(Writer writer) {
        this.OnRender(writer);
    }

    protected synchronized void OnRender(Writer writer) {
        if (this.formList == null) {
            return;
        }
        int nFormCount = this.formList.size();
        int i = 0;
        while (i < nFormCount) {
            SRFExBaseForm form = (SRFExBaseForm)this.formList.get(i);
            form.Render(writer);
            ++i;
        }
    }

    public synchronized String GetUnusedFormId(String strPreFixFormName) {
        if (StringHelper.Length((String)strPreFixFormName) == 0) {
            strPreFixFormName = "form";
        }
        int nNumber = 1;
        String strFormId;
        while (this.InternalFindForm(strFormId = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFixFormName, (Object)nNumber)) != null) {
            ++nNumber;
        }
        return strFormId;
    }

    public synchronized String GetUnusedFormId() {
        return this.GetUnusedFormId("");
    }

    public void RegisterFormControl(SRFExControl formControl) {
        if (formControl instanceof ISRFExFormItem) {
            SRFExBaseForm form;
            ISRFExFormItem formItem = (ISRFExFormItem)((Object)formControl);
            FormItemConfig formItemConfig = formItem.getFormItemConfig();
            if (formItemConfig == null) {
                return;
            }
            String strFormId = formItemConfig.getFormId();
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = this.getPage().getDefaultFormId();
            }
            if ((form = this.FindForm(strFormId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u90e8\u4ef6[%1$s]\u6240\u6307\u5b9a\u7684\u8868\u5355[%2$s]", (Object)formControl.getUniqueID(), (Object)strFormId));
                return;
            }
            form.AddControl(formControl);
        }
    }

    public void UnregisterFormControl(SRFExControl formControl) {
        if (formControl instanceof ISRFExFormItem) {
            SRFExBaseForm form;
            ISRFExFormItem formItem = (ISRFExFormItem)((Object)formControl);
            FormItemConfig formItemConfig = formItem.getFormItemConfig();
            if (formItemConfig == null) {
                return;
            }
            String strFormId = formItemConfig.getFormId();
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = this.getPage().getDefaultFormId();
            }
            if ((form = this.FindForm(strFormId)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u90e8\u4ef6[%1$s]\u6307\u5b9a\u8868\u5355[%2$s]", (Object)formControl.getUniqueID(), (Object)strFormId));
                return;
            }
            form.RemoveControl(formControl);
        }
    }
}

