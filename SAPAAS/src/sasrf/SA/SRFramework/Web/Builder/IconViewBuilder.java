/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.BaseListBuilder;
import SA.SRFramework.Web.IWebListUserColumn;
import SA.SRFramework.Web.IWebListUserColumn2;
import SA.SRFramework.Web.UI.IconViewConfig;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.UI.UserCtrlMgr;
import SA.SRFramework.Web.WebUtility;
import java.net.URLEncoder;

public class IconViewBuilder
extends BaseListBuilder {
    protected IconViewConfig iconviewConfig = null;

    public void setIconViewConfig(IconViewConfig value) {
        this.iconviewConfig = value;
    }

    protected String GetItemValue(ListColumnConfig item, DataTable dt, DataRow row, int nRowIndex) throws Exception {
        if (item.getManual()) {
            if (this.userCtrlMgr == null) {
                this.userCtrlMgr = (UserCtrlMgr)this.webContext.getPageContext().getServletContext().getAttribute("SRFUSERCTRLMGR");
            }
            if (this.userCtrlMgr == null) {
                System.err.print("Invalid UserListColumnMgr\n");
                return "&nbsp";
            }
            Object userListColumn = this.userCtrlMgr.Get(item.getUserColumn());
            if (userListColumn == null) {
                System.err.print("Invalid UserListColumn[" + item.getUserColumn() + "]\n");
                return "&nbsp";
            }
            if (ClassHelper.ContainClass(userListColumn.getClass(), IWebListUserColumn2.class)) {
                IWebListUserColumn2 inter = (IWebListUserColumn2)userListColumn;
                return inter.Output2(this.webContext, item.getID(), item, row, dt, 0);
            }
            if (ClassHelper.ContainClass(userListColumn.getClass(), IWebListUserColumn.class)) {
                IWebListUserColumn inter = (IWebListUserColumn)userListColumn;
                return inter.Output(item.getID(), item, row, 0);
            }
            return "&nbsp";
        }
        if (item.getItemParams().size() == 0) {
            return String.format(item.getItemFormat(), "");
        }
        Object[] valueObj = new Object[item.getItemParams().size()];
        int i = 0;
        while (i < valueObj.length) {
            ParamConfig paramConfig = (ParamConfig)item.getItemParams().get(i);
            if (paramConfig.getMust() && row.IsDBNull(paramConfig.getID())) {
                return "&nbsp";
            }
            Object tempObj = row.Get(paramConfig.getID());
            String strObjValue = "";
            strObjValue = tempObj == null ? paramConfig.getDefaultValue() : (StringHelper.StringLength(paramConfig.getValueFormat()) == 0 ? tempObj.toString() : String.format(paramConfig.getValueFormat(), tempObj));
            if (paramConfig.getEncode()) {
                strObjValue = URLEncoder.encode(strObjValue, "UTF-8");
            }
            valueObj[i] = strObjValue;
            ++i;
        }
        String strOutput = StringHelper.Format(item.getItemFormat(), valueObj);
        if (item.getTrimLen() != 0) {
            String strValue = strOutput;
            if (strValue.length() > item.getTrimLen()) {
                strValue = strValue.substring(0, item.getTrimLen());
                strValue = String.valueOf(strValue) + "...";
            }
            strOutput = WebUtility.TextToHTMLWithoutReturn(strValue);
        }
        return strOutput;
    }
}

