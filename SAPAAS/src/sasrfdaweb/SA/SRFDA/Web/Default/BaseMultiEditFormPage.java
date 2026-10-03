/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseMultiEditFormPage
extends BaseMainPage {
    protected boolean bInfoMode = false;

    @Override
    protected boolean PreparePageEnv() {
        block6: {
            block5: {
                if (!super.PreparePageEnv()) {
                    return false;
                }
                this.strPageDataEntityId = this.getWebContext().getSRFDEID();
                if (this.LoadPageDataEntity()) break block5;
                return false;
            }
            try {
                if (this.ProcessParentDataTag()) break block6;
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                return false;
            }
            return false;
        }
        try {
            this.bInfoMode = this.OnGetInfoMode();
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
        }
        return true;
    }

    protected boolean OnGetInfoMode() {
        if (this.getWebContext().isContainsParam("SRFINFOMODE")) {
            return this.getWebContext().getSRFInfoMode();
        }
        boolean bInfoMode = false;
        try {
            if (this.isEnableParentData() && StringHelper.Compare((String)this.getPickupDEFHelper().GetDERId(), (String)this.getDEHelper().GetMajorDERId(), (boolean)false) == 0 && this.isParentDataInWorkflow() && !this.isParentDataEnableWFUpdate()) {
                bInfoMode = true;
            }
        }
        catch (Exception e) {
            this.PageLog(this, 1, e.getMessage(), e);
        }
        return this.getPageParam("PAGE.INFOMODE", bInfoMode);
    }

    protected boolean isInfoMode() {
        return this.bInfoMode;
    }
}

