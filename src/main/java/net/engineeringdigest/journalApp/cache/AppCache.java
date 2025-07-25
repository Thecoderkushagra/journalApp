package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.entity.ConfigEntity;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public HashMap<String, String> APP_CACHE = new HashMap<>();

    @PostConstruct
    private void init() {
        List<ConfigEntity> all = configJournalAppRepository.findAll();
        for (ConfigEntity configEntity: all){
            APP_CACHE.put(configEntity.getKey(),configEntity.getValue());
        }
    }
}

