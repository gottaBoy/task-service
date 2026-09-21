/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.ISRFExNavigateHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import SA.SRFramework.WebEx.UI.NavigateItem;
import SA.SRFramework.WebEx.UI.NavigateMgr;

public class NavigateBarHelper {
    public static String TAG_NAVIGATEBAR = "SRFEXNAVIGATEBAR";

    public static boolean Register(SRFExPage curPage, MenuItemExConfig menuItemExConfig) {
        if (menuItemExConfig == null) {
            return false;
        }
        NavigateMgr navigateMgr = null;
        Object obj = curPage.getPageContext().getSession().getAttribute(TAG_NAVIGATEBAR);
        if (obj != null && obj instanceof NavigateMgr) {
            navigateMgr = (NavigateMgr)obj;
        } else {
            navigateMgr = new NavigateMgr();
            curPage.getPageContext().getSession().setAttribute(TAG_NAVIGATEBAR, (Object)navigateMgr);
        }
        if (navigateMgr == null) {
            return false;
        }
        NavigateItem item = null;
        if (StringHelper.Length((String)menuItemExConfig.getNavigateHelper()) > 0) {
            Object objHelper = ObjectHelper.Create(menuItemExConfig.getNavigateHelper());
            if (objHelper == null) {
                return false;
            }
            if (objHelper instanceof ISRFExNavigateHelper) {
                ISRFExNavigateHelper iNavigateHelper = (ISRFExNavigateHelper)objHelper;
                item = iNavigateHelper.GetNavigateItem(curPage, menuItemExConfig);
            } else {
                return false;
            }
        }
        if (item == null) {
            item = new NavigateItem();
        }
        String strLink = curPage.getWebContext().getCurPagePath();
        String strQueryString = curPage.getWebContext().GetQueryString();
        if (StringHelper.Length((String)strQueryString) > 0) {
            strLink = String.valueOf(strLink) + "?";
            strLink = String.valueOf(strLink) + strQueryString;
        }
        strLink = ".." + strLink;
        item.setCaption(menuItemExConfig.getCaption());
        item.setTips(menuItemExConfig.getTips());
        item.setURL(strLink);
        navigateMgr.AddItem(item);
        return true;
    }

    public static NavigateMgr GetNavigateMgr(SRFExPage curPage) {
        NavigateMgr navigateMgr = null;
        Object obj = curPage.getPageContext().getSession().getAttribute(TAG_NAVIGATEBAR);
        if (obj != null && obj instanceof NavigateMgr) {
            navigateMgr = (NavigateMgr)obj;
        }
        return navigateMgr;
    }
}

