package org.kangspace.wechat.helper.core.message;

/**
 * 微信加密消息接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatEncryptMessage extends WeChatMessage {
    /**
     * 获取原始加密消息内容
     *
     * @return 原始加密消息内容
     */
    String getEncrypt();

    /**
     * 设置加密消息
     *
     * @param encrypt 已经加密的消息内容
     */
    void setEncrypt(String encrypt);
}
