/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.IUserDGThemeDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExUserDataGridTheme
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridColumnConfig
 *  SA.SRFramework.WebEx.UI.DataGridConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DEDataCtrl.IUserDGThemeDataCtrl;
import SA.SRFDA.Ctrl.DataGrid.SRFUserDGColumn;
import SA.SRFDA.Ctrl.DataGrid.SRFUserDGTheme;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExUserDataGridTheme;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyDataGridTheme
implements ISRFExUserDataGridTheme {
    private static IDEDataCtrl userDataCtrl = null;
    private static IDEDataCtrl userDataCtrl_Detail = null;
    private static IUserDGThemeDataCtrl userDGThemeDataCtrl = null;
    private static final Log log = LogFactory.getLog(MyDataGridTheme.class);

    public DataGridConfig GetUserDGConfig(SRFExWebContext webContext, DataGridConfig orgConfig) {
        ISRFDAGlobalHelper iGlobalHelper = (ISRFDAGlobalHelper)webContext.getGlobalHelper();
        if (userDataCtrl_Detail == null || userDataCtrl == null) {
            userDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0096", "SYSTEM", null);
            if (userDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0096"));
                return orgConfig;
            }
            userDataCtrl_Detail = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0097", "SYSTEM", null);
            if (userDataCtrl_Detail == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0097"));
                return orgConfig;
            }
            if (iGlobalHelper.getDAModelVersion() >= 10091900) {
                if (userDataCtrl instanceof IUserDGThemeDataCtrl) {
                    userDGThemeDataCtrl = (IUserDGThemeDataCtrl)userDataCtrl;
                }
                if (userDGThemeDataCtrl == null) {
                    log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DE0096"));
                    return orgConfig;
                }
            }
        }
        String strDataGridThemeId = (String.valueOf(webContext.getCurPageName()) + orgConfig.getConfigId()).toUpperCase();
        SRFUserDGTheme userDGTheme = new SRFUserDGTheme();
        userDGTheme.setProjectId("SAEAM3");
        userDGTheme.setDataGridId(strDataGridThemeId);
        userDGTheme.setPersonId(webContext.getCurUserId());
        try {
            Vector userDGThemes = new Vector();
            CallResult callResult = userDataCtrl.Select((BaseDataEntity)userDGTheme, userDGThemes);
            if (callResult.getRetCode() == 0) {
                if (userDGThemes.size() < 1) {
                    return orgConfig;
                }
                userDGTheme.Proxy((BaseDataEntity)userDGThemes.get(0));
                if (iGlobalHelper.getDAModelVersion() >= 10091900) {
                    boolean bTestGroupField;
                    String strDataGridTheme = userDGTheme.getDGThemeModel();
                    if (StringHelper.IsNullOrEmpty((String)strDataGridTheme)) {
                        return orgConfig;
                    }
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
                    Vector<SRFUserDGColumn> userDGColumns = new Vector<SRFUserDGColumn>();
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
                                            userDGColumn.setOrderFlag(i + 1);
                                            userDGColumns.add(userDGColumn);
                                        }
                                    }
                                }
                            }
                        }
                        ++i;
                    }
                    boolean bContainSortField = false;
                    boolean bContainGroupField = false;
                    int nIndex = 0;
                    int i2 = 0;
                    while (i2 < userDGColumns.size()) {
                        SRFUserDGColumn userDGColumn = (SRFUserDGColumn)((Object)userDGColumns.get(i2));
                        DataGridColumnConfig dataGridColumnConfig = orgConfig.getDataGridColumnsConfig().FindDataGridColumnConfig(userDGColumn.getDGColumnId());
                        if (dataGridColumnConfig != null) {
                            orgConfig.getDataGridColumnsConfig().MoveColumn(dataGridColumnConfig, userDGColumn.GetParamIntValue("ORDERFLAG", nIndex) - 1);
                            dataGridColumnConfig.setLocked(userDGColumn.getLockFlag() == 1);
                            dataGridColumnConfig.setHidden(userDGColumn.getVisibleFlag() != 1);
                            dataGridColumnConfig.setWidth(userDGColumn.getWidth());
                            ++nIndex;
                        }
                        ++i2;
                    }
                    boolean bTestSortField = !StringHelper.IsNullOrEmpty((String)strSortField);
                    boolean bl = bTestGroupField = !StringHelper.IsNullOrEmpty((String)strGroupField);
                    if (bTestSortField || bTestGroupField) {
                        int i3 = 0;
                        while (i3 < orgConfig.getDataGridColumnsConfig().getList().size()) {
                            DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)orgConfig.getDataGridColumnsConfig().getList().get(i3);
                            if (bTestSortField && StringHelper.Compare((String)dataGridColumnConfig.getDSItem(), (String)strSortField, (boolean)true) == 0) {
                                bContainSortField = true;
                                bTestSortField = false;
                            }
                            if (bTestGroupField && StringHelper.Compare((String)dataGridColumnConfig.getDSItem(), (String)strGroupField, (boolean)true) == 0) {
                                bContainGroupField = true;
                                bTestGroupField = false;
                            }
                            if (!bTestSortField && !bTestGroupField) break;
                            ++i3;
                        }
                    }
                    if (bContainSortField) {
                        orgConfig.getDataGridDSConfig().setSortField(strSortField);
                        orgConfig.getDataGridDSConfig().setSortDesc(StringHelper.Compare((String)strSortDirection, (String)"DESC", (boolean)true) == 0);
                    }
                    if (bContainGroupField && orgConfig.getDataGridGroupConfig(false) != null && StringHelper.Length((String)strGroupField) > 0) {
                        orgConfig.getDataGridGroupConfig(true).setGroupItem(strGroupField);
                    }
                } else {
                    SRFUserDGColumn userDGColumn = new SRFUserDGColumn();
                    userDGColumn.setUserDGThemeId(userDGTheme.GetParamStringValue("USERDGTHEMEID", ""));
                    Vector userDGColumns = new Vector();
                    callResult = userDataCtrl_Detail.Select((BaseDataEntity)userDGColumn, userDGColumns);
                    if (callResult.getRetCode() == 0) {
                        orgConfig.getDataGridDSConfig().setSortField(userDGTheme.getReserver());
                        orgConfig.getDataGridDSConfig().setSortDesc(StringHelper.Compare((String)userDGTheme.getReserver2(), (String)"DESC", (boolean)true) == 0);
                        if (orgConfig.getDataGridGroupConfig(false) != null && StringHelper.Length((String)userDGTheme.getReserver3()) > 0) {
                            orgConfig.getDataGridGroupConfig(true).setGroupItem(userDGTheme.getReserver3());
                        }
                        int nIndex = 0;
                        int i = 0;
                        while (i < userDGColumns.size()) {
                            userDGColumn.Proxy((BaseDataEntity)userDGColumns.get(i));
                            DataGridColumnConfig dataGridColumnConfig = orgConfig.getDataGridColumnsConfig().FindDataGridColumnConfig(userDGColumn.getDGColumnId());
                            if (dataGridColumnConfig != null) {
                                orgConfig.getDataGridColumnsConfig().MoveColumn(dataGridColumnConfig, userDGColumn.GetParamIntValue("ORDERFLAG", nIndex) - 1);
                                dataGridColumnConfig.setLocked(userDGColumn.getLockFlag() == 1);
                                dataGridColumnConfig.setHidden(userDGColumn.getVisibleFlag() != 1);
                                dataGridColumnConfig.setWidth(userDGColumn.getWidth());
                                ++nIndex;
                            }
                            ++i;
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return orgConfig;
    }
}

