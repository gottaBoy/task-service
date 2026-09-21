/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.BaseDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LinkDEFHelper
extends BaseDEFHelper
implements ILinkDEFHelper {
    protected IDEFHelper relatedDEFHelper = null;
    protected IDEFHelper realDEFHelper = null;
    private static final Log log = LogFactory.getLog(LinkDEFHelper.class);
    private boolean bCalcDERId = false;
    private String strDERId = "";

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strRelatedDEFieldId = this.GetRelatedDEField();
        if (StringHelper.IsNullOrEmpty((String)strRelatedDEFieldId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9a\u4e49\u5173\u7cfb\u5c5e\u6027", (Object)this.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEField relatedDEField = this.GetRelatedDEField(strRelatedDEFieldId);
        if (relatedDEField == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper iDEHelper = null;
        iDEHelper = StringHelper.Compare((String)relatedDEField.getDEID(), (String)this.iDEHelper.getId(), (boolean)true) == 0 ? this.iDEHelper : this.globalHelperEx.getDAModelStorage().FindDEHelper(relatedDEField.getDEID());
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)relatedDEField.getDEID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.relatedDEFHelper = iDEHelper.GetDEFHelper(relatedDEField);
        if (this.relatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)relatedDEField.getDEFID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    protected String GetRelatedDEField() {
        if (StringHelper.Compare((String)this.field.getDERTYPE(), (String)"DERCUSTOM", (boolean)true) == 0) {
            return this.field.getRDEFID2();
        }
        return this.field.getRELATEDDEFIELD();
    }

    @Override
    public IDEFHelper GetRealDEFHelper() {
        this.PrepareRealDEField();
        return this.realDEFHelper;
    }

    @Override
    public IDEFHelper GetRelatedDEFHelper() {
        return this.relatedDEFHelper;
    }

    protected synchronized void PrepareRealDEField() {
        if (this.realDEFHelper != null) {
            return;
        }
        if (this.relatedDEFHelper.IsLinkDEField()) {
            ILinkDEFHelper iLinkDEFHelper = null;
            if (this.relatedDEFHelper instanceof ILinkDEFHelper) {
                iLinkDEFHelper = (ILinkDEFHelper)this.relatedDEFHelper;
            }
            if (iLinkDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ILinkDEFHelper]", (Object)this.relatedDEFHelper.GetFullName()));
            }
            this.realDEFHelper = iLinkDEFHelper.GetRealDEFHelper();
            if (this.realDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.relatedDEFHelper.GetFullName()));
            }
        } else {
            this.realDEFHelper = this.relatedDEFHelper;
        }
    }

    protected DEField GetRelatedDEField(String strRelatedDEFieldId) {
        DEField deField = new DEField();
        CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDEField(strRelatedDEFieldId, deField);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u539f\u56e0:%2$s", (Object)strRelatedDEFieldId, (Object)(callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo())));
            return null;
        }
        return deField;
    }

    @Override
    public boolean IsLinkDEField() {
        return true;
    }

    @Override
    public boolean IsPhisicalDEField() {
        return false;
    }

    @Override
    public String GetDERId() {
        if (!this.bCalcDERId) {
            this.bCalcDERId = true;
            this.strDERId = this.OnGetDERId();
        }
        return this.strDERId;
    }

    protected String OnGetDERId() {
        if (StringHelper.Compare((String)this.field.getDERTYPE(), (String)"DERCUSTOM", (boolean)true) == 0) {
            return this.field.getDERCUSTOMID();
        }
        return this.field.getDERID();
    }

    @Override
    public boolean IsCustomJoin() {
        return StringHelper.Compare((String)this.field.getDERTYPE(), (String)"DERCUSTOM", (boolean)true) == 0;
    }

    @Override
    protected String OnGetStdDataType() {
        return this.GetRealDEFHelper().GetStdDataType();
    }

    @Override
    protected CallResult OnPrepareCreateDEField(Vector<ValueError> errs) {
        CallResult callResult = new CallResult();
        String strDataType = this.field.getDATATYPE();
        if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
            ValueError err = new ValueError();
            err.setErrorCode(3);
            err.setErrorInfo("\u6570\u636e\u7c7b\u578b\u4e0d\u88ab\u65b0\u5efa\u5c5e\u6027\u652f\u6301!");
            err.setValue("DATATYPE");
            errs.add(err);
            callResult.setRetCode(5);
            return callResult;
        }
        if (StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) != 0 && StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) != 0) {
            ValueError err = new ValueError();
            err.setErrorCode(3);
            err.setErrorInfo("\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61\u4e0d\u652f\u6301\u6b64\u6570\u636e\u7c7b\u578b!");
            err.setValue("DATATYPE");
            errs.add(err);
            callResult.setRetCode(5);
            return callResult;
        }
        String strDERType = this.field.getDERTYPE();
        if (StringHelper.Compare((String)strDERType, (String)"DERCUSTOM", (boolean)true) == 0) {
            DERCUSTOM derCustom;
            ValueError err;
            String strDERID = this.field.getDERCUSTOMID();
            String strRDEFID = this.field.getRDEFID2();
            this.field.setDEFTYPE(3);
            if (StringHelper.IsNullOrEmpty((String)strDERID)) {
                err = new ValueError();
                err.setErrorCode(1);
                err.setErrorInfo("\u5b9e\u4f53\u5173\u7cfb\u4e0d\u80fd\u4e3a\u7a7a!");
                err.setValue("DERCUSTOMID");
                errs.add(err);
            }
            if (StringHelper.IsNullOrEmpty((String)strRDEFID)) {
                err = new ValueError();
                err.setErrorCode(1);
                err.setErrorInfo("\u5173\u8054\u5c5e\u6027\u4e0d\u80fd\u4e3a\u7a7a!");
                err.setValue("RDEFID2");
                errs.add(err);
            }
            if ((derCustom = this.getDEHelper().FindDERCUSTOM(false, strDERID)) == null) {
                ValueError err2 = new ValueError();
                err2.setErrorCode(3);
                err2.setErrorInfo("\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u5931\u8d25\uff0c\u8bf7\u786e\u8ba4!");
                err2.setValue("DERCUSTOMID");
                errs.add(err2);
            } else {
                String strDEID = this.iDEHelper.getId();
                if (StringHelper.Compare((String)derCustom.getMINORDEID(), (String)strDEID, (boolean)true) != 0) {
                    ValueError err3 = new ValueError();
                    err3.setErrorCode(3);
                    err3.setErrorInfo("\u5b9e\u4f53\u5173\u7cfb\u5e76\u4e0d\u5c5e\u4e8e\u5f53\u524d\u5b9e\u4f53!");
                    err3.setValue("DERCUSTOMID");
                    errs.add(err3);
                } else {
                    String strMajorDEID = derCustom.getMAJORDEID();
                    IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strMajorDEID);
                    if (iMajorDEHelper == null) {
                        ValueError err4 = new ValueError();
                        err4.setErrorCode(3);
                        err4.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5173\u8054\u5b9e\u4f53\u7684\u8f85\u52a9\u5bf9\u8c61!");
                        err4.setValue("DERCUSTOMID");
                        errs.add(err4);
                    } else {
                        IDEFHelper iDEFHelper = iMajorDEHelper.GetDEFHelper(strRDEFID);
                        if (iDEFHelper == null) {
                            ValueError err5 = new ValueError();
                            err5.setErrorCode(3);
                            err5.setErrorInfo("\u5173\u8054\u5c5e\u6027\u4e0d\u5c5e\u4e8e\u5173\u7cfb\u5b9e\u4f53!");
                            err5.setValue("DERCUSTOMID");
                            errs.add(err5);
                        }
                    }
                }
            }
        } else {
            ValueError err;
            String strDERID = this.field.getDERID();
            String strRDEFID = this.field.getRELATEDDEFIELD();
            this.field.setDEFTYPE(3);
            if (StringHelper.IsNullOrEmpty((String)strDERID)) {
                err = new ValueError();
                err.setErrorCode(1);
                err.setErrorInfo("\u5b9e\u4f53\u5173\u7cfb\u4e0d\u80fd\u4e3a\u7a7a!");
                err.setValue("DATATYPEPARAM4");
                errs.add(err);
            }
            if (StringHelper.IsNullOrEmpty((String)strRDEFID)) {
                err = new ValueError();
                err.setErrorCode(1);
                err.setErrorInfo("\u5173\u8054\u5c5e\u6027\u4e0d\u80fd\u4e3a\u7a7a!");
                err.setValue("DATATYPEPARAM");
                errs.add(err);
            }
            DER1N der1N = new DER1N();
            callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(strDERID, der1N);
            if (callResult.getRetCode() != 0) {
                ValueError err6 = new ValueError();
                err6.setErrorCode(3);
                err6.setErrorInfo("\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u5931\u8d25\uff0c\u8bf7\u786e\u8ba4!");
                err6.setValue("DATATYPEPARAM4");
                errs.add(err6);
            } else {
                String strDEID = this.iDEHelper.getId();
                if (StringHelper.Compare((String)der1N.getMINORDEID(), (String)strDEID, (boolean)true) != 0) {
                    ValueError err7 = new ValueError();
                    err7.setErrorCode(3);
                    err7.setErrorInfo("\u5b9e\u4f53\u5173\u7cfb\u5e76\u4e0d\u5c5e\u4e8e\u5f53\u524d\u5b9e\u4f53!");
                    err7.setValue("DATATYPEPARAM4");
                    errs.add(err7);
                } else {
                    String strMajorDEID = der1N.getMAJORDEID();
                    IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strMajorDEID);
                    if (iMajorDEHelper == null) {
                        ValueError err8 = new ValueError();
                        err8.setErrorCode(3);
                        err8.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5173\u8054\u5b9e\u4f53\u7684\u8f85\u52a9\u5bf9\u8c61!");
                        err8.setValue("DATATYPEPARAM4");
                        errs.add(err8);
                    } else {
                        IDEFHelper iDEFHelper = iMajorDEHelper.GetDEFHelper(strRDEFID);
                        if (iDEFHelper == null) {
                            ValueError err9 = new ValueError();
                            err9.setErrorCode(3);
                            err9.setErrorInfo("\u5173\u8054\u5c5e\u6027\u4e0d\u5c5e\u4e8e\u5173\u7cfb\u5b9e\u4f53!");
                            err9.setValue("DATATYPEPARAM");
                            errs.add(err9);
                        }
                    }
                }
            }
        }
        if (errs.size() == 0) {
            callResult.setRetCode(0);
        } else {
            callResult.setRetCode(5);
        }
        return callResult;
    }

    @Override
    protected String OnGetCodeList() {
        if (!StringHelper.IsNullOrEmpty((String)this.field.getCODELIST())) {
            return this.field.getCODELIST();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.field.getCODELISTID())) {
            return this.field.getCODELISTID();
        }
        String strCodeList = this.GetRealDEFHelper().GetCodeList();
        if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
            return strCodeList;
        }
        return super.OnGetCodeList();
    }

    @Override
    protected String OnGetDefaultFormItemStyle() {
        return "SRFEXSPANEX";
    }
}

