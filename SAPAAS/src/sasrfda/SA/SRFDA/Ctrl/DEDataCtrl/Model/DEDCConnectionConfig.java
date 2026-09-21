/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseConnectionConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class DEDCConnectionConfig
extends DEDCBaseConnectionConfig {
    public static String TAG_DEDCCONNECTION = "SRFEXDEDCCONNECTION";
    public static final int MAXPARAMCOUNT = 10;
    public static final String TAG_OPMODE = "OPMODE";
    public static final String TAG_OP = "OP";
    public static final String TAG_OP2 = "OP2";
    public static final String TAG_OP3 = "OP3";
    public static final String TAG_OP4 = "OP4";
    public static final String TAG_OP5 = "OP5";
    public static final String TAG_OP6 = "OP6";
    public static final String TAG_OP7 = "OP7";
    public static final String TAG_OP8 = "OP8";
    public static final String TAG_OP9 = "OP9";
    public static final String TAG_OP10 = "OP10";
    public static final String TAG_OPPARAM = "OPPARAM";
    public static final String TAG_OPPARAM2 = "OPPARAM2";
    public static final String TAG_OPPARAM3 = "OPPARAM3";
    public static final String TAG_OPPARAM4 = "OPPARAM4";
    public static final String TAG_OPPARAM5 = "OPPARAM5";
    public static final String TAG_OPPARAM6 = "OPPARAM6";
    public static final String TAG_OPPARAM7 = "OPPARAM7";
    public static final String TAG_OPPARAM8 = "OPPARAM8";
    public static final String TAG_OPPARAM9 = "OPPARAM9";
    public static final String TAG_OPPARAM10 = "OPPARAM10";
    public static final String TAG_OPPARAMASFUNC = "OPPARAMASFUNC";
    public static final String TAG_OPPARAMASFUNC2 = "OPPARAMASFUNC2";
    public static final String TAG_OPPARAMASFUNC3 = "OPPARAMASFUNC3";
    public static final String TAG_OPPARAMASFUNC4 = "OPPARAMASFUNC4";
    public static final String TAG_OPPARAMASFUNC5 = "OPPARAMASFUNC5";
    public static final String TAG_OPPARAMASFUNC6 = "OPPARAMASFUNC6";
    public static final String TAG_OPPARAMASFUNC7 = "OPPARAMASFUNC7";
    public static final String TAG_OPPARAMASFUNC8 = "OPPARAMASFUNC8";
    public static final String TAG_OPPARAMASFUNC9 = "OPPARAMASFUNC9";
    public static final String TAG_OPPARAMASFUNC10 = "OPPARAMASFUNC10";
    public static final String TAG_OPMODE_AND = "AND";
    public static final String TAG_OPMODE_OR = "OR";
    public static final String TAG_OP_GT = "GT";
    public static final String TAG_OP_GTANDEQ = "GTANDEQ";
    public static final String TAG_OP_EQ = "EQ";
    public static final String TAG_OP_LT = "LT";
    public static final String TAG_OP_LTANDEQ = "LTANDEQ";
    public static final String TAG_OP_REQEX = "REQEX";
    public static final String TAG_OP_NOTEQ = "NOTEQ";
    public static final String TAG_OP_ISNULL = "ISNULL";
    public static final String TAG_OP_ISNOTNULL = "ISNOTNULL";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final int OP_UNKNOWN = 0;
    public static final int OP_GT = 1;
    public static final int OP_GTANDEQ = 2;
    public static final int OP_EQ = 3;
    public static final int OP_LT = 4;
    public static final int OP_LTANDEQ = 5;
    public static final int OP_NOTEQ = 8;
    public static final int OP_AND = 12;
    public static final int OP_OR = 23;
    public static final int OP_ISNULL = 24;
    public static final int OP_ISNOTNULL = 25;
    protected String strOpMode = "AND";
    protected Hashtable OpList = new Hashtable();
    protected Hashtable OpParamList = new Hashtable();
    protected Hashtable OpParamAsFuncList = new Hashtable();
    protected boolean bDefaultMode = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OPMODE, (boolean)true) == 0) {
            this.strOpMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULTMODE, (boolean)true) == 0) {
            this.bDefaultMode = DEDCConnectionConfig.GetValue((String)strValue, (boolean)this.bDefaultMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OP, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP2, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP3, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP4, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP5, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP6, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP7, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP8, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP9, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OP10, (boolean)true) == 0) {
            int nOpValue = DEDCConnectionConfig.GetOpValue(strValue);
            if (nOpValue == 0) {
                return;
            }
            if (StringHelper.Length((String)(strName = strName.replace(TAG_OP, ""))) == 0) {
                this.OpList.put(0, nOpValue);
            } else {
                this.OpList.put(Integer.parseInt(strName) - 1, nOpValue);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OPPARAM, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM2, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM3, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM4, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM5, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM6, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM7, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM8, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM9, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAM10, (boolean)true) == 0) {
            if (StringHelper.Length((String)(strName = strName.replace(TAG_OPPARAM, ""))) == 0) {
                this.OpParamList.put(0, strValue);
            } else {
                this.OpParamList.put(Integer.parseInt(strName) - 1, strValue);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC2, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC3, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC4, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC5, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC6, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC7, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC8, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC9, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_OPPARAMASFUNC10, (boolean)true) == 0) {
            if (StringHelper.Length((String)(strName = strName.replace(TAG_OPPARAMASFUNC, ""))) == 0) {
                this.OpParamAsFuncList.put(0, DEDCConnectionConfig.GetValue((String)strValue, (boolean)false));
            } else {
                this.OpParamAsFuncList.put(Integer.parseInt(strName) - 1, DEDCConnectionConfig.GetValue((String)strValue, (boolean)false));
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getOpMode() {
        return this.strOpMode;
    }

    public void setOpMode(String value) {
        this.strOpMode = value;
    }

    public boolean getDefaultMode() {
        return this.bDefaultMode;
    }

    public void setDefaultMode(boolean value) {
        this.bDefaultMode = value;
    }

    public Hashtable getOPList() {
        return this.OpList;
    }

    public Hashtable getOPParamList() {
        return this.OpParamList;
    }

    public Hashtable getOpParamAsFuncList() {
        return this.OpParamAsFuncList;
    }

    public static int GetOpValue(String strOpTag) {
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_GT, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)">", (boolean)true) == 0) {
            return 1;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_GTANDEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)">=", (boolean)true) == 0) {
            return 2;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_EQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"=", (boolean)true) == 0) {
            return 3;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_LT, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<", (boolean)true) == 0) {
            return 4;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_LTANDEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<=", (boolean)true) == 0) {
            return 5;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_NOTEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<>", (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"!=", (boolean)true) == 0) {
            return 8;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_ISNULL, (boolean)true) == 0) {
            return 24;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_ISNOTNULL, (boolean)true) == 0) {
            return 25;
        }
        return 0;
    }
}

