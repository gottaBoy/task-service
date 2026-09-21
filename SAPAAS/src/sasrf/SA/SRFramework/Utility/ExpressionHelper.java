/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  groovy.lang.Binding
 *  groovy.lang.GroovyClassLoader
 *  groovy.lang.GroovyObject
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Utility;

import SA.SRFramework.Utility.StringHelper;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExpressionHelper
extends Script {
    private static final Log log = LogFactory.getLog(ExpressionHelper.class);
    private static Hashtable<String, GroovyObject> scriptObjectMap = new Hashtable();

    public Object GetValue(String strExpression) {
        try {
            Object objRet = null;
            Binding binding = new Binding();
            binding.setVariable("ret", objRet);
            this.setBinding(binding);
            String strFullExpression = "ret " + strExpression + ";";
            objRet = this.evaluate(strFullExpression);
            return objRet;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("\u5904\u7406\u811a\u672c[%1$s]\u53d1\u751f\u5f02\u5e38", strExpression), (Throwable)ex);
            return null;
        }
    }

    public Object run() {
        return null;
    }

    protected static GroovyObject GetGroovyObject(ExpressionHelper helper, String strCode) {
        GroovyObject go = scriptObjectMap.get(strCode);
        if (go != null) {
            return go;
        }
        try {
            ClassLoader cl = ((Object)((Object)helper)).getClass().getClassLoader();
            GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
            String strFullCode = StringHelper.Format("class SRFTest {public Object Test(){Object ret%1$s;return ret;}}", strCode);
            Class groovyClass = groovyCl.parseClass(strFullCode);
            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            if (scriptObjectMap.size() > 200) {
                scriptObjectMap.clear();
            }
            scriptObjectMap.put(strCode, groovyObject);
            return groovyObject;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

