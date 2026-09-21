/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEDSGroupParam;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDataSetGroupParamImpl
extends PSObjectImpl
implements IPSDEDataSetGroupParam {
    protected IPSDEDataSet iPSDEDataSet;
    protected PSDEDSGroupParam psDEDSGroupParam;
    private String strGroupCode = null;
    private String strGroupField = null;
    private String strSortDir = null;
    private int nSortOrder = -1;
    private int nStdDataType = -1;
    private boolean bEnableGroup = false;
    private String[] groupFields = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataSet iPSDEDataSet, PSDEDSGroupParam psDEDSGroupParam) throws Exception {
        IPSDEField iPSDEField;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDataSet = iPSDEDataSet;
        this.psDEDSGroupParam = psDEDSGroupParam;
        this.setId(this.psDEDSGroupParam.getPSDEDSGRPPARAMID());
        this.setName(this.psDEDSGroupParam.getPSDEDSGRPPARAMNAME());
        this.setPSObjectData(this.psDEDSGroupParam);
        if (!StringHelper.isNullOrEmpty((String)this.psDEDSGroupParam.getGROUPCODE())) {
            this.strGroupCode = this.psDEDSGroupParam.getGROUPCODE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEDSGroupParam.getCUSTOMDEFNAME())) {
            this.strGroupField = this.psDEDSGroupParam.getCUSTOMDEFNAME();
        } else if (!StringHelper.isNullOrEmpty((String)this.psDEDSGroupParam.getPSDEFNAME())) {
            this.strGroupField = this.psDEDSGroupParam.getPSDEFNAME();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strGroupField)) {
            this.strGroupField = this.strGroupField.trim();
            if (!StringHelper.isNullOrEmpty((String)this.strGroupField)) {
                this.groupFields = this.strGroupField.split("[,]");
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEDSGroupParam.getORDERDIR())) {
            this.strSortDir = this.psDEDSGroupParam.getORDERDIR();
        }
        if (!this.psDEDSGroupParam.isSORTORDERVALUENull()) {
            this.nSortOrder = this.psDEDSGroupParam.getSORTORDERVALUE();
        }
        this.nStdDataType = this.psDEDSGroupParam.getSTDDATATYPE();
        if (this.nStdDataType <= 0 && !StringHelper.isNullOrEmpty((String)this.strGroupField) && (iPSDEField = this.iPSDEDataSet.getPSDataEntity().getPSDEField(this.strGroupField, true)) != null) {
            this.nStdDataType = iPSDEField.getStdDataType();
        }
        if (!this.psDEDSGroupParam.isGROUPFLAGNull()) {
            this.bEnableGroup = this.psDEDSGroupParam.getGROUPFLAG();
        }
        this.onInit();
    }

    public String getGroupCode() {
        return this.strGroupCode;
    }

    public String getSortDir() {
        return this.strSortDir;
    }

    public int getSortOrder() {
        return this.nSortOrder;
    }

    public IDEDataSet getDEDataSet() {
        return this.getPSDEDataSet();
    }

    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public int getStdDataType() {
        return this.nStdDataType;
    }

    public String[] getGroupFields() {
        return this.groupFields;
    }

    public boolean isReCalc() {
        return false;
    }

    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEDataSet);
    }
}

