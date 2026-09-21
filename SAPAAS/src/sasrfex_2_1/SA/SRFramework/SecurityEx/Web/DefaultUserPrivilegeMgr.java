/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.SecurityEx.Web;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.SecurityEx.Web.PrivilegeObject;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExBaseButton;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.XML.XmlWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class DefaultUserPrivilegeMgr
implements IUserPrivilegeMgr,
Serializable {
    private static final long serialVersionUID = -7101083258395847302L;
    public static final int MAXUNITCOUNT = 300;
    protected Hashtable resourceList = null;
    protected PrivilegeObject rootObject = null;
    protected PrivilegeObject activePageObject = null;
    protected HashMap<String, Integer> columnList = new HashMap();

    @Override
    public synchronized void Reset(SRFExWebContext webContext) {
        this.resourceList = null;
    }

    @Override
    public synchronized void Reset() {
        this.resourceList = null;
    }

    @Override
    public synchronized boolean Test(SRFExWebContext webContext, String strResourceId) {
        if (StringHelper.Length((String)webContext.getCurUserId()) == 0) {
            return false;
        }
        strResourceId = strResourceId.toUpperCase();
        if (this.resourceList != null && this.resourceList.containsKey(strResourceId)) {
            return (Boolean)this.resourceList.get(strResourceId);
        }
        boolean bRet = this.InternalTest(webContext, strResourceId);
        if (this.resourceList == null) {
            this.resourceList = new Hashtable();
        } else if (this.resourceList.size() >= 300) {
            this.resourceList.clear();
        }
        this.resourceList.put(strResourceId, bRet);
        return bRet;
    }

    @Override
    public synchronized void LogTest(SRFExWebContext webContext, Object object, String strResourceId) {
        this.InternalLogTest(webContext, object, strResourceId);
    }

    protected synchronized boolean InternalTest(SRFExWebContext webContext, String strResourceId) {
        return true;
    }

    protected synchronized void InternalLogTest(SRFExWebContext webContext, Object object, String strResourceId) {
        String strCurPageName = webContext.getCurPageName();
        String strCurPagePath = webContext.getCurPagePath();
        if (strCurPageName.indexOf("backend.jsp") != -1) {
            return;
        }
        if (strCurPagePath.indexOf("commonex/") != -1) {
            return;
        }
        if (strCurPagePath.indexOf("include/") != -1) {
            return;
        }
        if (object instanceof SRFExPage) {
            SRFExPage page = (SRFExPage)object;
            if (page.getMainPage()) {
                if (this.rootObject != null) {
                    if (StringHelper.Compare((String)this.rootObject.getCurPagePath(), (String)strCurPagePath, (boolean)true) != 0) {
                        this.LogPrivilegeObject(this.rootObject);
                        this.rootObject = null;
                        this.activePageObject = null;
                    } else {
                        return;
                    }
                }
                this.rootObject = null;
                this.rootObject = new PrivilegeObject();
                this.rootObject.setResourceId(strResourceId);
                this.activePageObject = this.rootObject;
                if (webContext.getDialogMode()) {
                    this.rootObject.setResourceType("DIALOGPAGE");
                    this.rootObject.setResourceName(String.valueOf(strCurPageName) + "[dialog]");
                } else {
                    this.rootObject.setResourceType("MAINPAGE");
                    this.rootObject.setResourceName(String.valueOf(strCurPageName) + "[mainview]");
                }
            } else {
                if (this.rootObject == null) {
                    return;
                }
                PrivilegeObject subPage = this.rootObject.FindPage(strCurPageName, "");
                if (subPage == null) {
                    subPage = new PrivilegeObject();
                    subPage.setResourceType("SUBPAGE");
                    subPage.setResourceName(String.valueOf(strCurPageName) + "[subview]");
                    if (this.activePageObject != null) {
                        this.activePageObject.getChilds().add(subPage);
                    } else {
                        this.rootObject.getChilds().add(subPage);
                    }
                }
                subPage.setResourceId(strResourceId);
                subPage.setCurPageName(strCurPageName);
                if (subPage.getCurPagePath().indexOf("../") != -1) {
                    subPage.setCurPagePath(strCurPagePath);
                } else if (StringHelper.Length((String)subPage.getCurPagePath()) < StringHelper.Length((String)strCurPagePath)) {
                    subPage.setCurPagePath(strCurPagePath);
                }
                this.activePageObject = subPage;
                return;
            }
            this.rootObject.setCurPageName(strCurPageName);
            this.rootObject.setCurPagePath(strCurPagePath);
            return;
        }
        if (object instanceof SRFExTabView) {
            SRFExTabView tabView = (SRFExTabView)object;
            PrivilegeObject subPage = this.rootObject.FindPage(strCurPageName, "");
            if (subPage == null) {
                subPage = new PrivilegeObject();
                subPage.setResourceId(strResourceId);
                subPage.setResourceType("SUBPAGE");
                subPage.setResourceName(String.valueOf(strCurPageName) + "[subview]");
                if (this.activePageObject != null) {
                    this.activePageObject.getChilds().add(subPage);
                } else {
                    this.rootObject.getChilds().add(subPage);
                }
            }
            int i = 0;
            while (i < tabView.getTabViewConfig().getTabViewPages().size()) {
                TabViewPageConfig tabViewPageConfig = (TabViewPageConfig)((Object)tabView.getTabViewConfig().getTabViewPages().get(i));
                String strPagePath = tabViewPageConfig.getRemoteURL();
                String strTabViewResourceId = tabViewPageConfig.getResourceId();
                PrivilegeObject tabPage = new PrivilegeObject();
                tabPage.setResourceId(strTabViewResourceId);
                tabPage.setResourceType("SUBPAGE");
                String strPageName = strPagePath;
                int nPos = strPageName.lastIndexOf("/");
                if (nPos != -1 && strPageName.length() - 1 > nPos) {
                    strPageName = strPageName.substring(nPos + 1);
                }
                if ((nPos = strPageName.lastIndexOf("?")) != -1) {
                    strPageName = strPageName.substring(0, nPos);
                }
                if ((nPos = strPagePath.lastIndexOf("?")) != -1) {
                    strPagePath = strPagePath.substring(0, nPos);
                }
                tabPage.setResourceName(String.valueOf(strPageName) + tabViewPageConfig.getCaption() + "[subview]");
                tabPage.setCurPagePath(strPagePath);
                subPage.getChilds().add(tabPage);
                ++i;
            }
            return;
        }
        if (object instanceof SRFExBaseButton) {
            SRFExBaseButton button = (SRFExBaseButton)object;
            PrivilegeObject subPage = this.rootObject.FindPage(strCurPageName, "");
            if (subPage == null) {
                subPage = new PrivilegeObject();
                subPage.setResourceId("");
                subPage.setResourceType("SUBPAGE");
                subPage.setResourceName(String.valueOf(strCurPageName) + "[subview]");
                if (this.activePageObject != null) {
                    this.activePageObject.getChilds().add(subPage);
                } else {
                    this.rootObject.getChilds().add(subPage);
                }
            }
            this.activePageObject = subPage;
            if (subPage.FindButton(strResourceId) != null) {
                return;
            }
            PrivilegeObject buttonObject = new PrivilegeObject();
            buttonObject.setResourceName(String.valueOf(button.getBaseButtonConfig().getText()) + "[button]");
            buttonObject.setResourceId(strResourceId);
            buttonObject.setResourceType("BUTTON");
            subPage.getChilds().add(buttonObject);
            return;
        }
    }

    protected void LogPrivilegeObject(PrivilegeObject privilegeObject) {
        if (privilegeObject == null) {
            return;
        }
        try {
            String path = StringHelper.Format((String)"C:\\TEMP\\%1$s.xml", (Object)privilegeObject.getResourceId());
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(path), "UTF-8");
            out.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
            XmlWriter xmlWriter = new XmlWriter(out);
            this.LogPrivilegeObject(privilegeObject, xmlWriter);
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            return;
        }
    }

    protected void LogPrivilegeObject(PrivilegeObject privilegeObject, XmlWriter xmlWriter) throws Exception {
        xmlWriter.writeEntity("PRIVILEGEOBJECT");
        xmlWriter.writeAttribute("ID", privilegeObject.getResourceId());
        xmlWriter.writeAttribute("NAME", privilegeObject.getResourceName());
        xmlWriter.writeAttribute("TYPE", privilegeObject.getResourceType());
        xmlWriter.writeAttribute("PATH", privilegeObject.getCurPagePath());
        int nCount = privilegeObject.getChilds().size();
        int i = 0;
        while (i < nCount) {
            PrivilegeObject child = (PrivilegeObject)privilegeObject.getChilds().get(i);
            this.LogPrivilegeObject(child, xmlWriter);
            ++i;
        }
        xmlWriter.endEntity();
    }

    @Override
    public boolean Test(SRFExHttpServletContext servletContext, String strResourceId) {
        if (StringHelper.Length((String)servletContext.getCurUserId()) == 0) {
            return false;
        }
        strResourceId = strResourceId.toUpperCase();
        if (this.resourceList != null && this.resourceList.containsKey(strResourceId)) {
            return (Boolean)this.resourceList.get(strResourceId);
        }
        boolean bRet = this.InternalTest(servletContext, strResourceId);
        if (this.resourceList == null) {
            this.resourceList = new Hashtable();
        } else if (this.resourceList.size() >= 300) {
            this.resourceList.clear();
        }
        this.resourceList.put(strResourceId, bRet);
        return bRet;
    }

    protected synchronized boolean InternalTest(SRFExHttpServletContext servletContext, String strResourceId) {
        return true;
    }

    @Override
    public int TestColumn(ISRFExWebContext webContext, String strResourceId) {
        if (StringHelper.IsNullOrEmpty((String)strResourceId)) {
            return 3;
        }
        strResourceId = strResourceId.toUpperCase();
        if (this.columnList != null && this.columnList.containsKey(strResourceId)) {
            return this.columnList.get(strResourceId);
        }
        int nRet = this.InternalTestColumn(webContext, strResourceId);
        if (this.columnList.size() >= 300) {
            this.columnList.clear();
        }
        this.columnList.put(strResourceId, nRet);
        return nRet;
    }

    protected int InternalTestColumn(ISRFExWebContext webContext, String strResourceId) {
        return 3;
    }
}

