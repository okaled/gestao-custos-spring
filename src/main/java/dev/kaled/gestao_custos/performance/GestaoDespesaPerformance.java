package dev.kaled.gestao_custos.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kaled.gestao_custos.entity.Despesa;
import dev.kaled.gestao_custos.repository.DespesaRepository;

@RequestMapping("/gestao/performance")
@RestController
public class GestaoDespesaPerformance {

    @Autowired
    DespesaRepository repository;

    @GetMapping("/sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = repository.findAll();

        stopWatch.stop();
        System.out.println("Tempo sem paginação: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = repository.findAll(pageable);
        stopWatch.stop();
        System.out.println("Tempo com paginação: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = repository.findByEmail(email, pageable);
        stopWatch.stop();
        System.out.println("Tempo com paginação: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(despesas);
    }

    @Cacheable(value = "gastosPorEmailCache", key = "#email + '-'+#pageable.pageNumber+'-'+#pageable.pageSize+'-'")
    @GetMapping("/cache/{email}")
    public ResponseEntity<Page<Despesa>> cacheComPaginacao(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var despesas = repository.findByEmail(email, pageable);
        stopWatch.stop();
        System.out.println("Tempo com paginação: " + stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok(despesas);
    }
}
