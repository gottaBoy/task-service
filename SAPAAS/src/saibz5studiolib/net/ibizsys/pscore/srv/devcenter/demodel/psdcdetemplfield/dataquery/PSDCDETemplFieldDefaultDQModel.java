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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdetemplfield.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="45080DA2-6F7E-4127-BB37-4CFCA2749558", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLOWEMPTY`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFTYPE`, t1.`LENGTH`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PRECISION2`, t1.`PREDEFINETYPE`, t1.`PSDATATYPEID`, t1.`PSDATATYPENAME`, t1.`PSDCDETEMPLFIELDID`, t1.`PSDCDETEMPLFIELDNAME`, t1.`PSDCDETEMPLID`, t1.`PSDCDETEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCDETEMPLFIELD` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.`ALLOWEMPTY`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="DEFTYPE", expression="t1.`DEFTYPE`", showorder=4), @DEDataQueryCodeExp(name="LENGTH", expression="t1.`LENGTH`", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.`PRECISION2`", showorder=8), @DEDataQueryCodeExp(name="PREDEFINETYPE", expression="t1.`PREDEFINETYPE`", showorder=9), @DEDataQueryCodeExp(name="PSDATATYPEID", expression="t1.`PSDATATYPEID`", showorder=10), @DEDataQueryCodeExp(name="PSDATATYPENAME", expression="t1.`PSDATATYPENAME`", showorder=11), @DEDataQueryCodeExp(name="PSDCDETEMPLFIELDID", expression="t1.`PSDCDETEMPLFIELDID`", showorder=12), @DEDataQueryCodeExp(name="PSDCDETEMPLFIELDNAME", expression="t1.`PSDCDETEMPLFIELDNAME`", showorder=13), @DEDataQueryCodeExp(name="PSDCDETEMPLID", expression="t1.`PSDCDETEMPLID`", showorder=14), @DEDataQueryCodeExp(name="PSDCDETEMPLNAME", expression="t1.`PSDCDETEMPLNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLOWEMPTY, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DEFTYPE, t1.LENGTH, t1.LOGICNAME, t1.MEMO, t1.PRECISION2, t1.PREDEFINETYPE, t1.PSDATATYPEID, t1.PSDATATYPENAME, t1.PSDCDETEMPLFIELDID, t1.PSDCDETEMPLFIELDNAME, t1.PSDCDETEMPLID, t1.PSDCDETEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCDETEMPLFIELD t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.ALLOWEMPTY", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="DEFTYPE", expression="t1.DEFTYPE", showorder=4), @DEDataQueryCodeExp(name="LENGTH", expression="t1.LENGTH", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.PRECISION2", showorder=8), @DEDataQueryCodeExp(name="PREDEFINETYPE", expression="t1.PREDEFINETYPE", showorder=9), @DEDataQueryCodeExp(name="PSDATATYPEID", expression="t1.PSDATATYPEID", showorder=10), @DEDataQueryCodeExp(name="PSDATATYPENAME", expression="t1.PSDATATYPENAME", showorder=11), @DEDataQueryCodeExp(name="PSDCDETEMPLFIELDID", expression="t1.PSDCDETEMPLFIELDID", showorder=12), @DEDataQueryCodeExp(name="PSDCDETEMPLFIELDNAME", expression="t1.PSDCDETEMPLFIELDNAME", showorder=13), @DEDataQueryCodeExp(name="PSDCDETEMPLID", expression="t1.PSDCDETEMPLID", showorder=14), @DEDataQueryCodeExp(name="PSDCDETEMPLNAME", expression="t1.PSDCDETEMPLNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSDCDETemplFieldDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCDETemplFieldDefaultDQModel() {
        this.initAnnotation(PSDCDETemplFieldDefaultDQModel.class);
    }
}

