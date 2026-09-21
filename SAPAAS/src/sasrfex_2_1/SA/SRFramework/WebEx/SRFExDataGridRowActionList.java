/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Script.ElementJSHelper;
import SA.SRFramework.WebEx.UI.DataGridRowActionListConfig;
import java.io.Writer;

public class SRFExDataGridRowActionList
extends SRFExControl {
    protected DataGridRowActionListConfig dataGridRowActionListConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";
    public static final String TAG_SRFEXDATAGRIDROWACTIONLIST = "SRFEXDATAGRIDROWACTIONLIST";

    @Override
    protected XMLConfig CreateConfig() {
        return new DataGridRowActionListConfig();
    }

    public DataGridRowActionListConfig getDataGridRowActionListConfig() {
        return this.dataGridRowActionListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridRowActionListConfig = null;
        if (this.config != null && this.config instanceof DataGridRowActionListConfig) {
            this.dataGridRowActionListConfig = (DataGridRowActionListConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getDataGridRowActionListConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getDataGridRowActionListConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            writer.write(String.format("<option selected=\"selected\" value=\"0\">%1$s</option>", this.getWebContext().getLocalText(TAG_SRFEXDATAGRIDROWACTIONLIST, "SELECT_TEXT", "\u9009\u62e9")));
            writer.write(String.format("<option value=\"1\"  >%1$s</option>", this.getWebContext().getLocalText(TAG_SRFEXDATAGRIDROWACTIONLIST, "SELECTALL_TEXT", "\u5168\u90e8\u9009\u4e2d")));
            writer.write(String.format("<option value=\"2\"  >%1$s</option>", this.getWebContext().getLocalText(TAG_SRFEXDATAGRIDROWACTIONLIST, "SELECTNONE_TEXT", "\u5168\u90e8\u53d6\u6d88")));
            writer.write(String.format("<option value=\"3\">%1$s</option>", this.getWebContext().getLocalText(TAG_SRFEXDATAGRIDROWACTIONLIST, "SELECTALTERNATIVE_TEXT", "\u53cd\u5411\u9009\u4e2d")));
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _L = Ext.getDom('%1$s');\r\n", this.getUniqueID());
            script.Append("if( _L ==undefined || _L ==null) return;\r\n");
            script.Append("switch(_L.selectedIndex){\r\n");
            script.Append("case 1: %1$s _L.value ='0';return;\r\n", DataGridJSHelper.getDataGridCheckScript(this.getDataGridRowActionListConfig().getDataGridId(), true));
            script.Append("case 2: %1$s _L.value ='0';return;\r\n", DataGridJSHelper.getDataGridCheckScript(this.getDataGridRowActionListConfig().getDataGridId(), false));
            script.Append("case 3: %1$s _L.value ='0';return;\r\n", DataGridJSHelper.getDataGridCheckAlternativeScript(this.getDataGridRowActionListConfig().getDataGridId()));
            script.Append("default:return;\r\n");
            script.Append("}\r\n");
            String strTempCode = script.toString();
            script.Reset();
            this.getPage().RegisterOnReadyScript(3, ElementJSHelper.getOnEventScript(this.getUniqueID(), "change", 1, strTempCode));
            script.Append("var _L = Ext.getDom('%1$s');\r\n", this.getUniqueID());
            script.Append("if( _L == undefined || _L == null) return;\r\n");
            script.Append("_L.selectedIndex = 0;\r\n");
            strTempCode = script.toString();
            script.Reset();
            this.getPage().RegisterOnReadyScript(3, DataGridJSHelper.getOnRowSelectedCancelEventScript(this.getDataGridRowActionListConfig().getDataGridId(), strTempCode));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

