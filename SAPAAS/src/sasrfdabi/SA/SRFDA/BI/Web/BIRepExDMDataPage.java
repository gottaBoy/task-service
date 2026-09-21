/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExPage
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Tree.BIRepExDMTreeViewActionHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;

public class BIRepExDMDataPage
extends SRFDAPage {
    protected void OnLoadBackEnd() {
        BIRepExDMTreeViewActionHelper biTreeViewActionHelper;
        String strActionType = this.webContext.getActionType();
        String strAction = this.webContext.getAction();
        String strTreeId = this.webContext.getTreeId();
        if (StringHelper.Length((String)strTreeId) > 0 && (biTreeViewActionHelper = new BIRepExDMTreeViewActionHelper()).Process((SRFExPage)this, strTreeId, this.getWebContext().getTreeNode(), strAction)) {
            return;
        }
    }
}

