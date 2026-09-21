/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SP.SRFExSPEx;

public class ExportPatchPage
extends SRFDAPageEx {
    protected SRFExSPEx spEx = null;

    @Override
    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.object['%1$s']={};\r\n", (Object)this.spEx.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
        this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.object['%1$s']", (Object)this.spEx.getUniqueID()));
        this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"window.location.href='../srfds/exportpatch.jsp?'+ Ext.urlEncode($P.object['%1$s']);", (Object)this.spEx.getUniqueID()));
    }

    protected String GetSearchFormActionHelper() {
        return BaseDASearchFormActionHelper.class.getName();
    }

    protected void LoadSPEx() {
        this.spEx = ExportPatchPage.CreateSPEx(this, "spEx", "SRFDS.SPEX_EXPORTPATCH");
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
            this.IsBackEndMode();
        }
    }
}

