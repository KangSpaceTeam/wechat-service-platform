package org.kangspace.wechat.helper.core.config;

import lombok.Data;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.WeChatToken;
import org.redisson.api.RedissonClient;

/**
 * 微信基本配置接口(包括AppId等),包括:
 * <pre>
 * 1. AppId,AppSecret,由子类实现
 * 2. {@link WeChatTokenStorage} Token存储器
 * 3. {@link org.kangspace.wechat.helper.core.config.WeChatRequestConfig.RequestConfig} Http请求相关配置
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatConfig {

    /**
     * 应用ID
     *
     * @return appId
     */
    String getAppId();

    /**
     * Http相关请求配置
     *
     * @return {@link RequestConfig}
     */
    RequestConfig requestConfig();

    /**
     * 获取Token存储器
     *
     * @return {@link WeChatTokenStorage}
     */
    <TokenVal extends WeChatToken> WeChatTokenStorage<TokenVal> getWeChatTokenStorage();

    /**
     * 获取HttpClient
     *
     * @return {@link WeChatHttpClient}
     */
    WeChatHttpClient getWeChatHttpClient();

    /**
     * 获取Redis配置
     *
     * @return {@link WeChatRedisConfig}
     */
    WeChatRedisConfig getRedisConfig();

    /**
     * 根据 {@link WeChatRedisConfig}获取RedissonClient
     *
     * @return {@link RedissonClient}
     */
    RedissonClient getRedissonClient();

    /**
     * 请求配置
     */
    @Data
    class RequestConfig {
        /**
         * 是否压缩, default: true
         */
        private boolean compress = true;
        /**
         * 是否重定向, default: true
         */
        private boolean followRedirect = true;
        /**
         * 是否保持连接, default: false
         */
        private boolean keepAlive = false;
        /**
         * 连接超时时间, default: 3000
         */
        private Integer connectionTimeout = 3000;
        /**
         * 读取超时时间时间, default: 3000
         */
        private Long readTimeout = 3000L;
        /**
         * 请求最大重试次数(不含第一次请求)
         *
         * @see org.kangspace.wechat.helper.core.request.filter.RequestExecuteRetryFilter
         */
        private int maxRetryCount = 3;
    }
}
