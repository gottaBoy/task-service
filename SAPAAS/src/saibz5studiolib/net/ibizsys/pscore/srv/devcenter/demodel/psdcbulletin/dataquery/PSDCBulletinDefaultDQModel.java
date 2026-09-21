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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbulletin.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C56339DE-CE05-4ED5-84CF-C2BD78A3B8B9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`AUTHOR`, t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`MEMO`, t1.`PSDCBULLETINID`, t1.`PSDCBULLETINNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PUBFLAG`, t1.`PUBTIME`, t1.`TARGETTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCBULLETIN` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="AUTHOR", expression="t1.`AUTHOR`", showorder=0), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDCBULLETINID", expression="t1.`PSDCBULLETINID`", showorder=6), @DEDataQueryCodeExp(name="PSDCBULLETINNAME", expression="t1.`PSDCBULLETINNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="PUBFLAG", expression="t1.`PUBFLAG`", showorder=10), @DEDataQueryCodeExp(name="PUBTIME", expression="t1.`PUBTIME`", showorder=11), @DEDataQueryCodeExp(name="TARGETTYPE", expression="t1.`TARGETTYPE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.AUTHOR, t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MEMO, t1.PSDCBULLETINID, t1.PSDCBULLETINNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PUBFLAG, t1.PUBTIME, t1.TARGETTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCBULLETIN t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="AUTHOR", expression="t1.AUTHOR", showorder=0), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDCBULLETINID", expression="t1.PSDCBULLETINID", showorder=6), @DEDataQueryCodeExp(name="PSDCBULLETINNAME", expression="t1.PSDCBULLETINNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="PUBFLAG", expression="t1.PUBFLAG", showorder=10), @DEDataQueryCodeExp(name="PUBTIME", expression="t1.PUBTIME", showorder=11), @DEDataQueryCodeExp(name="TARGETTYPE", expression="t1.TARGETTYPE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDCBulletinDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCBulletinDefaultDQModel() {
        this.initAnnotation(PSDCBulletinDefaultDQModel.class);
    }
}

