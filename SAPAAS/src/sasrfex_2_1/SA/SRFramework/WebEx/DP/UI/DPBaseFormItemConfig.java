/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class DPBaseFormItemConfig
extends DPItemConfig {
    public static final String TAG_CAPTIONONTOP = "CAPTIONONTOP";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_CAPTIONWIDTH = "CAPTIONWIDTH";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_CAPTIONEXTSTYLE = "CAPTIONEXTSTYLE";
    public static final String TAG_AUTOERRORREGION = "AUTOERRORREGION";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_TIPSID = "TIPSID";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_CAPTIONCONTAINERSTYLE = "CAPTIONCONTAINERSTYLE";
    public static final String TAG_CTRLCONTAINERSTYLE = "CTRLCONTAINERSTYLE";
    public static final String TAG_EXTSTYLE = "EXTSTYLE";
    public static final String TAG_UNIT = "UNIT";
    public static final String TAG_UNITWIDTH = "UNITWIDTH";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_PROCESSCOND = "PROCESSCOND";
    public static final String TAG_RESETCOND = "RESETCOND";
    public static final String TAG_ALLOWEMPTYCOND = "ALLOWEMPTYCOND";
    public static final String TAG_EXTPARAMS = "EXTPARAMS";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DV = "DV";
    public static final String TAG_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String TAG_FORMITEMXML = "FORMITEMXML";
    public static final String TAG_FIUPDATEMODE = "FIUPDATEMODE";
    protected boolean bShowCaption = true;
    protected boolean bCaptionOnTop = false;
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected int nCaptionWidth = 0;
    protected boolean bAllowEmpty = true;
    protected String strCaptionExtStyle = "";
    protected boolean bAutoErrorRegion = true;
    protected boolean bSyncControlConfig = true;
    protected String strTips = "";
    protected String strTipsId = "";
    protected String strDVT = "";
    protected String strDV = "";
    protected String strEnableCond = "";
    protected BaseControlConfig ctrlConfig = null;
    protected String strProcessCond = "";
    protected String strFormItemStyle = "";
    protected String strFormItemXML = "";
    protected String strResetCond = "";
    protected String strUnit = "";
    protected int nUnitWidth = 0;
    protected String strAllowEmptyCond = "";
    protected String strCaptionContainerStyle = "";
    protected String strCtrlContainerStyle = "";
    protected String strExtStyle = "";
    protected String strFIUpdateMode = "";
    private static TreeMap<String, Integer> propertyMap = new TreeMap();

    static {
        propertyMap.put(TAG_CAPTIONONTOP, 0);
        propertyMap.put(TAG_CAPTION, 0);
        propertyMap.put(TAG_CAPTIONCSSCLASS, 0);
        propertyMap.put(TAG_CAPTIONWIDTH, 0);
        propertyMap.put(TAG_ALLOWEMPTY, 0);
        propertyMap.put(TAG_CAPTIONEXTSTYLE, 0);
        propertyMap.put(TAG_AUTOERRORREGION, 0);
        propertyMap.put(TAG_TIPS, 0);
        propertyMap.put(TAG_TIPSID, 0);
        propertyMap.put(TAG_DVT, 0);
        propertyMap.put(TAG_DV, 0);
        propertyMap.put(TAG_SHOWCAPTION, 0);
        propertyMap.put(TAG_ENABLECOND, 0);
        propertyMap.put(TAG_RESETCOND, 0);
        propertyMap.put(TAG_PROCESSCOND, 0);
        propertyMap.put(TAG_ALLOWEMPTYCOND, 0);
        propertyMap.put(TAG_FORMITEMSTYLE, 0);
        propertyMap.put(TAG_FORMITEMXML, 0);
        propertyMap.put(TAG_UNIT, 0);
        propertyMap.put(TAG_UNITWIDTH, 0);
        propertyMap.put(TAG_CAPTIONCONTAINERSTYLE, 0);
        propertyMap.put(TAG_CTRLCONTAINERSTYLE, 0);
        propertyMap.put(TAG_EXTSTYLE, 0);
        propertyMap.put(TAG_FIUPDATEMODE, 0);
    }

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_CAPTION);
        if (strValue != null) {
            this.setCaption(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ALLOWEMPTY)) != null) {
            this.setAllowEmpty(DPBaseFormItemConfig.GetValue((String)strValue, (boolean)this.bAllowEmpty));
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONONTOP)) != null) {
            this.setCaptionOnTop(DPBaseFormItemConfig.GetValue((String)strValue, (boolean)this.bCaptionOnTop));
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONCSSCLASS)) != null) {
            this.setCaptionCssClass(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONWIDTH)) != null) {
            this.setCaptionWidth(DPBaseFormItemConfig.GetValue((String)strValue, (int)this.nCaptionWidth));
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONEXTSTYLE)) != null) {
            this.setCaptionExtStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_AUTOERRORREGION)) != null) {
            this.setAutoErrorRegion(DPBaseFormItemConfig.GetValue((String)strValue, (boolean)this.bAutoErrorRegion));
        }
        if ((strValue = attrMap.remove(TAG_TIPS)) != null) {
            this.setTips(strValue);
        }
        if ((strValue = attrMap.remove(TAG_TIPSID)) != null) {
            this.setTipsId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DVT)) != null) {
            this.setDVT(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DV)) != null) {
            this.setDV(strValue);
        }
        if ((strValue = attrMap.remove(TAG_SHOWCAPTION)) != null) {
            this.setShowCaption(DPBaseFormItemConfig.GetValue((String)strValue, (boolean)this.bShowCaption));
        }
        if ((strValue = attrMap.remove(TAG_ENABLECOND)) != null) {
            this.setEnableCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_RESETCOND)) != null) {
            this.setResetCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_PROCESSCOND)) != null) {
            this.setProcessCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ALLOWEMPTYCOND)) != null) {
            this.setAllowEmptyCond(strValue);
        }
        if ((strValue = attrMap.remove(TAG_FORMITEMSTYLE)) != null) {
            this.setFormItemStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_FORMITEMXML)) != null) {
            this.setFormItemXML(strValue);
        }
        if ((strValue = attrMap.remove(TAG_UNIT)) != null) {
            this.setUnit(strValue);
        }
        if ((strValue = attrMap.remove(TAG_UNITWIDTH)) != null) {
            this.setUnitWidth(DPBaseFormItemConfig.GetValue((String)strValue, (int)this.getUnitWidth()));
        }
        if ((strValue = attrMap.remove(TAG_CAPTIONCONTAINERSTYLE)) != null) {
            this.setCaptionContainerStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CTRLCONTAINERSTYLE)) != null) {
            this.setCtrlContainerStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_EXTSTYLE)) != null) {
            this.setExtStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_FIUPDATEMODE)) != null) {
            this.setFIUpdateMode(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public boolean getCaptionOnTop() {
        return this.bCaptionOnTop;
    }

    public void setCaptionOnTop(boolean bCaptionOnTop) {
        this.bCaptionOnTop = bCaptionOnTop;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setCaptionWidth(int nCaptionWidth) {
        this.nCaptionWidth = nCaptionWidth;
    }

    public int getCaptionWidth() {
        if (this.nCaptionWidth == 0 && this.getParentGroupConfig() != null) {
            return this.getParentGroupConfig().getCaptionWidth();
        }
        return this.nCaptionWidth;
    }

    public void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public void setAutoErrorRegion(boolean bAutoErrorRegion) {
        this.bAutoErrorRegion = bAutoErrorRegion;
    }

    public boolean getAutoErrorRegion() {
        return this.bAutoErrorRegion;
    }

    public void setSyncControlConfig(boolean bSyncControlConfig) {
        this.bSyncControlConfig = bSyncControlConfig;
    }

    public boolean getSyncControlConfig() {
        return this.bSyncControlConfig;
    }

    public void setCaptionExtStyle(String strCaptionExtStyle) {
        this.strCaptionExtStyle = strCaptionExtStyle;
    }

    public String getCaptionExtStyle() {
        return this.strCaptionExtStyle;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getTipsId() {
        return this.strTipsId;
    }

    public void setTipsId(String strTipsId) {
        this.strTipsId = strTipsId;
    }

    public BaseControlConfig getCtrlConfig() {
        return this.ctrlConfig;
    }

    public void setCtrlConfig(BaseControlConfig ctrlConfig) {
        this.ctrlConfig = ctrlConfig;
    }

    @Override
    protected void OnGetFormCtrlConfig(ArrayList list) {
        super.OnGetFormCtrlConfig(list);
        if (this.ctrlConfig != null) {
            list.add(this);
        }
    }

    public String getDVT() {
        return this.strDVT;
    }

    public void setDVT(String strDVT) {
        this.strDVT = strDVT;
    }

    public String getDV() {
        return this.strDV;
    }

    public void setDV(String strDV) {
        this.strDV = strDV;
    }

    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    public void setShowCaption(boolean showCaption) {
        this.bShowCaption = showCaption;
    }

    public String getEnableCond() {
        return this.strEnableCond;
    }

    public void setEnableCond(String strEnableCond) {
        this.strEnableCond = strEnableCond;
    }

    public String getProcessCond() {
        return this.strProcessCond;
    }

    public void setProcessCond(String strProcessCond) {
        this.strProcessCond = strProcessCond;
    }

    public String getFormItemStyle() {
        return this.strFormItemStyle;
    }

    public void setFormItemStyle(String strFormItemStyle) {
        this.strFormItemStyle = strFormItemStyle;
    }

    public String getFormItemXML() {
        return this.strFormItemXML;
    }

    public void setFormItemXML(String strFormItemXML) {
        this.strFormItemXML = strFormItemXML;
    }

    public String getResetCond() {
        return this.strResetCond;
    }

    public void setResetCond(String strResetCond) {
        this.strResetCond = strResetCond;
    }

    public String getUnit() {
        return this.strUnit;
    }

    public void setUnit(String strUnit) {
        this.strUnit = strUnit;
    }

    public int getUnitWidth() {
        return this.nUnitWidth;
    }

    public void setUnitWidth(int unitWidth) {
        this.nUnitWidth = unitWidth;
        if (this.nUnitWidth < 0) {
            this.nUnitWidth = 0;
        }
    }

    public String getAllowEmptyCond() {
        return this.strAllowEmptyCond;
    }

    public void setAllowEmptyCond(String strEmptyCond) {
        this.strAllowEmptyCond = strEmptyCond;
    }

    public String getCaptionContainerStyle() {
        return this.strCaptionContainerStyle;
    }

    public String getCtrlContainerStyle() {
        return this.strCtrlContainerStyle;
    }

    public void setCaptionContainerStyle(String strCaptionContainerStyle) {
        this.strCaptionContainerStyle = strCaptionContainerStyle;
    }

    public void setCtrlContainerStyle(String strCtrlContainerStyle) {
        this.strCtrlContainerStyle = strCtrlContainerStyle;
    }

    public String getExtStyle() {
        return this.strExtStyle;
    }

    public void setExtStyle(String strExtStyle) {
        this.strExtStyle = strExtStyle;
    }

    public String getFIUpdateMode() {
        return this.strFIUpdateMode;
    }

    public void setFIUpdateMode(String strFIUpdateMode) {
        this.strFIUpdateMode = strFIUpdateMode;
    }
}

