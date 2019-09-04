package com.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.models.Cidades;

import org.apache.tomcat.util.http.fileupload.FileItemStream.ItemSkippedException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {

    //Retorna cidade informando ibge
    Cidades findAll(Number ibge_id);

    //Retorna cidade informando UF
    Cidades findAll(String uf);

    //Busca a qtd de cidades por Estado
    @Query("select count(*), max(tb.uf) from tb_cidades tb group by uf order by uf")
    List<Cidades> findAllCidades();

    //Busca todas as cidades que são Capitais
    @Query("select tb.ibge_id, tb.uf, tb.name, tb.capital, tb.lon, tb.lat from tb_cidades tb where tb.capital is not null order by 3")
    List<Cidades> findAllcapitaisCidades();

    //Busca o menor Estado
    @Query("select count(*), tb.uf from tb_cidades tb group by tb.uf order by 1 asc fetch first 1 rows only")
    List<Cidades> menorEstado();

    //Busca o maior Estado
    @Query("select count(*), tb.uf from tb_cidades tb group by tb.uf order by 1 desc fetch first 1 rows only")
    List<Cidades> maiorEstado();

    //Junta as duas listas "menorEstado", "maiorEstado" em uma so lista
    public default List<Cidades> buscaMaiorMenorEstado(){
        List<Cidades> novaLista = new ArrayList<Cidades>(maiorEstado());
        novaLista.addAll(menorEstado());
        return novaLista;
    }

    //Numero de colunas
    @Query("select count(*) from information_schema.Columns Where Table_Name='tb_cidades'")
    int colunas();

    //Numero de linhas
    @Query("select count(*) from tb_cidades")
    int linhas();

    //Soma de todos os campos da tabela
    public default Integer somaTabela(){
        int total = (colunas() * linhas());
        return total;
    }

    //Carrega arquivo CSV e persiste no banco
    public default <CSVReader> String[][] carregaCidades(String arquivo) throws IOException {
        String arquivoCSV = arquivo;
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        String[][] arrayCidade = new String[20][20];
        int j = 0;
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                j++;
                String[] cidade = linha.split(csvDivisor);
                for(int i=0; i <= cidade.length; i++){
                    arrayCidade[j][i] = cidade[i];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ItemSkippedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return arrayCidade;
    }



}