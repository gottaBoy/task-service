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
package net.ibizsys.pscore.srv.config.demodel.pspfplugintempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6649C7D7-8916-4E61-BCC4-B8FF23D68BDD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFPLUGINID`, t11.`PSPFPLUGINNAME`, t1.`PSPFPLUGINTEMPLID`, t1.`PSPFPLUGINTEMPLNAME`, t1.`PSPFPUBCODEID`, t1.`PSPFPUBCODENAME`, t1.`TEMPLCODE2`, t1.`TEMPLCODE3`, t1.`TEMPLCODE4`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFPLUGINTEMPL` t1  LEFT JOIN T_SRFPSPFPLUGIN t11 ON t1.PSPFPLUGINID = t11.PSPFPLUGINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.`TEMPLDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.`PSPFPLUGINID`", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.`PSPFPLUGINNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINTEMPLID", expression="t1.`PSPFPLUGINTEMPLID`", showorder=7), @DEDataQueryCodeExp(name="PSPFPLUGINTEMPLNAME", expression="t1.`PSPFPLUGINTEMPLNAME`", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBCODEID", expression="t1.`PSPFPUBCODEID`", showorder=9), @DEDataQueryCodeExp(name="PSPFPUBCODENAME", expression="t1.`PSPFPUBCODENAME`", showorder=10), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=11), @DEDataQueryCodeExp(name="TEMPLCODE3", expression="t1.`TEMPLCODE3`", showorder=12), @DEDataQueryCodeExp(name="TEMPLCODE4", expression="t1.`TEMPLCODE4`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFID, t1.PSPFNAME, t1.PSPFPLUGINID, t11.PSPFPLUGINNAME, t1.PSPFPLUGINTEMPLID, t1.PSPFPLUGINTEMPLNAME, t1.PSPFPUBCODEID, t1.PSPFPUBCODENAME, t1.TEMPLCODE2, t1.TEMPLCODE3, t1.TEMPLCODE4, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFPLUGINTEMPL t1  LEFT JOIN T_SRFPSPFPLUGIN t11 ON t1.PSPFPLUGINID = t11.PSPFPLUGINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.TEMPLDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=4), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.PSPFPLUGINID", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.PSPFPLUGINNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINTEMPLID", expression="t1.PSPFPLUGINTEMPLID", showorder=7), @DEDataQueryCodeExp(name="PSPFPLUGINTEMPLNAME", expression="t1.PSPFPLUGINTEMPLNAME", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBCODEID", expression="t1.PSPFPUBCODEID", showorder=9), @DEDataQueryCodeExp(name="PSPFPUBCODENAME", expression="t1.PSPFPUBCODENAME", showorder=10), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=11), @DEDataQueryCodeExp(name="TEMPLCODE3", expression="t1.TEMPLCODE3", showorder=12), @DEDataQueryCodeExp(name="TEMPLCODE4", expression="t1.TEMPLCODE4", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSPFPluginTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPluginTemplDefaultDQModel() {
        this.initAnnotation(PSPFPluginTemplDefaultDQModel.class);
    }
}

