/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Common.Version
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Admin;

import SA.SRFDA.Common.Version;
import SA.SRFDA.Web.Default.IndexPage;
import SA.SRFramework.Utility.StringHelper;

public class AdminIndexPage
extends IndexPage {
    private static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
    private static final String TAG_LICSTATUS = "{075674F3-7934-418D-AC9C-1E3F150C825A}";

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) != 0) {
                this.getWebContext().getSession().removeAttribute(CONST_CAS_ASSERTION);
                this.getWebContext().Logout();
                this.SetStopPage(true);
                this.getResponse().sendRedirect("../srfadmin/index_real.jsp");
                return;
            }
            if (StringHelper.Compare((String)this.getWebContext().getCurUserMode(), (String)"SYSTEMDEVELOP", (boolean)true) != 0) {
                this.getWebContext().getSession().removeAttribute(CONST_CAS_ASSERTION);
                this.getWebContext().Logout();
                this.SetStopPage(true);
                this.getResponse().sendRedirect("../srfadmin/index_real.jsp");
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected boolean OnGetUserIdDirectMode() {
        return false;
    }

    public String OutputToolVersion() {
        String strLicInfo = "";
        Object objLic = this.getWebContext().getGlobalHelper().GetGlobalValue(TAG_LICSTATUS);
        if (objLic != null) {
            strLicInfo = objLic.toString();
        }
        return StringHelper.Format((String)"Ver %1$s-%2$s &nbsp;[%3$s]", (Object)Version.toVersionString(), (Object)this.getWebContext().getGlobalHelper().getDAModelVersion(), (Object)(StringHelper.IsNullOrEmpty((String)strLicInfo) ? "\u5f00\u53d1\u6a21\u5f0f" : "\u6388\u6743\u6a21\u5f0f"));
    }
}

