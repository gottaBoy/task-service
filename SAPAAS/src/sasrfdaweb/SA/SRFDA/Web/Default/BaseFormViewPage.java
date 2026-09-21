/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.PP.PPEditForm
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Config.DPConfigPublishContext;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.PP.PPEditForm;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Web.Default.BaseEditViewPage;
import SA.SRFDA.Web.IFormViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;

public abstract class BaseFormViewPage
extends BaseEditViewPage
implements IFormViewPage {
    protected SRFExDPEx panel = null;
    protected String strDPConfigId = "";
    public static final String TAG_WFFORMNAME_DEFAULT = "DEFAULT";
    private String strFormDigestData = "";
    protected String strFormViewId = "";
    protected Form formView = null;
    public static final String PPCTRLID_PANEL = "PANEL";
    protected PPEditForm ppEditForm = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_PANEL, "PP_FORM")) != null && pageParam instanceof PPEditForm) {
            this.ppEditForm = (PPEditForm)pageParam;
        }
    }

    protected Form CalcCurrentFormView() throws Exception {
        String strFormViewId = this.ProcessMultiFormMode();
        Form formView = null;
        if (StringHelper.IsNullOrEmpty((String)strFormViewId)) {
            strFormViewId = this.getCurrentDEMainActionForm();
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormViewId)) {
            formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), strFormViewId);
            if (formView == null) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8868\u5355[%2$s]\u5931\u8d25", (Object)this.strPageDataEntityId, (Object)strFormViewId));
            }
            return formView;
        }
        formView = this.getWebContext().GetConfigCache().GetDefaultDEMainForm(this.getWebContext(), this.getPageDataEntityId());
        if (formView == null) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u9ed8\u8ba4\u8868\u5355\u5931\u8d25", (Object)this.getPageDataEntityId()));
        }
        return formView;
    }

    protected boolean ProcessFormDigestMode() {
        BaseDataEntity activeData;
        block5: {
            if (!this.isEnableFormDigest()) {
                return true;
            }
            if (this.IsBackEndMode()) {
                String strFormDigestData = SRFDAWebCTXHelper.GetFormDigest((ISRFDAWebContext)this.getWebContext());
                this.setFormDigestData(strFormDigestData);
                return true;
            }
            try {
                activeData = this.getActiveData();
                if (activeData != null) break block5;
                return true;
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u754c\u9762\u5f53\u524d\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                return false;
            }
        }
        String strFormDigestData = BaseDataEntity.CalcDigest((BaseDataEntity)activeData, (String)this.getFormData().getSENSITIVEFIELDS());
        this.setFormDigestData(strFormDigestData);
        this.getWebContext().SetParamValue("SRFFORMDIGEST", strFormDigestData);
        return true;
    }

    @Override
    public final Form getFormData() {
        return this.formView;
    }

    protected final void setFormData(Form formView) {
        this.formView = formView;
    }

    @Override
    public SRFExForm getForm() {
        return (SRFExForm)this.getDefaultForm();
    }

    @Override
    public final boolean isEnableFormDigest() {
        return this.OnGetEnableFormDigest();
    }

    protected boolean OnGetEnableFormDigest() {
        if (!this.getFormData().isSENSITIVEMODENull()) {
            return this.getFormData().getSENSITIVEMODE();
        }
        return false;
    }

    @Override
    public String getFormDigestData() {
        return this.strFormDigestData;
    }

    protected void setFormDigestData(String strFormDigestData) {
        this.strFormDigestData = strFormDigestData;
    }

    @Override
    protected boolean OnGetEnableDAConfigV2(String strConfigType) {
        if (StringHelper.Compare((String)strConfigType, (String)"DP", (boolean)true) == 0 && this.isEnableFormDigest()) {
            return true;
        }
        return super.OnGetEnableDAConfigV2(strConfigType);
    }

    protected String GetFormActionHelper() {
        String strFormActionHelper = this.getPageParam("PAGE.FORMACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
            return strFormActionHelper;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return this.GetDefaultFormActionHelper();
    }

    protected String GetDefaultFormActionHelper() {
        if (this.getDEHelper().IsEnableWF()) {
            return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFFORMACTIONHELPER", "");
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
    }

    protected String OnGetDPConfigId() {
        try {
            if (this.isEnableDAConfigV2("DP")) {
                DPConfigPublishContext configPublishContext = new DPConfigPublishContext();
                this.FillDAConfigPublishContext(configPublishContext);
                configPublishContext.setForm(this.getFormData());
                if (this.isEnableFormDigest()) {
                    configPublishContext.setAppendConfigId(this.getFormDigestData());
                    if (!this.IsBackEndMode()) {
                        configPublishContext.setActiveData(this.getActiveData());
                    }
                }
                return this.getDAConfigHelper().GetConfigId("DP", (IDAConfigPublishContext)configPublishContext);
            }
            return this.getPageParam("PAGE.FORM.DPCONFIGID", this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView));
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u52a8\u6001\u9762\u677f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    public final boolean isEnableFormItemPrivilege() {
        return this.OnGetFormItemPrivilege();
    }

    protected boolean OnGetFormItemPrivilege() {
        boolean bEnableDEFPriv = this.getDEHelper().IsEnableDEFieldPriv();
        if (this.ppEditForm != null && !this.ppEditForm.isITEMPRIVILEGENull()) {
            bEnableDEFPriv = this.ppEditForm.getITEMPRIVILEGE();
        }
        return this.getPageParam("PAGE.FORM.ITEMPRIVILEGE", bEnableDEFPriv);
    }

    @Override
    protected String OnGetPageCaption() {
        if (this.IsContainPageParam("PAGE.CAPTIONCONTENT")) {
            return this.getPageParam("PAGE.CAPTIONCONTENT", "");
        }
        if (this.formView != null && !StringHelper.IsNullOrEmpty((String)this.formView.getPAGECAPTION())) {
            return this.formView.getPAGECAPTION();
        }
        return super.OnGetPageCaption();
    }
}

