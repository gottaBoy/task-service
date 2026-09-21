/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDMItem;
import SA.SRFDA.PS.Core.Database.PSSysDMItemImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDMItemGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDMItem, IPSSysDMItem> {
    private static final Log log = LogFactory.getLog(PSSysDMItemGlobalModel.class);
    private HashMap<String, ArrayList<IPSSysDMItem>> psSysDMItemListMap = new HashMap();
    private HashMap<String, IPSSysDMItem> lastCheckPSSysDMItemMap = new HashMap();

    @Override
    protected PSSysDMItem GetObject(String strPSSysDMItemId) {
        return null;
    }

    @Override
    protected IPSSysDMItem OnCreateModelHelper(PSSysDMItem vt) throws Exception {
        PSSysDMItemImpl iPSSysDMItem = new PSSysDMItemImpl();
        iPSSysDMItem.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDMItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDMItem obj) {
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
    protected IPSSysDMItem registerModel(PSSysDMItem vt) throws Exception {
        IPSSysDMItem lastPSSysDMItem;
        IPSSysDMItem iPSSysDMItem = (IPSSysDMItem)this.InternalGetModelHelper(vt.getPSSYSDMITEMID());
        if (iPSSysDMItem != null) {
            return iPSSysDMItem;
        }
        this.setModel(vt.getPSSYSDMITEMID(), vt, null);
        iPSSysDMItem = (IPSSysDMItem)this.FindModelHelper(vt.getPSSYSDMITEMID());
        String strDBType = iPSSysDMItem.getDBType().toUpperCase();
        ArrayList<IPSSysDMItem> psSysDMItemList = this.psSysDMItemListMap.get(strDBType);
        if (psSysDMItemList == null) {
            psSysDMItemList = new ArrayList();
            this.psSysDMItemListMap.put(strDBType, psSysDMItemList);
        }
        psSysDMItemList.add(iPSSysDMItem);
        if (!(StringHelper.Compare((String)iPSSysDMItem.getDBObjType(), (String)"COLUMN", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)iPSSysDMItem.getTestSql()) || (lastPSSysDMItem = this.lastCheckPSSysDMItemMap.get(strDBType)) != null && lastPSSysDMItem.getCreateTime() >= iPSSysDMItem.getCreateTime())) {
            this.lastCheckPSSysDMItemMap.put(strDBType, iPSSysDMItem);
        }
        return iPSSysDMItem;
    }

    @Override
    protected Vector<PSSysDMItem> getAllModels() throws Exception {
        Vector<PSSysDMItem> list = new Vector<PSSysDMItem>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDMItems(this.getPSSystem().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6570\u636e\u7ed3\u6784\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDMItem vt) {
        return vt.getPSSYSDMITEMID();
    }

    @Override
    public void ResetAll() {
        this.lastCheckPSSysDMItemMap.clear();
        this.psSysDMItemListMap.clear();
        super.ResetAll();
    }

    public Iterator<IPSSysDMItem> getPSSysDMItemList(String strDBType) {
        this.preloadModels();
        strDBType = strDBType.toUpperCase();
        ArrayList<IPSSysDMItem> psSysDMItemList = this.psSysDMItemListMap.get(strDBType);
        if (psSysDMItemList == null || psSysDMItemList.size() == 0) {
            return null;
        }
        return psSysDMItemList.iterator();
    }

    public IPSSysDMItem getLastTestPSSysDMItem(String strDBType) {
        this.preloadModels();
        strDBType = strDBType.toUpperCase();
        return this.lastCheckPSSysDMItemMap.get(strDBType);
    }
}

