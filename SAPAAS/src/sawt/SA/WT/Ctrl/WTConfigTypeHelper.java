/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTConfigValueHelper;
import SA.WT.Ctrl.WTBaseObject;
import SA.WT.Ctrl.WTConfigValueHelper;
import SA.WT.Data.WTConfigType;
import SA.WT.Data.WTConfigValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class WTConfigTypeHelper
extends WTBaseObject
implements IWTConfigTypeHelper {
    private WTConfigType imConfigType = null;
    private HashMap<String, IWTConfigValueHelper> imConfigValueHelperMap = new HashMap();
    private ArrayList<IWTConfigValueHelper> imConfigValueHelperList = new ArrayList();
    private Boolean bPrepareWTConfigValue = false;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WTConfigType imConfigType) throws Exception {
        this.imConfigType = imConfigType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.imConfigType.getWTCONFIGTYPEID());
        this.setName(this.imConfigType.getWTCONFIGTYPENAME().toUpperCase());
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    protected synchronized void PrepareWTConfigValue() throws Exception {
        if (this.bPrepareWTConfigValue.booleanValue()) {
            return;
        }
        this.OnPrepareWTConfigValue();
        this.bPrepareWTConfigValue = true;
    }

    protected synchronized void OnPrepareWTConfigValue() throws Exception {
        Vector<WTConfigValue> WTConfigValues = new Vector<WTConfigValue>();
        CallResult callResult = this.getWTModelHelper().GetWTConfigValues(this.getId(), WTConfigValues);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2WT\u914d\u7f6e\u7c7b\u578b[%1$s]\u503c\u660e\u7ec6\u5931\u8d25\uff0c%2$s", (Object)this.getId(), (Object)callResult.getErrorInfo()));
        }
        this.imConfigValueHelperMap.clear();
        this.imConfigValueHelperList.clear();
        for (WTConfigValue imConfigValue : WTConfigValues) {
            WTConfigValueHelper iWTConfigValueHelper = new WTConfigValueHelper();
            iWTConfigValueHelper.Init(this.getDAGlobalHelper(), this, imConfigValue);
            if (this.imConfigValueHelperMap.containsKey(iWTConfigValueHelper.getName())) {
                int nOldIimex = this.imConfigValueHelperList.indexOf(this.imConfigValueHelperMap.get(iWTConfigValueHelper.getName()));
                if (nOldIimex == -1) {
                    this.imConfigValueHelperList.add(iWTConfigValueHelper);
                } else {
                    this.imConfigValueHelperList.remove(nOldIimex);
                    this.imConfigValueHelperList.add(nOldIimex, iWTConfigValueHelper);
                }
                this.imConfigValueHelperMap.put(iWTConfigValueHelper.getName(), iWTConfigValueHelper);
                continue;
            }
            this.imConfigValueHelperMap.put(iWTConfigValueHelper.getName(), iWTConfigValueHelper);
            this.imConfigValueHelperList.add(iWTConfigValueHelper);
        }
    }

    @Override
    public IWTConfigValueHelper FindDefaultWTConfigValue() throws Exception {
        return this.FindWTConfigValue("DEFAULT");
    }

    @Override
    public IWTConfigValueHelper FindWTConfigValue(String strWTConfigValueName) throws Exception {
        this.PrepareWTConfigValue();
        IWTConfigValueHelper iWTConfigValueHelper = this.imConfigValueHelperMap.get(strWTConfigValueName.toUpperCase());
        if (iWTConfigValueHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u914d\u7f6e\u503c[%1$s]", (Object)strWTConfigValueName));
        }
        return iWTConfigValueHelper;
    }

    @Override
    public Iterator<IWTConfigValueHelper> getWTConfigValues() throws Exception {
        this.PrepareWTConfigValue();
        return this.imConfigValueHelperList.iterator();
    }
}

