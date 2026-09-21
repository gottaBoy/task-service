/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IUserDGThemeDataCtrl;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;

public class UserDGThemeDataCtrl
extends BaseDEDataCtrl
implements IUserDGThemeDataCtrl {
    @Override
    public CallResult UpdateUserDGTheme(UserDGTheme userDGTheme) {
        CallResult callResult = new CallResult();
        String strSQL = "DELETE FROM T_SRFUSERDGTHEME WHERE PERSONID=? AND DATAGRIDID=?";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)userDGTheme.getPERSONID());
        callParamList.Add((Object)userDGTheme.getDATAGRIDID());
        callResult = BaseDEDataCtrl.ExecuteWithoutResultEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList());
        if (callResult.IsError()) {
            return callResult;
        }
        return this.Save(true, userDGTheme);
    }
}

