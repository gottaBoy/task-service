/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewgroup.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6FF64A2B-A973-4827-9F05-0D404CAEE8EB", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVIEWGROUPID`, t1.`PSDEVIEWGROUPNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVIEWGROUP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVIEWGROUPID", expression="t1.`PSDEVIEWGROUPID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWGROUPNAME", expression="t1.`PSDEVIEWGROUPNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDEVIEWGROUP\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVIEWGROUPID, t1.PSDEVIEWGROUPNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVIEWGROUP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVIEWGROUPID", expression="t1.PSDEVIEWGROUPID", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWGROUPNAME", expression="t1.PSDEVIEWGROUPNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDEVIEWGROUP\"}')} )")})})
public class PSDEViewGroupCurSysDQModel
extends DEDataQueryModelBase {
    public PSDEViewGroupCurSysDQModel() {
        this.initAnnotation(PSDEViewGroupCurSysDQModel.class);
    }
}

