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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmobapptdref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CD17BCBA-75C3-4FE3-8467-FD90A040AB06", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCMOBAPPTDREFID`, t1.`PSDCMOBAPPTDREFNAME`, t1.`PSDCMOBAPPTESTDEVICEID`, t1.`PSDCMOBAPPTESTDEVICENAME`, t1.`REFPSOBJID`, t1.`REFPSOBJNAME`, t1.`REFPSOBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCMOBAPPTDREF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCMOBAPPTDREFID", expression="t1.`PSDCMOBAPPTDREFID`", showorder=3), @DEDataQueryCodeExp(name="PSDCMOBAPPTDREFNAME", expression="t1.`PSDCMOBAPPTDREFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.`PSDCMOBAPPTESTDEVICEID`", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.`PSDCMOBAPPTESTDEVICENAME`", showorder=6), @DEDataQueryCodeExp(name="REFPSOBJID", expression="t1.`REFPSOBJID`", showorder=7), @DEDataQueryCodeExp(name="REFPSOBJNAME", expression="t1.`REFPSOBJNAME`", showorder=8), @DEDataQueryCodeExp(name="REFPSOBJTYPE", expression="t1.`REFPSOBJTYPE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCMOBAPPTDREFID, t1.PSDCMOBAPPTDREFNAME, t1.PSDCMOBAPPTESTDEVICEID, t1.PSDCMOBAPPTESTDEVICENAME, t1.REFPSOBJID, t1.REFPSOBJNAME, t1.REFPSOBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCMOBAPPTDREF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCMOBAPPTDREFID", expression="t1.PSDCMOBAPPTDREFID", showorder=3), @DEDataQueryCodeExp(name="PSDCMOBAPPTDREFNAME", expression="t1.PSDCMOBAPPTDREFNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.PSDCMOBAPPTESTDEVICEID", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.PSDCMOBAPPTESTDEVICENAME", showorder=6), @DEDataQueryCodeExp(name="REFPSOBJID", expression="t1.REFPSOBJID", showorder=7), @DEDataQueryCodeExp(name="REFPSOBJNAME", expression="t1.REFPSOBJNAME", showorder=8), @DEDataQueryCodeExp(name="REFPSOBJTYPE", expression="t1.REFPSOBJTYPE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDCMobAppTDRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCMobAppTDRefDefaultDQModel() {
        this.initAnnotation(PSDCMobAppTDRefDefaultDQModel.class);
    }
}

