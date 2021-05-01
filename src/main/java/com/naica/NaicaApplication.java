package com.naica;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.naica.domain.Coordenador;
import com.naica.domain.Unidade;
import com.naica.repositories.CoordenadorRepository;
import com.naica.repositories.UnidadeRepository;

@SpringBootApplication
public class NaicaApplication implements CommandLineRunner {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private CoordenadorRepository coordenadorRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(NaicaApplication.class, args);
		
		System.out.println("BANCO RODANDO");
	}

	@Override
	public void run(String... args) throws Exception {
		
		Unidade luizote = new Unidade(null, "Luizote", " R. Genarino Cazabona, 954 - Luizote de Freitas, Uberlândia - MG, 38414-530");
		Unidade morumbi = new Unidade(null, "Morumbi", " Av. Felipe Calixto Milken, 137 - Morumbi, Uberlândia - MG, 38407-225");
		Unidade lagoinha = new Unidade(null, "Lagoinha", " R. Cel. Antônio Alves Pereira, 2660 - Lagoinha, Uberlândia - MG, 38408-370 ");
		Unidade tibery = new Unidade(null, "Tibery", " Av. Europa, 175 - Tibery, Uberlândia - MG, 38405-088 ");
		Unidade martaHelena = new Unidade(null, "Marta Helena", " Av. República do Piratini, 234 - Marta Helena, Uberlândia - MG, 38402-028");
		Unidade mansour = new Unidade(null, "Mansour", " R. Rio Uaupes, 36 - Mansour, Uberlândia - MG, 38414-446 ");
		Unidade pequis = new Unidade(null, "Pequis", "  Av. Wilson Rodrigues da Silva, 880 - Res. Pequis, Uberlândia - MG, 38421-032 ");
		Unidade jardimCelia = new Unidade(null, "Jardim Célia", " R. dos Sininhos, 35 - Jardim Célia, Uberlândia - MG, 38413-653 ");
		Unidade tapuirama = new Unidade(null, "Tapuirama", " Av. José Pedro Abalém, 1122 - Distrito de, Uberlândia - MG, 38417-000 ");
		Unidade canaa = new Unidade(null, "Canaã", " Sem endereço no momento");
		Unidade tocantins = new Unidade(null, "Tocantins", " Sem endereço no momento ");
		
		
		Coordenador cLuizote = new Coordenador(null, "Claudecir Santana","claudecir.santana", luizote, "kady_bio@yahoo.com.br", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cMorumbi = new Coordenador(null, "Danielle Castro", "danielle.castro",morumbi, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cLagoinha = new Coordenador(null, "Elga Carrijo","elga.carrijo", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cTibery = new Coordenador(null, "Miriam Lima","miriam.lima", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cMartaHelena = new Coordenador(null, "Clausmei Reis","clausmei.reis", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cMansour = new Coordenador(null, "Danuza Franco","danuza.franco", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cPequis = new Coordenador(null, "Thays Gonçalves", "thays.gonçalves",luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cJardimCelia = new Coordenador(null, "Alan Moreira","alan.moreira", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cTapuirama = new Coordenador(null, "Angélica Lemes", "angelica.lemes",luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cCanaa = new Coordenador(null, "Daniella Sales", "daniella.sales",luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		Coordenador cTocantins = new Coordenador(null, "Laís Barcelos","lais.barcelos", luizote, "Não possui", bCryptPasswordEncoder.encode("Senha123"));
		
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
