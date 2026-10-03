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
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            boolean bl = this.isEnableFolderKey(pSDataEntity);
            boolean bl2 = this.isEnableNoViewMode(pSDataEntity);
            if (DataObject.getBoolValue((Integer)pSDataEntity.getNoViewMode(), (boolean)bl2)) {
                HashMap<String, Integer> viewLevels = new HashMap<String, Integer>();
                int n = DataObject.getIntegerValue((Object)pSDataEntity.getViewLevel(), (Integer)DEFieldViewColLevelCodeListModel.DEFAULT);
                DEFieldViewColLevelCodeListModel codeList = (DEFieldViewColLevelCodeListModel)CodeListGlobal.getCodeList(DEFieldViewColLevelCodeListModel.class);
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL3) {
                    viewLevels.put("View4", DEFieldViewColLevelCodeListModel.LEVEL3);
                }
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL2) {
                    viewLevels.put("View3", DEFieldViewColLevelCodeListModel.LEVEL2);
                }
                if (n >= DEFieldViewColLevelCodeListModel.LEVEL1) {
                    viewLevels.put("View2", DEFieldViewColLevelCodeListModel.LEVEL1);
                }
                if (n >= DEFieldViewColLevelCodeListModel.DEFAULT) {
                    viewLevels.put("View", DEFieldViewColLevelCodeListModel.DEFAULT);
                }
                PSDEDataQueryService queryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                for (String view : viewLevels.keySet()) {
                    Integer level = viewLevels.get(view);
                    String logicName = codeList.getCodeListText(Integer.toString(level), true);
                    PSDEDataQuery query = new PSDEDataQuery();
                    String queryId = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)viewReserverMap.get(view.toUpperCase())) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), view.toUpperCase());
                    boolean bl3 = false;
                    query.setPSDEDataQueryId(queryId);
                    if (queryService.checkKey(query) == 0) {
                        PSDEDataQuery existing = new PSDEDataQuery();
                        existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                        existing.setViewColLevel(level);
                        if (!queryService.selectOne(existing, true)) {
                            existing.reset();
                            existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                            existing.setCodeName(view);
                            if (!queryService.selectOne(existing, true)) {
                                bl3 = true;
                            }
                        }
                    }
                    if (!bl3) continue;
                    query.setPSDEId(pSDataEntity.getPSDataEntityId());
                    query.setPSDEName(pSDataEntity.getPSDataEntityName());
                    query.setPSDEDataQueryName(view.toUpperCase());
                    query.setLogicName(logicName);
                    query.setCodeName(view);
                    query.setCustomMode(0);
                    query.setDefaultMode(0);
                    query.setViewColLevel(level);
                    queryService.create(query);
                    PSDEDQJoin join = new PSDEDQJoin();
                    join.setPSDEDQId(query.getPSDEDataQueryId());
                    join.setPSDEDQName(query.getPSDEDataQueryName());
                    join.setJoinPSDEId(query.getPSDEId());
                    join.setJoinPSDEName(query.getPSDEName());
                    join.setMainFlag(1);
                    join.setPSDEJoinTypeId("MAIN");
                    join.setPSDEDQJoinName(query.getPSDEName());
                    PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                    pSDEDQJoinService.create(join);
                }
            }
            bl2 = false;
            PSDEDataSet dataSet = new PSDEDataSet();
            String string4 = null;
            string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT) : pSDataEntity.getPSDataEntityId();
            dataSet.setPSDEDataSetId(string4);
            if (this.checkKey(dataSet) == 0) {
                PSDEDataSet existing = new PSDEDataSet();
                existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                existing.setDefaultMode(1);
                if (!this.selectOne(existing, true)) {
                    existing.reset();
                    existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                    existing.setCodeName("Default");
                    if (!this.selectOne(existing, true)) {
                        bl2 = true;
                    }
                }
            }
            if (bl2) {
                dataSet.reset();
                dataSet.setPSDEId(pSDataEntity.getPSDataEntityId());
                dataSet.setDefaultMode(1);
                boolean bl4 = true;
                SelectCond cond = new SelectCond();
                cond.setFetchFirst(true);
                cond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                cond.set("DEFAULTMODE", (Object)1);
                ArrayList<PSDEDataSet> arrayList = this.select((ISelectCond)cond);
                if (arrayList.size() > 0) {
                    bl4 = false;
                }
                dataSet.reset();
                dataSet.setPSDEDataSetId(string4);
                dataSet.setPSDEId(pSDataEntity.getPSDataEntityId());
                dataSet.setDefaultMode(bl4 ? 1 : 0);
                dataSet.setPSDEDataSetName("DEFAULT");
                dataSet.setCodeName("Default");
                this.create(dataSet);
                PSDEDataQueryService queryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                PSDEDataQuery query = new PSDEDataQuery();
                query.setPSDEId(pSDataEntity.getPSDataEntityId());
                query.setPSDEName(pSDataEntity.getPSDataEntityName());
                query.setPSDEDataQueryName("DEFAULT");
                query.setCodeName("Default");
                query.setCustomMode(0);
                if (bl) {
                    query.setPSDEDataQueryId(string4);
                }
                queryService.create(query);
                PSDEDQJoin join = new PSDEDQJoin();
                join.setPSDEDQId(query.getPSDEDataQueryId());
                join.setPSDEDQName(query.getPSDEDataQueryName());
                join.setJoinPSDEId(query.getPSDEId());
                join.setJoinPSDEName(query.getPSDEName());
                join.setMainFlag(1);
                join.setPSDEJoinTypeId("MAIN");
                join.setPSDEDQJoinName(query.getPSDEName());
                PSDEDQJoinService joinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
                joinService.create(join);
                PSDEDSDQ link = new PSDEDSDQ();
                link.setPSDEDataSetId(dataSet.getPSDEDataSetId());
                link.setPSDEDQId(query.getPSDEDataQueryId());
                PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
                pSDEDSDQService.create(link);
            }
            if (!StringHelper.isNullOrEmpty((String)(string3 = pSDataEntity.getIndexDEType()))) {
                dataSet = new PSDEDataSet();
                string4 = null;
                string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_INDEXTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)string3);
                dataSet.setPSDEDataSetId(string4);
                boolean bl5 = false;
                if (this.checkKey(dataSet) == 0) {
                    PSDEDataSet existing = new PSDEDataSet();
                    existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                    existing.setPredefineType("INDEXDE");
                    if (!this.selectOne(existing, true)) {
                        bl5 = true;
                    }
                }
                if (bl5) {
                    dataSet.reset();
                    dataSet.setPSDEDataSetId(string4);
                    dataSet.setPSDEId(pSDataEntity.getPSDataEntityId());
                    dataSet.setDefaultMode(0);
                    dataSet.setPredefineType("INDEXDE");
                    dataSet.setPSDEDataSetName("IndexDER");
                    dataSet.setCodeName("IndexDER");
                    this.create(dataSet);
                }
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                dataSet = new PSDEDataSet();
                string4 = null;
                string4 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_FORMTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
                dataSet.setPSDEDataSetId(string4);
                boolean bl6 = false;
                if (this.checkKey(dataSet) == 0) {
                    PSDEDataSet existing = new PSDEDataSet();
                    existing.setPSDEId(pSDataEntity.getPSDataEntityId());
                    existing.setPredefineType("MULTIFORM");
                    if (!this.selectOne(existing, true)) {
                        bl6 = true;
                    }
                }
                if (bl6) {
                    dataSet.reset();
                    dataSet.setPSDEDataSetId(string4);
                    dataSet.setPSDEId(pSDataEntity.getPSDataEntityId());
                    dataSet.setDefaultMode(0);
                    dataSet.setPredefineType("MULTIFORM");
                    dataSet.setPSDEDataSetName("FormType");
                    dataSet.setCodeName("FormType");
                    this.create(dataSet);
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
        super.onAfterUpdateTempMajor(pSDEDataSet);
    }

    static {
        viewReserverMap.put("VIEW", RESERVERTAG_VIEW);
        viewReserverMap.put("VIEW2", RESERVERTAG_VIEW2);
        viewReserverMap.put("VIEW3", RESERVERTAG_VIEW3);
        viewReserverMap.put("VIEW4", RESERVERTAG_VIEW4);
    }
}
