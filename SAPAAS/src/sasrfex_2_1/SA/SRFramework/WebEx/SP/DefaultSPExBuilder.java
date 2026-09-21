/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.SP;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SP.SPExBuilder;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultSPExBuilder
extends SPExBuilder {
    private static final Log log = LogFactory.getLog(DefaultSPExBuilder.class);

    @Override
    public void Render(Writer writer, SRFExSPEx searchPanel) {
        try {
            int nPanelWidth;
            if (searchPanel.getSPExConfig().getWidth() == 0) {
                writer.write(StringHelper.Format((String)"<table id='%1$s' width='100%%' border='0' cellspacing='0' cellpadding='0'>", (Object)searchPanel.getUniqueID()));
            } else {
                writer.write(StringHelper.Format((String)"<table id='%1$s' width='%2$s' border='0' cellspacing='0' cellpadding='0'>", (Object)searchPanel.getUniqueID(), (Object)searchPanel.getSPExConfig().getWidthString()));
            }
            writer.write("<tr>");
            writer.write("<td valign='top'>");
            if (searchPanel.getSPExConfig().getWidth() != 0 && (nPanelWidth = searchPanel.getSPExConfig().getWidth() - 90) > 0) {
                searchPanel.getPanel().getDPConfig().setWidth(nPanelWidth);
            }
            searchPanel.RenderChild(writer, "panel");
            writer.write("</td>");
            writer.write("<td width='70' valign='top' >");
            writer.write(StringHelper.Format((String)"<table  width='100%%' border='0' cellspacing='0' cellpadding='0'>"));
            writer.write("<tr><td height='5' ></td></tr>");
            writer.write("<tr>");
            writer.write("<td align='center' height='25' valign='middle'>");
            searchPanel.RenderChild(writer, "searchButton");
            writer.write("</td>");
            writer.write("</tr>");
            if (searchPanel.getSPExConfig().isResetButton()) {
                writer.write("<tr>");
                writer.write("<td align='center' height='25' valign='middle'>");
                searchPanel.RenderChild(writer, "resetButton");
                writer.write("</td>");
                writer.write("</tr>");
            }
            writer.write("</table>");
            writer.write("</td>");
            writer.write("</tr>");
            writer.write("</table>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.sp['%1$s']=new SRFDA.SPEx({spid:'%1$s',form:%2$s,tabid:'%3$s',customsearch:%4$s,csjsfunc:%5$s,csjsfuncname:'%5$s',itemprivilege:%6$s,saveload:%7$s});", searchPanel.getUniqueID(), searchPanel.getSearchForm().getFormId(), searchPanel.FindControl("Panel").getUniqueID(), searchPanel.getSPExConfig().isCustomSearch(), !StringHelper.IsNullOrEmpty((String)searchPanel.getSPExConfig().getCustomSearchJSFunc()) ? searchPanel.getSPExConfig().getCustomSearchJSFunc() : "null", searchPanel.isEnableItemPrivilege(), searchPanel.getSPExConfig().isSaveLoad());
            searchPanel.getPage().RegisterOnReadyScript(2, script.toString());
        }
        catch (Exception ex) {
            log.error((Object)"\u7ed8\u5236\u641c\u7d22\u9762\u677f\u51fa\u73b0\u51fa\u9519", (Throwable)ex);
        }
    }
}

