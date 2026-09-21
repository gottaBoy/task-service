/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.DGEx.DGExBuilder;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;

public class DefaultDGExBuilder
extends DGExBuilder {
    @Override
    public void Render(Writer writer, SRFExDGEx dgEx) {
        try {
            DGExConfig dgExConfig = dgEx.getDGExConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", dgExConfig.getWidthString());
            styleBuilder.AddStyle("height", dgExConfig.getHeightString());
            writer.write("<DIV");
            DefaultDGExBuilder.OutputAttribute(writer, "id", dgEx.getUniqueID());
            String strClass = "sx-panel";
            if (StringHelper.Length((String)dgExConfig.getCssClass()) > 0) {
                strClass = dgExConfig.getCssClass();
            }
            DefaultDGExBuilder.OutputAttribute(writer, "class", strClass);
            DefaultDGExBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + dgExConfig.getExtStyle());
            writer.write(" >");
            writer.write("</DIV>");
            StringBuilderEx script = new StringBuilderEx();
            String strURL = dgExConfig.getDataURL();
            if (StringHelper.Length((String)strURL) == 0) {
                strURL = dgEx.getPage().getDefaultBackEndUrl();
            }
            if (StringHelper.Length((String)strURL) > 0) {
                strURL = URLHelper.AppendURLSeperator(strURL);
            }
            boolean bSortable = false;
            boolean bNoDefSort = true;
            String strSortField = "";
            boolean bSortDesc = false;
            if (dgExConfig.getDataGroupConfig() != null && dgExConfig.getDataGroupConfig().getDataGroupFetchConfig() != null) {
                bSortable = dgExConfig.getDataGroupConfig().getDataGroupFetchConfig().getSortable();
                bNoDefSort = dgExConfig.getDataGroupConfig().getDataGroupFetchConfig().getNoDefSort();
                strSortField = dgExConfig.getDataGroupConfig().getDataGroupFetchConfig().getSortField();
                bSortDesc = dgExConfig.getDataGroupConfig().getDataGroupFetchConfig().getSortDesc();
            }
            script.Append("var httpProxy=new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:%2$s,url:'%1$s'}));\r\n", strURL, dgExConfig.getTimeout());
            script.Append("var RecordDef=Ext.data.Record.create([");
            script.Append("{name:'KEYS'}");
            script.Append("]);\r\n");
            script.Append("var myReader=new Ext.data.JsonReader({root:\"items\"");
            if (dgExConfig.getPaging()) {
                script.Append(",totalProperty:\"totalrow\"");
            }
            script.Append(",summaryinfo:\"summaryinfo\"");
            script.Append("},RecordDef);\r\n");
            script.Append("var _S=new Ext.data.Store({proxy:httpProxy,reader:myReader,remoteSort:true});\r\n");
            script.Append("_S.userparams={};\r\n");
            script.Append("_S.sysparams={};\r\n");
            if (!bNoDefSort && bSortable && !StringHelper.IsNullOrEmpty((String)strSortField)) {
                script.Append("_S.setDefaultSort('%1$s','%2$s');\r\n", strSortField.toLowerCase(), bSortDesc ? "DESC" : "ASC");
                script.Append("_S.sortToggle['%1$s']='%2$s';\r\n", strSortField.toLowerCase(), bSortDesc ? "DESC" : "ASC");
            }
            if (dgExConfig.getPaging()) {
                script.Append("_S.loaddefault=function(){var _S=%2$s;if($P.store['%1$s'].lastOptions){_S=$P.store['%1$s'].lastOptions.params.limit;} $P.store['%1$s'].load({params:{start:0, limit:_S}});};\r\n", dgEx.getUniqueID(), dgExConfig.getPagingToolbarConfig().getPageSize());
                script.Append("var paging=new Ext.PagingToolbar({\r\n");
                script.Append("pageSize:%1$s,\r\n", dgExConfig.getPagingToolbarConfig().getPageSize());
                script.Append("store:_S,\r\n");
                script.Append("displayInfo:true,\r\n");
                script.Append("displayMsg:'%1$s',\r\n", dgExConfig.getPagingToolbarConfig().getDisplayMsg());
                script.Append("emptyMsg:'%1$s',\r\n", dgExConfig.getPagingToolbarConfig().getEmptyMsg());
                script.Append("beforePageText:'%1$s',\r\n", dgExConfig.getPagingToolbarConfig().getBeforePageMsg());
                script.Append("afterPageText:'%1$s'\r\n", dgExConfig.getPagingToolbarConfig().getAfterPageMsg());
                script.Append("});\r\n");
            } else {
                script.Append("_S.loaddefault=function(){$P.store['%1$s'].load({params:{}});};\r\n", dgEx.getUniqueID());
            }
            script.Append("var _G=new SRFDA.DGEx({el:'%1$s'\r\n", dgEx.getUniqueID());
            if (dgExConfig.getWidth() > 0) {
                script.Append(",width:%1$s", dgExConfig.getWidth());
            }
            if (dgExConfig.getHeight() > 0) {
                script.Append(",height:%1$s", dgExConfig.getHeight());
            }
            if (dgExConfig.getPaging()) {
                script.Append(",bbar:paging");
            }
            script.Append(",border:%1$s", dgExConfig.getBorder() ? "true" : "false");
            script.Append(",bodyCssClass:'sx-panel-body'");
            script.Append(",_GRIDID:'%1$s'", dgEx.getUniqueID());
            script.Append(",_URL:'%1$s'", strURL);
            script.Append(",store:_S");
            script.Append("});\r\n");
            script.Append("$P.gridex['%1$s']=_G;\r\n", dgEx.getUniqueID());
            script.Append("$P.store['%1$s']=_S;\r\n", dgEx.getUniqueID());
            dgEx.getPage().RegisterOnReadyScript(2, script.toString());
            if (dgExConfig.getLoadDefault()) {
                dgEx.getPage().RegisterOnReadyScript(5, StringHelper.Format((String)"$P.store['%1$s'].loaddefault();\r\n", (Object)dgEx.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return super.getBuilderMode();
    }

    @Override
    public String getBuilderName() {
        return "DGEX";
    }
}

