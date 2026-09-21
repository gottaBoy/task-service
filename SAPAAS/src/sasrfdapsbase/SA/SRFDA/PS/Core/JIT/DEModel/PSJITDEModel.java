/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DataEntityModelBase
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITCodeListDEDataSetModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEACModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataQueryModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataSetModel;
import SA.SRFDA.PS.Core.JIT.Entity.PSJITEntity;
import SA.SRFDA.PS.Core.JIT.Service.PSJITService;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITDEWFModel;
import java.util.ArrayList;
import java.util.Iterator;
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
import net.ibizsys.paas.demodel.DataEntityModelBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import org.hibernate.SessionFactory;

public class PSJITDEModel
extends DataEntityModelBase<PSJITEntity>
implements IPSJITDEModel<PSJITEntity> {
    private IPSDataEntity iPSDataEntity = null;
    private IPSJITSystemModel iSystemModel = null;
    private PSJITService psJITService;

    public void init(IPSJITSystemModel ISystemModel2, IPSDataEntity iPSDataEntity) throws Exception {
        this.iSystemModel = ISystemModel2;
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
        this.iSystemModel.registerDataEntityModel(this);
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    public ISystem getSystem() {
        return this.iSystemModel;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iSystemModel;
    }

    public PSJITService getRealService() {
        if (this.psJITService == null) {
            try {
                PSJITService psJITService = new PSJITService();
                psJITService.init(this);
                this.psJITService = psJITService;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.psJITService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public IService getService(SessionFactory sessionFactory) throws Exception {
        return this.getRealService();
    }

    public PSJITEntity createEntity() {
        return new PSJITEntity();
    }

    protected void prepareDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
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
                Iterator<IPSDEFSearchMode> psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
                while (psDEFSearchModes.hasNext()) {
                    IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
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
                list.add(psDEFields.next().getName().toLowerCase());
            }
            this.setMainStateFields(list.toArray(new String[list.size()]));
        }
    }

    protected void prepareDEACModes() throws Exception {
        Iterator<IPSDEACMode> psDEACModes = this.getPSDataEntity().getAllPSDEACModes();
        while (psDEACModes.hasNext()) {
            PSJITDEACModel psJITDEACMode = new PSJITDEACModel();
            psJITDEACMode.init(this, psDEACModes.next());
            this.registerDEACMode((IDEACMode)psJITDEACMode);
        }
    }

    protected void prepareDEDataSets() throws Exception {
        Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
        while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
            if (StringHelper.isNullOrEmpty((String)iPSDEDataSet.getPredefinedType())) {
                PSJITDEDataSetModel psJITDEDataSetModel = new PSJITDEDataSetModel();
                psJITDEDataSetModel.init(this, iPSDEDataSet);
                this.registerDEDataSet((IDEDataSet)psJITDEDataSetModel);
                continue;
            }
            PSJITCodeListDEDataSetModel psJITCodeListDEDataSetModel = new PSJITCodeListDEDataSetModel();
            psJITCodeListDEDataSetModel.init(this, iPSDEDataSet);
            this.registerDEDataSet((IDEDataSet)psJITCodeListDEDataSetModel);
        }
    }

    protected void prepareDEDataQueries() throws Exception {
        Iterator<IPSDEDataQuery> psDEDataQueries = this.getPSDataEntity().getAllPSDEDataQueries();
        while (psDEDataQueries.hasNext()) {
            IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
            PSJITDEDataQueryModel psJITDEDataQueryModel = new PSJITDEDataQueryModel();
            psJITDEDataQueryModel.init(this, iPSDEDataQuery);
            this.registerDEDataQuery((IDEDataQuery)psJITDEDataQueryModel);
        }
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    protected void prepareDEUIActions() throws Exception {
    }

    protected void prepareDEWFs() throws Exception {
        Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
        while (psDEWFs.hasNext()) {
            IPSDEWF iPSDEWF = psDEWFs.next();
            PSJITDEWFModel psJITDEWFModel = new PSJITDEWFModel();
            psJITDEWFModel.init(this, iPSDEWF);
            this.registerDEWF((IDEWF)psJITDEWFModel);
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
}

