/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDConfigValueHelper;
import SA.SRFDA.ND.Ctrl.NDBaseObject;
import SA.SRFDA.ND.Ctrl.NDConfigValueHelper;
import SA.SRFDA.ND.Data.NDConfigType;
import SA.SRFDA.ND.Data.NDConfigValue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class NDConfigTypeHelper
extends NDBaseObject
implements INDConfigTypeHelper {
    private NDConfigType ndConfigType = null;
    private HashMap<String, INDConfigValueHelper> ndConfigValueHelperMap = new HashMap();
    private ArrayList<INDConfigValueHelper> ndConfigValueHelperList = new ArrayList();
    private Boolean bPrepareNDConfigValue = false;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, NDConfigType ndConfigType) throws Exception {
        this.ndConfigType = ndConfigType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.ndConfigType.getNDCONFIGTYPEID());
        this.setName(this.ndConfigType.getNDCONFIGTYPENAME());
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
    }

    protected synchronized void PrepareNDConfigValue() throws Exception {
        if (this.bPrepareNDConfigValue.booleanValue()) {
            return;
        }
        this.OnPrepareNDConfigValue();
        this.bPrepareNDConfigValue = true;
    }

    protected synchronized void OnPrepareNDConfigValue() throws Exception {
        Vector<NDConfigValue> NDConfigValues = new Vector<NDConfigValue>();
        CallResult callResult = this.getNDModelHelper().GetNDConfigValues(this.getId(), NDConfigValues);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7f51\u76d8\u914d\u7f6e\u7c7b\u578b[%1$s]\u503c\u660e\u7ec6\u5931\u8d25\uff0c%2$s", (Object)this.getId(), (Object)callResult.getErrorInfo()));
        }
        this.ndConfigValueHelperMap.clear();
        this.ndConfigValueHelperList.clear();
        for (NDConfigValue ndConfigValue : NDConfigValues) {
            NDConfigValueHelper iNDConfigValueHelper = new NDConfigValueHelper();
            iNDConfigValueHelper.Init(this.getDAGlobalHelper(), this, ndConfigValue);
            if (this.ndConfigValueHelperMap.containsKey(iNDConfigValueHelper.getName())) {
                int nOldIndex = this.ndConfigValueHelperList.indexOf(this.ndConfigValueHelperMap.get(iNDConfigValueHelper.getName()));
                if (nOldIndex == -1) {
                    this.ndConfigValueHelperList.add(iNDConfigValueHelper);
                } else {
                    this.ndConfigValueHelperList.remove(nOldIndex);
                    this.ndConfigValueHelperList.add(nOldIndex, iNDConfigValueHelper);
                }
                this.ndConfigValueHelperMap.put(iNDConfigValueHelper.getName(), iNDConfigValueHelper);
                continue;
            }
            this.ndConfigValueHelperMap.put(iNDConfigValueHelper.getName(), iNDConfigValueHelper);
            this.ndConfigValueHelperList.add(iNDConfigValueHelper);
        }
    }

    @Override
    public INDConfigValueHelper FindDefaultNDConfigValue() throws Exception {
        return this.FindNDConfigValue("DEFAULT");
    }

    @Override
    public INDConfigValueHelper FindNDConfigValue(String strNDConfigValueName) throws Exception {
        this.PrepareNDConfigValue();
        INDConfigValueHelper iNDConfigValueHelper = this.ndConfigValueHelperMap.get(strNDConfigValueName.toUpperCase());
        if (iNDConfigValueHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u914d\u7f6e\u503c[%1$s]", (Object)strNDConfigValueName));
        }
        return iNDConfigValueHelper;
    }

    @Override
    public Iterator<INDConfigValueHelper> getNDConfigValues() throws Exception {
        this.PrepareNDConfigValue();
        return this.ndConfigValueHelperList.iterator();
    }

    @Override
    public String FindNDConfigValue(String strNDConfigValueName, String strDefault) throws Exception {
        this.PrepareNDConfigValue();
        INDConfigValueHelper iNDConfigValueHelper = this.ndConfigValueHelperMap.get(strNDConfigValueName.toUpperCase());
        if (iNDConfigValueHelper == null) {
            return strDefault;
        }
        return iNDConfigValueHelper.getConfigValue();
    }
}

