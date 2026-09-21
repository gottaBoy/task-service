/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.GroovyClassLoader
 *  groovy.lang.GroovyObject
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DP;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import java.util.Hashtable;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DPGroovyHelper
extends Script {
    private static final Log log = LogFactory.getLog(DPGroovyHelper.class);
    protected SRFExDPEx dpEx = null;
    protected SRFExForm form = null;
    protected TreeMap<String, String> itemsMap = new TreeMap();
    private static Hashtable<String, GroovyObject> scriptObjectMap = new Hashtable();

    public void Init(SRFExForm form, SRFExDPEx dpEx) {
        this.dpEx = dpEx;
        this.form = form;
    }

    public String GetTestItemIdScript(String strParamName) {
        String strRet = "";
        boolean bFirst = true;
        for (String strFormItemId : this.itemsMap.keySet()) {
            if (bFirst) {
                bFirst = false;
            } else {
                strRet = String.valueOf(strRet) + "||";
            }
            strRet = String.valueOf(strRet) + StringHelper.Format((String)"%1$s=='%2$s'", (Object)strParamName, (Object)strFormItemId);
        }
        if (!bFirst) {
            strRet = String.valueOf(strRet) + "||";
        }
        strRet = String.valueOf(strRet) + StringHelper.Format((String)"%1$s==''", (Object)strParamName);
        return strRet;
    }

    public CallResult GetTestFormItemValueScript(String strCode) {
        CallResult callResult = new CallResult();
        try {
            this.itemsMap.clear();
            GroovyObject go = DPGroovyHelper.GetGroovyObject(this, strCode);
            if (go == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u811a\u672c\u5f15\u64ce\u5bf9\u8c61");
                return callResult;
            }
            Object[] arg = new Object[]{this};
            String strRet = (String)go.invokeMethod("Test", (Object)arg);
            callResult.setUserObject(strRet);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5904\u7406\u811a\u672c[%1$s]\u53d1\u751f\u5f02\u5e38", (Object)strCode), (Throwable)ex);
            callResult.setRetCode(1);
            return callResult;
        }
    }

    public String Val(String strItemId) {
        SRFExControl control = this.form.FindControl(strItemId);
        if (control == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u63a7\u4ef6[%1$s]", (Object)strItemId));
            return "";
        }
        this.itemsMap.put(control.getUniqueID(), "");
        return StringHelper.Format((String)"%1$s.G('%2$s')", (Object)this.form.getFormId(), (Object)control.getUniqueID());
    }

    public String CurOPPerson() {
        String strCurUserId = this.form.getPage().getWebContext().getCurUserId();
        return StringHelper.Format((String)"'%1$s'", (Object)strCurUserId);
    }

    public String SV(String strKey) {
        Object objValue = this.form.getPage().getWebContext().GetSessionValue(strKey);
        if (objValue == null) {
            return "''";
        }
        return StringHelper.Format((String)"'%1$s'", (Object)objValue);
    }

    public Object run() {
        return null;
    }

    protected static GroovyObject GetGroovyObject(DPGroovyHelper helper, String strCode) {
        GroovyObject go = scriptObjectMap.get(strCode);
        if (go != null) {
            return go;
        }
        try {
            ClassLoader cl = ((Object)((Object)helper)).getClass().getClassLoader();
            GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
            String strFullCode = StringHelper.Format((String)"class SRFTest {public String Test(dp){String ret=%1$s;return ret;}}", (Object)strCode);
            Class groovyClass = groovyCl.parseClass(strFullCode);
            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            if (scriptObjectMap.size() > 2000) {
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

