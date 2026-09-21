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
package net.ibizsys.pscore.srv.config.demodel.pssubsys.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B7C28568-BEBD-4629-A561-C050E0243860", name="SFFW")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVSLNSYSID`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSUBSYSID`, t1.`PSSUBSYSNAME`, t1.`PSSYSTEMID`, t1.`SFFWFLAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VERSION` FROM `T_SRFPSSUBSYS` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DEMODELS", expression="t1.`DEMODELS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=3), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=4), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.`PSSUBSYSNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=8), @DEDataQueryCodeExp(name="SFFWFLAG", expression="t1.`SFFWFLAG`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="VERSION", expression="t1.`VERSION`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSFID` =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSUBSYS\"}')}  AND  t1.`SFFWFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVSLNSYSID, t1.PSSFID, t1.PSSFNAME, t1.PSSUBSYSID, t1.PSSUBSYSNAME, t1.PSSYSTEMID, t1.SFFWFLAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VERSION FROM T_SRFPSSUBSYS t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DEMODELS", expression="t1.DEMODELS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=3), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=4), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.PSSUBSYSNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=8), @DEDataQueryCodeExp(name="SFFWFLAG", expression="t1.SFFWFLAG", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="VERSION", expression="t1.VERSION", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSFID =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSUBSYS\"}')}  AND  t1.SFFWFLAG = 1 )")})})
public class PSSubSysSFFWDQModel
extends DEDataQueryModelBase {
    public PSSubSysSFFWDQModel() {
        this.initAnnotation(PSSubSysSFFWDQModel.class);
    }
}

