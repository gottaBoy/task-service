/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuConfig;
import SA.SRFramework.Web.UI.MenuGroupConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.WebContext;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class DefaultPageHelper {
    private MenuConfig menuConfig = null;
    private WebContext webContext = null;

    public void setMConfig(MenuConfig value) {
        this.menuConfig = value;
    }

    public MenuConfig getMConfig() {
        return this.menuConfig;
    }

    public void setCurWebContext(WebContext value) {
        this.webContext = value;
    }

    public String CalcDefaultPage() {
        if (this.menuConfig == null || this.webContext == null) {
            return "";
        }
        for (Object ObjMainMenuConfig : this.menuConfig.getMainMenus()) {
            int curPrivs;
            MainMenuConfig mainMenuConfig = (MainMenuConfig)ObjMainMenuConfig;
            if (StringHelper.Length(mainMenuConfig.getActiveImage()) == 0 || StringHelper.Length(mainMenuConfig.getID()) != 0 && (curPrivs = this.webContext.getCurUserPrivs().GetResPriv(mainMenuConfig.getID())) == 0) continue;
            ArrayList groupList = mainMenuConfig.getMenuGroups();
            int nGroupCount = groupList.size();
            int i = 0;
            while (i < nGroupCount) {
                int privilege;
                MenuGroupConfig menuGroupConfig = (MenuGroupConfig)groupList.get(i);
                if (StringHelper.StringLength(menuGroupConfig.getID()) == 0 || (privilege = this.webContext.getCurUserPrivs().GetResPriv(menuGroupConfig.getID())) != 0) {
                    for (Object objMenuItemConfig : menuGroupConfig.getMenuItemList()) {
                        int privilege2;
                        MenuItemConfig item = (MenuItemConfig)objMenuItemConfig;
                        if (StringHelper.Length(item.getName()) == 0 || StringHelper.StringLength(item.getID()) != 0 && (privilege2 = this.webContext.getCurUserPrivs().GetResPriv(item.getID())) == 0) continue;
                        if (item.getParamList().size() > 0) {
                            ParamConfig paramConfig;
                            boolean bIngore = false;
                            for (Object objParamConfig : item.getParamList()) {
                                paramConfig = (ParamConfig)objParamConfig;
                                Object curValue = DefaultPageHelper.GetParamValue(paramConfig.getID(), this.webContext);
                                if (curValue == null || StringHelper.Length(curValue.toString()) == 0) {
                                    if (!paramConfig.getMust()) continue;
                                    bIngore = true;
                                    break;
                                }
                                if (!paramConfig.getMustNot()) continue;
                                bIngore = true;
                                break;
                            }
                            if (bIngore) continue;
                            Object[] valueObj = new Object[item.getParamList().size()];
                            int j = 0;
                            while (j < valueObj.length) {
                                paramConfig = (ParamConfig)item.getParamList().get(j);
                                Object objTemp = DefaultPageHelper.GetParamValue(paramConfig.getID(), this.webContext);
                                if (objTemp == null) {
                                    objTemp = "";
                                }
                                if (ClassHelper.ContainClass(objTemp.getClass(), String.class)) {
                                    try {
                                        objTemp = URLEncoder.encode(objTemp.toString(), "UTF-8");
                                    }
                                    catch (Exception ex) {
                                        objTemp = "";
                                    }
                                }
                                valueObj[j] = objTemp;
                                ++j;
                            }
                            return DefaultPageHelper.fixAbsolutURL(StringHelper.Format(item.getPath(), valueObj), this.webContext.getPage().getRequest());
                        }
                        return DefaultPageHelper.fixAbsolutURL(item.getPath(), this.webContext.getPage().getRequest());
                    }
                }
                ++i;
            }
        }
        return "";
    }

    private static String fixAbsolutURL(String url, HttpServletRequest request) {
        if (url.startsWith("/")) {
            String context = request.getContextPath();
            url = String.valueOf(context) + url;
        }
        return url;
    }

    protected static Object GetParamValue(String strParamId, Object objContext) {
        Object objValue = null;
        try {
            String propertyMethod = "get" + strParamId.substring(0, 1).toUpperCase() + strParamId.substring(1, strParamId.length());
            Method prop = objContext.getClass().getMethod(propertyMethod, new Class[0]);
            objValue = prop.invoke(objContext, new Object[0]);
            if (objValue == null) {
                objValue = "";
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return "";
        }
        return objValue;
    }
}

