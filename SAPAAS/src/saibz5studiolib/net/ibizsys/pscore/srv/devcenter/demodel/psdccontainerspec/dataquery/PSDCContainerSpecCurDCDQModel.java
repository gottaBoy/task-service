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
package net.ibizsys.pscore.srv.devcenter.demodel.psdccontainerspec.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="02B99480-E409-4B05-B849-5550E0D475F0", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CFGTYPE`, t1.`CLUSTERTYPE`, t1.`CPULIMIT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MEMORYLIMIT`, t1.`PSDCCONTAINERSPECID`, t1.`PSDCCONTAINERSPECNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`SPECPARAMS`, t1.`SPECTAG`, t1.`SPECTAG2`, t1.`SPECVER`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCCONTAINERSPEC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTAINERCFG", expression="t1.`CONTAINERCFG`", showorder=-1), @DEDataQueryCodeExp(name="CFGTYPE", expression="t1.`CFGTYPE`", showorder=0), @DEDataQueryCodeExp(name="CLUSTERTYPE", expression="t1.`CLUSTERTYPE`", showorder=1), @DEDataQueryCodeExp(name="CPULIMIT", expression="t1.`CPULIMIT`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="MEMORYLIMIT", expression="t1.`MEMORYLIMIT`", showorder=6), @DEDataQueryCodeExp(name="PSDCCONTAINERSPECID", expression="t1.`PSDCCONTAINERSPECID`", showorder=7), @DEDataQueryCodeExp(name="PSDCCONTAINERSPECNAME", expression="t1.`PSDCCONTAINERSPECNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=10), @DEDataQueryCodeExp(name="SPECPARAMS", expression="t1.`SPECPARAMS`", showorder=11), @DEDataQueryCodeExp(name="SPECTAG", expression="t1.`SPECTAG`", showorder=12), @DEDataQueryCodeExp(name="SPECTAG2", expression="t1.`SPECTAG2`", showorder=13), @DEDataQueryCodeExp(name="SPECVER", expression="t1.`SPECVER`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCCONTAINERSPEC\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CFGTYPE, t1.CLUSTERTYPE, t1.CPULIMIT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MEMORYLIMIT, t1.PSDCCONTAINERSPECID, t1.PSDCCONTAINERSPECNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.SPECPARAMS, t1.SPECTAG, t1.SPECTAG2, t1.SPECVER, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCCONTAINERSPEC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTAINERCFG", expression="t1.CONTAINERCFG", showorder=-1), @DEDataQueryCodeExp(name="CFGTYPE", expression="t1.CFGTYPE", showorder=0), @DEDataQueryCodeExp(name="CLUSTERTYPE", expression="t1.CLUSTERTYPE", showorder=1), @DEDataQueryCodeExp(name="CPULIMIT", expression="t1.CPULIMIT", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="MEMORYLIMIT", expression="t1.MEMORYLIMIT", showorder=6), @DEDataQueryCodeExp(name="PSDCCONTAINERSPECID", expression="t1.PSDCCONTAINERSPECID", showorder=7), @DEDataQueryCodeExp(name="PSDCCONTAINERSPECNAME", expression="t1.PSDCCONTAINERSPECNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=10), @DEDataQueryCodeExp(name="SPECPARAMS", expression="t1.SPECPARAMS", showorder=11), @DEDataQueryCodeExp(name="SPECTAG", expression="t1.SPECTAG", showorder=12), @DEDataQueryCodeExp(name="SPECTAG2", expression="t1.SPECTAG2", showorder=13), @DEDataQueryCodeExp(name="SPECVER", expression="t1.SPECVER", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCCONTAINERSPEC\"}')} )")})})
public class PSDCContainerSpecCurDCDQModel
extends DEDataQueryModelBase {
    public PSDCContainerSpecCurDCDQModel() {
        this.initAnnotation(PSDCContainerSpecCurDCDQModel.class);
    }
}

