package com.dockermicroservices.Chart.daos;

import com.dockermicroservices.Chart.entities.Chart;

public interface ChartDao {
    Chart getChartGivenUserId(String userId);
}
