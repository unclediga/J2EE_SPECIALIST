package ru.unclediga.spec.service;

import ru.unclediga.spec.model.CatalogItem;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class ProductCatalogService {
    private List<CatalogItem> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("MY: bean ProductCatalogService.init()");
        items.add(new CatalogItem("code1", "item1"));
        items.add(new CatalogItem("code1", "item1"));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MY: bean ProductCatalogService.destroy()");
        items.clear();
    }

    public int getSize() {
        return items.size();
    }

    public List<CatalogItem> getAll() {
        return items;
    }
}
