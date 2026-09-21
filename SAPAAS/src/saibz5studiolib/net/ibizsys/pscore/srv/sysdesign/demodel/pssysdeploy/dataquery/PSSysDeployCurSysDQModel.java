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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeploy.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B725AD6D-7A21-47DD-B1CF-AA2F115B4CEA", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTDEPLOY`, t1.`MEMO`, t1.`PSDEVCENTERASID`, t11.`PSDEVCENTERASNAME`, t1.`PSSYSDEPLOYID`, t1.`PSSYSDEPLOYNAME`, t1.`PSSYSSFPUBID`, t21.`PSSYSSFPUBNAME`, t1.`PSSYSTEMID`, t31.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSSYSDEPLOY` t1  LEFT JOIN T_SRFPSDEVCENTERAS t11 ON t1.PSDEVCENTERASID = t11.PSDEVCENTERASID  LEFT JOIN T_SRFPSSYSSFPUB t21 ON t1.PSSYSSFPUBID = t21.PSSYSSFPUBID  LEFT JOIN T_SRFPSSYSTEM t31 ON t1.PSSYSTEMID = t31.PSSYSTEMID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTDEPLOY", expression="t1.`DEFAULTDEPLOY`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.`PSDEVCENTERASID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t11.`PSDEVCENTERASNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.`PSSYSDEPLOYID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t1.`PSSYSDEPLOYNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.`PSSYSSFPUBID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t21.`PSSYSSFPUBNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t31.`PSSYSTEMNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSDEPLOY\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTDEPLOY, t1.MEMO, t1.PSDEVCENTERASID, t11.PSDEVCENTERASNAME, t1.PSSYSDEPLOYID, t1.PSSYSDEPLOYNAME, t1.PSSYSSFPUBID, t21.PSSYSSFPUBNAME, t1.PSSYSTEMID, t31.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSSYSDEPLOY t1  LEFT JOIN T_SRFPSDEVCENTERAS t11 ON t1.PSDEVCENTERASID = t11.PSDEVCENTERASID  LEFT JOIN T_SRFPSSYSSFPUB t21 ON t1.PSSYSSFPUBID = t21.PSSYSSFPUBID  LEFT JOIN T_SRFPSSYSTEM t31 ON t1.PSSYSTEMID = t31.PSSYSTEMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTDEPLOY", expression="t1.DEFAULTDEPLOY", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.PSDEVCENTERASID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t11.PSDEVCENTERASNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.PSSYSDEPLOYID", showorder=6), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t1.PSSYSDEPLOYNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.PSSYSSFPUBID", showorder=8), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t21.PSSYSSFPUBNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t31.PSSYSTEMNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSDEPLOY\"}')} )")})})
public class PSSysDeployCurSysDQModel
extends DEDataQueryModelBase {
    public PSSysDeployCurSysDQModel() {
        this.initAnnotation(PSSysDeployCurSysDQModel.class);
    }
}

