/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFramework.WebEx.Form.SRFExForm
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFramework.WebEx.Form.SRFExForm;

public interface IFormViewPage {
    public Form getFormData();

    public SRFExForm getForm();

    public boolean isEnableFormDigest();

    public String getFormDigestData();
}

