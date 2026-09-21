/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.StringHelper
 *  jxl.Workbook
 *  jxl.write.Label
 *  jxl.write.WritableCell
 *  jxl.write.WritableSheet
 *  jxl.write.WritableWorkbook
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Hashtable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DataGridExcelReportHelperEx {
    private DataGridConfig dataGridConfig = null;
    protected DataTable searchResult = null;
    protected SRFExWebContext webContext = null;
    protected boolean bEnableItemPrivilege = false;

    public void setWebContext(SRFExWebContext webContext) {
        this.webContext = webContext;
    }

    public void setDataSource(DataTable value) {
        this.searchResult = value;
    }

    public void setConfig(DataGridConfig value) {
        this.dataGridConfig = value;
    }

    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }

    public CallResult Output(String strFile) throws Exception {
        CallResult callResult = new CallResult();
        if (this.dataGridConfig == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6570\u636e\u8868\u683c\u903b\u8f91\u6709\u8bef");
            return callResult;
        }
        if (this.searchResult == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6570\u636e\u96c6\u5408\u6709\u8bef");
            return callResult;
        }
        int nColumnCount = this.dataGridConfig.getDataGridColumnsConfig().getList().size();
        WritableWorkbook workbook = Workbook.createWorkbook((File)new File(strFile));
        WritableSheet s1 = workbook.createSheet("\u6570\u636e", 0);
        int nRowIndex = 0;
        int nColumnIndex = 0;
        int i = 0;
        while (i < nColumnCount) {
            DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.dataGridConfig.getDataGridColumnsConfig().getList().get(i));
            if (!this.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getPrivilegeId()) || this.webContext.GetUserPrivilegeMgr().TestColumn(this.webContext, dataGridColumnConfig.getPrivilegeId()) != 0) {
                Label l = new Label(nColumnIndex, nRowIndex, dataGridColumnConfig.getExcelCaption());
                s1.addCell((WritableCell)l);
                s1.setColumnView(nColumnIndex, dataGridColumnConfig.getWidth() / 5);
                ++nColumnIndex;
            }
            ++i;
        }
        ++nRowIndex;
        Hashtable userTable = null;
        for (Object tempRowObj : this.searchResult.getRows()) {
            DataRow row = (DataRow)tempRowObj;
            nColumnIndex = 0;
            int i2 = 0;
            while (i2 < nColumnCount) {
                DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.dataGridConfig.getDataGridColumnsConfig().getList().get(i2));
                if (!this.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getPrivilegeId()) || this.webContext.GetUserPrivilegeMgr().TestColumn(this.webContext, dataGridColumnConfig.getPrivilegeId()) != 0) {
                    String strCellValue = "";
                    strCellValue = StringHelper.Compare((String)"SRFROWSN", (String)dataGridColumnConfig.getID(), (boolean)true) == 0 ? String.valueOf((i2 + 1) * nRowIndex + i2) : this.GetCellValue(this.dataGridConfig.getDataGridDSConfig().FindDSItem(dataGridColumnConfig.getDSItem()), row, userTable);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++i2;
            }
            ++nRowIndex;
        }
        workbook.write();
        workbook.close();
        return callResult;
    }

    public void Output(Writer writer) throws Exception {
        if (this.dataGridConfig == null) {
            writer.write("\u6570\u636e\u8868\u683c\u903b\u8f91\u6709\u8bef\uff0c\u8bf7\u786e\u8ba4\uff01\n");
            return;
        }
        if (this.searchResult == null) {
            writer.write("\u6570\u636e\u96c6\u5408\u6709\u8bef\uff0c\u8bf7\u786e\u8ba4\uff01");
            return;
        }
        int nColumnCount = this.dataGridConfig.getDataGridColumnsConfig().getList().size();
        WritableWorkbook workbook = Workbook.createWorkbook((OutputStream)this.webContext.getPage().getResponse().getOutputStream());
        WritableSheet s1 = workbook.createSheet("\u6570\u636e\u8868\u683c", 0);
        int nRowIndex = 0;
        int nColumnIndex = 0;
        int i = 0;
        while (i < nColumnCount) {
            DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.dataGridConfig.getDataGridColumnsConfig().getList().get(i));
            if (!this.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getPrivilegeId()) || this.webContext.GetUserPrivilegeMgr().TestColumn(this.webContext, dataGridColumnConfig.getPrivilegeId()) != 0) {
                Label l = new Label(nColumnIndex, nRowIndex, dataGridColumnConfig.getExcelCaption());
                s1.addCell((WritableCell)l);
                s1.setColumnView(nColumnIndex, dataGridColumnConfig.getWidth() / 10);
                ++nColumnIndex;
            }
            ++i;
        }
        ++nRowIndex;
        Hashtable userTable = null;
        for (Object tempRowObj : this.searchResult.getRows()) {
            DataRow row = (DataRow)tempRowObj;
            nColumnIndex = 0;
            int i2 = 0;
            while (i2 < nColumnCount) {
                DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.dataGridConfig.getDataGridColumnsConfig().getList().get(i2));
                if (!this.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getPrivilegeId()) || this.webContext.GetUserPrivilegeMgr().TestColumn(this.webContext, dataGridColumnConfig.getPrivilegeId()) != 0) {
                    String strCellValue = "";
                    strCellValue = StringHelper.Compare((String)"SRFROWSN", (String)dataGridColumnConfig.getID(), (boolean)true) == 0 ? String.valueOf((i2 + 1) * nRowIndex + i2) : this.GetCellValue(this.dataGridConfig.getDataGridDSConfig().FindDSItem(dataGridColumnConfig.getDSItem()), row, userTable);
                    Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
                    s1.addCell((WritableCell)l);
                    ++nColumnIndex;
                }
                ++i2;
            }
            ++nRowIndex;
        }
        workbook.write();
        workbook.close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected String GetCellValue(DataGridDSItemConfig dsItemConfig, DataRow dr, Hashtable userTable) {
        if (dsItemConfig == null) {
            return "\u6570\u636e\u9879\u914d\u7f6e\u65e0\u6548";
        }
        try {
            ItemParamsConfig itemParamsConfig;
            if (StringHelper.Length((String)dsItemConfig.getCustom()) > 0) {
                ISRFExDataGridDSItem iDataGridDSItem = this.GetDataGridDSItem(dsItemConfig.getCustom(), userTable);
                if (iDataGridDSItem == null) {
                    return "\u65e0\u6548\u7684\u81ea\u5b9a\u4e49\u8868\u683c\u6570\u636e";
                }
                if (!(iDataGridDSItem instanceof ISRFExDataGridDSItem3)) return iDataGridDSItem.GetValue(dsItemConfig, dr, true);
                return ((ISRFExDataGridDSItem3)((Object)iDataGridDSItem)).GetValue(this.webContext, dsItemConfig, dr, true);
            }
            String strItemFormat = dsItemConfig.getExcelFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if ((itemParamsConfig = dsItemConfig.getItemParamsConfig()) == null) {
                Object objValue;
                strValue = dr.IsDBNull(dsItemConfig.getID()) ? "" : ((objValue = dr.Get(dsItemConfig.getID())) == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue));
            } else {
                Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                int j = 0;
                while (true) {
                    if (j >= itemParamsConfig.getList().size()) {
                        strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                        break;
                    }
                    ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                    if (dr.IsDBNull(itemParamConfig.getID())) {
                        valueObj[j] = itemParamConfig.getDefault();
                    } else {
                        Object objValue = null;
                        objValue = StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0 ? StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)dr.Get(itemParamConfig.getID())) : dr.Get(itemParamConfig.getID());
                        if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                            String strTempValue = objValue.toString();
                            CodeListConfig codeListConfig = this.webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                            if (codeListConfig != null) {
                                objValue = codeListConfig.GetCodeListValue(strTempValue, true);
                            }
                        }
                        valueObj[j] = objValue;
                    }
                    ++j;
                }
            }
            if (StringHelper.Length((String)dsItemConfig.getExcelCodeList()) <= 0) return strValue;
            CodeListConfig codeListConfig = this.webContext.getCodeListMgr().GetCodeListConfig(dsItemConfig.getExcelCodeList());
            if (codeListConfig == null) return strValue;
            return codeListConfig.GetCodeListValue(strValue, true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "\u83b7\u53d6\u8868\u683c\u503c\u51fa\u73b0\u5f02\u5e38";
        }
    }

    protected ISRFExDataGridDSItem GetDataGridDSItem(String strCustomId, Hashtable userTable) {
        if (userTable != null && userTable.contains(strCustomId)) {
            return (ISRFExDataGridDSItem)userTable.get(strCustomId);
        }
        Object obj = ObjectHelper.Create(strCustomId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof ISRFExDataGridDSItem) {
            if (userTable == null) {
                userTable = new Hashtable<String, Object>();
            }
            userTable.put(strCustomId, obj);
            return (ISRFExDataGridDSItem)obj;
        }
        return null;
    }
}

