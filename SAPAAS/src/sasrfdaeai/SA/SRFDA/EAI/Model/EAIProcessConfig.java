/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFramework.Utility.StringHelper;

public class EAIProcessConfig
extends EAIBaseProcessConfig {
    public static String TAG_EAIPROCESS = "SRFEXEAIPPROCESS";
    public static String TAG_NEXT = "NEXT";
    public static String TAG_PROCESSTYPE = "PROCESSTYPE";
    protected String strNext = "";
    protected String strProcessType = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NEXT, (boolean)true) == 0) {
            this.setNext(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSTYPE, (boolean)true) == 0) {
            this.setProcessType(strValue);
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

    public String getProcessType() {
        return this.strProcessType;
    }

    public void setProcessType(String strProcessType) {
        this.strProcessType = strProcessType;
    }

    protected Object CreateCloneObject() {
        return new EAIProcessConfig();
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        EAIProcessConfig obj = (EAIProcessConfig)((Object)dst);
        obj.setNext(this.getNext());
        obj.setProcessType(this.getProcessType());
    }
}

