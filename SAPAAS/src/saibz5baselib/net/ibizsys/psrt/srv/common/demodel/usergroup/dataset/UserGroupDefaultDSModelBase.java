/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.usergroup.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="5eba267a2d34c0c5dc686961a48f62d1",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="66C21513-F456-4E58-BC4F-12AED848D7D4",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserGroupDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserGroupDefaultDSModelBase() {
        super();

        this.initAnnotation(UserGroupDefaultDSModelBase.class);
    }




}