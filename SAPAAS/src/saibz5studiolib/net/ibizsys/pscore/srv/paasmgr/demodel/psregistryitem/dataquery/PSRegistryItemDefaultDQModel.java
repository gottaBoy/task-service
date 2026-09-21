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
package net.ibizsys.pscore.srv.paasmgr.demodel.psregistryitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FEC152DC-D249-48D9-B46D-76864050F4EB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMTAG`, t1.`ITEMTAG2`, t1.`MEMO`, t1.`PSREGISTRYITEMID`, t1.`PSREGISTRYITEMNAME`, t1.`PSREGISTRYREPOID`, t11.`PSREGISTRYREPONAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSREGISTRYITEM` t1  LEFT JOIN T_SRFPSREGISTRYREPO t11 ON t1.PSREGISTRYREPOID = t11.PSREGISTRYREPOID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ITEMTAG", expression="t1.`ITEMTAG`", showorder=2), @DEDataQueryCodeExp(name="ITEMTAG2", expression="t1.`ITEMTAG2`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSREGISTRYITEMID", expression="t1.`PSREGISTRYITEMID`", showorder=5), @DEDataQueryCodeExp(name="PSREGISTRYITEMNAME", expression="t1.`PSREGISTRYITEMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSREGISTRYREPOID", expression="t1.`PSREGISTRYREPOID`", showorder=7), @DEDataQueryCodeExp(name="PSREGISTRYREPONAME", expression="t11.`PSREGISTRYREPONAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ITEMTAG, t1.ITEMTAG2, t1.MEMO, t1.PSREGISTRYITEMID, t1.PSREGISTRYITEMNAME, t1.PSREGISTRYREPOID, t11.PSREGISTRYREPONAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSREGISTRYITEM t1  LEFT JOIN T_SRFPSREGISTRYREPO t11 ON t1.PSREGISTRYREPOID = t11.PSREGISTRYREPOID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ITEMTAG", expression="t1.ITEMTAG", showorder=2), @DEDataQueryCodeExp(name="ITEMTAG2", expression="t1.ITEMTAG2", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSREGISTRYITEMID", expression="t1.PSREGISTRYITEMID", showorder=5), @DEDataQueryCodeExp(name="PSREGISTRYITEMNAME", expression="t1.PSREGISTRYITEMNAME", showorder=6), @DEDataQueryCodeExp(name="PSREGISTRYREPOID", expression="t1.PSREGISTRYREPOID", showorder=7), @DEDataQueryCodeExp(name="PSREGISTRYREPONAME", expression="t11.PSREGISTRYREPONAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSRegistryItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSRegistryItemDefaultDQModel() {
        this.initAnnotation(PSRegistryItemDefaultDQModel.class);
    }
}

