package com.hxb.core.context;

import com.hxb.core.common.utils.StringUtils;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by yangjiachang on 2017/12/29.
 */
public class HxbPreferencesPlaceholderConfigurer extends PreferencesPlaceholderConfigurer {

    /**
     * 文件目录
     */
    private String propdir;

    private Resource[] locations;

    /**
     * 文件列表
     */
    private List<String> props;

    public void setPropdir(String propdir) {
        this.propdir = propdir;
    }

    public void setLocations(Resource... locations) {
        this.locations = locations;
        super.setLocations(locations);
    }

    public Resource[] getLocations() {
        return locations;
    }

    public void setProps(List<String> props) {
        Properties properties = new Properties();
        boolean isInside = StringUtils.isBlank(propdir) ? true : false;
        for (String propfile : props) {
            propfile = getValidpropfile(propfile);
            String path = propfile;
            try {
                Properties prop = new Properties();
                InputStream is;
                if (isInside) {

                    logger.info("Loading properites file from " + path);
                    is = HxbPreferencesPlaceholderConfigurer.class.getResourceAsStream(propfile);
                } else {
                    String file = propdir + propfile;
                    path = file;
                    logger.info("Loading properites file from " + path);
                    is = new FileInputStream(file);
                }
                prop.load(is);
                if (prop != null) {
                    properties.putAll(prop);
                }
            } catch (Exception e) {
                logger.fatal("Properties file " + path + " cannot be found. All related functionalities may be unavailable", e);
            }
        }
        this.setProperties(properties);
    }

    /**
     * 获取标准的路径，防止漏加 /
     * @param propfile
     * @return
     */
    private static String getValidpropfile(String propfile){
        if(!propfile.startsWith("/")){
            propfile = "/"+propfile;
        }
        return propfile;
    }

}
