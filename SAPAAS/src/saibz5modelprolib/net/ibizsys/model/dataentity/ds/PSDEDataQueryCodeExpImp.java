/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp
 *  net.ibizsys.paas.data.DataObject
 */
package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.model.entity.PSDEDataQueryCodeExp;
import net.ibizsys.paas.data.DataObject;

public class PSDEDataQueryCodeExpImp
extends PSObjectImpl
implements IPSDEDataQueryCodeExp {
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private String strExpression = "";
    private int nShowOrder = -1;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQueryCode iPSDEDataQueryCode, PSDEDataQueryCodeExp psDEDataQueryCodeExp) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        this.setId(psDEDataQueryCodeExp.getPSDEDQCODEEXPID());
        this.setName(psDEDataQueryCodeExp.getPSDEDQCODEEXPNAME());
        this.setPSObjectData(psDEDataQueryCodeExp, false);
        this.strExpression = DataObject.getStringValue((Object)psDEDataQueryCodeExp.getEXPCODE(), (String)"");
        this.nShowOrder = DataObject.getIntegerValue((Object)psDEDataQueryCodeExp.getORDERVALUE(), (Integer)0);
        this.onInit();
    }

    public String getExpression() {
        return this.strExpression;
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSSysModelInstId();
    }
}

