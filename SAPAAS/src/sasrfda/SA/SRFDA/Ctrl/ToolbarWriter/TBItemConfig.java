/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFramework.Base.XMLCollectionConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.w3c.dom.Node;

public class TBItemConfig
extends XMLConfig {
    public static final String TAG_TBITEM = "SRFDATBITEM";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPLANRESID = "CAPLANRESID";
    public static final String TAG_DEBEHAVIORID = "DEBEHAVIORID";
    public static final String TAG_DEBEHAVIORNAME = "DEBEHAVIORNAME";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_VISIBLECOND = "VISIBLECOND";
    public static final String TAG_SEPERATOR = "SEPERATOR";
    public static final String SEPERATOR_FIRST = "FIRST";
    public static final String SEPERATOR_LAST = "LAST";
    public static final String SEPERATOR_ALL = "ALL";
    public static final String SEPERATOR_NONE = "NONE";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_SIMPLEMODE = "SIMPLEMODE";
    public static final String MODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String MODE_ICON = "ICON";
    public static final String MODE_SHORTWORD = "SHORTWORD";
    protected String strCaption = "";
    protected String strCapLanResId = "";
    protected String strDEBehaviorId = "";
    protected String strDEBehaviorName = "";
    protected String strIconCls = "";
    protected String strVisibleCond = "";
    protected String strSimpleMode = "";
    protected String strDefaultMode = "";
    protected String strSeperator = "";
    protected XMLCollectionConfig<TBItemConfig> items = new XMLCollectionConfig();

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_TBITEM, (boolean)true) == 0) {
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.LoadConfig(xmlNode);
            this.items.add((Object)tbItemConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public XMLCollectionConfig<TBItemConfig> getItems() {
        return this.items;
    }

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_CAPTION);
        if (strValue != null) {
            this.setCaption(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPLANRESID)) != null) {
            this.setCapLanResId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DEBEHAVIORID)) != null) {
            this.setDEBehaviorId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DEBEHAVIORNAME)) != null) {
            this.setDEBehaviorName(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ICONCLS)) != null) {
            this.setIconCls(strValue);
        }
        if ((strValue = attrMap.remove(TAG_VISIBLECOND)) != null) {
            this.setVisibleCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_SIMPLEMODE)) != null) {
            this.setSimpleMode(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DEFAULTMODE)) != null) {
            this.setDefaultMode(strValue);
        }
        if ((strValue = attrMap.remove(TAG_SEPERATOR)) != null) {
            this.setSeperator(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public String getCaption() {
        return this.strCaption;
    }

    public String getDEBehaviorId() {
        return this.strDEBehaviorId;
    }

    public String getDEBehaviorName() {
        return this.strDEBehaviorName;
    }

    public String getIconCls() {
        return this.strIconCls;
    }

    public String getVisibleCond() {
        return this.strVisibleCond;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public void setDEBehaviorId(String strDEBehaviorId) {
        this.strDEBehaviorId = strDEBehaviorId;
    }

    public void setDEBehaviorName(String strDEBehaviorName) {
        this.strDEBehaviorName = strDEBehaviorName;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public void setVisibleCond(String strVisibleCond) {
        this.strVisibleCond = strVisibleCond;
    }

    public String getCapLanResId() {
        return this.strCapLanResId;
    }

    public void setCapLanResId(String strCapLanResId) {
        this.strCapLanResId = strCapLanResId;
    }

    public String getSimpleMode() {
        return this.strSimpleMode;
    }

    public void setSimpleMode(String strSimpleMode) {
        this.strSimpleMode = strSimpleMode;
    }

    public String getDefaultMode() {
        return this.strDefaultMode;
    }

    public void setDefaultMode(String strDefaultMode) {
        this.strDefaultMode = strDefaultMode;
    }

    public boolean IsShowIcon(boolean bDefaultMode) {
        String strMode;
        String string = strMode = bDefaultMode ? this.strDefaultMode : this.strSimpleMode;
        if (StringHelper.IsNullOrEmpty((String)strMode)) {
            return true;
        }
        if (StringHelper.Compare((String)strMode, (String)MODE_ICON, (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)strMode, (String)MODE_ICONANDSHORTWORD, (boolean)true) == 0;
    }

    public boolean IsShowWord(boolean bDefaultMode) {
        String strMode;
        String string = strMode = bDefaultMode ? this.strDefaultMode : this.strSimpleMode;
        return StringHelper.IsNullOrEmpty((String)strMode);
    }

    public boolean IsShowShortWord(boolean bDefaultMode) {
        String strMode;
        String string = strMode = bDefaultMode ? this.strDefaultMode : this.strSimpleMode;
        if (StringHelper.Compare((String)strMode, (String)MODE_ICONANDSHORTWORD, (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)strMode, (String)MODE_SHORTWORD, (boolean)true) == 0;
    }

    public String getSeperator() {
        return this.strSeperator;
    }

    public void setSeperator(String strSeperator) {
        this.strSeperator = strSeperator;
    }
}

