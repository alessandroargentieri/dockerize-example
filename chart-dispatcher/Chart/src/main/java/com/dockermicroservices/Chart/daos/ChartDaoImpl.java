package com.dockermicroservices.Chart.daos;

import com.dockermicroservices.Chart.entities.Chart;
import com.dockermicroservices.Chart.entities.Item;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChartDaoImpl implements ChartDao{

    Map<String, Chart> chartMap;

    @Override
    public Chart getChartGivenUserId(String userId) {
        return chartMap.get(userId);
    }

    @PostConstruct
    private void fillChartList(){

        chartMap = new HashMap<>();

        Item item1 = new Item("xsxs", "pen", 1.00d, 2);
        Item item2 = new Item("xssd", "pencil", 0.89d, 7);
        Item item3 = new Item("ddtr", "gum", 2.10d, 3);
        List<Item> itemsAlex = new ArrayList<>();
        itemsAlex.add(item1);
        itemsAlex.add(item2);
        itemsAlex.add(item3);
        Chart chartAlex = new Chart(itemsAlex);

        Item item4 = new Item("xsee", "oil", 1.00d, 2);
        Item item5 = new Item("ffsd", "water", 0.89d, 7);
        Item item6 = new Item("ddsw", "coke", 2.10d, 3);
        List<Item> itemsDebora = new ArrayList<>();
        itemsDebora.add(item4);
        itemsDebora.add(item5);
        itemsDebora.add(item6);
        Chart chartDebora = new Chart(itemsDebora);

        Item item7 = new Item("xqqs", "colors", 1.00d, 2);
        Item item8 = new Item("xsuy", "book", 0.89d, 7);
        Item item9 = new Item("ddds", "light", 2.10d, 3);
        List<Item> itemsTeo = new ArrayList<>();
        itemsTeo.add(item7);
        itemsTeo.add(item8);
        itemsTeo.add(item9);
        Chart chartTeo = new Chart(itemsTeo);

        chartMap.put("cd32", chartAlex);
        chartMap.put("cd33", chartDebora);
        chartMap.put("cd34", chartTeo);

    }
}
