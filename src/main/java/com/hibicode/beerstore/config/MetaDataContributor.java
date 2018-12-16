package com.hibicode.beerstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Component
public class MetaDataContributor implements InfoContributor {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> details = new HashMap<>();
        details.put("bean-definition-count", ctx.getBeanDefinitionCount());
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(ctx.getStartupDate()),
                        TimeZone.getDefault().toZoneId());
        details.put("startup-date", triggerTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        builder.withDetail("other", details);
    }

}