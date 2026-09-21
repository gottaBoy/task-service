/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.IDEACMode
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEFieldModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.ssdyna.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.demodel.DataEntityModelBase;
import net.ibizsys.ssdyna.demodel.DynaCodeListDEDataSetModel;
import net.ibizsys.ssdyna.demodel.DynaDEACModel;
import net.ibizsys.ssdyna.demodel.DynaDEDataQueryModel;
import net.ibizsys.ssdyna.demodel.DynaDEDataSetModel;
import net.ibizsys.ssdyna.demodel.DynaDEWFModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.entity.DynaEntity;
import net.ibizsys.ssdyna.service.DynaService;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class DynaDEModel
extends DataEntityModelBase<DynaEntity>
implements IDynaDEModel<DynaEntity> {
    private static final Log log = LogFactory.getLog(DynaDEModel.class);
    private IPSDataEntity iPSDataEntity = null;
    private IDynaSysModel iDynaSysModel = null;
    private DynaService dynaService;

    @Override
    public void init(IDynaSysModel iDynaSysModel, IPSDataEntity iPSDataEntity) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.iPSDataEntity = iPSDataEntity;
        this.setId(this.getPSDataEntity().getId());
        this.setName(this.getPSDataEntity().getName());
        this.setTableName(this.getPSDataEntity().getTableName());
        this.setViewName(this.getPSDataEntity().getViewName());
        this.setLogicName(this.getPSDataEntity().getLogicName());
        if (this.getPSDataEntity().isLogicValid()) {
            this.setLogicValid(true);
            this.setValidValue(this.getPSDataEntity().getLogicValidStringValue(true));
            this.setInvalidValue(this.getPSDataEntity().getLogicValidStringValue(false));
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDataEntity().getDSLink())) {
            this.setDSLink(this.getPSDataEntity().getDSLink());
        }
        if (this.getPSDataEntity().isEnableMultiDS()) {
            this.setEnableMultiDS(true);
        }
        if (this.getPSDataEntity().isEnableMultiForm()) {
            this.setEnableMultiForm(true);
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDataEntity().getIndexDEType())) {
            this.setIndexDEType(this.getPSDataEntity().getIndexDEType());
        }
        if (this.getPSDataEntity().getInheritPSDataEntity() != null) {
            this.setInheritDEId(this.getPSDataEntity().getInheritPSDataEntity().getId());
            this.setInheritTypeValue(this.getPSDataEntity().getPSDERInherit().getTypeValue());
        }
        this.setDataAccCtrlMode(this.getPSDataEntity().getDataAccCtrlMode());
        this.setAuditMode(this.getPSDataEntity().getAuditMode());
        if (this.getPSDataEntity().getDataChangeLogMode() != 0) {
            this.setDataChangeLogMode(this.getPSDataEntity().getDataChangeLogMode());
        }
        if (this.getPSDataEntity().isNoViewMode()) {
            this.setNoViewMode(true);
        }
        if (this.getPSDataEntity().getStorageMode() != 1) {
            this.setStorageMode(this.getPSDataEntity().getStorageMode());
        }
        this.prepareModels();
        this.iDynaSysModel.registerDataEntityModel((IDataEntityModel)this);
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    public ISystem getSystem() {
        return this.iDynaSysModel;
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return this.iDynaSysModel;
    }

    public DynaService getRealService() {
        if (this.dynaService == null) {
            try {
                DynaService dynaService = new DynaService();
                dynaService.init(this);
                this.dynaService = dynaService;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dynaService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public IService getService(SessionFactory sessionFactory) throws Exception {
        return this.getRealService();
    }

    public DynaEntity createEntity() {
        DynaEntity dynaEntity = new DynaEntity();
        if (!StringHelper.isNullOrEmpty((String)this.getInheritTypeValue())) {
            try {
                dynaEntity.set(this.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField().getName(), this.getInheritTypeValue());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return dynaEntity;
    }

    protected void prepareDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            iDEField = this.createDEField(iPSDEField.getName());
            if (iDEField == null) {
                DEFieldModel deFieldModel = new DEFieldModel();
                deFieldModel.setDataEntity((IDataEntity)this);
                deFieldModel.setId(iPSDEField.getId());
                deFieldModel.setName(iPSDEField.getName());
                deFieldModel.setLogicName(iPSDEField.getLogicName());
                deFieldModel.setDataType(iPSDEField.getDataType());
                deFieldModel.setStdDataType(iPSDEField.getStdDataType());
                if (iPSDEField.isKeyDEField()) {
                    deFieldModel.setKeyDEField(true);
                }
                if (iPSDEField.isMajorDEField()) {
                    deFieldModel.setMajorDEField(true);
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEField.getUnionKeyValue())) {
                    deFieldModel.setUnionKeyValue(iPSDEField.getUnionKeyValue());
                }
                if (iPSDEField.isLinkDEField()) {
                    deFieldModel.setLinkDEField(true);
                }
                if (iPSDEField.isInheritDEField()) {
                    deFieldModel.setInheritDEField(true);
                }
                if (iPSDEField.isMultiFormDEField()) {
                    deFieldModel.setMultiFormDEField(true);
                }
                if (iPSDEField.isIndexTypeDEField()) {
                    deFieldModel.setIndexTypeDEField(true);
                }
                deFieldModel.setImportOrder(iPSDEField.getImportOrder());
                deFieldModel.setImportTag(iPSDEField.getImportTag());
                if (iPSDEField.getDERName() != null) {
                    deFieldModel.setDERName(iPSDEField.getDERName());
                }
                if (iPSDEField.getLinkDEFName() != null) {
                    deFieldModel.setLinkDEFName(iPSDEField.getLinkDEFName());
                }
                if (!iPSDEField.isPhisicalDEField()) {
                    deFieldModel.setPhisicalDEField(false);
                }
                if (iPSDEField.isFormulaDEField()) {
                    deFieldModel.setFormulaDEField(true);
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEField.getPreDefinedType())) {
                    deFieldModel.setPreDefinedType(iPSDEField.getPreDefinedType());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEField.getDBValueFunc())) {
                    deFieldModel.setDBValueFunc(iPSDEField.getDBValueFunc());
                }
                if (iPSDEField.getPSCodeList() != null) {
                    deFieldModel.setCodeListId(iPSDEField.getPSCodeList().getId());
                }
                if (iPSDEField.getValueFormat() != null) {
                    deFieldModel.setValueFormat(iPSDEField.getValueFormat());
                }
                if (iPSDEField.isEnableAudit()) {
                    deFieldModel.setEnableAudit(true);
                    if (!StringHelper.isNullOrEmpty((String)iPSDEField.getAuditInfoFormat())) {
                        deFieldModel.setAuditInfoFormat(iPSDEField.getAuditInfoFormat());
                    }
                }
                if (this.getPSDataEntity().isEnableTempData() && !iPSDEField.isEnableTempData()) {
                    deFieldModel.setEnableTempData(false);
                }
                Iterator psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
                while (psDEFSearchModes.hasNext()) {
                    IPSDEFSearchMode iPSDEFSearchMode = (IPSDEFSearchMode)psDEFSearchModes.next();
                    iDEFSearchMode = this.createDEFSearchMode((IDEField)deFieldModel, iPSDEFSearchMode.getName());
                    if (iDEFSearchMode != null) continue;
                    DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                    defSearchModeModel.setDEField((IDEField)deFieldModel);
                    defSearchModeModel.setName(iPSDEFSearchMode.getName());
                    if (!StringHelper.isNullOrEmpty((String)iPSDEFSearchMode.getValueFunc())) {
                        defSearchModeModel.setValueFunc(iPSDEFSearchMode.getValueFunc());
                    }
                    defSearchModeModel.setValueOp(iPSDEFSearchMode.getValueOp());
                    defSearchModeModel.init();
                    deFieldModel.registerDEFSearchMode((IDEFSearchMode)defSearchModeModel);
                }
                deFieldModel.init();
                iDEField = deFieldModel;
            }
            this.registerDEField(iDEField);
        }
        psDEFields = this.getPSDataEntity().getDEMainStateDEFields();
        if (psDEFields != null) {
            ArrayList<String> list = new ArrayList<String>();
            while (psDEFields.hasNext()) {
                list.add(((IPSDEField)psDEFields.next()).getName().toLowerCase());
            }
            this.setMainStateFields(list.toArray(new String[list.size()]));
        }
    }

    protected void prepareDEACModes() throws Exception {
        Iterator psDEACModes = this.getPSDataEntity().getAllPSDEACModes();
        while (psDEACModes.hasNext()) {
            DynaDEACModel dynaDEACMode = new DynaDEACModel();
            dynaDEACMode.init(this, (IPSDEACMode)psDEACModes.next());
            this.registerDEACMode((IDEACMode)dynaDEACMode);
        }
    }

    protected void prepareDEDataSets() throws Exception {
        Iterator psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
        while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)psDEDataSets.next();
            if (StringHelper.isNullOrEmpty((String)iPSDEDataSet.getPredefinedType())) {
                DynaDEDataSetModel dynaDEDataSetModel = new DynaDEDataSetModel();
                dynaDEDataSetModel.init(this, iPSDEDataSet);
                this.registerDEDataSet((IDEDataSet)dynaDEDataSetModel);
                continue;
            }
            DynaCodeListDEDataSetModel dynaCodeListDEDataSetModel = new DynaCodeListDEDataSetModel();
            dynaCodeListDEDataSetModel.init(this, iPSDEDataSet);
            this.registerDEDataSet((IDEDataSet)dynaCodeListDEDataSetModel);
        }
    }

    protected void prepareDEDataQueries() throws Exception {
        Iterator psDEDataQueries = this.getPSDataEntity().getAllPSDEDataQueries();
        while (psDEDataQueries.hasNext()) {
            IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueries.next();
            DynaDEDataQueryModel dynaDEDataQueryModel = new DynaDEDataQueryModel();
            dynaDEDataQueryModel.init(this, iPSDEDataQuery);
            this.registerDEDataQuery((IDEDataQuery)dynaDEDataQueryModel);
        }
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    protected void prepareDEUIActions() throws Exception {
    }

    protected void prepareDEWFs() throws Exception {
        Iterator psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
        while (psDEWFs.hasNext()) {
            IPSDEWF iPSDEWF = (IPSDEWF)psDEWFs.next();
            DynaDEWFModel dynaDEWFModel = new DynaDEWFModel();
            dynaDEWFModel.init(this, iPSDEWF);
            this.registerDEWF((IDEWF)dynaDEWFModel);
        }
    }

    protected void prepareDEMainStates() throws Exception {
    }

    protected void prepareDEDataSyncs() throws Exception {
    }

    protected void preparePDTDEViews() throws Exception {
    }

    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    protected void prepareDEPrints() throws Exception {
    }

    protected void prepareDEReports() throws Exception {
    }

    protected void prepareDEDataExports() throws Exception {
    }

    protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {
        super.onFillFetchQuickSearchConditions(groupCondImpl, strQuickSearch);
    }

    @Override
    public boolean isDynaDETemplMode() {
        return false;
    }
}

