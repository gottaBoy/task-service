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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysfile.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EC72319D-1A27-45B1-9FC1-333B0115DF96", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FILEOBJSIZE`, t1.`MEMO`, t1.`OWNERID`, t1.`OWNERNAME`, t1.`OWNERTYPE`, t1.`PSMODULEID`, t11.`PSMODULENAME`, t1.`PSNDFILEID`, t1.`PSSYSFILEID`, t1.`PSSYSFILENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSFILE` t1  LEFT JOIN `T_SRFPSMODULE` t11 ON t1.`PSMODULEID` = t11.`PSMODULEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="FILEOBJSIZE", expression="t1.`FILEOBJSIZE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="OWNERID", expression="t1.`OWNERID`", showorder=5), @DEDataQueryCodeExp(name="OWNERNAME", expression="t1.`OWNERNAME`", showorder=6), @DEDataQueryCodeExp(name="OWNERTYPE", expression="t1.`OWNERTYPE`", showorder=7), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.`PSMODULEID`", showorder=8), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.`PSMODULENAME`", showorder=9), @DEDataQueryCodeExp(name="PSNDFILEID", expression="t1.`PSNDFILEID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSFILEID", expression="t1.`PSSYSFILEID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSFILENAME", expression="t1.`PSSYSFILENAME`", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=13), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.FILEOBJSIZE, t1.MEMO, t1.OWNERID, t1.OWNERNAME, t1.OWNERTYPE, t1.PSMODULEID, t11.PSMODULENAME, t1.PSNDFILEID, t1.PSSYSFILEID, t1.PSSYSFILENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSFILE t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="FILEOBJSIZE", expression="t1.FILEOBJSIZE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="OWNERID", expression="t1.OWNERID", showorder=5), @DEDataQueryCodeExp(name="OWNERNAME", expression="t1.OWNERNAME", showorder=6), @DEDataQueryCodeExp(name="OWNERTYPE", expression="t1.OWNERTYPE", showorder=7), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.PSMODULEID", showorder=8), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.PSMODULENAME", showorder=9), @DEDataQueryCodeExp(name="PSNDFILEID", expression="t1.PSNDFILEID", showorder=10), @DEDataQueryCodeExp(name="PSSYSFILEID", expression="t1.PSSYSFILEID", showorder=11), @DEDataQueryCodeExp(name="PSSYSFILENAME", expression="t1.PSSYSFILENAME", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=13), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={})})
public class PSSysFileDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysFileDefaultDQModel() {
        this.initAnnotation(PSSysFileDefaultDQModel.class);
    }
}

