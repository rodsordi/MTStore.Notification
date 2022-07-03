package br.com.mt.store.notif.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "br.com.mt.store.notif.infra.outputadapter",
        "br.com.mt.store.notif.infra.respository"
})
public class ScanConfig {

}