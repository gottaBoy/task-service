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
package net.ibizsys.pscore.srv.config.demodel.pshelpsectiontempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F0BF4186-F44C-4975-B16E-38E330AB51B7", name="Global")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSHELPSECTIONTEMPLID`, t1.`PSHELPSECTIONTEMPLNAME`, t1.`PSHELPSECTIONTYPEID`, t11.`PSHELPSECTIONTYPENAME`, t1.`PUBMODE`, t1.`PUBOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPSECTIONTEMPL` t1  LEFT JOIN T_SRFPSHELPSECTIONTYPE t11 ON t1.PSHELPSECTIONTYPEID = t11.PSHELPSECTIONTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLID", expression="t1.`PSHELPSECTIONTEMPLID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLNAME", expression="t1.`PSHELPSECTIONTEMPLNAME`", showorder=7), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.`PSHELPSECTIONTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t11.`PSHELPSECTIONTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="PUBMODE", expression="t1.`PUBMODE`", showorder=10), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`PUBMODE` = 1  AND  t1.`PSDEVCENTERID` IS NULL )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSHELPSECTIONTEMPLID, t1.PSHELPSECTIONTEMPLNAME, t1.PSHELPSECTIONTYPEID, t11.PSHELPSECTIONTYPENAME, t1.PUBMODE, t1.PUBOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPSECTIONTEMPL t1  LEFT JOIN T_SRFPSHELPSECTIONTYPE t11 ON t1.PSHELPSECTIONTYPEID = t11.PSHELPSECTIONTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLID", expression="t1.PSHELPSECTIONTEMPLID", showorder=6), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLNAME", expression="t1.PSHELPSECTIONTEMPLNAME", showorder=7), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.PSHELPSECTIONTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t11.PSHELPSECTIONTYPENAME", showorder=9), @DEDataQueryCodeExp(name="PUBMODE", expression="t1.PUBMODE", showorder=10), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.PUBMODE = 1  AND  t1.PSDEVCENTERID IS NULL )")})})
public class PSHelpSectionTemplGlobalDQModel
extends DEDataQueryModelBase {
    public PSHelpSectionTemplGlobalDQModel() {
        this.initAnnotation(PSHelpSectionTemplGlobalDQModel.class);
    }
}

