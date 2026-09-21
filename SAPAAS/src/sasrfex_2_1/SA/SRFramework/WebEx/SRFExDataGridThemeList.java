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
import SA.SRFramework.WebEx.UI.DataGridThemeConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig;
import SA.SRFramework.WebEx.UI.DataGridThemeListConfig;
import java.io.Writer;
import java.util.Iterator;

public class SRFExDataGridThemeList
extends SRFExControl {
    protected DataGridThemeListConfig dataGridThemeListConfig = null;
    private static final String TAG_DATAGRIDTHEMEMGR = "SRFEXDATAGRIDTHEMEMGR";
    public static final String TAG_SRFEXDATAGRIDTHEMETLIST = "SRFEXDATAGRIDTHEMETLIST";

    @Override
    protected XMLConfig CreateConfig() {
        return new DataGridThemeListConfig();
    }

    public DataGridThemeListConfig getDataGridThemeListConfig() {
        return this.dataGridThemeListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridThemeListConfig = null;
        if (this.config != null && this.config instanceof DataGridThemeListConfig) {
            this.dataGridThemeListConfig = (DataGridThemeListConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getDataGridThemeListConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getDataGridThemeListConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            boolean bActive = false;
            boolean bFirst = true;
            boolean bSingleMode = false;
            if (this.getDataGridThemeListConfig().GetDataGridThemeGroupsConfig().size() == 1) {
                bSingleMode = true;
            }
            Iterator iterator = this.getDataGridThemeListConfig().GetDataGridThemeGroupsConfig().iterator();
            while (iterator.hasNext()) {
                DataGridThemeGroupConfig group = (DataGridThemeGroupConfig)((Object)iterator.next());
                if (group.size() == 0) continue;
                if (bFirst) {
                    bFirst = false;
                } else {
                    writer.write(String.format("<option value=''>&nbsp;&nbsp;&nbsp;</option>", new Object[0]));
                }
                if (!bSingleMode) {
                    writer.write(String.format("<option value=''>--- %1$s ---</option>", group.getGroupName()));
                }
                if (group.size() == 0) {
                    String strNoView = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.DATAGRIDTHEMELIST.NOVIEW", "(\u65e0)");
                    writer.write(StringHelper.Format((String)"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%1$s</option>", (Object)strNoView));
                    continue;
                }
                Iterator iterator2 = group.iterator();
                while (iterator2.hasNext()) {
                    DataGridThemeConfig theme = (DataGridThemeConfig)((Object)iterator2.next());
                    if (theme.isActive() && !bActive) {
                        bActive = true;
                        writer.write(String.format("<option selected=\"selected\" value=\"%2$s\">%1$s</option>", theme.getThemeName(), theme.getURL()));
                        continue;
                    }
                    writer.write(String.format("<option value=\"%2$s\">%1$s</option>", theme.getThemeName(), theme.getURL()));
                }
            }
            if (this.getDataGridThemeListConfig().isCustomTheme()) {
                writer.write(String.format("<option value=''>&nbsp;&nbsp;&nbsp;</option>", new Object[0]));
                String strManageMyView = this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getWebContext().getLocalization(), "CONTROL.DATAGRIDTHEMELIST.MANAGEMYVIEW", "\u7ba1\u7406\u6211\u7684\u89c6\u56fe");
                writer.write(String.format("<option value='%1$s'>%2$s</option>", TAG_DATAGRIDTHEMEMGR, strManageMyView));
            }
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _V=Ext.getDom('%1$s').value;\r\n", this.getUniqueID());
            script.Append("if(_V==undefined || _V=='')return;\r\n");
            script.Append("if(_V=='%1$s'){ %2$s return;}\r\n", TAG_DATAGRIDTHEMEMGR, this.getDataGridThemeListConfig().getMgrJSCode());
            script.Append("window.location.href=_V;\r\n");
            this.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)this.getUniqueID(), (Object)script.toString()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

