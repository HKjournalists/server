package com.software.server.web.shiro;

import com.software.server.common.constant.ResourceStatusEnum;
import com.software.server.common.utils.StringUtils;
import com.software.server.dao.model.ResourceModel;
import com.software.server.service.interfaces.IResourceService;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

/**
 * 配置拦截
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    @Autowired
    private IResourceService resourceService;

    private String filterChainPath = "classpath:config/shiroChainDefinition.ini";

    public static final String PERMISSION_STRING = "perms[\"{0}\"]";


    @Override
    public Ini.Section getObject() throws Exception {
        List<ResourceModel> list = resourceService.listByStatus(ResourceStatusEnum.NORMAL.getKey());
        Ini ini = new Ini();
        ini.loadFromPath(filterChainPath);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        for(ResourceModel resourceModel : list){
            if (StringUtils.isNotEmpty(resourceModel.getResKey()) && StringUtils.isNotEmpty(resourceModel.getResValue())){
                section.put(resourceModel.getResKey(), MessageFormat.format(PERMISSION_STRING, resourceModel.getResValue()));
            }
        }
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getFilterChainDefinitions() {
        return filterChainPath;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainPath = filterChainDefinitions;
    }
}
