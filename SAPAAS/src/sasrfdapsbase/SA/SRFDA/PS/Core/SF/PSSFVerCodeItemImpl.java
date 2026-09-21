/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.IPSSFVerCodeItem;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSSFVerCodeItemImpl
extends PSSFObjectImpl
implements IPSSFVerCodeItem {
    private IPSSFVerCode iPSSFVerCode = null;
    private PSSFVerCodeItem psSFVerCodeItem = null;
    private PSSFCodeTempl psSFCodeTempl = new PSSFCodeTempl();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFVerCode iPSSFVerCode, PSSFVerCodeItem psSFVerCodeItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFVerCode = iPSSFVerCode;
        this.psSFVerCodeItem = psSFVerCodeItem;
        this.setId(this.psSFVerCodeItem.getPSSFVERCODEITEMID());
        this.setName(this.psSFVerCodeItem.getPSSFVERCODEITEMNAME());
        this.setPSObjectData(this.psSFVerCodeItem);
        this.psSFVerCodeItem.CopyTo(this.psSFCodeTempl, false);
        this.setPSSF(this.iPSSFVerCode.getPSSF());
        this.onInit();
    }

    @Override
    public PSSFCodeTempl getPSSFCodeTemplData() {
        return this.psSFCodeTempl;
    }

    @Override
    public IPSSFVerCode getPSSFVerCode() {
        return this.iPSSFVerCode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSFVerCode().getPSSysModelInstId();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeType iPSSFCodeType, PSSFCodeTempl psSFCodeTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplDesc() {
        return "";
    }

    @Override
    public String getLogicName() {
        return "";
    }
}

