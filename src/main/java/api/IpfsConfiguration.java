package api;

/**
 * @Classname IpfsConfiguration
 * @Description ipfs 配置类
 * @Date 2019/10/9 10:24
 * @Author haifeng.lv
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IpfsProperties.class)
@ConditionalOnClass(IpfsTemplate.class)
@ConditionalOnProperty(prefix = "ipfs", value = "enabled", matchIfMissing = true)
public class IpfsConfiguration {

    @Autowired
    private IpfsProperties ipfsProperties;

    @Bean
    @ConditionalOnMissingBean(IpfsTemplate.class)
    public IpfsTemplate ipfsTemplate(){
        // 加载配置项
        IpfsTemplate ipfsTemplate = new IpfsTemplate(ipfsProperties);
        return ipfsTemplate;
    }

}
