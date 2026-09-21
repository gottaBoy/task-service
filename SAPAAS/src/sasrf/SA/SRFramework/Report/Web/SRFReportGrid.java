/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 *  org.jfree.data.category.DefaultCategoryDataset
 */
package SA.SRFramework.Report.Web;

import SA.SRFramework.Report.UI.ReportGridConfig;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.TableRenderHelper;
import SA.SRFramework.Web.UI.TableCellConfig;
import javax.servlet.jsp.JspWriter;
import org.jfree.data.category.DefaultCategoryDataset;

public class SRFReportGrid
extends SRFWebControl {
    private ReportGridConfig reportGridConfig = null;
    private DefaultCategoryDataset defaultCategoryDataset = null;

    @Override
    protected void OnRender(JspWriter output) {
        if (this.reportGridConfig == null || this.defaultCategoryDataset == null) {
            return;
        }
        if (this.defaultCategoryDataset.getColumnCount() == 0) {
            return;
        }
        int nLeaveColumnWidth = this.getWidth() - this.reportGridConfig.getXYCellConfig().getWidth();
        int nColumnWidth = nLeaveColumnWidth / this.defaultCategoryDataset.getColumnCount();
        try {
            output.println(String.format("<table cellpadding=\"0\" cellspacing=\"0\" border=\"%1$d\"   width=\"100%%\" > ", this.reportGridConfig.getBorderWidth()));
            output.println("<tr>");
            TableRenderHelper.RenderCell(output, this.reportGridConfig.getXYCellConfig());
            TableCellConfig columnCellConfig = new TableCellConfig();
            columnCellConfig.setHeight(0);
            columnCellConfig.setWidth(nColumnWidth);
            int nColumnCount = this.defaultCategoryDataset.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName = (String)((Object)this.defaultCategoryDataset.getColumnKey(i));
                TableRenderHelper.RenderCell(output, columnCellConfig, strColumnName);
                ++i;
            }
            output.println("</tr>");
            TableCellConfig rowKeyCellConfig = new TableCellConfig();
            rowKeyCellConfig.setWidth(0);
            rowKeyCellConfig.setHeight(this.reportGridConfig.getXYCellConfig().getYAxisConfig().getHeight());
            rowKeyCellConfig.setCSS(this.reportGridConfig.getXYCellConfig().getYAxisConfig().getCSS());
            int nRowCount = this.defaultCategoryDataset.getRowCount();
            int j = 0;
            while (j < nRowCount) {
                output.println("<tr>");
                TableRenderHelper.RenderCell(output, rowKeyCellConfig, (String)((Object)this.defaultCategoryDataset.getRowKey(j)));
                output.println("</tr>");
                ++j;
            }
            output.println("</table>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void setConfig(ReportGridConfig value) {
        this.reportGridConfig = value;
    }

    public void setDataset(DefaultCategoryDataset value) {
        this.defaultCategoryDataset = value;
    }
}

