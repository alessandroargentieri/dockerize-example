FROM openjdk:8-jdk-alpine
# Environment Variable that defines the endpoints for the user microservice and the chart microservice
ENV AGGREGATOR_USER_SERVICE_ADDRESS = http://localhost:8081/user
ENV AGGREGATOR_CHART_SERVICE_ADDRESS = http://localhost:8082/chart
ADD target/Aggregator-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
CMD ["java", "-jar", "Aggregator-0.0.1-SNAPSHOT.jar", "--aggregator.user.service.address=${AGGREGATOR_USER_SERVICE_ADDRESS} --aggregator.chart.service.address=${AGGREGATOR_CHART_SERVICE_ADDRESS}"]