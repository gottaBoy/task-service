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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysmodelrepo.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="003AB006-AB42-4970-9AAB-FC928F79F48C", name="Valid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`GITBRANCH`, t1.`GITPATH`, t1.`MEMO`, t1.`PSSYSMODELREPOID`, t1.`PSSYSMODELREPONAME`, t1.`REPOTAG`, t1.`REPOTAG2`, t1.`REPOTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSMODELREPO` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="GITBRANCH", expression="t1.`GITBRANCH`", showorder=2), @DEDataQueryCodeExp(name="GITPATH", expression="t1.`GITPATH`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELREPOID", expression="t1.`PSSYSMODELREPOID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSMODELREPONAME", expression="t1.`PSSYSMODELREPONAME`", showorder=6), @DEDataQueryCodeExp(name="REPOTAG", expression="t1.`REPOTAG`", showorder=7), @DEDataQueryCodeExp(name="REPOTAG2", expression="t1.`REPOTAG2`", showorder=8), @DEDataQueryCodeExp(name="REPOTYPE", expression="t1.`REPOTYPE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.GITBRANCH, t1.GITPATH, t1.MEMO, t1.PSSYSMODELREPOID, t1.PSSYSMODELREPONAME, t1.REPOTAG, t1.REPOTAG2, t1.REPOTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSMODELREPO t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="GITBRANCH", expression="t1.GITBRANCH", showorder=2), @DEDataQueryCodeExp(name="GITPATH", expression="t1.GITPATH", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELREPOID", expression="t1.PSSYSMODELREPOID", showorder=5), @DEDataQueryCodeExp(name="PSSYSMODELREPONAME", expression="t1.PSSYSMODELREPONAME", showorder=6), @DEDataQueryCodeExp(name="REPOTAG", expression="t1.REPOTAG", showorder=7), @DEDataQueryCodeExp(name="REPOTAG2", expression="t1.REPOTAG2", showorder=8), @DEDataQueryCodeExp(name="REPOTYPE", expression="t1.REPOTYPE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1 )")})})
public class PSSysModelRepoValidDQModel
extends DEDataQueryModelBase {
    public PSSysModelRepoValidDQModel() {
        this.initAnnotation(PSSysModelRepoValidDQModel.class);
    }
}

