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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawgroup.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FC7E0340-8937-4EB5-9AF3-1E51B9AE80C4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOCKFLAG`, t1.`MEMO`, t1.`PSDEAWGROUPID`, t1.`PSDEAWGROUPNAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSDEAWGROUP` t1  ", querycodetemp="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOCKFLAG`, t1.`MEMO`, t1.`PSDEAWGROUPID`, t1.`PSDEAWGROUPNAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEAWGROUP_TMP` t1  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.`LOCKFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEAWGROUPID", expression="t1.`PSDEAWGROUPID`", showorder=5), @DEDataQueryCodeExp(name="PSDEAWGROUPNAME", expression="t1.`PSDEAWGROUPNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.LOCKFLAG, t1.MEMO, t1.PSDEAWGROUPID, t1.PSDEAWGROUPNAME, t1.PSDEID, t1.PSDENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSDEAWGROUP t1  ", querycodetemp="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.LOCKFLAG, t1.MEMO, t1.PSDEAWGROUPID, t1.PSDEAWGROUPNAME, t1.PSDEID, t1.PSDENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEAWGROUP_TMP t1  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.LOCKFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEAWGROUPID", expression="t1.PSDEAWGROUPID", showorder=5), @DEDataQueryCodeExp(name="PSDEAWGROUPNAME", expression="t1.PSDEAWGROUPNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=12)}, conds={})})
public class PSDEAWGroupDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEAWGroupDefaultDQModel() {
        this.initAnnotation(PSDEAWGroupDefaultDQModel.class);
    }
}

