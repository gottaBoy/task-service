/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.UIStyleConfig;
import java.util.Enumeration;
import java.util.Hashtable;

public class ControlConfigContext {
    protected UIStyleConfig parentUIStyleConfig = null;
    protected BaseControlConfig parentConfig = null;
    protected Hashtable paramList = null;
    protected UIStyleConfig globalUIStyleConfig = null;
    protected UIStyleConfig curUIStyleConfig = null;

    public UIStyleConfig getParentUIStyle() {
        return this.parentUIStyleConfig;
    }

    public void setParentUIStyle(UIStyleConfig uiStyleConfig) {
        this.parentUIStyleConfig = uiStyleConfig;
    }

    public UIStyleConfig getGlobalUIStyle() {
        return this.globalUIStyleConfig;
    }

    public void setGlobalUIStyle(UIStyleConfig uiStyleConfig) {
        this.globalUIStyleConfig = uiStyleConfig;
    }

    public UIStyleConfig getCurUIStyle() {
        return this.curUIStyleConfig;
    }

    public void setCurUIStyle(UIStyleConfig uiStyleConfig) {
        this.curUIStyleConfig = uiStyleConfig;
    }

    public BaseControlConfig getParent() {
        return this.parentConfig;
    }

    public void setParent(BaseControlConfig parentConfig) {
        this.parentConfig = parentConfig;
    }

    public ControlConfigContext Clone() {
        ControlConfigContext configContext = new ControlConfigContext();
        configContext.setParentUIStyle(this.parentUIStyleConfig);
        configContext.setGlobalUIStyle(this.globalUIStyleConfig);
        configContext.setCurUIStyle(this.curUIStyleConfig);
        configContext.setParent(this.parentConfig);
        if (this.paramList != null) {
            Enumeration en = this.paramList.keys();
            while (en.hasMoreElements()) {
                Object objKey = en.nextElement();
                configContext.setParam(objKey.toString(), this.paramList.get(objKey));
            }
        }
        return configContext;
    }

    public void FromParamList(Hashtable paramList) {
        this.paramList = null;
        if (paramList != null && paramList.size() > 0) {
            this.paramList = new Hashtable();
            Enumeration en = paramList.keys();
            while (en.hasMoreElements()) {
                Object objKey = en.nextElement();
                this.paramList.put(objKey, paramList.get(objKey));
            }
        }
    }

    public Hashtable getParamList() {
        return this.paramList;
    }

    public Object getParam(String strParamName) {
        if (this.paramList == null) {
            return null;
        }
        strParamName = strParamName.toUpperCase();
        return this.paramList.get(strParamName);
    }

    public int getParamInt(String strParamName, int nDefault) {
        Object objValue = this.getParam(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        if (objValue instanceof Integer) {
            return (Integer)objValue;
        }
        return nDefault;
    }

    public void setParam(String strParamName, Object objValue) {
        if (objValue == null) {
            return;
        }
        if (this.paramList == null) {
            this.paramList = new Hashtable();
        }
        strParamName = strParamName.toUpperCase();
        this.paramList.put(strParamName, objValue);
    }

    public void RemoveParam(String strParamName) {
        if (this.paramList == null) {
            return;
        }
        strParamName = strParamName.toUpperCase();
        this.paramList.remove(strParamName);
    }
}

