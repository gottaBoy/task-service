/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Ctrl.Tree;

import SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.SRFExWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportTreeActionHelper
extends BaseDATreeActionHelper {
    private static final Log log = LogFactory.getLog(ReportTreeActionHelper.class);

    protected boolean IsLoadDataRow(DataRow dr) {
        String strReportId;
        block3: {
            try {
                strReportId = "";
                if (!dr.IsDBNull("REPORTID")) break block3;
                return false;
            }
            catch (Exception e) {
                log.error((Object)e);
                return false;
            }
        }
        try {
            strReportId = dr.Get("REPORTID").toString();
            return this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), UniResHelper.GetReportResId((String)strReportId));
        }
        catch (Exception e) {
            log.error((Object)e);
            return false;
        }
    }
}

