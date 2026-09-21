/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSWXMenu;
import net.ibizsys.modelapi.domain.PSWXMenuItem;
import net.ibizsys.modelapi.dto.PSWXMenuDTO;
import net.ibizsys.modelapi.dto.PSWXMenuFuncDTO;
import net.ibizsys.modelapi.dto.PSWXMenuItemDTO;
import net.ibizsys.modelapi.service.IPSWXMenuItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWXMenuItemServiceImpl
extends PSModelServiceImplBase<PSWXMenuItem, PSWXMenuItemDTO>
implements IPSWXMenuItemService {
    private static final Log log = LogFactory.getLog(PSWXMenuItemServiceImpl.class);

    @Override
    public List<PSWXMenuItem> listByPSWXMenuItem(PSWXMenuItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXMenuItem get(PSWXMenuItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXMenuItem> list = this.listByPSWXMenuItem(parent);
        if (list != null) {
            for (PSWXMenuItem item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSWXMenuItemDTO> listDTOByPSWXMenuItem(String strParentKey) throws Exception {
        PSWXMenuItem pswxmenuitem = (PSWXMenuItem)PSModelServiceUtil.getInstance().getPSWXMenuItemService().get(strParentKey);
        List<PSWXMenuItem> list = this.listByPSWXMenuItem(pswxmenuitem);
        if (list != null) {
            ArrayList<PSWXMenuItemDTO> dtoList = new ArrayList<PSWXMenuItemDTO>();
            for (PSWXMenuItem item : list) {
                PSWXMenuItemDTO dto = (PSWXMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWXMenuItem> listByPSWXMenu(PSWXMenu parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXMenuItem get(PSWXMenu parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXMenuItem> list = this.listByPSWXMenu(parent);
        if (list != null) {
            for (PSWXMenuItem item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSWXMenuItemDTO> listDTOByPSWXMenu(String strParentKey) throws Exception {
        PSWXMenu pswxmenu = (PSWXMenu)PSModelServiceUtil.getInstance().getPSWXMenuService().get(strParentKey);
        List<PSWXMenuItem> list = this.listByPSWXMenu(pswxmenu);
        if (list != null) {
            ArrayList<PSWXMenuItemDTO> dtoList = new ArrayList<PSWXMenuItemDTO>();
            for (PSWXMenuItem item : list) {
                PSWXMenuItemDTO dto = (PSWXMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWXMenuItem> onListAll() throws Exception {
        ArrayList<PSWXMenuItem> list = new ArrayList<PSWXMenuItem>();
        List pswxmenus = PSModelServiceUtil.getInstance().getPSWXMenuService().listAll();
        if (pswxmenus != null) {
            for (PSWXMenu parent : pswxmenus) {
                List<PSWXMenuItem> items = this.listByPSWXMenu(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSWXMenuItem> alllist = new ArrayList<PSWXMenuItem>();
        alllist.addAll(list);
        for (PSWXMenuItem item : list) {
            List<PSWXMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWXMenuItem> listAllChild(PSWXMenuItem parent) throws Exception {
        List<PSWXMenuItem> list = this.listByPSWXMenuItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSWXMenuItem> alllist = new ArrayList<PSWXMenuItem>();
        alllist.addAll(list);
        for (PSWXMenuItem item : list) {
            List<PSWXMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWXMenuItem> listAllByPSWXMenu(PSWXMenu parent) throws Exception {
        List<PSWXMenuItem> list = this.listByPSWXMenu(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSWXMenuItem> alllist = new ArrayList<PSWXMenuItem>();
        alllist.addAll(list);
        for (PSWXMenuItem item : list) {
            List<PSWXMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWXMenuItemDTO> listAllDTOByPSWXMenu(String strParentKey) throws Exception {
        PSWXMenu pswxmenu = (PSWXMenu)PSModelServiceUtil.getInstance().getPSWXMenuService().get(strParentKey);
        List<PSWXMenuItem> list = this.listAllByPSWXMenu(pswxmenu);
        if (list != null) {
            ArrayList<PSWXMenuItemDTO> dtoList = new ArrayList<PSWXMenuItemDTO>();
            for (PSWXMenuItem item : list) {
                PSWXMenuItemDTO dto = (PSWXMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSWXMenuItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSWXMenuItem item;
        PSWXMenuItem item2;
        PSWXMenuItem pswxmenuitem = (PSWXMenuItem)PSModelServiceUtil.getInstance().getPSWXMenuItemService().get(strParentKey, true);
        if (pswxmenuitem != null && (item2 = this.get(pswxmenuitem, strCurKey, true)) != null) {
            return item2;
        }
        PSWXMenu pswxmenu = (PSWXMenu)PSModelServiceUtil.getInstance().getPSWXMenuService().get(strParentKey, true);
        if (pswxmenu != null && (item = this.get(pswxmenu, strCurKey, true)) != null) {
            return item;
        }
        return (PSWXMenuItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWXMenuItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSWXMenuItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXMenuItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWXMenuId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXMenuService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWXMenuItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSWXMenuItemName())) {
            return et.getPSWXMenuItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWXMenuItemDTO dto, PSWXMenuItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWXMenuItemId(t.getId().replace("/", "."));
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSWXMenuItemId() != null || !bIgnoreNull) {
            dto.setPPSWXMenuItemId(t.getPPSWXMenuItemId());
        }
        if (t.getPPSWXMenuItemName() != null || !bIgnoreNull) {
            dto.setPPSWXMenuItemName(t.getPPSWXMenuItemName());
        }
        if (t.getPSWXMenuFuncId() != null || !bIgnoreNull) {
            dto.setPSWXMenuFuncId(t.getPSWXMenuFuncId());
        }
        if (t.getPSWXMenuFuncName() != null || !bIgnoreNull) {
            dto.setPSWXMenuFuncName(t.getPSWXMenuFuncName());
        }
        if (t.getPSWXMenuId() != null || !bIgnoreNull) {
            dto.setPSWXMenuId(t.getPSWXMenuId());
        }
        if (t.getPSWXMenuItemName() != null || !bIgnoreNull) {
            dto.setPSWXMenuItemName(t.getPSWXMenuItemName());
        }
        if (t.getPSWXMenuName() != null || !bIgnoreNull) {
            dto.setPSWXMenuName(t.getPSWXMenuName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (StringUtils.hasLength((String)dto.getPPSWXMenuItemId())) {
            dto.setPPSWXMenuItemId(this.getRealPSModelId(t, dto.getPPSWXMenuItemId()).replace("/", "."));
        }
        if ("PSWXMENUITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSWXMenuItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuFuncId())) {
            dto.setPSWXMenuFuncId(this.getRealPSModelId(t, dto.getPSWXMenuFuncId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuId())) {
            dto.setPSWXMenuId(this.getRealPSModelId(t, dto.getPSWXMenuId()).replace("/", "."));
        }
        if ("PSWXMENU".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWXMenuId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSWXMenuItemId())) {
            linkDTO = (PSWXMenuItemDTO)PSModelServiceUtil.getInstance().getPSWXMenuItemService().getDTO(dto.getPPSWXMenuItemId());
            dto.setPPSWXMenuItemName(((PSWXMenuItemDTO)linkDTO).getPSWXMenuItemName());
        } else {
            dto.setPPSWXMenuItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuFuncId())) {
            linkDTO = (PSWXMenuFuncDTO)PSModelServiceUtil.getInstance().getPSWXMenuFuncService().getDTO(dto.getPSWXMenuFuncId());
            dto.setPSWXMenuFuncName(((PSWXMenuFuncDTO)linkDTO).getPSWXMenuFuncName());
        } else {
            dto.setPSWXMenuFuncName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuId())) {
            linkDTO = (PSWXMenuDTO)PSModelServiceUtil.getInstance().getPSWXMenuService().getDTO(dto.getPSWXMenuId());
            dto.setPSWXMenuName(((PSWXMenuDTO)linkDTO).getPSWXMenuName());
        } else {
            dto.setPSWXMenuName(null);
        }
        List<PSWXMenuItem> list = PSModelServiceUtil.getInstance().getPSWXMenuItemService().listByPSWXMenuItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSWXMenuItemDTO> pswxmenuitems = new ArrayList<PSWXMenuItemDTO>();
            for (PSWXMenuItem item : list) {
                PSWXMenuItemDTO dstItem = (PSWXMenuItemDTO)PSModelServiceUtil.getInstance().getPSWXMenuItemService().toDTO(item);
                pswxmenuitems.add(dstItem);
            }
            dto.setPswxmenuitems(pswxmenuitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWXMENUITEM";
    }

    @Override
    public PSWXMenuItem createDomain() {
        return new PSWXMenuItem();
    }

    @Override
    public PSWXMenuItemDTO createDTO() {
        return new PSWXMenuItemDTO();
    }
}

