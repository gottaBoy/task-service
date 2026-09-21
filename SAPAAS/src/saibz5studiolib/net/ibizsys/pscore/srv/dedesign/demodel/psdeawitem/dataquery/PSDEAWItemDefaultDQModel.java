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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0F922400-C0C9-4893-98A7-E8CF61B97A0A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACTIONVALUE`, t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MOREURL`, t1.`ORDERVALUE`, t1.`PSDEACTIONWIZARDID`, t11.`PSDEACTIONWIZARDNAME`, t1.`PSDEAWITEMID`, t1.`PSDEAWITEMNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEAWITEM` t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  ", querycodetemp="SELECT t1.`ACTIONVALUE`, t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MOREURL`, t1.`ORDERVALUE`, t1.`PSDEACTIONWIZARDID`, t11.`PSDEACTIONWIZARDNAME`, t1.`PSDEAWITEMID`, t1.`PSDEAWITEMNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEAWITEM_TMP` t1  LEFT JOIN T_SRFPSDEACTIONWIZARD_TMP t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIONVALUE", expression="t1.`ACTIONVALUE`", showorder=0), @DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MOREURL", expression="t1.`MOREURL`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDID", expression="t1.`PSDEACTIONWIZARDID`", showorder=7), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDNAME", expression="t11.`PSDEACTIONWIZARDNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEAWITEMID", expression="t1.`PSDEAWITEMID`", showorder=9), @DEDataQueryCodeExp(name="PSDEAWITEMNAME", expression="t1.`PSDEAWITEMNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=11), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACTIONVALUE, t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MOREURL, t1.ORDERVALUE, t1.PSDEACTIONWIZARDID, t11.PSDEACTIONWIZARDNAME, t1.PSDEAWITEMID, t1.PSDEAWITEMNAME, t1.PSDEFID, t1.PSDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEAWITEM t1  LEFT JOIN T_SRFPSDEACTIONWIZARD t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  ", querycodetemp="SELECT t1.ACTIONVALUE, t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MOREURL, t1.ORDERVALUE, t1.PSDEACTIONWIZARDID, t11.PSDEACTIONWIZARDNAME, t1.PSDEAWITEMID, t1.PSDEAWITEMNAME, t1.PSDEFID, t1.PSDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEAWITEM_TMP t1  LEFT JOIN T_SRFPSDEACTIONWIZARD_TMP t11 ON t1.PSDEACTIONWIZARDID = t11.PSDEACTIONWIZARDID  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIONVALUE", expression="t1.ACTIONVALUE", showorder=0), @DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MOREURL", expression="t1.MOREURL", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDID", expression="t1.PSDEACTIONWIZARDID", showorder=7), @DEDataQueryCodeExp(name="PSDEACTIONWIZARDNAME", expression="t11.PSDEACTIONWIZARDNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEAWITEMID", expression="t1.PSDEAWITEMID", showorder=9), @DEDataQueryCodeExp(name="PSDEAWITEMNAME", expression="t1.PSDEAWITEMNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=11), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDEAWItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEAWItemDefaultDQModel() {
        this.initAnnotation(PSDEAWItemDefaultDQModel.class);
    }
}

