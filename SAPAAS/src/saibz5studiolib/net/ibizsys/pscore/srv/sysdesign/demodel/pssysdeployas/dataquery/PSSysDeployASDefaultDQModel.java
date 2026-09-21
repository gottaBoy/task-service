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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeployas.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="668E99CA-B161-46BB-B9F6-820FD8A68797", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSYSDEPLOYASID`, t1.`PSSYSDEPLOYASNAME`, t1.`PSSYSDEPLOYID`, t11.`PSSYSDEPLOYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDEPLOYAS` t1  LEFT JOIN T_SRFPSSYSDEPLOY t11 ON t1.PSSYSDEPLOYID = t11.PSSYSDEPLOYID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSSYSDEPLOYASID", expression="t1.`PSSYSDEPLOYASID`", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEPLOYASNAME", expression="t1.`PSSYSDEPLOYASNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.`PSSYSDEPLOYID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t11.`PSSYSDEPLOYNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSSYSDEPLOYASID, t1.PSSYSDEPLOYASNAME, t1.PSSYSDEPLOYID, t11.PSSYSDEPLOYNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDEPLOYAS t1  LEFT JOIN T_SRFPSSYSDEPLOY t11 ON t1.PSSYSDEPLOYID = t11.PSSYSDEPLOYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSSYSDEPLOYASID", expression="t1.PSSYSDEPLOYASID", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEPLOYASNAME", expression="t1.PSSYSDEPLOYASNAME", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.PSSYSDEPLOYID", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t11.PSSYSDEPLOYNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSSysDeployASDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDeployASDefaultDQModel() {
        this.initAnnotation(PSSysDeployASDefaultDQModel.class);
    }
}

