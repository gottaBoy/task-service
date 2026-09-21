/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseParentDataPage;
import SA.SRFDA.Web.IActiveDataPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseActiveDataPage
extends BaseParentDataPage
implements IActiveDataPage {
    private BaseDataEntity activeData = null;
    private boolean bCalcActiveData = false;
    private boolean bCopyMode = false;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.bCopyMode = this.OnGetCopyMode();
        return true;
    }

    protected boolean isCopyMode() {
        return this.bCopyMode;
    }

    protected boolean OnGetCopyMode() {
        if (this.IsBackEndMode()) {
            return this.getWebContext().getCopyMode();
        }
        return SRFDAWebCTXHelper.IsCopyMode((ISRFDAWebContext)this.getWebContext());
    }

    @Override
    public final BaseDataEntity getActiveData() throws Exception {
        if (!this.bCalcActiveData) {
            this.activeData = this.OnGetActiveData();
            this.bCalcActiveData = true;
        }
        return this.activeData;
    }

    protected BaseDataEntity OnGetActiveData() throws Exception {
        Object objValue;
        if (SRFDAWebCTXHelper.IsNewDataMode((ISRFDAWebContext)this.getWebContext())) {
            return null;
        }
        if (this.isCopyMode()) {
            return null;
        }
        String strKeyData = this.getWebContext().GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyData)) {
            if (!this.IsBackEndMode()) {
                strKeyData = SRFDAWebCTXHelper.GetDAKey((ISRFDAWebContext)this.getWebContext());
                if (StringHelper.IsNullOrEmpty((String)strKeyData)) {
                    return null;
                }
            } else {
                return null;
            }
        }
        if ((objValue = DataTypeParse.Parse((String)this.getDEHelper().GetKeyDEFHelper().GetStdDataType(), (String)strKeyData)) == null) {
            throw new Exception(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u4f20\u5165\u952e\u503c[%1$s]\u5b9e\u9645\u7c7b\u578b\u503c\u5931\u8d25", (Object)strKeyData)));
        }
        BaseDataEntity activeDataEntity = new BaseDataEntity();
        activeDataEntity.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), objValue);
        IDEDataCtrl deDataCtrl = this.getDEDataCtrl2(this.getDEHelper().getId());
        CallResult callResult = deDataCtrl.Get(activeDataEntity);
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objValue, (Object)callResult.getErrorInfo()));
        }
        return activeDataEntity;
    }

    @Override
    public final boolean isEnableActiveData() {
        return this.OnGetEnableActiveData();
    }

    protected boolean OnGetEnableActiveData() {
        return true;
    }

    protected void ResetActiveData() {
        this.activeData = null;
        this.bCalcActiveData = false;
    }
}

