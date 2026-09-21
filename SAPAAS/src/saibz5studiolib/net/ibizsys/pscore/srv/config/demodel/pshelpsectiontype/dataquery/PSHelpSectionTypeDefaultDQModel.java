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
package net.ibizsys.pscore.srv.config.demodel.pshelpsectiontype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F4D3F645-DAD4-49DA-A80E-428E6A54D96D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`OUTPUTDIR`, t1.`PSHELPSECTIONTEMPLID`, t11.`PSHELPSECTIONTEMPLNAME`, t1.`PSHELPSECTIONTYPEID`, t1.`PSHELPSECTIONTYPENAME`, t1.`PUBOBJ`, t1.`SECTIONOBJ`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPSECTIONTYPE` t1  LEFT JOIN T_SRFPSHELPSECTIONTEMPL t11 ON t1.PSHELPSECTIONTEMPLID = t11.PSHELPSECTIONTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="OUTPUTDIR", expression="t1.`OUTPUTDIR`", showorder=3), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLID", expression="t1.`PSHELPSECTIONTEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLNAME", expression="t11.`PSHELPSECTIONTEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.`PSHELPSECTIONTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t1.`PSHELPSECTIONTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=8), @DEDataQueryCodeExp(name="SECTIONOBJ", expression="t1.`SECTIONOBJ`", showorder=9), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OUTPUTDIR, t1.PSHELPSECTIONTEMPLID, t11.PSHELPSECTIONTEMPLNAME, t1.PSHELPSECTIONTYPEID, t1.PSHELPSECTIONTYPENAME, t1.PUBOBJ, t1.SECTIONOBJ, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPSECTIONTYPE t1  LEFT JOIN T_SRFPSHELPSECTIONTEMPL t11 ON t1.PSHELPSECTIONTEMPLID = t11.PSHELPSECTIONTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="OUTPUTDIR", expression="t1.OUTPUTDIR", showorder=3), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLID", expression="t1.PSHELPSECTIONTEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSHELPSECTIONTEMPLNAME", expression="t11.PSHELPSECTIONTEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.PSHELPSECTIONTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t1.PSHELPSECTIONTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=8), @DEDataQueryCodeExp(name="SECTIONOBJ", expression="t1.SECTIONOBJ", showorder=9), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={})})
public class PSHelpSectionTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSHelpSectionTypeDefaultDQModel() {
        this.initAnnotation(PSHelpSectionTypeDefaultDQModel.class);
    }
}

