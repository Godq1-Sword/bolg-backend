package org.gdq.bolg.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.gdq.bolg.core.model.entity.ReactiveBody;
import org.gdq.bolg.core.model.po.MenuPO;
import org.gdq.bolg.core.model.vo.MenuVO;
import org.gdq.bolg.core.service.MenuService;
import org.gdq.bolg.core.util.BolgConstantMap;
import org.gdq.bolg.core.util.ReactiveBodyUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author God_q1
 * date 2020/7/9
 * description MenuController
 */
@Transactional
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * description 插入菜单
     *
     * @param menuVOS 菜单数据
     * @return ReactiveBody
     * @author gdq date 2020/8/18
     */
    @PostMapping
    public ReactiveBody addMenu(@RequestBody List<MenuVO> menuVOS) {
        menuVOS.forEach(menuVo -> {
            menuVo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            menuService.addMenu(new MenuPO(menuVo));
        });
        return ReactiveBodyUtil.generateSucRB(null, "插入菜单成功");
    }

    /**
     * description 删除菜单
     *
     * @param menuVOS 菜单数据
     * @return ReactiveBody
     * @author gdq date 2020/8/18
     */
    @DeleteMapping
    public ReactiveBody deleteMenu(@RequestBody List<MenuVO> menuVOS) {
        menuService.removeMenu(menuVOS);
        return ReactiveBodyUtil.generateSucRB(null, "删除菜单成功");
    }

    /**
     * description 更新菜单
     *
     * @param menuVOS 菜单数据
     * @return ReactiveBody
     * @author gdq date 2020/8/18
     */
    @PutMapping
    public ReactiveBody updateMenu(@RequestBody List<MenuVO> menuVOS) {
        menuVOS.forEach(menuVo -> menuService.modifyMenu(new MenuPO(menuVo)));
        return ReactiveBodyUtil.generateSucRB(null, "更新菜单成功");
    }

    @GetMapping
    public ReactiveBody getAllMenu() {
        return ReactiveBodyUtil.generateSucRB(menuService.queryAllMenu());
    }

    /**
     * description get Menu By Type
     *
     * @param type menuType
     * @return ReactiveBody
     * @author gdq date 2020/8/5
     */
    @GetMapping("/type/{type}")
    public ReactiveBody getMenu(@PathVariable("type") String type) {
        // TODO rel Role
        List<MenuPO> menuPOS = menuService.queryMenusByType(type);
        return ReactiveBodyUtil.generateSucRB(MenuVO.menuPOSToVOS(menuPOS));
    }

    /**
     * description get Menu group by type
     *
     * @return ReactiveBody
     * @author gdq date 2020/8/5
     */
    @GetMapping("/typeGroup")
    public ReactiveBody getMenuTypeGroup() {
        // get AllTypes
        List<String> types = menuService.queryAllTypes();
        // get typeGroups
        JSONArray typeGroups = new JSONArray();
        types.forEach(type -> {
            JSONObject typeGroup = new JSONObject();
            List<MenuPO> menuPOS = menuService.queryMenusByType(type);
            typeGroup.put("key", BolgConstantMap.getValue(type).toString());
            typeGroup.put("type", type);
            typeGroup.put("value", MenuVO.menuPOSToVOS(menuPOS));
            typeGroups.add(typeGroup);
        });
        return ReactiveBodyUtil.generateSucRB(typeGroups);
    }
}
