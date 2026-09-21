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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelmemo.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="074EC15F-F75D-49F3-AE74-F881185413EF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PPSMODELMEMOID`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`PSMODELMEMOID`, t1.`PSMODELMEMONAME`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`PSOBJTYPE`, t1.`PSOBJTYPENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELMEMO` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PPSMODELMEMOID", expression="t1.`PPSMODELMEMOID`", showorder=3), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=4), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELMEMOID", expression="t1.`PSMODELMEMOID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELMEMONAME", expression="t1.`PSMODELMEMONAME`", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.`PSOBJTYPENAME`", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PPSMODELMEMOID, t1.PSDEFID, t1.PSDEFNAME, t1.PSMODELMEMOID, t1.PSMODELMEMONAME, t1.PSOBJID, t1.PSOBJNAME, t1.PSOBJTYPE, t1.PSOBJTYPENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELMEMO t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PPSMODELMEMOID", expression="t1.PPSMODELMEMOID", showorder=3), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=4), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELMEMOID", expression="t1.PSMODELMEMOID", showorder=6), @DEDataQueryCodeExp(name="PSMODELMEMONAME", expression="t1.PSMODELMEMONAME", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=9), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.PSOBJTYPENAME", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSModelMemoDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelMemoDefaultDQModel() {
        this.initAnnotation(PSModelMemoDefaultDQModel.class);
    }
}

