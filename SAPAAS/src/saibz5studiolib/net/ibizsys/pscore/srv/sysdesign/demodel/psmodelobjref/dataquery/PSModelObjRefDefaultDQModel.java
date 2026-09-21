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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelobjref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3163D068-E08B-4ABC-A848-2E44BDF91C6E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSMODELOBJID`, t1.`PSMODELOBJREFID`, t1.`PSMODELOBJREFNAME`, t1.`PSSYSTEMID`, t1.`REFPSMODELOBJID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSMODELOBJREF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSMODELOBJID", expression="t1.`PSMODELOBJID`", showorder=2), @DEDataQueryCodeExp(name="PSMODELOBJREFID", expression="t1.`PSMODELOBJREFID`", showorder=3), @DEDataQueryCodeExp(name="PSMODELOBJREFNAME", expression="t1.`PSMODELOBJREFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=5), @DEDataQueryCodeExp(name="REFPSMODELOBJID", expression="t1.`REFPSMODELOBJID`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=9), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSMODELOBJID, t1.PSMODELOBJREFID, t1.PSMODELOBJREFNAME, t1.PSSYSTEMID, t1.REFPSMODELOBJID, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSMODELOBJREF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSMODELOBJID", expression="t1.PSMODELOBJID", showorder=2), @DEDataQueryCodeExp(name="PSMODELOBJREFID", expression="t1.PSMODELOBJREFID", showorder=3), @DEDataQueryCodeExp(name="PSMODELOBJREFNAME", expression="t1.PSMODELOBJREFNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=5), @DEDataQueryCodeExp(name="REFPSMODELOBJID", expression="t1.REFPSMODELOBJID", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=9), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=10)}, conds={})})
public class PSModelObjRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelObjRefDefaultDQModel() {
        this.initAnnotation(PSModelObjRefDefaultDQModel.class);
    }
}

