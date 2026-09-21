/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  groovy.lang.Binding
 *  groovy.lang.Script
 */
package SA.TM.Ctrl.Utility;

import groovy.lang.Binding;
import groovy.lang.Script;
import java.util.Hashtable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMGrooveEngine
extends Script {
    public Object Calc(Hashtable<String, Object> macroValueMap, String strMacro) {
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

    public Object run() {
        return null;
    }
}

