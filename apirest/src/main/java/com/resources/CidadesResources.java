package com.resources;

import java.io.IOException;
import java.util.List;

import com.models.Cidades;
import com.repository.CidadesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class CidadesResources {

    @Autowired
    CidadesRepository cidadesRepository;

    //Lista todas as cidades
    @GetMapping("/listarCidades")
    public <cidades> List<Cidades> listaCidades(){
        return cidadesRepository.findAll();
    }

    //Busca somente uma cidade por id
    @GetMapping("/pegaCidade")
    public Cidades pegaCidades(@RequestBody Cidades cidades){
        return (Cidades) cidadesRepository.findAll(cidades.getId);
    }

    //Busca apenas todas as cidades capitais
    @GetMapping("/pegaCapitais")
    public <cidades> List<Cidades> findAllcapitaisCidades(){
        return cidadesRepository.findAllcapitaisCidades();
    }

    //Salva a cidade
    @PostMapping("/salvarCidade")
    public Cidades salvaCidades(@RequestBody Cidades cidades){
        return cidadesRepository.save(cidades);
    }

    //Deleta a cidade
    @DeleteMapping("/deletaCidade")
    public void deletaCidades(@RequestBody Cidades cidades) {
        cidadesRepository.deleteById(cidades.getId());
    }

    //Atualiza a cidade
    @PutMapping("/atualizaCidade")
    public Cidades atualizaCidades(@RequestBody Cidades cidades) {
        return cidadesRepository.save(cidades);
    }

    //Carrega Arquivo CSV e persiste no banco
    @PostMapping("/carregaCSV")
    public String[][] carregaCSV(@RequestBody String arquivo) throws IOException{
        return cidadesRepository.carregaCidades(arquivo);
    }

    //Busca a qtd de cidadaes por Estado
    @GetMapping("/qtdCidadeEstado")
    public <cidades> List<Cidades> findAllCidades(){
        return cidadesRepository.findAllCidades();
    }

    //Retorna cidade informando ibge
    @GetMapping("/pegaCidadeIbge")
    public Cidades pegaCidadeIbge(@RequestBody Cidades cidades){
        return (Cidades) cidadesRepository.findAll(cidades.getIbge_id());
    }

    //Busca maior e menos qtd de cidades por Estado
    @GetMapping("/qtdMaiorMenorEstado")
    public <cidades> List<Cidades> buscaMaiorMenorEstado(){
        return cidadesRepository.buscaMaiorMenorEstado();
    }

    //Retorna as cidades escolhendo o Estado
    @GetMapping("/pegaCidadesPorEstado")
    public Cidades pegaCidadesPorEstado(@RequestBody Cidades cidades){
        return (Cidades) cidadesRepository.findAll(cidades.getUf());
    }
}