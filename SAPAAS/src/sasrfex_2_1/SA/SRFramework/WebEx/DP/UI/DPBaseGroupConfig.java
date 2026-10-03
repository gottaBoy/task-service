/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.DP.UI.DPDataGridItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPFormItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPItemsConfig;
import SA.SRFramework.WebEx.DP.UI.DPRawItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPSpaceItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPTabGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPUserFormItemConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import org.w3c.dom.Node;

public abstract class DPBaseGroupConfig
extends DPItemConfig {
    public static final String TAG_COLUMNS = "COLUMNS";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONWIDTH = "CAPTIONWIDTH";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_EXTSTYLE = "EXTSTYLE";
    public static final String TAG_GROUPID = "GROUPID";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_CAPTIONBINDING = "CAPTIONBINDING";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    protected String strCaption = "";
    protected String strColumns = "";
    protected String strHeight = "";
    protected int nCaptionWidth = 0;
    protected String strCaptionCssClass = "";
    protected String strExtStyle = "";
    protected String strEnableCond = "";
    protected String strGroupId = "";
    protected String strCaptionBinding = "";
    protected String strResourceId = null;
    protected DPItemsConfig itemsConfig = new DPItemsConfig();
    protected static Hashtable<String, String> childItemMap = new Hashtable();

    static {
        childItemMap.put("SRFEXDPRAWITEM", "SA.SRFramework.WebEx.DP.UI.DPRawItemConfig");
        childItemMap.put("SRFEXDPGROUP", "SA.SRFramework.WebEx.DP.UI.DPGroupConfig");
        childItemMap.put("SRFEXDPFORMITEM", "SA.SRFramework.WebEx.DP.UI.DPFormItemConfig");
        childItemMap.put("SRFEXDPUSERFORMITEM", "SA.SRFramework.WebEx.DP.UI.DPUserFormItemConfig");
        childItemMap.put("SRFEXDPSPACEITEM", "SA.SRFramework.WebEx.DP.UI.DPSpaceItemConfig");
        childItemMap.put("SRFEXDPTABGROUP", "SA.SRFramework.WebEx.DP.UI.DPTabGroupConfig");
        childItemMap.put("SRFEXDPDATAGRIDITEM", DPDataGridItemConfig.class.getName());
    }

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_COLUMNS);
        if (strValue != null) {
            this.setColumns(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPTION)) != null) {
            this.setCaption(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONCSSCLASS)) != null) {
            this.setCaptionCssClass(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONWIDTH)) != null) {
            this.nCaptionWidth = DPBaseGroupConfig.GetValue((String)strValue, (int)this.nCaptionWidth);
        }
        if ((strValue = attrMap.remove(TAG_EXTSTYLE)) != null) {
            this.setExtStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ENABLECOND)) != null) {
            this.setEnableCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_GROUPID)) != null) {
            this.setGroupId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONBINDING)) != null) {
            this.setCaptionBinding(strValue);
        }
        if ((strValue = attrMap.remove(TAG_RESOURCEID)) != null) {
            this.setResourceId(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (childItemMap.containsKey(strName = strName.toUpperCase())) {
            String strObject = childItemMap.get(strName);
            Object objConfig = this.CreateObject(strObject);
            if (objConfig != null && objConfig instanceof DPItemConfig) {
                DPItemConfig itemConfig = (DPItemConfig)((Object)objConfig);
                itemConfig.setParentGroupConfig(this);
                if (itemConfig.LoadConfig(xmlNode)) {
                    this.itemsConfig.add(itemConfig);
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    private Object CreateObject(String strObject) {
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPFormItemConfig", (boolean)false) == 0) {
            return new DPFormItemConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPGroupConfig", (boolean)false) == 0) {
            return new DPGroupConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPRawItemConfig", (boolean)false) == 0) {
            return new DPRawItemConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPUserFormItemConfig", (boolean)false) == 0) {
            return new DPUserFormItemConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPSpaceItemConfig", (boolean)false) == 0) {
            return new DPSpaceItemConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPTabGroupConfig", (boolean)false) == 0) {
            return new DPTabGroupConfig();
        }
        if (StringHelper.Compare((String)strObject, (String)"SA.SRFramework.WebEx.DP.UI.DPDataGridItemConfig", (boolean)false) == 0) {
            return new DPDataGridItemConfig();
        }
        return ObjectHelper.Create(strObject);
    }

    public DPItemsConfig getItemsConfig() {
        return this.itemsConfig;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getColumns() {
        return this.strColumns;
    }

    public void setColumns(String strColumns) {
        this.strColumns = strColumns;
    }

    public int getCaptionWidth() {
        if (this.nCaptionWidth == 0 && this.getParentGroupConfig() != null) {
            return this.getParentGroupConfig().getCaptionWidth();
        }
        return this.nCaptionWidth;
    }

    public void setCaptionWidth(int captionWidth) {
        this.nCaptionWidth = captionWidth;
    }

    @Override
    protected void OnGetFormCtrlConfig(ArrayList list) {
        super.OnGetFormCtrlConfig(list);
        int i = 0;
        while (i < this.itemsConfig.size()) {
            DPItemConfig dpItemConfig = (DPItemConfig)((Object)this.itemsConfig.get(i));
            dpItemConfig.GetFormCtrlConfig(list);
            ++i;
        }
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getExtStyle() {
        return this.strExtStyle;
    }

    public void setExtStyle(String strExtStyle) {
        this.strExtStyle = strExtStyle;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
    }

    public String getEnableCond() {
        return this.strEnableCond;
    }

    public void setEnableCond(String strEnableCond) {
        this.strEnableCond = strEnableCond;
    }

    public String getGroupId() {
        if (StringHelper.IsNullOrEmpty((String)this.strGroupId)) {
            return this.getID();
        }
        return this.strGroupId;
    }

    public void setGroupId(String strGroupId) {
        this.strGroupId = strGroupId;
    }

    public String getCaptionBinding() {
        if (StringHelper.IsNullOrEmpty((String)this.strCaptionBinding)) {
            return this.getID();
        }
        return this.strCaptionBinding;
    }

    public void setCaptionBinding(String strCaptionBinding) {
        this.strCaptionBinding = strCaptionBinding;
    }

    public String getResourceId() {
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }
}
