/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.ER.IPSSysERMap
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysERMapCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysERMap iPSSysERMap = null;
    private int nTableIndex = 0;
    private int nColumnIndex = 0;
    private int nWordIndex = 0;
    private int nLinkIndex = 0;
    private HashMap<String, Integer> psDEIndexMap = new HashMap();
    private HashMap<String, Integer> psDEFIndexMap = new HashMap();
    private HashMap<String, Integer> psDEFWordIndexMap = new HashMap();
    private HashMap<String, Integer> psDERIndexMap = new HashMap();

    protected void onGenerateCode() throws Exception {
        Iterator psSysERMaps = this.iPSSystem.getAllPSSysERMaps();
        while (psSysERMaps.hasNext()) {
            IPSSysERMap iPSSysERMap;
            this.iPSSysERMap = iPSSysERMap = (IPSSysERMap)psSysERMaps.next();
            if (iPSSysERMap.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSSysERMap.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            this.onGenerateCode(iPSSysERMap);
        }
    }

    protected void onGenerateCode(IPSSysERMap iPSSysERMap) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(this.iPSSysERMap, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysERMap = null;
        this.nTableIndex = 0;
        this.nColumnIndex = 0;
        this.nWordIndex = 0;
        this.nLinkIndex = 0;
        this.psDEIndexMap.clear();
        this.psDEFIndexMap.clear();
        this.psDEFWordIndexMap.clear();
        this.psDERIndexMap.clear();
        super.onClose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getTableIndex(IPSDataEntity iPSDataEntity) {
        HashMap<String, Integer> hashMap = this.psDEIndexMap;
        synchronized (hashMap) {
            Integer nValue = this.psDEIndexMap.get(iPSDataEntity.getId());
            if (nValue != null) {
                return nValue;
            }
            nValue = this.nTableIndex;
            ++this.nTableIndex;
            this.psDEIndexMap.put(iPSDataEntity.getId(), nValue);
            return nValue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getColumnIndex(IPSDEField iPSDEField) {
        HashMap<String, Integer> hashMap = this.psDEFIndexMap;
        synchronized (hashMap) {
            Integer nValue = this.psDEFIndexMap.get(iPSDEField.getId());
            if (nValue != null) {
                return nValue;
            }
            nValue = this.nColumnIndex;
            ++this.nColumnIndex;
            this.psDEFIndexMap.put(iPSDEField.getId(), nValue);
            return nValue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getWordIndex(IPSDEField iPSDEField) {
        HashMap<String, Integer> hashMap = this.psDEFWordIndexMap;
        synchronized (hashMap) {
            Integer nValue = this.psDEFWordIndexMap.get(iPSDEField.getId());
            if (nValue != null) {
                return nValue;
            }
            nValue = this.nWordIndex;
            ++this.nWordIndex;
            this.psDEFWordIndexMap.put(iPSDEField.getId(), nValue);
            return nValue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLinkIndex(IPSDERBase iPSDERBase) {
        HashMap<String, Integer> hashMap = this.psDERIndexMap;
        synchronized (hashMap) {
            Integer nValue = this.psDERIndexMap.get(iPSDERBase.getId());
            if (nValue != null) {
                return nValue;
            }
            nValue = this.nLinkIndex;
            ++this.nLinkIndex;
            this.psDERIndexMap.put(iPSDERBase.getId(), nValue);
            return nValue;
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}

