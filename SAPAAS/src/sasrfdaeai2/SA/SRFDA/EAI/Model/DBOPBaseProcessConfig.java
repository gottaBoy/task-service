/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DBOPBaseProcessConfig
extends XMLConfig {
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_LEFT = "LEFT";
    public static final String TAG_TOP = "TOP";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_NEXT = "NEXT";
    protected String strLogicName = "";
    protected double dLeft = 0.0;
    protected double dTop = 0.0;
    protected double dWidth = 0.0;
    protected double dHeight = 0.0;
    protected String strNext = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_LOGICNAME, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LEFT, (boolean)true) == 0) {
            this.setLeft(DBOPBaseProcessConfig.GetValue((String)strValue, (double)0.0));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TOP, (boolean)true) == 0) {
            this.setTop(DBOPBaseProcessConfig.GetValue((String)strValue, (double)0.0));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            this.setWidth(DBOPBaseProcessConfig.GetValue((String)strValue, (double)0.0));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEIGHT, (boolean)true) == 0) {
            this.setHeight(DBOPBaseProcessConfig.GetValue((String)strValue, (double)0.0));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NEXT, (boolean)true) == 0) {
            this.setNext(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getNext() {
        return this.strNext;
    }

    public void setNext(String strNext) {
        this.strNext = strNext;
    }

    public double getLeft() {
        return this.dLeft;
    }

    public void setLeft(double dLeft) {
        this.dLeft = dLeft;
    }

    public double getTop() {
        return this.dTop;
    }

    public void setTop(double dTop) {
        this.dTop = dTop;
    }

    public double getWidth() {
        return this.dWidth;
    }

    public void setWidth(double dWidth) {
        this.dWidth = dWidth;
    }

    public double getHeight() {
        return this.dHeight;
    }

    public void setHeight(double dHeight) {
        this.dHeight = dHeight;
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }
}

