/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond;
import net.ibizsys.model.entity.PSDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;

public class PSDEDataQueryCodeCondImp
extends PSObjectImpl
implements IPSDEDataQueryCodeCond {
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private String strCustomCond = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQueryCode iPSDEDataQueryCode, PSDEDataQueryCodeCond psDEDataQueryCodeCond) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        this.setId(psDEDataQueryCodeCond.getPSDEDQCODECONDID());
        this.setName(psDEDataQueryCodeCond.getPSDEDQCODECONDNAME());
        this.setPSObjectData(psDEDataQueryCodeCond, false);
        this.strCustomCond = psDEDataQueryCodeCond.getCONDCODE();
        this.onInit();
    }

    public String getDEFName() {
        return null;
    }

    public String getCondType() {
        return "CUSTOM";
    }

    public String getCondOp() {
        return null;
    }

    public String getCondValue() {
        return null;
    }

    public String getCustomCond() {
        return this.strCustomCond;
    }

    public String getPredefindedCond() {
        return null;
    }

    public String getPredefinedCode() {
        return null;
    }

    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        return null;
    }

    public String getDEFieldExp() {
        return null;
    }

    public boolean isNotMode() {
        return false;
    }

    public int getStdDataType() {
        return 0;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSSysModelInstId();
    }

    public String getValueFunc() {
        return null;
    }
}

