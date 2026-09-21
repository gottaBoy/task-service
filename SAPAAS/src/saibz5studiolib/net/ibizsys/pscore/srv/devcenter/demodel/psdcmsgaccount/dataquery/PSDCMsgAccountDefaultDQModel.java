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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsgaccount.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E3EA9781-15C4-4A11-A924-23A52FB07599", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDCMSGACCOUNTID`, t1.`PSDCMSGACCOUNTNAME`, t1.`PSDCORGUSERID`, t1.`PSDCORGUSERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCMSGACCOUNT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDCMSGACCOUNTID", expression="t1.`PSDCMSGACCOUNTID`", showorder=2), @DEDataQueryCodeExp(name="PSDCMSGACCOUNTNAME", expression="t1.`PSDCMSGACCOUNTNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDCORGUSERID", expression="t1.`PSDCORGUSERID`", showorder=4), @DEDataQueryCodeExp(name="PSDCORGUSERNAME", expression="t1.`PSDCORGUSERNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDCMSGACCOUNTID, t1.PSDCMSGACCOUNTNAME, t1.PSDCORGUSERID, t1.PSDCORGUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCMSGACCOUNT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDCMSGACCOUNTID", expression="t1.PSDCMSGACCOUNTID", showorder=2), @DEDataQueryCodeExp(name="PSDCMSGACCOUNTNAME", expression="t1.PSDCMSGACCOUNTNAME", showorder=3), @DEDataQueryCodeExp(name="PSDCORGUSERID", expression="t1.PSDCORGUSERID", showorder=4), @DEDataQueryCodeExp(name="PSDCORGUSERNAME", expression="t1.PSDCORGUSERNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=8)}, conds={})})
public class PSDCMsgAccountDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCMsgAccountDefaultDQModel() {
        this.initAnnotation(PSDCMsgAccountDefaultDQModel.class);
    }
}

