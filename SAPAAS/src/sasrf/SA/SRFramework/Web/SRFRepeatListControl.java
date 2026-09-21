/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFListControl;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class SRFRepeatListControl
extends SRFListControl {
    private int layout = 1;
    private int repeatColumns = 1;
    private int direction = 1;
    private boolean textIsLiteral = false;

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public void setRepeatColumns(int repeatColumns) {
        this.repeatColumns = repeatColumns;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setTextIsLiteral(boolean textIsLiteral) {
        this.textIsLiteral = textIsLiteral;
    }

    public int getLayout() {
        return this.layout;
    }

    public int getRepeatColumns() {
        return this.repeatColumns;
    }

    public int getDirection() {
        return this.direction;
    }

    public boolean getTextIsLiteral() {
        return this.textIsLiteral;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String[] styles = this.getCssClass().split(";");
            String strBoxClass = "";
            String strLableClass = "";
            if (styles.length >= 1) {
                strBoxClass = styles[0];
            }
            if (styles.length >= 2) {
                strLableClass = styles[1];
            }
            boolean bSpanTag = StringHelper.StringLength(strLableClass) != 0;
            String strUniqueId2 = this.getUniqueID().replace(":", "_");
            if (this.getLayout() == 1) {
                int nRowCount;
                if (this.getRepeatColumns() == 0) {
                    this.setRepeatColumns(1);
                }
                if ((nRowCount = this.getItems().size() / this.getRepeatColumns()) * this.getRepeatColumns() < this.getItems().size()) {
                    ++nRowCount;
                }
                int nCellWidth = 100 / this.getRepeatColumns();
                output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
                int nRowIndex = 0;
                while (nRowIndex < nRowCount) {
                    output.println("<TR>");
                    int nColIndex = 0;
                    while (nColIndex < this.getRepeatColumns()) {
                        if (nRowIndex != 0 || nColIndex == this.getRepeatColumns() - 1) {
                            output.print("<TD>");
                        } else {
                            output.println(String.format("<TD width=\"%1$d%%\">", nCellWidth));
                        }
                        int nItemIndex = -1;
                        nItemIndex = nRowIndex * this.getRepeatColumns() + nColIndex;
                        if (this.getDirection() == 2) {
                            nItemIndex = nColIndex * nRowCount + nRowIndex;
                        }
                        if (nItemIndex >= this.getItems().size()) {
                            output.print("&nbsp;");
                        } else {
                            this.OutputItem(output, nItemIndex, strBoxClass, strLableClass, bSpanTag, strUniqueId2);
                        }
                        output.println("</TD>");
                        ++nColIndex;
                    }
                    output.println("</TR>");
                    ++nRowIndex;
                }
                output.println("</table>");
            } else {
                int nItemCount = this.getItems().size();
                int i = 0;
                while (i < nItemCount) {
                    this.OutputItem(output, i, strBoxClass, strLableClass, bSpanTag, strUniqueId2);
                    ++i;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void OutputItem(JspWriter output, int nItemIndex, String strBoxClass, String strLableClass, boolean bSpanTag, String strUniqueId2) throws IOException {
    }
}

