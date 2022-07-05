package br.com.mt.store.notif.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "br.com.mt.store.commons.app.config",
        "br.com.mt.store.notif.infra.outputadapter",
        "br.com.mt.store.notif.infra.sender"
})
public class ScanConfig {

}