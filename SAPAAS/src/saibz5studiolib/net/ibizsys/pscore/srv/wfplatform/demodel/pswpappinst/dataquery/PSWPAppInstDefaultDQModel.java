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
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpappinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F2A6133E-F521-42A0-9326-95E04D8F5D27", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSWPAPPID`, t1.`PSWPAPPINSTID`, t1.`PSWPAPPINSTNAME`, t11.`PSWPAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWPAPPINST` t1  LEFT JOIN T_SRFPSWPAPP t11 ON t1.PSWPAPPID = t11.PSWPAPPID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSWPAPPID", expression="t1.`PSWPAPPID`", showorder=2), @DEDataQueryCodeExp(name="PSWPAPPINSTID", expression="t1.`PSWPAPPINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSWPAPPINSTNAME", expression="t1.`PSWPAPPINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSWPAPPNAME", expression="t11.`PSWPAPPNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSWPAPPID, t1.PSWPAPPINSTID, t1.PSWPAPPINSTNAME, t11.PSWPAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWPAPPINST t1  LEFT JOIN T_SRFPSWPAPP t11 ON t1.PSWPAPPID = t11.PSWPAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSWPAPPID", expression="t1.PSWPAPPID", showorder=2), @DEDataQueryCodeExp(name="PSWPAPPINSTID", expression="t1.PSWPAPPINSTID", showorder=3), @DEDataQueryCodeExp(name="PSWPAPPINSTNAME", expression="t1.PSWPAPPINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSWPAPPNAME", expression="t11.PSWPAPPNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSWPAppInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSWPAppInstDefaultDQModel() {
        this.initAnnotation(PSWPAppInstDefaultDQModel.class);
    }
}

