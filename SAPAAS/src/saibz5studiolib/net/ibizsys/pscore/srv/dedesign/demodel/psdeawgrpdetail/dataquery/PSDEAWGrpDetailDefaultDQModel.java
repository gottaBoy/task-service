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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawgrpdetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CDD8F9F4-A787-41E4-8BB6-41173AB91AA3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEACTIONWIZARDID`, t11.`PSDEACTIONWIZARDNAME`, t1.`PSDEAWGROUPID`, t21.`PSDEAWGROUPNAME`, t1.`PSDEAWGRPDETAILID`, t1.`PSDEAWGRPDETAILNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEAWGRPDETAIL` t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  LEFT JOIN T_SRFPSDEAWGROUP t21 ON t1.PSDEAWGROUPID = t21.PSDEAWGROUPID  ", querycodetemp="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEACTIONWIZARDID`, t11.`PSDEACTIONWIZARDNAME`, t1.`PSDEAWGROUPID`, t21.`PSDEAWGROUPNAME`, t1.`PSDEAWGRPDETAILID`, t1.`PSDEAWGRPDETAILNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEAWGRPDETAIL_TMP` t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  LEFT JOIN T_SRFPSDEAWGROUP_TMP t21 ON t1.PSDEAWGROUPID = t21.PSDEAWGROUPID  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDID", expression="t1.`PSDEACTIONWIZARDID`", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDNAME", expression="t11.`PSDEACTIONWIZARDNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEAWGROUPID", expression="t1.`PSDEAWGROUPID`", showorder=6), @DEDataQueryCodeExp(name="PSDEAWGROUPNAME", expression="t21.`PSDEAWGROUPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEAWGRPDETAILID", expression="t1.`PSDEAWGRPDETAILID`", showorder=8), @DEDataQueryCodeExp(name="PSDEAWGRPDETAILNAME", expression="t1.`PSDEAWGRPDETAILNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSDEACTIONWIZARDID, t11.PSDEACTIONWIZARDNAME, t1.PSDEAWGROUPID, t21.PSDEAWGROUPNAME, t1.PSDEAWGRPDETAILID, t1.PSDEAWGRPDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEAWGRPDETAIL t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  LEFT JOIN T_SRFPSDEAWGROUP t21 ON t1.PSDEAWGROUPID = t21.PSDEAWGROUPID  ", querycodetemp="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSDEACTIONWIZARDID, t11.PSDEACTIONWIZARDNAME, t1.PSDEAWGROUPID, t21.PSDEAWGROUPNAME, t1.PSDEAWGRPDETAILID, t1.PSDEAWGRPDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEAWGRPDETAIL_TMP t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  LEFT JOIN T_SRFPSDEAWGROUP_TMP t21 ON t1.PSDEAWGROUPID = t21.PSDEAWGROUPID  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDID", expression="t1.PSDEACTIONWIZARDID", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDNAME", expression="t11.PSDEACTIONWIZARDNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEAWGROUPID", expression="t1.PSDEAWGROUPID", showorder=6), @DEDataQueryCodeExp(name="PSDEAWGROUPNAME", expression="t21.PSDEAWGROUPNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEAWGRPDETAILID", expression="t1.PSDEAWGRPDETAILID", showorder=8), @DEDataQueryCodeExp(name="PSDEAWGRPDETAILNAME", expression="t1.PSDEAWGRPDETAILNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSDEAWGrpDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEAWGrpDetailDefaultDQModel() {
        this.initAnnotation(PSDEAWGrpDetailDefaultDQModel.class);
    }
}

