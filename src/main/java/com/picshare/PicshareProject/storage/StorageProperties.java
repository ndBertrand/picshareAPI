package com.picshare.PicshareProject.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import static com.picshare.PicshareProject.storage.StorageConstants.*;


@Service
public class StorageProperties {

    /**
     * Folder location for storing files
     */

    private String location = LOCAL_STORE_DIRECTORY;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
