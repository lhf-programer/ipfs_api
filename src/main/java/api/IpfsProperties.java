package api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname IpfsProperties
 * @Description ipfs 属性
 * @Date 2019/10/9 10:18
 * @Author haifeng.lv
 */
@ConfigurationProperties(prefix = "ipfs")
@Data
public class IpfsProperties {
    /**
     * 连接地址
     */
    private String url;
}
