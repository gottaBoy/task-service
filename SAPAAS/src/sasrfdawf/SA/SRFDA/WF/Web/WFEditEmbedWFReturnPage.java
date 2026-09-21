/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.CommonXMLFormDialogEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Web.Default.CommonXMLFormDialogEx;
import SA.SRFramework.WebEx.Form.SRFExForm;

public class WFEditEmbedWFReturnPage
extends CommonXMLFormDialogEx {
    protected String GetDPExConfigId() {
        return "SRFWF.DPEX_EMBEDWFRETURN";
    }

    protected void LoadDPEx() {
        super.LoadDPEx();
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        if (!this.IsBackEndMode()) {
            form.setTotalRealId(true);
        }
    }
}

