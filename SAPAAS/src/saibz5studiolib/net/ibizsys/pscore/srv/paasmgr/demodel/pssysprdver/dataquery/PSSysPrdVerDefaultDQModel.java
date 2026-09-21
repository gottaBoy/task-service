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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysprdver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E16DA4CC-048B-41F8-9019-D358684850F1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSPRDVERID`, t1.`PSSYSPRDVERNAME`, t1.`PSSYSPRODUCTID`, t1.`PSSYSPRODUCTNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSPRDVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSPRDVERID", expression="t1.`PSSYSPRDVERID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSPRDVERNAME", expression="t1.`PSSYSPRDVERNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.`PSSYSPRODUCTID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.`PSSYSPRODUCTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSPRDVERID, t1.PSSYSPRDVERNAME, t1.PSSYSPRODUCTID, t1.PSSYSPRODUCTNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSPRDVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSPRDVERID", expression="t1.PSSYSPRDVERID", showorder=3), @DEDataQueryCodeExp(name="PSSYSPRDVERNAME", expression="t1.PSSYSPRDVERNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.PSSYSPRODUCTID", showorder=5), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.PSSYSPRODUCTNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSSysPrdVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysPrdVerDefaultDQModel() {
        this.initAnnotation(PSSysPrdVerDefaultDQModel.class);
    }
}

