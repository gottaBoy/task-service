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
package net.ibizsys.pscore.srv.config.demodel.psmidetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="683C7E9A-09F0-4A9A-8028-99B58CA29938", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INITMODE`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDENAME`, t1.`PSMIDETAILID`, t1.`PSMIDETAILNAME`, t1.`PSMODELINITID`, t11.`PSMODELINITNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMIDETAIL` t1  LEFT JOIN T_SRFPSMODELINIT t11 ON t1.PSMODELINITID = t11.PSMODELINITID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INITMODE", expression="t1.`INITMODE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=5), @DEDataQueryCodeExp(name="PSMIDETAILID", expression="t1.`PSMIDETAILID`", showorder=6), @DEDataQueryCodeExp(name="PSMIDETAILNAME", expression="t1.`PSMIDETAILNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELINITID", expression="t1.`PSMODELINITID`", showorder=8), @DEDataQueryCodeExp(name="PSMODELINITNAME", expression="t11.`PSMODELINITNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INITMODE, t1.MEMO, t1.ORDERVALUE, t1.PSDENAME, t1.PSMIDETAILID, t1.PSMIDETAILNAME, t1.PSMODELINITID, t11.PSMODELINITNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMIDETAIL t1  LEFT JOIN T_SRFPSMODELINIT t11 ON t1.PSMODELINITID = t11.PSMODELINITID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INITMODE", expression="t1.INITMODE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=5), @DEDataQueryCodeExp(name="PSMIDETAILID", expression="t1.PSMIDETAILID", showorder=6), @DEDataQueryCodeExp(name="PSMIDETAILNAME", expression="t1.PSMIDETAILNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELINITID", expression="t1.PSMODELINITID", showorder=8), @DEDataQueryCodeExp(name="PSMODELINITNAME", expression="t11.PSMODELINITNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSMIDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSMIDetailDefaultDQModel() {
        this.initAnnotation(PSMIDetailDefaultDQModel.class);
    }
}

