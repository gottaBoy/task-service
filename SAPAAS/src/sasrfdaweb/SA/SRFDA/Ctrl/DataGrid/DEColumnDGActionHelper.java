/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEColumnDGActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(DEColumnDGActionHelper.class);

    @Override
    protected boolean OnFetchAction() {
        IDEHelper inheritDEHelper;
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(this.getWebContext().GetParamValue("DEID"));
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            JSONObject objJSON = new JSONObject();
            objJSON.put("SRFROWID", (Object)Helper.GenGuidEx());
            objJSON.put("KEYS", (Object)iDEFHelper.getName());
            objJSON.put("defname", (Object)iDEFHelper.getName());
            objJSON.put("DEFNAME", (Object)iDEFHelper.getName());
            objJSON.put("deflogicname", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
            fetchResult.getItems().add(objJSON);
        }
        if (iDEHelper.IsInheritMode() && (inheritDEHelper = iDEHelper.GetInheritDEHelper()) != null) {
            for (IDEFHelper iDEFHelper : inheritDEHelper.GetDEFHelpers()) {
                if (iDEFHelper.IsIgnoreInherit() || iDEHelper.IsContainDEField(iDEFHelper.getName())) continue;
                JSONObject objJSON = new JSONObject();
                objJSON.put("SRFROWID", (Object)Helper.GenGuidEx());
                objJSON.put("KEYS", (Object)iDEFHelper.getName());
                objJSON.put("defname", (Object)iDEFHelper.getName());
                objJSON.put("DEFNAME", (Object)iDEFHelper.getName());
                objJSON.put("deflogicname", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
                fetchResult.getItems().add(objJSON);
            }
        }
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }
}

