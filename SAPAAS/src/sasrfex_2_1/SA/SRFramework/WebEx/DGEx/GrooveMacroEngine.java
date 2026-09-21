/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  groovy.lang.Binding
 *  groovy.lang.Script
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.DataRowHelper;
import groovy.lang.Binding;
import groovy.lang.Script;
import java.util.TreeMap;

public class GrooveMacroEngine
extends Script {
    protected DGExFetchResultHelperContext context = null;

    public Object Calc(DGExFetchResultHelperContext context, TreeMap<String, Object> macroValueMap, String strMacro) {
        try {
            Object objValue = 0;
            Binding binding = new Binding();
            for (String strKey : macroValueMap.keySet()) {
                binding.setVariable(strKey.toUpperCase(), macroValueMap.get(strKey));
            }
            this.setBinding(binding);
            objValue = this.evaluate(strMacro);
            return objValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Object Calc(DGExFetchResultHelperContext context, DataRow dr, String strMacro) {
        try {
            Object objValue = 0;
            Binding binding = new Binding();
            DataRowHelper drHelper = new DataRowHelper(dr);
            binding.setProperty("DR", (Object)drHelper);
            this.setBinding(binding);
            objValue = this.evaluate(strMacro);
            return objValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Object run() {
        return null;
    }
}

