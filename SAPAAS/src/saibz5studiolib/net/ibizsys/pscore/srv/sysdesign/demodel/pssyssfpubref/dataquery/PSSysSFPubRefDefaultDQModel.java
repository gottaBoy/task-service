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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfpubref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E816B0A8-D2FF-4345-A910-BDC82B0E4930", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSSYSSFPUBID`, t11.`PSSYSSFPUBNAME`, t1.`PSSYSSFPUBREFID`, t1.`PSSYSSFPUBREFNAME`, t1.`REFPSSYSSFPUBID`, t21.`PSSYSSFPUBNAME` AS `REFPSSYSSFPUBNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSSFPUBREF` t1  LEFT JOIN T_SRFPSSYSSFPUB t11 ON t1.PSSYSSFPUBID = t11.PSSYSSFPUBID  LEFT JOIN T_SRFPSSYSSFPUB t21 ON t1.REFPSSYSSFPUBID = t21.PSSYSSFPUBID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.`PSSYSSFPUBID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t11.`PSSYSSFPUBNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSSFPUBREFID", expression="t1.`PSSYSSFPUBREFID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSSFPUBREFNAME", expression="t1.`PSSYSSFPUBREFNAME`", showorder=7), @DEDataQueryCodeExp(name="REFPSSYSSFPUBID", expression="t1.`REFPSSYSSFPUBID`", showorder=8), @DEDataQueryCodeExp(name="REFPSSYSSFPUBNAME", expression="t21.`PSSYSSFPUBNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSSYSSFPUBID, t11.PSSYSSFPUBNAME, t1.PSSYSSFPUBREFID, t1.PSSYSSFPUBREFNAME, t1.REFPSSYSSFPUBID, t21.PSSYSSFPUBNAME AS REFPSSYSSFPUBNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSSFPUBREF t1  LEFT JOIN T_SRFPSSYSSFPUB t11 ON t1.PSSYSSFPUBID = t11.PSSYSSFPUBID  LEFT JOIN T_SRFPSSYSSFPUB t21 ON t1.REFPSSYSSFPUBID = t21.PSSYSSFPUBID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.PSSYSSFPUBID", showorder=4), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t11.PSSYSSFPUBNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSSFPUBREFID", expression="t1.PSSYSSFPUBREFID", showorder=6), @DEDataQueryCodeExp(name="PSSYSSFPUBREFNAME", expression="t1.PSSYSSFPUBREFNAME", showorder=7), @DEDataQueryCodeExp(name="REFPSSYSSFPUBID", expression="t1.REFPSSYSSFPUBID", showorder=8), @DEDataQueryCodeExp(name="REFPSSYSSFPUBNAME", expression="t21.PSSYSSFPUBNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSSysSFPubRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysSFPubRefDefaultDQModel() {
        this.initAnnotation(PSSysSFPubRefDefaultDQModel.class);
    }
}

