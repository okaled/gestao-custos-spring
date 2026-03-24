package dev.kaled.gestao_custos.useCases;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.kaled.gestao_custos.entity.Despesa;
import dev.kaled.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa execute(Despesa despesa) {

        if (despesa.getCategoria() == null || despesa.getCategoria().equals("") || despesa.getData() == null
                || despesa.getValor() == null || despesa.getValor().compareTo(BigDecimal.ZERO) <= 0
                || despesa.getDescricao() == null
                || despesa.getDescricao().equals("")
                || despesa.getEmail() == null
                || despesa.getEmail().equals("")) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos");
        }

        despesa = despesaRepository.save(despesa);
        return despesa;
    }
}
