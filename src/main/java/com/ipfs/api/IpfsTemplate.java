package com.ipfs.api;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.File;
import java.io.IOException;

/**
 * @Classname IpfsTemplate
 * @Description ipfs 操作
 * @Date 2019/10/9 10:22
 * @Author haifeng.lv
 */
public class IpfsTemplate {

    private IpfsProperties ipfsProperties;

    private final IPFS ipfs;

    IpfsTemplate(IpfsProperties ipfsProperties) {
        this.ipfsProperties = ipfsProperties;
        // 初始化 ipfs
        ipfs = new IPFS(ipfsProperties.getUrl());
    }

    /**
     * @description 获取版本信息
     * @author haifeng.lv
     * @updateTime 2019/10/9 11:00
     * @return: java.lang.String
     */
    public String getVersion() throws IOException {
        return ipfs.version();
    }

    /**
     * @description 添加文件到 ipfs
     * @author haifeng.lv
     * @param: filePath 文件路径
     * @updateTime 2019/10/9 11:22
     * @return: java.lang.String hash 值
     */
    public String add(String filePath) throws IOException {
        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File(filePath));
        MerkleNode addResult = ipfs.add(file).get(0);
        return addResult.hash.toString();
    }

    /**
     * @description 读取文件
     * @author haifeng.lv
     * @param: hash hash 值
     * @updateTime 2019/10/9 11:23
     * @return: java.lang.String
     */
    public String cat(String hash) throws IOException {
        byte[] data = ipfs.cat(Multihash.fromBase58(hash));
        return new String(data);
    }
}
