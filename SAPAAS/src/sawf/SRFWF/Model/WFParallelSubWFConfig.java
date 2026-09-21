/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.Data.WFSubWF;
import SRFWF.Model.WFBaseEmbedWFConfig;
import java.util.Vector;

public class WFParallelSubWFConfig
extends WFBaseEmbedWFConfig {
    public static final String TAG_WFPARALLELSUBWF = "SRFEXWFPARALLELSUBWF";
    public static final String TAG_DESUBWFID = "DESUBWFID";
    public static final String TAG_DESUBWFNAME = "DESUBWFNAME";
    public static final String TAG_DESUBWFVR = "DESUBWFVR";
    public static final String TAG_DESUBWFID2 = "DESUBWFID2";
    public static final String TAG_DESUBWFNAME2 = "DESUBWFNAME2";
    public static final String TAG_DESUBWFVR2 = "DESUBWFVR2";
    public static final String TAG_DESUBWFID3 = "DESUBWFID3";
    public static final String TAG_DESUBWFNAME3 = "DESUBWFNAME3";
    public static final String TAG_DESUBWFVR3 = "DESUBWFVR3";
    public static final String TAG_DESUBWFID4 = "DESUBWFID4";
    public static final String TAG_DESUBWFNAME4 = "DESUBWFNAME4";
    public static final String TAG_DESUBWFVR4 = "DESUBWFVR4";
    public static final String TAG_DESUBWFID5 = "DESUBWFID5";
    public static final String TAG_DESUBWFNAME5 = "DESUBWFNAME5";
    public static final String TAG_DESUBWFVR5 = "DESUBWFVR5";
    public static final String TAG_DESUBWFID6 = "DESUBWFID6";
    public static final String TAG_DESUBWFNAME6 = "DESUBWFNAME6";
    public static final String TAG_DESUBWFVR6 = "DESUBWFVR6";
    public static final String TAG_DESUBWFID7 = "DESUBWFID7";
    public static final String TAG_DESUBWFNAME7 = "DESUBWFNAME7";
    public static final String TAG_DESUBWFVR7 = "DESUBWFVR7";
    public static final String TAG_DESUBWFID8 = "DESUBWFID8";
    public static final String TAG_DESUBWFNAME8 = "DESUBWFNAME8";
    public static final String TAG_DESUBWFVR8 = "DESUBWFVR8";
    public static final String TAG_DESUBWFID9 = "DESUBWFID9";
    public static final String TAG_DESUBWFNAME9 = "DESUBWFNAME9";
    public static final String TAG_DESUBWFVR9 = "DESUBWFVR9";
    public static final String TAG_ENABLEDESUBWF9 = "ENABLEDESUBWF9";
    public static final String TAG_ENABLEDESUBWF8 = "ENABLEDESUBWF8";
    public static final String TAG_ENABLEDESUBWF7 = "ENABLEDESUBWF7";
    public static final String TAG_ENABLEDESUBWF6 = "ENABLEDESUBWF6";
    public static final String TAG_ENABLEDESUBWF5 = "ENABLEDESUBWF5";
    public static final String TAG_ENABLEDESUBWF4 = "ENABLEDESUBWF4";
    public static final String TAG_ENABLEDESUBWF3 = "ENABLEDESUBWF3";
    public static final String TAG_ENABLEDESUBWF2 = "ENABLEDESUBWF2";
    public static final String TAG_ENABLEDESUBWF = "ENABLEDESUBWF";
    protected String strDESubWFId = "";
    protected String strDESubWFName = "";
    protected String strDESubWFVR = "";
    protected String strDESubWFId2 = "";
    protected String strDESubWFName2 = "";
    protected String strDESubWFVR2 = "";
    protected String strDESubWFId3 = "";
    protected String strDESubWFName3 = "";
    protected String strDESubWFVR3 = "";
    protected String strDESubWFId4 = "";
    protected String strDESubWFName4 = "";
    protected String strDESubWFVR4 = "";
    protected String strDESubWFId5 = "";
    protected String strDESubWFName5 = "";
    protected String strDESubWFVR5 = "";
    protected String strDESubWFId6 = "";
    protected String strDESubWFName6 = "";
    protected String strDESubWFVR6 = "";
    protected String strDESubWFId7 = "";
    protected String strDESubWFName7 = "";
    protected String strDESubWFVR7 = "";
    protected String strDESubWFId8 = "";
    protected String strDESubWFName8 = "";
    protected String strDESubWFVR8 = "";
    protected String strDESubWFId9 = "";
    protected String strDESubWFName9 = "";
    protected String strDESubWFVR9 = "";
    protected boolean bEnableSubWF = false;
    protected boolean bEnableSubWF2 = false;
    protected boolean bEnableSubWF3 = false;
    protected boolean bEnableSubWF4 = false;
    protected boolean bEnableSubWF5 = false;
    protected boolean bEnableSubWF6 = false;
    protected boolean bEnableSubWF7 = false;
    protected boolean bEnableSubWF8 = false;
    protected boolean bEnableSubWF9 = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID, (boolean)true) == 0) {
            this.setDESubWFId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME, (boolean)true) == 0) {
            this.setDESubWFName(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR, (boolean)true) == 0) {
            this.setDESubWFVR(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID2, (boolean)true) == 0) {
            this.setDESubWFId2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME2, (boolean)true) == 0) {
            this.setDESubWFName2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR2, (boolean)true) == 0) {
            this.setDESubWFVR2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID3, (boolean)true) == 0) {
            this.setDESubWFId3(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME3, (boolean)true) == 0) {
            this.setDESubWFName3(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR3, (boolean)true) == 0) {
            this.setDESubWFVR3(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID4, (boolean)true) == 0) {
            this.setDESubWFId4(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME4, (boolean)true) == 0) {
            this.setDESubWFName4(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR4, (boolean)true) == 0) {
            this.setDESubWFVR4(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID5, (boolean)true) == 0) {
            this.setDESubWFId5(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME5, (boolean)true) == 0) {
            this.setDESubWFName5(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR5, (boolean)true) == 0) {
            this.setDESubWFVR5(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID6, (boolean)true) == 0) {
            this.setDESubWFId6(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME6, (boolean)true) == 0) {
            this.setDESubWFName6(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR6, (boolean)true) == 0) {
            this.setDESubWFVR6(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID7, (boolean)true) == 0) {
            this.setDESubWFId7(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME7, (boolean)true) == 0) {
            this.setDESubWFName7(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR7, (boolean)true) == 0) {
            this.setDESubWFVR7(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID8, (boolean)true) == 0) {
            this.setDESubWFId8(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME8, (boolean)true) == 0) {
            this.setDESubWFName8(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR8, (boolean)true) == 0) {
            this.setDESubWFVR8(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFID9, (boolean)true) == 0) {
            this.setDESubWFId9(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFNAME9, (boolean)true) == 0) {
            this.setDESubWFName9(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESUBWFVR9, (boolean)true) == 0) {
            this.setDESubWFVR9(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF, (boolean)true) == 0) {
            this.setEnableSubWF(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF2, (boolean)true) == 0) {
            this.setEnableSubWF2(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF2()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF3, (boolean)true) == 0) {
            this.setEnableSubWF3(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF3()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF4, (boolean)true) == 0) {
            this.setEnableSubWF4(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF4()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF5, (boolean)true) == 0) {
            this.setEnableSubWF5(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF5()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF6, (boolean)true) == 0) {
            this.setEnableSubWF6(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF6()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF7, (boolean)true) == 0) {
            this.setEnableSubWF7(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF7()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF8, (boolean)true) == 0) {
            this.setEnableSubWF8(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF8()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLEDESUBWF9, (boolean)true) == 0) {
            this.setEnableSubWF9(WFParallelSubWFConfig.GetValue((String)strValue, (boolean)this.isEnableSubWF9()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }

    public String getDESubWFId2() {
        return this.strDESubWFId2;
    }

    public String getDESubWFName2() {
        return this.strDESubWFName2;
    }

    public String getDESubWFVR2() {
        return this.strDESubWFVR2;
    }

    public void setDESubWFId2(String strDESubWFId2) {
        this.strDESubWFId2 = strDESubWFId2;
    }

    public void setDESubWFName2(String strDESubWFName2) {
        this.strDESubWFName2 = strDESubWFName2;
    }

    public void setDESubWFVR2(String strDESubWFVR2) {
        this.strDESubWFVR2 = strDESubWFVR2;
    }

    public String getDESubWFId() {
        return this.strDESubWFId;
    }

    public String getDESubWFName() {
        return this.strDESubWFName;
    }

    public String getDESubWFVR() {
        return this.strDESubWFVR;
    }

    public void setDESubWFId(String strDESubWFId) {
        this.strDESubWFId = strDESubWFId;
    }

    public void setDESubWFName(String strDESubWFName) {
        this.strDESubWFName = strDESubWFName;
    }

    public void setDESubWFVR(String strDESubWFVR) {
        this.strDESubWFVR = strDESubWFVR;
    }

    public String getDESubWFId3() {
        return this.strDESubWFId3;
    }

    public String getDESubWFName3() {
        return this.strDESubWFName3;
    }

    public String getDESubWFVR3() {
        return this.strDESubWFVR3;
    }

    public void setDESubWFId3(String strDESubWFId3) {
        this.strDESubWFId3 = strDESubWFId3;
    }

    public void setDESubWFName3(String strDESubWFName3) {
        this.strDESubWFName3 = strDESubWFName3;
    }

    public void setDESubWFVR3(String strDESubWFVR3) {
        this.strDESubWFVR3 = strDESubWFVR3;
    }

    public String getDESubWFId4() {
        return this.strDESubWFId4;
    }

    public String getDESubWFName4() {
        return this.strDESubWFName4;
    }

    public String getDESubWFVR4() {
        return this.strDESubWFVR4;
    }

    public void setDESubWFId4(String strDESubWFId4) {
        this.strDESubWFId4 = strDESubWFId4;
    }

    public void setDESubWFName4(String strDESubWFName4) {
        this.strDESubWFName4 = strDESubWFName4;
    }

    public void setDESubWFVR4(String strDESubWFVR4) {
        this.strDESubWFVR4 = strDESubWFVR4;
    }

    public String getDESubWFId5() {
        return this.strDESubWFId5;
    }

    public String getDESubWFName5() {
        return this.strDESubWFName5;
    }

    public String getDESubWFVR5() {
        return this.strDESubWFVR5;
    }

    public void setDESubWFId5(String strDESubWFId5) {
        this.strDESubWFId5 = strDESubWFId5;
    }

    public void setDESubWFName5(String strDESubWFName5) {
        this.strDESubWFName5 = strDESubWFName5;
    }

    public void setDESubWFVR5(String strDESubWFVR5) {
        this.strDESubWFVR5 = strDESubWFVR5;
    }

    public String getDESubWFId6() {
        return this.strDESubWFId6;
    }

    public String getDESubWFName6() {
        return this.strDESubWFName6;
    }

    public String getDESubWFVR6() {
        return this.strDESubWFVR6;
    }

    public void setDESubWFId6(String strDESubWFId6) {
        this.strDESubWFId6 = strDESubWFId6;
    }

    public void setDESubWFName6(String strDESubWFName6) {
        this.strDESubWFName6 = strDESubWFName6;
    }

    public void setDESubWFVR6(String strDESubWFVR6) {
        this.strDESubWFVR6 = strDESubWFVR6;
    }

    public String getDESubWFId7() {
        return this.strDESubWFId7;
    }

    public String getDESubWFName7() {
        return this.strDESubWFName7;
    }

    public String getDESubWFVR7() {
        return this.strDESubWFVR7;
    }

    public void setDESubWFId7(String strDESubWFId7) {
        this.strDESubWFId7 = strDESubWFId7;
    }

    public void setDESubWFName7(String strDESubWFName7) {
        this.strDESubWFName7 = strDESubWFName7;
    }

    public void setDESubWFVR7(String strDESubWFVR7) {
        this.strDESubWFVR7 = strDESubWFVR7;
    }

    public String getDESubWFId8() {
        return this.strDESubWFId8;
    }

    public String getDESubWFName8() {
        return this.strDESubWFName8;
    }

    public String getDESubWFVR8() {
        return this.strDESubWFVR8;
    }

    public void setDESubWFId8(String strDESubWFId8) {
        this.strDESubWFId8 = strDESubWFId8;
    }

    public void setDESubWFName8(String strDESubWFName8) {
        this.strDESubWFName8 = strDESubWFName8;
    }

    public void setDESubWFVR8(String strDESubWFVR8) {
        this.strDESubWFVR8 = strDESubWFVR8;
    }

    public String getDESubWFId9() {
        return this.strDESubWFId9;
    }

    public String getDESubWFName9() {
        return this.strDESubWFName9;
    }

    public String getDESubWFVR9() {
        return this.strDESubWFVR9;
    }

    public void setDESubWFId9(String strDESubWFId9) {
        this.strDESubWFId9 = strDESubWFId9;
    }

    public void setDESubWFName9(String strDESubWFName9) {
        this.strDESubWFName9 = strDESubWFName9;
    }

    public void setDESubWFVR9(String strDESubWFVR9) {
        this.strDESubWFVR9 = strDESubWFVR9;
    }

    public boolean isEnableSubWF() {
        return this.bEnableSubWF;
    }

    public boolean isEnableSubWF2() {
        return this.bEnableSubWF2;
    }

    public boolean isEnableSubWF3() {
        return this.bEnableSubWF3;
    }

    public boolean isEnableSubWF4() {
        return this.bEnableSubWF4;
    }

    public boolean isEnableSubWF5() {
        return this.bEnableSubWF5;
    }

    public boolean isEnableSubWF6() {
        return this.bEnableSubWF6;
    }

    public boolean isEnableSubWF7() {
        return this.bEnableSubWF7;
    }

    public boolean isEnableSubWF8() {
        return this.bEnableSubWF8;
    }

    public boolean isEnableSubWF9() {
        return this.bEnableSubWF9;
    }

    public void setEnableSubWF(boolean bEnableSubWF) {
        this.bEnableSubWF = bEnableSubWF;
    }

    public void setEnableSubWF2(boolean bEnableSubWF2) {
        this.bEnableSubWF2 = bEnableSubWF2;
    }

    public void setEnableSubWF3(boolean bEnableSubWF3) {
        this.bEnableSubWF3 = bEnableSubWF3;
    }

    public void setEnableSubWF4(boolean bEnableSubWF4) {
        this.bEnableSubWF4 = bEnableSubWF4;
    }

    public void setEnableSubWF5(boolean bEnableSubWF5) {
        this.bEnableSubWF5 = bEnableSubWF5;
    }

    public void setEnableSubWF6(boolean bEnableSubWF6) {
        this.bEnableSubWF6 = bEnableSubWF6;
    }

    public void setEnableSubWF7(boolean bEnableSubWF7) {
        this.bEnableSubWF7 = bEnableSubWF7;
    }

    public void setEnableSubWF8(boolean bEnableSubWF8) {
        this.bEnableSubWF8 = bEnableSubWF8;
    }

    public void setEnableSubWF9(boolean bEnableSubWF9) {
        this.bEnableSubWF9 = bEnableSubWF9;
    }

    public Vector<WFSubWF> getWFSubWFList() {
        WFSubWF wfSubWF;
        Vector<WFSubWF> wfSubWfList = new Vector<WFSubWF>();
        if (this.isEnableSubWF()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF2()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId2());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName2());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR2());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF3()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId3());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName3());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR3());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF4()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId4());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName4());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR4());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF5()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId5());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName5());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR5());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF6()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId6());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName6());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR6());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF7()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId7());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName7());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR7());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF8()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId8());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName8());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR8());
            wfSubWfList.add(wfSubWF);
        }
        if (this.isEnableSubWF9()) {
            wfSubWF = new WFSubWF();
            wfSubWF.setDESUBWFID(this.getDESubWFId9());
            wfSubWF.setDESUBWFNAME(this.getDESubWFName9());
            wfSubWF.setDESUBWFVR(this.getDESubWFVR9());
            wfSubWfList.add(wfSubWF);
        }
        return wfSubWfList;
    }
}

