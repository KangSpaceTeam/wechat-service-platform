package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 获取自定义菜单配置响应
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuGetResponse extends WeChatMpResponseEntity {
    /**
     * 默认菜单
     */
    private Menu menu;
    /**
     * 全部个性化菜单信息。
     */
    @JsonProperty("conditionalmenu")
    private List<ConditionalMenu> conditionalMenu;

    /**
     * 默认菜单
     */
    @Data
    public static class Menu {
        @JsonProperty("menuid")
        private String menuId;

        /**
         * 菜单按钮列表
         */
        private List<MenuButtonResponse.MenuButton> button;
    }

    /**
     * 全部个性化菜单信息
     */
    @Data
    @ToString(callSuper = true)
    public static class ConditionalMenu extends Menu {
        /**
         * 菜单匹配规则。
         * 必填: 是
         */
        @JsonProperty("matchrule")
        private MenuMatchRule matchRule;
    }
}
