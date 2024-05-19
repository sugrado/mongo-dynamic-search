package com.sugrado.mongo_dynamic_search.dto;

import java.util.List;

public record DynamicQuery(
        List<DynamicFilter> filters,
        List<DynamicSort> sorts
) {
}
