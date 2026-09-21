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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysprdver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="42268230-DCA2-4E83-A9D5-4F6B92C4EBD3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PRDVERSTATE`, t1.`PSDCSYSPRDVERID`, t1.`PSDCSYSPRDVERNAME`, t1.`PSDCSYSPRODUCTID`, t1.`PSDCSYSPRODUCTNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCSYSPRDVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRDVERSTATE", expression="t1.`PRDVERSTATE`", showorder=3), @DEDataQueryCodeExp(name="PSDCSYSPRDVERID", expression="t1.`PSDCSYSPRDVERID`", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSPRDVERNAME", expression="t1.`PSDCSYSPRDVERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTID", expression="t1.`PSDCSYSPRODUCTID`", showorder=6), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTNAME", expression="t1.`PSDCSYSPRODUCTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PRDVERSTATE, t1.PSDCSYSPRDVERID, t1.PSDCSYSPRDVERNAME, t1.PSDCSYSPRODUCTID, t1.PSDCSYSPRODUCTNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCSYSPRDVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRDVERSTATE", expression="t1.PRDVERSTATE", showorder=3), @DEDataQueryCodeExp(name="PSDCSYSPRDVERID", expression="t1.PSDCSYSPRDVERID", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSPRDVERNAME", expression="t1.PSDCSYSPRDVERNAME", showorder=5), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTID", expression="t1.PSDCSYSPRODUCTID", showorder=6), @DEDataQueryCodeExp(name="PSDCSYSPRODUCTNAME", expression="t1.PSDCSYSPRODUCTNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDCSysPrdVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSysPrdVerDefaultDQModel() {
        this.initAnnotation(PSDCSysPrdVerDefaultDQModel.class);
    }
}

