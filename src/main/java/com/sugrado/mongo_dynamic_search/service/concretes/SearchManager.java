package com.sugrado.mongo_dynamic_search.service.concretes;

import com.sugrado.mongo_dynamic_search.dto.DynamicFilter;
import com.sugrado.mongo_dynamic_search.dto.DynamicQuery;
import com.sugrado.mongo_dynamic_search.dto.DynamicSort;
import com.sugrado.mongo_dynamic_search.service.abstracts.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchManager implements SearchService {
    private final MongoTemplate mongoTemplate;

    @Override
    public <T> List<T> dynamicSearch(DynamicQuery dynamicQuery, Class<T> type) {
        Query query = new Query();
        if (dynamicQuery.filters() != null) {
            filter(query, dynamicQuery.filters());
        }
        if (dynamicQuery.sorts() != null) {
            sort(query, dynamicQuery.sorts());
        }
        return mongoTemplate.find(query, type);
    }

    private void filter(Query query, List<DynamicFilter> filters) {
        for (DynamicFilter filter : filters) {
            if (filter.field() == null || filter.field().isBlank())
                throw new IllegalArgumentException("Field must be provided for filtering");
            if (filter.value() == null || filter.value().isBlank())
                throw new IllegalArgumentException("Value must be provided for filtering");
            if (filter.operator() == null)
                throw new IllegalArgumentException("Operator must be provided for filtering");
        }
        Criteria.where("").is("").andOperator(Criteria.where("").is(""));
        filters.stream()
                .map(filter ->
                        switch (filter.operator()) {
                            case EQUALS -> Criteria.where(filter.field()).is(filter.value());
                            case NOT_EQUALS -> Criteria.where(filter.field()).ne(filter.value());
                            case GREATER_THAN -> Criteria.where(filter.field()).gt(filter.value());
                            case GREATER_THAN_OR_EQUALS -> Criteria.where(filter.field()).gte(filter.value());
                            case LESS_THAN -> Criteria.where(filter.field()).lt(filter.value());
                            case LESS_THAN_OR_EQUALS -> Criteria.where(filter.field()).lte(filter.value());
                            case IN -> Criteria.where(filter.field()).in((Object[]) filter.value().split(","));
                            case NOT_IN -> Criteria.where(filter.field()).nin((Object[]) filter.value().split(","));
                            case IS_NULL -> Criteria.where(filter.field()).is(null);
                            case IS_NOT_NULL -> Criteria.where(filter.field()).ne(null);
                            case STARTS_WITH -> Criteria.where(filter.field()).regex("^" + filter.value());
                            case ENDS_WITH -> Criteria.where(filter.field()).regex(filter.value() + "$");
                            case CONTAINS -> Criteria.where(filter.field()).regex(".*" + filter.value() + ".*");
                            case DOES_NOT_CONTAINS ->
                                    Criteria.where(filter.field()).not().regex(".*" + filter.value() + ".*");
                        }
                )
                .forEach(query::addCriteria);
    }

    private void sort(Query query, List<DynamicSort> sorts) {
        for (DynamicSort dynamicSort : sorts) {
            if (dynamicSort.field() == null || dynamicSort.field().isBlank())
                throw new IllegalArgumentException("Field must be provided for sorting");
            if (dynamicSort.direction() == null)
                throw new IllegalArgumentException("Direction must be provided for sorting");
        }

        sorts.stream()
                .map(dynamicSort ->
                        switch (dynamicSort.direction()) {
                            case ASC -> Sort.by(Sort.Order.asc(dynamicSort.field()));
                            case DESC -> Sort.by(Sort.Order.desc(dynamicSort.field()));
                        }
                )
                .forEach(query::with);
    }
}
