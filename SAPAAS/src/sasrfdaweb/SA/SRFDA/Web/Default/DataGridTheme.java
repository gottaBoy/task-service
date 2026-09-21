/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.IUserDGThemeDataCtrl
 *  SA.SRFDA.Ctrl.Data.UserDGTheme
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEDataCtrl.IUserDGThemeDataCtrl;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFDA.Ctrl.DataGrid.SRFUserDGColumn;
import SA.SRFDA.Ctrl.DataGrid.SRFUserDGTheme;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;

public class DataGridTheme
extends SRFDAPage {
    private static IDEDataCtrl userDataCtrl_Detail = null;
    private static IDEDataCtrl userDataCtrl = null;
    private static IUserDGThemeDataCtrl userDGThemeDataCtrl = null;

    public DataGridTheme() {
        this.setResourceId("");
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (userDataCtrl_Detail == null || userDataCtrl == null) {
            userDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0096", "SYSTEM", null);
            if (userDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0096"));
                return false;
            }
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 10091900) {
                if (userDataCtrl instanceof IUserDGThemeDataCtrl) {
                    userDGThemeDataCtrl = (IUserDGThemeDataCtrl)userDataCtrl;
                }
                if (userDGThemeDataCtrl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DE0096"));
                    return false;
                }
            }
            if ((userDataCtrl_Detail = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0097", "SYSTEM", null)) == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0097"));
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean OnCustomAction(String strActionType, String strAction) {
        if (StringHelper.Compare((String)strActionType, (String)"datagridthemeaction", (boolean)true) != 0) return super.OnCustomAction(strActionType, strAction);
        String strDataGridThemeId = this.getWebContext().getDataGridThemeId();
        String strDataGridTheme = this.getWebContext().getDataGridTheme();
        if (StringHelper.Length((String)strDataGridThemeId) == 0) return true;
        if (StringHelper.Length((String)strDataGridTheme) == 0) {
            return true;
        }
        try {
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 10091900) {
                UserDGTheme userDGTheme = new UserDGTheme();
                userDGTheme.setPERSONID(this.getWebContext().getCurUserId());
                userDGTheme.setPROJECTID("SAEAM3");
                userDGTheme.setDATAGRIDID(strDataGridThemeId);
                userDGTheme.setDGTHEMEMODEL(strDataGridTheme);
                CallResult callResult = userDGThemeDataCtrl.UpdateUserDGTheme(userDGTheme);
                if (callResult.getRetCode() == 0) return true;
                return true;
            }
            SRFUserDGTheme userDGTheme = new SRFUserDGTheme();
            userDGTheme.setPersonId(this.getWebContext().getCurUserId());
            userDGTheme.setProjectId("SAEAM3");
            userDGTheme.setDataGridId(strDataGridThemeId);
            String[] parts = strDataGridTheme.split("[;]");
            String strSortField = "";
            String strSortDirection = "";
            String strGroupField = "";
            if (parts.length >= 1) {
                String[] temp = parts[0].split("[|]");
                if (temp.length >= 2) {
                    strSortField = temp[0];
                    strSortDirection = temp[1];
                }
                if (temp.length > 2) {
                    strGroupField = temp[2];
                }
            }
            ArrayList<SRFUserDGColumn> columnList = new ArrayList<SRFUserDGColumn>();
            int i = 1;
            while (i < parts.length) {
                String[] temp = parts[i].split("[|]");
                if (temp.length == 5) {
                    SRFUserDGColumn userDGColumn = new SRFUserDGColumn();
                    if (StringHelper.Length((String)temp[0]) > 0) {
                        // empty if block
                    }
                    if (StringHelper.Length((String)temp[1]) > 0 && StringHelper.Compare((String)"SELECTCOLUMN", (String)temp[1], (boolean)false) != 0) {
                        userDGColumn.setDGColumnId(temp[1]);
                        if (StringHelper.Length((String)temp[2]) > 0) {
                            userDGColumn.setVisibleFlag(Integer.parseInt(temp[2]));
                            if (StringHelper.Length((String)temp[3]) > 0) {
                                userDGColumn.setLockFlag(Integer.parseInt(temp[3]));
                                if (StringHelper.Length((String)temp[4]) > 0) {
                                    userDGColumn.setWidth(Integer.parseInt(temp[4]));
                                    columnList.add(userDGColumn);
                                }
                            }
                        }
                    }
                }
                ++i;
            }
            Vector userDGThemes = new Vector();
            userDataCtrl.Select((BaseDataEntity)userDGTheme, userDGThemes);
            int i2 = 0;
            while (i2 < userDGThemes.size()) {
                if (userDataCtrl.Remove((BaseDataEntity)userDGThemes.get(i2)).getRetCode() != 0) {
                    return true;
                }
                ++i2;
            }
            userDGTheme.setReserver(strSortField);
            userDGTheme.setReserver2(strSortDirection);
            userDGTheme.setReserver3(strGroupField);
            CallResult callResult = userDataCtrl.Save(true, (BaseDataEntity)userDGTheme);
            if (callResult.getRetCode() != 0) {
                return true;
            }
            int i3 = 0;
            while (i3 < columnList.size()) {
                SRFUserDGColumn userDGColumn = new SRFUserDGColumn();
                userDGColumn = (SRFUserDGColumn)((Object)columnList.get(i3));
                userDGColumn.setOrderFlag(i3 + 1);
                userDGColumn.setUserDGThemeId(userDGTheme.getUserDGThemeId());
                callResult = userDataCtrl_Detail.Save(true, (BaseDataEntity)userDGColumn);
                if (callResult.getRetCode() != 0) {
                    // empty if block
                }
                ++i3;
            }
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
    }
}

