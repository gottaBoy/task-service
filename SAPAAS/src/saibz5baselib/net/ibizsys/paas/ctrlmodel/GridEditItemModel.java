/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.control.grid.IGEIDEACMode;
import net.ibizsys.paas.control.grid.IGEIDEFValueRule;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.ctrlmodel.IGridEditItemModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.service.UserDictCatService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GridEditItemModel
extends ModelBaseImpl
implements IGridEditItemModel {
    private static final Log log = LogFactory.getLog(GridEditItemModel.class);
    protected IGrid iGrid = null;
    protected IDataItem iDataItem = null;
    private IGEIDEACMode iGEIDEACMode = null;
    private IDEField iDEField = null;
    private ArrayList<IGEIDEFValueRule> fiDEFValueRuleList = null;
    private String strCodeListId = "";
    private String strUserDictCatId = "";
    private int nEnableCond = 3;
    private String strCreateDVT = "";
    private String strCreateDV = "";
    private String strUpdateDVT = "";
    private String strUpdateDV = "";
    private String strCaption = "";
    private boolean bAllowEmpty = true;
    private String strCapLanId = "";
    private String strValueRuleId = null;
    private int nIgnoreInput = 0;
    private boolean bOutputCodeListConfig = false;
    private String strValueItemName = "";
    private String strValueTranslator = "";
    private IValueTranslator iValueTranslator = null;
    private String strDEFName;
    private int nOutputCodeListConfigMode = IGridEditItemModel.OUTPUTCODELISTCONFIGMODE_NONE;

    public void init() throws Exception {
        IGridModel iGridModel;
        if (!StringHelper.isNullOrEmpty(this.getValueTranslator()) && (iGridModel = (IGridModel)this.getGrid()).getViewController() != null) {
            this.iValueTranslator = iGridModel.getViewController().getSystemModel().getValueTranslator(this.getValueTranslator());
        }
    }

    public void setGrid(IGrid iGrid) {
        this.iGrid = iGrid;
    }

    @Override
    public IGrid getGrid() {
        return this.iGrid;
    }

    @Override
    public IGridModel getGridModel() {
        return (IGridModel)this.getGrid();
    }

    @Override
    public IDataItem getDataItem() {
        return this.iDataItem;
    }

    public void setDataItem(IDataItem iDataItem) {
        this.iDataItem = iDataItem;
    }

    @Override
    public Object getInputValue(IWebContext iWebContext) throws Exception {
        String strValue = null;
        strValue = iWebContext.getPostValue(this.getName());
        if (strValue == null) {
            return null;
        }
        if (this.iValueTranslator != null) {
            return this.iValueTranslator.convert(strValue);
        }
        return DataTypeHelper.parse(this.getDataItem().getDataType(), strValue);
    }

    @Override
    public Object getInputValue(JSONObject jsonObject) throws Exception {
        String strValue = null;
        strValue = jsonObject.optString(this.getName());
        if (strValue == null) {
            return null;
        }
        if (this.iValueTranslator != null) {
            return this.iValueTranslator.convert(strValue);
        }
        return DataTypeHelper.parse(this.getDataItem().getDataType(), strValue);
    }

    @Override
    public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
        if (this.getDataItem() != null) {
            return this.getDataItem().getValue(iWebContext, iDataObject);
        }
        return iDataObject.get(this.getName());
    }

    @Override
    public String getPrivilegeId() {
        return null;
    }

    @Override
    public String getValueItemName() {
        return this.strValueItemName;
    }

    @Override
    public IGEIDEACMode getGEIDEACMode() {
        return this.iGEIDEACMode;
    }

    @Override
    public Iterator<IGEIDEFValueRule> getGEIDEFValueRules() {
        if (this.fiDEFValueRuleList == null || this.fiDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.fiDEFValueRuleList.iterator();
    }

    @Override
    public String getDEFName() {
        return this.strDEFName;
    }

    protected void setGEIDEACMode(IGEIDEACMode iGEIDEACMode) {
        this.iGEIDEACMode = iGEIDEACMode;
    }

    @Override
    public IDEField getDEField() {
        return this.iDEField;
    }

    protected void setDEField(IDEField iDEField) {
        this.iDEField = iDEField;
    }

    @Override
    public int getEnableCond() {
        return this.nEnableCond;
    }

    @Override
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @Override
    public String getCreateDV() {
        return this.strCreateDV;
    }

    @Override
    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    @Override
    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    @Override
    public ICodeList getCodeList() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getCodeListId())) {
            return null;
        }
        return CodeListGlobal.getCodeList(this.getCodeListId());
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    public String getCapLanId() {
        return this.strCapLanId;
    }

    @Override
    public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
        if (!bUpdate) {
            return DefaultValueHelper.getValue(iWebContext, this.getCreateDVT(), this.getCreateDV(), this.getDataItem().getDataType());
        }
        return DefaultValueHelper.getValue(iWebContext, this.getUpdateDVT(), this.getUpdateDV(), this.getDataItem().getDataType());
    }

    public void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    public void setValueItemName(String strValueItemName) {
        this.strValueItemName = strValueItemName;
    }

    public void setDEFName(String strDEFName) {
        this.strDEFName = strDEFName;
    }

    public void setEnableCond(int nEnableCond) {
        this.nEnableCond = nEnableCond;
    }

    public void setCreateDVT(String strCreateDVT) {
        this.strCreateDVT = strCreateDVT;
    }

    public void setCreateDV(String strCreateDV) {
        this.strCreateDV = strCreateDV;
    }

    public void setUpdateDVT(String strUpdateDVT) {
        this.strUpdateDVT = strUpdateDVT;
    }

    public void setUpdateDV(String strUpdateDV) {
        this.strUpdateDV = strUpdateDV;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public void setCapLanId(String strCapLanId) {
        this.strCapLanId = strCapLanId;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    public void setCodeListId(String strCodeListId) {
        this.strCodeListId = strCodeListId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getValueRuleId() {
        return this.strValueRuleId;
    }

    public void setValueRuleId(String strValueRuleId) {
        this.strValueRuleId = strValueRuleId;
    }

    @Override
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    public void setIgnoreInput(int nIgnoreInput) {
        this.nIgnoreInput = nIgnoreInput;
    }

    @Override
    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception {
        if (this.getCodeList() != null) {
            ICodeList iCodeList;
            if (this.isOutputCodeListConfig() && (iCodeList = this.getCodeList()) != null) {
                JSONObject config = new JSONObject();
                this.fillCodeListConfig(config, iCodeList, iWebContext, iDataObject, "items");
                return config;
            }
            return null;
        }
        if (!StringHelper.isNullOrEmpty(this.getUserDictCatId())) {
            String strUserDictCatCodeListId = UserDictCatService.calcUserDictCatCodeListId(this.getUserDictCatId());
            ICodeList iCodeList = CodeListGlobal.getCodeList(strUserDictCatCodeListId);
            JSONObject config = new JSONObject();
            this.fillCodeListConfig(config, iCodeList, iWebContext, iDataObject, "dictitems");
            return config;
        }
        return null;
    }

    protected void fillCodeListConfig(JSONObject config, ICodeList iCodeList, IWebContext iWebContext, IDataObject iDataObject, String strPropertyName) throws Exception {
        ArrayList<JSONObject> itemList = new ArrayList<JSONObject>();
        Iterator<ICodeItem> codeItems = null;
        if ((this.getOutputCodeListConfigMode() & IFormItemModel.OUTPUTCODELISTCONFIGMODE_SELECTEDONLY) > 0) {
            ICodeItem iCodeItem;
            String strValue = DataObject.getStringValue(iDataObject.get(this.getName()));
            if (strValue != null && (iCodeItem = iCodeList.getCodeItem(strValue, true)) != null) {
                JSONObject item = new JSONObject();
                item.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(), true));
                item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
                if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                    item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(), true));
                }
                if (iCodeItem.isDisableSelect()) {
                    item.put("disabled", true);
                }
                if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                    item.put("leaf", true);
                } else if ((this.getOutputCodeListConfigMode() & IFormItemModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD) > 0) {
                    this.fillCodeListItems(item, iCodeItem);
                }
                itemList.add(item);
            }
        } else {
            if (iCodeList instanceof IDynamicCodeList) {
                IDynamicCodeList iDynamicCodeList = (IDynamicCodeList)iCodeList;
                codeItems = iDynamicCodeList.queryCodeItems(iWebContext, iDataObject);
            } else {
                codeItems = iCodeList.getCodeItems();
            }
            while (codeItems.hasNext()) {
                ICodeItem iCodeItem = codeItems.next();
                JSONObject item = new JSONObject();
                item.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(), true));
                item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
                if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                    item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(), true));
                }
                if (iCodeItem.isDisableSelect()) {
                    item.put("disabled", true);
                }
                if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                    item.put("leaf", true);
                } else if (this.getOutputCodeListConfigMode() == IFormItemModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD.intValue()) {
                    this.fillCodeListItems(item, iCodeItem);
                }
                itemList.add(item);
            }
        }
        config.put(strPropertyName, (Object)itemList.toArray());
    }

    protected void fillCodeListItems(JSONObject parentItem, ICodeItem parentCodeItem) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        while (parentCodeItem.getCodeItems().hasNext()) {
            ICodeItem iCodeItem = parentCodeItem.getCodeItems().next();
            JSONObject item = new JSONObject();
            item.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(), true));
            item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
            if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(), true));
            }
            if (iCodeItem.isDisableSelect()) {
                item.put("disabled", true);
            }
            if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                item.put("leaf", true);
            } else {
                this.fillCodeListItems(item, iCodeItem);
            }
            list.add(item);
        }
        parentItem.put("items", (Object)list.toArray());
    }

    @Override
    public boolean isOutputCodeListConfig() {
        return this.bOutputCodeListConfig;
    }

    public void setOutputCodeListConfig(boolean bOutputCodeListConfig) {
        this.bOutputCodeListConfig = bOutputCodeListConfig;
    }

    @Override
    public String getValueTranslator() {
        return this.strValueTranslator;
    }

    public void setValueTranslator(String strValueTranslator) {
        this.strValueTranslator = strValueTranslator;
    }

    @Override
    public String getUserDictCatId() {
        return this.strUserDictCatId;
    }

    public void setUserDictCatId(String strUserDictCatId) {
        this.strUserDictCatId = strUserDictCatId;
    }

    @Override
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    public void setOutputCodeListConfigMode(int nOutputCodeListConfigMode) {
        this.nOutputCodeListConfigMode = nOutputCodeListConfigMode;
    }
}

