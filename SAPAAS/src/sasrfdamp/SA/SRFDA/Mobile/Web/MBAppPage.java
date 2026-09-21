/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Mobile.Panel.BaseMobilePanel;
import SA.SRFDA.Mobile.Panel.IMobilePanel;
import SA.SRFDA.Mobile.UIPart.DefaultMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Mobile.Web.BaseMBPanelPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.File;
import java.util.TreeMap;
import java.util.Vector;

public class MBAppPage
extends BaseMBPanelPage {
    private String strOutputHeader = "";

    protected void OnInit() {
        super.OnInit();
        try {
            IMobilePanel mobilePanel = BaseMobilePanel.CreateMobilePanel((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getDEHelper(), this.mbPanel);
            Vector<IMobileUIPart> mobileUIParts = new Vector<IMobileUIPart>();
            mobilePanel.GetRelatedUIParts(mobileUIParts);
            mobileUIParts.add(0, mobilePanel);
            DefaultMobilePublishContext publishContext = new DefaultMobilePublishContext();
            publishContext.setWebContext((ISRFDAWebContext)this.getWebContext());
            publishContext.setAlwaysCreate(true);
            String strRunTimeFolder = "js_runtime" + File.separator;
            publishContext.setRuntimeFolder(String.valueOf(this.getWebContext().getGlobalHelper().GetAppRootPath()) + strRunTimeFolder);
            for (IMobileUIPart mobileUIPart : mobileUIParts) {
                publishContext.RegisterUIPart(mobileUIPart);
            }
            for (IMobileUIPart mobileUIPart : mobileUIParts) {
                mobileUIPart.PreparePublish(publishContext);
            }
            for (IMobileUIPart mobileUIPart : mobileUIParts) {
                mobileUIPart.Publish(publishContext);
            }
            StringBuilderEx sb = new StringBuilderEx();
            TreeMap<String, String> fileMap = new TreeMap<String, String>();
            if (publishContext.getCSSFiles().size() > 0) {
                for (String strFileName : publishContext.getCSSFiles()) {
                    fileMap.put(strFileName, "");
                }
                for (String strFileName : fileMap.keySet()) {
                    sb.Append("<LINK href=\"../js_runtime/%1$s\" type=\"text/css\" rel=\"stylesheet\"> \r\n", (Object)strFileName);
                }
            }
            if (publishContext.getJSFiles().size() > 0) {
                fileMap.clear();
                for (String strFileName : publishContext.getJSFiles()) {
                    fileMap.put(strFileName, "");
                }
                for (String strFileName : fileMap.keySet()) {
                    sb.Append("<script type=\"text/javascript\" src=\"../js_runtime/%1$s\"></script>\r\n", (Object)strFileName);
                }
            }
            sb.Append("<script type=\"text/javascript\">\r\n");
            sb.Append("Ext.setup({\r\n");
            sb.Append("tabletStartupScreen: 'tablet_startup.png',\r\n");
            sb.Append("phoneStartupScreen: 'phone_startup.png',\r\n");
            sb.Append("icon: 'icon.png',\r\n");
            sb.Append("glossOnIcon: false,\r\n");
            sb.Append("onReady: function() {\r\n");
            sb.Append("var topPanel= new %1$s.%2$s({fullscreen: true});\r\n", (Object)"sasrfmb", (Object)mobilePanel.getUniqueName());
            sb.Append("topPanel.show();\r\n");
            sb.Append("   }\r\n");
            sb.Append("});\r\n");
            sb.Append("</script>\r\n");
            this.strOutputHeader = sb.toString();
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage(), ex);
        }
    }

    protected String OnGetPageHeaderContent() {
        String strPageHeader = super.OnGetPageHeaderContent();
        if (StringHelper.IsNullOrEmpty((String)strPageHeader)) {
            return this.strOutputHeader;
        }
        return String.valueOf(strPageHeader) + "\r\n" + this.strOutputHeader;
    }
}

