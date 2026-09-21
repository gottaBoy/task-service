/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvrprovider.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="32C92B47-F290-493D-A0BC-FF96A10BD3D0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSVRPROVIDERID`, t1.`PSSVRPROVIDERNAME`, t1.`SPSN`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSVRPROVIDER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t1.`PSSVRPROVIDERID`", showorder=3), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t1.`PSSVRPROVIDERNAME`", showorder=4), @DEDataQueryCodeExp(name="SPSN", expression="t1.`SPSN`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSVRPROVIDERID, t1.PSSVRPROVIDERNAME, t1.SPSN, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSVRPROVIDER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSVRPROVIDERID", expression="t1.PSSVRPROVIDERID", showorder=3), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t1.PSSVRPROVIDERNAME", showorder=4), @DEDataQueryCodeExp(name="SPSN", expression="t1.SPSN", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSSvrProviderDefaultDQModel
extends DEDataQueryModelBase {
    public PSSvrProviderDefaultDQModel() {
        this.initAnnotation(PSSvrProviderDefaultDQModel.class);
    }
}

