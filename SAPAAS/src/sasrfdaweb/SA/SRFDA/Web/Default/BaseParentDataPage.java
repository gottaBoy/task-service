/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDESubWFHelper
 *  SA.SRFDA.Ctrl.IDEWFHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Base.OutParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Ctrl.SRFWFStates
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.IParentDataPage;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.Base.OutParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.SRFWFStates;

public abstract class BaseParentDataPage
extends SRFDAPageEx
implements IParentDataPage {
    private boolean bCalcParentData = false;
    private IDEHelper iParentDEHelper = null;
    private BaseDataEntity parentDataEntity = null;
    private Object objParentKey = "";
    private Object objPickupDEFValue = null;
    private IPickupDEFHelper iPickupDEFHelper = null;
    private boolean bParentDataWFMode = false;
    private boolean bEnableParentDataWFSubmit = false;
    private boolean bEnableParentDataWFUpdate = false;
    private boolean bParentDataTempMode = false;

    private void CalcParentDataInfo() throws Exception {
        if (this.bCalcParentData) {
            return;
        }
        this.bCalcParentData = true;
        BaseParentDataPage.CalcParentDataInfo(this);
        BaseParentDataPage.CalcParentDataWFState(this);
        this.OnCalcParentDataInfo();
    }

    private static void CalcParentDataInfo(BaseParentDataPage baseParentDataMainPage) throws Exception {
        String strKey;
        OutParam outParentDEHelper = new OutParam();
        OutParam outPickupDEFHelper = new OutParam();
        OutParam parentKey = new OutParam();
        OutParam pickupDEFValue = new OutParam();
        BaseParentDataPage.CalcParentDataInfo(baseParentDataMainPage, (OutParam<IDEHelper>)outParentDEHelper, (OutParam<IPickupDEFHelper>)outPickupDEFHelper, (OutParam<Object>)parentKey, (OutParam<Object>)pickupDEFValue);
        baseParentDataMainPage.iParentDEHelper = (IDEHelper)outParentDEHelper.getValue();
        baseParentDataMainPage.iPickupDEFHelper = (IPickupDEFHelper)outPickupDEFHelper.getValue();
        baseParentDataMainPage.objParentKey = parentKey.getValue();
        baseParentDataMainPage.objPickupDEFValue = pickupDEFValue.getValue();
        Object objKey = parentKey.getValue();
        baseParentDataMainPage.bParentDataTempMode = objKey == null ? false : (strKey = objKey.toString()).indexOf("SRFDATEMPKEYID") == 0;
    }

    private static void CalcParentDataWFState(BaseParentDataPage page) throws Exception {
        if (page.getParentKey() == null) {
            return;
        }
        if (page.isParentDataTempMode()) {
            return;
        }
        IDEHelper iParentDEHelper = page.getParentDEHelper();
        if (!iParentDEHelper.IsEnableWF()) {
            return;
        }
        IDEWFHelper iDEWFHelper = iParentDEHelper.GetDEWFHelper();
        IDEFHelper iWFStateDEFHelper = iDEWFHelper.getWFStateField();
        if (iWFStateDEFHelper == null) {
            return;
        }
        BaseDataEntity parentData = page.getParentData();
        String strWFState = SRFWFStates.ToString((int)parentData.GetParamIntValue(iWFStateDEFHelper.getName(), 0));
        if (StringHelper.Compare((String)strWFState, (String)"WFNOTFINISH", (boolean)true) != 0) {
            return;
        }
        page.bParentDataWFMode = true;
        IDESubWFHelper iDESubWFHelper = null;
        String strDESubWFId = SRFDAWebCTXHelper.GetPDESubWFId((ISRFDAWebContext)page.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strDESubWFId)) {
            iDESubWFHelper = page.getParentDEHelper().GetDESubWFHelper(strDESubWFId);
        }
        String strWFStep = "";
        strWFStep = iDESubWFHelper == null ? parentData.GetParamStringValue(iDEWFHelper.getWFStepField().getName(), "") : parentData.GetParamStringValue(iDESubWFHelper.getWFStepField().getName(), "");
        if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
            throw new Exception("\u6d41\u7a0b\u6b65\u9aa4\u503c\u65e0\u6548");
        }
        String strWFId = "";
        if (iDESubWFHelper == null) {
            strWFStep = parentData.GetParamStringValue(iDEWFHelper.getWFStepField().getName(), "");
            strWFId = iParentDEHelper.GetDEWFId(page.getWebContext().getSRFWFMode());
        } else {
            strWFStep = parentData.GetParamStringValue(iDESubWFHelper.getWFStepField().getName(), "");
            strWFId = iDESubWFHelper.getWFId();
        }
        CallResult callResult = BaseMainPage.TestWFAction(page, iParentDEHelper, strWFId, page.getParentKey().toString(), strWFStep);
        if (callResult.IsOk()) {
            page.bEnableParentDataWFSubmit = true;
            page.bEnableParentDataWFUpdate = iDESubWFHelper == null ? iDEWFHelper.isWFStepEditable(strWFStep) : iDESubWFHelper.isWFStepEditable(strWFStep);
        }
    }

    protected void OnCalcParentDataInfo() {
    }

    @Override
    public final IDEHelper getParentDEHelper() throws Exception {
        this.CalcParentDataInfo();
        return this.iParentDEHelper;
    }

    @Override
    public final BaseDataEntity getParentData() throws Exception {
        if (this.getParentKey() == null) {
            return null;
        }
        if (this.parentDataEntity != null) {
            return this.parentDataEntity;
        }
        this.parentDataEntity = BaseParentDataPage.GetParentData(this, this.getParentDEHelper(), this.getParentKey());
        return this.parentDataEntity;
    }

    @Override
    public final Object getParentKey() throws Exception {
        this.CalcParentDataInfo();
        return this.objParentKey;
    }

    @Override
    public Object getPickupDEFValue() throws Exception {
        this.CalcParentDataInfo();
        return this.objPickupDEFValue;
    }

    @Override
    public final IPickupDEFHelper getPickupDEFHelper() throws Exception {
        this.CalcParentDataInfo();
        return this.iPickupDEFHelper;
    }

    @Override
    public final boolean isEnableParentData() throws Exception {
        return this.OnGetEnableParentData() && this.getParentDEHelper() != null;
    }

    protected boolean OnGetEnableParentData() throws Exception {
        return true;
    }

    protected void ResetParentData() {
        this.parentDataEntity = null;
        this.iParentDEHelper = null;
        this.bCalcParentData = false;
        this.objParentKey = null;
        this.objPickupDEFValue = null;
        this.bParentDataWFMode = false;
        this.bEnableParentDataWFSubmit = false;
        this.bEnableParentDataWFUpdate = false;
        this.bParentDataTempMode = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void CalcParentDataInfo(ISRFDAPage iPage, OutParam<IDEHelper> outParentDEHelper, OutParam<IPickupDEFHelper> outPickupDEFHelper, OutParam<Object> outParentKey, OutParam<Object> outPickupDEFValue) throws Exception {
        String strKeyValue;
        String strDERID = SRFDAWebCTXHelper.GetDERId((ISRFDAWebContext)iPage.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return;
        }
        IPickupDEFHelper pickupDEFHelper = iPage.getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = iPage.getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
            }
            IDEFHelper iDEFHelper = iPage.getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) {
                    return;
                }
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
            strDERID = pickupDEFHelper.GetDERId();
            iPage.getWebContext().SetParamValue("SRFDERID", strDERID);
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return;
        }
        outPickupDEFHelper.setValue(pickupDEFHelper);
        outParentDEHelper.setValue(pickupDEFHelper.GetRealDEFHelper().getDEHelper());
        boolean bAppendIndexType = false;
        String strIndexType = "";
        String strParamName = "";
        String strDERIndexId = SRFDAWebCTXHelper.GetDERIndexId((ISRFDAWebContext)iPage.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
            DERINDEX derIndex = new DERINDEX();
            CallResult callResult = iPage.getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
            }
            IDEHelper iDEHelper = iPage.getDAModelStorage().FindDEHelper(derIndex.getDEID());
            if (iDEHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
            }
            strParamName = iDEHelper.GetKeyDEFHelper().getName();
            outParentDEHelper.setValue(iDEHelper);
            IDEHelper indexDEHelper = iPage.getDAModelStorage().FindDEHelper2(derIndex.getINDEXDEID());
            if (indexDEHelper.GetIndexMode() == 1) {
                bAppendIndexType = true;
                strIndexType = derIndex.getTYPEVALUE();
            }
        } else {
            strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
        }
        if (StringHelper.IsNullOrEmpty((String)(strKeyValue = iPage.getWebContext().GetPostValue(strParamName)))) {
            strKeyValue = iPage.getWebContext().GetParamValue(strParamName);
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue) && !iPage.IsBackEndMode()) {
            strKeyValue = iPage.getWebContext().GetParamValue("SRFPARENTDATA");
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            return;
        }
        outParentKey.setValue(pickupDEFHelper.GetRealDEFHelper().GetDEFValue(strKeyValue));
        if (bAppendIndexType) {
            outPickupDEFValue.setValue((Object)BaseDEHelper.GetIndexDEKeyValueWithType((String)strIndexType, (Object)outParentKey.getValue()));
            return;
        } else {
            outPickupDEFValue.setValue(outParentKey.getValue());
        }
    }

    public static BaseDataEntity GetParentData(ISRFDAPage iPage, IDEHelper iParentDEHelper, Object objParentKey) throws Exception {
        if (objParentKey == null) {
            throw new Exception("\u65e0\u6cd5\u6307\u5b9a\u6570\u636e\u4e3b\u952e");
        }
        BaseDataEntity realDataEntity = new BaseDataEntity();
        realDataEntity.SetParamValue(iParentDEHelper.GetKeyDEFHelper().getName(), objParentKey);
        String strKey = objParentKey.toString();
        if (strKey.indexOf("SRFDATEMPKEYID") == 0) {
            return realDataEntity;
        }
        IDEDataCtrl iRealDataCtrl = iPage.getDEDataCtrl2(iParentDEHelper.getId());
        CallResult callResult = iRealDataCtrl.Get(realDataEntity);
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)iRealDataCtrl.GetDEHelper().getName(), (Object)callResult.getErrorInfo()));
        }
        return realDataEntity;
    }

    @Override
    public boolean isParentDataInWorkflow() throws Exception {
        this.CalcParentDataInfo();
        return this.bParentDataWFMode;
    }

    @Override
    public boolean isParentDataEnableWFSubmit() throws Exception {
        this.CalcParentDataInfo();
        return this.bEnableParentDataWFSubmit;
    }

    @Override
    public boolean isParentDataEnableWFUpdate() throws Exception {
        this.CalcParentDataInfo();
        return this.bEnableParentDataWFUpdate;
    }

    @Override
    public boolean isParentDataTempMode() throws Exception {
        this.CalcParentDataInfo();
        return this.bParentDataTempMode;
    }

    protected final boolean ProcessParentDataTag() throws Exception {
        return this.OnProcessParentDataTag();
    }

    protected boolean OnProcessParentDataTag() throws Exception {
        if (!this.isEnableParentData()) {
            return true;
        }
        String strParentDataTag = this.CalcParentDataTag();
        boolean bRedirect = false;
        String strCurParentDataTag = this.getWebContext().GetParamValue("SRFPARENTDATATAG");
        if (StringHelper.IsNullOrEmpty((String)strCurParentDataTag)) {
            if (!StringHelper.IsNullOrEmpty((String)strParentDataTag)) {
                if (!this.IsBackEndMode()) {
                    this.getWebContext().SetParamValue("SRFPARENTDATATAG", strParentDataTag);
                } else {
                    bRedirect = true;
                }
            }
        } else {
            if (StringHelper.Compare((String)strCurParentDataTag, (String)strParentDataTag, (boolean)false) == 0) {
                return true;
            }
            this.getWebContext().SetParamValue("SRFPARENTDATATAG", strParentDataTag);
            bRedirect = true;
        }
        if (bRedirect) {
            if (this.getParentKey() == null) {
                this.getWebContext().SetParamValue("SRFPARENTDATA", "");
            } else {
                this.getWebContext().SetParamValue("SRFPARENTDATA", this.getParentKey().toString());
            }
            return this.RedirectCurrentPath();
        }
        return true;
    }

    protected final String CalcParentDataTag() throws Exception {
        return this.OnCalcParentDataTag();
    }

    protected String OnCalcParentDataTag() throws Exception {
        String strParentDataTag = "";
        if (StringHelper.Compare((String)this.getPickupDEFHelper().GetDERId(), (String)this.getDEHelper().GetMajorDERId(), (boolean)false) == 0) {
            strParentDataTag = StringHelper.Format((String)"%1$s_%2$s_%3$s", (Object)(this.isParentDataInWorkflow() ? "1" : "0"), (Object)(this.isParentDataEnableWFSubmit() ? "1" : "0"), (Object)(this.isParentDataEnableWFUpdate() ? "1" : "0"));
        }
        return strParentDataTag;
    }
}
