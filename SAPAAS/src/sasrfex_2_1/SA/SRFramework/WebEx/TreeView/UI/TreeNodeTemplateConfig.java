/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.TreeView.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.TreeView.UI.TreeNodeTemplateItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class TreeNodeTemplateConfig
extends XMLConfig {
    public static final String TAG_TREENODETEMPLATE = "SRFEXTREENODETEMPLATE";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_CONDITION = "CONDITION";
    protected TreeMap<String, TreeNodeTemplateItemConfig> itemMap = null;
    protected String strDBField = "";
    protected String strItemFormat = "";
    protected String strCondition = "";
    protected ItemParamsConfig itemParamsConfig = null;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DBFIELD, (boolean)true) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.strCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDBField() {
        if (StringHelper.Length((String)this.strDBField) == 0) {
            return this.getID();
        }
        return this.strDBField;
    }

    public void setDBField(String strDBField) {
        this.strDBField = strDBField;
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXTREENODETEMPLATEITEM", (boolean)true) == 0) {
            TreeNodeTemplateItemConfig treeNodeTemplateItemConfig = new TreeNodeTemplateItemConfig();
            if (treeNodeTemplateItemConfig.LoadConfig(xmlNode)) {
                if (this.itemMap == null) {
                    this.itemMap = new TreeMap();
                }
                this.itemMap.put(treeNodeTemplateItemConfig.getID().toUpperCase(), treeNodeTemplateItemConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXITEMPARAMS", (boolean)true) == 0) {
            if (this.itemParamsConfig == null) {
                this.itemParamsConfig = new ItemParamsConfig();
            }
            this.itemParamsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public TreeNodeTemplateItemConfig FindTreeNodeTemplateItemConfig(String strId) {
        if (this.itemMap == null) {
            return null;
        }
        if (this.itemMap.containsKey(strId = strId.toUpperCase())) {
            return this.itemMap.get(strId);
        }
        return null;
    }

    public ItemParamsConfig getItemParamsConfig() {
        return this.itemParamsConfig;
    }

    public boolean isMatchCondition(SRFExWebContext webContext, DataRow dr) {
        String strValue = TreeNodeTemplateConfig.GetTemplateValue(webContext, this, dr);
        return StringHelper.Compare((String)strValue, (String)this.strCondition, (boolean)true) == 0;
    }

    public boolean isMatchCondition(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        String strValue = TreeNodeTemplateConfig.GetTemplateValue(webContext, this, dataEntity);
        return StringHelper.Compare((String)strValue, (String)this.strCondition, (boolean)true) == 0;
    }

    protected static String GetTemplateValue(SRFExWebContext webContext, TreeNodeTemplateConfig treeNodeTemplateConfig, DataRow dr) {
        try {
            ItemParamsConfig itemParamsConfig;
            String strItemFormat = treeNodeTemplateConfig.getItemFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if ((itemParamsConfig = treeNodeTemplateConfig.getItemParamsConfig()) == null) {
                Object objValue;
                strValue = dr.IsDBNull(treeNodeTemplateConfig.getDBField()) ? "" : ((objValue = dr.Get(treeNodeTemplateConfig.getDBField())) == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue));
            } else {
                Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                int j = 0;
                while (j < itemParamsConfig.getList().size()) {
                    ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                    if (dr.IsDBNull(itemParamConfig.getID())) {
                        valueObj[j] = itemParamConfig.getDefault();
                    } else {
                        Object objValue = null;
                        objValue = StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0 ? StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)dr.Get(itemParamConfig.getID())) : dr.Get(itemParamConfig.getID());
                        if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                            String strTempValue = objValue.toString();
                            CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                            if (codeListConfig != null) {
                                objValue = codeListConfig.GetCodeListValueWithStyle(strTempValue, false);
                            }
                        }
                        valueObj[j] = objValue;
                    }
                    ++j;
                }
                strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
            }
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    protected static String GetTemplateValue(SRFExWebContext webContext, TreeNodeTemplateConfig treeNodeTemplateConfig, BaseDataEntity dataEntity) {
        try {
            ItemParamsConfig itemParamsConfig;
            String strItemFormat = treeNodeTemplateConfig.getItemFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if ((itemParamsConfig = treeNodeTemplateConfig.getItemParamsConfig()) == null) {
                Object objValue = dataEntity.GetParamValue(treeNodeTemplateConfig.getDBField());
                strValue = objValue == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue);
            } else {
                Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                int j = 0;
                while (j < itemParamsConfig.getList().size()) {
                    ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                    Object objValue = dataEntity.GetParamValue(itemParamConfig.getID());
                    if (objValue == null) {
                        valueObj[j] = itemParamConfig.getDefault();
                    } else {
                        if (StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0) {
                            objValue = StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)objValue);
                        }
                        if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                            String strTempValue = objValue.toString();
                            CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                            if (codeListConfig != null) {
                                objValue = codeListConfig.GetCodeListValueWithStyle(strTempValue, false);
                            }
                        }
                        valueObj[j] = objValue;
                    }
                    ++j;
                }
                strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
            }
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public TreeNodeConfig GetTreeNodeConfig(SRFExWebContext webContext, DataRow dr) {
        if (this.itemMap == null) {
            return null;
        }
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        for (String strItem : TreeNodeConfig.getProperties()) {
            TreeNodeTemplateItemConfig treeNodeTemplateConfigItem = this.itemMap.get(strItem);
            if (treeNodeTemplateConfigItem == null) continue;
            treeNodeConfig.SetProperty(strItem, TreeNodeTemplateConfig.GetTemplateItemValue(webContext, treeNodeTemplateConfigItem, dr));
        }
        return treeNodeConfig;
    }

    public TreeNodeConfig GetTreeNodeConfig(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        if (this.itemMap == null) {
            return null;
        }
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        for (String strItem : TreeNodeConfig.getProperties()) {
            TreeNodeTemplateItemConfig treeNodeTemplateConfigItem = this.itemMap.get(strItem);
            if (treeNodeTemplateConfigItem == null) continue;
            treeNodeConfig.SetProperty(strItem, TreeNodeTemplateConfig.GetTemplateItemValue(webContext, treeNodeTemplateConfigItem, dataEntity));
        }
        return treeNodeConfig;
    }

    protected static String GetTemplateItemValue(SRFExWebContext webContext, TreeNodeTemplateItemConfig treeNodeTemplateConfigItem, DataRow dr) {
        try {
            ItemParamsConfig itemParamsConfig;
            String strValue = treeNodeTemplateConfigItem.getValue();
            if (StringHelper.Length((String)strValue) > 0) {
                return strValue;
            }
            String strItemFormat = treeNodeTemplateConfigItem.getItemFormat();
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if ((itemParamsConfig = treeNodeTemplateConfigItem.getItemParamsConfig()) == null) {
                Object objValue;
                strValue = dr.IsDBNull(treeNodeTemplateConfigItem.getDBField()) ? "" : ((objValue = dr.Get(treeNodeTemplateConfigItem.getDBField())) == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue));
            } else {
                CodeListConfig codeListConfig;
                Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                int j = 0;
                while (j < itemParamsConfig.getList().size()) {
                    ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                    if (dr.IsDBNull(itemParamConfig.getID())) {
                        valueObj[j] = itemParamConfig.getDefault();
                    } else {
                        Object objValue = null;
                        objValue = StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0 ? StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)dr.Get(itemParamConfig.getID())) : dr.Get(itemParamConfig.getID());
                        if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                            String strTempValue = objValue.toString();
                            CodeListConfig codeListConfig2 = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                            if (codeListConfig2 != null) {
                                objValue = codeListConfig2.GetCodeListValueWithStyle(strTempValue, false);
                            }
                        }
                        valueObj[j] = objValue;
                    }
                    ++j;
                }
                strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                if (StringHelper.Length((String)treeNodeTemplateConfigItem.getCodeList()) > 0 && (codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(treeNodeTemplateConfigItem.getCodeList())) != null) {
                    strValue = codeListConfig.GetCodeListValueWithStyle(strValue, false);
                }
            }
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    protected static String GetTemplateItemValue(SRFExWebContext webContext, TreeNodeTemplateItemConfig treeNodeTemplateConfigItem, BaseDataEntity dataEntity) {
        try {
            ItemParamsConfig itemParamsConfig;
            String strValue = treeNodeTemplateConfigItem.getValue();
            if (StringHelper.Length((String)strValue) > 0) {
                return strValue;
            }
            String strItemFormat = treeNodeTemplateConfigItem.getItemFormat();
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if ((itemParamsConfig = treeNodeTemplateConfigItem.getItemParamsConfig()) == null) {
                Object objValue = dataEntity.GetParamValue(treeNodeTemplateConfigItem.getDBField());
                strValue = objValue == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue);
            } else {
                CodeListConfig codeListConfig;
                Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                int j = 0;
                while (j < itemParamsConfig.getList().size()) {
                    ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                    Object objValue = dataEntity.GetParamValue(itemParamConfig.getID());
                    if (objValue == null) {
                        valueObj[j] = itemParamConfig.getDefault();
                    } else {
                        if (StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0) {
                            objValue = StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)objValue);
                        }
                        if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                            String strTempValue = objValue.toString();
                            CodeListConfig codeListConfig2 = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                            if (codeListConfig2 != null) {
                                objValue = codeListConfig2.GetCodeListValueWithStyle(strTempValue, false);
                            }
                        }
                        valueObj[j] = objValue;
                    }
                    ++j;
                }
                strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                if (StringHelper.Length((String)treeNodeTemplateConfigItem.getCodeList()) > 0 && (codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(treeNodeTemplateConfigItem.getCodeList())) != null) {
                    strValue = codeListConfig.GetCodeListValueWithStyle(strValue, false);
                }
            }
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}

