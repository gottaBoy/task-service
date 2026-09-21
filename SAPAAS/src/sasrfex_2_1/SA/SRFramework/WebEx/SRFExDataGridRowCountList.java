/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.DataGridRowCountListConfig;
import java.io.Writer;

public class SRFExDataGridRowCountList
extends SRFExControl {
    protected DataGridRowCountListConfig DataGridRowCountListConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";
    public static final String TAG_SRFEXDATAGRIDROWCOUNTLIST = "SRFEXDATAGRIDROWCOUNTLIST";

    @Override
    protected XMLConfig CreateConfig() {
        return new DataGridRowCountListConfig();
    }

    public DataGridRowCountListConfig getDataGridRowCountListConfig() {
        return this.DataGridRowCountListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.DataGridRowCountListConfig = null;
        if (this.config != null && this.config instanceof DataGridRowCountListConfig) {
            this.DataGridRowCountListConfig = (DataGridRowCountListConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getDataGridRowCountListConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getDataGridRowCountListConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            String strPageFormat = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.DATAGRIDROWCOUNTLIST.PAGEFMT", "%1$s\u884c");
            int i = 1;
            while (i <= 10) {
                int nSize = i * 10;
                String strPageRowInfo = StringHelper.Format((String)strPageFormat, (Object)nSize);
                if (nSize == this.getDataGridRowCountListConfig().getActivePageSize()) {
                    writer.write(String.format("<option selected=\"selected\" value=\"%1$s\">%1$s</option>", strPageRowInfo));
                } else {
                    writer.write(String.format("<option value=\"%1$s\">%1$s</option>", strPageRowInfo));
                }
                ++i;
            }
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _V=Ext.getDom('%1$s').value;\r\n", this.getUniqueID());
            script.Append("if(_V==undefined || _V=='')return;\r\n");
            script.Append("var _TB=$P.grid['%1$s'].getBottomToolbar();if(!_TB){_TB=$P.toolbar['%1$s'];}if(_TB) _TB.pageSize=parseInt(_V);var sp=$P.store['%1$s'].lastOptions.params;sp.start=0;sp.limit = parseInt(_V);$P.store['%1$s'].reload();\r\n", this.getDataGridRowCountListConfig().getDataGridId());
            this.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)this.getUniqueID(), (Object)script.toString()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

