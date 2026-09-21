/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLConfig;
import java.util.TreeMap;

public abstract class DGExBaseCellConfig
extends XMLConfig {
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_VALIGN = "VALIGN";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_BORDER = "BORDER";
    public static final String TAG_LASTBORDER = "LASTBORDER";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_EXTSTYLE = "EXTSTYLE";
    public static final String TAG_BORDER_LEFT = "LEFT";
    public static final String TAG_BORDER_TOP = "TOP";
    public static final String TAG_BORDER_RIGHT = "RIGHT";
    public static final String TAG_BORDER_BOTTOM = "BOTTOM";
    public static final String TAG_BORDER_ALL = "ALL";
    public static final String TAG_BORDER_NONE = "NONE";
    private static final int HASHCODE_ALIGN = "ALIGN".hashCode();
    private static final int HASHCODE_VALIGN = "VALIGN".hashCode();
    private static final int HASHCODE_WIDTH = "WIDTH".hashCode();
    private static final int HASHCODE_HEIGHT = "HEIGHT".hashCode();
    private static final int HASHCODE_BORDER = "BORDER".hashCode();
    private static final int HASHCODE_LASTBORDER = "LASTBORDER".hashCode();
    private static final int HASHCODE_CSSCLASS = "CSSCLASS".hashCode();
    private static final int HASHCODE_EXTSTYLE = "EXTSTYLE".hashCode();
    public static final int BORDER_NONE = 0;
    public static final int BORDER_LEFT = 1;
    public static final int BORDER_TOP = 2;
    public static final int BORDER_RIGHT = 4;
    public static final int BORDER_BOTTOM = 8;
    public static final int BORDER_ALL = 15;
    private static TreeMap<String, Integer> borderValueMap = new TreeMap();
    protected String strAlign = "";
    protected String strVAlign = "";
    protected int nWidth = 0;
    protected int nHeight = 0;
    protected int nBorder = 0;
    protected int nLastBorder = 0;
    protected String strCssClass = "";
    protected String strExtStyle = "";

    static {
        borderValueMap.put(TAG_BORDER_LEFT, 1);
        borderValueMap.put(TAG_BORDER_TOP, 2);
        borderValueMap.put(TAG_BORDER_RIGHT, 4);
        borderValueMap.put(TAG_BORDER_BOTTOM, 8);
        borderValueMap.put(TAG_BORDER_ALL, 15);
    }

    protected void OnSetProperty(String strName, String strValue) {
        int nHashCode = strName.hashCode();
        if (nHashCode == HASHCODE_ALIGN) {
            this.setAlign(strValue);
            return;
        }
        if (nHashCode == HASHCODE_VALIGN) {
            this.setVAlign(strValue);
            return;
        }
        if (nHashCode == HASHCODE_WIDTH) {
            this.setWidth(DGExBaseCellConfig.GetValue((String)strValue, (int)this.getWidth()));
            return;
        }
        if (nHashCode == HASHCODE_HEIGHT) {
            this.setHeight(DGExBaseCellConfig.GetValue((String)strValue, (int)this.getHeight()));
            return;
        }
        if (nHashCode == HASHCODE_CSSCLASS) {
            this.setCssClass(strValue);
            return;
        }
        if (nHashCode == HASHCODE_EXTSTYLE) {
            this.setExtStyle(strValue);
            return;
        }
        if (nHashCode == HASHCODE_BORDER) {
            this.nBorder = 0;
            strValue = strValue.toUpperCase();
            String[] border = strValue.split("[|]");
            int i = 0;
            while (i < border.length) {
                if (borderValueMap.containsKey(border[i])) {
                    this.nBorder |= borderValueMap.get(border[i]).intValue();
                }
                ++i;
            }
            return;
        }
        if (nHashCode == HASHCODE_LASTBORDER) {
            this.nLastBorder = 0;
            strValue = strValue.toUpperCase();
            String[] border = strValue.split("[|]");
            int i = 0;
            while (i < border.length) {
                if (borderValueMap.containsKey(border[i])) {
                    this.nLastBorder |= borderValueMap.get(border[i]).intValue();
                }
                ++i;
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getAlign() {
        return this.strAlign;
    }

    public String getVAlign() {
        return this.strVAlign;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public void setVAlign(String strVAlign) {
        this.strVAlign = strVAlign;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    public int getBorder() {
        return this.nBorder;
    }

    public void setBorder(int nBorder) {
        this.nBorder = nBorder;
    }

    public int getLastBorder() {
        return this.nLastBorder;
    }

    public void setLastBorder(int nLastBorder) {
        this.nLastBorder = nLastBorder;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public String getExtStyle() {
        return this.strExtStyle;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public void setExtStyle(String strExtStyle) {
        this.strExtStyle = strExtStyle;
    }
}

