package com.jithin.availability.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration {

    @Bean
    public ElasticsearchClient elasticsearchClient(){

        Header[] defaultHeaders = new Header[]{
                new BasicHeader("Authorization", "ApiKey b09ZVE1wZ0JsSmpmNVFPa0ktRzA6YjlWelpZT1FqZDJDeWhqaHlJRmN4UQ==")
        };

        RestClient restClient = RestClient.builder(
                new HttpHost("localhost",9200)
        ).setDefaultHeaders(defaultHeaders).build();
        RestClientTransport transport = new RestClientTransport(
                restClient,
                new JacksonJsonpMapper()
        );
        return new ElasticsearchClient(transport);
    }
}
