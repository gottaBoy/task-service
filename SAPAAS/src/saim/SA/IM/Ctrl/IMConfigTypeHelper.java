/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMConfigType;
import SA.IM.Ctrl.Data.IMConfigValue;
import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.IM.Ctrl.IIMConfigValueHelper;
import SA.IM.Ctrl.IMBaseObject;
import SA.IM.Ctrl.IMConfigValueHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class IMConfigTypeHelper
extends IMBaseObject
implements IIMConfigTypeHelper {
    private IMConfigType imConfigType = null;
    private HashMap<String, IIMConfigValueHelper> imConfigValueHelperMap = new HashMap();
    private ArrayList<IIMConfigValueHelper> imConfigValueHelperList = new ArrayList();
    private Boolean bPrepareIMConfigValue = false;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IMConfigType imConfigType) throws Exception {
        this.imConfigType = imConfigType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.imConfigType.getIMCONFIGTYPEID());
        this.setName(this.imConfigType.getIMCONFIGTYPENAME().toUpperCase());
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    protected synchronized void PrepareIMConfigValue() throws Exception {
        if (this.bPrepareIMConfigValue.booleanValue()) {
            return;
        }
        this.OnPrepareIMConfigValue();
        this.bPrepareIMConfigValue = true;
    }

    protected synchronized void OnPrepareIMConfigValue() throws Exception {
        Vector<IMConfigValue> IMConfigValues = new Vector<IMConfigValue>();
        CallResult callResult = this.getIMModelHelper().GetIMConfigValues(this.getId(), IMConfigValues);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2IM\u914d\u7f6e\u7c7b\u578b[%1$s]\u503c\u660e\u7ec6\u5931\u8d25\uff0c%2$s", (Object)this.getId(), (Object)callResult.getErrorInfo()));
        }
        this.imConfigValueHelperMap.clear();
        this.imConfigValueHelperList.clear();
        for (IMConfigValue imConfigValue : IMConfigValues) {
            IMConfigValueHelper iIMConfigValueHelper = new IMConfigValueHelper();
            iIMConfigValueHelper.Init(this.getDAGlobalHelper(), this, imConfigValue);
            if (this.imConfigValueHelperMap.containsKey(iIMConfigValueHelper.getName())) {
                int nOldIimex = this.imConfigValueHelperList.indexOf(this.imConfigValueHelperMap.get(iIMConfigValueHelper.getName()));
                if (nOldIimex == -1) {
                    this.imConfigValueHelperList.add(iIMConfigValueHelper);
                } else {
                    this.imConfigValueHelperList.remove(nOldIimex);
                    this.imConfigValueHelperList.add(nOldIimex, iIMConfigValueHelper);
                }
                this.imConfigValueHelperMap.put(iIMConfigValueHelper.getName(), iIMConfigValueHelper);
                continue;
            }
            this.imConfigValueHelperMap.put(iIMConfigValueHelper.getName(), iIMConfigValueHelper);
            this.imConfigValueHelperList.add(iIMConfigValueHelper);
        }
    }

    @Override
    public IIMConfigValueHelper FindDefaultIMConfigValue() throws Exception {
        return this.FindIMConfigValue("DEFAULT");
    }

    @Override
    public IIMConfigValueHelper FindIMConfigValue(String strIMConfigValueName) throws Exception {
        this.PrepareIMConfigValue();
        IIMConfigValueHelper iIMConfigValueHelper = this.imConfigValueHelperMap.get(strIMConfigValueName.toUpperCase());
        if (iIMConfigValueHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u914d\u7f6e\u503c[%1$s]", (Object)strIMConfigValueName));
        }
        return iIMConfigValueHelper;
    }

    @Override
    public Iterator<IIMConfigValueHelper> getIMConfigValues() throws Exception {
        this.PrepareIMConfigValue();
        return this.imConfigValueHelperList.iterator();
    }
}

