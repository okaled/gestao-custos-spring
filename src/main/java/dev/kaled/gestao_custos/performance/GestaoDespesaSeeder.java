package dev.kaled.gestao_custos.performance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import dev.kaled.gestao_custos.entity.Despesa;
import dev.kaled.gestao_custos.repository.DespesaRepository;

// @Component
public class GestaoDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;

    // @Override
    public void run(String... args) throws Exception {
        List<Despesa> despesas = new ArrayList<>();
        System.out.println("Iniciando seeder");
        for (int i = 0; i <= 150000; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto n" + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays(i % 30));
            despesa.setCategoria("Teste");
            despesa.setEmail("performancetest@gmail.com");

            despesas.add(despesa);
        }
        despesaRepository.saveAll(despesas);
        System.out.println("Finalizando seeder");
    }

}
