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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbindex.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="182BC16C-189E-4930-9F09-B875AB5129AC", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLOWREVERSE`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INCFIELDS`, t1.`INDEXFIELDS`, t1.`INDEXTYPE`, t1.`MEMO`, t1.`PSDEDBINDEXID`, t1.`PSDEDBINDEXNAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`REMOVEFLAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSDEDBINDEX` t1  ", querycodetemp="SELECT t1.`ALLOWREVERSE`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INCFIELDS`, t1.`INDEXFIELDS`, t1.`INDEXTYPE`, t1.`MEMO`, t1.`PSDEDBINDEXID`, t1.`PSDEDBINDEXNAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`REMOVEFLAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEDBINDEX_TMP` t1  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLOWREVERSE", expression="t1.`ALLOWREVERSE`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="INCFIELDS", expression="t1.`INCFIELDS`", showorder=4), @DEDataQueryCodeExp(name="INDEXFIELDS", expression="t1.`INDEXFIELDS`", showorder=5), @DEDataQueryCodeExp(name="INDEXTYPE", expression="t1.`INDEXTYPE`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSDEDBINDEXID", expression="t1.`PSDEDBINDEXID`", showorder=8), @DEDataQueryCodeExp(name="PSDEDBINDEXNAME", expression="t1.`PSDEDBINDEXNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=10), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=11), @DEDataQueryCodeExp(name="REMOVEFLAG", expression="t1.`REMOVEFLAG`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLOWREVERSE, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.INCFIELDS, t1.INDEXFIELDS, t1.INDEXTYPE, t1.MEMO, t1.PSDEDBINDEXID, t1.PSDEDBINDEXNAME, t1.PSDEID, t1.PSDENAME, t1.REMOVEFLAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSDEDBINDEX t1  ", querycodetemp="SELECT t1.ALLOWREVERSE, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.INCFIELDS, t1.INDEXFIELDS, t1.INDEXTYPE, t1.MEMO, t1.PSDEDBINDEXID, t1.PSDEDBINDEXNAME, t1.PSDEID, t1.PSDENAME, t1.REMOVEFLAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEDBINDEX_TMP t1  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLOWREVERSE", expression="t1.ALLOWREVERSE", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="INCFIELDS", expression="t1.INCFIELDS", showorder=4), @DEDataQueryCodeExp(name="INDEXFIELDS", expression="t1.INDEXFIELDS", showorder=5), @DEDataQueryCodeExp(name="INDEXTYPE", expression="t1.INDEXTYPE", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSDEDBINDEXID", expression="t1.PSDEDBINDEXID", showorder=8), @DEDataQueryCodeExp(name="PSDEDBINDEXNAME", expression="t1.PSDEDBINDEXNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=10), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=11), @DEDataQueryCodeExp(name="REMOVEFLAG", expression="t1.REMOVEFLAG", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=15)}, conds={})})
public class PSDEDBIndexDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDBIndexDefaultDQModel() {
        this.initAnnotation(PSDEDBIndexDefaultDQModel.class);
    }
}

