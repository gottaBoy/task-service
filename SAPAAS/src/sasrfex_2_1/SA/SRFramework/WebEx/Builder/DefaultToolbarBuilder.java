/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Builder.ToolbarBuilder;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import java.io.Writer;
import java.util.Iterator;

public class DefaultToolbarBuilder
extends ToolbarBuilder {
    @Override
    public void Render(Writer writer, SRFExToolbar toolbar) {
        try {
            ToolbarConfig toolbarConfig = toolbar.getToolbarConfig();
            if (StringHelper.IsNullOrEmpty((String)toolbarConfig.getContainer())) {
                StyleBuilder styleBuilder = new StyleBuilder();
                if (toolbarConfig.getWidth() > 0) {
                    styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)toolbarConfig.getWidth()));
                }
                if (toolbarConfig.getHeight() > 0) {
                    styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)toolbarConfig.getHeight()));
                }
                writer.write("<DIV");
                DefaultToolbarBuilder.OutputAttribute(writer, "id", toolbar.getUniqueID());
                DefaultToolbarBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + toolbarConfig.getExtStyle());
                writer.write(" >");
                writer.write("</DIV>");
            }
            IUserPrivilegeMgr iUserPrivilegeMgr = toolbar.getPage().getWebContext().GetUserPrivilegeMgr();
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var tb=new Ext.Toolbar();\r\n");
            if (StringHelper.IsNullOrEmpty((String)toolbarConfig.getContainer())) {
                script.Append("tb.render('%1$s');\r\n", toolbar.getUniqueID());
            } else {
                script.Append("tb.render('%1$s');\r\n", toolbarConfig.getContainer());
            }
            if (!StringHelper.IsNullOrEmpty((String)toolbar.getToolbarConfig().getCssClass())) {
                script.Append("tb.getEl().addClass('%1$s');\r\n", toolbar.getToolbarConfig().getCssClass());
            }
            script.Append("$P.toolbar['%1$s']=tb;\r\n", toolbar.getUniqueID());
            toolbar.getWebContext().SetParamValue("%TOOLBARID%", toolbar.getUniqueID());
            String strTotalTBCode = "";
            ToolbarItemsConfig toolbarItemsConfig = toolbar.getToolbarConfig().getToolbarItemsConfig();
            Iterator iterator = toolbarItemsConfig.iterator();
            while (iterator.hasNext()) {
                String strTBCode;
                BaseToolbarItemConfig baseToolbarItemConfig = (BaseToolbarItemConfig)((Object)iterator.next());
                boolean bNoRight = false;
                String strResourceId = baseToolbarItemConfig.getResourceId();
                if (iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(toolbar.getPage().getWebContext(), strResourceId)) {
                    bNoRight = true;
                }
                if (StringHelper.IsNullOrEmpty((String)(strTBCode = baseToolbarItemConfig.GetJSCode(toolbar.getWebContext(), toolbar.getToolbarObject(baseToolbarItemConfig.getObject()), bNoRight)))) continue;
                if (!StringHelper.IsNullOrEmpty((String)strTotalTBCode)) {
                    strTotalTBCode = String.valueOf(strTotalTBCode) + ",";
                }
                strTotalTBCode = String.valueOf(strTotalTBCode) + strTBCode;
            }
            if (!StringHelper.IsNullOrEmpty((String)strTotalTBCode)) {
                script.Append("tb.add(%1$s);\r\n", strTotalTBCode);
            }
            script.Append("if(Ext.isFunction(tb.doLayout)){tb.doLayout(undefined,true);}\r\n");
            script.Append("delete tb;\r\n");
            toolbar.getWebContext().SetParamValue("%TOOLBARID%", "");
            toolbar.getPage().RegisterOnReadyScript(2, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

