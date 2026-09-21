/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFFormItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEFFormItem
implements IDEFFormCtrl {
    protected IDEFHelper iDEFHelper = null;
    protected DEFFormItemConfig defFormItemConfig = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;

    @Override
    public CallResult Init(IDEFHelper iDEFHelper, DEFFormItemConfig defFormItemConfig, ISRFDAGlobalHelper globalHelperEx) {
        this.iDEFHelper = iDEFHelper;
        this.globalHelperEx = globalHelperEx;
        this.defFormItemConfig = defFormItemConfig;
        return new CallResult();
    }

    @Override
    public String GetFormCtrlId() {
        return this.iDEFHelper.getName();
    }

    @Override
    public boolean IsAllowEmpty() {
        if (!this.iDEFHelper.IsPhisicalDEField() && !(this.iDEFHelper instanceof IInheritDEFHelper)) {
            return true;
        }
        if (this.iDEFHelper.GetDTColumn().IsValueAutoGen()) {
            return true;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.GetDefaultValueType())) {
            return true;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.GetDefaultValue())) {
            return true;
        }
        return this.iDEFHelper.getDEField().isNULLABLE();
    }

    @Override
    public boolean IsEnableFormCreate() {
        return this.iDEFHelper.getDEField().isENABLECREATE();
    }

    @Override
    public boolean IsEnableFormUpdate() {
        return this.iDEFHelper.getDEField().isENABLEMODIFY();
    }

    @Override
    public String GetUserParam() {
        return this.iDEFHelper.getDEField().getFORMITEMCONFIG();
    }

    @Override
    public boolean IsReadonly() {
        return false;
    }

    @Override
    public int GetStringLengthRule() {
        String strDataType = this.iDEFHelper.GetStdDataType();
        int nDataType = DataTypeHelper.FromString((String)strDataType);
        if (DataTypeHelper.IsStringType((int)nDataType)) {
            if (DataTypeHelper.IsLongStringType((int)nDataType)) {
                return 655360;
            }
            if (this.iDEFHelper.getDEField().getUNICODETEXT()) {
                return this.iDEFHelper.GetDTColumn().GetLength() / 2;
            }
            return this.iDEFHelper.GetDTColumn().GetLength();
        }
        return 0;
    }

    @Override
    public String GetItemFormat() {
        return this.OnGetItemFormat();
    }

    protected String OnGetItemFormat() {
        if (!StringHelper.IsNullOrEmpty((String)this.iDEFHelper.getDEField().getFORMITEMFORMAT())) {
            return this.iDEFHelper.getDEField().getFORMITEMFORMAT();
        }
        if (this.iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
            return inheritDEFHelper.GetRelatedDEFHelper().GetFormCtrl().GetItemFormat();
        }
        if (this.iDEFHelper.IsLinkDEField() && !this.iDEFHelper.IsPhisicalDEField()) {
            ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)this.iDEFHelper;
            return iLinkDEFHelper.GetRelatedDEFHelper().GetFormCtrl().GetItemFormat();
        }
        return this.defFormItemConfig.getItemFormat();
    }

    @Override
    public String GetFormItemStyle() {
        return "";
    }

    @Override
    public boolean IsKey() {
        return this.iDEFHelper.GetDTColumn().IsPKey();
    }

    @Override
    public String GetUserControlConfig() {
        return this.iDEFHelper.getDEField().getFORMITEMXML();
    }

    @Override
    public String GetDefaultValueType() {
        return this.iDEFHelper.getDEField().getFORMDVT();
    }

    @Override
    public String GetDefaultValue() {
        return this.iDEFHelper.getDEField().getFORMDV();
    }
}

