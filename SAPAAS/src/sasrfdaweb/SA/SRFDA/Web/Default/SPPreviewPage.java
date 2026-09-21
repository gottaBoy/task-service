/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SP.UI.SPExConfig
 *  SA.SRFramework.WebEx.SRFExControl
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.SRFExControl;

public class SPPreviewPage
extends SRFDAPage {
    protected SRFExDPEx panel = null;
    protected SRFExForm form = null;
    protected boolean bDEFGroupMode = false;
    protected String strDEFGroupId = "";

    public SPPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        this.setID(this.getWebContext().getTabViewPageId());
        String strDEFGroupMode = this.getWebContext().GetPostValue("srfdefgroupspmode");
        if (StringHelper.Compare((String)strDEFGroupMode, (String)"TRUE", (boolean)true) == 0) {
            this.bDEFGroupMode = true;
        }
        if (this.bDEFGroupMode) {
            this.strDEFGroupId = this.getWebContext().GetPostValue("srfdeid");
        } else {
            this.strPageDataEntityId = this.getWebContext().GetPostValue("srfdeid");
            if (!this.LoadPageDataEntity()) {
                return false;
            }
        }
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strXML = this.getWebContext().GetPostValue("dpxml");
        strXML = strXML.replace("\n", "&#xA;");
        strXML = strXML.replace("\r", "&#xD;");
        SPExConfig spConfig = null;
        spConfig = this.bDEFGroupMode ? this.getDAConfigHelper().GetDEFGroupSPExConfig(this.strDEFGroupId, strXML) : this.getDAConfigHelper().GetSPExConfig(this.getDEHelper(), strXML);
        if (spConfig == null) {
            return;
        }
        this.form = new SRFExForm();
        this.form.setFormId(this.getDefaultFormId());
        if (!this.IsBackEndMode()) {
            this.form.setLoadingIndicator(StringHelper.Format((String)"%1$s_indicator", (Object)this.form.getFormId()));
            this.form.setErrorIndicator(StringHelper.Format((String)"%1$s_errorindicator", (Object)this.form.getFormId()));
            this.form.getShowErrorAction().setShowFormItemErrorFunc("SRFForm.showFormItemErrorEx");
            this.form.getResetErrorAction().setShowFormItemErrorFunc("SRFForm.showFormItemErrorEx");
        }
        this.getForms().AddForm((SRFExBaseForm)this.form);
        this.panel = new SRFExDPEx();
        this.panel.setConfig((XMLConfig)spConfig.getDPConfig());
        this.panel.setID("panel");
        this.panel.getDPConfig().setWidth(100);
        this.panel.getDPConfig().setHeight(0);
        this.form.setMainPanel((SRFExControl)this.panel);
        this.AddControl((SRFExControl)this.panel);
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }
}

