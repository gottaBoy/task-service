/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.WebEx.Builder.DataGridBuilder;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.io.Writer;

public class IFrameDataGridBuilder
extends DataGridBuilder {
    @Override
    public void Render(Writer writer, SRFExDataGrid dataGrid) {
        try {
            String strSessionId = Helper.GenGuid();
            DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
            dataGrid.getPage().getWebContext().getSession().setAttribute(strSessionId, (Object)dataGridConfig);
            String strURL = "../commonex/datagrid.jsp?ConfigId=" + strSessionId;
            writer.write("<iframe ");
            writer.write(String.format(" name=\"%1$s\"", dataGrid.getUniqueID()));
            writer.write(String.format(" width=\"%1$d\"", dataGridConfig.getWidth()));
            writer.write(String.format(" frameBorder=\"%1$d\"", 0));
            writer.write(String.format(" marginheight=\"%1$d\"", 0));
            writer.write(String.format(" marginwidth=\"%1$d\"", 0));
            writer.write(String.format(" height=\"%1$d\"", 300));
            writer.write(String.format(" src=\"%1$s\"", strURL));
            writer.write(String.format(" scrolling=\"%1$s\"", "no"));
            writer.write(String.format(" ></iframe>", new Object[0]));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "";
    }

    @Override
    public String getBuilderName() {
        return "DATAGRID";
    }
}

