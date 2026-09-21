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
package net.ibizsys.pscore.srv.config.demodel.psportlet.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="1F82A06E-66BE-45C2-B936-028DB9067B03", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BASECLSPARAMS`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PORTLETTYPE`, t1.`PSPFPLUGINID`, t11.`PSPFPLUGINNAME`, t1.`PSPORTLETID`, t1.`PSPORTLETNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPORTLET` t1  LEFT JOIN `T_SRFPSPFPLUGIN` t11 ON t1.`PSPFPLUGINID` = t11.`PSPFPLUGINID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PORTLETTYPE", expression="t1.`PORTLETTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.`PSPFPLUGINID`", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.`PSPFPLUGINNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPORTLETID", expression="t1.`PSPORTLETID`", showorder=8), @DEDataQueryCodeExp(name="PSPORTLETNAME", expression="t1.`PSPORTLETNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BASECLSPARAMS, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PORTLETTYPE, t1.PSPFPLUGINID, t11.PSPFPLUGINNAME, t1.PSPORTLETID, t1.PSPORTLETNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPORTLET t1  LEFT JOIN T_SRFPSPFPLUGIN t11 ON t1.PSPFPLUGINID = t11.PSPFPLUGINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PORTLETTYPE", expression="t1.PORTLETTYPE", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.PSPFPLUGINID", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.PSPFPLUGINNAME", showorder=7), @DEDataQueryCodeExp(name="PSPORTLETID", expression="t1.PSPORTLETID", showorder=8), @DEDataQueryCodeExp(name="PSPORTLETNAME", expression="t1.PSPORTLETNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSPortletDefaultDQModel
extends DEDataQueryModelBase {
    public PSPortletDefaultDQModel() {
        this.initAnnotation(PSPortletDefaultDQModel.class);
    }
}

