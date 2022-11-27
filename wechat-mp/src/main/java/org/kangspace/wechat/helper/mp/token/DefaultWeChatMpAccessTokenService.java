package org.kangspace.wechat.helper.mp.token;

import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.mp.AbstractWeChatMpService;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenRequest;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 默认微信公众号Token处理Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class DefaultWeChatMpAccessTokenService extends AbstractWeChatMpService implements WeChatMpAccessTokenService {
    /**
     * AccessToken 存储器
     */
    private final WeChatTokenStorage<WeChatMpAccessTokenResponse> weChatTokenStorage;

    public DefaultWeChatMpAccessTokenService(WeChatMpConfig weChatConfig) {
        super(weChatConfig, null);
        this.weChatTokenStorage = weChatConfig.getWeChatTokenStorage();
    }

    @Override
    public WeChatMpAccessTokenResponse tokenRefresh() {
        WeChatMpConfig weChatMpConfig = getWeChatConfig();
        return token(weChatMpConfig.getAppId(), weChatMpConfig.getAppSecret());
    }

    @Override
    public WeChatMpAccessTokenResponse token(String appId, String secret) {
        String param = WeChatMpAccessTokenRequest.toQueryString(appId, secret);
        String url = WeChatMpApiPaths.TOKEN + StringLiteral.QUESTION_MARK + param;
        return get(url, WeChatMpAccessTokenResponse.class, false);
    }

    @Override
    public WeChatTokenStorage<WeChatMpAccessTokenResponse> getWeChatTokenStorage() {
        return this.weChatTokenStorage;
    }
}
