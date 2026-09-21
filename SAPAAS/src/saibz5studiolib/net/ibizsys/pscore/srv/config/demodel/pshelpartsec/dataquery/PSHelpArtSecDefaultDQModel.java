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
package net.ibizsys.pscore.srv.config.demodel.pshelpartsec.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6A5C2A36-DE79-4B3E-B562-457904A96E43", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSHELPARTICLETYPEID`, t11.`PSHELPARTICLETYPENAME`, t1.`PSHELPARTSECID`, t1.`PSHELPARTSECNAME`, t1.`PSHELPSECTIONTYPEID`, t21.`PSHELPSECTIONTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPARTSEC` t1  LEFT JOIN T_SRFPSHELPARTICLETYPE t11 ON t1.PSHELPARTICLETYPEID = t11.PSHELPARTICLETYPEID  LEFT JOIN T_SRFPSHELPSECTIONTYPE t21 ON t1.PSHELPSECTIONTYPEID = t21.PSHELPSECTIONTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSHELPARTICLETYPEID", expression="t1.`PSHELPARTICLETYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSHELPARTICLETYPENAME", expression="t11.`PSHELPARTICLETYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPARTSECID", expression="t1.`PSHELPARTSECID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTSECNAME", expression="t1.`PSHELPARTSECNAME`", showorder=7), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.`PSHELPSECTIONTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t21.`PSHELPSECTIONTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSHELPARTICLETYPEID, t11.PSHELPARTICLETYPENAME, t1.PSHELPARTSECID, t1.PSHELPARTSECNAME, t1.PSHELPSECTIONTYPEID, t21.PSHELPSECTIONTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPARTSEC t1  LEFT JOIN T_SRFPSHELPARTICLETYPE t11 ON t1.PSHELPARTICLETYPEID = t11.PSHELPARTICLETYPEID  LEFT JOIN T_SRFPSHELPSECTIONTYPE t21 ON t1.PSHELPSECTIONTYPEID = t21.PSHELPSECTIONTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSHELPARTICLETYPEID", expression="t1.PSHELPARTICLETYPEID", showorder=4), @DEDataQueryCodeExp(name="PSHELPARTICLETYPENAME", expression="t11.PSHELPARTICLETYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPARTSECID", expression="t1.PSHELPARTSECID", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTSECNAME", expression="t1.PSHELPARTSECNAME", showorder=7), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPEID", expression="t1.PSHELPSECTIONTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSHELPSECTIONTYPENAME", expression="t21.PSHELPSECTIONTYPENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSHelpArtSecDefaultDQModel
extends DEDataQueryModelBase {
    public PSHelpArtSecDefaultDQModel() {
        this.initAnnotation(PSHelpArtSecDefaultDQModel.class);
    }
}

