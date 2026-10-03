/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatas.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="b2af03b3659b89cfbfc6f8932ff1b61f",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="21B77E1F-6533-40F2-BF31-7D69A99C6EEA",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserRoleDatasDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserRoleDatasDefaultDSModelBase() {
        super();

        this.initAnnotation(UserRoleDatasDefaultDSModelBase.class);
    }




}