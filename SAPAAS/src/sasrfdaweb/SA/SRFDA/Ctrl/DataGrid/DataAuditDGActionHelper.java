/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class DataAuditDGActionHelper
extends BaseDADataGridActionHelper {
    @Override
    protected boolean OnGetUserDP() {
        return false;
    }

    @Override
    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        String strPDEId = this.getWebContext().getSRFPDEID();
        if (!StringHelper.IsNullOrEmpty((String)strPDEId)) {
            IDEHelper iMajorDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strPDEId);
            if (iMajorDEHelper == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPDEId));
                userConditions.add("1<>1");
                return;
            }
            String strParamValue = this.getWebContext().GetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName());
            if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
                strParamValue = this.getWebContext().GetPostValue(iMajorDEHelper.GetKeyDEFHelper().getName().toLowerCase());
            }
            if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7236\u5b9e\u4f53\u952e\u503c"));
                userConditions.add("1<>1");
                return;
            }
            IDEFHelper objectTypeDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("OBJECTTYPE");
            IDEFHelper objectidDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("OBJECTID");
            String strOwnerTypeCondition = daQueryModelHelper.GetConditionSQL(objectTypeDEFHelper, "", "=", strPDEId);
            userConditions.add(strOwnerTypeCondition);
            String strOwnerIdCondition = daQueryModelHelper.GetConditionSQL(objectidDEFHelper, "", "=", strParamValue);
            userConditions.add(strOwnerIdCondition);
        } else {
            userConditions.add("1<>1");
        }
    }
}

