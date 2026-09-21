/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.DADVHelper
 */
package SA.SRFDA.Web.PDA;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.PDA.BasePDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.DADVHelper;

public class EditPage
extends BasePDAPage {
    protected IDEDataCtrl iDEDataCtrl = null;
    protected BaseDataEntity dataEntity = new BaseDataEntity();

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.OnGetDataEntityId();
        return this.LoadPageDataEntity();
    }

    protected void OnInit() {
        super.OnInit();
        if (this.isSubmitMode()) {
            boolean bInsert;
            SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
            CallResult callResult = null;
            SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
            IDEDataCtrl iDEDataCtrl = this.getDEDataCtrl();
            if (!this.FillDataEntity(this.dataEntity, true)) {
                return;
            }
            boolean bl = bInsert = !this.IsFormContainKey(this.dataEntity);
            if (!bInsert) {
                BaseDataEntity checkkeyparam = new BaseDataEntity();
                this.dataEntity.CopyTo(checkkeyparam, true);
                callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
                if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                    return;
                }
                int nState = (Integer)callResult.getUserObject();
                if (nState == 0) {
                    bInsert = true;
                } else if (nState == 1) {
                    bInsert = false;
                } else {
                    return;
                }
            }
            if (bInsert) {
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    if (iDEFHelper.IsKeyDEField()) continue;
                    String strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
                    String strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
                    if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0 || this.dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                    this.dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
                }
            }
            if (bInsert) {
                callResult = this.OnSaveActionBeforeInsert(this.dataEntity);
                if (callResult.getRetCode() != 0) {
                    return;
                }
                String strInsertMode = this.GetInsertMode();
                callResult = iDEDataCtrl.Save(true, strInsertMode, this.dataEntity);
                if (callResult.getRetCode() == 0) {
                    callResult = this.OnSaveActionAfterInsert(callResult, this.dataEntity);
                }
            } else {
                callResult = this.OnSaveActionBeforeUpdate(this.dataEntity);
                if (callResult.getRetCode() != 0) {
                    return;
                }
                String strUpdateMode = this.GetUpdateMode();
                callResult = iDEDataCtrl.Save(false, strUpdateMode, this.dataEntity);
                if (callResult.getRetCode() == 0) {
                    callResult = this.OnSaveActionAfterUpdate(callResult, this.dataEntity);
                }
            }
            saveResult.From(callResult);
            saveResult.getRetCode();
        } else {
            if (!this.FillDataEntity(this.dataEntity, true)) {
                return;
            }
            CallResult callResult = this.OnTestDataAction(this.dataEntity, "READ");
            if (callResult.getRetCode() != 0) {
                return;
            }
            String strKeyData = this.dataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
            callResult = this.getDEDataCtrl().Get(this.dataEntity);
            callResult.getRetCode();
        }
    }

    protected String GetInsertMode() {
        return "DEFAULT";
    }

    protected String GetUpdateMode() {
        return "DEFAULT";
    }

    protected boolean FillDataEntity(BaseDataEntity dataEntity, boolean bKeyOnly) {
        return true;
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.getDEHelper().GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected boolean IsFormContainKey(BaseDataEntity dataEntity) {
        String strKey = dataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
        return !StringHelper.IsNullOrEmpty((String)strKey);
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(dataEntity, "CREATE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        CallResult callResult;
        String strAction = this.GetUpdateMode();
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)"DEFAULT", (boolean)true) == 0) {
            strAction = "UPDATE";
        }
        if ((callResult = this.OnTestDataAction(dataEntity, strAction)).getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        return "";
    }

    protected IDEDataCtrl getDEDataCtrl() {
        if (this.iDEDataCtrl != null) {
            return this.iDEDataCtrl;
        }
        this.iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        return this.iDEDataCtrl;
    }

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    public String GetItemValue(String strParamName) {
        return this.GetItemValue(strParamName, "%1$s", "");
    }

    public String GetItemValue(String strParamName, String strFormat) {
        return this.GetItemValue(strParamName, strFormat, "");
    }

    public String GetItemValue(String strParamName, String strFormat, String strDefault) {
        Object objValue = this.dataEntity.GetParamValue(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return StringHelper.Format((String)strFormat, (Object)objValue);
    }
}

