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
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcappentity.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="87BB87CC-6A17-4499-9B46-0E6AC9BDDC39", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSWPAPPENTITYID`, t21.`PSWPAPPENTITYNAME`, t1.`PSWPDCAPPENTITYID`, t1.`PSWPDCAPPENTITYNAME`, t1.`PSWPDCAPPINSTID`, t31.`PSWPDCAPPINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWPDCAPPENTITY` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSWPAPPENTITY t21 ON t1.PSWPAPPENTITYID = t21.PSWPAPPENTITYID  LEFT JOIN T_SRFPSWPDCAPPINST t31 ON t1.PSWPDCAPPINSTID = t31.PSWPDCAPPINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSWPAPPENTITYID", expression="t1.`PSWPAPPENTITYID`", showorder=4), @DEDataQueryCodeExp(name="PSWPAPPENTITYNAME", expression="t21.`PSWPAPPENTITYNAME`", showorder=5), @DEDataQueryCodeExp(name="PSWPDCAPPENTITYID", expression="t1.`PSWPDCAPPENTITYID`", showorder=6), @DEDataQueryCodeExp(name="PSWPDCAPPENTITYNAME", expression="t1.`PSWPDCAPPENTITYNAME`", showorder=7), @DEDataQueryCodeExp(name="PSWPDCAPPINSTID", expression="t1.`PSWPDCAPPINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSWPDCAPPINSTNAME", expression="t31.`PSWPDCAPPINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSWPAPPENTITYID, t21.PSWPAPPENTITYNAME, t1.PSWPDCAPPENTITYID, t1.PSWPDCAPPENTITYNAME, t1.PSWPDCAPPINSTID, t31.PSWPDCAPPINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWPDCAPPENTITY t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSWPAPPENTITY t21 ON t1.PSWPAPPENTITYID = t21.PSWPAPPENTITYID  LEFT JOIN T_SRFPSWPDCAPPINST t31 ON t1.PSWPDCAPPINSTID = t31.PSWPDCAPPINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=3), @DEDataQueryCodeExp(name="PSWPAPPENTITYID", expression="t1.PSWPAPPENTITYID", showorder=4), @DEDataQueryCodeExp(name="PSWPAPPENTITYNAME", expression="t21.PSWPAPPENTITYNAME", showorder=5), @DEDataQueryCodeExp(name="PSWPDCAPPENTITYID", expression="t1.PSWPDCAPPENTITYID", showorder=6), @DEDataQueryCodeExp(name="PSWPDCAPPENTITYNAME", expression="t1.PSWPDCAPPENTITYNAME", showorder=7), @DEDataQueryCodeExp(name="PSWPDCAPPINSTID", expression="t1.PSWPDCAPPINSTID", showorder=8), @DEDataQueryCodeExp(name="PSWPDCAPPINSTNAME", expression="t31.PSWPDCAPPINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSWPDCAppEntityDefaultDQModel
extends DEDataQueryModelBase {
    public PSWPDCAppEntityDefaultDQModel() {
        this.initAnnotation(PSWPDCAppEntityDefaultDQModel.class);
    }
}

