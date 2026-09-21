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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import org.w3c.dom.Node;

public class UIStyleConfig
extends XMLConfig {
    public static final String TAG_UISTYLE = "SRFEXUISTYLE";
    protected ArrayList childUIStyles = null;

    public void FillParamList(HashMap<String, String> paramList) {
        if (paramList == null || this.extAttrList == null) {
            return;
        }
        Enumeration en = this.extAttrList.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            if (paramList.containsKey(strKey)) continue;
            paramList.put(strKey, (String)this.extAttrList.get(strKey));
        }
    }

    public static boolean IsGlobalId(String strUIStyleId) {
        if (StringHelper.Length((String)strUIStyleId) > 0) {
            return strUIStyleId.indexOf(".") == 0;
        }
        return false;
    }

    public static ArrayList GetIds(String strUIStyleId) {
        int nPos;
        if (StringHelper.Length((String)strUIStyleId) == 0) {
            return null;
        }
        ArrayList<String> arrList = new ArrayList<String>();
        while ((nPos = strUIStyleId.indexOf(".")) != -1) {
            String strPartA = strUIStyleId.substring(0, nPos);
            if (StringHelper.Length((String)strPartA) > 0) {
                arrList.add(strPartA);
            }
            strUIStyleId = strUIStyleId.substring(nPos + 1);
        }
        if (StringHelper.Length((String)strUIStyleId) > 0) {
            arrList.add(strUIStyleId);
        }
        String[] strList = new String[arrList.size()];
        arrList.toArray(strList);
        return arrList;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_UISTYLE, (boolean)true) == 0) {
            UIStyleConfig uiStyleConfig = new UIStyleConfig();
            if (uiStyleConfig.LoadConfig(xmlNode)) {
                if (this.childUIStyles == null) {
                    this.childUIStyles = new ArrayList();
                }
                this.childUIStyles.add(uiStyleConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public UIStyleConfig GetUIStyleByPos(int nPos) {
        if (this.childUIStyles == null || nPos < 0 || nPos >= this.childUIStyles.size()) {
            return null;
        }
        return (UIStyleConfig)((Object)this.childUIStyles.get(nPos));
    }

    public UIStyleConfig GetUIStyleById(String strUIStyleId) {
        return this.GetUIStyleById(UIStyleConfig.GetIds(strUIStyleId));
    }

    public UIStyleConfig GetUIStyleById(ArrayList arr) {
        if (arr == null) {
            return null;
        }
        if (this.childUIStyles == null) {
            return null;
        }
        String strId = (String)arr.get(0);
        arr.remove(0);
        int i = 0;
        while (i < this.childUIStyles.size()) {
            UIStyleConfig uiStyleConfig = (UIStyleConfig)((Object)this.childUIStyles.get(i));
            if (StringHelper.Compare((String)uiStyleConfig.getID(), (String)strId, (boolean)true) == 0) {
                if (arr.size() == 0) {
                    return uiStyleConfig;
                }
                return this.GetUIStyleById(arr);
            }
            ++i;
        }
        return null;
    }
}

