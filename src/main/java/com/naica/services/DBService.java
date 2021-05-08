package com.naica.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.naica.domain.Coordenador;
import com.naica.domain.Unidade;
import com.naica.repositories.CoordenadorRepository;
import com.naica.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void instantiateTestDatabase() throws ParseException {

        Unidade luizote = new Unidade(null, "Naica Luizote", " R. Genarino Cazabona, 954 - Luizote de Freitas, Uberlândia - MG, 38414-530");
        Unidade morumbi = new Unidade(null, "Naica Morumbi", " Av. Felipe Calixto Milken, 137 - Morumbi, Uberlândia - MG, 38407-225");
        Unidade lagoinha = new Unidade(null, "Naica Lagoinha", " R. Cel. Antônio Alves Pereira, 2660 - Lagoinha, Uberlândia - MG, 38408-370 ");
        Unidade tibery = new Unidade(null, "Naica Tibery", " Av. Europa, 175 - Tibery, Uberlândia - MG, 38405-088 ");
        Unidade martaHelena = new Unidade(null, "Naica Marta Helena", " Av. República do Piratini, 234 - Marta Helena, Uberlândia - MG, 38402-028");
        Unidade mansour = new Unidade(null, "Naica Mansour", " R. Rio Uaupes, 36 - Mansour, Uberlândia - MG, 38414-446 ");
        Unidade pequis = new Unidade(null, "Naica Pequis", "  Av. Wilson Rodrigues da Silva, 880 - Res. Pequis, Uberlândia - MG, 38421-032 ");
        Unidade jardimCelia = new Unidade(null, "Naica Jardim Célia", " R. dos Sininhos, 35 - Jardim Célia, Uberlândia - MG, 38413-653 ");
        Unidade tapuirama = new Unidade(null, "Naica Tapuirama", " Av. José Pedro Abalém, 1122 - Distrito de, Uberlândia - MG, 38417-000 ");
        Unidade canaa = new Unidade(null, "Naica Canaã", " Sem endereço no momento");
        Unidade tocantins = new Unidade(null, "Naica Tocantins", " Sem endereço no momento ");


        Coordenador cLuizote = new Coordenador(null, "Claudecir Santana","claudecir.santana", "kady_bio@yahoo.com.br", bCryptPasswordEncoder.encode("Senha123"), luizote);
        Coordenador cMorumbi = new Coordenador(null, "Danielle Castro", "danielle.castro", "Não possui", bCryptPasswordEncoder.encode("Senha123"),morumbi);
        Coordenador cLagoinha = new Coordenador(null, "Elga Carrijo","elga.carrijo", "Não possui", bCryptPasswordEncoder.encode("Senha123"), lagoinha);
        Coordenador cTibery = new Coordenador(null, "Miriam Lima","miriam.lima", "Não possui", bCryptPasswordEncoder.encode("Senha123"), tibery);
        Coordenador cMartaHelena = new Coordenador(null, "Clausmei Reis","clausmei.reis", "Não possui", bCryptPasswordEncoder.encode("Senha123"), martaHelena);
        Coordenador cMansour = new Coordenador(null, "Danuza Franco","danuza.franco", "Não possui", bCryptPasswordEncoder.encode("Senha123"), mansour);
        Coordenador cPequis = new Coordenador(null, "Thays Gonçalves", "thays.gonçalves", "Não possui", bCryptPasswordEncoder.encode("Senha123"), pequis);
        Coordenador cJardimCelia = new Coordenador(null, "Alan Moreira","alan.moreira", "Não possui", bCryptPasswordEncoder.encode("Senha123"), jardimCelia);
        Coordenador cTapuirama = new Coordenador(null, "Angélica Lemes", "angelica.lemes", "Não possui", bCryptPasswordEncoder.encode("Senha123"), tapuirama);
        Coordenador cCanaa = new Coordenador(null, "Daniella Sales", "daniella.sales", "Não possui", bCryptPasswordEncoder.encode("Senha123"), canaa);
        Coordenador cTocantins = new Coordenador(null, "Laís Barcelos","lais.barcelos", "Não possui", bCryptPasswordEncoder.encode("Senha123"), tocantins);

        luizote.setCoordenador(cLuizote);
        cLuizote.setUnidade(luizote);

        morumbi.setCoordenador(cMorumbi);
        cMorumbi.setUnidade(morumbi);

        lagoinha.setCoordenador(cLagoinha);
        cLagoinha.setUnidade(lagoinha);

        tibery.setCoordenador(cTibery);
        cTibery.setUnidade(tibery);

        martaHelena.setCoordenador(cMartaHelena);
        cMartaHelena.setUnidade(martaHelena);

        mansour.setCoordenador(cMansour);
        cMansour.setUnidade(mansour);

        pequis.setCoordenador(cPequis);
        cPequis.setUnidade(pequis);

        jardimCelia.setCoordenador(cJardimCelia);
        cJardimCelia.setUnidade(jardimCelia);

        tapuirama.setCoordenador(cTapuirama);
        cTapuirama.setUnidade(tapuirama);

        canaa.setCoordenador(cCanaa);
        cCanaa.setUnidade(canaa);

        tocantins.setCoordenador(cTocantins);
        cTocantins.setUnidade(tocantins);


        coordenadorRepository.saveAll(Arrays.asList(cLuizote,cMorumbi, cLagoinha, cTibery, cMartaHelena, cMansour, cPequis, cJardimCelia, cTapuirama, cCanaa, cTocantins));
        unidadeRepository.saveAll(Arrays.asList(luizote, morumbi, lagoinha, tibery, martaHelena, mansour, pequis, jardimCelia, tapuirama, canaa, tocantins));
    }
}
