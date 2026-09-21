/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.BaseListCell
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.List;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.BaseListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFStepActorCell
extends BaseListCell {
    private static final Log log = LogFactory.getLog(WFStepActorCell.class);

    public String GetValue(IDEHelper iHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strValue = super.GetValue(iHelper, webContext, globalContext, dr, listColumnConfig);
        try {
            String strUserName = dr.Get("WFUSERNAME").toString();
            String strRoleName = dr.Get("WFSTEPACTORNAME").toString();
            if (StringHelper.Compare((String)strUserName, (String)strRoleName, (boolean)true) == 0) {
                return strUserName;
            }
            return strValue;
        }
        catch (Exception exception) {
            return strValue;
        }
    }
}

