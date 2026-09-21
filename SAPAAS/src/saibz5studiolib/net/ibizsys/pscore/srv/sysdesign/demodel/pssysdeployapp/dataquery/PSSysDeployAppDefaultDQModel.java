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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeployapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6F31D23C-DFD9-4017-A42B-D72A6F14C0F1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSAPPID`, t11.`PSSYSAPPNAME`, t1.`PSSYSDEPLOYAPPID`, t1.`PSSYSDEPLOYAPPNAME`, t1.`PSSYSDEPLOYID`, t21.`PSSYSDEPLOYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDEPLOYAPP` t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  LEFT JOIN T_SRFPSSYSDEPLOY t21 ON t1.PSSYSDEPLOYID = t21.PSSYSDEPLOYID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.`PSSYSAPPNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEPLOYAPPID", expression="t1.`PSSYSDEPLOYAPPID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSDEPLOYAPPNAME", expression="t1.`PSSYSDEPLOYAPPNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.`PSSYSDEPLOYID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t21.`PSSYSDEPLOYNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSAPPID, t11.PSSYSAPPNAME, t1.PSSYSDEPLOYAPPID, t1.PSSYSDEPLOYAPPNAME, t1.PSSYSDEPLOYID, t21.PSSYSDEPLOYNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDEPLOYAPP t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  LEFT JOIN T_SRFPSSYSDEPLOY t21 ON t1.PSSYSDEPLOYID = t21.PSSYSDEPLOYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=3), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.PSSYSAPPNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEPLOYAPPID", expression="t1.PSSYSDEPLOYAPPID", showorder=5), @DEDataQueryCodeExp(name="PSSYSDEPLOYAPPNAME", expression="t1.PSSYSDEPLOYAPPNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.PSSYSDEPLOYID", showorder=7), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t21.PSSYSDEPLOYNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSSysDeployAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDeployAppDefaultDQModel() {
        this.initAnnotation(PSSysDeployAppDefaultDQModel.class);
    }
}

