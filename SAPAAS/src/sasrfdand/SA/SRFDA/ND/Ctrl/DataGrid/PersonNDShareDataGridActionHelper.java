/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersonNDShareDataGridActionHelper
extends NDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(PersonNDShareDataGridActionHelper.class);

    public PersonNDShareDataGridActionHelper() {
        this.bRemoveFlagCondition = true;
    }

    @Override
    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        String strCondition = this.OnGetShareFSOTypeCondition(daQueryModelHelper);
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            userConditions.add(strCondition);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetShareFSORemoveFlagCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
    }

    protected String OnGetShareFSOTypeCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("SHARENDFSOTYPE");
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "FILE");
        String strCondition2 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "FOLDER");
        return StringHelper.Format((String)"(%1$s) OR (%2$s)", (Object)strCondition1, (Object)strCondition2);
    }

    @Override
    protected String OnGetFSObjectTypeCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("NDFSOBJECTTYPE");
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "SHARE");
        return strCondition1;
    }

    @Override
    protected String GetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        return super.GetPagingSQL(daQueryModelHelper, strScript, nStartRow, nPageSize, "SHARENDFSOTYPE", "DESC", strSortParam, strSortDirection);
    }

    protected String OnGetShareFSORemoveFlagCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("SHARENDFSOREMOVEFLAG");
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "ISNULL", "");
        String strCondition2 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "0");
        return StringHelper.Format((String)"(%1$s) OR (%2$s)", (Object)strCondition1, (Object)strCondition2);
    }
}

