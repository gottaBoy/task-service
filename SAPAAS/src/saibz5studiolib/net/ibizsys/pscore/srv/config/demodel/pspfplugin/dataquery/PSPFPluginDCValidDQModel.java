/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfplugin.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6FD25B88-1A55-46CD-8F1B-3BE3C86CDF8C", name="DCValid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`KEYWORDS`, t1.`MEMO`, t1.`PLUGINTYPE`, t1.`PREVIEWPSNDFILEID`, t1.`PREVIEWURL`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSPFPLUGINID`, t1.`PSPFPLUGINNAME`, t1.`RTOBJECTMODE`, t1.`RTOBJECTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFPLUGIN` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="PLUGINDESC", expression="t1.`PLUGINDESC`", showorder=-1), @DEDataQueryCodeExp(name="RTOBJECTREPO", expression="t1.`RTOBJECTREPO`", showorder=-1), @DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="KEYWORDS", expression="t1.`KEYWORDS`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.`PLUGINTYPE`", showorder=5), @DEDataQueryCodeExp(name="PREVIEWPSNDFILEID", expression="t1.`PREVIEWPSNDFILEID`", showorder=6), @DEDataQueryCodeExp(name="PREVIEWURL", expression="t1.`PREVIEWURL`", showorder=7), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=8), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=9), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.`PSPFPLUGINID`", showorder=10), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t1.`PSPFPLUGINNAME`", showorder=11), @DEDataQueryCodeExp(name="RTOBJECTMODE", expression="t1.`RTOBJECTMODE`", showorder=12), @DEDataQueryCodeExp(name="RTOBJECTNAME", expression="t1.`RTOBJECTNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1  AND  t1.`ALLDCFLAG` = 0  AND  t1.`PSDCID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDCID\",\"dename\":\"PSPFPLUGIN\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.KEYWORDS, t1.MEMO, t1.PLUGINTYPE, t1.PREVIEWPSNDFILEID, t1.PREVIEWURL, t1.PSDCID, t1.PSDCNAME, t1.PSPFPLUGINID, t1.PSPFPLUGINNAME, t1.RTOBJECTMODE, t1.RTOBJECTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFPLUGIN t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=-1), @DEDataQueryCodeExp(name="PLUGINDESC", expression="t1.PLUGINDESC", showorder=-1), @DEDataQueryCodeExp(name="RTOBJECTREPO", expression="t1.RTOBJECTREPO", showorder=-1), @DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="KEYWORDS", expression="t1.KEYWORDS", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.PLUGINTYPE", showorder=5), @DEDataQueryCodeExp(name="PREVIEWPSNDFILEID", expression="t1.PREVIEWPSNDFILEID", showorder=6), @DEDataQueryCodeExp(name="PREVIEWURL", expression="t1.PREVIEWURL", showorder=7), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=8), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=9), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.PSPFPLUGINID", showorder=10), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t1.PSPFPLUGINNAME", showorder=11), @DEDataQueryCodeExp(name="RTOBJECTMODE", expression="t1.RTOBJECTMODE", showorder=12), @DEDataQueryCodeExp(name="RTOBJECTNAME", expression="t1.RTOBJECTNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1  AND  t1.ALLDCFLAG = 0  AND  t1.PSDCID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDCID\",\"dename\":\"PSPFPLUGIN\"}')} )")})})
public class PSPFPluginDCValidDQModel
extends DEDataQueryModelBase {
    public PSPFPluginDCValidDQModel() {
        this.initAnnotation(PSPFPluginDCValidDQModel.class);
    }
}

