/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Security.UserRoleHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Security.UserRoleHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Enumeration;
import java.util.Vector;

public class AllUserFuncDGActionHelper
extends BaseDADataGridActionHelper {
    @Override
    protected void FillURLCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        String strParamName = "USEROBJECTID";
        String strUserObjectId = this.getWebContext().GetPostValue(strParamName);
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = this.getWebContext().GetParamValue(strParamName);
        }
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = this.getWebContext().GetPostValue("USERID");
        }
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = this.getWebContext().GetParamValue("USERID");
        }
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = this.getWebContext().GetPostValue("USERGROUPID");
        }
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = this.getWebContext().GetParamValue("USERGROUPID");
        }
        if (strUserObjectId != null) {
            strUserObjectId = strUserObjectId.trim();
        }
        if (StringHelper.IsNullOrEmpty((String)strUserObjectId)) {
            strUserObjectId = "NA";
        }
        IDEFHelper iUserObjectIdDEFHelper = this.getDEHelper().GetDEFHelper("USEROBJECTID");
        String strConditon = "";
        UserRoleHelper userRoleHelper = new UserRoleHelper(this.getWebContext().getGlobalHelper(), strUserObjectId);
        Enumeration en = userRoleHelper.getAllUserObjects();
        while (en.hasMoreElements()) {
            String strItem = (String)en.nextElement();
            if (!StringHelper.IsNullOrEmpty((String)strConditon)) {
                strConditon = String.valueOf(strConditon) + " OR ";
            }
            strConditon = String.valueOf(strConditon) + daQueryModelHelper.GetConditionSQL(iUserObjectIdDEFHelper, "", "=", strItem);
        }
        if (!StringHelper.IsNullOrEmpty((String)strConditon)) {
            userConditions.add(strConditon);
        }
    }
}

