/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.user.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="f4552a6291c79e3934263b31b83aec33",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="24680F99-7889-4963-B07A-123C1A0E94A1",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserDefaultDSModelBase() {
        super();

        this.initAnnotation(UserDefaultDSModelBase.class);
    }




}