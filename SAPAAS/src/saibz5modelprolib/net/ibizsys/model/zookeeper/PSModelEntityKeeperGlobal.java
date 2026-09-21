/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.zookeeper;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.model.zookeeper.PSEntityKeeperGlobal;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;

public class PSModelEntityKeeperGlobal {
    private static boolean bInitPSDynaInst = false;
    private HashMap<String, PSDynaInst> psDynaInstMap = new HashMap();
    public static final String PSDYNAINST = "PSDYNAINST";
    private String strPSSysModelInstId = null;

    public PSModelEntityKeeperGlobal() {
    }

    public PSModelEntityKeeperGlobal(String strPSSysModelInstId) {
        this.strPSSysModelInstId = strPSSysModelInstId;
    }

    public static void initPSDynaInst() throws Exception {
        if (!bInitPSDynaInst) {
            if (!PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity(PSDYNAINST)) {
                PSEntityKeeperGlobal.getCurrent().registerPSEntity(PSDYNAINST, "USERTAG", new String[]{"PSSVRDOMAINID"}, new String[]{"DYNATAG"}, null);
            }
            bInitPSDynaInst = true;
        }
    }

    public static PSEntityKeeperGlobal getPSEntityKeeperGlobal() throws Exception {
        return PSEntityKeeperGlobal.getCurrent();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst(String strPSDynaInstId) throws Exception {
        PSDynaInst psDynaInst = this.psDynaInstMap.get(strPSDynaInstId);
        if (psDynaInst != null) {
            if (PSModelEntityKeeperGlobal.getPSEntityKeeperGlobal().getPSEntity(PSDYNAINST, (IEntity)psDynaInst, false)) {
                return psDynaInst;
            }
            HashMap<String, PSDynaInst> hashMap = this.psDynaInstMap;
            synchronized (hashMap) {
                this.psDynaInstMap.remove(strPSDynaInstId);
            }
        }
        psDynaInst = new PSDynaInst();
        CallResult callResult = PSModelQueryHelperFactory.getInstance(this.strPSSysModelInstId).getPSDynaInst(strPSDynaInstId, psDynaInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        psDynaInst.set("PSSVRDOMAINID", "DEFAULT");
        if (StringHelper.isNullOrEmpty((String)psDynaInst.getUSERTAG())) {
            psDynaInst.setUSERTAG(strPSDynaInstId);
        }
        if (psDynaInst.getUPDATEDATE() != null) {
            psDynaInst.set("DYNATAG", StringHelper.format((String)"%1$s", (Object)psDynaInst.getUPDATEDATE().getTime()));
        }
        this.updatePSDynaInst(psDynaInst);
        return psDynaInst;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePSDynaInst(PSDynaInst psDynaInst) throws Exception {
        PSModelEntityKeeperGlobal.getPSEntityKeeperGlobal().hasPSEntity(PSDYNAINST, (IEntity)psDynaInst);
        if (StringHelper.isNullOrEmpty((String)psDynaInst.getUSERTAG())) {
            psDynaInst.setUSERTAG(psDynaInst.getPSDYNAINSTID());
        }
        psDynaInst.set("PSSVRDOMAINID", "DEFAULT");
        if (StringHelper.isNullOrEmpty((String)psDynaInst.getParamStringValue("DYNATAG", "")) && psDynaInst.getUPDATEDATE() != null) {
            psDynaInst.set("DYNATAG", StringHelper.format((String)"%1$s", (Object)psDynaInst.getUPDATEDATE().getTime()));
        }
        PSModelEntityKeeperGlobal.getPSEntityKeeperGlobal().updatePSEntity(PSDYNAINST, (IEntity)psDynaInst, true);
        PSDynaInst lastPSDynaInst = this.psDynaInstMap.get(psDynaInst.getPSDYNAINSTID());
        if (lastPSDynaInst != null && lastPSDynaInst != psDynaInst) {
            psDynaInst.copyTo((IDataObject)lastPSDynaInst, false);
        }
        if (lastPSDynaInst == null) {
            HashMap<String, PSDynaInst> hashMap = this.psDynaInstMap;
            synchronized (hashMap) {
                lastPSDynaInst = this.psDynaInstMap.get(psDynaInst.getPSDYNAINSTID());
                if (lastPSDynaInst == null) {
                    this.psDynaInstMap.put(psDynaInst.getPSDYNAINSTID(), psDynaInst);
                }
            }
        }
    }

    public int getPSDynaInstCount() {
        return this.psDynaInstMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillPSDynaInstIdList(ArrayList<String> psDynaInstList) {
        HashMap<String, PSDynaInst> hashMap = this.psDynaInstMap;
        synchronized (hashMap) {
            psDynaInstList.addAll(this.psDynaInstMap.keySet());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPSDynaInst(String strPSDynaInstId) throws Exception {
        PSDynaInst psDynaInst = null;
        HashMap<String, PSDynaInst> hashMap = this.psDynaInstMap;
        synchronized (hashMap) {
            psDynaInst = this.psDynaInstMap.remove(strPSDynaInstId);
        }
        if (psDynaInst == null) {
            psDynaInst = new PSDynaInst();
            CallResult callResult = PSModelQueryHelperFactory.getInstance(this.strPSSysModelInstId).getPSDynaInst(strPSDynaInstId, psDynaInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if (StringHelper.isNullOrEmpty((String)psDynaInst.getUSERTAG())) {
            strPSDynaInstId = psDynaInst.getUSERTAG();
        }
        PSModelEntityKeeperGlobal.getPSEntityKeeperGlobal().removePSEntity(PSDYNAINST, strPSDynaInstId);
    }

    public boolean isPSDynaInstEnabled() throws Exception {
        return PSModelEntityKeeperGlobal.getPSEntityKeeperGlobal().isPSEntityEnabled(PSDYNAINST);
    }

    public static void initAll() throws Exception {
        PSModelEntityKeeperGlobal.initPSDynaInst();
    }
}

