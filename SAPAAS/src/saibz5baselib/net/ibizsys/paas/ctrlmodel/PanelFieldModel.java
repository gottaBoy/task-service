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
import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.IPanelFieldModel;
import net.ibizsys.paas.ctrlmodel.IPanelModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PanelFieldModel
extends ModelBaseImpl
implements IPanelFieldModel {
    private static final Log log = LogFactory.getLog(PanelFieldModel.class);
    protected IPanel iPanel = null;
    private String strCodeListId = "";
    private boolean bOutputCodeListConfig = false;
    private int nOutputCodeListConfigMode = IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_NONE;
    protected IDataItem iDataItem = null;

    public void init() throws Exception {
    }

    public void setPanel(IPanel iPanel) {
        this.iPanel = iPanel;
    }

    @Override
    public IPanel getPanel() {
        return this.iPanel;
    }

    @Override
    public IPanelModel getPanelModel() {
        return (IPanelModel)this.getPanel();
    }

    @Override
    public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
        if (this.getDataItem() != null) {
            return this.getDataItem().getValue(iWebContext, iDataObject);
        }
        return iDataObject.get(this.getName());
    }

    @Override
    public ICodeList getCodeList() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getCodeListId())) {
            return null;
        }
        return CodeListGlobal.getCodeList(this.getCodeListId());
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
    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
        if (this.getCodeList() != null) {
            ICodeList iCodeList;
            if (this.isOutputCodeListConfig() && (iCodeList = this.getCodeList()) != null) {
                JSONObject config = new JSONObject();
                this.fillCodeListConfig(config, iCodeList, iWebContext, iDataObject, "items");
                return config;
            }
            return null;
        }
        return null;
    }

    protected void fillCodeListConfig(JSONObject config, ICodeList iCodeList, IWebContext iWebContext, IDataObject iDataObject, String strPropertyName) throws Exception {
        ArrayList<JSONObject> itemList = new ArrayList<JSONObject>();
        Iterator<ICodeItem> codeItems = null;
        if ((this.getOutputCodeListConfigMode() & IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_SELECTEDONLY) > 0) {
            ICodeItem iCodeItem;
            String strValue = DataObject.getStringValue(iDataObject.get(this.getName()));
            if (strValue != null && (iCodeItem = iCodeList.getCodeItem(strValue, true)) != null) {
                JSONObject item = new JSONObject();
                item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(iWebContext, iCodeItem), true));
                item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
                if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                    item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(), true));
                }
                if (iCodeItem.isDisableSelect()) {
                    item.put("disabled", true);
                }
                if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                    item.put("leaf", true);
                } else if ((this.getOutputCodeListConfigMode() & IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD) > 0) {
                    this.fillCodeListItems(iWebContext, item, iCodeItem);
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
                item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(iWebContext, iCodeItem), true));
                item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
                if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                    item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(), true));
                }
                if (iCodeItem.isDisableSelect()) {
                    item.put("disabled", true);
                }
                if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                    item.put("leaf", true);
                } else if (this.getOutputCodeListConfigMode() == IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD.intValue()) {
                    this.fillCodeListItems(iWebContext, item, iCodeItem);
                }
                itemList.add(item);
            }
        }
        config.put(strPropertyName, (Object)itemList.toArray());
    }

    protected void fillCodeListItems(JSONObject parentItem, ICodeItem parentCodeItem) throws Exception {
        this.fillCodeListItems(WebContext.getCurrent(), parentItem, parentCodeItem);
    }

    protected void fillCodeListItems(IWebContext iWebContext, JSONObject parentItem, ICodeItem parentCodeItem) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        Iterator<ICodeItem> items = parentCodeItem.getCodeItems();
        while (items.hasNext()) {
            ICodeItem iCodeItem = items.next();
            JSONObject item = new JSONObject();
            item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(iWebContext, iCodeItem), true));
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
                this.fillCodeListItems(iWebContext, item, iCodeItem);
            }
            list.add(item);
        }
        parentItem.put("items", (Object)list.toArray());
    }

    protected String getCodeItemText(IWebContext iWebContext, ICodeItem iCodeItem) {
        String strText = iCodeItem.getText();
        String strTextLanResTag = iCodeItem.getTextLanResTag();
        if (!StringHelper.isNullOrEmpty(strTextLanResTag)) {
            strText = iWebContext.getLocalization(strTextLanResTag, strText);
        }
        return strText;
    }

    @Override
    public boolean isOutputCodeListConfig() {
        return this.bOutputCodeListConfig;
    }

    public void setOutputCodeListConfig(boolean bOutputCodeListConfig) {
        this.bOutputCodeListConfig = bOutputCodeListConfig;
    }

    @Override
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    public void setOutputCodeListConfigMode(int nOutputCodeListConfigMode) {
        this.nOutputCodeListConfigMode = nOutputCodeListConfigMode;
    }

    @Override
    public IDataItem getDataItem() {
        return this.iDataItem;
    }

    public void setDataItem(IDataItem iDataItem) {
        this.iDataItem = iDataItem;
    }
}

