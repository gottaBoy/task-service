/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseInputConfig;

public class DatePickerConfig
extends BaseInputConfig {
    public static final String TAG_DATEPICKER = "SRFEXDATEPICKER";
    public static final String TAG_TIPMESSAGE = "TIPMESSAGE";
    public static final String TAG_DAYENABLE = "DAYENABLE";
    public static final String TAG_HOURENABLE = "HOURENABLE";
    public static final String TAG_MINUTEENABLE = "MINUTEENABLE";
    public static final String TAG_SECONDENABLE = "SECONDENABLE";
    public static final String TAG_TIMENOWBUTTON = "TIMENOWBUTTON";
    protected String strTipMessage = "\u70b9\u51fb\u9009\u62e9\u65f6\u95f4";
    protected boolean bDayEnable = true;
    protected boolean bHourEnable = false;
    protected boolean bMinuteEnable = false;
    protected boolean bSecondEnable = false;
    protected boolean bTimeNowButton = true;

    public DatePickerConfig() {
        this.strCssClass = "sx-input";
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TIPMESSAGE, (boolean)true) == 0) {
            this.strTipMessage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DAYENABLE, (boolean)true) == 0) {
            this.bDayEnable = DatePickerConfig.GetValue((String)strValue, (boolean)this.bDayEnable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HOURENABLE, (boolean)true) == 0) {
            this.bHourEnable = DatePickerConfig.GetValue((String)strValue, (boolean)this.bHourEnable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MINUTEENABLE, (boolean)true) == 0) {
            this.bMinuteEnable = DatePickerConfig.GetValue((String)strValue, (boolean)this.bMinuteEnable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SECONDENABLE, (boolean)true) == 0) {
            this.bSecondEnable = DatePickerConfig.GetValue((String)strValue, (boolean)this.bSecondEnable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMENOWBUTTON, (boolean)true) == 0) {
            this.setTimeNowButton(DatePickerConfig.GetValue((String)strValue, (boolean)this.isTimeNowButton()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setTipMessage(String strTipMessage) {
        this.strTipMessage = strTipMessage;
    }

    public String getTipMessage() {
        return this.strTipMessage;
    }

    public void setDayEnable(boolean bDayEnable) {
        this.bDayEnable = bDayEnable;
    }

    public boolean getDayEnable() {
        return this.bDayEnable;
    }

    public void setHourEnable(boolean bHourEnable) {
        this.bHourEnable = bHourEnable;
    }

    public boolean getHourEnable() {
        return this.bHourEnable || this.bMinuteEnable || this.bSecondEnable;
    }

    public void setMinuteEnable(boolean bMinuteEnable) {
        this.bMinuteEnable = bMinuteEnable;
    }

    public boolean getMinuteEnable() {
        return this.bMinuteEnable || this.bSecondEnable;
    }

    public void setSecondEnable(boolean bSecondEnable) {
        this.bSecondEnable = bSecondEnable;
    }

    public boolean getSecondEnable() {
        return this.bSecondEnable;
    }

    public boolean isTimeNowButton() {
        return this.bTimeNowButton;
    }

    public void setTimeNowButton(boolean bTimeNowButton) {
        this.bTimeNowButton = bTimeNowButton;
    }
}

