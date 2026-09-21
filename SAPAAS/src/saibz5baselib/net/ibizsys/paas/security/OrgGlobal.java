/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import java.util.HashMap;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.service.OrgSectorService;
import net.ibizsys.psrt.srv.common.service.OrgService;

public class OrgGlobal {
    private static HashMap<String, Org> orgMap = new HashMap();
    private static HashMap<String, OrgSector> orgSectorMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Org getOrg(String strOrgId) throws Exception {
        Org org = null;
        HashMap<String, Org> hashMap = orgMap;
        synchronized (hashMap) {
            org = orgMap.get(strOrgId);
        }
        if (org != null) {
            return org;
        }
        org = new Org();
        org.setOrgId(strOrgId);
        OrgService orgService = (OrgService)ServiceGlobal.getService(OrgService.class);
        orgService.get(org);
        HashMap<String, Org> hashMap2 = orgMap;
        synchronized (hashMap2) {
            orgMap.put(strOrgId, org);
        }
        return org;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetOrg(String strOrgId) throws Exception {
        HashMap<String, Org> hashMap = orgMap;
        synchronized (hashMap) {
            orgMap.remove(strOrgId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Org reloadOrg(String strOrgId) throws Exception {
        Org org = null;
        org = new Org();
        org.setOrgId(strOrgId);
        OrgService orgService = (OrgService)ServiceGlobal.getService(OrgService.class);
        orgService.get(org);
        HashMap<String, Org> hashMap = orgMap;
        synchronized (hashMap) {
            orgMap.put(strOrgId, org);
        }
        return org;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static OrgSector getOrgSector(String strOrgSectorId) throws Exception {
        OrgSector orgSector = null;
        HashMap<String, OrgSector> hashMap = orgSectorMap;
        synchronized (hashMap) {
            orgSector = orgSectorMap.get(strOrgSectorId);
        }
        if (orgSector != null) {
            return orgSector;
        }
        orgSector = new OrgSector();
        orgSector.setOrgSectorId(strOrgSectorId);
        OrgSectorService orgSectorService = (OrgSectorService)ServiceGlobal.getService(OrgSectorService.class);
        orgSectorService.get(orgSector);
        HashMap<String, OrgSector> hashMap2 = orgSectorMap;
        synchronized (hashMap2) {
            orgSectorMap.put(strOrgSectorId, orgSector);
        }
        return orgSector;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetOrgSector(String strOrgSectorId) throws Exception {
        HashMap<String, OrgSector> hashMap = orgSectorMap;
        synchronized (hashMap) {
            orgSectorMap.remove(strOrgSectorId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static OrgSector reloadOrgSector(String strOrgSectorId) throws Exception {
        OrgSector orgSector = null;
        orgSector = new OrgSector();
        orgSector.setOrgSectorId(strOrgSectorId);
        OrgSectorService orgSectorService = (OrgSectorService)ServiceGlobal.getService(OrgSectorService.class);
        orgSectorService.get(orgSector);
        HashMap<String, OrgSector> hashMap = orgSectorMap;
        synchronized (hashMap) {
            orgSectorMap.put(strOrgSectorId, orgSector);
        }
        return orgSector;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void reset() {
        HashMap<String, EntityBase> hashMap = orgMap;
        synchronized (hashMap) {
            orgMap.clear();
        }
        hashMap = orgSectorMap;
        synchronized (hashMap) {
            orgSectorMap.clear();
        }
    }
}

