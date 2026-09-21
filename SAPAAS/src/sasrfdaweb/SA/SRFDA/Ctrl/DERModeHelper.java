/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.DERMode
 *  SA.SRFDA.Ctrl.IDERModeHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DERMode;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DERModeHelper
extends BaseDAObjectHelper
implements IDERModeHelper {
    private String strMemo = "";
    private int nVersion = 0;
    private String strHelperObject = "";
    private int nOrderFlag = 0;
    private String strHelperParam = "";
    private String strTVPPublisher = "";
    private String strTVPPublisherParam = "";
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected DERMode derMode = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DERMode derMode) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.derMode = derMode;
        this.InitModel(this.derMode);
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public String getMemo() {
        return this.strMemo;
    }

    protected void setMemo(String strValue) {
        this.strMemo = strValue;
    }

    public String getHelperObject() {
        return this.strHelperObject;
    }

    protected void setHelperObject(String strValue) {
        this.strHelperObject = strValue;
    }

    public int getOrderFlag() {
        return this.nOrderFlag;
    }

    protected void setOrderFlag(int nValue) {
        this.nOrderFlag = nValue;
    }

    public String getHelperParam() {
        return this.strHelperParam;
    }

    protected void setHelperParam(String strValue) {
        this.strHelperParam = strValue;
    }

    public String getTVPPublisher() {
        return this.strTVPPublisher;
    }

    protected void setTVPPublisher(String strValue) {
        this.strTVPPublisher = strValue;
    }

    public String getTVPPublisherParam() {
        return this.strTVPPublisherParam;
    }

    protected void setTVPPublisherParam(String strValue) {
        this.strTVPPublisherParam = strValue;
    }

    protected void InitModel(DERMode item) {
        this.setMemo(item.getMEMO());
        this.setVersion(item.getVERSION());
        this.setHelperObject(item.getHELPEROBJECT());
        this.setOrderFlag(item.getORDERFLAG());
        this.setHelperParam(item.getHELPERPARAM());
        this.setTVPPublisher(item.getTVPPUBLISHER());
        this.setTVPPublisherParam(item.getTVPPUBLISHERPARAM());
    }
}

