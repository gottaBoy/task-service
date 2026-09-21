/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.UIStyleConfig;
import java.util.HashMap;
import java.util.Hashtable;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BaseControlConfig
extends XMLConfig {
    public static final String TAG_ENABLED = "ENABLED";
    public static final String TAG_LEFT = "LEFT";
    public static final String TAG_TOP = "TOP";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_VISIBLE = "VISIBLE";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_RENDERMODE = "RENDERMODE";
    public static final String TAG_EXTSTYLE = "EXTSTYLE";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_ALWAYSOUTPUT = "ALWAYSOUTPUT";
    public static final String TAG_UISTYLE = "UISTYLE";
    public static final String TAG_EXTATTR = "EXTATTR";
    public static final String TAG_MINWIDTH = "MINWIDTH";
    public static final String TAG_MAXWIDTH = "MAXWIDTH";
    public static final String TAG_BORDER = "BORDER";
    protected int nLeft = 0;
    protected int nTop = 0;
    protected double nWidth = 0.0;
    protected double nHeight = 0.0;
    protected boolean bVisible = true;
    protected String strCssClass = "";
    protected String strRenderMode = "";
    protected String strExtStyle = "";
    protected String strExtAttr = "";
    protected boolean bEnabled = true;
    protected String strName = "";
    protected String strConfigId = "";
    protected boolean bAlwaysOutput = false;
    protected boolean bBorder = true;
    protected ControlConfigContext configContext = null;
    protected double nMinWidth = Double.NaN;
    protected double nMaxWidth = Double.NaN;
    protected String strSRFCache = "";

    public String getConfigId() {
        return this.strConfigId;
    }

    public void setConfigId(String strConfigId) {
        this.strConfigId = strConfigId;
    }

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_NAME);
        if (strValue != null) {
            this.strName = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ENABLED)) != null) {
            this.bEnabled = BaseControlConfig.GetValue((String)strValue, (boolean)this.bEnabled);
        }
        if ((strValue = attrMap.remove(TAG_LEFT)) != null) {
            this.nLeft = BaseControlConfig.GetValue((String)strValue, (int)this.nLeft);
        }
        if ((strValue = attrMap.remove(TAG_TOP)) != null) {
            this.nTop = BaseControlConfig.GetValue((String)strValue, (int)this.nTop);
        }
        if ((strValue = attrMap.remove(TAG_WIDTH)) != null) {
            this.nWidth = BaseControlConfig.GetValue((String)strValue, (double)this.nWidth);
        }
        if ((strValue = attrMap.remove(TAG_HEIGHT)) != null) {
            this.nHeight = BaseControlConfig.GetValue((String)strValue, (double)this.nHeight);
        }
        if ((strValue = attrMap.remove(TAG_VISIBLE)) != null) {
            this.bVisible = BaseControlConfig.GetValue((String)strValue, (boolean)this.bVisible);
        }
        if ((strValue = attrMap.remove(TAG_ALWAYSOUTPUT)) != null) {
            this.bAlwaysOutput = BaseControlConfig.GetValue((String)strValue, (boolean)this.bAlwaysOutput);
        }
        if ((strValue = attrMap.remove(TAG_CSSCLASS)) != null) {
            this.strCssClass = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RENDERMODE)) != null) {
            this.strRenderMode = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EXTSTYLE)) != null) {
            this.strExtStyle = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EXTATTR)) != null) {
            this.strExtAttr = strValue;
        }
        if ((strValue = attrMap.remove(TAG_BORDER)) != null) {
            this.bBorder = BaseControlConfig.GetValue((String)strValue, (boolean)this.bBorder);
        }
        if ((strValue = attrMap.remove(TAG_MINWIDTH)) != null) {
            this.nMinWidth = BaseControlConfig.GetValue((String)strValue, (double)this.nMinWidth);
        }
        if ((strValue = attrMap.remove(TAG_MAXWIDTH)) != null) {
            this.nMaxWidth = BaseControlConfig.GetValue((String)strValue, (double)this.nMaxWidth);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public int getLeft() {
        return this.nLeft;
    }

    public void setLeft(int nLeft) {
        this.nLeft = nLeft;
    }

    public int getTop() {
        return this.nTop;
    }

    public void setTop(int nTop) {
        this.nTop = nTop;
    }

    public int getWidth() {
        return (int)this.nWidth;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public int getHeight() {
        return (int)this.nHeight;
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    public double getWidthEx() {
        return this.nWidth;
    }

    public void setWidthEx(double nWidth) {
        this.nWidth = nWidth;
    }

    public double getHeightEx() {
        return this.nHeight;
    }

    public void setHeightEx(double nHeight) {
        this.nHeight = nHeight;
    }

    public double getMinWidth() {
        return this.nMinWidth;
    }

    public void setMinWidth(double nMinWidth) {
        this.nMinWidth = nMinWidth;
    }

    public double getMaxWidth() {
        return this.nMaxWidth;
    }

    public void setMaxWidth(double nMaxWidth) {
        this.nMaxWidth = nMaxWidth;
    }

    public String getWidthString() {
        if (this.nWidth == 0.0) {
            return "";
        }
        if (this.nWidth > 1.0) {
            return StringHelper.Format((String)"%1$spx", (Object)((int)this.nWidth));
        }
        return StringHelper.Format((String)"%1$s%%", (Object)((int)(this.nWidth * 100.0)));
    }

    public String getHeightString() {
        if (this.nHeight == 0.0) {
            return "";
        }
        if (this.nHeight > 1.0) {
            return StringHelper.Format((String)"%1$spx", (Object)((int)this.nHeight));
        }
        return StringHelper.Format((String)"%1$s%%", (Object)((int)(this.nHeight * 100.0)));
    }

    public boolean getVisible() {
        return this.bVisible;
    }

    public void setVisible(boolean bVisible) {
        this.bVisible = bVisible;
    }

    public boolean getAlwaysOutput() {
        return this.bAlwaysOutput;
    }

    public void setAlwaysOutput(boolean bAlwaysOutput) {
        this.bAlwaysOutput = bAlwaysOutput;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public String getRenderMode() {
        return this.strRenderMode;
    }

    public void setRenderMode(String strRenderMode) {
        this.strRenderMode = strRenderMode;
    }

    public String getExtStyle() {
        return this.strExtStyle;
    }

    public void setExtStyle(String strExtStyle) {
        this.strExtStyle = strExtStyle;
    }

    public Hashtable getExtAttributes() {
        return this.extAttrList;
    }

    public synchronized void SetExtAttribute(String strKey, String strValue) {
        if (this.extAttrList == null) {
            this.extAttrList = new Hashtable();
        }
        if ((strKey = strKey.toLowerCase()).compareToIgnoreCase("id") == 0 || strKey.compareToIgnoreCase("name") == 0) {
            return;
        }
        this.extAttrList.put(strKey, strValue);
    }

    public synchronized String GetExtAttribute(String strKey) {
        if (this.extAttrList == null) {
            return "";
        }
        if (this.extAttrList.containsKey(strKey = strKey.toLowerCase())) {
            return (String)this.extAttrList.get(strKey);
        }
        return "";
    }

    public synchronized void RemoveExtAttribute(String strKey) {
        if (this.extAttrList == null) {
            return;
        }
        if (this.extAttrList.containsKey(strKey = strKey.toLowerCase())) {
            this.extAttrList.remove(strKey);
        }
    }

    public synchronized void ClearExtAttributes() {
        if (this.extAttrList == null) {
            return;
        }
        this.extAttrList.clear();
    }

    public boolean getEnabled() {
        return this.bEnabled;
    }

    public void setEnabled(boolean bValue) {
        this.bEnabled = bValue;
    }

    public boolean LoadConfig(Node xmlNode, ControlConfigContext configContext) {
        NodeList nodes;
        this.configContext = configContext;
        this.strNodeName = xmlNode.getNodeName();
        this.strNodeValue = xmlNode.getNodeValue();
        NamedNodeMap attrs = xmlNode.getAttributes();
        if (attrs != null) {
            HashMap<String, String> paramList = new HashMap<String, String>();
            int i = 0;
            while (i < attrs.getLength()) {
                Node attrNode = attrs.item(i);
                if (attrNode != null) {
                    paramList.put(attrNode.getNodeName().toUpperCase(), attrNode.getNodeValue());
                }
                ++i;
            }
            if (this.configContext != null) {
                String strUIStyle = null;
                if (paramList.containsKey(TAG_UISTYLE)) {
                    strUIStyle = paramList.get(TAG_UISTYLE);
                }
                UIStyleConfig uiStyleConfig = null;
                if (strUIStyle == null) {
                    int nChildPos;
                    if (this.configContext.getParentUIStyle() != null && (nChildPos = this.configContext.getParamInt("CHILDPOS", -1)) != -1) {
                        uiStyleConfig = this.configContext.getParentUIStyle().GetUIStyleByPos(nChildPos);
                    }
                } else if (StringHelper.Length((String)strUIStyle) > 0) {
                    if (UIStyleConfig.IsGlobalId(strUIStyle)) {
                        if (this.configContext.getGlobalUIStyle() != null) {
                            uiStyleConfig = this.configContext.getGlobalUIStyle().GetUIStyleById(strUIStyle);
                        }
                    } else if (this.configContext.getParentUIStyle() != null) {
                        uiStyleConfig = this.configContext.getParentUIStyle().GetUIStyleById(strUIStyle);
                    }
                }
                this.configContext.setCurUIStyle(uiStyleConfig);
                if (uiStyleConfig != null) {
                    uiStyleConfig.FillParamList(paramList);
                }
            }
            if (paramList.size() > 0) {
                this.OnSetPropertyEx(paramList);
                for (String strKey : paramList.keySet()) {
                    this.OnSetProperty(strKey, paramList.get(strKey));
                }
            }
        }
        if ((nodes = xmlNode.getChildNodes()) != null) {
            int i = 0;
            while (i < nodes.getLength()) {
                Node childNode = nodes.item(i);
                if (childNode != null) {
                    this.OnLoadNode(childNode.getNodeName().toUpperCase(), childNode);
                }
                ++i;
            }
        }
        this.configContext = null;
        return true;
    }

    public ControlConfigContext getConfigContext() {
        return this.configContext;
    }

    public String getExtAttr() {
        return this.strExtAttr;
    }

    public void setExtAttr(String strExtAttr) {
        this.strExtAttr = strExtAttr;
    }

    public boolean getBorder() {
        return this.bBorder;
    }

    public void setBorder(boolean border) {
        this.bBorder = border;
    }

    public String getSRFCache() {
        return this.strSRFCache;
    }

    public void setSRFCache(String strSRFCache) {
        this.strSRFCache = strSRFCache;
    }

    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        BaseControlConfig obj = (BaseControlConfig)((Object)dst);
        obj.setAlwaysOutput(this.getAlwaysOutput());
        obj.setBorder(this.getBorder());
        obj.setConfigId(this.getConfigId());
        obj.setCssClass(this.getCssClass());
        obj.setEnabled(this.getEnabled());
        obj.setExtAttr(this.getExtAttr());
        obj.setExtStyle(this.getExtStyle());
        obj.setHeightEx(this.getHeightEx());
        obj.setLeft(this.getLeft());
        obj.setName(this.getName());
        obj.setRenderMode(this.getRenderMode());
        obj.setSRFCache(this.getSRFCache());
        obj.setTop(this.getTop());
        obj.setVisible(this.getVisible());
        obj.setWidthEx(this.getWidthEx());
        obj.setMaxWidth(this.getMaxWidth());
        obj.setMinWidth(this.getMinWidth());
    }

    protected Object CreateCloneObject() {
        return new BaseControlConfig();
    }
}

