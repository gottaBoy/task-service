/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Web.Builder.SubListBuilder;
import SA.SRFramework.Web.SRFListViewControl;
import SA.SRFramework.Web.UI.SubListConfig;
import javax.servlet.jsp.JspWriter;

public class SRFSubList
extends SRFListViewControl {
    private SubListConfig subListConfig = null;
    private String strMoreURL = "";
    private String strMoreURLTarget = "";
    protected SelectResult selectResult = null;

    public void setDataSource(SelectResult value) {
        this.selectResult = value;
    }

    public void setConfig(SubListConfig value) {
        this.subListConfig = value;
    }

    public void setMoreURL(String value) {
        this.strMoreURL = value;
    }

    public void MoreURLTarget(String value) {
        this.strMoreURLTarget = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<!-- BEGIN SUBLIST -->\n");
            SubListBuilder slBuilder = this.GetSubListBuilder();
            if (slBuilder == null || this.subListConfig == null) {
                return;
            }
            slBuilder.setControlId(this.getUniqueID());
            slBuilder.setConfig(this.subListConfig);
            slBuilder.setCurWebContext(this.getWebContext());
            slBuilder.setMoreURL(this.strMoreURL);
            slBuilder.setMoreURLTarget(this.strMoreURLTarget);
            if (this.searchResult != null) {
                slBuilder.setDataSource(this.searchResult);
            } else if (this.selectResult != null) {
                slBuilder.setDataSource(this.selectResult);
            }
            slBuilder.Render(output);
            output.print("<!-- END SUBLIST -->\n");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected SubListBuilder GetSubListBuilder() {
        return this.getWebContext().getCurThemeConfig().GetSubListBuilder();
    }
}

