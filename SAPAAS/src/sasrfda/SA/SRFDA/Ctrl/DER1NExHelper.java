/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DER1NHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DER1NEx;
import SA.SRFDA.Ctrl.IDER1NExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DER1NExHelper
extends DER1NHelper
implements IDER1NExHelper {
    private String strDEId = "";
    private String strDER1NId = "";
    private String strMemo = "";
    private String strDERIndexId = "";
    private String strIndexDEId = "";
    protected DER1NEx der1NEx = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DER1NEx der1nEx) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        DER1N der1N = new DER1N();
        CallResult callResult = this.getDAModelHelper().GetDER1N(der1nEx.getDER1NID(), der1N);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2DER1N\u6570\u636e\u53d1[%1$s]\u751f\u9519\u8bef,%2$s", (Object)der1nEx.getDER1NID(), (Object)callResult.getErrorInfo()));
        }
        super.Init(iDAGlobalHelper, der1N);
        this.InitModel(der1nEx);
    }

    @Override
    public String getDEId() {
        return this.strDEId;
    }

    protected void setDEId(String strValue) {
        this.strDEId = strValue;
    }

    @Override
    public String getDER1NId() {
        return this.strDER1NId;
    }

    protected void setDER1NId(String strValue) {
        this.strDER1NId = strValue;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    protected void setMemo(String strValue) {
        this.strMemo = strValue;
    }

    @Override
    public String getDERIndexId() {
        return this.strDERIndexId;
    }

    protected void setDERIndexId(String strValue) {
        this.strDERIndexId = strValue;
    }

    @Override
    public String getIndexDEId() {
        return this.strIndexDEId;
    }

    protected void setIndexDEId(String strValue) {
        this.strIndexDEId = strValue;
    }

    private void InitModel(DER1NEx item) {
        this.setShowName1N(item.getDER1NEXNAME());
        if (!item.isDEIDNull()) {
            this.setDEId(item.getDEID());
        }
        if (!item.isDER1NIDNull()) {
            this.setDER1NId(item.getDER1NID());
        }
        if (!item.isDEACMODEIDNull()) {
            this.setDEACModeId(item.getDEACMODEID());
        }
        if (!item.isDERTYPEIDNull()) {
            this.setDERTypeId(item.getDERTYPEID());
        }
        if (!item.isMAJORDEIDNull()) {
            this.setMajorDEId(item.getMAJORDEID());
        }
        if (!item.isPICKUPPAGEIDNull()) {
            this.setPickupPageId(item.getPICKUPPAGEID());
        }
        if (!item.isRELATEDPAGEIDNull()) {
            this.setRelatedPageId(item.getRELATEDPAGEID());
        }
        if (!item.isSHOWNAMELANRESIDNull()) {
            this.setShowNameLanResId(item.getSHOWNAMELANRESID());
        }
        if (!item.isMEMONull()) {
            this.setMemo(item.getMEMO());
        }
        if (!item.isSHOWORDERNull()) {
            this.setShowOrder(item.getSHOWORDER());
        }
        if (!item.isMPICKUPPAGEIDNull()) {
            this.setMPickupPageId(item.getMPICKUPPAGEID());
        }
        if (!item.isDERINDEXIDNull()) {
            this.setDERIndexId(item.getDERINDEXID());
        }
        if (!item.isINDEXDEIDNull()) {
            this.setIndexDEId(item.getINDEXDEID());
        }
    }
}

