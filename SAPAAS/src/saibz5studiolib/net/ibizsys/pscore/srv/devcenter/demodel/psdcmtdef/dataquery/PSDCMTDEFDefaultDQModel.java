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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmtdef.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FE049A62-F019-4890-9232-9EA2CAE6A7E8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLOWEMPTY`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFDATATYPE`, t1.`LENGTH`, t1.`LOGICNAME`, t1.`MAJORFIELD`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PKEY`, t1.`PRECISION2`, t1.`PREDEFINEDTYPE`, t1.`PSDCMODELTEMPLID`, t1.`PSDCMODELTEMPLNAME`, t1.`PSDCMTDEFID`, t1.`PSDCMTDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCMTDEF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.`ALLOWEMPTY`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="DEFDATATYPE", expression="t1.`DEFDATATYPE`", showorder=4), @DEDataQueryCodeExp(name="LENGTH", expression="t1.`LENGTH`", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=6), @DEDataQueryCodeExp(name="MAJORFIELD", expression="t1.`MAJORFIELD`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=9), @DEDataQueryCodeExp(name="PKEY", expression="t1.`PKEY`", showorder=10), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.`PRECISION2`", showorder=11), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.`PREDEFINEDTYPE`", showorder=12), @DEDataQueryCodeExp(name="PSDCMODELTEMPLID", expression="t1.`PSDCMODELTEMPLID`", showorder=13), @DEDataQueryCodeExp(name="PSDCMODELTEMPLNAME", expression="t1.`PSDCMODELTEMPLNAME`", showorder=14), @DEDataQueryCodeExp(name="PSDCMTDEFID", expression="t1.`PSDCMTDEFID`", showorder=15), @DEDataQueryCodeExp(name="PSDCMTDEFNAME", expression="t1.`PSDCMTDEFNAME`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLOWEMPTY, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DEFDATATYPE, t1.LENGTH, t1.LOGICNAME, t1.MAJORFIELD, t1.MEMO, t1.ORDERVALUE, t1.PKEY, t1.PRECISION2, t1.PREDEFINEDTYPE, t1.PSDCMODELTEMPLID, t1.PSDCMODELTEMPLNAME, t1.PSDCMTDEFID, t1.PSDCMTDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCMTDEF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.ALLOWEMPTY", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="DEFDATATYPE", expression="t1.DEFDATATYPE", showorder=4), @DEDataQueryCodeExp(name="LENGTH", expression="t1.LENGTH", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=6), @DEDataQueryCodeExp(name="MAJORFIELD", expression="t1.MAJORFIELD", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=9), @DEDataQueryCodeExp(name="PKEY", expression="t1.PKEY", showorder=10), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.PRECISION2", showorder=11), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.PREDEFINEDTYPE", showorder=12), @DEDataQueryCodeExp(name="PSDCMODELTEMPLID", expression="t1.PSDCMODELTEMPLID", showorder=13), @DEDataQueryCodeExp(name="PSDCMODELTEMPLNAME", expression="t1.PSDCMODELTEMPLNAME", showorder=14), @DEDataQueryCodeExp(name="PSDCMTDEFID", expression="t1.PSDCMTDEFID", showorder=15), @DEDataQueryCodeExp(name="PSDCMTDEFNAME", expression="t1.PSDCMTDEFNAME", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18)}, conds={})})
public class PSDCMTDEFDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCMTDEFDefaultDQModel() {
        this.initAnnotation(PSDCMTDEFDefaultDQModel.class);
    }
}

