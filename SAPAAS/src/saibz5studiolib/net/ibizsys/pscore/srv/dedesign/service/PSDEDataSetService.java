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
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.codelist.DEFieldViewColLevelCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoinBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDataSetService
extends PSDEDataSetServiceBase
implements IPSModelService<PSDEDataSet> {
    private static final Log log = LogFactory.getLog(PSDEDataSetService.class);
    public static final String RESERVERTAG_DEFAULT = "R1";
    public static final String RESERVERTAG_VIEW = "R2";
    public static final String RESERVERTAG_VIEW2 = "R3";
    public static final String RESERVERTAG_VIEW3 = "R4";
    public static final String RESERVERTAG_VIEW4 = "R5";
    public static final String RESERVERTAG_INDEXTYPE = "R6";
    public static final String RESERVERTAG_FORMTYPE = "R7";
    private static HashMap<String, String> viewReserverMap = new HashMap();

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            String string3;
            Object object;
            Object object2;
            Object object3;
            Serializable serializable;
            Object object4;
            Object object5;
            Serializable serializable2;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
            boolean bl2 = this.isEnableNoViewMode((IEntity)pSDataEntity);
            if (DataObject.getBoolValue((Integer)pSDataEntity.getNoViewMode(), (boolean)bl2)) {
                serializable2 = new HashMap();
                int n = DataObject.getIntegerValue((Object)pSDataEntity.getViewLevel(), (Integer)DEFieldViewColLevelCodeListModel.DEFAULT);
                object5 = (DEFieldViewColLevelCodeListModel)CodeListGlobal.getCodeList(DEFieldViewColLevelCodeListModel.class);
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL3) {
                    ((HashMap)serializable2).put("View4", DEFieldViewColLevelCodeListModel.LEVEL3);
                }
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL2) {
                    ((HashMap)serializable2).put("View3", DEFieldViewColLevelCodeListModel.LEVEL2);
                }
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL1) {
                    ((HashMap)serializable2).put("View2", DEFieldViewColLevelCodeListModel.LEVEL1);
                }
                if (n >= DEFieldViewColLevelCodeListModel.DEFAULT) {
                    ((HashMap)serializable2).put("View", DEFieldViewColLevelCodeListModel.DEFAULT);
                }
                object4 = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                for (Object object6 : ((HashMap)serializable2).keySet()) {
                    EntityBase entityBase;
                    serializable = (Integer)((HashMap)serializable2).get(object6);
                    object3 = object5.getCodeListText(Integer.toString((Integer)serializable), true);
                    object2 = new PSDEDataQuery();
                    object = null;
                    object = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)viewReserverMap.get(((String)object6).toUpperCase())) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)((String)object6).toUpperCase());
                    boolean bl3 = false;
                    ((PSDEDataQueryBase)object2).setPSDEDataQueryId((String)object);
                    if (((PSCoreSysServiceBase)object4).checkKey(object2) == 0) {
                        entityBase = new PSDEDataQuery();
                        entityBase.setPSDEId(pSDataEntity.getPSDataEntityId());
                        entityBase.setViewColLevel((Integer)serializable);
                        if (!object4.selectOne((IEntity)entityBase, true)) {
                            entityBase.reset();
                            entityBase.setPSDEId(pSDataEntity.getPSDataEntityId());
                            entityBase.setCodeName((String)object6);
                            if (!object4.selectOne((IEntity)entityBase, true)) {
                                bl3 = true;
                            }
                        }
                    }
                    if (!bl3) continue;
                    ((PSDEDataQueryBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataQueryBase)object2).setPSDEName(pSDataEntity.getPSDataEntityName());
                    ((PSDEDataQueryBase)object2).setPSDEDataQueryName(((String)object6).toUpperCase());
                    ((PSDEDataQueryBase)object2).setLogicName((String)object3);
                    ((PSDEDataQueryBase)object2).setCodeName((String)object6);
                    ((PSDEDataQueryBase)object2).setCustomMode(0);
                    ((PSDEDataQueryBase)object2).setDefaultMode(0);
                    ((PSDEDataQueryBase)object2).setViewColLevel((Integer)serializable);
                    ((PSCoreSysServiceBaseBase)((Object)object4)).create(object2);
                    entityBase = new PSDEDQJoin();
                    entityBase.setPSDEDQId(((PSDEDataQueryBase)object2).getPSDEDataQueryId());
                    entityBase.setPSDEDQName(((PSDEDataQueryBase)object2).getPSDEDataQueryName());
                    entityBase.setJoinPSDEId(((PSDEDataQueryBase)object2).getPSDEId());
                    entityBase.setJoinPSDEName(((PSDEDataQueryBase)object2).getPSDEName());
                    entityBase.setMainFlag(1);
                    entityBase.setPSDEJoinTypeId("MAIN");
                    entityBase.setPSDEDQJoinName(((PSDEDataQueryBase)object2).getPSDEName());
                    PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                    pSDEDQJoinService.create(entityBase);
                }
            }
            bl2 = false;
            serializable2 = new PSDEDataSet();
            String string4 = null;
            string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT) : pSDataEntity.getPSDataEntityId();
            ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
            if (this.checkKey(serializable2) == 0) {
                object5 = new PSDEDataSet();
                ((PSDEDataSetBase)object5).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEDataSetBase)object5).setDefaultMode(1);
                if (!this.selectOne((IEntity)object5, true)) {
                    object5.reset();
                    ((PSDEDataSetBase)object5).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataSetBase)object5).setCodeName("Default");
                    if (!this.selectOne((IEntity)object5, true)) {
                        bl2 = true;
                    }
                }
            }
            if (bl2) {
                Object object6;
                serializable2.reset();
                ((PSDEDataSetBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEDataSetBase)serializable2).setDefaultMode(1);
                boolean bl4 = true;
                object4 = new SelectCond();
                object4.setFetchFirst(true);
                object4.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                object4.set("DEFAULTMODE", (Object)1);
                ArrayList arrayList = this.select((ISelectCond)object4);
                if (arrayList.size() > 0) {
                    bl4 = false;
                }
                serializable2.reset();
                ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
                ((PSDEDataSetBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEDataSetBase)serializable2).setDefaultMode(bl4 ? 1 : 0);
                ((PSDEDataSetBase)serializable2).setPSDEDataSetName("DEFAULT");
                ((PSDEDataSetBase)serializable2).setCodeName("Default");
                this.create(serializable2);
                object6 = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                serializable = new PSDEDataQuery();
                ((PSDEDataQueryBase)serializable).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEDataQueryBase)serializable).setPSDEName(pSDataEntity.getPSDataEntityName());
                ((PSDEDataQueryBase)serializable).setPSDEDataQueryName("DEFAULT");
                ((PSDEDataQueryBase)serializable).setCodeName("Default");
                ((PSDEDataQueryBase)serializable).setCustomMode(0);
                if (bl) {
                    ((PSDEDataQueryBase)serializable).setPSDEDataQueryId(string4);
                }
                ((PSCoreSysServiceBaseBase)((Object)object6)).create(serializable);
                object3 = new PSDEDQJoin();
                ((PSDEDQJoinBase)object3).setPSDEDQId(((PSDEDataQueryBase)serializable).getPSDEDataQueryId());
                ((PSDEDQJoinBase)object3).setPSDEDQName(((PSDEDataQueryBase)serializable).getPSDEDataQueryName());
                ((PSDEDQJoinBase)object3).setJoinPSDEId(((PSDEDataQueryBase)serializable).getPSDEId());
                ((PSDEDQJoinBase)object3).setJoinPSDEName(((PSDEDataQueryBase)serializable).getPSDEName());
                ((PSDEDQJoinBase)object3).setMainFlag(1);
                ((PSDEDQJoinBase)object3).setPSDEJoinTypeId("MAIN");
                ((PSDEDQJoinBase)object3).setPSDEDQJoinName(((PSDEDataQueryBase)serializable).getPSDEName());
                object2 = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                ((PSCoreSysServiceBaseBase)((Object)object2)).create(object3);
                object = new PSDEDSDQ();
                ((PSDEDSDQBase)object).setPSDEDataSetId(((PSDEDataSetBase)serializable2).getPSDEDataSetId());
                ((PSDEDSDQBase)object).setPSDEDQId(((PSDEDataQueryBase)serializable).getPSDEDataQueryId());
                PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
                pSDEDSDQService.create(object);
            }
            if (!StringHelper.isNullOrEmpty((String)(string3 = pSDataEntity.getIndexDEType()))) {
                serializable2 = new PSDEDataSet();
                string4 = null;
                string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_INDEXTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)string3);
                ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
                boolean bl5 = false;
                if (this.checkKey(serializable2) == 0) {
                    object4 = new PSDEDataSet();
                    ((PSDEDataSetBase)object4).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataSetBase)object4).setPredefineType("INDEXDE");
                    if (!this.selectOne((IEntity)object4, true)) {
                        bl5 = true;
                    }
                }
                if (bl5) {
                    serializable2.reset();
                    ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
                    ((PSDEDataSetBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataSetBase)serializable2).setDefaultMode(0);
                    ((PSDEDataSetBase)serializable2).setPredefineType("INDEXDE");
                    ((PSDEDataSetBase)serializable2).setPSDEDataSetName("IndexDER");
                    ((PSDEDataSetBase)serializable2).setCodeName("IndexDER");
                    this.create(serializable2);
                }
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                serializable2 = new PSDEDataSet();
                string4 = null;
                string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_FORMTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
                ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
                boolean bl6 = false;
                if (this.checkKey(serializable2) == 0) {
                    object4 = new PSDEDataSet();
                    ((PSDEDataSetBase)object4).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataSetBase)object4).setPredefineType("MULTIFORM");
                    if (!this.selectOne((IEntity)object4, true)) {
                        bl6 = true;
                    }
                }
                if (bl6) {
                    serializable2.reset();
                    ((PSDEDataSetBase)serializable2).setPSDEDataSetId(string4);
                    ((PSDEDataSetBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEDataSetBase)serializable2).setDefaultMode(0);
                    ((PSDEDataSetBase)serializable2).setPredefineType("MULTIFORM");
                    ((PSDEDataSetBase)serializable2).setPSDEDataSetName("FormType");
                    ((PSDEDataSetBase)serializable2).setCodeName("FormType");
                    this.create(serializable2);
                }
            }
        }
    }

    protected void onAfterUpdateTempMajor(PSDEDataSet pSDEDataSet) throws Exception {
        PSDEDataQuery pSDEDataQuery = null;
        ArrayList<PSDEDSDQ> arrayList = pSDEDataSet.getPSDEDSDQs();
        for (PSDEDSDQ pSDEDSDQ : arrayList) {
            if (pSDEDataQuery == null) {
                pSDEDataQuery = pSDEDSDQ.getPSDEDQ();
                continue;
            }
            if (DataTypeHelper.compare((int)9, (Object)pSDEDataQuery.getViewColLevel(), (Object)pSDEDSDQ.getPSDEDQ().getViewColLevel()) == 0L) continue;
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u67e5\u8be2[%1$s]\u4e0e[%2$s]\u89c6\u56fe\u7ea7\u522b\u4e0d\u4e00\u81f4", (Object)pSDEDataQuery.getLogicName(), (Object)pSDEDSDQ.getPSDEDQ().getLogicName()));
        }
        super.onAfterUpdateTempMajor((IEntity)pSDEDataSet);
    }

    static {
        viewReserverMap.put("VIEW", RESERVERTAG_VIEW);
        viewReserverMap.put("VIEW2", RESERVERTAG_VIEW2);
        viewReserverMap.put("VIEW3", RESERVERTAG_VIEW3);
        viewReserverMap.put("VIEW4", RESERVERTAG_VIEW4);
    }
}

