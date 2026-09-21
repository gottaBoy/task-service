/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.IPSDevSlnSysModelStorage;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysModelStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public abstract class PSModelSyncHelperBase {
    private SessionFactory sessionFactory = null;
    private PSDevSlnSys psDevSlnSys = null;
    private IPSDevSlnSysModelStorage iPSDevSlnSysModelStorage = null;
    private Map<String, Object> modelMapMap = new HashMap<String, Object>();
    private Map<String, Map<String, Integer>> psModelSyncMap = new HashMap<String, Map<String, Integer>>();

    public PSModelSyncHelperBase(PSDevSlnSys psDevSlnSys, SessionFactory sessionFactory) {
        this.psDevSlnSys = psDevSlnSys;
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() throws Exception {
        if (this.sessionFactory == null) {
            this.sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.psDevSlnSys.getPSSysModelInstId(), (boolean)true);
        }
        return this.sessionFactory;
    }

    public PSDevSlnSys getPSDevSlnSys() {
        return this.psDevSlnSys;
    }

    public String getPSSystemId() {
        return this.getPSDevSlnSys().getPSSystemId();
    }

    protected IPSDevSlnSysModelStorage getPSDevSlnSysModelStorage() throws Exception {
        return this.getPSDevSlnSysModelStorage(false);
    }

    protected IPSDevSlnSysModelStorage getPSDevSlnSysModelStorage(boolean bReload) throws Exception {
        if (this.iPSDevSlnSysModelStorage != null && !bReload) {
            return this.iPSDevSlnSysModelStorage;
        }
        this.iPSDevSlnSysModelStorage = this.getPSDevSlnSysModelStorage(this.getPSDevSlnSys(), false);
        return this.iPSDevSlnSysModelStorage;
    }

    public String sync(PSDevSlnSysRef psDevSlnSysRef, PSDevSlnSys refPSDevSlnSys) throws Exception {
        IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage = this.getPSDevSlnSysModelStorage(refPSDevSlnSys, true);
        try {
            ImportSessionManager.openSession();
            String string = this.onSync(psDevSlnSysRef, refPSDevSlnSysModelStorage);
            return string;
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            ImportSessionManager.closeSession();
        }
    }

    protected String onSync(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        return null;
    }

    protected IPSDevSlnSysModelStorage getPSDevSlnSysModelStorage(PSDevSlnSys psDevSlnSys, boolean bRef) throws Exception {
        return new PSDevSlnSysModelStorage(psDevSlnSys);
    }

    protected <T> T getDstPSModel(String strModelType, String strId, Class<T> cls) {
        if (StringHelper.isNullOrEmpty((String)strId)) {
            return null;
        }
        Object objItem = this.modelMapMap.get(String.format("%1$s|%2$s", strModelType, strId));
        if (objItem == null) {
            return null;
        }
        return (T)objItem;
    }

    protected void mapPSModel(String strModelType, String strId, Object obj) {
        this.modelMapMap.put(String.format("%1$s|%2$s", strModelType, strId), obj);
    }

    protected String syncPSDataEntites(PSModule srcPSModule, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSModule dstPSModule = this.getDstPSModel("PSMODULE", srcPSModule.getPSModuleId(), PSModule.class);
        SelectCond srcSelectCond = new SelectCond();
        srcSelectCond.set("psmoduleid", (Object)srcPSModule.getPSModuleId());
        List<PSDataEntity> srcPSDataEntityList = refPSDevSlnSysModelStorage.select("PSDATAENTITY", (ISelectCond)srcSelectCond, PSDataEntity.class);
        if (srcPSDataEntityList != null) {
            for (PSDataEntity srcPSDataEntity : srcPSDataEntityList) {
                SelectCond selectCond = new SelectCond();
                selectCond.set("psmoduleid", (Object)dstPSModule.getPSModuleId());
                PSDataEntity dstPSDataEntity = this.getPSDevSlnSysModelStorage().getByCodeName("PSDATAENTITY", (ISelectCond)selectCond, srcPSDataEntity.getCodeName(), PSDataEntity.class);
                if (dstPSDataEntity == null) {
                    dstPSDataEntity = new PSDataEntity();
                    dstPSDataEntity.setPSDataEntityName(srcPSDataEntity.getPSDataEntityName());
                    dstPSDataEntity.setCodeName(srcPSDataEntity.getCodeName());
                    dstPSDataEntity.setLogicName(srcPSDataEntity.getLogicName());
                    dstPSDataEntity.setDEType(srcPSDataEntity.getDEType());
                    dstPSDataEntity.setPSModuleId(dstPSModule.getPSModuleId());
                    dstPSDataEntity.setPSSysModelGroupId(dstPSModule.getPSSysModelGroupId());
                    dstPSDataEntity.setTableName(srcPSDataEntity.getTableName());
                    if (!StringHelper.isNullOrEmpty((String)srcPSDataEntity.getTableName())) {
                        dstPSDataEntity.setExistingModel(Integer.valueOf(1));
                    }
                    dstPSDataEntity.setNoViewMode(Integer.valueOf(1));
                    dstPSDataEntity.setVirtualFlag(srcPSDataEntity.getVirtualFlag());
                    dstPSDataEntity.setIndexDEType(srcPSDataEntity.getIndexDEType());
                    dstPSDataEntity.setStorageMode(DEStorageTypeCodeListModel.NONE);
                    this.getPSDevSlnSysModelStorage().create("PSDATAENTITY", (IEntity)dstPSDataEntity);
                }
                this.mapPSModel("PSDATAENTITY", srcPSDataEntity.getPSDataEntityId(), dstPSDataEntity);
            }
        }
        return null;
    }

    protected String syncPSDERs(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSDER> srcPSDERList = refPSDevSlnSysModelStorage.select("PSDER", null, PSDER.class);
        for (PSDER srcPSDER : srcPSDERList) {
            PSDataEntity dstMinorPSDataEntity;
            PSDataEntity dstMajorPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDER.getMajorPSDEId(), PSDataEntity.class);
            if (dstMajorPSDataEntity == null || (dstMinorPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDER.getMinorPSDEId(), PSDataEntity.class)) == null) continue;
            SelectCond selectCond = new SelectCond();
            selectCond.set("DERTYPE", (Object)srcPSDER.getDERType());
            selectCond.set("MAJORPSDEID", (Object)dstMajorPSDataEntity.getPSDataEntityId());
            selectCond.set("MINORPSDEID", (Object)dstMinorPSDataEntity.getPSDataEntityId());
            selectCond.set("PSDERNAME", (Object)srcPSDER.getPSDERName());
            PSDER dstPSDER = this.getPSDevSlnSysModelStorage().selectOne("PSDER", (ISelectCond)selectCond, PSDER.class);
            if (dstPSDER == null) {
                dstPSDER = new PSDER();
                dstPSDER.setLogicName(srcPSDER.getLogicName());
                dstPSDER.setPSDERName(srcPSDER.getPSDERName());
                dstPSDER.setCodeName(srcPSDER.getCodeName());
                dstPSDER.setDERType(srcPSDER.getDERType());
                dstPSDER.setMinorCodeName(srcPSDER.getMinorCodeName());
                dstPSDER.setMajorPSDEId(dstMajorPSDataEntity.getPSDataEntityId());
                dstPSDER.setMajorPSDEName(dstMajorPSDataEntity.getPSDataEntityName());
                dstPSDER.setMinorPSDEId(dstMinorPSDataEntity.getPSDataEntityId());
                dstPSDER.setMinorPSDEName(dstMinorPSDataEntity.getPSDataEntityName());
                dstPSDER.setOrderValue(srcPSDER.getOrderValue());
                dstPSDER.setExportScope(srcPSDER.getExportScope());
                dstPSDER.setExportScope2(srcPSDER.getExportScope2());
                dstPSDER.setDERSubType(srcPSDER.getDERSubType());
                dstPSDER.setDERFieldName(srcPSDER.getDERFieldName());
                dstPSDER.setDERFieldLName(srcPSDER.getDERFieldLName());
                dstPSDER.setMasterRS(srcPSDER.getMasterRS());
                dstPSDER.setIndexValue(srcPSDER.getIndexValue());
                dstPSDER.setInheritMode(srcPSDER.getInheritMode());
                dstPSDER.setIgnoreDEFields(srcPSDER.getIgnoreDEFields());
                dstPSDER.setRemoveActionType(srcPSDER.getRemoveActionType());
                dstPSDER.setRemoveOrder(srcPSDER.getRemoveOrder());
                this.getPSDevSlnSysModelStorage().create("PSDER", (IEntity)dstPSDER);
            }
            this.mapPSModel("PSDER", srcPSDER.getPSDERId(), dstPSDER);
        }
        return null;
    }

    protected String syncPSCodeItems(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSCodeItem> srcPSCodeItemList = refPSDevSlnSysModelStorage.select("PSCODEITEM", null, PSCodeItem.class);
        if (srcPSCodeItemList != null) {
            for (PSCodeItem srcPSCodeItem : srcPSCodeItemList) {
                PSCodeList dstPSCodeList = this.getDstPSModel("PSCODELIST", srcPSCodeItem.getPSCodeListId(), PSCodeList.class);
                if (dstPSCodeList == null) continue;
                SelectCond selectCond = new SelectCond();
                selectCond.set("pscodelistid", (Object)dstPSCodeList.getPSCodeListId());
                selectCond.set("codeitemvalue", (Object)srcPSCodeItem.getCodeItemValue());
                PSCodeItem dstPSCodeItem = this.getPSDevSlnSysModelStorage().selectOne("PSCODEITEM", (ISelectCond)selectCond, PSCodeItem.class);
                if (dstPSCodeItem == null) {
                    dstPSCodeItem = new PSCodeItem();
                    dstPSCodeItem.setPSCodeItemName(srcPSCodeItem.getPSCodeItemName());
                    dstPSCodeItem.setCodeName(srcPSCodeItem.getCodeName());
                    dstPSCodeItem.setPSCodeListId(dstPSCodeList.getPSCodeListId());
                    dstPSCodeItem.setCodeItemValue(srcPSCodeItem.getCodeItemValue());
                    dstPSCodeItem.setOrderValue(srcPSCodeItem.getOrderValue());
                    dstPSCodeItem.setValidFlag(srcPSCodeItem.getValidFlag());
                    dstPSCodeItem.setDefaultFlag(srcPSCodeItem.getDefaultFlag());
                    dstPSCodeItem.setDisableSelect(srcPSCodeItem.getDisableSelect());
                    dstPSCodeItem.setUserData(srcPSCodeItem.getUserData());
                    dstPSCodeItem.setUserData2(srcPSCodeItem.getUserData2());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSCODEITEM", (IEntity)dstPSCodeItem);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u4ee3\u7801\u8868[%1$s][%2$s]\u9879[%3$s][%4$s]\u53d1\u751f\u5f02\u5e38\uff0c%5$s", dstPSCodeList.getPSCodeListName(), dstPSCodeList.getCodeName(), srcPSCodeItem.getPSCodeItemName(), srcPSCodeItem.getCodeItemValue(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSCODEITEM", srcPSCodeItem.getPSCodeItemId(), dstPSCodeItem);
            }
        }
        return null;
    }

    protected String syncPSDEFields(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSDEField> srcPSDEFieldList = refPSDevSlnSysModelStorage.select("PSDEFIELD", null, PSDEField.class);
        if (srcPSDEFieldList != null) {
            this.syncPSDEFields(srcPSDEFieldList, psDevSlnSysRef, refPSDevSlnSysModelStorage);
        }
        return null;
    }

    protected String syncPSDEFields(Collection<PSDEField> srcPSDEFieldList, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        PSDEField dstPSDEField;
        SelectCond selectCond;
        PSCodeList dstPSCodeList;
        ArrayList<Object> derPSDEFieldList = new ArrayList<Object>();
        for (PSDEField srcPSDEField : srcPSDEFieldList) {
            PSDataEntity dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEField.getPSDEId(), PSDataEntity.class);
            if (dstPSDataEntity == null) continue;
            PSDER dstPSDER = null;
            if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getPSDERId())) {
                dstPSDER = this.getDstPSModel("PSDER", srcPSDEField.getPSDERId(), PSDER.class);
                if (dstPSDER == null) continue;
                if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getDERPSDEFId())) {
                    derPSDEFieldList.add(srcPSDEField);
                    continue;
                }
            }
            PSDER dstO2MPSDER = null;
            if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getO2MPSDERId()) && (dstO2MPSDER = this.getDstPSModel("PSDER", srcPSDEField.getO2MPSDERId(), PSDER.class)) == null) continue;
            PSDER dstO2OPSDER = null;
            if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getO2OPSDERId()) && (dstO2OPSDER = this.getDstPSModel("PSDER", srcPSDEField.getO2OPSDERId(), PSDER.class)) == null) continue;
            dstPSCodeList = null;
            if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getPSCodeListId()) && (dstPSCodeList = this.getDstPSModel("PSCODELIST", srcPSDEField.getPSCodeListId(), PSCodeList.class)) == null) continue;
            selectCond = new SelectCond();
            selectCond.set("PSDEFIELDNAME", (Object)srcPSDEField.getPSDEFieldName());
            selectCond.set("PSDEID", (Object)dstPSDataEntity.getPSDataEntityId());
            dstPSDEField = this.getPSDevSlnSysModelStorage().selectOne("PSDEFIELD", (ISelectCond)selectCond, PSDEField.class);
            if (dstPSDEField == null) {
                dstPSDEField = new PSDEField();
                dstPSDEField.setLogicName(srcPSDEField.getLogicName());
                dstPSDEField.setPSDEFieldName(srcPSDEField.getPSDEFieldName());
                dstPSDEField.setCodeName(srcPSDEField.getCodeName());
                dstPSDEField.setDEFType(srcPSDEField.getDEFType());
                dstPSDEField.setAllowEmpty(srcPSDEField.getAllowEmpty());
                dstPSDEField.setPSDataTypeId(srcPSDEField.getPSDataTypeId());
                dstPSDEField.setPSDataTypeName(srcPSDEField.getPSDataTypeName());
                dstPSDEField.setLength(srcPSDEField.getLength());
                dstPSDEField.setPrecision2(srcPSDEField.getPrecision2());
                dstPSDEField.setPreDefineType(srcPSDEField.getPreDefineType());
                dstPSDEField.setPSDEId(dstPSDataEntity.getPSDataEntityId());
                dstPSDEField.setPSDEName(dstPSDataEntity.getPSDataEntityName());
                dstPSDEField.setOrderValue(srcPSDEField.getOrderValue());
                dstPSDEField.setExportScope(srcPSDEField.getExportScope());
                dstPSDEField.setPKey(srcPSDEField.getPKey());
                dstPSDEField.setMajorField(srcPSDEField.getMajorField());
                dstPSDEField.setFormulaFormat(srcPSDEField.getFormulaFormat());
                dstPSDEField.setFormulaFields(srcPSDEField.getFormulaFields());
                dstPSDEField.setDefaultValueType(srcPSDEField.getDefaultValueType());
                dstPSDEField.setDefaultValue(srcPSDEField.getDefaultValue());
                dstPSDEField.setIndexType(srcPSDEField.getIndexType());
                dstPSDEField.setMultiFormField(srcPSDEField.getMultiFormField());
                if (dstPSCodeList != null) {
                    dstPSDEField.setPSCodeListId(dstPSCodeList.getPSCodeListId());
                    dstPSDEField.setPSCodeListName(dstPSCodeList.getPSCodeListName());
                }
                if (dstO2MPSDER != null) {
                    dstPSDEField.setO2MPSDERId(dstO2MPSDER.getPSDERId());
                    dstPSDEField.setO2MPSDERName(dstO2MPSDER.getPSDERName());
                }
                if (dstO2OPSDER != null) {
                    dstPSDEField.setO2OPSDERId(dstO2OPSDER.getPSDERId());
                    dstPSDEField.setO2OPSDERName(dstO2OPSDER.getPSDERName());
                }
                try {
                    this.getPSDevSlnSysModelStorage().create("PSDEFIELD", (IEntity)dstPSDEField);
                }
                catch (Exception ex) {
                    throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSDEField.getPSDEName(), srcPSDEField.getPSDEFieldName(), ex.getMessage()), ex);
                }
            }
            this.mapPSModel("PSDEFIELD", srcPSDEField.getPSDEFieldId(), dstPSDEField);
        }
        ArrayList<PSDEField> derPSDEFieldList2 = new ArrayList<PSDEField>();
        while (true) {
            int nLastSize = derPSDEFieldList.size();
            while (derPSDEFieldList.size() > 0) {
                PSDEField srcPSDEField = (PSDEField)derPSDEFieldList.remove(0);
                PSDEField dstDERPSDEField = this.getDstPSModel("PSDEFIELD", srcPSDEField.getDERPSDEFId(), PSDEField.class);
                if (dstDERPSDEField != null) {
                    PSDataEntity dstPSDataEntity = this.getDstPSModel("PSDATAENTITY", srcPSDEField.getPSDEId(), PSDataEntity.class);
                    PSDER dstPSDER = this.getDstPSModel("PSDER", srcPSDEField.getPSDERId(), PSDER.class);
                    dstPSCodeList = null;
                    if (!StringHelper.isNullOrEmpty((String)srcPSDEField.getPSCodeListId()) && (dstPSCodeList = this.getDstPSModel("PSCODELIST", srcPSDEField.getPSCodeListId(), PSCodeList.class)) == null) continue;
                    selectCond = new SelectCond();
                    selectCond.set("PSDEFIELDNAME", (Object)srcPSDEField.getPSDEFieldName());
                    selectCond.set("PSDEID", (Object)dstPSDataEntity.getPSDataEntityId());
                    dstPSDEField = this.getPSDevSlnSysModelStorage().selectOne("PSDEFIELD", (ISelectCond)selectCond, PSDEField.class);
                    if (dstPSDEField == null) {
                        dstPSDEField = new PSDEField();
                        dstPSDEField.setLogicName(srcPSDEField.getLogicName());
                        dstPSDEField.setPSDEFieldName(srcPSDEField.getPSDEFieldName());
                        dstPSDEField.setCodeName(srcPSDEField.getCodeName());
                        dstPSDEField.setDEFType(srcPSDEField.getDEFType());
                        dstPSDEField.setAllowEmpty(srcPSDEField.getAllowEmpty());
                        dstPSDEField.setPSDataTypeId(srcPSDEField.getPSDataTypeId());
                        dstPSDEField.setPSDataTypeName(srcPSDEField.getPSDataTypeName());
                        dstPSDEField.setLength(srcPSDEField.getLength());
                        dstPSDEField.setPrecision2(srcPSDEField.getPrecision2());
                        dstPSDEField.setPreDefineType(srcPSDEField.getPreDefineType());
                        dstPSDEField.setPSDEId(dstPSDataEntity.getPSDataEntityId());
                        dstPSDEField.setPSDEName(dstPSDataEntity.getPSDataEntityName());
                        dstPSDEField.setOrderValue(srcPSDEField.getOrderValue());
                        dstPSDEField.setExportScope(srcPSDEField.getExportScope());
                        dstPSDEField.setPKey(srcPSDEField.getPKey());
                        dstPSDEField.setMajorField(srcPSDEField.getMajorField());
                        dstPSDEField.setFormulaFormat(srcPSDEField.getFormulaFormat());
                        dstPSDEField.setFormulaFields(srcPSDEField.getFormulaFields());
                        dstPSDEField.setDefaultValueType(srcPSDEField.getDefaultValueType());
                        dstPSDEField.setDefaultValue(srcPSDEField.getDefaultValue());
                        dstPSDEField.setIndexType(srcPSDEField.getIndexType());
                        dstPSDEField.setMultiFormField(srcPSDEField.getMultiFormField());
                        if (dstPSCodeList != null) {
                            dstPSDEField.setPSCodeListId(dstPSCodeList.getPSCodeListId());
                            dstPSDEField.setPSCodeListName(dstPSCodeList.getPSCodeListName());
                        }
                        if (dstDERPSDEField != null) {
                            dstPSDEField.setDERPSDEFId(dstDERPSDEField.getPSDEFieldId());
                            dstPSDEField.setDERPSDEFName(dstDERPSDEField.getPSDEFieldName());
                        }
                        if (dstPSDER != null) {
                            dstPSDEField.setPSDERId(dstPSDER.getPSDERId());
                            dstPSDEField.setPSDERName(dstPSDER.getPSDERName());
                        }
                        try {
                            this.getPSDevSlnSysModelStorage().create("PSDEFIELD", (IEntity)dstPSDEField);
                        }
                        catch (Exception ex) {
                            throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSDEField.getPSDEName(), srcPSDEField.getPSDEFieldName(), ex.getMessage()), ex);
                        }
                    }
                    this.mapPSModel("PSDEFIELD", srcPSDEField.getPSDEFieldId(), dstPSDEField);
                    continue;
                }
                derPSDEFieldList2.add(srcPSDEField);
            }
            if (derPSDEFieldList2.size() == 0 || nLastSize == derPSDEFieldList2.size()) break;
            derPSDEFieldList.addAll(derPSDEFieldList2);
            derPSDEFieldList2.clear();
        }
        return null;
    }

    protected String syncPSDERDEFMaps(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSDERDEFMap> srcPSDERDEFMapList = refPSDevSlnSysModelStorage.select("PSDERDEFMAP", null, PSDERDEFMap.class);
        if (srcPSDERDEFMapList != null) {
            for (PSDERDEFMap srcPSDERDEFMap : srcPSDERDEFMapList) {
                PSDERDEFMap dstPSDERDEFMap;
                PSDEField majorDSTPSDEField;
                PSDER dstPSDER = this.getDstPSModel("PSDER", srcPSDERDEFMap.getPSDERId(), PSDER.class);
                if (dstPSDER == null || (majorDSTPSDEField = this.getDstPSModel("PSDEFIELD", srcPSDERDEFMap.getMajorPSDEFId(), PSDEField.class)) == null) continue;
                PSDEField minorDSTPSDEField = null;
                if (!StringHelper.isNullOrEmpty((String)srcPSDERDEFMap.getMinorPSDEFId()) && (minorDSTPSDEField = this.getDstPSModel("PSDEFIELD", srcPSDERDEFMap.getMinorPSDEFId(), PSDEField.class)) == null) continue;
                SelectCond selectCond = new SelectCond();
                selectCond.set("psderid", (Object)dstPSDER.getPSDERId());
                selectCond.set("MAPTYPE", (Object)srcPSDERDEFMap.getMapType());
                if (majorDSTPSDEField != null) {
                    selectCond.set("MAJORPSDEFID", (Object)majorDSTPSDEField.getPSDEFieldId());
                }
                if (minorDSTPSDEField != null) {
                    selectCond.set("MINORPSDEFID", (Object)minorDSTPSDEField.getPSDEFieldId());
                }
                if ((dstPSDERDEFMap = this.getPSDevSlnSysModelStorage().selectOne("PSDERDEFMAP", (ISelectCond)selectCond, PSDERDEFMap.class)) == null) {
                    dstPSDERDEFMap = new PSDERDEFMap();
                    dstPSDERDEFMap.setPSDERDEFMapName(srcPSDERDEFMap.getPSDERDEFMapName());
                    dstPSDERDEFMap.setCodeName(srcPSDERDEFMap.getCodeName());
                    dstPSDERDEFMap.setPSDERId(dstPSDER.getPSDERId());
                    dstPSDERDEFMap.setPSDERName(dstPSDER.getPSDERName());
                    dstPSDERDEFMap.setMajorPSDEFId(majorDSTPSDEField.getPSDEFieldId());
                    dstPSDERDEFMap.setMajorPSDEFName(majorDSTPSDEField.getPSDEFieldName());
                    if (minorDSTPSDEField != null) {
                        dstPSDERDEFMap.setMinorPSDEFId(minorDSTPSDEField.getPSDEFieldId());
                        dstPSDERDEFMap.setMinorPSDEFName(minorDSTPSDEField.getPSDEFieldName());
                    }
                    dstPSDERDEFMap.setMapType(srcPSDERDEFMap.getMapType());
                    dstPSDERDEFMap.setFormulaFormat(srcPSDERDEFMap.getFormulaFormat());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSDERDEFMAP", (IEntity)dstPSDERDEFMap);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u5b9e\u4f53\u5173\u7cfb[%1$s]\u5c5e\u6027\u6620\u5c04[%2$s][%3$s]\u53d1\u751f\u5f02\u5e38\uff0c%4$s", dstPSDER.getPSDERName(), srcPSDERDEFMap.getPSDERDEFMapName(), srcPSDERDEFMap.getMapType(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSDERDEFMAP", srcPSDERDEFMap.getPSDERDEFMapId(), dstPSDERDEFMap);
            }
        }
        return null;
    }

    protected String syncPSCodeLists(PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        List<PSCodeList> srcPSCodeListList = refPSDevSlnSysModelStorage.select("PSCODELIST", null, PSCodeList.class);
        if (srcPSCodeListList != null) {
            return this.syncPSCodeLists(srcPSCodeListList, null, psDevSlnSysRef, refPSDevSlnSysModelStorage);
        }
        return null;
    }

    protected String syncPSCodeLists(Collection<PSCodeList> srcPSCodeListList, PSModule defaultPSModule, PSDevSlnSysRef psDevSlnSysRef, IPSDevSlnSysModelStorage refPSDevSlnSysModelStorage) throws Exception {
        if (srcPSCodeListList != null) {
            for (PSCodeList srcPSCodeList : srcPSCodeListList) {
                SelectCond selectCond = new SelectCond();
                PSModule dstPSModule = null;
                if (!StringHelper.isNullOrEmpty((String)srcPSCodeList.getPSModuleId()) && (dstPSModule = this.getDstPSModel("PSMODULE", srcPSCodeList.getPSModuleId(), PSModule.class)) == null) continue;
                if (dstPSModule == null) {
                    dstPSModule = defaultPSModule;
                }
                if (dstPSModule == null) continue;
                selectCond.set("psmoduleid", (Object)dstPSModule.getPSModuleId());
                PSCodeList dstPSCodeList = this.getPSDevSlnSysModelStorage().getByCodeName("PSCODELIST", (ISelectCond)selectCond, srcPSCodeList.getCodeName(), PSCodeList.class);
                if (dstPSCodeList == null) {
                    dstPSCodeList = new PSCodeList();
                    dstPSCodeList.setPSCodeListName(srcPSCodeList.getPSCodeListName());
                    dstPSCodeList.setCodeName(srcPSCodeList.getCodeName());
                    dstPSCodeList.setCodeListSN(srcPSCodeList.getCodeListSN());
                    dstPSCodeList.setCLType(srcPSCodeList.getCLType());
                    dstPSCodeList.setPSModuleId(dstPSModule.getPSModuleId());
                    dstPSCodeList.setPSModuleName(dstPSModule.getPSModuleName());
                    dstPSCodeList.setOrMode(srcPSCodeList.getOrMode());
                    dstPSCodeList.setNumberItem(srcPSCodeList.getNumberItem());
                    try {
                        this.getPSDevSlnSysModelStorage().create("PSCODELIST", (IEntity)dstPSCodeList);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u540c\u6b65\u4ee3\u7801\u8868[%1$s][%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", srcPSCodeList.getPSCodeListName(), srcPSCodeList.getCodeName(), ex.getMessage()), ex);
                    }
                }
                this.mapPSModel("PSCODELIST", srcPSCodeList.getPSCodeListId(), dstPSCodeList);
            }
        }
        return null;
    }

    protected boolean syncPSModel(IEntity srcEntity, IEntity dstEntity, Map<String, Integer> fieldMap) throws Exception {
        boolean bUpdate = false;
        for (Map.Entry<String, Integer> entry : fieldMap.entrySet()) {
            if (DataTypeHelper.compare((int)entry.getValue(), (Object)srcEntity.get(entry.getKey()), (Object)dstEntity.get(entry.getKey())) == 0L) continue;
            dstEntity.set(entry.getKey(), srcEntity.get(entry.getKey()));
            bUpdate = true;
        }
        return bUpdate;
    }
}

