/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEFieldModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.saas.demodel.DataEntityModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.demodel;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.demodel.DynaDEWFModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataEntityModelBase<ET extends IEntity>
extends net.ibizsys.saas.demodel.DataEntityModelBase<ET>
implements IDynaDEModel<ET> {
    private static final Log log = LogFactory.getLog(DataEntityModelBase.class);
    private IPSDataEntity iPSDataEntity = null;
    private IDynaSysModel iDynaSysModel = null;
    private boolean bInit = false;

    @Override
    public void init(IDynaSysModel iDynaSysModel, IPSDataEntity iPSDataEntity) throws Exception {
        if (!this.isDynaDETemplMode()) {
            throw new Exception("\u5f53\u524d\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61\u4e0d\u652f\u6301\u521d\u59cb\u5316\u64cd\u4f5c");
        }
        this.iDynaSysModel = iDynaSysModel;
        this.iPSDataEntity = iPSDataEntity;
        this.bInit = true;
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
        this.onInit();
        this.iPSDataEntity = null;
    }

    protected void prepareModels() throws Exception {
        if (this.isDynaDETemplMode()) {
            if (!this.bInit) {
                return;
            }
            super.prepareModels();
            this.prepareDynaModels();
        } else {
            super.prepareModels();
        }
    }

    protected void prepareDynaModels() throws Exception {
        this.prepareDynaDEFields();
        this.prepareDynaDEWFs();
        this.prepareDynaPDTDEViews();
    }

    public IPSDataEntity getPSDataEntity() throws Exception {
        if (this.iPSDataEntity == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53]%1$s][%2$s]\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", (Object)this.getName(), (Object)this.getId()));
        }
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return (IDynaSysModel)this.getSystemModel();
    }

    @Override
    public boolean isDynaDETemplMode() {
        return false;
    }

    protected boolean isRegisterToDEModelGlobal() {
        return !this.isDynaDETemplMode();
    }

    protected void prepareDynaDEWFs() throws Exception {
        this.resetDEWFs();
        Iterator psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
        while (psDEWFs.hasNext()) {
            IPSDEWF iPSDEWF = (IPSDEWF)psDEWFs.next();
            DynaDEWFModel psJITDEWFModel = new DynaDEWFModel();
            psJITDEWFModel.init(this, iPSDEWF);
            this.registerDEWF((IDEWF)psJITDEWFModel);
        }
    }

    protected void prepareDynaDEFields() throws Exception {
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            if (this.getDEField(iPSDEField.getName(), true) != null) continue;
            iDEField = this.createDEField(iPSDEField.getName());
            if (iDEField == null) {
                DEFieldModel deFieldModel = new DEFieldModel();
                deFieldModel.setDataEntity((IDataEntity)this);
                deFieldModel.setId(iPSDEField.getId());
                deFieldModel.setName(iPSDEField.getName());
                deFieldModel.setLogicName(iPSDEField.getLogicName());
                deFieldModel.setDEFType(iPSDEField.getDEFType());
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
    }

    protected void prepareDynaPDTDEViews() throws Exception {
        Iterator pdtViewNames = this.getPSDataEntity().getPDTViewNames();
        if (pdtViewNames != null) {
            while (pdtViewNames.hasNext()) {
                String strPDTViewName = (String)pdtViewNames.next();
                this.registerPDTDEView(strPDTViewName, this.getPSDataEntity().getPSDEViewIdByPDT(strPDTViewName));
            }
        }
    }
}

