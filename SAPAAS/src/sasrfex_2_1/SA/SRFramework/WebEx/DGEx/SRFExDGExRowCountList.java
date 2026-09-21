/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.DGEx.UI.DGExRowCountListConfig;
import SA.SRFramework.WebEx.SRFExControl;
import java.io.Writer;

public class SRFExDGExRowCountList
extends SRFExControl {
    protected DGExRowCountListConfig dgExRowCountListConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";
    public static final String TAG_SRFEXDATAGRIDROWCOUNTLIST = "SRFEXDATAGRIDROWCOUNTLIST";

    @Override
    protected XMLConfig CreateConfig() {
        return new DGExRowCountListConfig();
    }

    public DGExRowCountListConfig getDGExRowCountListConfig() {
        return this.dgExRowCountListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dgExRowCountListConfig = null;
        if (this.config != null && this.config instanceof DGExRowCountListConfig) {
            this.dgExRowCountListConfig = (DGExRowCountListConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getDGExRowCountListConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getDGExRowCountListConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            String strPageFormat = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.DATAGRIDROWCOUNTLIST.PAGEFMT", "%1$s\u884c");
            int i = 1;
            while (i <= 10) {
                int nSize = i * 10;
                String strPageRowInfo = StringHelper.Format((String)strPageFormat, (Object)nSize);
                if (nSize == this.getDGExRowCountListConfig().getActivePageSize()) {
                    writer.write(String.format("<option selected=\"selected\" value=\"%1$s\">%1$s</option>", strPageRowInfo));
                } else {
                    writer.write(String.format("<option  value=\"%1$s\">%1$s</option>", strPageRowInfo));
                }
                ++i;
            }
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _V=Ext.getDom('%1$s').value;\r\n", this.getUniqueID());
            script.Append("if(_V==undefined || _V=='')return;\r\n");
            script.Append("$P.gridex['%1$s'].getBottomToolbar().pageSize= parseInt(_V);$P.store['%1$s'].lastOptions.params.limit=parseInt(_V);$P.store['%1$s'].reload();\r\n", this.getDGExRowCountListConfig().getDGExId());
            this.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)this.getUniqueID(), (Object)script.toString()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

