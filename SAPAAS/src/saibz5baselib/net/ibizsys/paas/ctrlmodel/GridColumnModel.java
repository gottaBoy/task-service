/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.IGridColumnModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class GridColumnModel
extends ModelBaseImpl
implements IGridColumnModel {
    protected IGrid iGrid = null;
    protected String strCaption = "";
    protected String strExcelCaption = null;
    protected String strDataItemName = "";
    private String strCodeListId = null;
    private String strAlign = "LEFT";
    private IGridDataItem iGridDataItem = null;
    private String strCapLanResTag = null;
    private String strExcelCapLanResTag = null;

    public void init(IGrid iGrid) throws Exception {
        this.setGrid(iGrid);
        this.onInit();
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public String getDataItemName() {
        return this.strDataItemName;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public void setDataItemName(String strDataItemName) {
        this.strDataItemName = strDataItemName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    protected IGrid getGrid() {
        return this.iGrid;
    }

    protected void setGrid(IGrid iGrid) {
        this.iGrid = iGrid;
    }

    @Override
    public String getExcelCaption() {
        if (StringHelper.isNullOrEmpty(this.strExcelCaption)) {
            return this.getCaption();
        }
        return this.strExcelCaption;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    @Override
    public String getAlign() {
        return this.strAlign;
    }

    public void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public IGridModel getGridModel() {
        return (IGridModel)this.getGrid();
    }

    @Override
    public String getExcelText(IWebContext iWebContext, Object object) throws Exception {
        return this.getExcelText(iWebContext, object, false);
    }

    @Override
    public String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        ICodeList iCodeListModel;
        Object objValue;
        block14: {
            IGridDataItem iGridDataItem;
            block13: {
                String strPrivilegeId;
                iGridDataItem = this.getGridDataItem();
                if (!bEnableItemPrivilege || StringHelper.isNullOrEmpty(strPrivilegeId = iGridDataItem.getPrivilegeId()) || (iWebContext.getUserPrivilegeMgr().testDEField(iWebContext, strPrivilegeId) & 1) != 0) break block13;
                return "";
            }
            try {
                objValue = iGridDataItem.getValue(iWebContext, object);
                iCodeListModel = null;
                if (!StringHelper.isNullOrEmpty(this.getCodeListId())) {
                    boolean bConvertCL = true;
                    if (!StringHelper.isNullOrEmpty(iGridDataItem.getCodeListId())) {
                        bConvertCL = false;
                    } else if (iGridDataItem.getDataItemParams() != null) {
                        IDataItemParam[] iDataItemParamArray = iGridDataItem.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            IDataItemParam iDataItemParam = iDataItemParamArray[n2];
                            if (!StringHelper.isNullOrEmpty(iDataItemParam.getCodeListId())) {
                                bConvertCL = false;
                                break;
                            }
                            ++n2;
                        }
                    }
                    if (bConvertCL) {
                        iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(this.getCodeListId());
                    }
                }
                if (objValue != null) break block14;
                if (iCodeListModel != null) {
                    return iCodeListModel.getEmptyText();
                }
                return "";
            }
            catch (Exception ex) {
                return ex.getMessage();
            }
        }
        if (iCodeListModel != null) {
            return iCodeListModel.getCodeListText(objValue.toString(), true);
        }
        return objValue.toString();
    }

    @Override
    public IGridDataItem getGridDataItem() throws Exception {
        if (this.iGridDataItem == null) {
            this.iGridDataItem = this.getGridModel().getGridDataItem(this.getDataItemName());
        }
        return this.iGridDataItem;
    }

    @Override
    public String getCapLanResTag() {
        return this.strCapLanResTag;
    }

    @Override
    public String getExcelCapLanResTag() {
        if (StringHelper.isNullOrEmpty(this.strExcelCapLanResTag)) {
            return this.getCapLanResTag();
        }
        return this.strExcelCapLanResTag;
    }

    public void setCapLanResTag(String strCapLanResTag) {
        this.strCapLanResTag = strCapLanResTag;
    }

    public void setExcelCapLanResTag(String strExcelCapLanResTag) {
        this.strExcelCapLanResTag = strExcelCapLanResTag;
    }
}

