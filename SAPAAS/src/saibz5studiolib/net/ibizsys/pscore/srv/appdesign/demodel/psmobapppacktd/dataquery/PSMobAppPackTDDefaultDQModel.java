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
package net.ibizsys.pscore.srv.appdesign.demodel.psmobapppacktd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3E9D0969-873B-4BE8-BD0F-D57BFA898ED2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCMOBAPPTESTDEVICEID`, t1.`PSDCMOBAPPTESTDEVICENAME`, t1.`PSDCMOBPACKCERTID`, t11.`PSDCMOBPACKCERTNAME`, t1.`PSMOBAPPPACKID`, t1.`PSMOBAPPPACKNAME`, t1.`PSMOBAPPPACKTDID`, t1.`PSMOBAPPPACKTDNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMOBAPPPACKTD` t1  LEFT JOIN T_SRFPSDCMOBPACKCERT t11 ON t1.PSDCMOBPACKCERTID = t11.PSDCMOBPACKCERTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.`PSDCMOBAPPTESTDEVICEID`", showorder=4), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.`PSDCMOBAPPTESTDEVICENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBPACKCERTID", expression="t1.`PSDCMOBPACKCERTID`", showorder=6), @DEDataQueryCodeExp(name="PSDCMOBPACKCERTNAME", expression="t11.`PSDCMOBPACKCERTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMOBAPPPACKID", expression="t1.`PSMOBAPPPACKID`", showorder=8), @DEDataQueryCodeExp(name="PSMOBAPPPACKNAME", expression="t1.`PSMOBAPPPACKNAME`", showorder=9), @DEDataQueryCodeExp(name="PSMOBAPPPACKTDID", expression="t1.`PSMOBAPPPACKTDID`", showorder=10), @DEDataQueryCodeExp(name="PSMOBAPPPACKTDNAME", expression="t1.`PSMOBAPPPACKTDNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCMOBAPPTESTDEVICEID, t1.PSDCMOBAPPTESTDEVICENAME, t1.PSDCMOBPACKCERTID, t11.PSDCMOBPACKCERTNAME, t1.PSMOBAPPPACKID, t1.PSMOBAPPPACKNAME, t1.PSMOBAPPPACKTDID, t1.PSMOBAPPPACKTDNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMOBAPPPACKTD t1  LEFT JOIN T_SRFPSDCMOBPACKCERT t11 ON t1.PSDCMOBPACKCERTID = t11.PSDCMOBPACKCERTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.PSDCMOBAPPTESTDEVICEID", showorder=4), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.PSDCMOBAPPTESTDEVICENAME", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBPACKCERTID", expression="t1.PSDCMOBPACKCERTID", showorder=6), @DEDataQueryCodeExp(name="PSDCMOBPACKCERTNAME", expression="t11.PSDCMOBPACKCERTNAME", showorder=7), @DEDataQueryCodeExp(name="PSMOBAPPPACKID", expression="t1.PSMOBAPPPACKID", showorder=8), @DEDataQueryCodeExp(name="PSMOBAPPPACKNAME", expression="t1.PSMOBAPPPACKNAME", showorder=9), @DEDataQueryCodeExp(name="PSMOBAPPPACKTDID", expression="t1.PSMOBAPPPACKTDID", showorder=10), @DEDataQueryCodeExp(name="PSMOBAPPPACKTDNAME", expression="t1.PSMOBAPPPACKTDNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSMobAppPackTDDefaultDQModel
extends DEDataQueryModelBase {
    public PSMobAppPackTDDefaultDQModel() {
        this.initAnnotation(PSMobAppPackTDDefaultDQModel.class);
    }
}

