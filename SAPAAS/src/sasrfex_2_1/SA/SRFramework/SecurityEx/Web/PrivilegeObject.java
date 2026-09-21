/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.SecurityEx.Web;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;

public class PrivilegeObject {
    protected String strResourceId;
    protected String strResourceName;
    protected String strResourceType;
    protected String strCurPageName = "";
    protected String strCurPagePath = "";
    protected ArrayList childObjects = new ArrayList();

    public String getResourceId() {
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    public String getResourceName() {
        return this.strResourceName;
    }

    public void setResourceName(String strResourceName) {
        this.strResourceName = strResourceName;
    }

    public String getResourceType() {
        return this.strResourceType;
    }

    public void setResourceType(String strResourceType) {
        this.strResourceType = strResourceType;
    }

    public String getCurPageName() {
        return this.strCurPageName;
    }

    public void setCurPageName(String strCurPageName) {
        this.strCurPageName = strCurPageName;
    }

    public String getCurPagePath() {
        return this.strCurPagePath;
    }

    public void setCurPagePath(String strCurPagePath) {
        this.strCurPagePath = strCurPagePath;
    }

    public ArrayList getChilds() {
        return this.childObjects;
    }

    public PrivilegeObject FindPage(String strCurPagePath, String strCurPageName) {
        if ((StringHelper.Compare((String)this.strResourceType, (String)"DIALOGPAGE", (boolean)true) == 0 || StringHelper.Compare((String)this.strResourceType, (String)"MAINPAGE", (boolean)true) == 0 || StringHelper.Compare((String)this.strResourceType, (String)"SUBPAGE", (boolean)true) == 0) && this.strCurPagePath.indexOf(strCurPagePath = strCurPagePath.replace("../", "")) != -1) {
            return this;
        }
        int nCount = this.childObjects.size();
        int i = 0;
        while (i < nCount) {
            PrivilegeObject childObject = (PrivilegeObject)this.childObjects.get(i);
            PrivilegeObject findObject = childObject.FindPage(strCurPagePath, strCurPageName);
            if (findObject != null) {
                return findObject;
            }
            ++i;
        }
        return null;
    }

    public PrivilegeObject FindButton(String strResourceId) {
        int nCount = this.childObjects.size();
        int i = 0;
        while (i < nCount) {
            PrivilegeObject childObject = (PrivilegeObject)this.childObjects.get(i);
            if (StringHelper.Compare((String)childObject.getResourceType(), (String)"BUTTON", (boolean)true) == 0 && StringHelper.Compare((String)childObject.getResourceId(), (String)strResourceId, (boolean)true) == 0) {
                return childObject;
            }
            ++i;
        }
        return null;
    }
}

