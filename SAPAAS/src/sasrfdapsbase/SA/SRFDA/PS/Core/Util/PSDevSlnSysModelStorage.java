/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Util.IPSDevSlnSysModelStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysModelStorage
implements IPSDevSlnSysModelStorage {
    private static final Log log = LogFactory.getLog(PSDevSlnSysModelStorage.class);
    private PSDevSlnSys psDevSlnSys = null;
    private Map<String, List<Object>> modelListMap = new HashMap<String, List<Object>>();
    private Map<String, Map<String, Object>> modelMapMap = new HashMap<String, Map<String, Object>>();
    private long nLastActiveTime = 0L;
    private IPSSystem iPSSystem = null;
    private List<ModelLog> modelLogList = new ArrayList<ModelLog>();
    private static int MAXMODELLOGSIZE = 51;

    public PSDevSlnSysModelStorage(PSDevSlnSys psDevSlnSys) throws Exception {
        this.psDevSlnSys = psDevSlnSys;
        this.prepare();
    }

    protected SessionFactory getSessionFactory() throws Exception {
        return PSSysModelInstGlobal.getSessionFactory((String)this.psDevSlnSys.getPSSysModelInstId(), (boolean)true);
    }

    @Override
    public PSDevSlnSys getPSDevSlnSys() {
        return this.psDevSlnSys;
    }

    public String getPSSystemId() {
        return this.getPSDevSlnSys().getPSSystemId();
    }

    protected void prepare() throws Exception {
        this.getSessionFactory();
        this.activePSSysModelInst();
        this.onPrepareModels();
    }

    protected void activePSSysModelInst() throws Exception {
        if (this.nLastActiveTime == 0L || System.currentTimeMillis() - this.nLastActiveTime >= 10000L) {
            PSSysModelInstGlobal.active((String)this.getPSDevSlnSys().getPSSysModelInstId());
            this.nLastActiveTime = System.currentTimeMillis();
        }
    }

    protected void onPrepareModels() throws Exception {
        ArrayList<String> modelList = new ArrayList<String>();
        this.prepareModelList(modelList);
        for (String strModel : modelList) {
            List list;
            if (this.modelListMap.containsKey(strModel) || (list = this.prepareModel(strModel)) == null) continue;
            this.modelListMap.put(strModel, list);
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)strModel);
            HashMap map = new HashMap();
            this.modelMapMap.put(strModel, map);
            for (Object item : list) {
                String[] tags = this.getModelTags(iDataEntityModel, (IEntity)item);
                if (tags == null) continue;
                String[] stringArray = tags;
                int n = tags.length;
                int n2 = 0;
                while (n2 < n) {
                    String strTag = stringArray[n2];
                    map.put(strTag, item);
                    ++n2;
                }
            }
        }
    }

    protected String[] getModelTags(IDataEntityModel iDataEntityModel, IEntity iEntity) throws Exception {
        String strKey = DataObject.getStringValue((IDataObject)iEntity, (String)iDataEntityModel.getKeyDEField().getName(), null);
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            return null;
        }
        if ("PSDER".equals(iDataEntityModel.getName())) {
            PSDER psDER = (PSDER)iEntity;
            String strTag2 = String.format("%1$s|%2$s|%3$s|%4$s", psDER.getDERType(), psDER.getMajorPSDEId(), psDER.getMinorPSDEId(), psDER.getPSDERName());
            return new String[]{strKey, strTag2};
        }
        return new String[]{strKey};
    }

    protected void prepareModelList(List<String> modelList) {
        modelList.add("PSSYSREF");
        modelList.add("PSSYSMODELGROUP");
        modelList.add("PSMODULE");
        modelList.add("PSDATAENTITY");
        modelList.add("PSDEFIELD");
        modelList.add("PSDER");
        modelList.add("PSDERDEFMAP");
        modelList.add("PSDEDATASET");
        modelList.add("PSCODELIST");
        modelList.add("PSCODEITEM");
    }

    protected List prepareModel(String strModelName) throws Exception {
        this.activePSSysModelInst();
        IService iService = DEModelGlobal.getDEModel((String)strModelName).getService(this.getSessionFactory());
        return iService.select((ISelectCond)new SelectCond());
    }

    @Override
    public <T> List<T> select(String strModelName, ISelectCond iSelectCond, Class<T> cls) throws Exception {
        this.activePSSysModelInst();
        List<Object> list = this.modelListMap.get(strModelName);
        if (list == null || iSelectCond == null) {
            return list;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        iSelectCond.fillMap(map);
        if (map.size() == 0) {
            map = null;
        }
        ArrayList<Object> result = new ArrayList<Object>();
        for (Object objItem : list) {
            Object t;
            if (map != null && !this.test((IEntity)(t = objItem), map)) continue;
            result.add(objItem);
        }
        return result;
    }

    protected boolean test(IEntity iEntity, Map<String, Object> map) throws Exception {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object dstValue = entry.getValue();
            Object srcValue = iEntity.get(entry.getKey());
            if (DataTypeHelper.compare((int)DataTypeHelper.getObjectDataType((Object)dstValue), (Object)srcValue, (Object)dstValue) == 0L) continue;
            return false;
        }
        return true;
    }

    @Override
    public <T> T selectOne(String strModelName, ISelectCond iSelectCond, Class<T> cls) throws Exception {
        List<T> list = this.select(strModelName, iSelectCond, cls);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public <T> T getByCodeName(String strModelName, ISelectCond iSelectCond, String strCodeName, Class<T> cls) throws Exception {
        List<T> list = this.select(strModelName, iSelectCond, cls);
        if (list == null) {
            return null;
        }
        for (T objItem : list) {
            Object objCodeName = ((IEntity)objItem).get("codename");
            if (StringHelper.isNullOrEmpty((Object)objCodeName) || !strCodeName.equalsIgnoreCase((String)objCodeName)) continue;
            return objItem;
        }
        return null;
    }

    @Override
    public <T> T getByName(String strModelName, ISelectCond iSelectCond, String strName, Class<T> cls) throws Exception {
        List<T> list = this.select(strModelName, iSelectCond, cls);
        if (list == null) {
            return null;
        }
        for (T objItem : list) {
            Object objName = ((IEntity)objItem).get(String.valueOf(strModelName.toLowerCase()) + "name");
            if (StringHelper.isNullOrEmpty((Object)objName) || !strName.equalsIgnoreCase((String)objName)) continue;
            return objItem;
        }
        return null;
    }

    @Override
    public <T> T getByTag(String strModelName, String strTag, Class<T> cls) throws Exception {
        Object objItem;
        Map<String, Object> map = this.modelMapMap.get(strModelName);
        if (map != null && (objItem = map.get(strTag)) != null) {
            return (T)objItem;
        }
        return null;
    }

    @Override
    public void create(String strModelName, IEntity iEntity) throws Exception {
        boolean bHasPSSystemId;
        this.activePSSysModelInst();
        IService iService = DEModelGlobal.getDEModel((String)strModelName).getService(this.getSessionFactory());
        boolean bl = bHasPSSystemId = iService.getDEModel().getDEField("PSSYSTEMID", true) != null;
        if (bHasPSSystemId) {
            iEntity.set("pssystemid", (Object)this.getPSSystemId());
        }
        iService.create(iEntity, false);
        this.addModelLog(iService, iEntity, true);
        SessionFactoryManager.releaseRef((boolean)true);
        SessionFactoryManager.addRef();
    }

    @Override
    public void update(String strModelName, IEntity iEntity) throws Exception {
        boolean bHasPSSystemId;
        this.activePSSysModelInst();
        IService iService = DEModelGlobal.getDEModel((String)strModelName).getService(this.getSessionFactory());
        boolean bl = bHasPSSystemId = iService.getDEModel().getDEField("PSSYSTEMID", true) != null;
        if (bHasPSSystemId) {
            iEntity.set("pssystemid", (Object)this.getPSSystemId());
        }
        iService.update(iEntity, false);
        this.addModelLog(iService, iEntity, false);
        SessionFactoryManager.releaseRef((boolean)true);
        SessionFactoryManager.addRef();
    }

    @Override
    public void create(String strModelName, List<IEntity> list) throws Exception {
        this.activePSSysModelInst();
        IService iService = DEModelGlobal.getDEModel((String)strModelName).getService(this.getSessionFactory());
        boolean bHasPSSystemId = iService.getDEModel().getDEField("PSSYSTEMID", true) != null;
        for (IEntity iEntity : list) {
            if (bHasPSSystemId) {
                iEntity.set("pssystemid", (Object)this.getPSSystemId());
            }
            iService.create(iEntity, false);
            this.addModelLog(iService, iEntity, true);
        }
        SessionFactoryManager.releaseRef((boolean)true);
        SessionFactoryManager.addRef();
    }

    @Override
    public void update(String strModelName, List<IEntity> list) throws Exception {
        this.activePSSysModelInst();
        IService iService = DEModelGlobal.getDEModel((String)strModelName).getService(this.getSessionFactory());
        boolean bHasPSSystemId = iService.getDEModel().getDEField("PSSYSTEMID", true) != null;
        for (IEntity iEntity : list) {
            if (bHasPSSystemId) {
                iEntity.set("pssystemid", (Object)this.getPSSystemId());
            }
            iService.update(iEntity, false);
            this.addModelLog(iService, iEntity, false);
        }
        SessionFactoryManager.releaseRef((boolean)true);
        SessionFactoryManager.addRef();
    }

    protected void addModelLog(IService iService, IEntity iEntity, boolean bCreate) {
        try {
            if (this.modelLogList.size() >= MAXMODELLOGSIZE) {
                return;
            }
            ModelLog modelLog = new ModelLog();
            modelLog.name = iService.getDEModel().getName();
            modelLog.logicName = iService.getDEModel().getLogicName();
            modelLog.dataInfo = iService.getDataSummary(iEntity);
            modelLog.create = bCreate;
            this.modelLogList.add(modelLog);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public IPSSystem getPSSystem() throws Exception {
        if (this.iPSSystem == null) {
            IPSDevSlnSys iPSDevSlnSys = PSObjectFactory.getPSModelStorage().getPSDevSlnSys(this.getPSDevSlnSys().getPSDevSlnSysId());
            IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
                iPSSystem = iPSDevSlnSys.reloadPSSystem(IPSSystem.LOADLEVEL_CODE);
            }
            this.iPSSystem = iPSSystem;
        }
        return this.iPSSystem;
    }

    @Override
    public String getLogInfo() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.modelLogList.size()) {
            if (i != 0) {
                sb.append("\r\n");
            }
            if (i == MAXMODELLOGSIZE - 1) {
                sb.append("......");
                break;
            }
            ModelLog modelLog = this.modelLogList.get(i);
            sb.append(String.format("[%1$s][%2$s][%3$s]%4$s", modelLog.create ? "\u65b0\u5efa" : "\u66f4\u65b0", modelLog.name, modelLog.logicName, modelLog.dataInfo));
            ++i;
        }
        return sb.toString();
    }

    private class ModelLog {
        public String name = null;
        public String logicName = null;
        public String dataInfo = null;
        public boolean create = true;

        private ModelLog() {
        }
    }
}

