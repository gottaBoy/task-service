/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleDADataGridActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(SimpleDADataGridActionHelper.class);

    @Override
    protected boolean OnFetchAction() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        BaseDAQueryModelHelper daQueryModelHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().getDAQueryModelHelper(this.getPage().getDEHelper());
        StringBuilderEx script = new StringBuilderEx();
        script.Append(daQueryModelHelper.GetQueryModelScript());
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        String strCountSQL = daQueryModelHelper.GetCountSQL(script.toString());
        int nStartRow = -1;
        int nPageSize = 0;
        if (this.getDataGrid().getDataGridConfig().getPaging()) {
            String strTemp = this.getPage().getRequest().getParameter("start");
            if (StringHelper.Length((String)strTemp) != 0) {
                try {
                    nStartRow = Integer.parseInt(strTemp);
                }
                catch (Exception ex) {
                    nStartRow = -1;
                }
            }
            if (StringHelper.Length((String)(strTemp = this.getPage().getRequest().getParameter("limit"))) != 0) {
                try {
                    nPageSize = Integer.parseInt(strTemp);
                }
                catch (Exception ex) {
                    nPageSize = 0;
                }
            }
        } else {
            nStartRow = 0;
            nPageSize = 0x7FFFFFFE;
        }
        String strSortParam = this.getPage().getRequest().getParameter("sort");
        String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            strSortParam = strRealSortParam;
        }
        String strSortDirection = this.getPage().getRequest().getParameter("dir");
        String strPagingSQL = daQueryModelHelper.GetPagingSQL(script.toString(), nStartRow, nPageSize, strSortParam, strSortDirection, "", "");
        log.info((Object)("PAGING SQL\r\n" + strPagingSQL));
        this.SelectAndFillFetchResult(strCountSQL, strPagingSQL, null, fetchResult);
        if (StringHelper.Compare((String)this.getWebContext().GetParamValue("EXTCOLUMN"), (String)"TRUE", (boolean)true) == 0) {
            int i = 1;
            while (i <= 10) {
                JSONObject jo = new JSONObject();
                jo.put("DEFNAME", (Object)StringHelper.Format((String)"_srfcol%1$s_", (Object)i));
                jo.put("defname", (Object)StringHelper.Format((String)"_srfcol%1$s_", (Object)i));
                jo.put("deflogicname", (Object)StringHelper.Format((String)"[\u7528\u6237\u6269\u5c55%1$s]", (Object)i));
                fetchResult.getItems().add(jo);
                ++i;
            }
        }
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }
}

