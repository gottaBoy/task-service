/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.GroovyClassLoader
 *  groovy.lang.GroovyObject
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.DPGroovyHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class GrooveRuleEngine
extends Script {
    private static final Log log = LogFactory.getLog(DPGroovyHelper.class);
    protected BaseDataEntity dataEntity = null;
    private static Hashtable<String, GroovyObject> scriptObjectMap = new Hashtable();

    protected boolean InternalTest(String strCode, boolean bErrorRet) {
        try {
            GroovyObject go = GrooveRuleEngine.GetGroovyObject(this, strCode);
            if (go == null) {
                log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u811a\u672c\u5f15\u64ce\u5bf9\u8c61");
                return bErrorRet;
            }
            Object[] arg = new Object[]{this};
            return (Boolean)go.invokeMethod("Test", (Object)arg);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return bErrorRet;
        }
    }

    public Object run() {
        return null;
    }

    public boolean IsNull(String strFormItemId) {
        Object obj = this.dataEntity.GetParamValue(strFormItemId);
        return obj == null;
    }

    public boolean IsNotNull(String strFormItemId) {
        Object obj = this.dataEntity.GetParamValue(strFormItemId);
        return obj != null;
    }

    public int Int(String strFormItemId, int nDefault) {
        return this.dataEntity.GetParamIntValue(strFormItemId, nDefault);
    }

    public String Val(String strFormItemId, String strDefault) {
        return this.dataEntity.GetParamStringValue(strFormItemId, strDefault);
    }

    public String Val(String strFormItemId) {
        return this.dataEntity.GetParamStringValue(strFormItemId, "");
    }

    public String String(String strFormItemId, String strDefault) {
        return this.dataEntity.GetParamStringValue(strFormItemId, strDefault);
    }

    public double Double(String strFormItemId, double fDefault) {
        return this.dataEntity.GetParamDoubleValue(strFormItemId, fDefault);
    }

    public float Float(String strFormItemId, float fDefault) {
        return this.dataEntity.GetParamFloatValue(strFormItemId, fDefault);
    }

    public BigDecimal Float(String strFormItemId, BigDecimal fDefault) {
        return this.dataEntity.GetParamBigDecimalValue(strFormItemId, fDefault);
    }

    public boolean Bool(String strFormItemId, boolean bDefault) {
        return this.dataEntity.GetParamBoolValue(strFormItemId, bDefault);
    }

    public long GetTime(String strTime) {
        if (StringHelper.IsNullOrEmpty((String)strTime)) {
            return new Date().getTime();
        }
        try {
            if (StringHelper.Compare((String)strTime, (String)"NOHOUR", (boolean)true) == 0) {
                strTime = String.format("%1$tY-%1$tm-%1$td 00:00:00", new Date());
            } else if (StringHelper.Compare((String)strTime, (String)"NOMINUTE", (boolean)true) == 0) {
                strTime = String.format("%1$tY-%1$tm-%1$td %1$tH:00:00", new Date());
            } else if (StringHelper.Compare((String)strTime, (String)"NOSECOND", (boolean)true) == 0) {
                strTime = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:00", new Date());
            } else {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u65f6\u95f4\u683c\u5f0f"));
            }
            log.debug((Object)StringHelper.Format((String)"\u8ba1\u7b97\u5f53\u524d\u65f6\u95f4[%1$s]", (Object)strTime));
            Date date = DateParser.Parser((String)strTime);
            return date.getTime();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return 0L;
        }
    }

    public long Time(String strFormItemId) {
        return this.dataEntity.GetParamDateValue(strFormItemId, null).getTime();
    }

    public long TimeDiff(String strFormItemId, String strFormItem2) {
        return this.Compare(5, strFormItemId, strFormItem2);
    }

    public long IntDiff(String strFormItemId, String strFormItem2) {
        return this.Compare(9, strFormItemId, strFormItem2);
    }

    public long FloatDiff(String strFormItemId, String strFormItem2) {
        return this.Compare(7, strFormItemId, strFormItem2);
    }

    public long DoubleDiff(String strFormItemId, String strFormItem2) {
        return this.Compare(6, strFormItemId, strFormItem2);
    }

    public long StringDiff(String strFormItemId, String strFormItem2) {
        return this.Compare(25, strFormItemId, strFormItem2);
    }

    public long Compare(int nType, String strFormItemId, String strFormItemId2) {
        Object objValue = this.dataEntity.GetParamValue(strFormItemId);
        Object objValue2 = this.dataEntity.GetParamValue(strFormItemId2);
        if (objValue == null && objValue2 == null) {
            return 0L;
        }
        if (objValue == null && objValue2 != null) {
            return 1L;
        }
        if (objValue != null && objValue2 == null) {
            return -1L;
        }
        if (StringHelper.Compare((String)objValue.getClass().getName(), (String)objValue2.getClass().getName(), (boolean)true) != 0) {
            return -100L;
        }
        return DataTypeParse.Compare((int)nType, (Object)objValue, (Object)objValue2);
    }

    public boolean RegEx(String strFormItemId, String strRule) {
        return GrooveRuleEngine.TestRegEx(strRule, this.String(strFormItemId, ""));
    }

    protected static boolean TestRegEx(String strRule, String strValue) {
        Pattern p = Pattern.compile(strRule);
        Matcher m = p.matcher(strValue);
        boolean b = m.matches();
        return b;
    }

    public String CurOPPerson() {
        String strCurUserId = this.GetWebContext().getCurUserId();
        return strCurUserId;
    }

    public String SV(String strKey) {
        Object objValue = this.GetWebContext().GetSessionValue(strKey);
        if (objValue == null) {
            return "";
        }
        return StringHelper.Format((String)"%1$s", (Object)objValue);
    }

    protected ISRFExWebContext GetWebContext() {
        return null;
    }

    protected static GroovyObject GetGroovyObject(GrooveRuleEngine helper, String strCode) {
        GroovyObject go = scriptObjectMap.get(strCode);
        if (go != null) {
            return go;
        }
        try {
            ClassLoader cl = ((Object)((Object)helper)).getClass().getClassLoader();
            GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
            String strFullCode = StringHelper.Format((String)"class SRFTest {public Boolean Test(dp){Boolean ret=%1$s;return ret;}}", (Object)strCode);
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

