package com.ufuk.Repository;

import com.ufuk.Domain.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    List<Kisi> getByCustomQuery(String search);

    List<Kisi> getByAdLikeOrSoyadiLike(String ad , String soyad);
}
