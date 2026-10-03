/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.usergroupdetail.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="404bf990bacdba520e82d9603063c3dd",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="3DA05FEA-614F-48A2-B033-C9A4F6BA5C6E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserGroupDetailDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserGroupDetailDefaultDSModelBase() {
        super();

        this.initAnnotation(UserGroupDetailDefaultDSModelBase.class);
    }




}