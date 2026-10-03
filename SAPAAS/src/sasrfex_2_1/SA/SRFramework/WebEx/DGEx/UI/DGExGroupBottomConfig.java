/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellsConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroParamConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacrosConfig;
import java.util.Enumeration;
import java.util.Properties;
import org.w3c.dom.Node;

public class DGExGroupBottomConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXGROUPBOTTOM = "SRFEXDGEXGROUPBOTTOM";
    protected DGExMacrosConfig macrosConfig = null;
    protected DGExCellsConfig cellsConfig = null;
    public static final String TAG_MACROS = "MACROS";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_MACROS, (String)strName, (boolean)true) == 0) {
            this.ParseMacros(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXMACROS", (boolean)true) == 0) {
            if (this.macrosConfig == null) {
                this.macrosConfig = new DGExMacrosConfig();
            }
            this.macrosConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXCELLS", (boolean)true) == 0) {
            if (this.cellsConfig == null) {
                this.cellsConfig = new DGExCellsConfig();
                this.cellsConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGExMacrosConfig getMacrosConfig() {
        return this.macrosConfig;
    }

    public DGExCellsConfig getCellsConfig() {
        return this.cellsConfig;
    }

    protected void ParseMacros(String strValue) {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return;
        }
        try {
            if (this.macrosConfig == null) {
                this.macrosConfig = new DGExMacrosConfig();
            }
            Properties properties = PropertiesHelper.Load(strValue);
            Enumeration<Object> en = properties.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                String strMacro = PropertiesHelper.GetProperty(properties, strKey);
                int nPos = (strMacro = strMacro.trim()).indexOf("(");
                if (nPos == -1) continue;
                String strFunc = strMacro.substring(0, nPos);
                String strParams = strMacro.substring(nPos + 1, strMacro.length() - 1);
                if (StringHelper.IsNullOrEmpty((String)strParams)) continue;
                DGExMacroConfig macroConfig = new DGExMacroConfig();
                macroConfig.setFunc(strFunc);
                macroConfig.setID(strKey);
                String[] params = strParams.split("[,]");
                int i = 0;
                while (i < params.length) {
                    DGExMacroParamConfig paramConfig = new DGExMacroParamConfig();
                    paramConfig.setID(params[i]);
                    if (++i < params.length) {
                        paramConfig.setNullValue(params[i]);
                    }
                    macroConfig.getMacroParamsConfig().add(paramConfig);
                    ++i;
                }
                this.macrosConfig.add(macroConfig);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
