/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFType;
import net.ibizsys.pscore.srv.config.entity.PSMIDetail;
import net.ibizsys.pscore.srv.config.entity.PSModelInitStruct;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.config.service.PSDEFTypeService;
import net.ibizsys.pscore.srv.config.service.PSMIDetailService;
import net.ibizsys.pscore.srv.config.service.PSModelInitService;
import net.ibizsys.pscore.srv.config.service.PSVTCtrlService;
import net.ibizsys.pscore.srv.config.service.PSVTRVService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDEInitCfgService;
import org.hibernate.SessionFactory;

public class PSModelGlobal {
    private static HashMap<String, PSModelInitStruct> psModelInitStructMap = null;
    private static Object psModelInitStructMapLock = new Object();
    private static HashMap<String, PSViewTypeStruct> psViewTypeStructMap = null;
    private static Object psViewTypeStructMapLock = new Object();
    private static HashMap<String, PSDEFType> psDEFTypeMap = null;
    private static Object psDEFTypeMapLock = new Object();
    public static final String PSDCMODELTEMPL_UPPER_UNDERSCORE = "UPPER_UNDERSCORE";

    public static ArrayList<PSSystemDBCfg> getPSSystemDBCfgs(String string, SessionFactory sessionFactory) throws Exception {
        ActionSession actionSession = ActionSessionManager.getCurrentSession((boolean)false);
        String string2 = StringHelper.format((String)"PSSystemDBCfgs_%1$s_%2$s", (Object)string, (Object)sessionFactory);
        Object object = null;
        if (actionSession != null) {
            object = actionSession.getActionParam(string2);
        }
        if (object == null) {
            PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)sessionFactory);
            PSSystem pSSystem = new PSSystem();
            pSSystem.setPSSystemId(string);
            ArrayList<PSSystemDBCfg> arrayList = pSSystemDBCfgService.selectByPSSystem(pSSystem);
            if (actionSession != null) {
                actionSession.setActionParam(string2, arrayList);
            }
            return arrayList;
        }
        if (object != DataObject.EMPTY) {
            return (ArrayList)object;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PSModelInitStruct getPSModelInit(String string) throws Exception {
        Object object = psModelInitStructMapLock;
        synchronized (object) {
            if (psModelInitStructMap == null) {
                PSModelInitStruct pSModelInitStruct;
                HashMap<String, PSModelInitStruct> hashMap = new HashMap<String, PSModelInitStruct>();
                PSModelInitService pSModelInitService = (PSModelInitService)ServiceGlobal.getService(PSModelInitService.class);
                PSMIDetailService pSMIDetailService = (PSMIDetailService)ServiceGlobal.getService(PSMIDetailService.class);
                ArrayList arrayList = pSModelInitService.select((ISelectCond)new SelectCond());
                SelectCond selectCond = new SelectCond();
                selectCond.setOrderInfo("ORDER BY ORDERVALUE");
                ArrayList arrayList2 = pSMIDetailService.select((ISelectCond)selectCond);
                for (EntityBase entityBase : arrayList) {
                    pSModelInitStruct = new PSModelInitStruct();
                    entityBase.copyTo((IDataObject)pSModelInitStruct, true);
                    hashMap.put(pSModelInitStruct.getPSModelInitName(), pSModelInitStruct);
                }
                for (EntityBase entityBase : arrayList2) {
                    pSModelInitStruct = (PSModelInitStruct)hashMap.get(entityBase.getPSModelInitName());
                    pSModelInitStruct.getPSModelInitDetails().add((PSMIDetail)entityBase);
                }
                psModelInitStructMap = hashMap;
            }
            return psModelInitStructMap.get(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetPSModelInits() {
        Object object = psModelInitStructMapLock;
        synchronized (object) {
            if (psModelInitStructMap != null) {
                psModelInitStructMap.clear();
                psModelInitStructMap = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PSViewTypeStruct getPSViewType(String string) throws Exception {
        Object object = psViewTypeStructMapLock;
        synchronized (object) {
            if (psViewTypeStructMap == null) {
                PSViewTypeStruct pSViewTypeStruct;
                HashMap<String, PSViewTypeStruct> hashMap = new HashMap<String, PSViewTypeStruct>();
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class);
                PSVTCtrlService pSVTCtrlService = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class);
                PSVTRVService pSVTRVService = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class);
                ArrayList arrayList = pSViewTypeService.select((ISelectCond)new SelectCond());
                SelectCond selectCond = new SelectCond();
                ArrayList arrayList2 = pSVTCtrlService.select((ISelectCond)selectCond);
                ArrayList arrayList3 = pSVTRVService.select((ISelectCond)selectCond);
                for (EntityBase entityBase : arrayList) {
                    pSViewTypeStruct = new PSViewTypeStruct();
                    entityBase.copyTo((IDataObject)pSViewTypeStruct, true);
                    hashMap.put(pSViewTypeStruct.getPSViewTypeId(), pSViewTypeStruct);
                }
                for (EntityBase entityBase : arrayList2) {
                    pSViewTypeStruct = (PSViewTypeStruct)hashMap.get(entityBase.getPSViewTypeId());
                    pSViewTypeStruct.getPSVTCtrls().add((PSVTCtrl)entityBase);
                }
                for (EntityBase entityBase : arrayList3) {
                    pSViewTypeStruct = (PSViewTypeStruct)hashMap.get(entityBase.getPSViewTypeId());
                    pSViewTypeStruct.getPSVTRVs().add((PSVTRV)entityBase);
                }
                psViewTypeStructMap = hashMap;
            }
            return psViewTypeStructMap.get(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetPSViewTypes() {
        Object object = psViewTypeStructMapLock;
        synchronized (object) {
            if (psViewTypeStructMap != null) {
                psViewTypeStructMap.clear();
                psViewTypeStructMap = null;
            }
        }
    }

    public static PSDCModelTempl getPSDCModelTempl(String string) throws Exception {
        String string2;
        PSDCModelTempl pSDCModelTempl = null;
        ActionSession actionSession = ActionSessionManager.getCurrentSession((boolean)true);
        Object object = actionSession.getActionParam(string2 = StringHelper.format((String)"PSDCModelTempl_%1$s", (Object)string));
        if (object == null) {
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(string);
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            pSDevSlnSysService.get((IEntity)pSDevSlnSys);
            if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDCModelTemplId()) && !PSDCMODELTEMPL_UPPER_UNDERSCORE.equalsIgnoreCase(pSDevSlnSys.getPSDCModelTemplId())) {
                pSDCModelTempl = pSDevSlnSys.getPSDCModelTempl();
            }
            if (pSDCModelTempl == null) {
                actionSession.setActionParam(string2, DataObject.EMPTY);
            } else {
                actionSession.setActionParam(string2, pSDCModelTempl);
            }
            return pSDCModelTempl;
        }
        if (object != DataObject.EMPTY) {
            return (PSDCModelTempl)object;
        }
        return null;
    }

    public static PSDEInitCfg getPSDEInitCfg(String string, SessionFactory sessionFactory) throws Exception {
        ActionSession actionSession = ActionSessionManager.getCurrentSession((boolean)false);
        String string2 = StringHelper.format((String)"PSDEInitCfg_%1$s_%2$s", (Object)string, (Object)sessionFactory);
        Object object = null;
        if (actionSession != null) {
            object = actionSession.getActionParam(string2);
        }
        if (object == null) {
            PSDEInitCfgService pSDEInitCfgService = (PSDEInitCfgService)ServiceGlobal.getService(PSDEInitCfgService.class, (SessionFactory)sessionFactory);
            PSDEInitCfg pSDEInitCfg = new PSDEInitCfg();
            pSDEInitCfg.setPSDEInitCfgId(string);
            if (!pSDEInitCfgService.get((IEntity)pSDEInitCfg, true)) {
                if (actionSession != null) {
                    actionSession.setActionParam(string2, DataObject.EMPTY);
                }
                return null;
            }
            if (actionSession != null) {
                actionSession.setActionParam(string2, (Object)pSDEInitCfg);
            }
            return pSDEInitCfg;
        }
        if (object != DataObject.EMPTY) {
            return (PSDEInitCfg)object;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PSDEFType getPSDEFType(PSDEField pSDEField, Map<String, PSDEFType> map) throws Exception {
        Object object;
        Object object2;
        Object object3;
        Object object4 = psDEFTypeMapLock;
        synchronized (object4) {
            if (psDEFTypeMap == null) {
                object3 = new HashMap();
                PSDEFTypeService pSDEFTypeService = (PSDEFTypeService)ServiceGlobal.getService(PSDEFTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                object2 = pSDEFTypeService.select((ISelectCond)new SelectCond());
                object = ((ArrayList)object2).iterator();
                while (object.hasNext()) {
                    PSDEFType pSDEFType = (PSDEFType)object.next();
                    String string = pSDEFType.getFields();
                    if (!StringHelper.isNullOrEmpty((String)string)) {
                        String[] stringArray;
                        string = string.toUpperCase();
                        string = string.replace(',', ';');
                        for (String string2 : stringArray = string.split("[;]")) {
                            ((HashMap)object3).put(string2.trim(), pSDEFType);
                        }
                    }
                    ((HashMap)object3).put(pSDEFType.getPSDEFTypeId(), pSDEFType);
                }
                psDEFTypeMap = object3;
            }
        }
        object4 = pSDEField.getPSDataTypeId();
        object3 = PSModelGlobal.toDEFTypeString(pSDEField.getDEFType());
        boolean bl = true;
        if (StringHelper.compare((String)object4, (String)"PICKUP", (boolean)true) == 0 || StringHelper.compare((String)object4, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)object4, (String)"PICKUPTEXT", (boolean)true) == 0) {
            bl = false;
        }
        if (bl && (pSDEField.getDEFType() == 2 || pSDEField.getDEFType() == 3)) {
            bl = false;
        }
        object2 = StringHelper.format((String)"[*:%1$s]", (Object)pSDEField.getPSDEFieldName()).toUpperCase();
        object = null;
        if (bl) {
            if (map != null && (object = map.get(object2)) != null) {
                return object;
            }
            object = psDEFTypeMap.get(object2);
            if (object != null) {
                return object;
            }
        }
        object2 = StringHelper.format((String)"%1$s:%2$s", (Object)object3, (Object)object4).toUpperCase();
        if (map != null && (object = map.get(object2)) != null) {
            return object;
        }
        object = psDEFTypeMap.get(object2);
        if (object != null) {
            return object;
        }
        object2 = StringHelper.format((String)"%1$s:*", (Object)object3).toUpperCase();
        if (map != null && (object = map.get(object2)) != null) {
            return object;
        }
        object = psDEFTypeMap.get(object2);
        if (object != null) {
            return object;
        }
        object2 = StringHelper.format((String)"*:%1$s", (Object)object4).toUpperCase();
        if (map != null && (object = map.get(object2)) != null) {
            return object;
        }
        object = psDEFTypeMap.get(object2);
        if (object != null) {
            return object;
        }
        object2 = StringHelper.format((String)"*");
        if (map != null && (object = map.get(object2)) != null) {
            return object;
        }
        object = psDEFTypeMap.get(object2);
        if (object != null) {
            return object;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetPSDEFTypes() {
        Object object = psDEFTypeMapLock;
        synchronized (object) {
            if (psDEFTypeMap != null) {
                psDEFTypeMap.clear();
                psDEFTypeMap = null;
            }
        }
    }

    public static String toDEFTypeString(int n) {
        switch (n) {
            case 1: {
                return "PHISICAL";
            }
            case 2: {
                return "FORMULA";
            }
            case 3: {
                return "LINK";
            }
        }
        return "";
    }
}

