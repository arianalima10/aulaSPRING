package br.com.arianalima.reactiveapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.arianalima.reactiveapi.model.DocFiscal;
import br.com.arianalima.reactiveapi.repo.DocFiscalRepo;

@Service
public class DocFiscalServiceImpl implements IDocFiscalService{

	private DocFiscalRepo repo;
	private WebClient webClient;

	public DocFiscalServiceImpl(DocFiscalRepo repo , WebClient webClient) {
		super();
		this.repo = repo;
		this.webClient = webClient;
	}

	@Override
	public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo) {
		System.out.println("DEBUG = IDCLIENTE= " + idCliente);
		System.out.println("DEBUG = IDSERVICO= " + idServico);

		webClient.get()
			     .uri("http://localhost:8080/"+idCliente+"?servico="+idServico)
			     .retrieve()
			     .bodyToMono(String.class)
			     .doOnNext((resposta)->{
			    	 System.out.println("DEBUG - Solicitacao atendida pela API Externa");
			    	 DocFiscal doc = new DocFiscal();
			    	 doc.setProtocolo(protocolo);
			    	 doc.setDocumento(resposta);
			    	 repo.save(doc);
			     })
			     .doOnError(erro -> {
			    	 System.out.println("ERRO - " + erro);
			     })
			     .subscribe();
	}

	@Override
	public DocFiscal consultarPorProtocolo(String protocolo) {
		return repo.findByProtocolo(protocolo).orElse(null);
	}
}