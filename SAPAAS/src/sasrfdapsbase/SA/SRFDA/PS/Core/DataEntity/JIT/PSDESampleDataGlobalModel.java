/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.JIT;

import SA.SRFDA.PS.Core.DataEntity.JIT.IPSDESampleData;
import SA.SRFDA.PS.Core.DataEntity.JIT.PSDESampleDataImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDESampleData;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Random;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDESampleDataGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDESampleData, IPSDESampleData> {
    private static final Log log = LogFactory.getLog(PSDESampleDataGlobalModel.class);
    private static Random random = new Random();

    @Override
    protected PSDESampleData GetObject(String strPSDESampleDataId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDESampleDataId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDESampleData OnCreateModelHelper(PSDESampleData vt) throws Exception {
        PSDESampleDataImpl iPSDESampleData = new PSDESampleDataImpl();
        iPSDESampleData.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDESampleData;
    }

    @Override
    protected Boolean TestObjectRenew(PSDESampleData obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSDESampleData> getAllModels() throws Exception {
        Vector<PSDESampleData> psDESampleDataList = new Vector<PSDESampleData>();
        CallResult callResult = this.iPSModelHelper.getPSDESampleDatas(this.getPSDataEntity().getId(), psDESampleDataList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDESampleData> psDESampleDataList2 = new Vector<PSDESampleData>();
        for (PSDESampleData psDESampleData : psDESampleDataList) {
            psDESampleDataList2.add(psDESampleData);
        }
        for (PSDESampleData psDESampleData : psDESampleDataList) {
            int nRandomCount = psDESampleData.getRANDOMECNT();
            if (nRandomCount >= 5) {
                nRandomCount = 5;
            }
            int i = 0;
            while (i < nRandomCount) {
                PSDESampleData psDESampleDataClone = new PSDESampleData();
                psDESampleData.CopyTo(psDESampleDataClone, false);
                psDESampleDataClone.setPSDESAMPLEDATAID(StringHelper.Format((String)"%1$s__%2$s", (Object)psDESampleData.getPSDESAMPLEDATAID(), (Object)i));
                psDESampleDataClone.setPSDESAMPLEDATANAME(StringHelper.Format((String)"%1$s(%2$s)", (Object)psDESampleData.getPSDESAMPLEDATANAME(), (Object)(i + 1)));
                if (!StringHelper.IsNullOrEmpty((String)psDESampleData.getCODENAME())) {
                    psDESampleDataClone.setCODENAME(StringHelper.Format((String)"%1$s__%2$s", (Object)psDESampleData.getCODENAME(), (Object)(i + 1)));
                }
                psDESampleDataList2.add(psDESampleDataClone);
                ++i;
            }
        }
        return psDESampleDataList2;
    }

    @Override
    protected IPSDESampleData registerModel(PSDESampleData vt) throws Exception {
        IPSDESampleData iPSUniState = (IPSDESampleData)this.InternalGetModelHelper(vt.getPSDESAMPLEDATAID());
        if (iPSUniState != null) {
            return iPSUniState;
        }
        this.setModel(vt.getPSDESAMPLEDATAID(), vt, null);
        IPSDESampleData iPSDESampleData = (IPSDESampleData)this.FindModelHelper(vt.getPSDESAMPLEDATAID());
        return iPSDESampleData;
    }

    @Override
    protected String getObjectId(PSDESampleData vt) {
        return vt.getPSDESAMPLEDATAID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDESampleData vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    public IPSDESampleData getRandomPSDESampleData() throws Exception {
        int nCount = this.getAllModelHelperCount();
        if (nCount == 0) {
            return null;
        }
        return (IPSDESampleData)this.getAllModelHelper(random.nextInt(1000000) % nCount);
    }
}

